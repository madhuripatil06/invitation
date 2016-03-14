package party.guestList;

import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;

import java.util.ArrayList;

public class CreateGuestList {
    private ArrayList<Person> guests;
    private String fileData;

    public CreateGuestList(String fileData) {
        this.fileData = fileData;
        this.guests = new ArrayList<Person>();
    }

    public void createList(){
        String [] records = fileData.split("\n");
        for (String record : records) {
            add(record);
        }
    }
    public void add(String person) {
        String[] guestInfo = person.split(",");
        int ageParam = Integer.parseInt(guestInfo[3]);
        Name name = new Name(guestInfo[0], guestInfo[1]);
        Address address = new Address(guestInfo[4], guestInfo[5], guestInfo[6]);
        String gender = guestInfo[2];
        Age age = new Age(ageParam);
        Person guest = new Person(name, gender, address, age);
            guests.add(guest);
    }

    public ArrayList<Person> getList() {
        return guests;
    }
}