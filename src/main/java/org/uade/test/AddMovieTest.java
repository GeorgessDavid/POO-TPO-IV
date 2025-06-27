package org.uade.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uade.controller.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.enums.TipoTarjeta;
import org.uade.model.CondicionesDescuento;
import org.uade.model.Pelicula;
import org.uade.model.TarjetaDescuento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class AddMovieTest {
    private PeliculasController controller;

    @BeforeEach
    public void setUp() {
        controller = PeliculasController.getInstance();
//        Vaciamos el listado de películas para correr todos los tests.
        controller.reset();
    }

    @Test
    public void testAddMovie_Success() {
        int id = 105;
        TipoGenero genero = TipoGenero.DRAMA;
        String director = "Christopher Nolan";
        int duracion = 174;
        String titulo = "Tenet";
        TipoProyeccion tipoProyeccion = TipoProyeccion.TRES_D;
        List<String> actores = new ArrayList<>();
        CondicionesDescuento descuento = new CondicionesDescuento(new Date(), new Date(), 2, 0.3F, TipoTarjeta.CLARIN_365, new ArrayList<TarjetaDescuento>());

        controller.altaPelicula(id, genero, director, duracion, titulo, tipoProyeccion, actores, descuento);

        Pelicula pelicula = controller.buscarPelicula(id);
        assertNotNull(pelicula, "La pelicula debería haberse registrado exitosamente.");

        TipoGenero genre = pelicula.getGeneroID();
        assertEquals(TipoGenero.DRAMA, genre);
    }

    @Test
    public void testAddMovie_Fail_duplicated_movie() {
        int id = 105;
        TipoGenero genero = TipoGenero.DRAMA;
        String director = "Christopher Nolan";
        int duracion = 174;
        String titulo = "Tenet";
        TipoProyeccion tipoProyeccion = TipoProyeccion.TRES_D;
        List<String> actores = new ArrayList<>();
        CondicionesDescuento descuento = new CondicionesDescuento(new Date(), new Date(), 2, 0.3F, TipoTarjeta.CLARIN_365, new ArrayList<TarjetaDescuento>());

//        Agregamos la película.
        controller.altaPelicula(id, genero, director, duracion, titulo, tipoProyeccion, actores, descuento);
//          Se intenta agragar nuevamente la película.
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            controller.altaPelicula(id, genero, director, duracion, titulo, tipoProyeccion, actores, descuento);
        });

        assertEquals("Esta pelicula ya existe", e.getMessage());
    }
}
