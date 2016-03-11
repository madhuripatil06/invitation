package party.application;

import party.entities.Person;
import party.filters.Filter;

import java.util.ArrayList;

public class InvitationCoverPrinter implements Printer {
    @Override
    public void print(ArrayList<Person> guests, ArrayList<Filter> filters, String option) {
        Style printStyle = Style.parse(option);
        for (Person guest : guests) {
            String name = guest.represent(printStyle);
            String address = guest.address();
            printCover(name,address);
        }
    }

    private String generateDashes(){
        String dashes = "";
        for(int index = 0 ; index <30 ;index++ )
            dashes += "-";
        return dashes;
    }

    private String generateBorder(){
        return  String.format("%s%s%s","+",generateDashes(),"+");
    }

    private String generateMiddleBoder(){
        return String.format("%s%s%s","|",generateDashes(),"|");
    }

    private void printCover(String name, String address) {
        String [] addressEntities = address.split(", ");
        String cityState = addressEntities[0]+", "+addressEntities[1];
        String country = addressEntities[2];
        String cover = generateDesign(name,cityState,country);
        System.out.println(cover);
    }

    private String generateDesign(String name, String cityState, String country) {
        String result = String.format("%s\n%s\n%s\n",generateBorder(),printEntity(name),generateMiddleBoder());
        result += String.format("%s\n%s\n%s\n",printEntity(cityState),printEntity(country),generateBorder());
        return result;
    }

    private String printEntity(String name) {
        int spaces = 29-name.length();
       return "| "+name+generateSpaces(spaces)+"|";
    }

    private String generateSpaces(int spaces) {
        String result="";
        for(int index = 0 ;index <spaces  ; index++ ){
            result += " ";
        }
        return result;
    }
}
