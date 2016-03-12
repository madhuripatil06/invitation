import org.junit.Test;
import party.entities.Address;
import party.entities.Age;
import party.entities.Name;
import party.entities.Person;
import party.filters.CountryFilter;

import static org.junit.Assert.*;

public class CountryFilterTest {
    @Test
    public void testCountryFilterTocheckifTheGivenPersonIsFromIt() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("", "", "India");
        Age age = new Age(67);
        Person person = new Person(name, "Male", address, age);

        CountryFilter filter = new CountryFilter("India");
        assertTrue(filter.isValid(person));
        assertEquals(filter.getEntity(person),"India");
    }

    @Test
    public void testCountryFilterForTheInvalidPerson() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("", "", "India");
        Age age = new Age(67);
        Person person = new Person(name, "Male", address, age);

        CountryFilter filter = new CountryFilter("USA");
        assertFalse(filter.isValid(person));
        assertEquals(filter.getEntity(person),"USA");
    }
}