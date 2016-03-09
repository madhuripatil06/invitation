import java.util.ArrayList;
import java.util.HashMap;

public class GuestList {
    private ArrayList<Person> guests;
    private ArrayList<Filter> filters;

    public GuestList(ArrayList<Filter> filters) {
        this.filters = filters;
        this.guests = new ArrayList<Person>();
    }

    public void add(String person) {
        String[] guestInfo = person.split(",");
        int age = Integer.parseInt(guestInfo[3]);
        Name name = new Name(guestInfo[0], guestInfo[1]);
        Address address = new Address(guestInfo[4], guestInfo[5], guestInfo[6]);
        String gender =  guestInfo[2];
        Person guest = new Person(name,gender, address, age);
        guests.add(guest);
    }

    public String getName(Person guest, String option) {
        HashMap<String, String> name = new HashMap<String, String>();
        name.put("-f", guest.getNameInOrderFirstLast());
        name.put("-l", guest.getNameInOrderLastFirst());
        return name.get(option);
    }

    private String filterForEachFilter(Person guest) {
        String result = "";
        for (Filter filter : filters) {
            if (!filter.isValid(guest))
                return "";
            result += ", "+filter.getEntity();
        }
        return result;
    }

    public void print(String[] options) {
        for (Person guest : guests) {
            if (filters == null)
                System.out.println(getName(guest, options[0]));
            String filteredOutput = filterForEachFilter(guest);
            if (!filteredOutput.equals("")) {
                System.out.println(getName(guest, options[0])  + filteredOutput);
            }
        }
    }
}
