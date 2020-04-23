package hw4.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsAndColorsPage extends AbstractPageComponents {

    @FindBy(css = "p.radio > label")
    private List<WebElement> summaryRadioButtons;
    @FindBy(css = "p.checkbox > label")
    private List<WebElement> elementsCheckboxes;
    @FindBy(css = "button[title='Colors']")
    private WebElement colorDropdown;
    @FindBy(xpath = "//button[@title='Metals']//span[2]")
    private WebElement metalDropdown;
    @FindBy(xpath = "//ul[@class='dropdown-menu inner selectpicker']//li")
    private List<WebElement> colorAndMetalOptions;
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private WebElement vegetablesDropdown;
    @FindBy(css = ".dropdown-menu > li > a > label")
    private List<WebElement> vegetableCheckboxes;
    @FindBy(css = "#submit-button")
    private WebElement submitButton;
    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    private List<WebElement> results;

    public MetalsAndColorsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return null;
    }

    public List<WebElement> getWebElements(String string) {
        if ("summaryRadioButtons"==string) {
            return summaryRadioButtons;
        }
        if ("elementsCheckboxes"==string) {
            return elementsCheckboxes;
            }
        if ("colorAndMetalOptions"==string) {
            return colorAndMetalOptions;
            }
        if ("vegetableCheckboxes"==string) {
            return vegetableCheckboxes;
            }
        if ("results"==string) {
            return results;
            }
            throw new NoSuchElementException("Elements not found");
        }


    public WebElement getWebElement(String element) {
        if("colorDropdown"==element) {
            return colorDropdown;
        }
        if ("metalDropdown"==element) {
            return metalDropdown;
        }
        if ("vegetablesDropdown"==element) {
            return vegetablesDropdown;
        }
        if ("submitButton"==element) {
            return submitButton;
        }
            throw new NoSuchElementException("Elements not found");
        }


    public void selectWebElement(List<WebElement> webElements, List<String> webElementName) {
        for (WebElement element : webElements) {
            if (webElementName.contains(element.getText())) {
                element.click();
            }
        }
    }

    public void uncheckVegetables() {
        for (WebElement element : vegetableCheckboxes) {
            if (element.getText().contains("Vegetables")) {
                element.click();
            }
        }
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}

