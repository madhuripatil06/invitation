package party.application;

import party.entities.Person;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import java.util.HashMap;

public class PrintStyle {
    private String style;
    private HashMap<String, Representation> name;

    public PrintStyle(String style) {
        this.name = new HashMap<String, Representation>();
        this.name.put("-f", new FirstLast());
        this.name.put("-l", new LastFirst());
        this.style = style;
    }

    private String getName(Person guest, String option) {
        return guest.represent(name.get(option));
    }
    
    public String StyleInformation(Person guest, String filteredData) {
        return getName(guest, style) + filteredData;
    }
}
