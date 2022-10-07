/*
    Para executar o interpretador na linha de comando (fora do IDE):
        java -jar simple_expr.jar
 */
package parser;

public class Main {

    public static void main(String[] args) {
        java.io.Reader reader = null;
        if (args.length == 0) {
            reader = new java.io.InputStreamReader(System.in);
        } else {
            if (args.length != 1) {
                System.out.println("Usage : java -jar drp <filename>");
            } else {
                try {
                    java.io.FileInputStream stream = new java.io.FileInputStream(args[0]);
                    reader = new java.io.InputStreamReader(stream);
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("File not found : \"" + args[0] + "\"");
                } catch (Exception e) {
                    System.out.println("Not expected exception:" + e);
                }
            }
        }
        try {
            // Cria um scanner (gerado pelo JFlex)
            Scanner scanner = new Scanner(reader);
            // Cria um parser (gerado pelo CUP)
            Parser parser = new Parser(scanner);
            // Executa a análise
            parser.parse();
        } catch (Exception e) {
            System.out.println("Exceção detectada:" + e);
        }
    }
}
