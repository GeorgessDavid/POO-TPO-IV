package org.uade.model;

public class ComboModel {

    private int comboID;
    private String descripcion;
    private float precio;
    public CondicionesDescuentoModel contiene;

    public ComboModel(int comboID, String descripcion, float precio, CondicionesDescuentoModel contiene  ) {
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

    public CondicionesDescuentoModel getCondicionesDescuento() {
        return contiene;
    }
}