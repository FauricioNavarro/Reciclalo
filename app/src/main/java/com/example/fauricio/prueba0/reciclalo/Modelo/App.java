package com.example.fauricio.prueba0.reciclalo.Modelo;

import java.util.ArrayList;

/**
 * Created by Fauricio on 30/09/2017.
 */

public class App {
    private User usuario;
    private ArrayList<Premio> premios;
    private ArrayList<Producto> misProd;

    public App(ArrayList<Premio> premios, ArrayList<Producto> misProd) {
        this.premios = new ArrayList<Premio>();
        this.misProd = new ArrayList<Producto>();
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

    public ArrayList<Producto> getMisProd() {
        return misProd;
    }

    public void setMisProd(ArrayList<Producto> misProd) {
        this.misProd = misProd;
    }
}
