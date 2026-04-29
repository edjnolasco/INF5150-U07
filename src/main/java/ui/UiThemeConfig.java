package ui;

import javax.swing.UIManager;

/**
 * Configuración visual adicional para FlatLaf.
 *
 * Centraliza ajustes de bordes, redondeo, espaciado y apariencia
 * para que toda la aplicación mantenga una identidad visual consistente.
 */
public class UiThemeConfig {

    private UiThemeConfig() {
    }

    public static void aplicar() {
        // Bordes redondeados
        UIManager.put("Button.arc", 18);
        UIManager.put("Component.arc", 16);
        UIManager.put("TextComponent.arc", 14);
        UIManager.put("ScrollBar.width", 12);

        // Botones
        UIManager.put("Button.margin", new javax.swing.plaf.InsetsUIResource(8, 14, 8, 14));

        // Campos de texto
        UIManager.put("TextField.margin", new javax.swing.plaf.InsetsUIResource(6, 10, 6, 10));
        UIManager.put("PasswordField.margin", new javax.swing.plaf.InsetsUIResource(6, 10, 6, 10));

        // Tablas
        UIManager.put("Table.rowHeight", 30);
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", false);

        // Paneles y scroll
        UIManager.put("ScrollPane.border", null);
        UIManager.put("Component.focusWidth", 1);
    }
}