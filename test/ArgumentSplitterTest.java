import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArgumentSplitterTest {
    @Test
    public void testForTheSplittingOfTheOptionsWhenitIsGiven() throws Exception {
        String [] options = {"-f", "hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String[] expectedFiles = {"hello.txt"};
        assertArrayEquals(expectedFiles, argumentSplitter.files);
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.options);
    }

    @Test
    public void testForThesplittingOfTheOptionsWhenNoOptionProvided() throws Exception {
        String [] file = {"hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(file);
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.options);
    }

    @Test
    public void testForTheMultipleFiles() throws Exception {
        String [] options = {"-l","hello.txt","world.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-l"};
        assertArrayEquals(expectedOptions, argumentSplitter.options);
        String [] files = {"hello.txt","world.txt"};
        assertArrayEquals(files, argumentSplitter.files);
    }

    @Test
    public void testAddTheFiltersToTheOptionsIfItHasTheCountryName() throws Exception {
        String [] options = {"-l","-fromMacedonia","hello.txt","world.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-l"};
        assertArrayEquals(expectedOptions, argumentSplitter.options);
        String [] files = {"hello.txt","world.txt"};
        assertEquals(1, argumentSplitter.getFilters().size());
        assertArrayEquals(files, argumentSplitter.files);
    }
}