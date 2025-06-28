package org.uade;


import org.uade.controller.PeliculasController;
import org.uade.controller.SucursalController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.SalaModel;
import org.uade.views.MenuPeliculasView;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PeliculasController peliculasController = PeliculasController.getInstance();
        SucursalController sucursalController = SucursalController.getInstance();

        peliculasController.altaPelicula(
                TipoGenero.DRAMA,
                "Michael Bay",
                140,
                "Explosiones 2",
                TipoProyeccion.TRES_D,
                Arrays.asList("Actor A", "Actor B"),
                null
        );

        peliculasController.altaPelicula(
                TipoGenero.TERROR,
                "Woody Allen",
                95,
                "Comedia Ligera",
                TipoProyeccion.DOS_D,
                Arrays.asList("Comediante X", "Actriz Y"),
                null
        );

        SalaModel sala1 = new SalaModel(1, "Sala Principal", 100);
        SalaModel sala2 = new SalaModel(2, "Sala Secundaria", 80);
        List<SalaModel> salasSucursal1 = Arrays.asList(sala1, sala2);

        sucursalController.agregarSucursal("Microcentro", "Av Corrientes 1234", salasSucursal1);

        sucursalController.agregarSala(1, 2, "Sala VIP", 50);

        System.out.println("Películas y sucursales cargadas correctamente.");

        new MenuPeliculasView();
    }
}