package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.jupiter.api.Test;

class ExploradorBuilderTest {

    @Test
    void deberiaConstruirNodosPrincipales() {
        DefaultMutableTreeNode root = ExploradorBuilder.construirArbol();

        assertAll(
                () -> assertEquals("Root", root.getUserObject()),
                () -> assertEquals(3, root.getChildCount()),
                () -> assertEquals("Documentos",
                        ((DefaultMutableTreeNode) root.getChildAt(0)).getUserObject()),
                () -> assertEquals("Imágenes",
                        ((DefaultMutableTreeNode) root.getChildAt(1)).getUserObject()),
                () -> assertEquals("Videos",
                        ((DefaultMutableTreeNode) root.getChildAt(2)).getUserObject())
        );
    }
}