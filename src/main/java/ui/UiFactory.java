package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Fábrica de componentes Swing reutilizables.
 *
 * Centraliza estilos visuales y reduce repetición en la UI.
 * Permite mantener consistencia en todas las ventanas.
 */
public class UiFactory {

    private static final String FONT_NAME = "Segoe UI";
    private static final int FONT_SIZE = 14;

    private UiFactory() {
    }

    /**
     * Panel con padding estándar.
     */
    public static JPanel panel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        return panel;
    }

    /**
     * Panel sin borde (para layouts internos).
     */
    public static JPanel panelSinBorde(LayoutManager layout) {
        return new JPanel(layout);
    }

    /**
     * Label estándar.
     */
    public static JLabel label(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        return label;
    }

    /**
     * Label tipo título.
     */
    public static JLabel titulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font(FONT_NAME, Font.BOLD, 20));
        return label;
    }

    /**
     * Campo de texto estándar.
     */
    public static JTextField textField(int columnas) {
        JTextField field = new JTextField(columnas);
        field.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        return field;
    }

    /**
     * Botón estándar.
     */
    public static JButton boton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(120, 32));
        return boton;
    }

    /**
     * Botón principal (acción destacada).
     */
    public static JButton botonPrincipal(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(140, 36));
        return boton;
    }

    /**
     * Mostrar mensaje de error.
     */
    public static void mostrarError(Component parent, String mensaje) {
        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * Mostrar mensaje informativo.
     */
    public static void mostrarInfo(Component parent, String mensaje) {
        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}