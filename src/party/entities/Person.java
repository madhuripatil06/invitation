package party.entities;

import party.nameRepresentation.Representation;

public class Person {
    private String gender;
    private Address address;
    private Name name;
    private int age;

    public Person(Name name, String gender, Address address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public boolean  isFromCountry(String otherCountry){
        return address.isFromCountry(otherCountry);
    }

    public int howOldAreYou() {
        return age;
    }

    public String address(){
        return address.toString();
    }

    public String represent(Representation representation) {
        return String.format("%s%s", Gender.valueOf(gender), name.represent(representation));
    }
}
