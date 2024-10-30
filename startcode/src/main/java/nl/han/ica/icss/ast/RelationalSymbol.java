package nl.han.ica.icss.ast;

public class RelationalSymbol extends ASTNode {
    public String symbol;

    public RelationalSymbol() {super();}

    public RelationalSymbol(String symbol) {
        super();
        this.symbol = symbol;
    }

    @Override
    public String getNodeLabel() {
        return "RelationalSymbol (" + symbol + ")";
    }
}
