package party.printers;

import party.design.Design;
import party.design.PlusDashDesign;
import party.entities.Person;
import party.filters.Filter;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import java.util.ArrayList;
import java.util.HashMap;

public class InvitationCoverPrinter implements Printer {
    @Override
    public void print(ArrayList<Person> guests, ArrayList<Filter> filters, String option) {
        Representation representation = getRepresentation(option);
        for (Person guest : guests) {
            String name = guest.represent(representation, filters);
            String address = guest.address();
            printCover(name,address);
        }
    }

    private void printCover(String name, String address) {
        Design design = new PlusDashDesign();
        System.out.println(design.DesignPattern(name,address));
    }

    private Representation getRepresentation(String option) {
        HashMap<String , Representation> styles = new HashMap<String, Representation>();
        styles.put("-f",new FirstLast());
        styles.put("-l",new LastFirst());
        return styles.get(option);
    }
}
