package party.application;

import party.entities.Address;
import party.entities.Name;
import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public class CreateGuestList {
    private ArrayList<Person> guests;
    private ArrayList<Filter> filters;

    public CreateGuestList(ArrayList<Filter> filters) {
        this.filters = filters;
        this.guests = new ArrayList<Person>();
    }

    private Boolean isValid(Person guest) {
        for (Filter filter : filters) {
            if (!filter.isValid(guest))
                return false;
        }
        return true;
    }

    public void add(String person) {
        String[] guestInfo = person.split(",");
        int age = Integer.parseInt(guestInfo[3]);
        Name name = new Name(guestInfo[0], guestInfo[1]);
        Address address = new Address(guestInfo[4], guestInfo[5], guestInfo[6]);
        String gender = guestInfo[2];
        Person guest = new Person(name, gender, address, age);
        if (isValid(guest))
            guests.add(guest);
    }

    public ArrayList<Person> sortedGuests() {
        return guests;
    }

}