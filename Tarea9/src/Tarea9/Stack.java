package Tarea9;

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    // pila vacía
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // devuelve la longitud de pila
    public int length() {
        return data.size();
    }

    // extrae el último elemento de la pila (LIFO)
    public T pop() {
        if (!isEmpty()) {
            return data.remove(data.size() - 1);
        }
        return null; // error si está vacía
    }

    // devuelve el último elemento sin extraerlo
    public T peek() {
        if (!isEmpty()) {
            return data.get(data.size() - 1);
        }
        return null;
    }

    // añade un elemento a la pila
    public void push(T value) {
        data.add(value);
    }

    // representación en cadena de la pila
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("-----\n");
        for (int i = data.size() - 1; i >= 0; i--) {
            info.append(data.get(i)).append("\n|---|\n");
        }
        return info.toString();
    }
}
