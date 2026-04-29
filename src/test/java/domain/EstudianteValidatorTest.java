package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EstudianteValidatorTest {

    @Test
    void deberiaCrearEstudianteValido() {
        Estudiante estudiante = EstudianteValidator.crear("Ana", "95");

        assertEquals("Ana", estudiante.getNombre());
        assertEquals(95, estudiante.getNota());
    }

    @Test
    void deberiaFallarConNotaInvalida() {
        assertThrows(IllegalArgumentException.class,
                () -> EstudianteValidator.crear("Ana", "200"));
    }

    @Test
    void deberiaFallarConNombreVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> EstudianteValidator.crear("", "50"));
    }
}