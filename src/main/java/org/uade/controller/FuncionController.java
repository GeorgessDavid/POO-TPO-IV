package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.Funcion;
import org.uade.model.Pelicula;
import org.uade.model.Sala;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class FuncionController {

    private static FuncionController instance;
	private List<Funcion> funciones;
	
	private FuncionController() {
    	funciones = new ArrayList<>();
    	funciones.add(new Funcion(new Date(), 1, "11:00", new ArrayList<>(), new Sala(0, null, 0),
                new Pelicula(TipoGenero.TERROR,"steven spielberg",120,"Tiburon", TipoProyeccion.DOS_D,new ArrayList<>(),null)));
    }

    public static FuncionController getInstance(){
        if(instance == null) instance = new FuncionController();

        return instance;
    }

    public void ABM() {
        // TODO implement here
    }

    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
    	int asientos = -1;
		return asientos;
    }

    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return null;
    }

    public int peliculaMasVista() {
        // TODO implement here
        return 0;
    }

    public int diaDeLaSemanaConMenorVentas() {
        // TODO implement here
        return 0;
    }

    public List<Funcion> buscarPeliculaPorFuncion(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getId == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }

    public List<Funcion> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getGeneroID() == genero){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }
}