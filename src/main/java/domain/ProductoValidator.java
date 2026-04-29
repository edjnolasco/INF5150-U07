package domain;

/**
 * Valida los datos de un producto y construye una entidad Producto.
 */
public class ProductoValidator {

    private ProductoValidator() {
        // Evita instanciar esta clase de utilidad.
    }

    public static Producto crear(String id, String nombre, String precioTexto) {
        validarTexto(id, "ID vacío");
        validarTexto(nombre, "Nombre vacío");

        double precio = parsePrecio(precioTexto);

        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser > 0");
        }

        return new Producto(id.trim(), nombre.trim(), precio);
    }

    private static void validarTexto(String valor, String mensaje) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    private static double parsePrecio(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Precio inválido");
        }
    }
}