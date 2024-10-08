package ico.fesa.unam.mx.colas;

import java.util.LinkedList;

public class ColaADT<E> {
    private LinkedList<E> data;

    public ColaADT() {
        this.data = new LinkedList<>();
    }

    public boolean estVacia() {
        return this.data.isEmpty();
    }

    public int longitud() {
        return this.data.size();
    }

    public E frente() {
        return this.data.getFirst();
    }

    public void encolar(E valor) {
        this.data.addLast(valor);
    }

    public E desEncolar() {
        return this.data.removeFirst();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}