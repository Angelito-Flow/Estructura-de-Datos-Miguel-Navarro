import java.util.Stack;

public class Pila {
    private Stack<Integer> items;

    // aqui esta el constructor
    public Pila() {
        items = new Stack<>();
    }

    // obtener el tamaño de la pila
    public int tamaño() {
        return items.size();
    }

    // eliminar el elemento superior de la pila
    public int pop() {
        if (!estaVacia()) {
            return items.pop();
        }
        return -1;  // Devuelve -1 si la pila está vacía
    }

    // insertar un elemento en la pila
    public void push(int item) {
        items.push(item);
    }

    // comprobar si la pila está vacía
    public boolean estaVacia() {
        return items.isEmpty();
    }

    // Método recursivo para obtener el valor en la posición media de la pila
    public static int obtenerMedio(Pila pila, int tamaño, int contador) {
        if (contador == tamaño / 2) {
            return pila.pop();
        }

        int valor = pila.pop();
        int medio = obtenerMedio(pila, tamaño, contador + 1);
        pila.push(valor);

        return medio;
    }

    public static void main(String[] args) {
        Pila pila = new Pila();
        for (int i = 1; i <= 16; i++) {
            pila.push(i);
        }

        int tamaño = pila.tamaño();
        int valorMedio = obtenerMedio(pila, tamaño, 0);
        System.out.println("Valor en la posición media: " + valorMedio + ":)");

        // método recursivo para calcular la potencia de un número a elevado a^b.
        int a = 5;
        int b = 8;
        int resultado = potencia(a, b);
        System.out.println(a + " elevado a " + b + " es: " + resultado);
    }

    // método recursivo para calcular la potencia
    public static int potencia(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * potencia(a, b - 1);
    }
}
