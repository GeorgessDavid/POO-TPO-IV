package org.uade.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uade.controller.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.enums.TipoTarjeta;
import org.uade.model.CondicionesDescuentoModel;
import org.uade.model.PeliculaModel;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AddMovieTest {
    private PeliculasController controller;
    private TipoGenero genero;
    private String director;
    private int duracion;
    private String titulo;
    private TipoProyeccion tipoProyeccion;
    private List<String> actores;
    private CondicionesDescuentoModel descuento;

    @BeforeEach
    public void setUp() {
        controller = PeliculasController.getInstance();
        controller.reset();

        genero = TipoGenero.DRAMA;
        director = "Christopher Nolan";
        duracion = 174;
        titulo = "Tenet";
        tipoProyeccion = TipoProyeccion.TRES_D;
        actores = new ArrayList<>();
        descuento = new CondicionesDescuentoModel(
                new Date(System.currentTimeMillis() - 100_000),
                new Date(System.currentTimeMillis() + 1_000_000),
                2,
                0.3F,
                TipoTarjeta.CLARIN_365,
                new ArrayList<>()
        );
    }

    @Test
    public void testAddMovie_Success() {
        controller.altaPelicula(genero, director, duracion, titulo, tipoProyeccion, actores, descuento);

        PeliculaModel pelicula = controller.buscarPelicula(1);
        assertNotNull(pelicula, "La película debería haberse registrado exitosamente.");
        assertEquals(TipoGenero.DRAMA, pelicula.getGeneroID());
    }

    @Test
    public void testAddMovie_Fail_duplicated_movie() {
        controller.altaPelicula(genero, director, duracion, titulo, tipoProyeccion, actores, descuento);

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            controller.altaPelicula(genero, director, duracion, titulo, tipoProyeccion, actores, descuento);
        });

        assertEquals("Esta película ya existe", e.getMessage());
    }
}
