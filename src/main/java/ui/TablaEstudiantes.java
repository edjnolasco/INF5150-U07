package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import domain.Estudiante;
import domain.EstudianteValidator;

/**
 * Tabla de estudiantes con validación de datos.
 */
public class TablaEstudiantes {

    private TablaEstudiantes() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Notas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        String[] columnas = {"Nombre", "Nota"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(model);

        JPanel panelBottom = new JPanel(new FlowLayout());

        JTextField txtNombre = new JTextField(10);
        JTextField txtNota = new JTextField(3);
        JButton btnAgregar = new JButton("Agregar fila");

        btnAgregar.addActionListener(e ->
                manejarAgregar(frame, model, txtNombre, txtNota)
        );

        panelBottom.add(new JLabel("Nombre:"));
        panelBottom.add(txtNombre);
        panelBottom.add(new JLabel("Nota:"));
        panelBottom.add(txtNota);
        panelBottom.add(btnAgregar);

        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.add(panelBottom, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        return frame;
    }

    static void manejarAgregar(JFrame frame,
                               DefaultTableModel model,
                               JTextField txtNombre,
                               JTextField txtNota) {

        try {
            Estudiante estudiante = EstudianteValidator.crear(
                    txtNombre.getText(),
                    txtNota.getText()
            );

            model.addRow(new Object[] {
                    estudiante.getNombre(),
                    estudiante.getNota()
            });

            txtNombre.setText("");
            txtNota.setText("");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(
                    frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}