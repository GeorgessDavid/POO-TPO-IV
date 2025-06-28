package org.uade.model;

import org.uade.enums.TipoTarjeta;

import java.util.Date;
import java.util.List;

public class CondicionesDescuentoModel {

    private Date fchDesde;
    private Date fchHasta;
    private int diaSemana;
    private float porcentaje;
    private TipoTarjeta tipoTarjeta;
    private List<TarjetaDescuentoModel> tarjetaDescuento;

    public CondicionesDescuentoModel(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjeta, List<TarjetaDescuentoModel> tarjetaDescuento) {
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

    public List<TarjetaDescuentoModel> getTarjetaDescuento(){
        return tarjetaDescuento;
    }

    public void setTarjetaDescuento(TarjetaDescuentoModel tarjeta){
        tarjetaDescuento.add(tarjeta);
    }

    public float getDescuento(){
        float descuento = 0.0f;
        for (TarjetaDescuentoModel tarjetaDescuento: tarjetaDescuento) {
            descuento += getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta());
        }
        descuento=descuento+porcentaje;
        return descuento;
    }


    public static float getDescuentoPorTarjeta(TipoTarjeta tipoTarjeta){
        float descuento;
        switch (tipoTarjeta){
            case PAMI -> descuento = 0.25f;
            case UADE, MOVIE_CLUB -> descuento = 0.15f;
            case LA_NACION,CLARIN_365 -> descuento = 0.5f;
            default -> descuento = 0.0f;
        }
        return descuento;
    }



}