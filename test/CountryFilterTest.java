import party.filters.CountryFilter;
import org.junit.Test;
import party.entities.Address;
import party.entities.Name;
import party.entities.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryFilterTest {
    @Test
    public void testCountryFilterTocheckifTheGivenPersonIsFromIt() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("India");
        Person person = new Person(name, "Male", address, 67);

        CountryFilter filter = new CountryFilter("India");
        assertTrue(filter.isValid(person));
        assertEquals(filter.getEntity(person),"India");
    }

    @Test
    public void testCountryFilterForTheInvalidPerson() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("India");
        Person person = new Person(name, "Male", address, 67);

        CountryFilter filter = new CountryFilter("USA");
        assertFalse(filter.isValid(person));
        assertEquals(filter.getEntity(person),"USA");
    }
}