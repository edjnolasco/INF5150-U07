package domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ProductoValidatorTest {

    @Test
    void deberiaCrearProductoValido() {
        Producto producto = ProductoValidator.crear("A1", "Mouse", "250");

        assertAll(
                () -> assertEquals("A1", producto.getId()),
                () -> assertEquals("Mouse", producto.getNombre()),
                () -> assertEquals(250.0, producto.getPrecio())
        );
    }

    @Test
    void deberiaAceptarProductoValido() {
        assertDoesNotThrow(() -> ProductoValidator.crear("A1", "Mouse", "250.0"));
    }

    @Test
    void deberiaFallarConPrecioInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> ProductoValidator.crear("A1", "Mouse", "abc"));
    }

    @Test
    void deberiaFallarConPrecioNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> ProductoValidator.crear("A1", "Mouse", "-5"));
    }

    @Test
    void deberiaFallarConCamposVacios() {
        assertThrows(IllegalArgumentException.class,
                () -> ProductoValidator.crear("", "Mouse", "10"));
    }
}