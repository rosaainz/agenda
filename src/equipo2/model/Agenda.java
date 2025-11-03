package equipo2.model;

import java.util.List;

public class Agenda {
    private List<Contact> contacts;

    public Agenda(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Contacts=" + contacts;
    }
}
