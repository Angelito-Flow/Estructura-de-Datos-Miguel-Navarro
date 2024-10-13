package LaberintoPE;
import java.util.Stack;

class Resolucion {
    private static final int[] DESPLAZAMIENTOS_FILA = {0, -1, 0, 1}; // Movimientos: Izquierda, Arriba, Derecha, Abajo
    private static final int[] DESPLAZAMIENTOS_COLUMNA = {-1, 0, 1, 0};
    private static final String[] DIRECCIONES = {"Izquierda", "Arriba", "Derecha", "Abajo"};

    private final Laberinto laberinto;
    private final Posicion inicio, fin;
    private final Stack<Posicion> pila;

    public Resolucion(Laberinto laberinto, Posicion inicio, Posicion fin) {
        this.laberinto = laberinto;
        this.inicio = inicio;
        this.fin = fin;
        this.pila = new Stack<>();
    }

    // algoritmo de backtracking para resolver el laberinto
    public boolean resolver() {
        pila.push(inicio);
        laberinto.marcarVisitado(inicio.fila, inicio.columna);

        while (!pila.isEmpty()) {
            Posicion actual = pila.peek();

            if (actual.fila == fin.fila && actual.columna == fin.columna) {
                return true; // llegada a la salida
            }

            boolean seMovio = false;

            for (int i = 0; i < 4; i++) {
                int nuevaFila = actual.fila + DESPLAZAMIENTOS_FILA[i];
                int nuevaColumna = actual.columna + DESPLAZAMIENTOS_COLUMNA[i];

                if (laberinto.esPosicionValida(nuevaFila, nuevaColumna) && laberinto.esPasillo(nuevaFila, nuevaColumna)) {
                    pila.push(new Posicion(nuevaFila, nuevaColumna));
                    laberinto.marcarVisitado(nuevaFila, nuevaColumna);
                    seMovio = true;
                    break; // se dejo de buscar
                }
            }

            if (!seMovio) {
                pila.pop(); // Backtrack, no hay más opciones
            }
        }
        return false; // No se encontró una solución
    }

    // imprimir camino tomado
    public void imprimirCamino() {
        System.out.println("Camino recorrido:");
        for (Posicion p : pila) {
            System.out.println("Posición: (" + p.fila + ", " + p.columna + ")");
        }
    }
}
