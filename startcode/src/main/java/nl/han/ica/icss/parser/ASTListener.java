package nl.han.ica.icss.parser;

import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.gen.ICSSBaseListener;
import nl.han.ica.gen.ICSSParser;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.*;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {

    //Accumulator attributes:
    private AST ast;

    //Use this to keep track of the parent nodes when recursively traversing the ast
    private IHANStack<ASTNode> currentContainer;

    public ASTListener() {
        ast = new AST();
        currentContainer = new HANStack<>();
    }

    public AST getAST() {
        return ast;
    }

    @Override
    public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
        ASTNode stylesheet = new Stylesheet();
        currentContainer.push(stylesheet);
    }

    @Override
    public void exitStylesheet(ICSSParser.StylesheetContext ctx) {
        ast.setRoot((Stylesheet) currentContainer.pop());
    }

    // --- Level 0: ---

    @Override
    public void enterStyleRule(ICSSParser.StyleRuleContext ctx) {
        ASTNode stylerule = new Stylerule();
        currentContainer.push(stylerule);
    }

    @Override
    public void exitStyleRule(ICSSParser.StyleRuleContext ctx) {
        ASTNode stylerule = currentContainer.pop();
        currentContainer.peek().addChild(stylerule);
    }

    @Override
    public void enterTagselector(ICSSParser.TagselectorContext ctx) {
        ASTNode tagSelector = new TagSelector(ctx.getText());
        currentContainer.push(tagSelector);
    }

    @Override
    public void exitTagselector(ICSSParser.TagselectorContext ctx) {
        ASTNode tagSelector = currentContainer.pop();
        currentContainer.peek().addChild(tagSelector);
    }

    @Override
    public void enterClassselector(ICSSParser.ClassselectorContext ctx) {
        ASTNode classesSelector = new ClassSelector(ctx.getText());
        currentContainer.push(classesSelector);
    }

    @Override
    public void exitClassselector(ICSSParser.ClassselectorContext ctx) {
        ASTNode classesSelector = currentContainer.pop();
        currentContainer.peek().addChild(classesSelector);
    }

    @Override
    public void enterIdselector(ICSSParser.IdselectorContext ctx) {
        ASTNode id = new IdSelector(ctx.getText());
        currentContainer.push(id);
    }

    @Override
    public void exitIdselector(ICSSParser.IdselectorContext ctx) {
        ASTNode id = currentContainer.pop();
        currentContainer.peek().addChild(id);
    }

    @Override
    public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
        ASTNode declaration = new Declaration();
        currentContainer.push(declaration);
    }

    @Override
    public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
        ASTNode declaration = currentContainer.pop();
        currentContainer.peek().addChild(declaration);
    }

    @Override
    public void enterPropertyname(ICSSParser.PropertynameContext ctx) {
        ASTNode propertyName = new PropertyName(ctx.getText());
        currentContainer.push(propertyName);
    }

    @Override
    public void exitPropertyname(ICSSParser.PropertynameContext ctx) {
        ASTNode propertyName = currentContainer.pop();
        currentContainer.peek().addChild(propertyName);
    }

    @Override
    public void enterBoolLiteral(ICSSParser.BoolLiteralContext ctx) {
        ASTNode boolLiteral = new BoolLiteral(ctx.getText());
        currentContainer.push(boolLiteral);
    }

    @Override
    public void exitBoolLiteral(ICSSParser.BoolLiteralContext ctx) {
        ASTNode boolLiteral = currentContainer.pop();
        currentContainer.peek().addChild(boolLiteral);
    }

    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        ASTNode colorLiteral = new ColorLiteral(ctx.getText());
        currentContainer.push(colorLiteral);
    }

    @Override
    public void exitColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        ASTNode colorLiteral = currentContainer.pop();
        currentContainer.peek().addChild(colorLiteral);
    }

    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        ASTNode percentageLiteral = new PercentageLiteral(ctx.getText());
        currentContainer.push(percentageLiteral);
    }

    @Override
    public void exitPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        ASTNode percentageLiteral = currentContainer.pop();
        currentContainer.peek().addChild(percentageLiteral);
    }

    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        ASTNode pixelLiteral = new PixelLiteral(ctx.getText());
        currentContainer.push(pixelLiteral);
    }

    @Override
    public void exitPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        ASTNode pixelLiteral = currentContainer.pop();
        currentContainer.peek().addChild(pixelLiteral);
    }

    @Override
    public void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        ASTNode scalarLiteral = new ScalarLiteral(ctx.getText());
        currentContainer.push(scalarLiteral);
    }

    @Override
    public void exitScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        ASTNode scalarLiteral = currentContainer.pop();
        currentContainer.peek().addChild(scalarLiteral);
    }

    // --- Level 1: ---

    @Override
    public void enterVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        ASTNode variableAssignment = new VariableAssignment();
        currentContainer.push(variableAssignment);
    }

    @Override
    public void exitVariableAssignment(ICSSParser.VariableAssignmentContext ctx) {
        ASTNode variableAssignment = currentContainer.pop();
        currentContainer.peek().addChild(variableAssignment);
    }

    @Override
    public void enterVariableReference(ICSSParser.VariableReferenceContext ctx) {
        ASTNode variableReference = new VariableReference(ctx.getText());
        currentContainer.push(variableReference);
    }

    @Override
    public void exitVariableReference(ICSSParser.VariableReferenceContext ctx) {
        ASTNode variableReference = currentContainer.pop();
        currentContainer.peek().addChild(variableReference);
    }

    // --- Level 02: ---

    @Override
    public void enterExpression(ICSSParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            Operation operation;
            switch (ctx.getChild(1).getText()) {
                case "*":
                    operation = new MultiplyOperation();
                    break;
                case "-":
                    operation = new SubtractOperation();
                    break;
                case "+":
                    operation = new AddOperation();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ctx.getChild(1).getText());
            }
            currentContainer.push(operation);
        }
    }

    @Override
    public void exitExpression(ICSSParser.ExpressionContext ctx) {
        if (expressionHasTerminalNode(ctx)) {
            ASTNode operation = currentContainer.pop();
            currentContainer.peek().addChild(operation);
        }
    }

    private boolean expressionHasTerminalNode(ICSSParser.ExpressionContext ctx) {
        return ctx.addoperation() != null || ctx.substractoperation() != null || ctx.multiplyoperation() != null;
    }

    // --- Level 3: ---

    @Override
    public void enterIfClause(ICSSParser.IfClauseContext ctx) {
        ASTNode ifClause = new IfClause();
        currentContainer.push(ifClause);
    }

    @Override
    public void exitIfClause(ICSSParser.IfClauseContext ctx) {
        ASTNode ifClause = currentContainer.pop();
        currentContainer.peek().addChild(ifClause);
    }

    // --- Booleaanse expressies: ---

    @Override
    public void enterEquals(ICSSParser.EqualsContext ctx) {
        ASTNode compareOperation = new CompareOperation();
        currentContainer.push(compareOperation);
    }

    @Override
    public void exitEquals(ICSSParser.EqualsContext ctx) {
        ASTNode equals = currentContainer.pop();
        currentContainer.peek().addChild(equals);
    }

    @Override
    public void enterComparison(ICSSParser.ComparisonContext ctx) {
        ASTNode relationalOperation = new RelationalOperation();
        currentContainer.push(relationalOperation);
    }

    // --- Not operation: ---

    @Override
    public void enterNotOperator(ICSSParser.NotOperatorContext ctx) {
        ASTNode notSymbol = new NotSymbol(ctx.getText());
        currentContainer.push(notSymbol);
    }

    @Override
    public void exitNotOperator(ICSSParser.NotOperatorContext ctx) {
        ASTNode notSymbol = currentContainer.pop();
        currentContainer.peek().addChild(notSymbol);
    }

    @Override
    public void enterNotExpression(ICSSParser.NotExpressionContext ctx) {
        ASTNode notOperation = new NotOperation();
        currentContainer.push(notOperation);
    }

    @Override
    public void exitNotExpression(ICSSParser.NotExpressionContext ctx) {
        ASTNode notOperation = currentContainer.pop();
        currentContainer.peek().addChild(notOperation);
    }

    // ----

    @Override
    public void exitComparison(ICSSParser.ComparisonContext ctx) {
        ASTNode relationalOperation = currentContainer.pop();
        currentContainer.peek().addChild(relationalOperation);
    }

    @Override
    public void enterCompareOperator(ICSSParser.CompareOperatorContext ctx) {
        ASTNode relationalSymbol = new RelationalSymbol(ctx.getText());
        currentContainer.push(relationalSymbol);
    }

    @Override
    public void exitCompareOperator(ICSSParser.CompareOperatorContext ctx) {
        ASTNode relationalSymbol = currentContainer.pop();
        currentContainer.peek().addChild(relationalSymbol);
    }

    @Override
    public void enterElseClause(ICSSParser.ElseClauseContext ctx) {
        ASTNode elseClause = new ElseClause();
        currentContainer.push(elseClause);
    }

    @Override
    public void exitElseClause(ICSSParser.ElseClauseContext ctx) {
        ASTNode elseClause = currentContainer.pop();
        currentContainer.peek().addChild(elseClause);
    }
}