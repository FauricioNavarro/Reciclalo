package com.example.fauricio.prueba0.reciclalo.Controlador;

import com.example.fauricio.prueba0.reciclalo.Modelo.App;

/**
 * Created by Fauricio on 30/09/2017.
 */

public class Controladora {
    private static final Controladora ourInstance = new Controladora();
    private App reciclalo;

    public static Controladora getInstance() {
        return ourInstance;
    }

    public Controladora() {
    }

    public App getReciclalo() {
        return reciclalo;
    }

    public void setReciclalo(App reciclalo) {
        this.reciclalo = reciclalo;
    }


}
