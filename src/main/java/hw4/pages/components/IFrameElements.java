package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IFrameElements extends AbstractPageComponents {

    @FindBy(id = "frame")
    private WebElement iframe;
    @FindBy(id = "button-frame")
    private WebElement button;

    public IFrameElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
    }

    public void switchToIFrame(){
        driver.switchTo().frame("frame");
    }
    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }
    public boolean isButtonDisplayed(){
        return button.isDisplayed();
    }
    public boolean isFrameDisplayed(){
        return iframe.isDisplayed();
    }
}