package party.application;

import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public interface Printer {
    void print(ArrayList<Person>guests , ArrayList<Filter> filters,String option);
}
