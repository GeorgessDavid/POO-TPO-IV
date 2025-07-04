package org.uade.dto;

import org.uade.model.SalaModel;

import java.util.List;

public class SucursalDTO {
    private final int sucursalID;
    private final String denominacion;
    private final String direccion;
    private final List<SalaModel> salas;

    public SucursalDTO(int sucursalID, String denominacion, String direccion, List<SalaModel> salas) {
        this.sucursalID = sucursalID;
        this.denominacion = denominacion;
        this.direccion = direccion;
        this.salas = salas;
    }

    public int getSucursalID() {
        return sucursalID;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<SalaModel> getSalas() {
        return salas;
    }
}
