package ico.fesa.unam.mx.colas;

public class BancoMain {
    public static void main(String[] args) {
        ColaConPrioridadAcotada<ClienteBanco> cola = new ColaConPrioridadAcotada<>(5);

        // llegan 2 clientes nuevos
        cola.encolar(4, new ClienteBanco("Camila Magaña", "Cliente nuevo", 4));
        cola.encolar(4, new ClienteBanco("Miguel Navarro", "Cliente nuevo", 4));

        // llegan 3 personas que no son clientes
        cola.encolar(5, new ClienteBanco("Araceli Rocha", "No es cliente", 5));
        cola.encolar(5, new ClienteBanco("Oscar Navarro", "No es cliente", 5));
        cola.encolar(5, new ClienteBanco("Uriel Leal", "No es cliente", 5));

        // llega una celebridad
        cola.encolar(1, new ClienteBanco("Jesse Rutherford", "Celebridades", 1));

        // imprimir estado de la cola
        System.out.println("_________Estado inicial de la cola_________");
        System.out.println(cola);

        // se atiende al siguiente cliente y retira $10,000
        ClienteBanco clienteAtendido = atenderSiguienteCliente(cola);
        if (clienteAtendido != null) {
            System.out.println(clienteAtendido.getNombre() + " retira $10,000.");
        }

        // llegan 2 clientes más: uno frecuente y uno premium
        cola.encolar(3, new ClienteBanco("Francisco Rocha", "Cliente frecuente", 3));
        cola.encolar(2, new ClienteBanco("Carmen Acuña", "Cliente premium", 2));

        // atender al siguiente cliente
        atenderSiguienteCliente(cola);

        // imprimir estado de la cola
        System.out.println("_____Estado de la cola después de atender a 2 clientes_____");
        System.out.println(cola);

        // atender a todos los clientes restantes
        while (!cola.estaVacia()) {
            atenderSiguienteCliente(cola);
        }

        // imprimir estado final de la cola
        System.out.println("_____Estado final de la cola_____");
        System.out.println(cola);
    }

    private static ClienteBanco atenderSiguienteCliente(ColaConPrioridadAcotada<ClienteBanco> cola) {
        ClienteBanco clienteAtendido = cola.desEncolar();
        if (clienteAtendido != null) {
            System.out.println("Atendiendo a: " + clienteAtendido.getNombre());
        } else {
            System.out.println("No hay más clientes en la cola :)");
        }
        return clienteAtendido;
    }
}