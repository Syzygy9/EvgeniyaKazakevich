package hw6.pages.components;

import hw6.pages.AbstractPageComponents;
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
    }

    public boolean isLogDisplayed(String parameter) {
        waitForLogsToBeVisible();
        boolean isDisplayed = false;
        for (WebElement log : logs) {
            if (log.getText().contains(parameter)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    public boolean isCheckboxLogDisplayed(String checkboxName, String status) {
        return isLogDisplayed(checkboxName + ": condition changed to " + status);
    }

    public boolean isRadioLogDisplayed(String radioName) {
        return isLogDisplayed("metal: value changed to " + radioName);
    }

    public boolean isDropdownLogDisplayed(String dropdownValue) {
        return isLogDisplayed("Colors: value changed to " + dropdownValue);
    }

    private void waitForLogsToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(logs));
    }


}
