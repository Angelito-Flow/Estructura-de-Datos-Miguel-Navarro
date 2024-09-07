package Tarea5Package;

public class DoubleLinkedList<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int tamanio;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.head == null && this.tail == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarAlInicio(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            nuevo.setSiguiente(this.head);
            this.head.setAnterior(nuevo);
            this.head = nuevo;
        }
        this.tamanio++;
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (this.estaVacia()) {
            this.head = nuevo;
            this.tail = nuevo;
        } else {
            nuevo.setAnterior(this.tail);
            this.tail.setSiguiente(nuevo);
            this.tail = nuevo;
        }
        this.tamanio++;
    }

    public void agregarDespuesDe(T referencia, T valor) {
        NodoDoble<T> aux = this.head;
        while (aux != null && !aux.getData().equals(referencia)) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            System.out.println("No existe la referencia!");
        } else {
            NodoDoble<T> nuevo = new NodoDoble<>(valor);
            NodoDoble<T> siguiente = aux.getSiguiente();
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            if (siguiente != null) {
                nuevo.setSiguiente(siguiente);
                siguiente.setAnterior(nuevo);
            } else {
                this.tail = nuevo;
            }
            this.tamanio++;
        }
    }

    public T obtener(int posicion) {
        if (posicion < 1 || posicion > tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        NodoDoble<T> aux = this.head;
        for (int i = 1; i < posicion; i++) {  // Cambiado de 0 a 1
            aux = aux.getSiguiente();
        }
        return aux.getData();
    }

    public void eliminarElPrimero() {
        if (!this.estaVacia()) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getSiguiente();
                this.head.setAnterior(null);
            }
            this.tamanio--;
        }
    }

    public void eliminarElFinal() {
        if (!this.estaVacia()) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.getAnterior();
                this.tail.setSiguiente(null);
            }
            this.tamanio--;
        }
    }

    public void eliminar(int posicion) {
        if (posicion < 1 || posicion > tamanio) {  // Cambiado de 0 a 1
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 1) {
            eliminarElPrimero();
        } else if (posicion == tamanio) {
            eliminarElFinal();
        } else {
            NodoDoble<T> aux = this.head;
            for (int i = 1; i < posicion; i++) {
                aux = aux.getSiguiente();
            }
            NodoDoble<T> anterior = aux.getAnterior();
            NodoDoble<T> siguiente = aux.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            this.tamanio--;
        }
    }

    public int buscar(T valor) {
        NodoDoble<T> aux = this.head;
        int posicion = 1;  // Comienza en 1
        while (aux != null) {
            if (aux.getData().equals(valor)) {
                return posicion;
            }
            aux = aux.getSiguiente();
            posicion++;
        }
        return -1; // Osea que no fue encontrado
    }

    public void actualizar(T aBuscar, T valor) {
        NodoDoble<T> aux = this.head;
        while (aux != null) {
            if (aux.getData().equals(aBuscar)) {
                aux.setData(valor);
                return;
            }
            aux = aux.getSiguiente();
        }
        System.out.println("Elemento no encontrado");
    }

    public void transversal(int direccion) {
        if (direccion == 1) { // De derecha a izquierda
            NodoDoble<T> aux = this.tail;
            while (aux != null) {
                System.out.print(aux + " ");
                aux = aux.getAnterior();
            }
        } else { // De izquierda a derecha
            NodoDoble<T> aux = this.head;
            while (aux != null) {
                System.out.print(aux + " ");
                aux = aux.getSiguiente();
            }
        }
        System.out.println("");
    }
}
