package org.uade.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
- Crear un menú en **Swing** que permita controlar los siguientes casos de uso:
    - Registrar una nueva función por género.
    - Registrar una película por género.
    - Consultar las películas por género.
    - Emitir un reporte de las películas con mayor recaudación.
*/


public class MenuPeliculasView extends JFrame implements ActionListener {
    private final JMenuItem menuItemRegistrarFuncion;
    private final JMenuItem menuItemRegistrarPelicula, menuItemConsultarPeliculas;
    private final JMenuItem menuItemEmitirReportePeliculas;

    public MenuPeliculasView() {
        super("Menu de películas");

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFunciones = new JMenu("Funciones");
        JMenu menuPeliculas = new JMenu("Peliculas");

        menuItemRegistrarFuncion = new JMenuItem("Registrar función");
        menuItemRegistrarFuncion.addActionListener(this);

        menuItemRegistrarPelicula = new JMenuItem("Registrar película");
        menuItemRegistrarPelicula.addActionListener(this);

        menuItemConsultarPeliculas = new JMenuItem("Consultar películas");
        menuItemConsultarPeliculas.addActionListener(this);

        menuItemEmitirReportePeliculas = new JMenuItem("Emitir reporte de películas");
        menuItemEmitirReportePeliculas.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuItemRegistrarFuncion) {
            new RegistrarFuncionView();
        }
        // ...


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPeliculasView::new);
    }
}
