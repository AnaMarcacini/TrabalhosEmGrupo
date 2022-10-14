package ast;

public class Operator extends AST {

    // Símbolo do operador
    // sym é a interface gerada pelo CUP
    private final int operator;

    public static AST create(int op, AST leftAST, AST rightAST) {
        AST ast = new Operator(op, leftAST, rightAST);
        if (leftAST != null) {
            leftAST.setParentAST(ast);
        }
        if (rightAST != null) {
            rightAST.setParentAST(ast);
        }
        return ast;
    }

    protected Operator(int op, AST leftAST, AST rightAST) {
        // Inicializa a parte básica do AST
        super(leftAST, rightAST);
        this.operator = op;
    }

    public int getOperatorSymbol() {
        return this.operator;
    }

    @Override
    public String toString() {
        return "Operator: " + operator;
    }

}
