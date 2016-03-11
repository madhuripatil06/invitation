package party.application;

import org.junit.Assert;
import org.junit.Test;

public class StyleTest {
    @Test
    public void TheStyleShouldReturnTheNameInFirstLastOrderIfminusfIsProvidedToIt() throws Exception {
        Style style = Style.parse("-f");
        assert style != null;
        String text = style.represent("Hello", "World");
        Assert.assertEquals(text,"Hello World");
    }

    @Test
    public void TheStyleShouldReturnTheNameInLastFirstOrderIfminuslIsProvidedToIt() throws Exception {
        Style style = Style.parse("-l");
        assert style != null;
        String text = style.represent("Hello", "World");
        Assert.assertEquals(text,"World, Hello");
    }
}