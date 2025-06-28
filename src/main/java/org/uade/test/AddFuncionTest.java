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
        String horario = "20:00";
        int id = 1;
        int idSala = 1;
        int idPelicula = 1;
        int idSucursal = 1;

        controller.altaFuncion(fecha, horario, idSala, idSucursal, idPelicula);

        FuncionModel funcion = controller.buscarFuncion(id);
        assertNotNull(funcion, "La función debería haberse registrado exitosamente.");

        TipoGenero genero = funcion.getPelicula().getGeneroID();
        assertEquals(TipoGenero.TERROR, genero);
    }

    @Test
    public void testAddFuncion_Fail_InvalidDate() {
        DescuentoController descuentoController = DescuentoController.getInstance();

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            descuentoController.altaDescuento(
                    new Date(System.currentTimeMillis() + 100_000),
                    new Date(),
                    2,
                    0.2F,
                    TipoTarjeta.CLARIN_365,
                    new ArrayList<>()
            );
        });

        assertEquals("La fecha de inicio no puede ser mayor a la fecha de fin.", e.getMessage());
    }
}