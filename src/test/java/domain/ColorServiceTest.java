package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class ColorServiceTest {

    @Test
    void deberiaRetornarColorValido() {
        assertEquals(Color.GREEN, ColorService.obtenerColor("Verde"));
    }

    @Test
    void deberiaFallarConColorInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> ColorService.obtenerColor("Morado"));
    }
}