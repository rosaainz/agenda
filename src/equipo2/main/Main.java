package equipo2.main;

import equipo2.model.Agenda;
import equipo2.model.Contact;
import equipo2.service.AgendaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda;



        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la Agenda Telefónica");
        System.out.print("¿Deseas indicar un tamaño máximo? (s/n): ");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Introduce el tamaño máximo de la agenda: ");
            int tam = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            agenda = new Agenda(tam);
        } else {
            agenda = new Agenda(); // tamaño por defecto
        }

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Ver espacios disponibles");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Apellido: ");
                    String lastName = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String phone = sc.nextLine();
                    Contact contact = new Contact(name,lastName,phone);
                    agendaService.addContact(agenda,contact);
                    break;

                case 2:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    Contacto encontrado = agenda.buscarContacto(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println("Contacto encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    agenda.eliminarContacto(nombreEliminar);
                    break;
                case 4:
                    agenda.mostrarContactos();
                    break;
                case 5:
                    System.out.println("Espacios disponibles: " + agenda.espaciosDisponibles());
                    break;

                case 0:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }


}
