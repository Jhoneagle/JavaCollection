package io.github.jhoneagle.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PropertiesHandlerTest {
    private File tempFile;
    private PropertiesHandler handler;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUP() {
        try {
            tempFile = tempFolder.newFile("test.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write("database=test.db" + "\n");
            fileWriter.write("tempFile=" + tempFile.getName() + "\n");
            fileWriter.write("homeSite=http://jhoneagle.github.io/home-pages");
        } catch (IOException e) {
            e.printStackTrace();
        }

        handler = new PropertiesHandler();
        handler.loadProperties(tempFile.getAbsolutePath());
    }

    @Test
    public void containsNothing() {
        handler = new PropertiesHandler();
        Map<String, String> allProperties = handler.getAllProperties();
        assertEquals(0, allProperties.size());
    }

    @Test
    public void canReadProperties() {
        Map<String, String> allProperties = handler.getAllProperties();
        assertEquals(3, allProperties.size());

        assertTrue(allProperties.get("homeSite").contains("http://jhoneagle.github.io/home-pages"));
    }

    @Test
    public void canReadSingleProperty() {
        String name = handler.getProperty("tempFile");
        assertTrue(name.contains(tempFile.getName()));
    }

    @Test
    public void canWriteProperty() {
        handler.setProperty("test", "test");

        String s = handler.getProperty("test");
        assertTrue(s.contains("test"));
    }

    @Test
    public void canWriteAndReadMore() {
        handler.setProperty("test", "test");
        handler.setProperty("text", "what next?");
        handler.setProperty("wait", "nani!");

        Map<String, String> allProperties = handler.getAllProperties();
        assertEquals(6, allProperties.size());

        String s = handler.getProperty("test");
        assertTrue(s.contains("test"));

        s = handler.getProperty("wait");
        assertTrue(s.contains("nani!"));

        s = handler.getProperty("database");
        assertTrue(s.contains("test.db"));
    }

    @After
    public void tearDown() {
        tempFile.delete();
    }
}