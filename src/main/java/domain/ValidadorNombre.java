package domain;

/**
 * Lógica de validación y generación de saludo.
 *
 * Esta clase no depende de Swing, por eso puede probarse de forma aislada.
 */
public class ValidadorNombre {

    private ValidadorNombre() {
        // Evita instanciar esta clase de utilidad.
    }

    public static String saludar(String nombre) {
        validar(nombre);
        return "Hola, " + nombre.trim();
    }

    static void validar(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }
    }
}