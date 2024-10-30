package nl.han.ica.icss.ast.operations;

import nl.han.ica.icss.ast.ASTNode;
import nl.han.ica.icss.ast.Expression;
import nl.han.ica.icss.ast.Operation;
import nl.han.ica.icss.ast.RelationalSymbol;

import java.util.ArrayList;

public class RelationalOperation extends Operation {
    public RelationalSymbol symbol;

    @Override
    public String getNodeLabel() {
        return "Relational";
    }

    @Override
    public ArrayList<ASTNode> getChildren() {
        ArrayList<ASTNode> children = new ArrayList<>();
        if(lhs != null)
            children.add(lhs);
        if(rhs != null)
            children.add(rhs);
        if(symbol != null)
            children.add(symbol);
        return children;
    }

    @Override
    public ASTNode addChild(ASTNode child) {
        if (child instanceof RelationalSymbol) {
            if(symbol == null) {
                symbol = (RelationalSymbol) child;
            }
        } else {
            if(lhs == null) {
                lhs = (Expression) child;
            } else if(rhs == null) {
                rhs = (Expression) child;
            }
        }


        return this;
    }
}
