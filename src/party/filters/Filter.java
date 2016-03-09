package party.filters;

import party.entities.Person;

public interface Filter {
    boolean isValid(Person guest);
    String getEntity();
}
