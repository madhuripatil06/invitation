package party.nameRepresentation;

public class FirstLast implements Representation {
    @Override
    public String represent(String first, String last) {
        return String.format("%s %s", first, last);
    }
}
