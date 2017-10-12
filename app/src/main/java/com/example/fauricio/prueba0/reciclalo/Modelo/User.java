package com.example.fauricio.prueba0.reciclalo.Modelo;

/**
 * Created by Fauricio on 30/09/2017.
 */

public class User {
    private int Id;
    private String Nombre;
    private String Correo;
    private String Contraseña;
    private double SaldoPuntos;

    public User(int id, String nombre, String correo, String contraseña, double saldoPuntos) {
        Id = id;
        Nombre = nombre;
        Correo = correo;
        Contraseña = contraseña;
        SaldoPuntos = saldoPuntos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public double getSaldoPuntos() {
        return SaldoPuntos;
    }

    public void setSaldoPuntos(double saldoPuntos) {
        SaldoPuntos = saldoPuntos;
    }
}
