package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;

import javax.swing.*;
import java.util.List;


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

        menuItemRegistrarPelicula = new JMenu("Registrar película");
        menuItemConsultarPeliculas = new JMenu("Consultar películas");

        TipoGenero[] generos = TipoGenero.values();

        for (TipoGenero genero : generos) {
            JMenuItem itemRegistrar = new JMenuItem(genero.toString());
            itemRegistrar.addActionListener(e -> onRegistrarPeliculaPorGenero(genero));
            menuItemRegistrarPelicula.add(itemRegistrar);

            JMenuItem itemConsultar = new JMenuItem(genero.toString());
            itemConsultar.addActionListener(e -> onConsultarPeliculasPorGenero(genero));
            menuItemConsultarPeliculas.add(itemConsultar);
        }

        menuItemEmitirReportePeliculas = new JMenuItem("Emitir reporte de películas");
        menuItemEmitirReportePeliculas.addActionListener(e -> new EmitirReportePeliculasView());

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


    private void onRegistrarPeliculaPorGenero(TipoGenero genero) {
        System.out.println("Registrando película del género: " + genero);
        new RegistrarPeliculaView(genero);
    }

    private void onConsultarPeliculasPorGenero(TipoGenero genero) {
        List<PeliculaDTO> peliculas = PeliculasController.getInstance()
                .buscarPeliculaPorGenero(genero)
                .stream()
                .map(PeliculasController.getInstance()::modelToDto)
                .toList();

        System.out.println("Consultando películas del género: " + genero);
        new GeneroConsultadoView(genero, peliculas);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPeliculasView::new);
    }
}
