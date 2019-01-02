package io.github.jhoneagle.io;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IOstubTest {
    private IOstub io;

    @Before
    public void setUp() {
        io = new IOstub();
    }

    @Test
    public void writeOneLine() {
        String test = "we came to test you.";
        io.write(test);
        assertTrue(io.read().contains(test));
    }

    @Test
    public void readFirstEmpty() {
        assertNull(io.read());
    }

    @Test
    public void writeMultipleLines() {
        String test = "we came to test you.";
        String test2 = "and judge you.";
        String test3 = "there is no place to hide.";
        String test4 = "because we will find you.";

        io.write(test);
        io.write(test2);
        io.write(test3);
        io.write(test4);

        assertTrue(io.read().contains(test));
        assertTrue(io.read().contains(test2));
        assertTrue(io.read().contains(test3));
        assertTrue(io.read().contains(test4));
    }

    @Test
    public void previousWorks() {
        String test = "we came to test you.";
        io.write(test);

        String test2 = "not me.";
        io.write(test2);

        assertTrue(io.read().contains(test));
        assertTrue(io.previous().contains(test));

        assertTrue(io.read().contains(test2));
        assertFalse(io.previous().contains(test));
    }

    @Test
    public void listConstructorWorks() {
        List<String> commands = new ArrayList<>();
        commands.add("1");
        commands.add("2");
        commands.add("3");

        io = new IOstub(commands);
        assertTrue(io.read().contains("1"));
        assertTrue(io.read().contains("2"));
        assertTrue(io.read().contains("3"));
    }
}