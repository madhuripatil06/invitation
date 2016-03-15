package party.entityTest;

import org.junit.Before;
import org.junit.Test;
import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;
import party.filters.AgeFilter;
import party.filters.CountryFilter;
import party.filters.Filter;
import party.nameRepresentation.FirstLast;
import party.nameRepresentation.LastFirst;
import party.nameRepresentation.Representation;

import java.util.ArrayList;

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
        assertEquals("Mr abc xyz", person.represent(representation,null));
    }

    @Test
    public void testForThePersonToGetTheNameInFormalWayForFemale() throws Exception {
        Person person = new Person(name, "Male", address, age);
        Representation representation = new LastFirst();
        assertEquals("Mr xyz, abc", person.represent(representation,null));
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInInformalWay() throws Exception {
        Person person = new Person(name, "Female", address, age);
        Representation representation = new FirstLast();
        String nameInOrderFirstLast = person.represent(representation,null);
        assertTrue(person.isAbove(20));
        assertFalse(person.isAbove(24));
        assertFalse(person.isAbove(23));
        assertEquals("Ms abc xyz", nameInOrderFirstLast);
    }

    @Test
    public void testForThePersonToGetNameOfAFemaleInFormalWay() throws Exception {
        Person person = new Person(name, "Female", address, age);
        Representation representation = new LastFirst();
        assertEquals("Ms xyz, abc", person.represent(representation,null));
    }

    @Test
    public void TheRepresentationOfThePersonWithAgeFilterShouldIncludeAgeInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        ArrayList<Filter>filters = new ArrayList<Filter>();
        filters.add(new AgeFilter(20));
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz, 23", person.represent(representation,filters));
    }

    @Test
    public void TheRepresentationOfThePersonWithCountryFilterShouldIncludeCountryInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        ArrayList<Filter>filters = new ArrayList<Filter>();
        filters.add(new CountryFilter("India"));
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz, India", person.represent(representation,filters));
    }

    @Test
    public void TheRepresentationOfThePersonWithCountryFilterAndAgeFilterShouldIncludeCountryAndAgeInRepresentation() throws Exception {
        Person person = new Person(name, "Male", address, age);
        ArrayList<Filter>filters = new ArrayList<Filter>();
        filters.add(new CountryFilter("India"));
        filters.add(new AgeFilter(22));
        Representation representation = new FirstLast();
        assertEquals("Mr abc xyz, India, 23", person.represent(representation,filters));
    }
}