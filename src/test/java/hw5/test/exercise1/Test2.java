package hw5.test.exercise1;

import hw5.test.BaseTest;
import hw5.test.steps.DifferentElementsPageSteps;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureScreenshotListener.class})
public class Test2 extends BaseTest {

    @Feature("Testing functionality of https://jdi-testing.github.io/jdi-light/different-elements.html")
    @Story("Checking of different elements (radio, checkboxes and dropdown)")
    @Test
    public void CheckStepsForExercise2() {
        HomePageSteps homePage = new HomePageSteps(driver);

        // 1. Open test site by URL
        homePage.openSitePage();

        // 2. Assert Browser title
        homePage.PageTitleEqualsHomePage("Home Page");

        // 3. Perform login
        homePage.login(USER, PASSWORD);

        // 4. Assert Username is logged in
        homePage.usernameIsDisplayed();
        homePage.usernameEqualsRomanIovlev("ROMAN IOVLEV");

        // 5.Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();
        DifferentElementsPageSteps differentElementsPage = new DifferentElementsPageSteps(driver);

        // 6. Select checkboxes "Water", "Wind"
        String checkBox1 = "Water";
        String checkBox2 = "Wind";
        differentElementsPage.tickCheckbox(checkBox1);
        differentElementsPage.tickCheckbox(checkBox2);

        // 7. Select radio "Selen"
        String radio = "Selen";
        differentElementsPage.tickRadio(radio);

        // 8.Select in dropdown "Yellow"
        String dropdownColor = "Yellow";
        differentElementsPage.setColorDropdown(dropdownColor);

        // 9.Assert that
        // • for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // • for radio button there is a log row and value is corresponded to the status of radio button
        // • for dropdown there is a log row and value is corresponded to the selected value

        differentElementsPage.logRowForCheckboxEqualsTrue(checkBox1, "true");
        differentElementsPage.logRowForCheckboxEqualsTrue(checkBox2, "true");

        differentElementsPage.logRowForRadioIsDisplayed(radio);

        differentElementsPage.logRowForDropdownIsDisplayed(dropdownColor);
    }
}