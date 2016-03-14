package party.design;

public class PlusDashDesign implements Design {
    private String generateDashes(){
        String dashes = "";
        for(int index = 0 ; index <30 ;index++ )
            dashes += "-";
        return dashes;
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

    private String generateBorder(){
        return  String.format("%s%s%s","+",generateDashes(),"+");
    }

    private String generateMiddleBoder(){
        return String.format("%s%s%s","|",generateDashes(),"|");
    }

    @Override
    public String DesignPattern(String name, String address) {
        String [] addressEntities = address.toString().split("\n");
        String result = String.format("%s\n%s\n%s\n",generateBorder(),printEntity(name),generateMiddleBoder());
        result += String.format("%s\n%s\n%s\n",printEntity(addressEntities[0]),printEntity(addressEntities[1]),generateBorder());
        return result;
    }
}
