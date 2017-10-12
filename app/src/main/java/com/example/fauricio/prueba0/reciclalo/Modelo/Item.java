package com.example.fauricio.prueba0.reciclalo.Modelo;

/**
 * Created by Fauricio on 01/10/2017.
 */

public class Item {
    private int imagen;
    private String titulo;
    private String contenido;

    public Item(int imagen, String titulo, String contenido) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
