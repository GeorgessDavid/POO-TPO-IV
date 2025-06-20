package org.uade.model;

public class Sala {

    private int salaID;
    private String denominacion;
    private int asientos;

    public Sala(int salaID, String denominacion, int asientos) {
    	this.asientos = asientos;
    	this.denominacion = denominacion;
    	this.salaID = salaID;
    }

    public int getSalaID() {
        return salaID;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getAsientos() {
        return asientos;
    }
}