package party.application;

import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public class
TerminalPrinter implements Printer {
    private String askForData(Person guest, ArrayList<Filter> filters) {
        String result = "";
        for (Filter filter : filters) {
            result += ", " + filter.getEntity(guest);
        }
        return result;
    }

    @Override
    public void print(ArrayList<Person> guests, ArrayList<Filter> filters, String option) {
        Style printStyle = Style.parse(option);
        for (Person guest : guests) {
            String filteredOutput = askForData(guest, filters);
            System.out.println(guest.represent(printStyle)+filteredOutput);
        }
    }
}
