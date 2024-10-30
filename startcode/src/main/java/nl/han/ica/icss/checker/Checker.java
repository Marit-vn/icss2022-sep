package nl.han.ica.icss.checker;

import nl.han.ica.datastructures.HANLinkedList;
import nl.han.ica.datastructures.IHANLinkedList;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.*;
import nl.han.ica.icss.ast.types.ExpressionType;

import java.util.HashMap;

public class Checker {

    private IHANLinkedList<HashMap<String, ExpressionType>> variableTypes;

    public void check(AST ast) {
        variableTypes = new HANLinkedList<>();
        variableTypes.addFirst(new HashMap<>());
        checkNode(ast.root);
    }

    public void checkNode(ASTNode node) {
        boolean isNewScope = false;

        // --- CH06: ---
        if (node instanceof Stylerule || node instanceof IfClause || node instanceof ElseClause) {
            variableTypes.addFirst(new HashMap<>()); // Push
            isNewScope = true;
        }

        if (node instanceof VariableAssignment) {
            checkVariableAssignment((VariableAssignment) node);
        } else if (node instanceof Declaration) {
            checkDeclaration((Declaration) node);
        } else if (node instanceof Operation) {
            checkOperation((Operation) node);
        } else if (node instanceof IfClause) {
            checkIfClause((IfClause) node);
        }

        // Recursive doorlopen van alle child nodes
        for (ASTNode child : node.getChildren()) {
            checkNode(child);
        }

        // --- CH06: ---
        if (isNewScope) {
            variableTypes.removeFirst();
        }
    }

    // --- Booleaanse expressies: ---
    private void checkIfClause(IfClause node) {
        Expression condition = node.conditionalExpression;

        if (condition instanceof VariableReference) {
            // Controleren of de variable binnen de scope bestaat en of het een boolean is.
            String variableName = ((VariableReference) condition).name;
            ExpressionType varType = getVariableType(variableName);
            if (varType != ExpressionType.BOOL) {
                node.setError("De variable " + variableName + " in de If condition moet een boolean zijn die gedefineerd is binnen de scope.");
            }
        } else if (condition instanceof CompareOperation | condition instanceof RelationalOperation) {
            checkBooleanOperation((Operation) condition);
        } else if (condition instanceof NotOperation){
            checkNotOperation((NotOperation) condition);
        } else if (!(condition instanceof BoolLiteral))
            node.setError("Geen geldige input voor de if condition. Moet een boolean of booleaanse expressie zijn: ==, <, >, !boolean");
    }

    private void checkNotOperation(NotOperation condition) {
        ExpressionType rightType = getExpressionType(condition.rhs);

        if(rightType != ExpressionType.BOOL){
            condition.setError("Rechterzijde van de ! moet een boolean zijn");
        }
    }

    private void checkBooleanOperation(Operation condition) {
        ExpressionType leftType = getExpressionType(condition.lhs);
        ExpressionType rightType = getExpressionType(condition.rhs);

        // Beide kanten moeten van hetzelfde type zijn om te vergelijken
        if (leftType != rightType) {
            condition.setError("Beide kanten van de booleaanse expressie moeten van hetzelfde type zijn");
        }
    }

    // Controlren of the variableReference bestaat in een ifClause
    private ExpressionType getVariableType(String variableName) {
        for (int i = 0; i < variableTypes.getSize(); i++) {
            HashMap<String, ExpressionType> scope = variableTypes.get(i);
            if (scope.containsKey(variableName)) {
                return scope.get(variableName);
            }
        }
        return ExpressionType.UNDEFINED;
    }

    private void checkVariableAssignment(VariableAssignment variableAssignment) {
        // Haal variablenaam op
        String variableName = variableAssignment.name.name;
        ExpressionType valueType = getExpressionType(variableAssignment.expression); // --- CH01 & CH06: ---

        // Assign aan scope
        variableTypes.getFirst().put(variableName, valueType);
    }

