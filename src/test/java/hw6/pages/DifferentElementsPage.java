package hw6.pages;

import hw6.pages.components.LogComponent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private final LogComponent logComponent;

    @FindBy(css = ".colors select")
    private WebElement colorsDropdown;
    @FindBy(xpath = "//*[@type='checkbox']")
    private List<WebElement> checkboxes;
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;
    @FindBy(className = "label-radio")
    private List<WebElement> radioElements;
    @FindBy(xpath = "//*[@type='radio']")
    private List<WebElement> radios;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.logComponent = new LogComponent(driver);
    }

    public DifferentElementsPage checkCheckboxBy(String name) {
        clickElementByLableName(checkboxes, checkBoxElements, name);
        return this;
    }

    public DifferentElementsPage checkRadiobuttonBy(String name) {
        clickElementByLableName(radios, radioElements, name);
        return this;

    }

    private void clickElementByLableName(List<WebElement> elements, List<WebElement> labels, String name) {
        if (elements.size() != labels.size())
            throw new IllegalStateException("Checkboxes does not match labels");

        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getText().equals(name)) {
                elements.get(i).click();
                return;
            }
        }
        throw new NoSuchElementException("No such checkbox with name " + name + " on the Different Elements page");

    }

    public DifferentElementsPage setColor(String color) {
        new Select(colorsDropdown).selectByVisibleText(color);
        return this;
    }

    public LogComponent getLogComponent() {
        return logComponent;
    }
}