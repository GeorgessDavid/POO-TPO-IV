package org.uade.views;

import org.uade.controller.FuncionController;


import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        peliculaId_lbl = new JLabel("ID de película:");
        peliculaId_lbl.setBounds(120, 30, 100, 20);
        contentPane.add(peliculaId_lbl);

        peliculaId_txt = new JTextField();
        peliculaId_txt.setBounds(210, 30, 60, 20);
        contentPane.add(peliculaId_txt);

        // ---------------- Horario ----------------
        horario_lbl = new JLabel("Horario:");
        horario_lbl.setBounds(120, 60, 100, 20);
        contentPane.add(horario_lbl);

        horario_txt = new JTextField();
        horario_txt.setBounds(210, 60, 80, 20);
        contentPane.add(horario_txt);

        // ---------------- Fecha ----------------
        fecha_lbl = new JLabel("Fecha:");
        fecha_lbl.setBounds(120, 90, 100, 20);
        contentPane.add(fecha_lbl);

        fecha_txt = new JTextField();
        fecha_txt.setBounds(210, 90, 80, 20);
        contentPane.add(fecha_txt);

        // ---------------- SucursalID ----------------
        sucursal_lbl = new JLabel("ID de sucursal:");
        sucursal_lbl.setBounds(120, 120, 100, 20);
        contentPane.add(sucursal_lbl);

        sucursal_txt = new JTextField();
        sucursal_txt.setBounds(210, 120, 60, 20);
        contentPane.add(sucursal_txt);

        // ---------------- SalaID ----------------
        sala_lbl = new JLabel("ID de sala:");
        sala_lbl.setBounds(120, 150, 100, 20);
        contentPane.add(sala_lbl);

        sala_txt = new JTextField();
        sala_txt.setBounds(210, 150, 60, 20);
        contentPane.add(sala_txt);

        /* Botones */
        registrarBtn = new JButton("Registrar");
        registrarBtn.setBounds(120, 190, 100, 30);
        contentPane.add(registrarBtn);

        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBounds(230, 190, 100, 30);
        contentPane.add(cancelarBtn);

        /* Action listeners */
        cancelarBtn.addActionListener(e -> dispose());

        registrarBtn.addActionListener(e -> {
            try {
                String horario = horario_txt.getText();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecha = fecha_txt.getText();
                LocalDate fechaParseada = LocalDate.parse(fecha, formatter);
                Date fechaComoDate = Date.from(fechaParseada.atStartOfDay(ZoneId.systemDefault()).toInstant());

                int sucursalId = Integer.parseInt(sucursal_txt.getText());
                int salaId = Integer.parseInt(sala_txt.getText());
                int peliculaId = Integer.parseInt(peliculaId_txt.getText());

                funcionController.altaFuncion(fechaComoDate, horario, salaId, sucursalId, peliculaId);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error al procesar los datos. Verifique los campos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrarFuncionView::new);
    }

}
