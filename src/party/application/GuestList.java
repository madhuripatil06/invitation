package party.application;

import party.entities.Address;
import party.entities.Name;
import party.entities.Person;
import party.filters.Filter;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import java.util.ArrayList;
import java.util.HashMap;

public class GuestList {
    private ArrayList<Person> guests;
    private ArrayList<Filter> filters;

    public GuestList(ArrayList<Filter> filters) {
        this.filters = filters;
        this.guests = new ArrayList<Person>();
    }

    public void add(String person) {
        String[] guestInfo = person.split(",");
        int age = Integer.parseInt(guestInfo[3]);
        Name name = new Name(guestInfo[0], guestInfo[1]);
        Address address = new Address(guestInfo[4], guestInfo[5], guestInfo[6]);
        String gender =  guestInfo[2];
        Person guest = new Person(name,gender, address, age);
        guests.add(guest);
    }

    public String getName(Person guest, String option) {
        HashMap<String, Representation> name = new HashMap<String , Representation>();
        name.put("-f", new FirstLast());
        name.put("-l", new LastFirst());
        return guest.represent(name.get(option));
    }

    private String filterForEachFilter(Person guest) {
        String result = "";
        for (Filter filter : filters) {
            if (!filter.isValid(guest))
                return "";
            result += ", "+filter.getEntity();
        }
        return result;
    }

    public void print(String[] options) {
        for (Person guest : guests) {
            if (filters.size() == 0)
                System.out.println(getName(guest, options[0]));
            String filteredOutput = filterForEachFilter(guest);
            if (!filteredOutput.equals("")) {
                System.out.println(getName(guest, options[0])  + filteredOutput);
            }
        }
    }
}
