package domain;

/**
 * Representa un producto dentro del inventario.
 */
public class Producto {

    private final String id;
    private final String nombre;
    private final double precio;

    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}