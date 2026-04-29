package ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import domain.ExploradorBuilder;

/**
 * Explorador simple con JTree y área de detalle.
 */
public class ExploradorSimple {

    private ExploradorSimple() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Explorador");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);

        DefaultMutableTreeNode root = ExploradorBuilder.construirArbol();

        JTree tree = new JTree(root);
        JTextArea area = new JTextArea();
        area.setEditable(false);

        tree.addTreeSelectionListener(e -> manejarSeleccion(tree, area));

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(tree),
                new JScrollPane(area)
        );

        split.setDividerLocation(150);

        frame.add(split);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    static void manejarSeleccion(JTree tree, JTextArea area) {
        Object selected = tree.getLastSelectedPathComponent();

        if (selected instanceof DefaultMutableTreeNode nodo) {
            area.setText("Seleccionaste: " + nodo.getUserObject());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}