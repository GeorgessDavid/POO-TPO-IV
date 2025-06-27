package org.uade.dto;

import org.uade.model.Combo;
import org.uade.model.Funcion;
import org.uade.model.TarjetaDescuento;

import java.util.Date;
import java.util.List;

public class VentaDTO {
    private final int ventaID;
    private final Date fchVenta;
    private final List<Combo> combos;
    private final Funcion funcion;
    private final TarjetaDescuento tarjetaDescuento;

    public VentaDTO(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion, TarjetaDescuento tarjetaDescuento) {
        this.ventaID = ventaID;
        this.fchVenta = fchVenta;
        this.combos = combos;
        this.funcion = funcion;
        this.tarjetaDescuento = tarjetaDescuento;
    }

    public int getVentaID() {
        return ventaID;
    }

    public Date getFchVenta() {
        return fchVenta;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }

}