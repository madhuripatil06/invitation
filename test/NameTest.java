import org.junit.Test;
import party.application.Style;
import party.entities.Name;

import static org.junit.Assert.assertEquals;

public class NameTest {
    @Test
    public void testForTheNameOfTheMalePersonInFormalWay() throws Exception {
        Name name = new Name("mai", "Idiot");
        String expected = "mai Idiot";
        Style representation = Style.FirstLast;
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfTheMalePersonInInformalWay() throws Exception {
        Name name = new Name("mai", "Idiot");
        String expected = "Idiot, mai";
        Style representation = Style.LastFirst;
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfFemaleInFormalWay() throws Exception {
        Name name = new Name("mai", "houseWife");
        String expected = "mai houseWife";
        Style representation = Style.FirstLast;
        assertEquals(expected,name.represent(representation));
    }

    @Test
    public void testForTheNameOfFemaleInInformalWay() throws Exception {
        Name name = new Name("mai", "houseWife");
        String expected = "houseWife, mai";
        Style representation = Style.LastFirst;
        assertEquals(expected,name.represent(representation));
    }
}