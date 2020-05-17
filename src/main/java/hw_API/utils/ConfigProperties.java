package hw_API.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConfigProperties {

    private static final String PATH = "src/test/resources/hw_API/config.properties";

    public static String getProperties(String property) {

        try (InputStream inputStream = new FileInputStream(PATH)) {
            Properties properties = new Properties();

            properties.load(inputStream);
            return (properties.getProperty(property));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return property;
    }


}
