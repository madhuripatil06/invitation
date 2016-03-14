package party.entityTest;

import org.junit.Test;
import party.entities.Address;

import static org.junit.Assert.*;

public class AddressTest {
    @Test
    public void testToCheckIfThepersonIsFromTheGivenCountry() throws Exception {
        Address address = new Address("", "", "nako");
        assertTrue(address.isFromCountry("nako"));
        assertFalse(address.isFromCountry("kon"));
    }
}