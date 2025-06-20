package org.uade.model;

import org.uade.enums.TipoTarjeta;

public class TarjetaDescuento {

    private int tarjetaID;
    private TipoTarjeta tipoTarjeta;
    private String numeroTarjeta;

    public TarjetaDescuento(int tarjetaID, TipoTarjeta tipoTarjeta, String numeroTarjeta) {
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