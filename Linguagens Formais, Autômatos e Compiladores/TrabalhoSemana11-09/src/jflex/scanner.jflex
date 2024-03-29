/**
 * Analisador léxico para expressões simples
 */
package compiler.scanner;

%%

%public
%class Scanner
%unicode
%type Token

%eofval{
    return new Token(Tag.EOF, yyline, yycolumn);
%eofval}

%line
%column

%eof{
    System.out.println("Análise léxica terminada com sucesso!");
%eof}


delim   = [\ \t\n]
ws      = {delim}+
digit	= [0-9]
number	= {digit}+(\.{digit}+)?([Ee][+-]?{digit}+)?
letter  = [A-Za-z]
id      = {letter}({letter}|{digit})*
//PontEVirgula = ";" // add


%%

{ws}		{ /* ignorar */ }
{number}	{ return new Number(Double.parseDouble(yytext()),
                                    yyline, yycolumn); }
{id}            {return new Id(yytext(), yyline, yycolumn); }
"+"             {return new Token(Tag.PLUS, yyline, yycolumn);}
"-"             {return new Token(Tag.MINUS, yyline, yycolumn);}
"*"             {return new Token(Tag.TIMES, yyline, yycolumn);}
"/"             {return new Token(Tag.DIV, yyline, yycolumn);}
"("             {return new Token(Tag.LPAREN, yyline, yycolumn);}
")"             {return new Token(Tag.RPAREN, yyline, yycolumn);}

";"             {return new Token(Tag.PontEVirgula, yyline, yycolumn);}
