package party.entities;

import party.nameRepresentation.Representation;

public class Person {
    private String gender;
    private Address address;
    private Name name;
    private int HowOldAreU;

    public Person(Name name, String gender, Address address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.HowOldAreU = age;
    }

    public String getCountry() {
        return address.getCountry();
    }

    public boolean  isFromCountry(String otherCountry){
        return address.getCountry().equals(otherCountry);
    }

    public int HowOldAreYou() {
        return HowOldAreU;
    }

    public String represent(Representation representation) {
        return String.format("%s%s", Gender.valueOf(gender), name.represent(representation));
    }
}
