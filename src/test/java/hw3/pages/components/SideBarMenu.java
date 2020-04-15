package hw3.pages.components;

import hw3.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractPageComponents {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuItems;

    public SideBarMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isSideBarMenuItemsDisplayed(){
        return isElementsDisplayed(sideBarMenuItems);
    }

    public List<String> getSideBarMenuItemsText(){
        waitForSidebarMenuToBeVisible();
        return sideBarMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public int getSideBarMenuItemsNumber(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(sideBarMenuItems)).size();
    }

    private void waitForSidebarMenuToBeVisible(){
        wait.until(ExpectedConditions.visibilityOfAllElements(sideBarMenuItems));
    }
}