package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Ejemplo de JTable con exportación a CSV.
 */
public class TablaEstudiantes {

    private TablaEstudiantes() {
    }

    public static JFrame crearVentana() {
        JFrame frame = WindowFactory.crearVentana("Tabla de Estudiantes", 600, 400);

        String[] columnas = {"Nombre", "Edad"};

        DefaultTableModel model = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla = new JTable(model);

        // Configuración visual
        tabla.setRowHeight(28);
        tabla.setAutoCreateRowSorter(true);

        JScrollPane scroll = new JScrollPane(tabla);

        // Botones
        JButton btnAgregar = UiFactory.boton("Agregar");
        JButton btnExportar = UiFactory.botonPrincipal("Exportar CSV");

        btnAgregar.addActionListener(e -> {
            model.addRow(new Object[]{"Nuevo Estudiante", 20});
        });

        btnExportar.addActionListener(e -> exportar(frame, tabla));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnExportar);

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);

        return frame;
    }

    private static void exportar(JFrame frame, JTable tabla) {
        try {
            CsvExporter.exportar(tabla, "estudiantes.csv");
            UiFactory.mostrarInfo(frame, "Archivo exportado: estudiantes.csv");
        } catch (Exception ex) {
            UiFactory.mostrarError(frame, "Error al exportar: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            crearVentana().setVisible(true);
        });
    }
}