package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import domain.Producto;
import domain.ProductoValidator;

/**
 * Mini CRUD de productos con exportación a CSV.
 *
 * Introduce:
 * - JTable
 * - Agregar, editar y eliminar registros
 * - Validación desacoplada
 * - Exportación de datos a CSV
 */
public class InventarioApp {

    private final Set<String> idsUsados = new HashSet<>();
    private final DefaultTableModel model;
    private final JTable tabla;
    private final JFrame frame;

    public InventarioApp() {
        frame = WindowFactory.crearVentana("Inventario", 560, 340);

        model = new DefaultTableModel(new String[] {"ID", "Nombre", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(model);
        tabla.setRowHeight(28);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setAutoCreateRowSorter(true);
    }

    public JFrame crearVentana() {
        frame.setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton btnAgregar = UiFactory.boton("Agregar");
        JButton btnEditar = UiFactory.boton("Editar");
        JButton btnEliminar = UiFactory.boton("Eliminar");
        JButton btnExportar = UiFactory.botonPrincipal("Exportar CSV");

        btnAgregar.addActionListener(e -> agregarProducto());
        btnEditar.addActionListener(e -> editarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnExportar.addActionListener(e -> exportarInventario());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnExportar);

        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);

        return frame;
    }

    private void agregarProducto() {
        Producto producto = mostrarDialogoProducto(null, null, null);

        if (producto == null) {
            return;
        }

        if (idsUsados.contains(producto.getId())) {
            UiFactory.mostrarError(frame, "ID ya existe");
            return;
        }

        idsUsados.add(producto.getId());

        model.addRow(new Object[] {
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio()
        });
    }

    private void editarProducto() {
        int row = tabla.getSelectedRow();

        if (row == -1) {
            UiFactory.mostrarError(frame, "Selecciona una fila");
            return;
        }

        int modelRow = tabla.convertRowIndexToModel(row);

        String idActual = (String) model.getValueAt(modelRow, 0);
        String nombreActual = (String) model.getValueAt(modelRow, 1);
        String precioActual = model.getValueAt(modelRow, 2).toString();

        Producto producto = mostrarDialogoProducto(idActual, nombreActual, precioActual);

        if (producto == null) {
            return;
        }

        if (!producto.getId().equals(idActual) && idsUsados.contains(producto.getId())) {
            UiFactory.mostrarError(frame, "ID ya existe");
            return;
        }

        idsUsados.remove(idActual);
        idsUsados.add(producto.getId());

        model.setValueAt(producto.getId(), modelRow, 0);
        model.setValueAt(producto.getNombre(), modelRow, 1);
        model.setValueAt(producto.getPrecio(), modelRow, 2);
    }

    private void eliminarProducto() {
        int row = tabla.getSelectedRow();

        if (row == -1) {
            UiFactory.mostrarError(frame, "Selecciona una fila");
            return;
        }

        int modelRow = tabla.convertRowIndexToModel(row);

        String id = (String) model.getValueAt(modelRow, 0);
        idsUsados.remove(id);
        model.removeRow(modelRow);
    }

    private void exportarInventario() {
        try {
            CsvExporter.exportar(tabla, "inventario.csv");
            UiFactory.mostrarInfo(frame, "Inventario exportado correctamente: inventario.csv");
        } catch (Exception ex) {
            UiFactory.mostrarError(frame, "Error al exportar inventario: " + ex.getMessage());
        }
    }

    private Producto mostrarDialogoProducto(String idInit, String nombreInit, String precioInit) {
        JTextField txtId = UiFactory.textField(10);
        JTextField txtNombre = UiFactory.textField(10);
        JTextField txtPrecio = UiFactory.textField(10);

        txtId.setText(idInit == null ? "" : idInit);
        txtNombre.setText(nombreInit == null ? "" : nombreInit);
        txtPrecio.setText(precioInit == null ? "" : precioInit);

        JPanel panel = UiFactory.panel(new GridLayout(3, 2, 8, 8));
        panel.add(UiFactory.label("ID:"));
        panel.add(txtId);
        panel.add(UiFactory.label("Nombre:"));
        panel.add(txtNombre);
        panel.add(UiFactory.label("Precio:"));
        panel.add(txtPrecio);

        int opcion = JOptionPane.showConfirmDialog(
                frame,
                panel,
                "Producto",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (opcion != JOptionPane.OK_OPTION) {
            return null;
        }

        try {
            return ProductoValidator.crear(
                    txtId.getText(),
                    txtNombre.getText(),
                    txtPrecio.getText()
            );
        } catch (IllegalArgumentException ex) {
            UiFactory.mostrarError(frame, ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            new InventarioApp().crearVentana().setVisible(true);
        });
    }
}