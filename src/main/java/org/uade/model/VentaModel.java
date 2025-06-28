package org.uade.model;

import java.util.Date;
import java.util.List;

public class VentaModel {

    private int ventaID;
    private Date fchVenta;
    private List<ComboModel> combos;
    private FuncionModel funcion;
    private TarjetaDescuentoModel tarjetaDescuento;

    public VentaModel(int ventaID, Date fchVenta, List<ComboModel> combos, FuncionModel funcion) {
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

    public List<ComboModel> getCombos() {
        return combos;
    }

    public FuncionModel getFuncion() {
        return funcion;
    }

    public TarjetaDescuentoModel getTarjetaDescuento(){
        return tarjetaDescuento;
    }

    public float getTotal() { return calcularMontoDeLaVentaPorFuncionCombos()+calcularMontoPorComboDeVenta();}

    public void setFuncion(FuncionModel funcion) {
        this.funcion = funcion;
    }

    public void setCombo(ComboModel combo){
        combos.add(combo);
    }

    public float calcularMontoPorComboDeVenta(){
        float total=  0.0f;
        for (ComboModel combo : combos) {
           total =+  (combo.getPrecio()-(combo.getPrecio()*
                   CondicionesDescuentoModel.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta())));
        }
        return total;
    }

    public float calcularMontoDeLaVentaPorFuncionCombos(){
        return funcion.calcularMontoPorEntradaDeLaPelicula();
    }
}