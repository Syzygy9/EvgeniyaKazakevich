package hw6.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WebDriverSingleton {

    INSTANCE;

    private static WebDriver driver;
    private static WebDriverWait wait;


    public static void createdDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createdDriver("chrome");
        }
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;    }


}