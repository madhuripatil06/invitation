import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {
    @Test
    public void testForTheNameOfTheMalePersonInFormalWay() throws Exception {
        Name name = new Name("mai", "Idiot", "Male");
        String expected = "Mr mai Idiot";
        assertEquals(expected,name.nameFirstLast());
    }

    @Test
    public void testForTheNameOfTheMalePersonInInformalWay() throws Exception {
        Name name = new Name("mai", "Idiot", "Male");
        String expected = "Mr Idiot, mai";
        assertEquals(expected,name.nameLastFirst());
    }

    @Test
    public void testForTheNameOfFemaleInFormalWay() throws Exception {
        Name name = new Name("mai", "houseWife", "Female");
        String expected = "Ms mai houseWife";
        assertEquals(expected,name.nameFirstLast());
    }

    @Test
    public void testForTheNameOfFemaleInInformalWay() throws Exception {
        Name name = new Name("mai", "houseWife", "Female");
        String expected = "Ms houseWife, mai";
        assertEquals(expected,name.nameLastFirst());
    }
}