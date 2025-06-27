package org.uade.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uade.controller.DescuentoController;
import org.uade.controller.FuncionController;
import org.uade.enums.TipoTarjeta;
import org.uade.model.*;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AddFuncionTest {
    private FuncionController controller;

    @BeforeEach
    public void setUp() {
        controller = FuncionController.getInstance();
    }

    @Test
    public void testAddFuncion_Success() {
        Date fecha = new Date();
        int id = 101;
        String horario = "20:00";
        List<Entrada> entradas = new ArrayList<>();
        Sala sala = new Sala(110, "2D", 50);
        CondicionesDescuento descuento = new CondicionesDescuento(new Date(), new Date(), 2, 0.2F, TipoTarjeta.CLARIN_365, new ArrayList<TarjetaDescuento>());
        Pelicula pelicula = new Pelicula(101, TipoGenero.TERROR, "Christopher Nolan", 167, "Interestellar", TipoProyeccion.TRES_D_MAX, new ArrayList<String>(), descuento);

        controller.altaFuncion(fecha, id, horario, entradas, sala, pelicula);

        Funcion funcion = controller.buscarFuncion(id);
        assertNotNull(funcion, "La función debería haberse registrado exitosamente.");

        TipoGenero genero = funcion.getPelicula().getGeneroID();
        assertEquals(TipoGenero.TERROR, genero);
    }

    @Test
    public void testAddFuncion_Fail_InvalidDate() {
        Date fecha = new Date();
        int id = 101;
        String horario = "20:00";
        List<Entrada> entradas = new ArrayList<>();
        Sala sala = new Sala(110, "2D", 50);

        DescuentoController descuentoController = DescuentoController.getInstance();

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            descuentoController.altaDescuento(new Date(System.currentTimeMillis() + 100000), new Date(), 2, 0.2F, TipoTarjeta.CLARIN_365, new ArrayList<TarjetaDescuento>());
        });

//        Pelicula pelicula = new Pelicula(101, TipoGenero.TERROR, "Christopher Nolan", 167, "Interestellar", TipoProyeccion.TRES_D_MAX, new ArrayList<String>(), descuento);

//        controller.altaFuncion(fecha, id, horario, entradas, sala, pelicula);

        assertEquals("La fecha de inicio no puede ser mayor a la fecha de fin.", e.getMessage());
    }
}
