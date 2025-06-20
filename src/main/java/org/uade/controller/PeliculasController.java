package org.uade.controller;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.Pelicula;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PeliculasController {

    private static PeliculasController instance;
	private List<Pelicula> peliculas;
	
    private PeliculasController() {
    	peliculas= new ArrayList<Pelicula>();
    	peliculas.add(new Pelicula(TipoGenero.SUSPENSO, "Pelicula1", 180 , "Director X", TipoProyeccion.DOS_D, Arrays.asList("Actriz Principal", "Actor Secundario"),null));
    }

    public static PeliculasController getInstance(){
        if(instance==null) instance = new PeliculasController();

        return instance;
    }

    public void ABM() {
        // TODO implement here
    }

}