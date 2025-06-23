package org.uade.model;

public class Combo {

    private int comboID;
    private String descripcion;
    private float precio;
    public CondicionesDescuento contiene;

    public Combo(int comboID, String descripcion, float precio, CondicionesDescuento contiene  ) {
    	this.comboID = comboID;
    	this.contiene = contiene;
    	this.descripcion = descripcion;
    	this.precio = precio;
    }

    public int getComboID() {
        return comboID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public CondicionesDescuento getCondicionesDescuento() {
        return contiene;
    }
}