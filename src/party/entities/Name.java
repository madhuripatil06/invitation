package party.entities;

import party.nameRepresentation.Representation;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String represent(Representation representation) {
        return representation.represent(firstName,lastName);
    }
}
