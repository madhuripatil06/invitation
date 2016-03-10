package party.application;

import party.entities.Address;
import party.entities.Name;
import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public class GuestList {
    private ArrayList<Person> guests;
    private ArrayList<Filter> filters;

    public GuestList(ArrayList<Filter> filters) {
        this.filters = filters;
        this.guests = new ArrayList<Person>();
    }

    private Boolean isValid(Person guest){
        for (Filter filter : filters) {
            if(!filter.isValid(guest))
                return false;
        }
        return true;
    }

    public void add(String person) {
        String[] guestInfo = person.split(",");
        int age = Integer.parseInt(guestInfo[3]);
        Name name = new Name(guestInfo[0], guestInfo[1]);
        Address address = new Address(guestInfo[6]);
        String gender =  guestInfo[2];
        Person guest = new Person(name,gender, address, age);
        if(isValid(guest))
            guests.add(guest);
    }

    private String askForData(Person guest) {
        String result = "";
        for (Filter filter : filters) {
            result += ", "+filter.getEntity(guest);
        }
        return result;
    }

    public void print(String[] options) {
        PrintStyle printStyle = new PrintStyle(options[0]);
        for (Person guest : guests) {
            String filteredOutput = askForData(guest);
            System.out.println(printStyle.StyleInformation(guest,filteredOutput));
        }
    }
}
