package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import domain.Producto;
import domain.ProductoValidator;

/**
 * Mini CRUD de productos.
 *
 * Introduce JTable, botones de acción y validación desacoplada.
 */
public class InventarioApp {

    private final Set<String> idsUsados = new HashSet<>();
    private final DefaultTableModel model;
    private final JTable tabla;
    private final JFrame frame;

    public InventarioApp() {
        frame = new JFrame("Inventario");
        model = new DefaultTableModel(new String[] {"ID", "Nombre", "Precio"}, 0);
        tabla = new JTable(model);
    }

    public JFrame crearVentana() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new FlowLayout());

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        btnAgregar.addActionListener(e -> agregarProducto());
        btnEditar.addActionListener(e -> editarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    private void agregarProducto() {
        Producto producto = mostrarDialogoProducto(null, null, null);

        if (producto == null) {
            return;
        }

        if (idsUsados.contains(producto.getId())) {
            mostrarError("ID ya existe");
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
            mostrarError("Selecciona una fila");
            return;
        }

        String idActual = (String) model.getValueAt(row, 0);
        String nombreActual = (String) model.getValueAt(row, 1);
        String precioActual = model.getValueAt(row, 2).toString();

        Producto producto = mostrarDialogoProducto(idActual, nombreActual, precioActual);

        if (producto == null) {
            return;
        }

        if (!producto.getId().equals(idActual) && idsUsados.contains(producto.getId())) {
            mostrarError("ID ya existe");
            return;
        }

        idsUsados.remove(idActual);
        idsUsados.add(producto.getId());

        model.setValueAt(producto.getId(), row, 0);
        model.setValueAt(producto.getNombre(), row, 1);
        model.setValueAt(producto.getPrecio(), row, 2);
    }

    private void eliminarProducto() {
        int row = tabla.getSelectedRow();

        if (row == -1) {
            mostrarError("Selecciona una fila");
            return;
        }

        String id = (String) model.getValueAt(row, 0);
        idsUsados.remove(id);
        model.removeRow(row);
    }

    private Producto mostrarDialogoProducto(String idInit, String nombreInit, String precioInit) {
        JTextField txtId = new JTextField(idInit == null ? "" : idInit, 10);
        JTextField txtNombre = new JTextField(nombreInit == null ? "" : nombreInit, 10);
        JTextField txtPrecio = new JTextField(precioInit == null ? "" : precioInit, 10);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Precio:"));
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
            mostrarError(ex.getMessage());
            return null;
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                frame,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventarioApp().crearVentana().setVisible(true));
    }
}