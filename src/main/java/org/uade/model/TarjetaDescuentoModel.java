package org.uade.model;

import org.uade.enums.TipoTarjeta;

public class TarjetaDescuentoModel {

    private int tarjetaID;
    private TipoTarjeta tipoTarjeta;
    private String numeroTarjeta;

    public TarjetaDescuentoModel(int tarjetaID, TipoTarjeta tipoTarjeta, String numeroTarjeta) {
    	this.numeroTarjeta = numeroTarjeta;
    	this.tarjetaID = tarjetaID;
    	this.tipoTarjeta = tipoTarjeta;
    }

    public int getTarjetaID() {
        return tarjetaID;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

}