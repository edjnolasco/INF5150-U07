package ui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.CalculadoraPropinaService;

/**
 * Calculadora de propina.
 *
 * Introduce JRadioButton para seleccionar una opción entre varias.
 */
public class CalculadoraPropina {

    private CalculadoraPropina() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Propina");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new GridLayout(7, 1));

        JTextField txtMonto = new JTextField();

        JRadioButton r10 = new JRadioButton("10%", true);
        JRadioButton r15 = new JRadioButton("15%");
        JRadioButton r20 = new JRadioButton("20%");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(r10);
        grupo.add(r15);
        grupo.add(r20);

        JLabel lblTotal = new JLabel("Total: ");
        JButton btnCalc = new JButton("Calcular");

        btnCalc.addActionListener(e ->
                manejarCalculo(frame, txtMonto, r10, r15, r20, lblTotal)
        );

        frame.add(new JLabel("Monto consumo:"));
        frame.add(txtMonto);
        frame.add(r10);
        frame.add(r15);
        frame.add(r20);
        frame.add(btnCalc);
        frame.add(lblTotal);

        frame.setLocationRelativeTo(null);
        return frame;
    }

    static void manejarCalculo(JFrame frame,
                               JTextField txtMonto,
                               JRadioButton r10,
                               JRadioButton r15,
                               JRadioButton r20,
                               JLabel lblTotal) {

        try {
            double monto = Double.parseDouble(txtMonto.getText().trim());

            double porcentaje = obtenerPorcentajeSeleccionado(r10, r15, r20);
            double total = CalculadoraPropinaService.calcularTotal(monto, porcentaje);

            lblTotal.setText(String.format("Total: %.2f", total));
        } catch (NumberFormatException ex) {
            mostrarError(frame, "Monto inválido.");
        } catch (IllegalArgumentException ex) {
            mostrarError(frame, ex.getMessage());
        }
    }

    private static double obtenerPorcentajeSeleccionado(JRadioButton r10,
                                                        JRadioButton r15,
                                                        JRadioButton r20) {
        if (r10.isSelected()) {
            return 0.10;
        }

        if (r15.isSelected()) {
            return 0.15;
        }

        if (r20.isSelected()) {
            return 0.20;
        }

        return 0.10;
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