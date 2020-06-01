package hw_jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class BasicTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverFactory.getDriver().quit();
    }

    @AfterSuite
    public void afterSuite() {
        killAllSeleniumDrivers();
    }
}
