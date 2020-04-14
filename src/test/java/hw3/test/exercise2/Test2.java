package hw3.test.exercise2;

import hw3.pages.HomePage;
import hw3.pages.components.DifferentElementsPage;
import hw3.test.BasicClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Test2 extends BasicClass {

    @Test
    public void checkStepsForExercise2() {

        HomePage homePage = new HomePage(driver);

        // 1 Open test site by URL
        openSite();

        // 2 Assert Browser title
        assertEquals(homePage.getTitle(), "Home Page");

        // 3 Perform login
        homePage.login(USER, PASSWORD);

        // 4 Assert Username is logged
        assertTrue(homePage.isUserNameDisplayed());
        assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 5 Open through the header menu Service -> Different Elements Page
        WebDriverWait wait = new WebDriverWait(driver, 6);
        homePage.openDifferentElementsPage();

        // 6 Select checkboxes "Water", "Wind"
        String checkBox1 = "Water";
        String checkBox2 = "Wind";
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        differentElementsPage.tickCheckBox(checkBox1);
        differentElementsPage.tickCheckBox(checkBox2);

        // 7 Select radio "Selen"
        String radio = "Selen";
        differentElementsPage.tickRadio(radio);

        // 8 Select in dropdown "Yellow"
        String color = "Yellow";
        differentElementsPage.selectColorDropDown(color);

        // 9 Assert that
        //   for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //   for radio button there is a log row and value is corresponded to the status of radio button
        //   for dropdown there is a log row and value is corresponded to the selected value

        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBox1, "true"));
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBox2, "true"));

        assertTrue(differentElementsPage.isRadioLogDisplayed(radio));

        assertTrue(differentElementsPage.isDropdownLogDisplayed(color));
    }
}