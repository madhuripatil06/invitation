package party.application;

import org.junit.Assert;
import org.junit.Test;
import party.entities.Address;
import party.entities.Name;
import party.entities.Person;

public class PrintStyleTest {
    @Test
    public void testForThePrintingStyleToGetTheNameInFirstLastOrdeForNoFilter() throws Exception {
        PrintStyle printStyle = new PrintStyle("-f");
        Name name = new Name("abc", "xyz");
        Address india = new Address("", "", "India");
        int age = 90;
        String gender = "Male";
        Person person = new Person(name, gender, india, age);
        String styledInfo = printStyle.StyleInformation(person, "");
        Assert.assertEquals(styledInfo,"Mr abc xyz");
    }

    @Test
    public void testForThePrintingStyleToGetTheNameInFirstLastOrdeForNoFilterFemale() throws Exception {
        PrintStyle printStyle = new PrintStyle("-f");
        Name name = new Name("abc", "xyz");
        Address india = new Address("", "", "India");
        int age = 90;
        String gender = "Female";
        Person person = new Person(name, gender, india, age);
        String styledInfo = printStyle.StyleInformation(person, "");
        Assert.assertEquals(styledInfo,"Ms abc xyz");
    }

    @Test
    public void testForThePrintingStyleToGetTheNameInFirstLastOrdeWithCountryFilterFemale() throws Exception {
        PrintStyle printStyle = new PrintStyle("-f");
        Name name = new Name("abc", "xyz");
        Address india = new Address("", "", "India");
        int age = 90;
        String gender = "Female";
        Person person = new Person(name, gender, india, age);
        String styledInfo = printStyle.StyleInformation(person, ", India");
        Assert.assertEquals(styledInfo,"Ms abc xyz, India");
    }

    @Test
    public void testForThePrintingStyleToGetTheNameInFirstLastOrdeWithAgeFilterFemale() throws Exception {
        PrintStyle printStyle = new PrintStyle("-f");
        Name name = new Name("abc", "xyz");
        Address india = new Address("", "", "India");
        int age = 90;
        String gender = "Female";
        Person person = new Person(name, gender, india, age);
        String styledInfo = printStyle.StyleInformation(person, ", 90");
        Assert.assertEquals(styledInfo,"Ms abc xyz, 90");
    }

    @Test
    public void testForThePrintingStyleToGetTheNameInFirstLastOrdeWithNoFilterFemaleFormally() throws Exception {
        PrintStyle printStyle = new PrintStyle("-l");
        Name name = new Name("abc", "xyz");
        Address india = new Address("", "", "India");
        int age = 90;
        String gender = "Female";
        Person person = new Person(name, gender, india, age);
        String styledInfo = printStyle.StyleInformation(person, "");
        Assert.assertEquals(styledInfo,"Ms xyz, abc");
    }
}