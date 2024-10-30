package nl.han.ica.icss.ast;

import java.util.ArrayList;

public class NotOperation extends Expression {

    public Expression rhs;
    public NotSymbol symbol;

    @Override
    public String getNodeLabel() {
        return "Not operation";
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        if (rhs != null)
            children.add(rhs);
        if (symbol != null)
            children.add(symbol);
        return children;
    }

    @Override
    public ASTNode addChild(ASTNode child) {
        if (child instanceof NotSymbol) {
            if (symbol == null) {
                symbol = (NotSymbol) child;
                System.out.println(child);
            }
        } else {
            if (rhs == null) {
                rhs = (Expression) child;
                System.out.println(child);
            }
        }
        return this;
    }
}
