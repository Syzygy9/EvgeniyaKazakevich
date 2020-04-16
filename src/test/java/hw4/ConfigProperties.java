package hw4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static final String PATH = "src/test/resources/config.properties";

    public static String getProperty(String property) {

        try (InputStream inputStream = new FileInputStream(PATH)) {
            Properties properties = new Properties();

            properties.load(inputStream);
            return (properties.getProperty(property));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


}