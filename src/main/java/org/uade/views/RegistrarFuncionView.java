package org.uade.views;

/*
private final Pelicula pelicula;
    private final int funcionID;
    private final String horario;
    private final Date fecha;
    private final List<Entrada> entradas;
    private final Sala sala;
*/


import org.uade.controller.FuncionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarFuncionView extends JFrame {
    private FuncionController funcionController = FuncionController.getInstance();

    private JPanel contentPane;

    private JLabel peliculaId_lbl, horario_lbl, fecha_lbl, sucursal_lbl, sala_lbl;
    private JTextField peliculaId_txt, horario_txt, fecha_txt, sucursal_txt, sala_txt;

    private JButton registrarBtn, cancelarBtn;

    public RegistrarFuncionView() {
        setTitle("Registrar función");

        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // ---------------- PeliculaID ----------------
        peliculaId_lbl = new JLabel("ID de la película:");
        peliculaId_lbl.setBounds(30, 30, 100, 20);
        contentPane.add(peliculaId_lbl);

        peliculaId_txt = new JTextField();
        peliculaId_txt.setBounds(130, 30, 200, 20);
        contentPane.add(peliculaId_txt);

        // ---------------- Horario ----------------
        horario_lbl = new JLabel("Horario:");
        horario_lbl.setBounds(30, 60, 100, 20);
        contentPane.add(horario_lbl);

        horario_txt = new JTextField();
        horario_txt.setBounds(130, 60, 200, 20);
        contentPane.add(horario_txt);

        // ---------------- Fecha ----------------
        fecha_lbl = new JLabel("Fecha:");
        fecha_lbl.setBounds(30, 90, 100, 20);
        contentPane.add(fecha_lbl);

        fecha_txt = new JTextField();
        fecha_txt.setBounds(130, 90, 200, 20);
        contentPane.add(fecha_txt);

        // ---------------- SucursalID ----------------
        sucursal_lbl = new JLabel("ID de la sucursal:");
        sucursal_lbl.setBounds(30, 120, 100, 20);
        contentPane.add(sucursal_lbl);

        sucursal_txt = new JTextField();
        sucursal_txt.setBounds(130, 120, 200, 20);
        contentPane.add(sucursal_txt);

        // ---------------- SalaID ----------------
        sala_lbl = new JLabel("ID de la sala:");
        sala_lbl.setBounds(30, 120, 100, 20);
        contentPane.add(sala_lbl);

        sala_txt = new JTextField();
        sala_txt.setBounds(130, 120, 60, 20);
        contentPane.add(sala_txt);

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        /* Botones */
        registrarBtn = new JButton("Registrar");
        registrarBtn.setBounds(100, 190, 100, 30);
        contentPane.add(registrarBtn);

        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBounds(230, 190, 100, 30);
        contentPane.add(cancelarBtn);

        /* Action listeners */
        cancelarBtn.addActionListener(e -> dispose());

        registrarBtn.addActionListener(e -> {
            try {

                int peliculaId = Integer.parseInt(peliculaId_txt.getText());
                String horario = horario_txt.getText();
                String fecha = fecha_txt.getText();
                int sucursalId = Integer.parseInt(sucursal_txt.getText());
                int salaId = Integer.parseInt(sala_txt.getText());

                funcionController.altaFuncion();
                if (funcionController.)


            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al procesar los datos. Verifique los campos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrarFuncionView::new);
    }

}
