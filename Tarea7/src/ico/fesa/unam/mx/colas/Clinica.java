package ico.fesa.unam.mx.colas;

public class Clinica {
    public static void main(String[] args) {
        ColaADT<Paciente> colaPacientes = new ColaADT<>();

        // Registrar la llegada de 3 pacientes
        colaPacientes.encolar(new Paciente("Uriel Leal"));
        colaPacientes.encolar(new Paciente("Camila Magaña"));
        colaPacientes.encolar(new Paciente("Miguel Navarro"));

        // Mostrar el contenido de la cola
        System.out.println("Pacientes en la cola: " + colaPacientes);

        // Mostrar el paciente que sigue (sin sacarlo de la cola)
        System.out.println("Siguiente paciente: " + colaPacientes.frente());

        // Atender al siguiente paciente (sacarlo de la cola)
        Paciente atendido = colaPacientes.desEncolar();
        System.out.println("Atendiendo a: " + atendido);

        // Mostrar el contenido de la cola después de atender
        System.out.println("Pacientes en la cola después de atender: " + colaPacientes);

        // Agregar 2 nuevos pacientes
        colaPacientes.encolar(new Paciente("Araceli Rocha"));
        colaPacientes.encolar(new Paciente("Lionel Messi"));

        // Mostrar el contenido de la cola con nuevos pacientes
        System.out.println("Pacientes en la cola después de agregar nuevos: " + colaPacientes);

        // Atender al siguiente paciente
        atendido = colaPacientes.desEncolar();
        System.out.println("Atendiendo a: " + atendido);

        // Mostrar el contenido final de la cola
        System.out.println("Pacientes en la cola finalmente: " + colaPacientes);
    }
}

