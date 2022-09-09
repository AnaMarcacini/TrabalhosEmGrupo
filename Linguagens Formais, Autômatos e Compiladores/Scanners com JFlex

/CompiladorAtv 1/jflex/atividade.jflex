/**
 * Analisador léxico para expressões simples
 */
package atividade;

%%

%class Lexer
%public
%unicode
%debug
%standalone
%line
%column
%type Token

%eofval{
    return new Token(Tag.EOF);
%eofval}

%eof{
    System.out.println("Análise léxica terminada com sucesso!");
%eof}

%{
    // Buffer para armazenar as cadeias de caracteres
    private StringBuffer buffer = new StringBuffer();
%}

%{
// Macros
%}

%xstate IN_STR

delim	= [\ \t\n\r]
ws		= {delim}+
letter	= [A-Za-z]
digit	= [0-9]
sub     = [_]
id		= ({sub}|{letter})(({letter}|{digit}|{sub}){0,31})
number	= {digit}+(\.{digit}+)?(E[+-]?{digit}+)?
%%

/* Regras e ações */
<YYINITIAL> {
    "\"" 	    { yybegin(IN_STR); buffer.setLength(0); }
    {ws}		{ /* ignorar */ }
    program     { return new Token(Tag.PROGRAM); }

    if			{ return new Token(Tag.IF); }
    else		{ return new Token(Tag.ELSE); }
    while       { return new Token(Tag.WHILE); }
    foreach     { return new Token(Tag.FOREACH); }
    function    { return new Token(Tag.FUNCTION); }
    end         { return new Token(Tag.END); }

    {id}		{ return new Id(yytext()); }
    {number}	{ return new Num(Double.parseDouble(yytext())); }
    "<"			{ return new Relop(Tag.LT);}
    "<="		{ return new Relop(Tag.LE);}
    "="			{ return new Relop(Tag.EQ);}
    "=="		{ return new Relop(Tag.IG);}

    "!="		{ return new Relop(Tag.NE);}
    ">"			{ return new Relop(Tag.GT);}
    ">="		{ return new Relop(Tag.GE);}
    "{"         { return new Relop(Tag.CE);}
    "}"         { return new Relop(Tag.CD);}
    "("         { return new Relop(Tag.PE);}
    ")"         { return new Relop(Tag.PD);}
    ","         { return new Relop(Tag.VR);}
    ";"         { return new Relop(Tag.PV);}





/*

ADD, SUB, MULT, DIV, RES, INCR, DECR

*/

    "+"		{ return new Relop(Tag.ADD);} 
    "-"			{ return new Relop(Tag.SUB);}
    "*"		{ return new Relop(Tag.MULT);}
    "/"         { return new Relop(Tag.DIV);}
    "%"         { return new Relop(Tag.RES);}
    "++"         { return new Relop(Tag.INCR);}
    "--"         { return new Relop(Tag.DECR);}



    "*/"         { return new Relop(Tag.FECHA);}
    "/*"         { return new Relop(Tag.ABRE);}


    /* Qualquer outro - gerar erro */
    .		    { throw new Error("Símbolo ilegal <" + yytext() +
                    "(" + (int)(yytext().charAt(0)) + ")" + ">"); }
}
<IN_STR> {
	"\""		{ yybegin(YYINITIAL); 
				    return new Str(buffer.toString()); }
	.|{delim}	{ buffer.append(yytext()); }
}