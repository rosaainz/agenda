package equipo2.main;

import equipo2.model.Agenda;
import equipo2.model.Contact;
import equipo2.service.AgendaService;


public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(5);
        AgendaService service = new AgendaService(agenda);

        Contact contact = new Contact("Juan", "Perez", "5512345678");
        Contact contact2 = new Contact("Rosa", "Perez", "5512345678");
        Contact contact3 = new Contact("Luis", "Perez", "5512345678");






        /*
         *  Menu de opciones
         */
    }
}
