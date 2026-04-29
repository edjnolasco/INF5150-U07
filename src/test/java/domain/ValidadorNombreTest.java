package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidadorNombreTest {

    @Test
    void deberiaSaludarCorrectamente() {
        assertEquals("Hola, Ana", ValidadorNombre.saludar("Ana"));
    }

    @Test
    void deberiaEliminarEspacios() {
        assertEquals("Hola, Ana", ValidadorNombre.saludar("   Ana   "));
    }

    @Test
    void deberiaFallarConVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> ValidadorNombre.saludar("   "));
    }

    @Test
    void deberiaFallarConNull() {
        assertThrows(IllegalArgumentException.class,
                () -> ValidadorNombre.saludar(null));
    }
}