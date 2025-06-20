package org.uade.model;

public class Entrada {

    private float precio;
    private int nroAsiento;
    public Funcion funcion;

    public Entrada(int nroAsiento, Funcion funcion, float precio) {
    	this.funcion = funcion;
    	this.nroAsiento = nroAsiento;
    	this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public int getNroAsiento() {
        return nroAsiento;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}