package ListasLigadas;

public class ListasLigadaADT<T> {
    private Nodo<T> head;
    private int tamanio;

    public ListasLigadaADT() {
        this.head = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.head == null;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void agregarAlFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (this.head == null) {
            this.head = nuevo;
        } else {
            Nodo<T> aux = this.head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
        this.tamanio++;
    }

    public void agregarAlInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (this.head != null) {
            nuevo.setNext(this.head);
        }
        this.head = nuevo;
        this.tamanio++;
    }

    public void agregarDespuesDe(T referencia, T valor) {
        Nodo<T> aux = this.head;
        while (aux != null && !aux.getDato().equals(referencia)) {
            aux = aux.getNext();
        }
        if (aux != null) {
            Nodo<T> nuevo = new Nodo<>(valor);
            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
            this.tamanio++;
        }
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= this.tamanio) {
            System.out.println("Posición inválida.");
            return;
        }
        if (posicion == 0) {
            this.head = this.head.getNext();
        } else {
            Nodo<T> aux = this.head;
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
        }
        this.tamanio--;
    }

    public void eliminarPrimero() {
        if (this.head != null) {
            this.head = this.head.getNext();
            this.tamanio--;
        }
    }

    public void eliminarFinal() {
        if (this.head == null) {
            return;
        }
        if (this.head.getNext() == null) {
            this.head = null;
        } else {
            Nodo<T> aux = this.head;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(null);
        }
        this.tamanio--;
    }

    public void buscar(T valor) {
        Nodo<T> aux = this.head;
        int indice = 0;
        while (aux != null) {
            if (aux.getDato().equals(valor)) {
                System.out.println("El elemento '" + valor + "' se encuentra en la posición: " + indice);
                return;
            }
            aux = aux.getNext();
            indice++;
        }
        System.out.println("El elemento '" + valor + "' no se encontró en la lista.");
    }

    public void actualizar(T aBuscar, T valor) {
        Nodo<T> aux = this.head;
        while (aux != null && !aux.getDato().equals(aBuscar)) {
            aux = aux.getNext();
        }
        if (aux != null) {
            aux.setDato(valor);
            System.out.println("El elemento '" + aBuscar + "' fue actualizado a '" + valor + "'");
        } else {
            System.out.println("El elemento '" + aBuscar + "' no se encontró en la lista.");
        }
    }

    public void transversal() {
        Nodo<T> aux = this.head;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getNext();
        }
        System.out.println();
    }
}
