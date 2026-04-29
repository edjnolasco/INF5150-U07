package domain;

/**
 * Utilidad para convertir texto a número decimal.
 *
 * Centralizar el parsing evita repetir try/catch en varias ventanas.
 */
public class ParserNumerico {

    private ParserNumerico() {
        // Evita instanciar esta clase de utilidad.
    }

    public static double parse(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo vacío");
        }

        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato numérico inválido");
        }
    }
}