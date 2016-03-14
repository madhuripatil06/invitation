package party.entityTest;

import org.junit.Test;
import party.entities.Name;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import static org.junit.Assert.assertEquals;

public class NameTest {
    @Test
    public void testForTheNameOfTheMalePersonInFormalWay() throws Exception {
        Name name = new Name("mai", "Idiot");
        String expected = "mai Idiot";
        Representation representation = new FirstLast();
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfTheMalePersonInInformalWay() throws Exception {
        Name name = new Name("mai", "Idiot");
        String expected = "Idiot, mai";
        Representation representation = new LastFirst();
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfFemaleInFormalWay() throws Exception {
        Name name = new Name("mai", "houseWife");
        String expected = "mai houseWife";
        Representation representation = new FirstLast();
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfFemaleInInformalWay() throws Exception {
        Name name = new Name("mai", "houseWife");
        String expected = "houseWife, mai";
        Representation representation = new LastFirst();
        assertEquals(expected,name.represent(representation));
    }
}