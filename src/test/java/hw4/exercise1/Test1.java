package hw4.exercise1;

import hw4.pages.HomePage;
import hw4.BaseTest;
import hw4.pages.TablePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Test1 extends BaseTest {

    @Test
    public void checkStepsForExercise1() {

        HomePage homePage = new HomePage(driver);

        // 1. Open site by URL
        openSite();
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert Browser title
        softAssert.assertEquals(homePage.getPageTitle(), "Home Page");

        // 3. Perform login
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        softAssert.assertTrue(homePage.isUserNameDisplayed());
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 7. Open through the header menu Service -> Table with pages
        TablePage tablePage = homePage.openTablePage(driver);

        // 8. Check that default value for “Show entries” dropdown is 5
        softAssert.assertEquals(tablePage.getSelectedDropdownValue().getText(), "5");

        // 11. Select new value for the entries in the dropdown list
        tablePage.setDropdownValue("10");

        // 13. Assert that in the table displayed corrected amount of entries
        softAssert.assertEquals(tablePage.getRowsNumber(), 10);

        // 14. Type in “Search” text field
        String searchValue = "junit";
        tablePage.typeInSearchInputField((searchValue));

        // 15. Assert the table contains only records with Search field value
        tablePage.getTableValues().
                forEach(e -> softAssert.assertTrue(e.getText().toLowerCase().contains(searchValue.toLowerCase())));

        softAssert.assertAll();
    }
}