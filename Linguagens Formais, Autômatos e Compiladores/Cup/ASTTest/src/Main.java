import ast.AST;
import ast.Operator;
import ast.Number;
import ast.Identifier;

public class Main {

    // Percorrimento em pós-ordem
    public static void printAST(AST ast) {
        if (ast != null) {
            printAST(ast.getLeftAST());
            printAST(ast.getRightAST());
            System.out.println(ast);
        }
    }

    public static void main(String[] args) {
        // Exemplo: árvore de x = y + 2;
        // Por exemplo, o número de "=" poderia ser 4
        // e o número de "+" poderia ser 7
        AST op = Operator.create(4,
                Identifier.create("x"),
                Operator.create(7,
                        Identifier.create("y"),
                        Number.create(2.0)));
        printAST(op);
    }
}
