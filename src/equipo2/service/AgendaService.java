package equipo2.service;

import equipo2.model.Contact;
import equipo2.model.Agenda;

import javax.management.openmbean.TabularData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgendaService {
    private final List<Contact> contacts = new ArrayList<>();
    private Agenda agenda;

    public AgendaService(Agenda agenda) {
        this.agenda = agenda;
    }


    /*
     * añadirContacto(Contacto c):
     *   Añade un contacto a la agenda. Si no hay espacio suficiente, se debe indicar al usuario que la agenda está llena.
     *   Antes de añadir el contacto, se debe comprobar que no exista ya en la agenda (contactos con el mismo nombre y apellido se consideran duplicados).
     *   No se puede añadir un contacto si el nombre o apellido están vacíos.
     * */
    public void addContact(Contact contact){
        if (contact == null){
            System.out.println("No se puede añadir un contacto nulo.");
        }

        // 1. Validar que nombre y apellido no estén vacíos
        if (contact.getName() == null || contact.getName().isBlank() ||
                contact.getLastName() == null || contact.getLastName().isBlank()) {
            System.out.println("No se puede añadir un contacto con nombre o apellido vacío.");
            return;
        }

        // 1. Validar que nombre y apellido no estén vacíos
        if (contact.getName() == null || contact.getName().isBlank() ||
                contact.getLastName() == null || contact.getLastName().isBlank()) {
            System.out.println("No se puede añadir un contacto con nombre o apellido vacío.");
            return;
        }


        // 4. Si todo esta bien, añadir contacto
        agenda.getContacts().add(contact);
        System.out.println("Contacto añadido correctamente: " +
                contact.getName() + " " + contact.getLastName());
        return;
    }

    /*
       listarContactos():
           Muestra todos los contactos de la agenda en el siguiente formato: Nombre Apellido - Teléfono.
           Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.
    */
    public void listarContactos(){
        List<Contact> contactos = agenda.getContacts();
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }

        Collections.sort(contactos, Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("=== Lista de contactos ===");
        for (Contact c : contactos) {
            System.out.println(c);
        }
    }


    /*
    *   existeContacto(Conctacto c):
    *     Verifica si un contacto ya existe en la agenda.
    *     Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.
    * */
    public boolean existContact(Contact contact){
        return agenda.getContacts().contains(contact);
    }


    /*
        buscaContacto(String nombre):
            Permite buscar un contacto por nombre y apellido.
            Si el contacto existe, muestra el teléfono. Si no existe, muestra un mensaje indicando que no se ha encontrado.
     */
    // buscaContacto
    // .equalsIgnoreCase es para comparar dos textos sin distinguir entre mayusculas y minusculas
    public void searchContact(String name) {
        for (Contact contact : agenda.getContacts()) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contacto encontrado: " + contact);
                return;
            }
        }
        System.out.println("No se encontro el contacto");
    }

    /*
        eliminarContacto(Contacto c):
            Elimina un contacto de la agenda. Muestra un mensaje indicando si la eliminación ha sido exitosa o no.
            Si se intenta eliminar un contacto que no existe, debe indicarse al usuario.
     */
    // eliminarContacto
    public void deleteContacto(String name) {
        List<Contact> toRemove = new ArrayList<>();
        for (Contact contact : agenda.getContacts()) {
            if (contact.getName().equalsIgnoreCase(name)) {
            toRemove.add(contact);
        }
    }
        if (!toRemove.isEmpty()) {
            agenda.getContacts().removeAll(toRemove);
            System.out.println("Contacto eliminado con nombre: " + name);
        } else {
            System.out.println("No se encontro el contacto para eliminar");
        }
    }


    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        boolean encontrado = false;

        for (Contact contact : agenda.getContacts()) {
            if (contact.getName().equalsIgnoreCase(nombre) &&
                    contact.getLastName().equalsIgnoreCase(apellido)) {

                contact.setPhone(nuevoTelefono);
                System.out.println("Teléfono actualizado para " + nombre + " " + apellido +
                        ". Nuevo número: " + nuevoTelefono);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró el contacto: " + nombre + " " + apellido);
        }
    }


    public void espacioLibres() {
        int libres = agenda.getMaxCapacity() - agenda.getContacts().size();
        System.out.println("Espacios disponibles: " + libres);
    }

   public boolean agendaLlena() {
       if (contacts.size() >= agenda.getMaxCapacity()) {
       System.out.println("La agenda está llena. No se pueden agregar más contactos.");
       return true;
    }
    return false;
    }

}
