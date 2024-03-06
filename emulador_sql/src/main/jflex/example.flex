package org.example;

import java_cup.runtime.*;

%%
%public
%class A_Lexer
%cup

digit = [0-9]
letter = [a-zA-Z]
whiteSpace = [\t\r]

%{
    StringBuffer str = new StringBuffer();

    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline, yycolumn);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline, yycolumn, value);
    }
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

%%
{digit}+ { return symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }
"(" { return symbol(ParserSym.LPAREN, yytext()); }
")" { return symbol(ParserSym.RPAREN, yytext()); }
"+" { return symbol(ParserSym.PLUS, yytext()); }
"*" { return symbol(ParserSym.TIMES, yytext()); }
{whiteSpace}+ { /* no haceer nada */}
[^] { throw new Error("cadena ilegal < "+ yytext()+" >"); }
