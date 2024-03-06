package org.example;

import java_cup.runtime.*;


%%
%public
%class Escaner
%cup
%line
%column

L = [a-zA-Z_]
LetterOrDigitOrScript = [A-Za-z0-9_]
digit = [0-9]
letter = [a-zA-Z]
whiteSpace = [\t\r]
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
/*comilla doble*/
doble = "\"" {InputCharacter}* "\""

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

<YYINITIAL>{
SELECCIONAR { return symbol(ParserSym.SELECCIONAR, yytext()); }
FILTRAR { return symbol(ParserSym.FILTRAR, yytext()); }
INSERTAR { return symbol(ParserSym.INSERTAR, yytext()); }
ACTUALIZAR { return symbol(ParserSym.ACTUALIZAR, yytext()); }
ASIGNAR { return symbol(ParserSym.ASIGNAR, yytext()); }
ELIMINAR { return symbol(ParserSym.ELIMINAR, yytext()); }

VALORES { return symbol(ParserSym.VALORES, yytext()); }


EN { return symbol(ParserSym.EN, yytext()); }
";" { return symbol(ParserSym.FIN_INST, yytext()); }
"," { return symbol(ParserSym.COMA, yytext()); }


"==" |
"!=" |
">" |
"<" |
">=" |
"<=" { return symbol(ParserSym.OP_RELACIONAL, yytext()); }

AND {return symbol(ParserSym.AND, yytext()); }
OR { return symbol(ParserSym.OR, yytext()); }


{digit}+ (("."){digit}+) |
{digit}+ { return symbol(ParserSym.NUMBER, Integer.valueOf(yytext())); }
{L}({LetterOrDigitOrScript})* { return symbol(ParserSym.COLUMN_ID, yytext());}
{L}({LetterOrDigitOrScript})*(".")({LetterOrDigitOrScript})* {return symbol(ParserSym.PATH, yytext());}
{doble} {return symbol(ParserSym.CONST, yytext()); }

"(" { return symbol(ParserSym.LPAREN, yytext()); }
")" { return symbol(ParserSym.RPAREN, yytext()); }
"+" { return symbol(ParserSym.PLUS, yytext()); }
"*" { return symbol(ParserSym.TIMES, yytext()); }
{whiteSpace}+ { /* no haceer nada */}

}
//[^] { throw new Error("cadena ilegal < "+ yytext()+" >"); }
//[^] { return symbol(ParserSym.ERROR, yytext()); }
\n  {yychar=0;}
. {System.err.println("watning: Unrecognized character "+yytext()+ "--ignored"+" at "+ (yyline+1) +", "+(yycolumn+1));}