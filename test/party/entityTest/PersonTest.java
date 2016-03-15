package party.entityTest;

import org.junit.Before;
import org.junit.Test;
import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import static org.junit.Assert.*;

public class PersonTest {
    Name name;
    Address address;
    Age age;
    @Before
    public void setUp() throws Exception {
        name = new Name("abc", "xyz");
        address = new Address("bengluru", "Karnataka", "India");
        age = new Age(23);
    }

    @Test
    public void TheAddressOfThePersonShouldReturnTheAddressInCityStatenewLineCoutryFormat() throws Exception {
        Person person = new Person(name, "Male", address, age);
        String address = person.address();
        String expected = "bengluru, Karnataka,\nIndia";
        assertEquals(expected,address);
    }

    @Test
    public void testForThePersonclassToGetTheNameofThePersonForMale() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz", person.represent(representation));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new LastFirst();
        assertEquals("Mr xyz, abc", person.represent(representation));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Person person = new Person(name, "Female", address, age);
        Representation representation = new FirstLast();
        String nameInOrderFirstLast = person.represent(representation);
        assertTrue(person.isAbove(20));
        assertFalse(person.isAbove(24));
        assertFalse(person.isAbove(23));
        assertEquals("Ms abc xyz", nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Person person = new Person(name, "Female", address, age);
        Representation representation = new LastFirst();
        assertEquals("Ms xyz, abc", person.represent(representation));
    }

    @Test
    public void TheRepresentationOfThePersonWithAgeFilterShouldIncludeAgeInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz", person.represent(representation));
    }

    @Test
    public void TheRepresentationOfThePersonWithCountryFilterShouldIncludeCountryInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz", person.represent(representation));
    }

    @Test
    public void TheRepresentationOfThePersonWithCountryFilterAndAgeFilterShouldIncludeCountryAndAgeInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz", person.represent(representation));
    }
}