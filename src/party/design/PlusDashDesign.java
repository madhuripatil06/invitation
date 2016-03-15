package party.design;

public class PlusDashDesign implements Design {
    private int count = 0;

    private String generateDashes(String symbol) {
        String dashes = "";
        for (int index = 0; index < count - 2; index++)
            dashes += symbol;
        return dashes;
    }

    private String printEntity(String name) {
        int spaces = (count-3) - name.length();
        return "| " + name + generateSpaces(spaces) + "|";
    }

    private String generateSpaces(int spaces) {
        String result = "";
        for (int index = 0; index < spaces; index++) {
            result += " ";
        }
        return result;
    }

    private void setCount(String name, String cityState, String country) {
        count = name.length();
        if (cityState.length() > count)
            count = cityState.length();
        if (country.length() > count)
            count = country.length();
        count += 4;
    }

    private String generateBorder() {
        return String.format("%s%s%s", "+", generateDashes("-"), "+");
    }

    private String generateMiddleBoder() {
        return String.format("%s%s%s", "|", generateDashes("-"), "|");
    }

    @Override
    public String DesignPattern(String name, String address) {
        String[] addressEntities = address.toString().split("\n");
        String cityState = addressEntities[0];
        String country = addressEntities[1];
        setCount(name, cityState, country);
        String result = String.format("%s\n%s\n%s\n", generateBorder(), printEntity(name), generateMiddleBoder());
        result += String.format("%s\n%s\n%s\n", printEntity(cityState), printEntity(country), generateBorder());
        return result;
    }
}
