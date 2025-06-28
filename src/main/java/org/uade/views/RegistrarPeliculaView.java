package org.uade.views;

import org.uade.controller.PeliculasController;
import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrarPeliculaView extends JFrame {

    private PeliculasController peliculasController = PeliculasController.getInstance();

    private JPanel contentPane;

    private JLabel nombre_lbl, duracion_lbl, director_lbl, actores_lbl, tipo_lbl;
    private JTextField nombre_txt, duracion_txt, director_txt, actores_txt;
    private JComboBox<TipoProyeccion> tipo_cb;

    private JButton registrarBtn, cancelarBtn;

    public RegistrarPeliculaView(TipoGenero genero) {
        setTitle("Registrando película de tipo " + genero);

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 500, 400);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);


        // ---------------- Nombre ----------------
        nombre_lbl = new JLabel("Nombre:");
        nombre_lbl.setBounds(30, 60, 100, 20);
        contentPane.add(nombre_lbl);

        nombre_txt = new JTextField();
        nombre_txt.setBounds(150, 60, 200, 20);
        contentPane.add(nombre_txt);

        // ---------------- Duración ----------------
        duracion_lbl = new JLabel("Duración (min):");
        duracion_lbl.setBounds(30, 90, 100, 20);
        contentPane.add(duracion_lbl);

        duracion_txt = new JTextField();
        duracion_txt.setBounds(150, 90, 200, 20);
        contentPane.add(duracion_txt);

        // ---------------- Director ----------------
        director_lbl = new JLabel("Director:");
        director_lbl.setBounds(30, 120, 100, 20);
        contentPane.add(director_lbl);

        director_txt = new JTextField();
        director_txt.setBounds(150, 120, 200, 20);
        contentPane.add(director_txt);

        // ---------------- Actores ----------------
        actores_lbl = new JLabel("Actores (separados por coma):");
        actores_lbl.setBounds(30, 150, 200, 20);
        contentPane.add(actores_lbl);

        actores_txt = new JTextField();
        actores_txt.setBounds(30, 180, 400, 20);
        contentPane.add(actores_txt);

        // ---------------- Tipo proyección ----------------
        tipo_lbl = new JLabel("Tipo de proyección:");
        tipo_lbl.setBounds(30, 210, 150, 20);
        contentPane.add(tipo_lbl);

        tipo_cb = new JComboBox<>(TipoProyeccion.values());
        tipo_cb.setBounds(180, 210, 200, 20);
        contentPane.add(tipo_cb);

        // ---------------- Botones ----------------
        registrarBtn = new JButton("Registrar");
        registrarBtn.setBounds(100, 270, 100, 30);
        contentPane.add(registrarBtn);

        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBounds(230, 270, 100, 30);
        contentPane.add(cancelarBtn);

        cancelarBtn.addActionListener(e -> dispose());

        registrarBtn.addActionListener(e -> {
            try {
                String nombre = nombre_txt.getText();
                int duracion = Integer.parseInt(duracion_txt.getText());
                String director = director_txt.getText();
                String actoresRaw = actores_txt.getText();
                TipoProyeccion tipo = (TipoProyeccion) tipo_cb.getSelectedItem();

                List<String> actores = new ArrayList<>();
                if (!actoresRaw.isBlank()) {
                    for (String actor : actoresRaw.split(",")) {
                        actores.add(actor.trim());
                    }
                }

                peliculasController.altaPelicula(genero, director, duracion, nombre, tipo, actores, null);
                JOptionPane.showMessageDialog(this, "Película registrada correctamente");
                dispose();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al procesar los datos. Verifique los campos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        TipoGenero genero = TipoGenero.SUSPENSO;

        SwingUtilities.invokeLater(() -> new RegistrarPeliculaView(genero));
    }
}