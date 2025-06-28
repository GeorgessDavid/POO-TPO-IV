package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GeneroConsultadoView extends JFrame {
    private final JTable tablaPeliculas;
    private final DefaultTableModel modeloTabla;

    public GeneroConsultadoView(TipoGenero genero, List<PeliculaDTO> peliculas) {
        super("Películas del genéro " + genero.toString());

        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[] { "ID", "Nombre", "Duración (en minutos)", "Director", "Actores", "Proyección" });

        for (PeliculaDTO pelicula : peliculas) {
            Object[] fila = new Object[] {
                    pelicula.getId(),
                    pelicula.getNombrePelicula(),
                    pelicula.getDuracionEnMinutos(),
                    pelicula.getDirector(),
                    pelicula.getActores(),
                    pelicula.getTipo(),
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

        List<PeliculaDTO> peliculas = PeliculasController.getInstance().buscarPeliculaPorGenero(TipoGenero.ROMANCE)
                .stream()
                .map(PeliculasController.getInstance()::modelToDto)
                .toList();

        GeneroConsultadoView tabla = new GeneroConsultadoView(TipoGenero.ROMANCE, peliculas);
    }

}
