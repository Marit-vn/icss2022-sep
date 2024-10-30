package nl.han.ica.icss.ast;


public class NotSymbol extends ASTNode {

    public String symbol;

    public NotSymbol() {
        super();
    }

    public NotSymbol(String symbol) {
        super();
        this.symbol = symbol;
    }


    @Override
    public String getNodeLabel() {
        return "Notsymbol (" + symbol + ")";
    }
}
