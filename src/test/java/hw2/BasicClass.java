package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BasicClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 6);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void login(String login, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.elementToBeClickable((By.id("name")))).sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable((By.id("password")))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable((By.id("login-button")))).click();
    }
}



