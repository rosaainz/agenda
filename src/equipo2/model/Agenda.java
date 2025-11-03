package equipo2.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contact> contacts;
    private int maxCapacity;

    public Agenda() {
        this(10);
    }

    public Agenda(int capacidadMaxima) {
        this.maxCapacity = capacidadMaxima;
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Contacts: " + contacts +
                ", maxCapacity:" + maxCapacity;
    }
}
