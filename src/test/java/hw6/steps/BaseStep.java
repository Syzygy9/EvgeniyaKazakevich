package hw6.steps;

import hw6.utils.ConfigProperties;
import hw6.utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class BaseStep {

    private final ConfigProperties property = new ConfigProperties();

    public WebDriver getDriver() {
        return WebDriverSingleton.getDriver();
    }

    public String getProperty(String propertyName) throws IOException {
        return property.getProperty(propertyName);
    }
}
