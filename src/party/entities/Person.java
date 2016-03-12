package party.entities;

import party.application.Style;

public class Person {
    private String gender;
    private Address address;
    private Name name;
    private Age age;

    public Person(Name name, String gender, Address address, Age age) {
        this.name = name;
        this.gender = String.valueOf(Gender.valueOf(gender.toUpperCase()));
        this.address = address;
        this.age = age;
    }

    public boolean  isFromCountry(String otherCountry){
        return address.isFromCountry(otherCountry);
    }

    public String howOldAreYou() {
        return age.toText();
    }

    public String address(){
        return address.toString();
    }

    public String represent(Style style){
            return gender+name.represent(style);
    }

    public boolean isAbove(int ageparam) {
        return age.isAbove(ageparam);
    }
}
