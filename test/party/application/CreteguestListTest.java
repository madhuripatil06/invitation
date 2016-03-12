package party.application;

import org.junit.Before;
import org.junit.Test;
import party.entities.Person;
import party.filters.AgeFilter;
import party.filters.CountryFilter;
import party.filters.Filter;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreteguestListTest {
    String ramon;
    String buddy;
    String vivienne;
    String anya;
    String daisha;
    @Before
    public void setUp() throws Exception {
        ramon = "Ramon,Windler,Female,24,Crooks ton,Georgia,Bangladesh";
        buddy = "Buddy,Nitzsche,Male,34,Katlynn view,Illinois,Romania";
        vivienne = "Vivienne,Stamm,Male,33,New Alanna,Illinois,Macedonia";
        anya = "Anya,Cruickshank,Male,30,Veda haven,Illinois,Romania";
        daisha = "Daisha,Steuber,Male,19,Veda haven,North Carolina,Macedonia";
    }

    @Test
    public void testForTheGuestListToAddAllTheGuestsToListIfThereIsNoFilter() throws Exception {
        CreateGuestList guests = new CreateGuestList(new ArrayList<Filter>(0));
        guests.add(ramon);
        guests.add(buddy);
        guests.add(anya);
        guests.add(daisha);
        guests.add(vivienne);
        int size = guests.sortedGuests().size();
        assertEquals(5,size);
    }

    @Test
    public void testForTheGuestListToAddOnlyValidGuestsIfThereIsACountryFilter() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new CountryFilter("Romania"));
        CreateGuestList guests = new CreateGuestList(filters);
        guests.add(ramon);
        guests.add(buddy);
        guests.add(anya);
        guests.add(daisha);
        guests.add(vivienne);
        ArrayList<Person> sortedGuests = guests.sortedGuests();
        int size = sortedGuests.size();
        for (Person sortedGuest : sortedGuests) {
            assertTrue(sortedGuest.isFromCountry("Romania"));
        }
        assertEquals(2,size);
    }

    @Test
    public void testForTheGuestListToAddOnlyValidGuestsIfThereIsAgeFilter() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new AgeFilter(25));
        CreateGuestList guests = new CreateGuestList(filters);
        guests.add(ramon);
        guests.add(buddy);
        guests.add(anya);
        guests.add(daisha);
        guests.add(vivienne);
        ArrayList<Person> sortedGuests = guests.sortedGuests();
        int size = sortedGuests.size();
        for (Person sortedGuest : sortedGuests) {
            assertTrue(sortedGuest.isAbove(25));
        }
        assertEquals(3,size);
    }


    @Test
    public void testForTheGuestListToAddOnlyValidGuestsIfThereAreMultipleFilters() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new AgeFilter(31));
        filters.add(new CountryFilter("Romania"));
        CreateGuestList guests = new CreateGuestList(filters);
        guests.add(ramon);
        guests.add(buddy);
        guests.add(anya);
        guests.add(daisha);
        guests.add(vivienne);
        ArrayList<Person> sortedGuests = guests.sortedGuests();
        int size = sortedGuests.size();
        for (Person guest : sortedGuests) {
            assertTrue(guest.isFromCountry("Romania"));
            assertTrue(guest.isAbove(31));
        }
        assertEquals(1,size);
    }
}