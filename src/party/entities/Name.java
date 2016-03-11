package party.entities;

import party.application.Style;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String represent(Style style) {
        return style.represent(firstName,lastName);
    }
}
