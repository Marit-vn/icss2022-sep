package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.BoolLiteral;
import nl.han.ica.icss.ast.literals.PercentageLiteral;
import nl.han.ica.icss.ast.literals.PixelLiteral;
import nl.han.ica.icss.ast.literals.ScalarLiteral;
import nl.han.ica.icss.ast.operations.*;

import java.util.*;

public class Evaluator implements Transform {

    private final Stack<HashMap<String, Literal>> variableValues;

    public Evaluator() {
        variableValues = new Stack<>();
    }

    @Override
    public void apply(AST ast) {
        Stylesheet stylesheet = ast.root;
        variableValues.push(new HashMap<>());
        List<ASTNode> toRemove = new ArrayList<>();

        for (ASTNode child : stylesheet.getChildren()) {
            if (child instanceof VariableAssignment) {
                transformVariableAssignment((VariableAssignment) child);
                toRemove.add(child);
            } else if (child instanceof Stylerule) {
                transformRuleBody((Stylerule) child);
            }
        }

        toRemove.forEach(stylesheet::removeChild);
        variableValues.pop(); // Pop de globale scope
    }

    private void transformRuleBody(Stylerule stylerule) {
        ArrayList<ASTNode> transformedBody = new ArrayList<>();
        variableValues.push(new HashMap<>()); // nieuwe scope

        for (ASTNode child : stylerule.body) {
            transformChildNode(child, transformedBody);
        }

        stylerule.body = transformedBody; // Vervang de body
        variableValues.pop();
    }

    private void transformIfClause(IfClause ifClause, List<ASTNode> parentBody) {
        ifClause.conditionalExpression = transformExpression(ifClause.conditionalExpression);
        boolean condition = ((BoolLiteral) ifClause.conditionalExpression).value;

        List<ASTNode> targetBody = condition ? ifClause.body : (ifClause.elseClause != null ? ifClause.elseClause.body : Collections.emptyList());

        for (ASTNode child : targetBody) {
            transformChildNode(child, parentBody);
        }
    }

    private void transformChildNode(ASTNode child, List<ASTNode> parentBody) {
        if (child instanceof VariableAssignment) {
            transformVariableAssignment((VariableAssignment) child);
        } else if (child instanceof Declaration) {
            transformDeclaration((Declaration) child);
            parentBody.add(child);
        } else if (child instanceof IfClause) {
            transformIfClause((IfClause) child, parentBody);
        }
    }

    private void transformDeclaration(Declaration declaration) {
        declaration.expression = transformExpression(declaration.expression);
    }

    private void transformVariableAssignment(VariableAssignment variableAssignment) {
        variableAssignment.expression = transformExpression(variableAssignment.expression);
        variableValues.peek().put(variableAssignment.name.name, (Literal) variableAssignment.expression);
    }

    private Literal transformExpression(Expression expression) {
        if (expression instanceof RelationalOperation) {
            return transformRelationalOperation((RelationalOperation) expression);
        } else if (expression instanceof CompareOperation) {
            return transformCompareOperation((CompareOperation) expression);
        } else if (expression instanceof NotOperation) {
            return transformNotOperation((NotOperation) expression);
        } else if (expression instanceof Operation) {
            return transformOperation((Operation) expression);
        } else if (expression instanceof VariableReference) {
            return resolveVariableReference((VariableReference) expression);
        }
        return (Literal) expression;
    }

    private Literal transformNotOperation(NotOperation expression) {
        Literal operandLiteral = transformOperand(expression.rhs);

        boolean operandValue = ((BoolLiteral) operandLiteral).value;
        return new BoolLiteral(!operandValue);
    }


    private Literal transformRelationalOperation(RelationalOperation relationalOperation) {
        Literal left = transformOperand(relationalOperation.lhs);
        Literal right = transformOperand(relationalOperation.rhs);

        int leftValue = getLiteralValue(left);
        int rightValue = getLiteralValue(right);

        String relationalSymbol = relationalOperation.symbol.symbol;

        switch (relationalSymbol) {
            case "<":
                return new BoolLiteral(leftValue < rightValue);
            case ">":
                return new BoolLiteral(leftValue > rightValue);
            default:
                return null;
        }
    }

    private Literal transformCompareOperation(CompareOperation compareOperation) {
        Literal left = transformOperand(compareOperation.lhs);
        Literal right = transformOperand(compareOperation.rhs);

        int leftValue = getLiteralValue(left);
        int rightValue = getLiteralValue(right);

        return new BoolLiteral(leftValue == rightValue);
    }


    private Literal transformOperand(Expression operand) {
        if (operand instanceof Operation) {
            return transformOperation((Operation) operand);
        } else if (operand instanceof VariableReference) {
            return resolveVariableReference((VariableReference) operand);
        }
        return (Literal) operand;
    }


    private Literal resolveVariableReference(VariableReference reference) {
        for (int i = variableValues.size() - 1; i >= 0; i--) {
            Literal literal = variableValues.get(i).get(reference.name);
            if (literal != null) return literal;
        }
        return null;
    }

    private Literal transformOperation(Operation operation) {
        Literal left = transformOperand(operation.lhs);
        Literal right = transformOperand(operation.rhs);

        int leftValue = getLiteralValue(left);
        int rightValue = getLiteralValue(right);

        if (operation instanceof AddOperation) {
            return createNewLiteral(left, right, leftValue + rightValue);
        } else if (operation instanceof SubtractOperation) {
            return createNewLiteral(left, right, leftValue - rightValue);
        } else if (operation instanceof MultiplyOperation) {
            return createNewLiteral(left instanceof ScalarLiteral ? right : left, right instanceof ScalarLiteral ? right : left, leftValue * rightValue);
        }
        return null;
    }


    private int getLiteralValue(Literal literal) {
        if (literal instanceof PixelLiteral) {
            return ((PixelLiteral) literal).value;
        } else if (literal instanceof ScalarLiteral) {
            return ((ScalarLiteral) literal).value;
        } else if (literal instanceof PercentageLiteral) {
            return ((PercentageLiteral) literal).value;
        } else if (literal instanceof BoolLiteral) {
            return ((BoolLiteral) literal).value ? 1 : 0; // Converteren naar een int zodat het een literal is
        }
        return 0;
    }

    private Literal createNewLiteral(Literal left, Literal right, int value) {
        if (right instanceof PixelLiteral || left instanceof PixelLiteral) {
            return new PixelLiteral(value);
        } else if (right instanceof PercentageLiteral || left instanceof PercentageLiteral) {
            return new PercentageLiteral(value);
        } else if (right instanceof ScalarLiteral || left instanceof ScalarLiteral) {
            return new ScalarLiteral(value);
        }
        return null;
    }
}