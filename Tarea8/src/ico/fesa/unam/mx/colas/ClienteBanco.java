package ico.fesa.unam.mx.colas;

public class ClienteBanco {
    private String nombre;
    private String tipoCliente;
    private int prioridad;

    public ClienteBanco(String nombre, String tipoCliente, int prioridad) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Tipo: %s, Prioridad: %d", nombre, tipoCliente, prioridad);
    }
}