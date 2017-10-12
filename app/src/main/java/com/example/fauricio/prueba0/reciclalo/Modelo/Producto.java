package com.example.fauricio.prueba0.reciclalo.Modelo;

/**
 * Created by Fauricio on 30/09/2017.
 */

public class Producto {
    private String Cod;
    private String descrip;
    private String tipo;
    private String DescripTipo;
    private double saldo;

    public Producto(String cod, String descrip, String tipo, String descripTipo, double saldo) {
        Cod = cod;
        this.descrip = descrip;
        this.tipo = tipo;
        DescripTipo = descripTipo;
        this.saldo = saldo;
    }

    public String getCod() {
        return Cod;
    }

    public void setCod(String cod) {
        Cod = cod;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripTipo() {
        return DescripTipo;
    }

    public void setDescripTipo(String descripTipo) {
        DescripTipo = descripTipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
