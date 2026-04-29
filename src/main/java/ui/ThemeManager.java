package ui;

import java.awt.Window;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Administra el tema visual global de la aplicación.
 */
public class ThemeManager {

    private static boolean darkMode = false;

    private ThemeManager() {
    }

    public static void aplicarTemaClaro() {
        aplicarTema(false);
    }

    public static void aplicarTemaOscuro() {
        aplicarTema(true);
    }

    public static void alternarTema() {
        aplicarTema(!darkMode);
    }

    public static boolean isDarkMode() {
        return darkMode;
    }

    private static void aplicarTema(boolean oscuro) {
        try {
            darkMode = oscuro;

            if (oscuro) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            aplicarAjustesComunes();
            refrescarVentanas();

        } catch (Exception e) {
            System.err.println("No se pudo aplicar el tema visual.");
        }
    }

    private static void aplicarAjustesComunes() {
        UIManager.put("Button.arc", 18);
        UIManager.put("Component.arc", 18);
        UIManager.put("TextComponent.arc", 14);
        UIManager.put("ScrollBar.width", 12);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.rowHeight", 28);
    }
    
    private static void refrescarVentanas() {
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }
}