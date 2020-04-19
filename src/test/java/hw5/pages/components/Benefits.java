package hw5.pages.components;

import hw5.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

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

    public int getBenefitImagesNumber(){
        return benefitImages.size();
    }

    public int getBenefitTextsNumber(){
        return benefitTexts.size();
    }

    public List<String> getBenefitTexts(){
        return benefitTexts.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
