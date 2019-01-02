package io.github.jhoneagle.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ConsoleIOTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ConsoleIO io;
    private Scanner reader;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        String lines = "yksi rivi" + "\n" + "kaksi rivi" + "\n" + "kolme rivi" + "\n" + "vika rivi";

        InputStream in = new ByteArrayInputStream(lines.getBytes());
        System.setIn(in);

        io = new ConsoleIO();
        reader = new Scanner(System.in);
    }

    @Test
    public void writeOneLine() {
        String test = "we came to test you.";
        io.write(test);

        assertTrue(outContent.toString().contains(test));
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

        assertTrue(outContent.toString().contains(test));
        assertTrue(outContent.toString().contains(test2));
        assertTrue(outContent.toString().contains(test3));
        assertTrue(outContent.toString().contains(test4));
    }

    @Test
    public void previousWorks() {
        assertTrue(io.read().contains("yksi rivi"));
        assertTrue(io.previous().contains("yksi rivi"));

        assertTrue(io.read().contains("kaksi rivi"));
        assertFalse(io.previous().contains("yksi rivi"));
    }

    @Test
    public void readOneLine() {
        assertTrue(io.read().contains("yksi rivi"));
    }

    @Test
    public void readMultipleLine() {
        assertTrue(io.read().contains("yksi rivi"));
        assertTrue(io.read().contains("kaksi rivi"));
        assertTrue(io.read().contains("kolme rivi"));
        assertTrue(io.read().contains("vika rivi"));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}