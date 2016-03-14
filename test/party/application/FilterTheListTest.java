package party.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import party.filters.AgeFilter;
import party.filters.CountryFilter;
import party.filters.Filter;
import party.guestList.CreateGuestList;
import party.guestList.FilterTheList;

import java.util.ArrayList;

public class FilterTheListTest {
    CreateGuestList list;
    @Before
    public void setUp() throws Exception {
        String filedata = "Ramon,Windler,Female,24,Crooks ton,Georgia,Bangladesh\nBuddy,Nitzsche,Male,34,Katlynn view,Illinois,Romania\nVivienne,Stamm,Male,33,New Alanna,Illinois,Macedonia\nAnya,Cruickshank,Male,30,Veda haven,Illinois,Romania\nDaisha,Steuber,Male,19,Veda haven,North Carolina,Macedonia";
        list = new CreateGuestList(filedata);
        list.createList();
    }

    @Test
    public void FilterTheListShouldReturnTheFilterdListIfTheListISGivenForTheCountryFilter() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new CountryFilter("Romania"));
        FilterTheList filterTheList = new FilterTheList(filters, list.getList());
        Assert.assertEquals(2,filterTheList.getFilteredGuest().size());
    }

    @Test
    public void FilterTheListShouldReturnTheFilterdListIfTheListISGivenForTheAgeFilter() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new AgeFilter(20));
        FilterTheList filterTheList = new FilterTheList(filters, list.getList());
        Assert.assertEquals(4,filterTheList.getFilteredGuest().size());
    }

    @Test
    public void FilterTheListShouldReturnTheFilterdListIfTheListISGivenForBothAgeFilterAndCountryFilter() throws Exception {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        filters.add(new AgeFilter(31));
        filters.add(new CountryFilter("Romania"));
        FilterTheList filterTheList = new FilterTheList(filters, list.getList());
        Assert.assertEquals(1,filterTheList.getFilteredGuest().size());
    }
}