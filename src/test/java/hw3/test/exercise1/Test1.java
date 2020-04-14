package hw3.test.exercise1;

import hw3.pages.HomePage;
import hw3.test.BasicClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;

public class Test1 extends BasicClass {

    @Test
    public void checkStepsForExercise1() {

        HomePage homePage = new HomePage(driver);

        // 1 Test site is opened
        openSite();

        // 2 Browser title equals "Home Page"
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getTitle(), "Home Page");

        // 3 User is logged in
        login(USER, PASSWORD);

        // 4 Assert that name is displayed and equals to expected result
        softAssert.assertTrue(homePage.isUserNameDisplayed());
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertTrue(homePage.isHeaderMenuItemsDisplayed());
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuText();
        List<String> expectedHeaderMenuItemsText = Arrays.asList("HOME","CONTACT FORM","SERVICE","METALS & COLORS");
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderMenuItemsText);

        // 6 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getBenefitIconsNumber(), 4);
        softAssert.assertTrue(homePage.isBenefitIconsDisplayed());

        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> actualBenefitTexts = homePage.getBenefitTexts();
        List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable", "To be multiplatform",
                "Already have good base\n"+
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        softAssert.assertEquals(actualBenefitTexts,expectedBenefitTexts);
        softAssert.assertEquals(homePage.getBenefitTextsNumber(), 4);

        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.isIFrameDisplayed());

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToIFrame();
        softAssert.assertTrue(homePage.isFrameButtonDisplayed());

        // 10 Switch to original window back
        homePage.switchToOriginalWindow();

        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertEquals(homePage.getSideBarMenuItemsNumber(), 5);
        softAssert.assertTrue(homePage.isSideBarMenuItemsDisplayed());
        List<String> expectedSideBarItemsText = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<String> actualSideBarItemsText = homePage.getSideBarMenuItemsText();
        softAssert.assertEquals(actualSideBarItemsText, expectedSideBarItemsText);
        softAssert.assertAll();
    }
}