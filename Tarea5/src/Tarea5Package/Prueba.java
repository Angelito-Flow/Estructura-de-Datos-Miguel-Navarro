package Tarea5Package;

public class Prueba {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> numeros = new DoubleLinkedList<>();

        numeros.agregarAlInicio(50);
        numeros.agregarAlFinal(60);
        numeros.agregarAlFinal(65);
        numeros.agregarAlFinal(70);
        numeros.agregarAlFinal(80);
        numeros.agregarAlFinal(90);

        System.out.println("Contenido de la lista:");
        numeros.transversal(0); // Imprime la lista de izquierda a derecha

        System.out.println("Eliminando el elemento en la posición 2");
        numeros.eliminar(2);
        System.out.println("Contenido de la lista después de la eliminación:");
        numeros.transversal(0);

        System.out.println("Actualizando el cuarto elemento a 88");
        numeros.actualizar(70, 88); // Actualiza el valor 70 a 88.
        System.out.println("Contenido de la lista después de la actualización:");
        numeros.transversal(0);

        int posicion = numeros.buscar(80);  // Busca la posición del valor 80
        System.out.println("El valor 80 se encuentra en la posición: " + posicion);
    }
}
