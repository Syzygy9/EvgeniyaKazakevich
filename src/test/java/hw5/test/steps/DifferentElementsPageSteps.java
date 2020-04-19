package hw5.test.steps;

import hw5.pages.components.DifferentElementsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;


public class DifferentElementsPageSteps {

    private final DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver) {
        this.differentElementsPage = new DifferentElementsPage(driver);
    }

    @Step("Tick checkbox '{0}'")
    public void tickCheckbox(String checkboxName) {
        differentElementsPage.tickCheckBox(checkboxName);
    }

    @Step("Tick radio '{0}'")
    public void tickRadio(String radioName) {
        differentElementsPage.tickRadio(radioName);
    }

    @Step("Set dropdown color to '{0}'")
    public void setColorDropdown(String color) {
        differentElementsPage.selectColorDropDown(color);
    }

    @Step("For checkbox '{0}' there is a log row with status '{1}'")
    public void logRowForCheckboxEqualsTrue(String checkBox, String status) {
        assertTrue(differentElementsPage.isCheckboxLogDisplayed(checkBox, status));
    }

    @Step("Log row for Radio '{0}' is displayed ")
    public void logRowForRadioIsDisplayed(String radio) {
        assertTrue(differentElementsPage.isRadioLogDisplayed(radio));
    }

    @Step("Log row for dropdown '{0}' value is displayed")
    public void logRowForDropdownIsDisplayed(String dropdownValue) {
        assertTrue(differentElementsPage.isDropdownLogDisplayed(dropdownValue));
    }
}