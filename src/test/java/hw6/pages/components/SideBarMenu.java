package hw6.pages.components;

import hw6.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractPageComponents {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuItems;
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuItemsText;

    public SideBarMenu(WebDriver driver) {
        super(driver);
    }

    public boolean sideBarMenuItemsAreDisplayed() {
        return sideBarMenuItems.stream()
                .allMatch(item -> item.isDisplayed());
    }

    public List<String> getSideBarMenuItemsText() {
        return sideBarMenuItemsText.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}