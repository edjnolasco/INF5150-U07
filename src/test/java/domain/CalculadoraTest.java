package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void deberiaSumarCorrectamente() {
        assertEquals(7.5, Calculadora.sumar(3.0, 4.5));
    }
}