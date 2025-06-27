package org.uade.dto;

import org.uade.enums.TipoTarjeta;

public class TarjetaDescuentoDTO {
    private final int tarjetaID;
    private final TipoTarjeta tipoTarjeta;
    private final String numeroTarjeta;

    public TarjetaDescuentoDTO(int tarjetaID, TipoTarjeta tipoTarjeta, String numeroTarjeta) {
        this.tarjetaID = tarjetaID;
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
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
