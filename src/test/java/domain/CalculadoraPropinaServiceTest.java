package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculadoraPropinaServiceTest {

    @Test
    void deberiaCalcularTotalCorrectamente() {
        assertEquals(115.0, CalculadoraPropinaService.calcularTotal(100.0, 0.15));
    }

    @Test
    void deberiaFallarConMontoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> CalculadoraPropinaService.calcularTotal(-5.0, 0.10));
    }
}