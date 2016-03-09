package party.nameRepresentation;

public class LastFirst implements Representation {
    @Override
    public String represent(String first, String last) {
        return String.format("%s, %s",last,first);
    }
}
