import org.junit.Test;

import static org.junit.Assert.*;

public class AgeFilterTest {
    @Test
    public void testForThePersonAboveTheGivenAge() throws Exception {
        Name name = new Name("abc","xyz","Male");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name,67,address);
        AgeFilter ageFilter = new AgeFilter(23);
        assertTrue(ageFilter.isValid(person));
        assertEquals(ageFilter.getEntity(),"67");
    }
    @Test
    public void testForThePersonAboveTheGivenAgeIfThePersonIsNotValid() throws Exception {
        Name name = new Name("abc","xyz","Male");
        Address address = new Address("bengluru","karnataka","India");
        Person person = new Person(name,9,address);
        AgeFilter ageFilter = new AgeFilter(23);
        assertFalse(ageFilter.isValid(person));
        assertNotEquals(ageFilter.getEntity(),"67");
    }
}