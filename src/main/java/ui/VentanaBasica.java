package ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Ventana básica creada con JFrame.
 *
 * Este primer ejemplo muestra la estructura mínima de una ventana Swing.
 */
public class VentanaBasica {

    private static final String TITULO = "Mi Primera Ventana";
    private static final int ANCHO = 1000;
    private static final int ALTO = 900;

    private VentanaBasica() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame(TITULO);
        frame.setSize(ANCHO, ALTO);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}