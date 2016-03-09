package party.nameRepresentation;

import org.junit.Assert;
import org.junit.Test;

public class LastFirstTest {
    @Test
    public void testCreateLastFirstToRepresentNameFormallyForMale() throws Exception {
        LastFirst name = new LastFirst();
        String informalName = name.represent("abc","xyz");
        String expectedName = "xyz, abc";
        Assert.assertEquals(expectedName,informalName);
    }
    @Test
    public void testCreateLastFirstToRepresentNameFormallyForFemale() throws Exception {
        LastFirst name = new LastFirst();
        String informalName = name.represent("abc","xyz");
        String expectedName = "xyz, abc";
        Assert.assertEquals(expectedName,informalName);
    }
}