package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
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

}
