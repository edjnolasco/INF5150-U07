package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.AuthService;

/**
 * Login simple con CardLayout.
 *
 * CardLayout permite cambiar entre diferentes pantallas dentro
 * de un mismo contenedor.
 */
public class LoginCardLayout {

    private static final String CARD_LOGIN = "login";
    private static final String CARD_HOME = "home";

    private LoginCardLayout() {
        // Evita instanciar esta clase de utilidad.
    }

    public static JFrame crearVentana() {
        JFrame frame = new JFrame("Login Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        CardLayout cardLayout = new CardLayout();
        JPanel contenedor = new JPanel(cardLayout);

        JPanel panelLogin = crearPanelLogin(frame, cardLayout, contenedor);
        JPanel panelHome = crearPanelHome();

        contenedor.add(panelLogin, CARD_LOGIN);
        contenedor.add(panelHome, CARD_HOME);

        frame.add(contenedor);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    private static JPanel crearPanelLogin(JFrame frame, CardLayout layout, JPanel contenedor) {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnEntrar = new JButton("Entrar");

        btnEntrar.addActionListener(e ->
                manejarLogin(frame, layout, contenedor, txtUser, txtPass)
        );

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUser);
        panel.add(new JLabel("Clave:"));
        panel.add(txtPass);
        panel.add(btnEntrar);

        return panel;
    }

    private static JPanel crearPanelHome() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Bienvenido 👋"));
        return panel;
    }

    static void manejarLogin(JFrame frame,
                             CardLayout layout,
                             JPanel contenedor,
                             JTextField txtUser,
                             JPasswordField txtPass) {

        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        if (AuthService.autenticar(user, pass)) {
            layout.show(contenedor, CARD_HOME);
        } else {
            mostrarError(frame);
        }
    }

    static void mostrarError(JFrame frame) {
        JOptionPane.showMessageDialog(
                frame,
                "Credenciales inválidas",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana().setVisible(true));
    }
}