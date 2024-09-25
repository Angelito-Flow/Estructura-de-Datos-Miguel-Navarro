package Tarea9;

import java.util.Scanner;

public class Main {

    // función que verifica si los paréntesis y llaves están balanceados
    public static boolean areParenthesesBalanced(String expr) {
        Stack<Character> stack = new Stack<>();

        // para recorrer cada carácter en la expresión
        for (int i = 0; i < expr.length(); i++) {
            char currentChar = expr.charAt(i);

            // si el carácter es una llave o paréntesis de apertura, lo añade a la pila
            if (currentChar == '(' || currentChar == '{') {
                stack.push(currentChar);
            }
            // si es una llave o paréntesis de cierre, verifica el balanceo
            else if (currentChar == ')' || currentChar == '}') {
                // si la pila está vacía, hay un error (falta una llave de apertura )
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();

                // verifica si los caracteres coinciden como apertura y cierre
                if ((currentChar == ')' && topChar != '(') || (currentChar == '}' && topChar != '{')) {
                    return false; // no coinciden
                }
            }
        }

        // si la pila está vacía al final, significa que esta balanceado
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // crear un objeto Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // pide al usuario que ingrese una cadena de texto
        System.out.print("Ingrese un texto con paréntesis y/o llaves: ");
        String inputText = scanner.nextLine(); // Capturar la cadena de entrada

        // verificar si la entrada del usuario está balanceada
        boolean resultado = areParenthesesBalanced(inputText);

        // mostrar el resultado
        if (resultado) {
            System.out.println("El texto tiene paréntesis y llaves balanceados.  ;) ");
        } else {
            System.out.println("El texto NO tiene paréntesis y/o llaves balanceados.  :( ");
        }

        // cierra el escáner
        scanner.close();
    }
}