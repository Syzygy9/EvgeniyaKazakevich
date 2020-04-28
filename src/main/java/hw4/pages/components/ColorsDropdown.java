package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ColorsDropdown extends AbstractPageComponents {

    @FindBy(css = ".colors select")
    private WebElement dropdownMenuElement;

    public ColorsDropdown(WebDriver driver) {
        super(driver);  }


    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("No elements found");
    }

    public WebElement getWebElement() {
        return dropdownMenuElement;
    }

}