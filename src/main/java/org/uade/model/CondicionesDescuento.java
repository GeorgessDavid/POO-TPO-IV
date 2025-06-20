package org.uade.model;

import org.uade.enums.TipoTarjeta;

import java.util.Date;
import java.util.List;

public class CondicionesDescuento {

    private Date fchDesde;
    private Date fchHasta;
    private int diaSemana;
    private float porcentaje;
    private TipoTarjeta tipoTarjeta;
    private List<TarjetaDescuento> tarjetaDescuento;

    public CondicionesDescuento(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjetaList, List<TarjetaDescuento> tarjetaDescuento) {
    	this.diaSemana = diaSemana;
    	this.fchDesde = fchDesde;
    	this.fchHasta = fchHasta;
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

    public List<TarjetaDescuento> getTarjetaDescuento(){
        return tarjetaDescuento;
    }

    public void setTarjetaDescuento(TarjetaDescuento tarjeta){
        tarjetaDescuento.add(tarjeta);
    }

    public float getDescuento(){
        float descuento = 0.0f;
        for (TarjetaDescuento tarjetaDescuento: getTarjetaDescuento()) {
            descuento += getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta());
        }
        descuento=descuento+porcentaje;
        return descuento;
    }


    public static float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta){
        switch (tipoTarjeta){
            case PAMI -> { return 0.25f; }
            case UADE, MOVIE_CLUB ->{ return 0.15f;}
            case LA_NACION,CLARIN_365 -> {return 0.5f;}
            default -> {return 0.0f;}
        }
    }



}