package ui;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Utilidad para exportar datos de JTable a archivo CSV.
 *
 * Uso:
 * CsvExporter.exportar(tabla, "archivo.csv");
 */
public class CsvExporter {

    private CsvExporter() {
    }

    public static void exportar(JTable tabla, String rutaArchivo) throws IOException {
        TableModel model = tabla.getModel();

        try (FileWriter writer = new FileWriter(rutaArchivo)) {

            // Encabezados
            for (int i = 0; i < model.getColumnCount(); i++) {
                writer.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    writer.write(",");
                }
            }
            writer.write("\n");

            // Filas
            for (int fila = 0; fila < model.getRowCount(); fila++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object valor = model.getValueAt(fila, col);
                    writer.write(valor != null ? valor.toString() : "");
                    if (col < model.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
        }
    }
}