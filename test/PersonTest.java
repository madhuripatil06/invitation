import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testForThePersonclassToGetTheNameofThePersonForMale() throws Exception {
        Name name = new Name("abc", "xyz", "Male");
        Address address = new Address( "bengluru", "karnataka", "india");
        Person person = new Person(name, 23,address);
        String nameInOrderFirstLast = person.getNameInOrderFirstLast();
        assertEquals("Mr abc xyz",nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Name name = new Name("abc", "xyz", "Male");
        Address address = new Address( "bengluru", "karnataka", "india");
        Person person = new Person(name, 23,address);
        String nameInOrderLastFirst = person.getNameInOrderLastFirst();
        assertEquals("Mr xyz, abc",nameInOrderLastFirst);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Name name = new Name("mili", "deo", "Female");
        Address address = new Address( "haldia", "westBengal", "India");
        Person person = new Person(name, 20,address);
        String nameInOrderFirstLast = person.getNameInOrderFirstLast();
        assertEquals("Ms mili deo",nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Name name = new Name("mili", "deo", "Female");
        Address address = new Address( "haldia", "westBengal", "India");
        Person person = new Person(name, 20,address);
        String nameInOrderLastFirst = person.getNameInOrderLastFirst();
        assertEquals("Ms deo, mili",nameInOrderLastFirst);
    }
}