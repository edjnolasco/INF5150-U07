package domain;

/**
 * Valida y construye objetos Estudiante.
 */
public class EstudianteValidator {

    private EstudianteValidator() {
        // Evita instanciar esta clase de utilidad.
    }

    public static Estudiante crear(String nombre, String notaTexto) {
        validarNombre(nombre);

        int nota = parseNota(notaTexto);
        validarRangoNota(nota);

        return new Estudiante(nombre.trim(), nota);
    }

    private static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }
    }

    private static int parseNota(String notaTexto) {
        try {
            return Integer.parseInt(notaTexto.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("La nota debe ser un número entero.");
        }
    }

    private static void validarRangoNota(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("Nota fuera de rango (0-100)");
        }
    }
}