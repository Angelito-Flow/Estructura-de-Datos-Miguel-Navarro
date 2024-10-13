package LaberintoPE;

public class Main {
    public static void main(String[] args) {
        // se define el laberinto: 1 = pared 0 = pasillo
        int[][] mapaLaberinto = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1}
        };

        // creacion de laberinto y los puntos de inicio y fin
        Laberinto laberinto = new Laberinto(mapaLaberinto);
        Posicion inicio = new Posicion(3, 1);
        Posicion fin = new Posicion(4, 3);

        // se inicializa la resolucion del laberinto
        Resolucion solucionador = new Resolucion(laberinto, inicio, fin);

        System.out.println("Laberinto");
        System.out.println("xxxxxxxxx");
        laberinto.imprimirLaberinto(inicio, fin); // imprimir el laberinto antes de resolver

        if (solucionador.resolver()) {
            System.out.println("¡El laberinto tiene solución! ;)))");
            solucionador.imprimirCamino(); // imprimir el camino tomado
        } else {
            System.out.println("El laberinto no tiene solución. :((");
        }

        // imprimir las posiciones visitadas
        laberinto.imprimirVisitado();
    }
}