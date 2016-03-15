package party.entities;

import party.filters.Filter;
import party.nameRepresentation.Representation;

import java.util.ArrayList;
import java.util.HashMap;

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

    public boolean isFromCountry(String otherCountry) {
        return address.isFromCountry(otherCountry);
    }

    public String address() {
        return address.toString();
    }

    private String Entities(ArrayList<Filter> filters) {
        String country = address.toString().split("\n")[1];
        int ageValue = Integer.parseInt(age.toText());

        HashMap<String, String> entities = new HashMap<String, String>();
        entities.put("party.filters.CountryFilter", ", " + country);
        entities.put("party.filters.AgeFilter", ", " + ageValue);
        String result = "";
        for (Filter filter : filters) {
            result += entities.get(filter.toString().split("@")[0]);
        }
        return result;
    }


    public String represent(Representation representation, ArrayList<Filter> filters) {
        String result = gender + name.represent(representation);
        if (filters != null)
            result += Entities(filters);
        return result;
    }

    public boolean isAbove(int ageparam) {
        return age.isAbove(ageparam);
    }
}
