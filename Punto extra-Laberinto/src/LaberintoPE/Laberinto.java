package LaberintoPE;

class Laberinto {
    private final int[][] mapa;
    private final boolean[][] visitado;
    private final int filas, columnas;

    public Laberinto(int[][] mapa) {
        this.mapa = mapa;
        this.filas = mapa.length;
        this.columnas = mapa[0].length;
        this.visitado = new boolean[filas][columnas];
    }

    public boolean esPasillo(int fila, int columna) {
        return mapa[fila][columna] == 0 && !visitado[fila][columna];
    }

    public boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public void marcarVisitado(int fila, int columna) {
        visitado[fila][columna] = true;
    }

    public void imprimirLaberinto(Posicion jugador, Posicion salida) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == jugador.fila && j == jugador.columna) {
                    System.out.print("J "); // J representa al jugador
                } else if (i == salida.fila && j == salida.columna) {
                    System.out.print("S "); // S representa la salida
                } else {
                    System.out.print(mapa[i][j] == 1 ? "# " : ". "); // . representa los pasillos
                }
            }
            System.out.println();
        }
    }

    public void imprimirVisitado() {
        System.out.println("Mapa de posiciones visitadas:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(visitado[i][j] ? "V " : ". ");
            }
            System.out.println();
        }
    }
}