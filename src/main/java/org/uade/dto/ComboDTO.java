package org.uade.dto;

import org.uade.model.CondicionesDescuento;

public class ComboDTO {
    private final int comboID;
    private final String descripcion;
    private final float precio;
    private final CondicionesDescuento condicionesDescuento;

    public ComboDTO(int comboID, String descripcion, float precio, CondicionesDescuento condicionesDescuento) {
        this.comboID = comboID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.condicionesDescuento = condicionesDescuento;
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
        return condicionesDescuento;
    }

}
