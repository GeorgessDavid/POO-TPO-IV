package org.uade.dto;

import org.uade.model.FuncionModel;

public class EntradaDTO {
    private final float precio;
    private final int nroAsiento;
    private final FuncionModel funcion;

    public EntradaDTO(float precio, int nroAsiento, FuncionModel funcion) {
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

    public FuncionModel getFuncion() {
        return funcion;
    }
}