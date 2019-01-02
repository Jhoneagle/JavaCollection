package io.github.jhoneagle.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesHandler {
    private Properties properties;

    public PropertiesHandler() {
        properties = new Properties();
    }

    public void loadProperties(String fileName) {
        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        this.properties.setProperty(key, value);
    }

    public Map<String, String> getAllProperties() {
        Map<String, String> list = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        for (Map.Entry entry : entries) {
            list.put((String) entry.getKey(), (String) entry.getValue());
        }

        return list;
    }
}
