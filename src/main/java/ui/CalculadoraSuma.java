package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.Calculadora;
import domain.ParserNumerico;

/**
 * Calculadora sencilla que suma dos valores numéricos.
 *
 * La interfaz obtiene datos; la lógica de suma vive en la capa domain.
 */
public class CalculadoraSuma {

    private CalculadoraSuma() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Calculadora Sencilla");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JTextField txtA = new JTextField();
        JTextField txtB = new JTextField();
        JLabel lblResultado = new JLabel("Resultado: ");
        JButton btnSumar = new JButton("Sumar");

        btnSumar.addActionListener(e -> manejarSuma(frame, txtA, txtB, lblResultado));

        panel.add(new JLabel("Número A:"));
        panel.add(txtA);

        panel.add(new JLabel("Número B:"));
        panel.add(txtB);

        panel.add(btnSumar);
        panel.add(new JLabel(""));

        panel.add(lblResultado);

        frame.add(panel);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    static void manejarSuma(JFrame frame, JTextField txtA, JTextField txtB, JLabel lblResultado) {
        try {
            double a = ParserNumerico.parse(txtA.getText());
            double b = ParserNumerico.parse(txtB.getText());
            double resultado = Calculadora.sumar(a, b);

            lblResultado.setText("Resultado: " + resultado);
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