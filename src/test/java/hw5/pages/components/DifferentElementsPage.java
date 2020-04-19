package hw5.pages.components;

import hw5.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private LogComponent logComponent;

    @FindBy(css = ".colors select")
    private WebElement colorsDropdown;
    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;


    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.logComponent = new LogComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status){
        return logComponent.isCheckboxLogDisplayed(checkboxName, status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return logComponent.isRadioLogDisplayed(radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return logComponent.isDropdownLogDisplayed(dropdownValue);
    }

    public void selectColorDropDown(String color) {
        colorsDropdown = wait.until(ExpectedConditions.visibilityOf(colorsDropdown));
        Select select = new Select(colorsDropdown);
        select.selectByVisibleText(color);
    }

    public void tickCheckBox(String checkboxName) {
        setElementInAList(checkboxName, checkBoxElements);
    }

    public void tickRadio(String radioName) {
        setElementInAList(radioName, radioElements);
    }

    }