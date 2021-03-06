package party.filterTest;

import org.junit.Test;
import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;
import party.filters.AgeFilter;

import static org.junit.Assert.*;

public class AgeFilterTest {
    @Test
    public void testForThePersonAboveTheGivenAge() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("", "", "India");
        Age age = new Age(67);
        Person person = new Person(name, "Male", address, age);
        AgeFilter ageFilter = new AgeFilter(23);
        assertTrue(ageFilter.isValid(person));
    }
    @Test
    public void testForThePersonAboveTheGivenAgeIfThePersonIsNotValid() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("", "", "India");
        Age age = new Age(9);
        Person person = new Person(name, "Male", address,age);
        AgeFilter ageFilter = new AgeFilter(23);
        assertFalse(ageFilter.isValid(person));
    }
}