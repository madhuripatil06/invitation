import party.filters.AgeFilter;
import org.junit.Test;
import party.entities.Address;
import party.entities.Name;
import party.entities.Person;

import static org.junit.Assert.*;

public class AgeFilterTest {
    @Test
    public void testForThePersonAboveTheGivenAge() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name, "Male", address, 67);
        AgeFilter ageFilter = new AgeFilter(23);
        assertTrue(ageFilter.isValid(person));
        assertEquals(ageFilter.getEntity(),"67");
    }
    @Test
    public void testForThePersonAboveTheGivenAgeIfThePersonIsNotValid() throws Exception {
        Name name = new Name("abc","xyz");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name, "Male", address, 9);
        AgeFilter ageFilter = new AgeFilter(23);
        assertFalse(ageFilter.isValid(person));
        assertNotEquals(ageFilter.getEntity(),"67");
    }
}