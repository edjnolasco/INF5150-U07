package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.ValidadorNombre;

/**
 * Ventana que solicita un nombre y muestra un saludo.
 */
public class SaludoConValidacion {

    private SaludoConValidacion() {
    }

    public static JFrame crearVentana() {
        JFrame frame = WindowFactory.crearVentana("Saludo", 380, 170);

        JTextField txtNombre = UiFactory.textField(15);
        JButton btnSaludar = UiFactory.botonPrincipal("Saludar");
        JLabel lblSalida = UiFactory.label("");

        btnSaludar.addActionListener(e -> manejarSaludo(frame, txtNombre, lblSalida));

        JPanel panel = UiFactory.panel(new FlowLayout());
        panel.add(UiFactory.label("Nombre:"));
        panel.add(txtNombre);
        panel.add(btnSaludar);
        panel.add(lblSalida);

        frame.add(panel);
        frame.getRootPane().setDefaultButton(btnSaludar);

        SwingUtilities.invokeLater(txtNombre::requestFocusInWindow);

        return frame;
    }

    static void manejarSaludo(JFrame frame, JTextField txtNombre, JLabel lblSalida) {
        try {
            lblSalida.setText(ValidadorNombre.saludar(txtNombre.getText()));
        } catch (IllegalArgumentException ex) {
            UiFactory.mostrarError(frame, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            crearVentana().setVisible(true);
        });
    }
}