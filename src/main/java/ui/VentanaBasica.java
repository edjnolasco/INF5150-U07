package ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Ventana básica creada con JFrame.
 */
public class VentanaBasica {

    private static final String TITULO = "Mi Primera Ventana";
    private static final int ANCHO = 1000;
    private static final int ALTO = 900;

    private VentanaBasica() {
    }

    public static JFrame crearVentana() {
        return WindowFactory.crearVentana(TITULO, ANCHO, ALTO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            crearVentana().setVisible(true);
        });
    }
}