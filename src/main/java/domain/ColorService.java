package domain;

import java.awt.Color;
import java.util.Map;

/**
 * Servicio que convierte el nombre de un color en un objeto Color.
 *
 * Esto evita tener condicionales repetidos dentro de la interfaz gráfica.
 */
public class ColorService {

    private static final Map<String, Color> COLORES = Map.of(
            "Rojo", Color.RED,
            "Verde", Color.GREEN,
            "Azul", Color.BLUE
    );

    private ColorService() {
        // Evita instanciar esta clase de utilidad.
    }

    public static Color obtenerColor(String nombre) {
        Color color = COLORES.get(nombre);

        if (color == null) {
            throw new IllegalArgumentException("Color inválido");
        }

        return color;
    }
}