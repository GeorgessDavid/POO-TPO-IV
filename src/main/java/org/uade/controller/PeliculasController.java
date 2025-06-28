package org.uade.controller;

import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.exceptions.NotFoundException;
import org.uade.model.CondicionesDescuento;
import org.uade.model.Pelicula;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PeliculasController {
    private static PeliculasController instance;
    private List<Pelicula> peliculas;

    public List<PeliculaDTO> getPeliculas() {
        return peliculas
                .stream()
                .map(PeliculasController.getInstance()::modelToDto)
                .toList();
    }

    private PeliculasController() {
    	peliculas= new ArrayList<Pelicula>();
    	peliculas.add(new Pelicula(1,TipoGenero.SUSPENSO, "Pelicula1", 180 , "Director X", TipoProyeccion.DOS_D, Arrays.asList("Actriz Principal", "Actor Secundario"),null));
    }

    public static PeliculasController getInstance(){
        if(instance==null) instance = new PeliculasController();

        return instance;
    }

    public void altaPelicula(int id,TipoGenero genero, String director, int duracionMinutos, String nombre, TipoProyeccion proyeccion, List<String> actores, CondicionesDescuento descuento){
        if(buscarPelicula(id)!=null) throw new IllegalArgumentException("Esta pelicula ya existe");
        peliculas.add(new Pelicula(id,genero,director,duracionMinutos,nombre,proyeccion,actores,descuento));
    }

    public void bajaPelicula(int id){
        Pelicula pelicula = buscarPelicula(id);
        if(pelicula == null) return;

        peliculas.remove(pelicula);
    }

    public void modificarPelicula(){}

    public Pelicula buscarPelicula(int id){
        for(Pelicula pelicula : peliculas){
            if(pelicula.getPeliculaId()==id) return pelicula;
        }
        return null;
    }

    public List<Pelicula> buscarPeliculaPorGenero(TipoGenero genero){
        List<Pelicula> pelis = new ArrayList<Pelicula>();
        for(Pelicula pelicula : peliculas){
            if(pelicula.getGeneroID()==genero) pelis.add(pelicula);
        }

        if (pelis.isEmpty()) throw new NotFoundException("No se encontraron películas.");

        return pelis;
    }

    public PeliculaDTO modelToDto(Pelicula pelicula) {
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