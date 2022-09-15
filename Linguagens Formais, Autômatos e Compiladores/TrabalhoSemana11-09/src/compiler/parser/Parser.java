package compiler.parser;

import compiler.scanner.Scanner;
import compiler.scanner.Tag;
import compiler.scanner.Token;

public class Parser {
    // referência a um scanner criado separadamente pelo JFlex
    private final Scanner scanner;
    // token atualmente obtido pelo Scanner
    private Token token;

    // classe do analisador sintático
    public Parser(Scanner scanner) throws Exception {
        // se não tem um scanner, então não é possível continuar
        if (scanner == null) {
            throw new Exception("Scanner não definido! Não foi possível criar o Parser!");
        }
        // armazena a referência
        this.scanner = scanner;
        // e obtém o primeiro token
        token = scanner.yylex();
    }

    // função para tratar erros
    private void error(Tag tag) throws Exception {
        throw new Exception("Erro durante a análise sintática: esperava marca com tag " + tag +
                " mas recebi marca com tag " + token.tag + "\n" +
                "Linha: " + token.line + " e Coluna: " + token.column);
    }

    private void error(Tag[] tags) throws Exception {
        String msg = "Erro durante a análise sintática: esperava marcas com tags [ ";
        for (Tag t : tags) {
            msg += t;
            msg += ' ';
        }
        msg += ']';
        msg += " mas recebi marca com tag " + token.tag + "\n" +
                "Linha: " + token.line + " e Coluna: " + token.column;
        throw new Exception(msg);
    }

    // função que verifica a marca atul e avança mna entrada
    private void accept(Tag tag) throws Exception {
        System.out.println("tag:"+ tag);
        // Se o token atual é o que se está esperando
        if (token.tag == tag) {
            // avança um token na entrada
            token = scanner.yylex();
        } else {
            // gera uma exceção
            error(tag);
        }
    }
/* ANTIGO
    // função que inicia a análise sintática descendente
    // recursiva
    public void parse() throws Exception {
        // REGRA: goal = expr;
        expr();
        // se, depois de expr() o token for EOF, tudo deu certo!
        if (token.tag == Tag.EOF) {
            System.out.println("Análise sintática terminada com sucesso!");
        } else {
            error(Tag.EOF);
        }
    }
 */
//_______________________ EDITs Ana__________________________________

    // REGRA: term = factor, tprime;
    private void program() throws Exception {
        System.out.println("term():");

        expr();
        accept(token.tag);;
    }


    public void parse() throws Exception {
        // REGRA: goal = expr;
        program();
        // se, depois de expr() o token for EOF, tudo deu certo!
        if (token.tag == Tag.EOF) {
            System.out.println("Análise sintática terminada com sucesso!");
        } else {
            error(Tag.EOF);
        }
    }


     // REGRA Antiga: factor = '(', expr, ')' | number | id;
     // REGRA: factor = '(', expr, ')' |'-',expr | number | id;
//Tag.MINUS
     private void factor() throws Exception {
        System.out.println("factor():");

        switch (token.tag) {
            case LPAREN:
                accept(Tag.LPAREN);
                expr();
                accept(Tag.RPAREN);
                break;
            case NUMBER:
                accept(Tag.NUMBER);
                break;
            case ID:
                accept(Tag.ID);
                break;


    //edit
            case MINUS://edit
                accept(Tag.MINUS);
                expr();





            default:
                error(new Tag[] { Tag.LPAREN, Tag.NUMBER, Tag.ID });
                break;
        }
    }


    //+ edit factor - abaixo \/

// _______________________________________________________________



    // REGRA: expr = term, eprime;
    private void expr() throws Exception {
        System.out.println("expr():");

        term();
        eprime();
    }

    // REGRA: eprime = { ('+' | '-'), term };
    private void eprime() throws Exception {
        System.out.println("eprime():");

        while (token.tag == Tag.PLUS || token.tag == Tag.MINUS) {
            accept(token.tag);
            term();
        }
    }

    // REGRA: term = factor, tprime;
    private void term() throws Exception {
        System.out.println("term():");

        factor();
        tprime();
    }

    // REGRA: tprime = { ( '*' | '/' ), factor };
    private void tprime() throws Exception {
        System.out.println("tprime():");

        while (token.tag == Tag.TIMES || token.tag == Tag.DIV) {
            accept(token.tag);
            factor();
        }
    }
/* FACTOR ANTIGO
    // REGRA: factor = '(', expr, ')' | number | id;
    private void factor() throws Exception {
        System.out.println("factor():");

        switch (token.tag) {
            case LPAREN:
                accept(Tag.LPAREN);
                expr();
                accept(Tag.RPAREN);
                break;
            case NUMBER:
                accept(Tag.NUMBER);
                break;
            case ID:
                accept(Tag.ID);
                break;
            default:
                error(new Tag[] { Tag.LPAREN, Tag.NUMBER, Tag.ID });
                break;
        }
    }
    */
}
