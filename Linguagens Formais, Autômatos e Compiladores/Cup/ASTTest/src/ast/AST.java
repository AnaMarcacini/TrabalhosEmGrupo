package ast;

public class AST {

    // Árvore AST pai
    private AST parentAST;
    // Árvore AST esquerda
    private final AST leftAST;
    // Árvore AST direita
    private final AST rightAST;

    public static AST create(AST leftAST, AST rightAST) {
        AST ast = new AST(leftAST, rightAST);
        if (leftAST != null) {
            leftAST.setParentAST(ast);
        }
        if (rightAST != null) {
            rightAST.setParentAST(ast);
        }
        return ast;
    }

    protected AST(AST leftAST, AST rightAST) {
        this.leftAST = leftAST;
        this.rightAST = rightAST;
        this.parentAST = null;
    }

    public AST getLeftAST() {
        return this.leftAST;
    }

    public AST getRightAST() {
        return this.rightAST;
    }

    public void setParentAST(AST ast) {
        this.parentAST = ast;
    }

    public AST getParentAST() {
        return this.parentAST;
    }

    @Override
    public String toString() {
        return "AST Node";
    }

}
