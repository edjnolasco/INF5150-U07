package domain;

/**
 * Lógica matemática básica.
 *
 * Esta clase no depende de Swing, por eso puede probarse fácilmente
 * con pruebas unitarias.
 */
public class Calculadora {

    private Calculadora() {
        // Evita instanciar esta clase de utilidad.
    }

    public static double sumar(double a, double b) {
        return a + b;
    }
}