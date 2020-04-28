package hw3.pages.components;

import hw3.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.stream.Collectors;

import java.util.List;

public class Benefits extends AbstractPageComponents {

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;
    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    public int getBenefitIconsNumber(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitIcons)).size();
    }

    public int getBenefitTextsNumber(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts)).size();
    }

    public List<String> getBenefitTexts(){
        wait.until(ExpectedConditions.visibilityOfAllElements(benefitTexts));
        return benefitTexts.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isBenefitIconsDisplayed(){
        return isElementsDisplayed(benefitIcons);
    }
}