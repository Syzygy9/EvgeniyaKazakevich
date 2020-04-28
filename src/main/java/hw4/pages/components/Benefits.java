package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Benefits extends AbstractPageComponents {

    @FindBy(className = "benefit-icon")
    List<WebElement> benefitImages;

    @FindBy(className = "benefit-txt")
    List<WebElement> benefitTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return benefitImages;
    }

}
