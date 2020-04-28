package hw6.pages.components;

import hw6.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrameElements extends AbstractPageComponents {
    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "frame-button")
    private WebElement button;


    public IFrameElements(WebDriver driver) {
        super(driver);
    }

    public boolean iframeIsDisplayed() {
        return iframe.isDisplayed();
    }

    public boolean iframeButtonIsDisplayed() {
        return button.isDisplayed();
    }

    public void switchToFrame() {
        getDriver().switchTo().frame(iframe);
    }
}
