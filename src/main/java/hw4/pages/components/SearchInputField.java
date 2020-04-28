package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchInputField extends AbstractPageComponents {

    @FindBy(css = ".dataTables_filter input")
    private WebElement searchInput;

    public SearchInputField(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Not supported in SearchInputField");
    }

    public WebElement getWebElement() {
        return searchInput;
    }
}
