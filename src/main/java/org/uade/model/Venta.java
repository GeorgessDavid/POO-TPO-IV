package org.uade.model;

import java.util.Date;
import java.util.List;

public class Venta {

    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    private Funcion funcion;
    private TarjetaDescuento tarjetaDescuento;

    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion) {
    	this.combos = combos;
    	this.funcion = funcion;
    	this.fchVenta = fchVenta;
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

    public TarjetaDescuento getTarjetaDescuento(){
        return tarjetaDescuento;
    }

    public float getTotal() { return calcularMontoDeLaVentaPorFuncionCombos()+calcularMontoPorComboDeVenta();}

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public void setCombo(Combo combo){
        combos.add(combo);
    }

    public float calcularMontoPorComboDeVenta(){
        float total=  0.0f;
        for (Combo combo : combos) {
           total =+  (combo.getPrecio()-(combo.getPrecio()*
                   CondicionesDescuento.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta())));
        }
        return total;
    }

    public float calcularMontoDeLaVentaPorFuncionCombos(){
        return funcion.calcularMontoPorEntradaDeLaPelicula();
    }
}