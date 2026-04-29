package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de botón que cambia el texto de una etiqueta.
 *
 * Introduce el concepto de evento: cuando el usuario hace clic,
 * se ejecuta una acción.
 */
public class BotonCambiaTexto {

    private static final String TITULO = "Cambio de texto";
    private static final String TEXTO_INICIAL = "Hola";
    private static final String TEXTO_CAMBIO = "¡Clic hecho!";

    private BotonCambiaTexto() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame(TITULO);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = crearLabel();
        JButton button = crearBoton(label);

        frame.add(label);
        frame.add(button);

        frame.setLocationRelativeTo(null);
        return frame;
    }

    static JLabel crearLabel() {
        return new JLabel(TEXTO_INICIAL);
    }

    static JButton crearBoton(JLabel label) {
        JButton button = new JButton("Cambiar");
        button.addActionListener(e -> cambiarTexto(label));
        return button;
    }

    static void cambiarTexto(JLabel label) {
        label.setText(TEXTO_CAMBIO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}