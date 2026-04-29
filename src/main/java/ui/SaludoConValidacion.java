package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.ValidadorNombre;

/**
 * Ventana que solicita un nombre y muestra un saludo.
 *
 * Este ejemplo separa la validación de la interfaz gráfica.
 */
public class SaludoConValidacion {

    private SaludoConValidacion() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Saludo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setLayout(new FlowLayout());

        JTextField txtNombre = new JTextField(15);
        JButton btnSaludar = new JButton("Saludar");
        JLabel lblSalida = new JLabel("");

        btnSaludar.addActionListener(e -> manejarSaludo(frame, txtNombre, lblSalida));

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(btnSaludar);
        frame.add(lblSalida);

        frame.setLocationRelativeTo(null);
        return frame;
    }

    static void manejarSaludo(JFrame frame, JTextField txtNombre, JLabel lblSalida) {
        try {
            String resultado = ValidadorNombre.saludar(txtNombre.getText());
            lblSalida.setText(resultado);
        } catch (IllegalArgumentException ex) {
            mostrarError(frame, ex.getMessage());
        }
    }

    static void mostrarError(JFrame frame, String mensaje) {
        JOptionPane.showMessageDialog(
                frame,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}