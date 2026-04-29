package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import domain.ColorService;

/**
 * Selector de color usando JComboBox.
 */
public class SelectorColor {

    private SelectorColor() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Selector de color");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        String[] colores = {"Rojo", "Verde", "Azul"};
        JComboBox<String> combo = new JComboBox<>(colores);

        JPanel panelColor = new JPanel();
        panelColor.setPreferredSize(new Dimension(100, 100));
        panelColor.setBackground(Color.RED);

        combo.addActionListener(e -> manejarSeleccion(combo, panelColor));

        frame.add(combo);
        frame.add(panelColor);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    static void manejarSeleccion(JComboBox<String> combo, JPanel panelColor) {
        String seleccion = (String) combo.getSelectedItem();

        try {
            panelColor.setBackground(ColorService.obtenerColor(seleccion));
        } catch (IllegalArgumentException ex) {
            panelColor.setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}