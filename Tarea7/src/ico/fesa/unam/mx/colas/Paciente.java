package ico.fesa.unam.mx.colas;

public class Paciente {
    private String nombre;

    public Paciente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Paciente" +
                "=" + nombre ;
    }

    public String getNombre() {
        return nombre;
    }
}