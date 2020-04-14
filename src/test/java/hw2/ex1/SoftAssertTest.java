package hw2.ex1;

import hw2.BasicClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SoftAssertTest extends BasicClass {

    String login = "Roman";
    String password = "Jdi1234";

            @Test
    public void checkStepsForExercise1() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        openSite(url);
        driver.manage().window().maximize();

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3. Perform login
        login(login, password);

        //  4. Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).isDisplayed(), true);
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".m-l8 > li"))).size(), 4);
        String expectedHeaderText = "HOME\n" + "CONTACT FORM\n" + "SERVICE\n" + "METALS & COLORS";
        String actualHeaderText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("m-l8"))).getText();
        softAssert.assertEquals(actualHeaderText, expectedHeaderText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconElementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-icon")));
        softAssert.assertEquals(iconElementsList.size(), 4);
        iconElementsList.forEach(element -> softAssert.assertTrue(element.isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("benefit-txt"))).size(), 4);

        String expectedIconText = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project\n" +
                "To be flexible and\n" +
                "customizable\n" +
                "To be multiplatform\n" +
                "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";
        String actualIconText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefits"))).getText();
        softAssert.assertEquals(actualIconText, expectedIconText);

        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame"))).isDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-frame"))).isDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionMenuElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li")));
        softAssert.assertEquals(leftSectionMenuElements.size(), 5);
        leftSectionMenuElements.forEach(element -> softAssert.assertTrue(element.isDisplayed()));
        String expectedLeftSectionMenuText = "Home\n" +
                "Contact form\n" +
                "Service\n" +
                "Metals & Colors\n" +
                "Elements packs";
        String actualLeftSectionMenuText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-menu"))).getText();
        softAssert.assertEquals(actualLeftSectionMenuText, expectedLeftSectionMenuText);

        softAssert.assertAll();
    }


}