    // --- CH04: ---
    private void checkDeclaration(Declaration node) {
        String variableName = node.property.name;
        ExpressionType expressionType = getExpressionType(node.expression);

        switch (variableName) {
            case "color":
            case "background-color":
                if (expressionType != ExpressionType.COLOR) {
                    node.setError("Variabele: " + variableName + " moet een kleurencode mee krijgen.");
                }
                break;
            case "width":
            case "height":
                if (expressionType != ExpressionType.PERCENTAGE && expressionType != ExpressionType.PIXEL && !isCalculation(node.expression)) {
                    node.setError("Variabele: " + variableName + " moet het type percentage of pixel krijgen.");
                }
                if (isCalculation(node.expression)) {
                    checkExpressiontypeOperation((Operation) node.expression);
                }
                break;
        }
    }

    private boolean isCalculation(Expression expression) {
        return (expression instanceof AddOperation ||
                expression instanceof MultiplyOperation ||
                expression instanceof SubtractOperation);
    }

    // --- CH03: ---
    private void checkOperation(Operation node) {
        ExpressionType leftType = getExpressionType(node.lhs);
        ExpressionType rightType = getExpressionType(node.rhs);

        if (leftType == ExpressionType.COLOR || rightType == ExpressionType.COLOR) {
            node.setError("Operatie mag geen kleuren bevatten");
        }
    }

    // --- CH02: ---
    private ExpressionType checkExpressiontypeOperation(Operation operation) {
        ExpressionType leftType = (operation.lhs instanceof Operation)
                ? checkExpressiontypeOperation((Operation) operation.lhs) // Conditie true
                : getExpressionType(operation.lhs); // Conditie false

        ExpressionType rightType = (operation.rhs instanceof Operation)
                ? checkExpressiontypeOperation((Operation) operation.rhs)
                : getExpressionType(operation.rhs);


        if (operation instanceof AddOperation || operation instanceof SubtractOperation) {
            // Plus en min mag alleen met dezelfde types
            if (leftType == rightType) {
                return leftType;  // Type is gelijk dus links of rechts maakt niet uit
            } else {
                operation.setError("Operatie met + of - moet operanden van hetzelfde type hebben.");
                return ExpressionType.UNDEFINED;
            }
        } else if (operation instanceof MultiplyOperation) {
            // Keersommen moeten minimaal 1 scalar bevatten
            if (leftType == ExpressionType.SCALAR || rightType == ExpressionType.SCALAR) {
                // Return de kant van de px of %
                return (leftType == ExpressionType.SCALAR) ? rightType : leftType;
            } else {
                operation.setError("Vermenigvuldigen vereist ten minste één scalaire operand.");
                return ExpressionType.UNDEFINED;
            }
        }

        if (leftType != ExpressionType.PERCENTAGE && leftType != ExpressionType.PIXEL) {
            operation.setError("Operation: " + operation + " moet het type percentage of pixel krijgen.");
        } else if (rightType != ExpressionType.PERCENTAGE && leftType != ExpressionType.PIXEL) {
            operation.setError("Operation: " + operation + "moet het type percentage of pixel krijgen");
        }

        operation.setError("Operatie moet een geldige operator bevatten.");
        return ExpressionType.UNDEFINED;
    }

    private ExpressionType getExpressionType(Expression expression) {
        if (expression instanceof Literal) { // TODO controleren of dit makkelijker kan
            if (expression instanceof PixelLiteral) {
                return ExpressionType.PIXEL;
            } else if (expression instanceof PercentageLiteral) {
                return ExpressionType.PERCENTAGE;
            } else if (expression instanceof ColorLiteral) {
                return ExpressionType.COLOR;
            } else if (expression instanceof BoolLiteral) {
                return ExpressionType.BOOL;
            } else if (expression instanceof ScalarLiteral) {
                return ExpressionType.SCALAR;
            }
        } else if (expression instanceof VariableReference) {
            // --- CH01 & CH06: ---
            String variableName = ((VariableReference) expression).name;

            // Handmatig itereren door de linklist
            for (int i = 0; i < variableTypes.getSize(); i++) {
                HashMap<String, ExpressionType> scope = variableTypes.get(i);
                if (scope.containsKey(variableName)) {
                    return scope.get(variableName);
                }
            }
            expression.setError("Variable " + variableName + " is niet gedefineerd binnen de scope.");
        }
        return ExpressionType.UNDEFINED;
    }
}