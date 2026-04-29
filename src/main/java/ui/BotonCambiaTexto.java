package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de botón que cambia el texto de una etiqueta.
 */
public class BotonCambiaTexto {

    private static final String TITULO = "Cambio de texto";
    private static final String TEXTO_INICIAL = "Hola";
    private static final String TEXTO_CAMBIO = "¡Clic hecho!";

    private BotonCambiaTexto() {
    }

    public static JFrame crearVentana() {
        JFrame frame = WindowFactory.crearVentana(TITULO, 320, 160);

        JLabel label = UiFactory.label(TEXTO_INICIAL);
        JButton button = UiFactory.botonPrincipal("Cambiar");

        button.addActionListener(e -> cambiarTexto(label));

        JPanel panel = UiFactory.panel(new FlowLayout());
        panel.add(label);
        panel.add(button);

        frame.add(panel);

        return frame;
    }

    static void cambiarTexto(JLabel label) {
        label.setText(TEXTO_CAMBIO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            crearVentana().setVisible(true);
        });
    }
}