package ui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import domain.PedidoService;

/**
 * Pedido de comida con selección múltiple usando JCheckBox.
 */
public class PedidoComida {

    private PedidoComida() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Pedido");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new FlowLayout());

        JCheckBox chPizza = new JCheckBox("Pizza");
        JCheckBox chPasta = new JCheckBox("Pasta");
        JCheckBox chEnsalada = new JCheckBox("Ensalada");

        JButton btnResumen = new JButton("Resumen");
        JTextArea area = new JTextArea(5, 20);
        area.setEditable(false);

        btnResumen.addActionListener(e ->
                manejarResumen(area, chPizza, chPasta, chEnsalada)
        );

        frame.add(chPizza);
        frame.add(chPasta);
        frame.add(chEnsalada);
        frame.add(btnResumen);
        frame.add(new JScrollPane(area));

        frame.setLocationRelativeTo(null);
        return frame;
    }

    static void manejarResumen(JTextArea area,
                               JCheckBox chPizza,
                               JCheckBox chPasta,
                               JCheckBox chEnsalada) {

        List<String> seleccionados = new ArrayList<>();

        if (chPizza.isSelected()) {
            seleccionados.add("Pizza");
        }

        if (chPasta.isSelected()) {
            seleccionados.add("Pasta");
        }

        if (chEnsalada.isSelected()) {
            seleccionados.add("Ensalada");
        }

        area.setText(PedidoService.generarResumen(seleccionados));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}