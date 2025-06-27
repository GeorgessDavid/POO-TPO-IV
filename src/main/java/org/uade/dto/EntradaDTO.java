package org.uade.dto;

import org.uade.model.Funcion;

public class EntradaDTO {
    private final float precio;
    private final int nroAsiento;
    private final Funcion funcion;

    public EntradaDTO(float precio, int nroAsiento, Funcion funcion) {
        this.precio = precio;
        this.nroAsiento = nroAsiento;
        this.funcion = funcion;
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