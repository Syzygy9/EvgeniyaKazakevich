package hw4.exercise2;

import hw4.pages.HomePage;
import hw4.BaseTest;
import hw4.pages.MetalsAndColorsPage;
import hw4.pages.builder.DataList;
import hw4.util.Summary;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;


public class Test2 extends BaseTest {

    @DataProvider
    public Object[][] dataList() {
        return new Object[][]{
                {DataList.builder().setElements(Arrays.asList("Earth"))
                        .setColors(Arrays.asList("Yellow"))
                        .setMetals(Arrays.asList("Gold")).build()},

                {DataList.builder().setSummary(Arrays.asList("3", "8"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},

                {DataList.builder().setSummary(Arrays.asList("3", "2"))
                        .setElements(Arrays.asList("Water", "Wind", "Fire"))
                        .setMetals(Arrays.asList("Bronze"))
                        .setVegetables(Arrays.asList("Onion")).build()},

                {DataList.builder().setSummary(Arrays.asList("6", "5"))
                        .setElements(Arrays.asList("Water"))
                        .setColors(Arrays.asList("Green"))
                        .setMetals(Arrays.asList("Selen"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion")).build()},

                {DataList.builder().setElements(Arrays.asList("Fire"))
                        .setColors(Arrays.asList("Blue"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }

    @Test(dataProvider = "dataList")
    public void checkStepsForExercise2(DataList dataList) {

        // 1. Open site by URL
        openSite();
        HomePage homePage = new HomePage(driver);

        SoftAssert softAssert = new SoftAssert();

        // 2. Perform login
        homePage.login(USER, PASSWORD);

        // 3. Click on the link on the Header section
        MetalsAndColorsPage MetalsAndColorsPage = homePage.openMetalsAndColorsPage(driver);

        // 4. Fill form on the page
        if (dataList.getSummary() != null) {
            MetalsAndColorsPage.selectWebElement(
            MetalsAndColorsPage.getWebElements("summaryRadioButtons"), dataList.getSummary());
        }

        if (dataList.getElements() != null) {
            MetalsAndColorsPage.selectWebElement(
            MetalsAndColorsPage.getWebElements("elementsCheckboxes"), dataList.getElements(
                    ));
        }

        if (dataList.getColors() != null) {
            MetalsAndColorsPage.getWebElement("colorDropdown").click();
            MetalsAndColorsPage.selectWebElement(
            MetalsAndColorsPage.getWebElements("colorAndMetalOptions"), dataList.getColors());
        }

        if (dataList.getMetals() != null) {
            MetalsAndColorsPage.getWebElement("metalDropdown").click();
            MetalsAndColorsPage.selectWebElement(MetalsAndColorsPage
                    .getWebElements("colorAndMetalOptions"), dataList.getMetals());
        }

        if (dataList.getVegetables() != null) {
            MetalsAndColorsPage.getWebElement("vegetablesDropdown").click();
            MetalsAndColorsPage.uncheckVegetables();
            MetalsAndColorsPage.selectWebElement(MetalsAndColorsPage
                    .getWebElements("vegetableCheckboxes"), dataList.getVegetables());

        }

        // 5. Click "Submit" button
        MetalsAndColorsPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        for (WebElement result : MetalsAndColorsPage.getWebElements("results")) {

            if (dataList.getSummary() != null
                && result.getText().contains("Summary")) {
                softAssert.assertTrue(result.getText().contains(Summary.summ(dataList.getSummary())));
            }

            if (dataList.getElements() != null
                && result.getText().contains("Elements")) {
                softAssert.assertTrue(result.getText()
                        .contains(String.join(", ", dataList.getElements())));
            }

            if (dataList.getColors() != null
                && result.getText().contains("Colors")) {
                softAssert.assertTrue(result.getText()
                        .contains(String.join(", ", dataList.getColors())));
            }

            if (dataList.getMetals() != null
                && result.getText().contains("Metals")) {
                softAssert.assertTrue(result.getText()
                        .contains(String.join(",", dataList.getMetals())));
            }

            if (dataList.getVegetables() != null
                && result.getText().contains("Vegetables")) {
                softAssert.assertTrue(result.getText()
                        .contains(String.join(", ", dataList.getVegetables())));
            }
        }
    }
}