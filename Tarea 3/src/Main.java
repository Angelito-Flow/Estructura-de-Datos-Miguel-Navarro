class Nodo {
    int data;
    Nodo next;

    // Constructor para inicializar un nodo
    public Nodo(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    private Nodo head;  // Referencia al primer nodo de la lista

    // Constructor para inicializar una lista enlazada vacía
    public Main() {
        this.head = null;
    }

    // Método para agregar un nodo al final de la lista
    public void add(int data) {
        Nodo newNode = new Nodo(data);
        if (head == null) {
            head = newNode;
        } else {
            Nodo current = head;
            // Recorrer hasta el último nodo
            while (current.next != null) {
                current = current.next;
            }
            // Enlazar el último nodo al nuevo nodo
            current.next = newNode;
        }
    }

    // Imprimir los elementos de la lista usando while
    public void printList() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Método para cambiar el valor de 300 a 333
    public void updateThirdNode(int newData) {
        if (head == null) return;

        Nodo current = head;
        int count = 1;

        while (current != null && count < 3) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.data = newData;
        }
    }

    // Insertar un nodo después de un nodo con un valor específico

    public void insertAfter(int afterValue, int newValue) {
        Nodo current = head;

        while (current != null) {
            if (current.data == afterValue) {
                Nodo newNode = new Nodo(newValue);
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    // Método para insertar un nodo al principio de la lista
    public void insertAtBeginning(int data) {
        Nodo newNode = new Nodo(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        Main list = new Main();

        // nodos
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(600);

        // Imprimir la lista original usando while
        System.out.println("Lista:");
        list.printList();

        // Cambiar valor del 3er nodo de 300 a 333
        list.updateThirdNode(333);
        System.out.println("Después de cambiar el valor del 3er nodo de 300 a 333:");
        list.printList();

        // Insertar 700 después del nodo 600
        list.insertAfter(600, 700);
        System.out.println("Insertar el nodo 700 después del nodo 600:");
        list.printList();

        // Insertar nodo 50 al principio
        list.insertAtBeginning(50);
        System.out.println("Insertar el nodo 50 al principio:");
        list.printList();
    }
}
