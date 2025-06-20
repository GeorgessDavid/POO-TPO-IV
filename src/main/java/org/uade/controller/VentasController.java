package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.dto.VentaDto;
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
        // TODO implement here
        return 0.0f;
    }

    public float recaudacionPorPelicula(int peliculaID) {
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(Objects.isNull(venta)){
                totalrecuadado=+venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
    	return totalrecuadado;
    }

    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    public void comboMasVendido() {
        // TODO implement here
    }

    private  Venta buscarVentaPorFuncion(Funcion funcion){
        for (Venta venta:getVentas()) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    public List<VentaDto> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDto> ventaDtos = new ArrayList<>();
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

    public VentaDto modelVentaToDto(Venta venta){
        return new VentaDto(modelFuncionToDto(venta.getFuncion()));
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion){
        return new FuncionDTO(funcion);
    }
}