package party.application;

import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public class FilterTheList {
    private ArrayList<Filter> filters;
    private ArrayList<Person> guests;
    private ArrayList<Person> validGuests;

    public FilterTheList(ArrayList<Filter> filters , ArrayList<Person>guests) {
        this.filters = filters;
        this.guests = guests;
        this.validGuests = new ArrayList<Person>();
    }

    private boolean isValidForEachFilter(Person guest){
        for (Filter filter : filters) {
            if(!filter.isValid(guest))
                return false;
        }
        return true;
    }

    private void filter(){
        for (Person guest : guests) {
            if(isValidForEachFilter(guest))
                validGuests.add(guest);
        }
    }

    public ArrayList<Person> getFilteredGuest(){
        filter();
        return validGuests;
    }
}
