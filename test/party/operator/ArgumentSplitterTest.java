package party.operator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArgumentSplitterTest {
    @Test
    public void testForTheSplittingOfTheOptionsWhenitIsGiven() throws Exception {
        String [] options = {"-f", "hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String[] expectedFiles = {"hello.txt"};
        assertArrayEquals(expectedFiles, argumentSplitter.getFiles());
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
    }

    @Test
    public void testForThesplittingOfTheOptionsWhenNoOptionProvided() throws Exception {
        String [] file = {"hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(file);
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
    }

    @Test
    public void testForTheMultipleFiles() throws Exception {
        String [] options = {"-l","hello.txt","world.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-l"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
        String [] files = {"hello.txt","world.txt"};
        assertArrayEquals(files, argumentSplitter.getFiles());
    }

    @Test
    public void testAddTheFiltersToTheOptionsIfItHasTheCountryName() throws Exception {
        String [] options = {"-l","-fromMacedonia","hello.txt","world.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-l"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
        String [] files = {"hello.txt","world.txt"};
        assertEquals(1, argumentSplitter.getFilters().size());
        assertArrayEquals(files, argumentSplitter.getFiles());
    }

    @Test
    public void testAddTheFiltersToAddAgeFilterToIt() throws Exception {
        String [] options = {"-above9","hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
        String [] files = {"hello.txt"};
        assertEquals(1, argumentSplitter.getFilters().size());
        assertArrayEquals(files, argumentSplitter.getFiles());
    }

    @Test
    public void testAddTheFiltersToAddBothAgeFilterAndCountryFilter() throws Exception {
        String [] options = {"-fromBangladesh","-above9","hello.txt"};
        ArgumentSplitter argumentSplitter = new ArgumentSplitter(options);
        String [] expectedOptions = {"-f"};
        assertArrayEquals(expectedOptions, argumentSplitter.getStyle());
        String [] files = {"hello.txt"};
        assertEquals(2, argumentSplitter.getFilters().size());
        assertArrayEquals(files, argumentSplitter.getFiles());
    }
}