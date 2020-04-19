package hw5.test;

import hw5.utils.ConfigProperties;
import hw5.utils.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final static String USER = ConfigProperties.getProperty("user");
    protected final static String PASSWORD = ConfigProperties.getProperty("password");

    @BeforeMethod
    public void start() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.createdDriver("chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
        wait =  WebDriverSingleton.INSTANCE.getWait();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }

}