package party.operator;

import party.filters.AgeFilter;
import party.filters.CountryFilter;
import party.filters.Filter;

import java.util.ArrayList;

public class ArgumentSplitter {
    public ArrayList<Filter> filters;
    public String[] files;
    public String[] options;

    public ArgumentSplitter(String[] arguments) {
        this.filters = new ArrayList<Filter>();
        this.options = splitOptions(arguments);
        this.files = splitFile(arguments);
    }

    private String[] splitFile(String[] options) {
        String file = "";
        for (String option : options) {
            if (option.charAt(0) != '-')
                file += option + " ";
        }
        return file.trim().split(" ");
    }

    private void addFilters(String option) {
        if (option.substring(0, 5).equals("-from")) {
            String country = option.substring(5);
            filters.add(new CountryFilter(country));
        } else if (option.substring(0, 6).equals("-above")) {
            int age = Integer.parseInt(option.substring(6));
            filters.add(new AgeFilter(age));
        }
    }

    private String[] splitOptions(String[] options) {
        String allOptions = "";
        for (String option : options) {
            if (option.charAt(0) == '-') {
                if (option.length() == 2)
                    allOptions += option + " ";
                else addFilters(option);
            }
        }
        if (allOptions.equals(""))
            allOptions = "-f";
        return allOptions.trim().split(" ");
    }
}
