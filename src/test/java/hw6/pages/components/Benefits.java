package hw6.pages.components;

import hw6.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Benefits extends AbstractPageComponents {
    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;
    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    public boolean allIconsAreDisplayed() {
        return benefitIcons.stream()
                .allMatch(icon -> icon.isDisplayed());
    }

    public List<String> getMenuItemsText() {
        return benefitTexts.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}