package domain;

import java.util.List;

/**
 * Servicio que genera el resumen de un pedido de comida.
 */
public class PedidoService {

    private PedidoService() {
        // Evita instanciar esta clase de utilidad.
    }

    public static String generarResumen(List<String> seleccionados) {
        if (seleccionados == null || seleccionados.isEmpty()) {
            return "Seleccionaste:\n(nada)";
        }

        StringBuilder sb = new StringBuilder("Seleccionaste:\n");

        for (String item : seleccionados) {
            sb.append("- ").append(item).append("\n");
        }

        return sb.toString().trim();
    }
}