package org.uade.dto;

import org.uade.enums.TipoTarjeta;
import org.uade.model.TarjetaDescuento;

import java.util.Date;
import java.util.List;

public class CondicionesDescuentoDTO {
    private final Date fchDesde;
    private final Date fchHasta;
    private final int diaSemana;
    private final float porcentaje;
    private final TipoTarjeta tipoTarjeta;
    private final List<TarjetaDescuento> tarjetaDescuento;

    public CondicionesDescuentoDTO(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjeta, List<TarjetaDescuento> tarjetaDescuento) {
        this.fchDesde = fchDesde;
        this.fchHasta = fchHasta;
        this.diaSemana = diaSemana;
        this.porcentaje = porcentaje;
        this.tipoTarjeta = tipoTarjeta;
        this.tarjetaDescuento = tarjetaDescuento;
    }

    public Date getFchDesde() {
        return fchDesde;
    }

    public Date getFchHasta() {
        return fchHasta;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public List<TarjetaDescuento> getTarjetaDescuento() {
        return tarjetaDescuento;
    }

    public static float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta) {
        float descuento = 0.0F;

        switch (tipoTarjeta) {
            case PAMI -> descuento = 0.25F;
            case UADE, MOVIE_CLUB -> descuento = 0.15F;
            case LA_NACION, CLARIN_365 -> descuento = 0.5F;
            default -> descuento = 0.0F;
        }

        return descuento;
    }

    public float getDescuento() {
        float descuento = 0.0F;

        for (TarjetaDescuento tarjeta : tarjetaDescuento) {
            descuento += getDescuentoPorTarjeta(tarjeta.getTipoTarjeta());
        }

        descuento += porcentaje;

        return descuento;
    }

}