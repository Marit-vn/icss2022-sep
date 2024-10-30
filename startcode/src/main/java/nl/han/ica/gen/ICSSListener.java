package nl.han.ica.gen;// Generated from C:/Users/marit/OneDrive - HAN/ICT-Year 3/APP/ICSSCompiler/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void enterStyleRule(ICSSParser.StyleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void exitStyleRule(ICSSParser.StyleRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#ruleBody}.
	 * @param ctx the parse tree
	 */
	void enterRuleBody(ICSSParser.RuleBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#ruleBody}.
	 * @param ctx the parse tree
	 */
	void exitRuleBody(ICSSParser.RuleBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 */
	void enterClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 */
	void exitClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 */
	void enterIdselector(ICSSParser.IdselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 */
	void exitIdselector(ICSSParser.IdselectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 */
	void enterTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 */
	void exitTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#propertyname}.
	 * @param ctx the parse tree
	 */
	void enterPropertyname(ICSSParser.PropertynameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#propertyname}.
	 * @param ctx the parse tree
	 */
	void exitPropertyname(ICSSParser.PropertynameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(ICSSParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(ICSSParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#colorLiteral}.
	 * @param ctx the parse tree
	 */
	void enterColorLiteral(ICSSParser.ColorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#colorLiteral}.
	 * @param ctx the parse tree
	 */
	void exitColorLiteral(ICSSParser.ColorLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#percentageLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#percentageLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPercentageLiteral(ICSSParser.PercentageLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#pixelLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#pixelLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPixelLiteral(ICSSParser.PixelLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#scalarLiteral}.
	 * @param ctx the parse tree
	 */
	void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#scalarLiteral}.
	 * @param ctx the parse tree
	 */
	void exitScalarLiteral(ICSSParser.ScalarLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#expressiontype}.
	 * @param ctx the parse tree
	 */
	void enterExpressiontype(ICSSParser.ExpressiontypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#expressiontype}.
	 * @param ctx the parse tree
	 */
	void exitExpressiontype(ICSSParser.ExpressiontypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#comparable}.
	 * @param ctx the parse tree
	 */
	void enterComparable(ICSSParser.ComparableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#comparable}.
	 * @param ctx the parse tree
	 */
	void exitComparable(ICSSParser.ComparableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(ICSSParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#variableAssignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(ICSSParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void enterVariableReference(ICSSParser.VariableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#variableReference}.
	 * @param ctx the parse tree
	 */
	void exitVariableReference(ICSSParser.VariableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#multiplyable}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyable(ICSSParser.MultiplyableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#multiplyable}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyable(ICSSParser.MultiplyableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#addoperation}.
	 * @param ctx the parse tree
	 */
	void enterAddoperation(ICSSParser.AddoperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#addoperation}.
	 * @param ctx the parse tree
	 */
	void exitAddoperation(ICSSParser.AddoperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#multiplyoperation}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyoperation(ICSSParser.MultiplyoperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#multiplyoperation}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyoperation(ICSSParser.MultiplyoperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#substractoperation}.
	 * @param ctx the parse tree
	 */
	void enterSubstractoperation(ICSSParser.SubstractoperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#substractoperation}.
	 * @param ctx the parse tree
	 */
	void exitSubstractoperation(ICSSParser.SubstractoperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#ifClause}.
	 * @param ctx the parse tree
	 */
	void enterIfClause(ICSSParser.IfClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#ifClause}.
	 * @param ctx the parse tree
	 */
	void exitIfClause(ICSSParser.IfClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(ICSSParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(ICSSParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#compareOperator}.
	 * @param ctx the parse tree
	 */
	void enterCompareOperator(ICSSParser.CompareOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#compareOperator}.
	 * @param ctx the parse tree
	 */
	void exitCompareOperator(ICSSParser.CompareOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#equalsOperator}.
	 * @param ctx the parse tree
	 */
	void enterEqualsOperator(ICSSParser.EqualsOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#equalsOperator}.
	 * @param ctx the parse tree
	 */
	void exitEqualsOperator(ICSSParser.EqualsOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#notOperator}.
	 * @param ctx the parse tree
	 */
	void enterNotOperator(ICSSParser.NotOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#notOperator}.
	 * @param ctx the parse tree
	 */
	void exitNotOperator(ICSSParser.NotOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ICSSParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ICSSParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#classic}.
	 * @param ctx the parse tree
	 */
	void enterClassic(ICSSParser.ClassicContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#classic}.
	 * @param ctx the parse tree
	 */
	void exitClassic(ICSSParser.ClassicContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ICSSParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ICSSParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#equals}.
	 * @param ctx the parse tree
	 */
	void enterEquals(ICSSParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#equals}.
	 * @param ctx the parse tree
	 */
	void exitEquals(ICSSParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ICSSParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ICSSParser.ComparisonContext ctx);
}