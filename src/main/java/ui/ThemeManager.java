package ui;

import java.awt.Window;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Administra el tema visual global de la aplicación.
 *
 * Permite alternar entre modo claro y modo oscuro usando FlatLaf.
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

            UiThemeConfig.aplicar();
            refrescarVentanas();

        } catch (Exception e) {
            System.err.println("No se pudo aplicar el tema visual.");
        }
    }

    private static void refrescarVentanas() {
        for (Window window : Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window);
        }
    }
}