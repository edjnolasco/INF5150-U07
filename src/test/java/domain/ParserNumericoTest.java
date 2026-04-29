package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParserNumericoTest {

    @Test
    void deberiaParsearNumeroValido() {
        assertEquals(10.0, ParserNumerico.parse("10"));
    }

    @Test
    void deberiaParsearNumeroConEspacios() {
        assertEquals(10.5, ParserNumerico.parse(" 10.5 "));
    }

    @Test
    void deberiaFallarConTextoInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> ParserNumerico.parse("abc"));
    }

    @Test
    void deberiaFallarConVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> ParserNumerico.parse("   "));
    }
}