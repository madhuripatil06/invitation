import org.junit.Test;
import party.application.Style;
import party.entities.Address;
import party.entities.Name;
import party.entities.Person;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testForThePersonclassToGetTheNameofThePersonForMale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Person person = new Person(name, "Male", address, 23);
        Style representation = Style.FirstLast;
        assertEquals("Mr abc xyz",person.represent(representation));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Person person = new Person(name, "Male", address, 23);
        Style representation = Style.LastFirst;
        assertEquals("Mr xyz, abc",person.represent(representation));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Person person = new Person(name, "Female", address, 20);
    Style representation = Style.FirstLast;
        String nameInOrderFirstLast = person.represent(representation);
        assertEquals("Ms mili deo",nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Person person = new Person(name, "Female", address, 20);
        Style representation = Style.LastFirst;
        assertEquals("Ms deo, mili",person.represent(representation));
    }
    @Test
    public void testForThePersonToNotChangeHisAge() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Person person = new Person(name, "Female", address, 20);
        int age = person.howOldAreYou();
        assertEquals(20,person.howOldAreYou());
    }
}