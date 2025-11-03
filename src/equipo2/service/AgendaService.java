package equipo2.service;

import equipo2.model.Agenda;
import equipo2.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private Agenda agenda;
    Agenda agenda;
    List<Contact> contacts = new ArrayList<>();

    public AgendaService(Agenda agenda) {
        this.agenda = agenda;
    }


    /*
     * añadirContacto(Contacto c):
     *   Añade un contacto a la agenda. Si no hay espacio suficiente, se debe indicar al usuario que la agenda está llena.
     *   Antes de añadir el contacto, se debe comprobar que no exista ya en la agenda (contactos con el mismo nombre y apellido se consideran duplicados).
     *   No se puede añadir un contacto si el nombre o apellido están vacíos.
     * */

    /*
       listarContactos():
           Muestra todos los contactos de la agenda en el siguiente formato: Nombre Apellido - Teléfono.
           Ordena los contactos alfabéticamente por nombre y apellido antes de mostrarlos.
    */
    public List<Contact> getContacts(){
        return contacts;
    }

    /*
    *   existeContacto(Conctacto c):
    *     Verifica si un contacto ya existe en la agenda.
    *     Los contactos se consideran iguales si tienen el mismo nombre y apellido, sin importar el teléfono.
    * */
    public boolean existContact(Contact contact){
        return getContacts().contains(contact);
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


    /*
        modificarTelefono(String nombre, String apellido, String nuevoTelefono):
            Permite modificar el teléfono de un contacto existente.
            Si el contacto no existe, debe mostrar un mensaje.
     */



    /*
        agendaLlena():
            Indica si la agenda está llena.
            Muestra un mensaje indicando que no hay espacio disponible para nuevos contactos.
     */


    /*
        espacioLibres():
            Muestra cuántos contactos más se pueden agregar a la agenda.
            Esto debe basarse en el tamaño máximo definido al crear la agenda.
     */
}
