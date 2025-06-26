package org.uade.controller;

import org.uade.dto.FuncionDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.Entrada;
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
                new Pelicula(1,TipoGenero.TERROR,"steven spielberg",120,"Tiburon", TipoProyeccion.DOS_D,new ArrayList<>(),null)));
    }

    public static FuncionController getInstance(){
        if(instance == null) instance = new FuncionController();

        return instance;
    }

    public void altaFuncion(Date fecha, int id, String horario, List<Entrada> entradas, Sala sala, Pelicula pelicula){
        if(buscarFuncion(id)!=null) return;

        funciones.add(new Funcion(fecha,id,horario,entradas,sala,pelicula));
    }

    public void bajaFuncion(int id){
        Funcion funcion = buscarFuncion(id);
        if(funcion==null) return;

        funciones.remove(funcion);
    }

    public void modificarFuncion(){

    }

    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
    	Funcion funcion = buscarFuncion(funcionID);
        if(funcion == null) return -1;

        int totalAsientos = funcion.getSala().getAsientos();
        int asientosOcupados = funcion.getEntradas().size();

        return totalAsientos - asientosOcupados;
    }

    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        if(funciones.isEmpty()) return null;
        List<FuncionDTO> funcionList = new ArrayList<>();

        for(Funcion funcion : funciones){
            if(funcion.getFecha().equals(fchFuncion)) funcionList.add(new FuncionDTO(funcion));
        }
        return funcionList;
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
            if (funcion.getPelicula().getPeliculaId() == peliculaID){
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
        return funcionesDeLaPelicula;
    }

    public Funcion buscarFuncion(int id){

        for(Funcion funcion : funciones){
            if(funcion.getFuncionID() == id) return funcion;
        }
        return null;
    }

    private Funcion buscarFuncionPorFecha(Date fecha){

        for(Funcion funcion : funciones){
            if(funcion.getFecha().equals(fecha)) return funcion;
        }
        return null;
    }
}