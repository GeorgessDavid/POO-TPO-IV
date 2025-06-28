package org.uade.model;

import java.util.List;

public class SucursalModel {

    private int sucursalID;
    private String denominacion;
    private String direccion;
    private List<SalaModel> salas;

    public SucursalModel(int sucursalID, String denominacion, String direccion, List<SalaModel> salas) {
    	this.denominacion = denominacion;
    	this.direccion = direccion;
    	this.sucursalID = sucursalID;
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

    public void setSala(SalaModel sala){
        salas.add(sala);
    }
}