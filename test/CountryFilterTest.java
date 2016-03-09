import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryFilterTest {
    @Test
    public void testCountryFilterTocheckifTheGivenPersonIsFromIt() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name, "Male", address, 67);

        CountryFilter filter = new CountryFilter("India");
        assertTrue(filter.isValid(person));
        assertEquals(filter.getEntity(),"India");
    }

    @Test
    public void testCountryFilterForTheInvalidPerson() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name, "Male", address, 67);

        CountryFilter filter = new CountryFilter("USA");
        assertFalse(filter.isValid(person));
        assertEquals(filter.getEntity(),"USA");
    }
}