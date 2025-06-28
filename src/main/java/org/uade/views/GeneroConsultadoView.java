package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.dto.PeliculaDTO;
import org.uade.enums.TipoGenero;
import org.uade.model.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GeneroConsultadoView extends JFrame {
    private final JTable tablaPeliculas;
    private final DefaultTableModel modeloTabla;

    public GeneroConsultadoView(TipoGenero genero, PeliculaDTO[] peliculas) {
        super("Películas del genéro " + genero.toString());

        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[] { "ID", "Nombre", "Duración (en minutos)", "Director", "Actores", "Proyección", "Condición de descuento" });

        for (PeliculaDTO pelicula : peliculas) {
            Object[] fila = new Object[] {
                    pelicula.getId(),
                    pelicula.getNombrePelicula(),
                    pelicula.getDuracionEnMinutos(),
                    pelicula.getDirector(),
                    pelicula.getActores(),
                    pelicula.getTipo(),
                    pelicula.getCondicionesDescuento()
            };

            modeloTabla.addRow(fila);
        }

        tablaPeliculas = new JTable(modeloTabla);
        tablaPeliculas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(tablaPeliculas);
        add(scrollPane, BorderLayout.CENTER);

        setSize(600, 400);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        List<Pelicula> peliculas = PeliculasController.getInstance().buscarPeliculaPorGenero(TipoGenero.ROMANCE);
        PeliculaDTO[] peliculasDtos = peliculas.stream()
                .map(PeliculasController.getInstance()::modelToDto)
                .toArray(PeliculaDTO[]::new);

        GeneroConsultadoView tabla = new GeneroConsultadoView(TipoGenero.ROMANCE, peliculasDtos);

        tabla.setVisible(true);
    }

}
