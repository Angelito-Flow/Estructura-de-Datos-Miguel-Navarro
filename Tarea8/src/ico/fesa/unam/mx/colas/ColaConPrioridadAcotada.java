package ico.fesa.unam.mx.colas;

public class ColaConPrioridadAcotada<E> {
    private ColaADT<E>[] colas;
    private int maxPrioridad;

    public ColaConPrioridadAcotada(int maxPrioridad) {
        this.maxPrioridad = maxPrioridad;
        this.colas = new ColaADT[maxPrioridad + 1];
        for (int i = 0; i < this.maxPrioridad + 1; i++) {
            this.colas[i] = new ColaADT<>();
        }
    }

    public int longitud() {
        int total = 0;
        for (int i = 0; i < maxPrioridad + 1; i++) {
            total += this.colas[i].longitud();
        }
        return total;
    }

    public boolean estaVacia() {
        return this.longitud() == 0;
    }

    public void encolar(int prioridad, E elemento) {
        if (prioridad >= 1 && prioridad <= this.maxPrioridad) {
            this.colas[prioridad].encolar(elemento);
        } else {
            System.out.println("¡Prioridad fuera de rango!");
        }
    }

    public E desEncolar() {
        for (int i = 1; i <= maxPrioridad; i++) {
            if (!colas[i].estVacia()) {
                return colas[i].desEncolar();
            }
        }
        return null; // no hay más elementos en la cola
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= maxPrioridad; i++) {
            sb.append("Prioridad ").append(i).append(": ");
            if (colas[i].estVacia()) {
                sb.append("Sin clientes esperando en esta prioridad\n");
            } else {
                sb.append("\n").append(colas[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }
}