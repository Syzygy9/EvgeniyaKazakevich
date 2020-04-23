package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPageComponents {
    protected WebDriver driver;
    protected WebDriverWait wait;

        protected AbstractPageComponents(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public boolean isElementsDisplayed(List<WebElement> elements){
        boolean isDisplayed = false;
        for (WebElement element : elements) {
            isDisplayed = element.isDisplayed();
        }
        return isDisplayed;
    }

    public void setElementToChecked(String elementName, List<WebElement> elements){
        for (WebElement element : elements) {
            if(!element.isSelected() & element.getText().equals(elementName))
                element.click();
        }
    }

    public boolean isElementIsDisplayedOnSection(String elementName, String status, List<WebElement> elements) {
        boolean isDisplayed = false;
        for (WebElement log : elements) {
            if (log.getText().contains(elementName + ": condition changed to " + status)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public boolean isElementIsDisplayedOnSection(String elementName, List<WebElement> elements) {
        boolean isDisplayed = false;
        for (WebElement log : elements) {
            if (log.getText().contains(": value changed to "  + elementName)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public abstract List<WebElement> getWebElements();
}