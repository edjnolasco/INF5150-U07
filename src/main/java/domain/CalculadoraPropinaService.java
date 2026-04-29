package domain;

/**
 * Servicio encargado de calcular el total de una cuenta con propina.
 */
public class CalculadoraPropinaService {

    private CalculadoraPropinaService() {
        // Evita instanciar esta clase de utilidad.
    }

    public static double calcularTotal(double monto, double porcentaje) {
        validarMonto(monto);
        return monto + (monto * porcentaje);
    }

    private static void validarMonto(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("Monto negativo");
        }
    }
}