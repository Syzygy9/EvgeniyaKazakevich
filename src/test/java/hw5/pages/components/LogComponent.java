package hw5.pages.components;

import hw5.pages.AbstractPageComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LogComponent extends AbstractPageComponents {

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public LogComponent(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("info-panel-body-log")));
    }

    @Override
    public List<WebElement> getWebElements() {
        return logs;
    }

    @Override
    public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
        return true;
    }

    @Override
    public boolean isRadioLogDisplayed(String radioName) {
        return true;
    }

    @Override
    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return true;
    }

    public boolean isElementIsDisplayedOnSection(String elementName, String status) {
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(elementName + ": condition changed to " + status)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }
}