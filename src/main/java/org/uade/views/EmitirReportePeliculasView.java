package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.controller.VentasController;
import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmitirReportePeliculasView extends JFrame {
    private PeliculasController peliculasController = PeliculasController.getInstance();

    private final JTable tablaPeliculas;
    private final DefaultTableModel modeloTabla;

    public EmitirReportePeliculasView() {
        super("Películas con mayor recaudación");

        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[] { "ID", "Nombre", "Recaudación" });


        for (PeliculaDTO pelicula : peliculasController.getPeliculas()) {
            Object[] fila = new Object[] {
                    pelicula.getId(),
                    pelicula.getNombrePelicula(),
                    VentasController.getInstance().recaudacionPorPelicula(pelicula.getId())
            };

            modeloTabla.addRow(fila);
        }

        tablaPeliculas = new JTable(modeloTabla);
        tablaPeliculas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(tablaPeliculas);
        add(scrollPane, BorderLayout.CENTER);

        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new EmitirReportePeliculasView();
    }

}
