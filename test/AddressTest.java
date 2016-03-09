import org.junit.Test;
import party.entities.Address;

import static org.junit.Assert.*;

public class AddressTest {
    @Test
    public void testToAddThecityStateAndCountryToIt() throws Exception {
        Address address = new Address("maziCity", "mazaState", "maziCountry");
        String expected = "maziCity, mazaState maziCountry";
        assertEquals(expected,address.toString());
    }

    @Test
    public void testToCheckIfThepersonIsFromTheGivenCountry() throws Exception {
        Address address = new Address("mala", "kahihi", "nako");
        assertTrue(address.isFromCountry("nako"));
        assertFalse(address.isFromCountry("kon"));
    }
}