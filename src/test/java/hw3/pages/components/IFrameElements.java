package hw3.pages.components;

import hw3.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFrameElements extends AbstractPageComponents {

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "button-frame")
    private WebElement button;

    public IFrameElements(WebDriver driver) {
        super(driver);
    }

    public void switchToIFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void switchToOriginalWindow(){
        driver.switchTo().defaultContent();
    }

    public boolean isButtonDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(button));
        return button.isDisplayed();
    }

    public boolean isIFrameDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(iframe));
        return iframe.isDisplayed();
    }
}