package hw2.ex2;

import hw2.PreAssertionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertElementsTest extends PreAssertionClass {

    String login = "Roman";
    String password = "Jdi1234";

    @Test
    public void checkStepsForExercise2() {

        // 1. Open test site by URL
        openSite(url);
        driver.manage().window().maximize();

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        login(login, password);

        //  4. Assert Username is loggined
        assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Service"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Different elements"))).click();
        assertEquals(driver.getTitle(), "Different Elements");

        // 6. Select checkboxes
        WebElement Water = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Water']")));
        WebElement Wind = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Wind']")));
        Water.click();
        Wind.click();

        // 7. Select radio
        WebElement Selen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Selen']")));
        Selen.click();

        // 8. Select in dropdown
        WebElement ColorsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".colors select")));
        Select element = new Select(ColorsDropdown);
        element.selectByVisibleText("Yellow");

     /* 9. Assert that
        •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        •	for radio button there is a log row and value is corresponded to the status of radio button
        •	for dropdown there is a log row and value is corresponded to the selected value.

       */
        WebElement elementWater = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Water: condition changed to true')]")));
        assertTrue(elementWater.isDisplayed(), "Water checkbox is not displayed in log row");
        WebElement elementWind = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Wind: condition changed to true')]")));
        assertTrue(elementWind.isDisplayed(), "Wind checkbox is not displayed in log row");
        WebElement elementSelen = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'metal: value changed to  Selen')]")));
        assertTrue(elementSelen.isDisplayed(), "Selen radio button is not displayed in log row");
        WebElement elementYellow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]")));
        assertTrue(elementYellow.isDisplayed(), "Dropdown selected color is not displayed in log row");

    }

}

