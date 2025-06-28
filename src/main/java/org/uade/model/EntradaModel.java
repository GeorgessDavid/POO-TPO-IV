package org.uade.model;

public class EntradaModel {

    private float precio;
    private int nroAsiento;
    public FuncionModel funcion;

    public EntradaModel(int nroAsiento, FuncionModel funcion, float precio) {
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

    public FuncionModel getFuncion() {
        return funcion;
    }
}