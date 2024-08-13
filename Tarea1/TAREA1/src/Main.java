import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String SEPARADOR = ",";

    public static void main(String[] args) {
        BufferedReader bufferLectura = null;
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            bufferLectura = new BufferedReader(new FileReader("C:\\Users\\Hp\\Documents\\Aragon\\7timo semestre\\EDD\\Tarea1.0\\Presencia Redes Sociales.csv"));
            bufferLectura.readLine();

            String linea;
            while ((linea = bufferLectura.readLine()) != null) {
                String[] separadoPorComas = linea.split(SEPARADOR);
                ArrayList<String> campos = new ArrayList<>();

                for (int i = 0; i < separadoPorComas.length; ++i) {
                    if (separadoPorComas[i].charAt(0) != '"') {
                        campos.add(separadoPorComas[i].replace("%", ""));
                    } else {
                        String strNew = separadoPorComas[i] + separadoPorComas[++i];
                        campos.add(strNew.replace("\"", ""));
                    }
                }
                data.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferLectura != null) bufferLectura.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!data.isEmpty()) {
            for (ArrayList<String> row : data) {
                if (row.get(0).equals("TWITTER") && row.get(1).contains("SEGUIDORES")) {
                    double diferenciaFollowers = Double.parseDouble(row.get(8)) - Double.parseDouble(row.get(3));
                    System.out.println("Diferencia de followers (Enero - Junio) : " + diferenciaFollowers + "\n");
                }
            }

            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
            System.out.println("Índices de los meses");
            for (int i = 0; i < meses.length; ++i) {
                System.out.println("  " + (i + 1) + " - " + meses[i]);
            }

            System.out.println("Introduce el índice de los meses que quieres comparar");
            System.out.print("Mes 1: ");
            int mes_1 = scanner.nextInt();
            System.out.print("Mes 2: ");
            int mes_2 = scanner.nextInt();

            if (mes_2 > mes_1) {
                for (ArrayList<String> row : data) {
                    if (row.get(0).equals("YOUTUBE") && row.get(1).contains("VISUALIZACIONES")) {
                        double vistas_mes_1 = Double.parseDouble(row.get(mes_1 + 2));
                        double vistas_mes_2 = Double.parseDouble(row.get(mes_2 + 2));
                        System.out.println("La diferencia de visualizaciones entre los dos meses (" + meses[mes_1 - 1] + " - " + meses[mes_2 - 1] + ") seleccionados es : " + (vistas_mes_2 - vistas_mes_1) + "\n");
                    }
                }
            } else {
                System.out.println("El mes 2 (" + mes_2 + ") no puede ser mayor al mes 1 (" + mes_1 + ")\n");
            }

            double promedio_TW = calcularPromedio(data, "TWITTER", "CRECIMIENTO DE FOLLOWERS");
            double promedio_FB = calcularPromedio(data, "FACEBOOK", "CRECIMIENTO (seguidores)");

            System.out.println("Promedio de crecimiento de Twitter: " + promedio_TW);
            System.out.println("Promedio de crecimiento de Facebook: " + promedio_FB);

            double promedioLikesYT = calcularPromedio(data, "YOUTUBE", "ME GUSTA");
            double promedioLikesTW = calcularPromedio(data, "TWITTER", "ME GUSTA");
            double promedioLikesFB = calcularPromedio(data, "FACEBOOK", "ME GUSTA");

            System.out.println("Promedio de 'Me gusta' de YouTube: " + promedioLikesYT);
            System.out.println("Promedio de 'Me gusta' de Twitter: " + promedioLikesTW);
            System.out.println("Promedio de 'Me gusta' de Facebook: " + promedioLikesFB);
        }
    }

    private static double calcularPromedio(ArrayList<ArrayList<String>> data, String plataforma, String criterio) {
        double suma = 0.0;
        int count = 0;

        for (ArrayList<String> row : data) {
            if (row.get(0).equals(plataforma) && row.get(1).contains(criterio)) {
                for (int j = 3; j <= 8; j++) {
                    suma += Double.parseDouble(row.get(j));
                }
                count++;
            }
        }

        return count > 0 ? suma / (count * 6) : 0.0;
    }
}