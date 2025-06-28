package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.dto.VentaDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoTarjeta;
import org.uade.model.FuncionModel;
import org.uade.model.VentaModel;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class VentasController {

    private static VentasController instance;
    private static FuncionController funcionController;
    private List<VentaModel> ventas;

    private VentasController(){
        funcionController = FuncionController.getInstance();
        ventas = new ArrayList<>();
        ventas.add(new VentaModel(1,new Date(), null, null));
    }

    public static VentasController getInstance(){
        if(instance == null) instance = new VentasController();

        return instance;
    }

    public List<VentaModel> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaModel> ventas) {
        this.ventas = ventas;
    }


    public float recaudacionPorFuncion(int funcionID) {
        VentaModel venta = buscarVentaPorIdFuncion(funcionID);
        if(venta==null) return 0.0f;

        return venta.calcularMontoDeLaVentaPorFuncionCombos();
    }

    public float recaudacionPorPelicula(int peliculaID) {
        List<FuncionModel> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (FuncionModel funcion:funciones) {
            VentaModel venta = buscarVentaPorFuncion(funcion);
            if(venta != null){
                totalrecuadado=+venta.getTotal();
            }
        }
    	return totalrecuadado;
    }

    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        float total = 0.0f;
        if(ventas.isEmpty()) return total;

        for(VentaModel venta : ventas){
            if(venta.getTarjetaDescuento().getTipoTarjeta() == tipoTarjeta) total += venta.getTotal();
        }

        return total;
    }

    public void comboMasVendido() {
        // TODO implement here
    }

    private VentaModel buscarVentaPorFuncion(FuncionModel funcion){
        if(ventas.isEmpty()) return null;

        for (VentaModel venta:ventas) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    private VentaModel buscarVentaPorIdFuncion(int id){
        if(ventas.isEmpty()) return null;

        for(VentaModel v : ventas){
            if(v.getFuncion().getFuncionID()==id) return v;
        }
        return null;
    }

    public List<VentaDTO> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDTO> ventaDtos = new ArrayList<>();
        List<FuncionModel> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if(funciones.isEmpty()){
            return ventaDtos;
        }
        for (FuncionModel funcion:funciones) {
            VentaModel venta = buscarVentaPorFuncion(funcion);
            if(Objects.isNull(venta)){
                ventaDtos.add(modelVentaToDto(venta));
            }
        }
        return ventaDtos;
    }

    public VentaDTO modelVentaToDto(VentaModel venta){
        return new VentaDTO(
                venta.getVentaID(),
                venta.getFchVenta(),
                venta.getCombos(),
                venta.getFuncion(),
                venta.getTarjetaDescuento()
        );
    }

    public FuncionDTO modelFuncionToDto(FuncionModel funcion){
        return new FuncionDTO(
                funcion.getPelicula(),
                funcion.getFuncionID(),
                funcion.getHorario(),
                funcion.getFecha(),
                funcion.getEntradas(),
                funcion.getSala()
        );
    }
}