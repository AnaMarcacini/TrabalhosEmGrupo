package compiler;

import compiler.parser.Parser;//chama a classe parser
import compiler.scanner.Scanner;// chama a classe scanner

public class Main {

    public static void main(String[] args) {
        java.io.Reader reader = null;
        if (args.length == 0) {
            reader = new java.io.InputStreamReader(System.in);//o terminal vai conter o texto teste
        } else {
            if (args.length != 1) {
                System.out.println("Uso : java -jar drp <nome do arquivo>");// mais de um parametro no comando ---- apenas um parametro chamado nomeDoArquivo
            } else {
                try {
                    java.io.FileInputStream stream = new java.io.FileInputStream(args[0]);
                    reader = new java.io.InputStreamReader(stream);//ler e abrir o arquivo
                } catch (java.io.FileNotFoundException e) {
                    System.out.println("Arquivo não encontrado : \"" + args[0] + "\"");
                } catch (Exception e) {
                    System.out.println("Exceção de arquivo: " + e);
                }
            }
        }
        try {
            Scanner scanner = new Scanner(reader);/// scaner gerado pelo jflex -- quando executar o jflex o erro some
            Parser parser = new Parser(scanner);// classe parser 
            // Executa a análise
            parser.parse();
        } catch (Exception e) {
            System.out.println("Exceção de análise: " + e);
        }

    }
}
