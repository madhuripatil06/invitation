import org.junit.Test;
import party.entities.Address;
import party.entities.Name;
import party.entities.Person;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testForThePersonclassToGetTheNameofThePersonForMale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Person person = new Person(name, "Male", address, 23);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz",person.represent(representation));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Person person = new Person(name, "Male", address, 23);
        Representation representation = new LastFirst();
        assertEquals("Mr xyz, abc",person.represent(representation));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Person person = new Person(name, "Female", address, 20);
        Representation representation = new FirstLast();
        String nameInOrderFirstLast = person.represent(representation);
        assertEquals("Ms mili deo",nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Person person = new Person(name, "Female", address, 20);
        Representation representation = new LastFirst();
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