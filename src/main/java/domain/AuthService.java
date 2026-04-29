package domain;

/**
 * Servicio de autenticación simple para la demostración de CardLayout.
 *
 * En una aplicación real, las credenciales no deberían estar escritas
 * directamente en el código. Aquí se mantienen así porque el objetivo
 * didáctico es comprender el flujo de validación y navegación.
 */
public class AuthService {

    private static final String USER = "admin";
    private static final String PASS = "1234";

    private AuthService() {
        // Evita instanciar esta clase de utilidad.
    }

    public static boolean autenticar(String usuario, String password) {
        if (usuario == null || password == null) {
            return false;
        }

        return USER.equals(usuario.trim()) && PASS.equals(password);
    }
}