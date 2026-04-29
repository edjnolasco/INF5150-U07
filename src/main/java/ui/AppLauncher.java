package ui;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * Dashboard principal de la Unidad 07.
 *
 * Presenta todos los ejercicios Swing como un panel demostrativo moderno.
 */
public class AppLauncher {

    private static final String REPO_URL = "https://github.com/edjnolasco/INF5150-U07";

    private AppLauncher() {
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("INF5150-U07 | Swing Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(760, 680);
        frame.setLayout(new BorderLayout());

        frame.add(crearHeader(), BorderLayout.NORTH);
        frame.add(crearContenido(), BorderLayout.CENTER);
        frame.add(crearFooter(), BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static JPanel crearHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(24, 28, 16, 28));

        JLabel titulo = new JLabel("INF5150 - Unidad 07");
        titulo.setFont(titulo.getFont().deriveFont(28f));

        JLabel subtitulo = new JLabel(
                "Interfaces gráficas en Java Swing con arquitectura, pruebas unitarias y UI moderna"
        );
        subtitulo.setFont(subtitulo.getFont().deriveFont(14f));

        JPanel textos = new JPanel(new GridLayout(2, 1, 0, 6));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);

        header.add(textos, BorderLayout.CENTER);
        return header;
    }

    private static JScrollPane crearContenido() {
        JPanel grid = new JPanel(new GridLayout(0, 2, 14, 14));
        grid.setBorder(BorderFactory.createEmptyBorder(12, 28, 12, 28));

        grid.add(crearCard("🪟", "UT01", "Ventana básica",
                "JFrame, tamaño, posición y cierre",
                () -> VentanaBasica.crearVentana().setVisible(true)));

        grid.add(crearCard("🖱️", "UT02", "Botón cambia texto",
                "Eventos con JButton y JLabel",
                () -> BotonCambiaTexto.crearVentana().setVisible(true)));

        grid.add(crearCard("👤", "UT03", "Saludo con validación",
                "JTextField, validación y JOptionPane",
                () -> SaludoConValidacion.crearVentana().setVisible(true)));

        grid.add(crearCard("➕", "UT04", "Calculadora de suma",
                "Parsing numérico y lógica desacoplada",
                () -> CalculadoraSuma.crearVentana().setVisible(true)));

        grid.add(crearCard("📦", "UT05", "Inventario CRUD",
                "JTable, altas, edición y eliminación",
                () -> new InventarioApp().crearVentana().setVisible(true)));

        grid.add(crearCard("🔐", "UT06", "Login con CardLayout",
                "Navegación entre pantallas",
                () -> LoginCardLayout.crearVentana().setVisible(true)));

        grid.add(crearCard("🌳", "UT07", "Explorador simple",
                "JTree, selección y JSplitPane",
                () -> ExploradorSimple.crearVentana().setVisible(true)));

        grid.add(crearCard("💰", "UT08", "Calculadora de propina",
                "JRadioButton y selección única",
                () -> CalculadoraPropina.crearVentana().setVisible(true)));

        grid.add(crearCard("🍽️", "UT09", "Pedido de comida",
                "JCheckBox y selección múltiple",
                () -> PedidoComida.crearVentana().setVisible(true)));

        grid.add(crearCard("🎨", "UT10", "Selector de color",
                "JComboBox y mapeo de dominio",
                () -> SelectorColor.crearVentana().setVisible(true)));

        grid.add(crearCard("📊", "UT11", "Tabla de estudiantes",
                "JTable, DefaultTableModel y validación",
                () -> TablaEstudiantes.crearVentana().setVisible(true)));

        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    private static JButton crearCard(String icono,
                                     String unidad,
                                     String titulo,
                                     String descripcion,
                                     Runnable accion) {

        String html = """
                <html>
                    <div style='padding:8px;'>
                        <div style='font-size:20px;'>%s</div>
                        <div style='font-size:10px;'>%s</div>
                        <div style='font-size:14px;'><b>%s</b></div>
                        <div style='font-size:10px;'>%s</div>
                    </div>
                </html>
                """.formatted(icono, unidad, titulo, descripcion);

        JButton card = new JButton(html);
        card.setHorizontalAlignment(JButton.LEFT);
        card.setVerticalAlignment(JButton.TOP);
        card.setFocusPainted(false);
        card.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
        card.addActionListener(e -> accion.run());

        return card;
    }

    private static JPanel crearFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 12));
        footer.setBorder(BorderFactory.createEmptyBorder(8, 28, 18, 28));

        JButton btnTema = new JButton("Modo oscuro");
        btnTema.addActionListener(e -> {
            ThemeManager.alternarTema();
            btnTema.setText(ThemeManager.isDarkMode() ? "Modo claro" : "Modo oscuro");
        });

        JButton btnRepo = new JButton("Repositorio");
        btnRepo.addActionListener(e -> abrirRepositorio());

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));

        footer.add(btnTema);
        footer.add(btnRepo);
        footer.add(btnSalir);

        return footer;
    }

    private static void abrirRepositorio() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(URI.create(REPO_URL));
            }
        } catch (Exception ex) {
            // No se muestra error porque abrir el navegador es una acción auxiliar.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager.aplicarTemaClaro();
            crearVentana().setVisible(true);
        });
    }
}