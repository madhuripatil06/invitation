import org.junit.Test;
import party.application.Style;
import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testForThePersonclassToGetTheNameofThePersonForMale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Age age = new Age(23);
        Person person = new Person(name, "Male", address, age);
        Style representation = Style.FirstLast;
        assertEquals("Mr abc xyz", person.represent(representation));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Name name = new Name("abc", "xyz");
        Address address = new Address("", "", "india");
        Age age = new Age(23);
        Person person = new Person(name, "Male", address, age);
        Style representation = Style.LastFirst;
        assertEquals("Mr xyz, abc", person.represent(representation));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Age age = new Age(23);
        Person person = new Person(name, "Female", address, age);
        Style representation = Style.FirstLast;
        String nameInOrderFirstLast = person.represent(representation);
        assertEquals("Ms mili deo", nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Name name = new Name("mili", "deo");
        Address address = new Address("", "", "India");
        Age age = new Age(20);
        Person person = new Person(name, "Female", address, age);
        Style representation = Style.LastFirst;
        assertEquals("Ms deo, mili", person.represent(representation));
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