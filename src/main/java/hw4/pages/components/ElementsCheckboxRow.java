package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElementsCheckboxRow extends AbstractPageComponents {

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxElements;

    public ElementsCheckboxRow(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return checkBoxElements;
    }

}