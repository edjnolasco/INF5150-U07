package domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthServiceTest {

    @Test
    void deberiaAutenticarCorrectamente() {
        assertTrue(AuthService.autenticar("admin", "1234"));
    }

    @Test
    void deberiaFallarCredencialesIncorrectas() {
        assertFalse(AuthService.autenticar("user", "1234"));
    }

    @Test
    void deberiaFallarConNull() {
        assertFalse(AuthService.autenticar(null, "1234"));
    }
}