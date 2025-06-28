package org.uade.dto;

import org.uade.model.ComboModel;
import org.uade.model.FuncionModel;
import org.uade.model.TarjetaDescuentoModel;

import java.util.Date;
import java.util.List;

public class VentaDTO {
    private final int ventaID;
    private final Date fchVenta;
    private final List<ComboModel> combos;
    private final FuncionModel funcion;
    private final TarjetaDescuentoModel tarjetaDescuento;

    public VentaDTO(int ventaID, Date fchVenta, List<ComboModel> combos, FuncionModel funcion, TarjetaDescuentoModel tarjetaDescuento) {
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

    public List<ComboModel> getCombos() {
        return combos;
    }

    public FuncionModel getFuncion() {
        return funcion;
    }

    public TarjetaDescuentoModel getTarjetaDescuento() {
        return tarjetaDescuento;
    }

}