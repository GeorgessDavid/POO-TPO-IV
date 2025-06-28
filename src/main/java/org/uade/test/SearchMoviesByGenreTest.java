package org.uade.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uade.controller.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.exceptions.NotFoundException;
import org.uade.model.PeliculaModel;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class SearchMoviesByGenreTest {
    private PeliculasController controller;

    @BeforeEach
    public void setUp() {
        controller = PeliculasController.getInstance();
        controller.reset();

        controller.altaPelicula(TipoGenero.SUSPENSO, "Director X", 120, "Suspenso Movie", TipoProyeccion.DOS_D, new ArrayList<>(), null);
        controller.altaPelicula(TipoGenero.DRAMA, "Director Y", 150, "Drama Movie", TipoProyeccion.TRES_D, new ArrayList<>(), null);
        controller.altaPelicula(TipoGenero.SUSPENSO, "Director Z", 130, "Another Suspense Movie", TipoProyeccion.DOS_D, new ArrayList<>(), null);
    }

    @Test
    public void testSearchMoviesByGenre_Success() {
        List<PeliculaModel> peliculas = controller.buscarPeliculaPorGenero(TipoGenero.SUSPENSO);
        assertFalse(peliculas.isEmpty(), "No se encontraron películas del género SUSPENSO.");
        assertEquals(2, peliculas.size(), "Se esperaban 2 películas del género SUSPENSO.");

        for (PeliculaModel pelicula : peliculas) {
            assertEquals(TipoGenero.SUSPENSO, pelicula.getGeneroID(), "La película no es del género SUSPENSO.");
        }
    }

    @Test
    public void testSearchMoviesByGenre_Fail_NoMoviesFound() {
        Exception e = assertThrows(NotFoundException.class, () -> {
            controller.buscarPeliculaPorGenero(TipoGenero.TERROR);
        });

        assertEquals("No se encontraron películas.", e.getMessage(), "El mensaje de error no coincide.");
    }

}
