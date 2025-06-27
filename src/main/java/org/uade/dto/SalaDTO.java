package org.uade.dto;

public class SalaDTO {
    private final int salaID;
    private final String denominacion;
    private final int asientos;

    public SalaDTO(int salaID, String denominacion, int asientos) {
        this.salaID = salaID;
        this.denominacion = denominacion;
        this.asientos = asientos;
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