package org.example.modelo.lexico;

/**
 * Clase que contiene toda la informacion sobre tokens
 *
 * @author giovanic
 */
public class TokenL {

    private final TK_Enum tipo;
    private final String lexema;
    private int fila;
    private int columna;

    /**
     * Metodo constructor
     *
     * @param tipo    tipo de token
     * @param lexema  palabra formada
     * @param fila    fila donde se ubica el token
     * @param columna columna donde se ubica el token
     */
    public TokenL(TK_Enum tipo, String lexema, int fila, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public TokenL(TK_Enum tipo, int fila, int columna) {
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.lexema = "";
    }

    public TokenL() {
        this.tipo = TK_Enum.EOF;
        this.lexema = null;
    }

    @Override
    public String toString() {
        return "TokenL{" +
                "tipo=" + tipo +
                ", lexema='" + lexema + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                '}';
    }

    public TK_Enum getTipo() {
        return tipo;
    }


    public String getLexema() {
        return lexema;
    }


    public int getFila() {
        return fila;
    }


    public int getColumna() {
        return columna;
    }
}