package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class PedidoServiceTest {

    @Test
    void deberiaRetornarResumenVacio() {
        assertEquals("Seleccionaste:\n(nada)",
                PedidoService.generarResumen(List.of()));
    }

    @Test
    void deberiaGenerarResumenMultiple() {
        String esperado = "Seleccionaste:\n- Pizza\n- Pasta";

        assertEquals(esperado,
                PedidoService.generarResumen(List.of("Pizza", "Pasta")));
    }
}