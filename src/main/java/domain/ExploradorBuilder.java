package domain;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Construye la estructura jerárquica utilizada por el explorador.
 *
 * Se separa la creación del árbol para poder probar su estructura sin abrir
 * una ventana Swing.
 */
public class ExploradorBuilder {

    private ExploradorBuilder() {
        // Evita instanciar esta clase de utilidad.
    }

    public static DefaultMutableTreeNode construirArbol() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        root.add(new DefaultMutableTreeNode("Documentos"));
        root.add(new DefaultMutableTreeNode("Imágenes"));
        root.add(new DefaultMutableTreeNode("Videos"));

        return root;
    }
}