package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class FuncionController {

    private static FuncionController instance;

    private PeliculasController peliculasController;
    private SucursalController sucursalController;
	private List<FuncionModel> funciones;

    private int contadorId;

	private FuncionController() {
        this.peliculasController = PeliculasController.getInstance();
        this.sucursalController = SucursalController.getInstance();
    	funciones = new ArrayList<>();
    	funciones.add(new FuncionModel(new Date(), 1, "11:00", new ArrayList<>(), new SalaModel(0, null, 0),
                new PeliculaModel(1,TipoGenero.TERROR,"steven spielberg",120,"Tiburon", TipoProyeccion.DOS_D,new ArrayList<>(),null)));
    }

    public static FuncionController getInstance(){
        if (instance == null) instance = new FuncionController();

        return instance;
    }


    public void altaFuncion(Date fecha, String horario, int idSala, int idSucursal, int idPelicula) {
        List<EntradaModel> entradas = new ArrayList<>();

        SucursalModel sucursal = sucursalController.buscarSucursal(idSucursal);
        if (sucursal == null) return; // TODO

        SalaModel sala = sucursal.buscarSala(idSala);
        if (sala == null) return; // TODO

        PeliculaModel pelicula = peliculasController.buscarPelicula(idPelicula);
        if (pelicula == null) return; // TODO

        funciones.add(new FuncionModel(fecha, contadorId, horario, entradas, sala, pelicula));
        contadorId++;
    }



    public void bajaFuncion(int id){
        FuncionModel funcion = buscarFuncion(id);
        if (funcion == null) return;

        funciones.remove(funcion);
    }


    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
    	FuncionModel funcion = buscarFuncion(funcionID);
        if(funcion == null) return -1;

        int totalAsientos = funcion.getSala().getAsientos();
        int asientosOcupados = funcion.getEntradas().size();

        return totalAsientos - asientosOcupados;
    }

    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        if(funciones.isEmpty()) return null;
        List<FuncionDTO> funcionList = new ArrayList<>();

        for(FuncionModel funcion : funciones){
            if(funcion.getFecha().equals(fchFuncion)) funcionList.add(
                    new FuncionDTO(
                            funcion.getPelicula(),
                            funcion.getFuncionID(),
                            funcion.getHorario(),
                            funcion.getFecha(),
                            funcion.getEntradas(),
                            funcion.getSala()
                    ));
        }
        return funcionList;
    }


    public List<FuncionModel> buscarPeliculaPorFuncion(int peliculaID) {
        List<FuncionModel> funcionesDeLaPelicula = new ArrayList<>();

        for (FuncionModel funcion : funciones) {
            if (funcion.getPelicula().getPeliculaId() == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }

        return funcionesDeLaPelicula;
    }

    public List<FuncionModel> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<FuncionModel> funcionesDeLaPelicula = new ArrayList<>();

        for (FuncionModel funcion : funciones) {
            if (funcion.getPelicula().getGeneroID() == genero){
                funcionesDeLaPelicula.add(funcion);
            }
        }

        return funcionesDeLaPelicula;
    }

    public FuncionModel buscarFuncion(int id){
        for(FuncionModel funcion : funciones){
            if(funcion.getFuncionID() == id) return funcion;
        }

        return null;
    }

    private FuncionModel buscarFuncionPorFecha(Date fecha){
        for(FuncionModel funcion : funciones){
            if(funcion.getFecha().equals(fecha)) return funcion;
        }

        return null;
    }
}