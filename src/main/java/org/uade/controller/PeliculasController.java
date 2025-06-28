package org.uade.controller;

import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.exceptions.NotFoundException;
import org.uade.model.CondicionesDescuentoModel;
import org.uade.model.PeliculaModel;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PeliculasController {

    private static PeliculasController instance;
	private List<PeliculaModel> peliculas;

    private int contadorId = 1;

    public List<PeliculaDTO> getPeliculas() {
        return peliculas
                .stream()
                .map(PeliculasController.getInstance()::modelToDto)
                .toList();
    }

    private PeliculasController() {
    	peliculas = new ArrayList<PeliculaModel>();
    }

    public static PeliculasController getInstance(){
        if(instance==null) instance = new PeliculasController();

        return instance;
    }

    public void altaPelicula(TipoGenero genero, String director, int duracionMinutos, String nombre, TipoProyeccion proyeccion, List<String> actores, CondicionesDescuentoModel descuento){
        if (buscarPelicula(contadorId) != null) throw new IllegalArgumentException("Esta pelicula ya existe");

        peliculas.add(new PeliculaModel(contadorId,genero,director,duracionMinutos,nombre,proyeccion,actores,descuento));
        contadorId++;
    }

    public void bajaPelicula(int id){
        PeliculaModel pelicula = buscarPelicula(id);
        if(pelicula == null) return;

        peliculas.remove(pelicula);
    }

    public void modificarPelicula(){}

    public PeliculaModel buscarPelicula(int id){
        for(PeliculaModel pelicula : peliculas){
            if(pelicula.getPeliculaId()==id) return pelicula;
        }
        return null;
    }

    public List<PeliculaModel> buscarPeliculaPorGenero(TipoGenero genero){
        List<PeliculaModel> pelis = new ArrayList<PeliculaModel>();
        for(PeliculaModel pelicula : peliculas){
            if(pelicula.getGeneroID()==genero) pelis.add(pelicula);
        }

        if (pelis.isEmpty()) throw new NotFoundException("No se encontraron películas.");

        return pelis;
    }

    public PeliculaDTO modelToDto(PeliculaModel pelicula) {
        return new PeliculaDTO(
                pelicula.getPeliculaId(),
                pelicula.getGeneroID(),
                pelicula.getNombrePelicula(),
                pelicula.getDuracionEnMinutos(),
                pelicula.getDirector(),
                pelicula.getActores(),
                pelicula.getTipo(),
                pelicula.getCondicionesDescuento()
        );
    }

    public void reset(){
        peliculas.clear();
    }
}