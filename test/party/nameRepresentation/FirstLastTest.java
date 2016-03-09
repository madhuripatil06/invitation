package party.nameRepresentation;

import org.junit.Assert;
import org.junit.Test;

public class FirstLastTest {
    @Test
    public void testCreateFirstLastToRepresentNameFormallyForMale() throws Exception {
        FirstLast name = new FirstLast();
        String informalName = name.represent("abc","xyz");
        String expectedName = "abc xyz";
        Assert.assertEquals(expectedName,informalName);
    }
    @Test
    public void testCreateFirstLastToRepresentNameFormallyForFemale() throws Exception {
        FirstLast name = new FirstLast();
        String informalName = name.represent("abc","xyz");
        String expectedName = "abc xyz";
        Assert.assertEquals(expectedName,informalName);
    }
}