package domain;

/**
 * Representa un estudiante con su nota.
 *
 * Esta clase modela los datos antes de mostrarlos en una JTable.
 */
public class Estudiante {

    private final String nombre;
    private final int nota;

    public Estudiante(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }
}