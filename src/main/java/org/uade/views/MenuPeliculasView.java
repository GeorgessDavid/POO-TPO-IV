package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;

import javax.swing.*;
import java.util.List;


/*
- Crear un menú en **Swing** que permita controlar los siguientes casos de uso:
    - Registrar una nueva función por género.
    - Registrar una película por género.

    - Consultar las películas por género.
    - Emitir un reporte de las películas con mayor recaudación.
*/


public class MenuPeliculasView extends JFrame {
    private final JMenuItem menuItemRegistrarFuncion;
    private final JMenuItem menuItemRegistrarPelicula, menuItemConsultarPeliculas;
    private final JMenuItem menuItemEmitirReportePeliculas;

    public MenuPeliculasView() {
        super("Menu de películas");

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFunciones = new JMenu("Funciones");
        JMenu menuPeliculas = new JMenu("Peliculas");

        menuItemRegistrarFuncion = new JMenuItem("Registrar función");
        menuItemRegistrarFuncion.addActionListener(e -> new RegistrarFuncionView());

        menuItemRegistrarPelicula = new JMenuItem("Registrar película");

        menuItemConsultarPeliculas = new JMenu("Consultar películas"); // <- Submenú

        TipoGenero[] generos = TipoGenero.values();

        for (TipoGenero genero : generos) {
            JMenuItem generoItem = new JMenuItem(genero.toString());
            menuItemConsultarPeliculas.add(generoItem);

            generoItem.addActionListener(e -> {

                List<PeliculaDTO> peliculas = PeliculasController.getInstance().buscarPeliculaPorGenero(TipoGenero.ROMANCE)
                        .stream()
                        .map(PeliculasController.getInstance()::modelToDto)
                        .toList();

                System.out.println("Consultando películas del género: " + genero);
                new GeneroConsultadoView(genero, peliculas);
            });
        }

        menuItemEmitirReportePeliculas = new JMenuItem("Emitir reporte de películas");
        menuItemEmitirReportePeliculas.addActionListener(e -> new EmitirReportePeliculasView());
        //menuItemEmitirReportePeliculas.addActionListener(this);

        menuFunciones.add(menuItemRegistrarFuncion);

        menuPeliculas.add(menuItemRegistrarPelicula);
        menuPeliculas.add(menuItemConsultarPeliculas);
        menuPeliculas.add(menuItemEmitirReportePeliculas);

        menuBar.add(menuFunciones);
        menuBar.add(menuPeliculas);
        setJMenuBar(menuBar);

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPeliculasView::new);
    }
}
