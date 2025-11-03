package equipo2.main;

import equipo2.model.Agenda;
import equipo2.model.Contact;
import equipo2.service.AgendaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la Agenda Telefónica");
        System.out.print("¿Deseas indicar un tamaño máximo? (s/n): ");
        String respuesta = sc.nextLine();

        Agenda agenda;
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Introduce el tamaño máximo de la agenda: ");
            int tam = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            agenda = new Agenda(tam);
        } else {
            agenda = new Agenda(); // tamaño por defecto
        }

        AgendaService agendaService = new AgendaService(agenda);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Ver espacios disponibles");
            System.out.println("6. Modificar teléfono de un contacto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    if (agendaService.agendaLlena()){
                        System.out.println("La agenda está llena.");
                    }else {
                        System.out.print("Nombre: ");
                        String name = sc.nextLine();
                        System.out.print("Apellido: ");
                        String lastName = sc.nextLine();
                        System.out.print("Teléfono: ");
                        String phone = sc.nextLine();

                        Contact contact = new Contact(name, lastName, phone);
                        agendaService.addContact(contact);
                    }
                    break;

                case 2:
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    agendaService.searchContact(nombreBuscar);
                    break;

                case 3:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    agendaService.deleteContacto(nombreEliminar);
                    break;

                case 4:
                    agendaService.listarContactos();
                    break;

                case 5:
                    agendaService.espacioLibres();
                    break;

                case 6:
                    System.out.print("Nombre del contacto: ");
                    String nombreModificar = sc.nextLine();
                    System.out.print("Apellido del contacto: ");
                    String apellidoModificar = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();
                    agendaService.modificarTelefono(nombreModificar, apellidoModificar, nuevoTelefono);
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
