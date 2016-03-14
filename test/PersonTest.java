import org.junit.Test;
import party.entities.Address;
import party.entities.Age;
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
        Age age = new Age(23);
        Person person = new Person(name, "Male", address, age);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz", person.represent(representation,null));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Age age = new Age(23);
        Person person = new Person(name, "Male", address, age);
        Representation representation = new LastFirst();
        assertEquals("Mr xyz, abc", person.represent(representation,null));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Age age = new Age(23);
        Person person = new Person(name, "Female", address, age);
        Representation representation = new FirstLast();
        String nameInOrderFirstLast = person.represent(representation,null);
        assertEquals("Ms mili deo", nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Age age = new Age(20);
        Person person = new Person(name, "Female", address, age);
        Representation representation = new LastFirst();
        assertEquals("Ms deo, mili", person.represent(representation,null));
    }

    @Test
    public void testForThePersonToNotChangeHisAge() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Age age = new Age(20);
        Person person = new Person(name, "Female", address, age);
        String ageString = person.howOldAreYou();
        assertEquals("20", person.howOldAreYou());
    }
}