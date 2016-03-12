package party.operator;

import party.filters.AgeFilter;
import party.filters.CountryFilter;
import party.filters.Filter;

import java.util.ArrayList;

public class ArgumentSplitter {

    private final String[] arguments;

    public ArgumentSplitter(String[] arguments) {
        this.arguments = arguments;
    }

    public String[] getFiles() {
        String file = "";
        for (String argument : arguments) {
            if (argument.charAt(0) != '-')
                file += argument + " ";
        }
        return file.trim().split(" ");
    }

    public ArrayList<Filter> getFilters(){
        ArrayList<Filter> filters = new ArrayList<Filter>();
        for (String argument : arguments) {
            if (argument.length() > 6 && argument.substring(0, 5).equals("-from")) {
                String country = argument.substring(5);
                filters.add(new CountryFilter(country));
            } else if (argument.length() > 6 && argument.substring(0, 6).equals("-above")) {
                int age = Integer.parseInt(argument.substring(6));
                filters.add(new AgeFilter(age));
            }
        }
        return filters;
    }

    public String[] getStyle() {
        String allOptions = "";
        for (String argument : arguments) {
            if (argument.charAt(0) == '-') {
                if (argument.length() == 2)
                    allOptions += argument + " ";
            }
        }
        if (allOptions.equals(""))
            allOptions = "-f";
        return allOptions.trim().split(" ");
    }
}
