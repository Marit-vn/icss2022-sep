package nl.han.ica.gen;// Generated from C:/Users/marit/OneDrive - HAN/ICT-Year 3/APP/ICSSCompiler/startcode/src/main/antlr4/nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ICSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ICSSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#styleRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleRule(ICSSParser.StyleRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#ruleBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleBody(ICSSParser.RuleBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdselector(ICSSParser.IdselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#propertyname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyname(ICSSParser.PropertynameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(ICSSParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#colorLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorLiteral(ICSSParser.ColorLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#percentageLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentageLiteral(ICSSParser.PercentageLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#pixelLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPixelLiteral(ICSSParser.PixelLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#scalarLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarLiteral(ICSSParser.ScalarLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#expressiontype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressiontype(ICSSParser.ExpressiontypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#comparable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparable(ICSSParser.ComparableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variableAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignment(ICSSParser.VariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(ICSSParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#multiplyable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyable(ICSSParser.MultiplyableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#addoperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddoperation(ICSSParser.AddoperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#multiplyoperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyoperation(ICSSParser.MultiplyoperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#substractoperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstractoperation(ICSSParser.SubstractoperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#ifClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfClause(ICSSParser.IfClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(ICSSParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#compareOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOperator(ICSSParser.CompareOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#equalsOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsOperator(ICSSParser.EqualsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#notOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotOperator(ICSSParser.NotOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ICSSParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#classic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassic(ICSSParser.ClassicContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ICSSParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#equals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(ICSSParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ICSSParser.ComparisonContext ctx);
}