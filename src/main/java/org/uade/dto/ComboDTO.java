package org.uade.dto;

import org.uade.model.CondicionesDescuentoModel;

public class ComboDTO {
    private final int comboID;
    private final String descripcion;
    private final float precio;
    private final CondicionesDescuentoModel condicionesDescuento;

    public ComboDTO(int comboID, String descripcion, float precio, CondicionesDescuentoModel condicionesDescuento) {
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

    public CondicionesDescuentoModel getCondicionesDescuento() {
        return condicionesDescuento;
    }

}
