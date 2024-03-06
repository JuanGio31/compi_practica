package org.example.modelo.proyecto;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private String nombre;
    private String path;
    private List<Archivo> archivos;
    private List<Carpeta> carpetas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.archivos = new ArrayList<>();
        this.carpetas = new ArrayList<>();
    }

    public void mostrar() {
        System.out.println("Proyecto > " + nombre);
        for (Carpeta carpeta : carpetas) {
            System.out.println(carpeta.toString());
        }
        System.out.println(" ");
        for (Archivo archivo : archivos) {
            System.out.println(archivo.toString());
        }
        System.out.println(" ");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void agregarCarpeta(Carpeta carpeta) {
        carpetas.add(carpeta);
    }

    public void agregarArchivo(Archivo archivo) {
        archivos.add(archivo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(List<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }
}
