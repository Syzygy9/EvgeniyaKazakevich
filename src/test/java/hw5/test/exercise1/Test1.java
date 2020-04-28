package hw5.test.exercise1;

import hw5.test.BaseTest;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;

@Listeners({AllureScreenshotListener.class})
public class Test1 extends BaseTest {

    @Feature("Testing functionality of https://jdi-testing.github.io/jdi-light/index.html")
    @Story("Login on home page and assert web-elements on page")
    @Test
    public void CheckStepsForExercise1() {

        HomePageSteps homePage = new HomePageSteps(driver);

        // 1. Open site by URL
        homePage.openSitePage();

        // 2. Assert Browser title
        homePage.PageTitleEqualsHomePage("Home Page");

        // 3.
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        homePage.usernameIsDisplayed();
        homePage.usernameEqualsRomanIovlev("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.headerMenuIsDisplayed();
        homePage.headerMenuHasFourItems(4);
        homePage.headerMenuContains(Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS"));

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.amountOfImagesEqualsFour(4);
        homePage.homePageImagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.amountOfTextsUnderImagesEqualsFour(4);
        homePage.textsUnderImagesContain(Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                        "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                        "Already have good base\n"+
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"));

        // 8. Assert that there is the iframe with “Frame Button” exist
        homePage.IFrameButtonIsDisplayed();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToIFrameElements();
        homePage.iFrameButtonIsDisplayed();

        // 10. Switch to original window back
        homePage.switchToOriginalWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        homePage.amountOfLeftSideBarMenuItemsIsFive(5);
        homePage.leftSideBarMenuItemsAreDisplayed();
        homePage.leftSideBarMenuContains(Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs"));

        homePage.assertAll();
    }
}