package party.printers;

import party.entities.Person;
import party.filters.Filter;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import java.util.ArrayList;
import java.util.HashMap;

public class
TerminalPrinter implements Printer {
    private Representation getRepresentation(String option) {
        HashMap<String , Representation> styles = new HashMap<String, Representation>();
        styles.put("-f",new FirstLast());
        styles.put("-l",new LastFirst());
        return styles.get(option);
    }

    @Override
    public void print(ArrayList<Person> guests, ArrayList<Filter> filters, String option) {
        Representation representation = getRepresentation(option);
        for (Person guest : guests) {
            System.out.println(guest.represent(representation));
        }
    }
}
