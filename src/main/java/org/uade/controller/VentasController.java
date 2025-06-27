package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.dto.VentaDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoTarjeta;
import org.uade.model.Funcion;
import org.uade.model.Venta;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class VentasController {

    private static VentasController instance;
    private static FuncionController funcionController;
    private List<Venta> ventas;

    private VentasController(){
        funcionController = FuncionController.getInstance();
        ventas = new ArrayList<>();
        ventas.add(new Venta(1,new Date(), null, null));
    }

    public static VentasController getInstance(){
        if(instance == null) instance = new VentasController();

        return instance;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }


    public float recaudacionPorFuncion(int funcionID) {
        Venta venta = buscarVentaPorIdFuncion(funcionID);
        if(venta==null) return 0.0f;

        return venta.calcularMontoDeLaVentaPorFuncionCombos();
    }

    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(venta != null){
                totalrecuadado=+venta.getTotal();
            }
        }
    	return totalrecuadado;
    }

    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        float total = 0.0f;
        if(ventas.isEmpty()) return total;

        for(Venta venta : ventas){
            if(venta.getTarjetaDescuento().getTipoTarjeta() == tipoTarjeta) total += venta.getTotal();
        }

        return total;
    }

    public void comboMasVendido() {
        // TODO implement here
    }

    private Venta buscarVentaPorFuncion(Funcion funcion){
        if(ventas.isEmpty()) return null;

        for (Venta venta:ventas) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    private Venta buscarVentaPorIdFuncion(int id){
        if(ventas.isEmpty()) return null;

        for(Venta v : ventas){
            if(v.getFuncion().getFuncionID()==id) return v;
        }
        return null;
    }

    public List<VentaDTO> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDTO> ventaDtos = new ArrayList<>();
        List<Funcion> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if(funciones.isEmpty()){
            return ventaDtos;
        }
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(Objects.isNull(venta)){
                ventaDtos.add(modelVentaToDto(venta));
            }
        }
        return ventaDtos;
    }

    public VentaDTO modelVentaToDto(Venta venta){
        return new VentaDTO(modelFuncionToDto(venta.getFuncion()));
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion){
        return new FuncionDTO(funcion);
    }
}