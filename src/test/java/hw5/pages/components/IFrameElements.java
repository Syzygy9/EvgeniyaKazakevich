package hw5.pages.components;

import hw5.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IFrameElements extends AbstractPageComponents {

    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "button-frame")
    private WebElement button;

    public IFrameElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
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

    public void switchToFrame(){
        driver.switchTo().frame("frame");
    }
    public void switchToOriginalWindow(){
        driver.switchTo().defaultContent();
    }
    public boolean isButtonDisplayed(){
        return button.isDisplayed();
    }
    public boolean isFrameDisplayed(){
        return frame.isDisplayed();
    }
}