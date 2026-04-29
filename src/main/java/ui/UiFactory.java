package ui;

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
 * Centraliza estilos básicos para mantener consistencia visual
 * entre todos los ejercicios.
 */
public class UiFactory {

    private UiFactory() {
    }

    public static JPanel panel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        return panel;
    }

    public static JPanel panelSinBorde(LayoutManager layout) {
        return new JPanel(layout);
    }

    public static JLabel titulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
        return label;
    }

    public static JLabel label(String texto) {
        return new JLabel(texto);
    }

    public static JTextField textField(int columnas) {
        return new JTextField(columnas);
    }

    public static JButton boton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        return boton;
    }

    public static JButton botonPrincipal(String texto) {
        JButton boton = boton(texto);
        boton.setFont(boton.getFont().deriveFont(Font.BOLD));
        return boton;
    }

    public static void mostrarError(java.awt.Component parent, String mensaje) {
        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void mostrarInfo(java.awt.Component parent, String mensaje) {
        JOptionPane.showMessageDialog(
                parent,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}