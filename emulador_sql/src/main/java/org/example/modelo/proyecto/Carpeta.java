package org.example.modelo.proyecto;

public class Carpeta {
    private String nombre;

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carpeta{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
