package hw4.pages.components;

import hw4.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private LogComponent logSection;
    private ElementsCheckboxRow elementsCheckboxRow;
    private SummaryRadioButtonRow radioRow;
    private ColorsDropdown colorsDropdown;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.logSection = new LogComponent(driver);
        this.elementsCheckboxRow = new ElementsCheckboxRow(driver);
        this.radioRow = new SummaryRadioButtonRow(driver);
        this.colorsDropdown = new ColorsDropdown(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
    }

    public void setCheckbox(String checkboxName){
        elementsCheckboxRow.setElementToChecked(checkboxName, elementsCheckboxRow.getWebElements());
    }

    public void setRadioRow(String radioRowName){
        radioRow.setElementToChecked(radioRowName, radioRow.getWebElements());
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status){
        return logSection.isElementIsDisplayedOnSection(checkboxName,  status, logSection.getWebElements());
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logSection.isElementIsDisplayedOnSection(radioName, logSection.getWebElements());
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logSection.isElementIsDisplayedOnSection(dropdownValue, logSection.getWebElements());
    }

    public void setColorDropDown(String color){
        Select select = new Select(colorsDropdown.getWebElement());
        select.selectByVisibleText(color);
    }



}
