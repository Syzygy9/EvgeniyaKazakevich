package hw6;

import hw6.utils.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasicClass {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void start() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        wait = new WebDriverWait(driver, 5);
    }


    @AfterMethod
    public void stop() {
        driver.quit();


    }



}