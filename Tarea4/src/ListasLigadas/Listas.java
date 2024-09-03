package ListasLigadas;

public class Listas<T> {

    public static void main(String[] args) {
        ListasLigadaADT<SmartPhone> lista = new ListasLigadaADT<>();

        // Crear y agregar 5 smartphones
        SmartPhone sp1 = new SmartPhone("Apple iPhone 14");
        SmartPhone sp2 = new SmartPhone("Samsung Galaxy S23");
        SmartPhone sp3 = new SmartPhone("Motorola Edge 40");
        SmartPhone sp4 = new SmartPhone("Apple iPhone 15");
        SmartPhone sp5 = new SmartPhone("Xiaomi Mi 11");

        lista.agregarAlFinal(sp1);
        lista.agregarAlFinal(sp2);
        lista.agregarAlFinal(sp3);
        lista.agregarAlFinal(sp4);
        lista.agregarAlFinal(sp5);

        // Imprimir contenido
        System.out.println("Contenido de la lista:");
        lista.transversal();

        // Eliminar el de la posición 2
        lista.eliminar(2);
        System.out.println("Después de eliminar el elemento en la posición 2:");
        lista.transversal();

        // Actualizar el segundo elemento
        SmartPhone nuevoSp2 = new SmartPhone("Samsung Galaxy S23 Ultra");
        lista.actualizar(sp2, nuevoSp2);
        System.out.println("Después de actualizar el segundo elemento:");
        lista.transversal();

        // Agregar un elemento al inicio y otro al final
        SmartPhone spInicio = new SmartPhone("Sony Xperia 5");
        SmartPhone spFinal = new SmartPhone("Huawei P50 Pro");
        lista.agregarAlInicio(spInicio);
        lista.agregarAlFinal(spFinal);
        System.out.println("Después de agregar un elemento al inicio y otro al final:");
        lista.transversal();

        // Eliminar el primero
        lista.eliminarPrimero();
        System.out.println("Después de eliminar el primer elemento:");
        lista.transversal();
    }
}
