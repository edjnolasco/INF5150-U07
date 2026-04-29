package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Fábrica para crear ventanas Swing con configuración común.
 */
public class WindowFactory {

    private WindowFactory() {
    }

    public static JFrame crearVentana(String titulo, int ancho, int alto) {
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(ancho, alto);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static JFrame crearLauncher(String titulo, int ancho, int alto) {
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ancho, alto);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        return frame;
    }
}