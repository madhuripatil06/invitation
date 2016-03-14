package party.application;

import org.junit.Before;
import org.junit.Test;
import party.guestList.CreateGuestList;

import static org.junit.Assert.assertEquals;

public class CreteguestListTest {
    String filedata;
    @Before
    public void setUp() throws Exception {
        filedata = "Ramon,Windler,Female,24,Crooks ton,Georgia,Bangladesh\nBuddy,Nitzsche,Male,34,Katlynn view,Illinois,Romania \nVivienne,Stamm,Male,33,New Alanna,Illinois,Macedonia \nAnya,Cruickshank,Male,30,Veda haven,Illinois,Romania \nDaisha,Steuber,Male,19,Veda haven,North Carolina,Macedonia";
    }

    @Test
    public void testForTheGuestListToAddAllTheGuestsToList() throws Exception {
        CreateGuestList guests = new CreateGuestList(filedata);
        guests.createList();
        int size = guests.getList().size();
        assertEquals(5,size);
    }
}