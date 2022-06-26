package org.joker.template.generate.db2j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcProperties {

    private static final Properties PROPERTIES = new Properties();

    static {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        try {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String getDriverClassName() {
        String property = PROPERTIES.getProperty("jdbc.driverClassName");
        if (property == null || property.isEmpty()) {
            throw new RuntimeException("jdbc.properties: jdbc.driverClassName is NULL");
        }
        return property;
    }

    public static String getUrl() {
        String property = PROPERTIES.getProperty("jdbc.url");
        if (property == null || property.isEmpty()) {
            throw new RuntimeException("jdbc.properties: jdbc.url is NULL");
        }
        return property;
    }

    public static String getUsername() {
        String property = PROPERTIES.getProperty("jdbc.username");
        if (property == null || property.isEmpty()) {
            throw new RuntimeException("jdbc.properties: jdbc.username is NULL");
        }
        return property;
    }

    public static String getPassword() {
        String property = PROPERTIES.getProperty("jdbc.password");
        if (property == null || property.isEmpty()) {
            throw new RuntimeException("jdbc.properties: jdbc.password is NULL");
        }
        return property;
    }

}
