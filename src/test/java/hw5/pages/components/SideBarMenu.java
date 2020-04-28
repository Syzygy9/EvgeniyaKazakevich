package hw5.pages.components;

import hw5.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractPageComponents {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuItems;

    public SideBarMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return sideBarMenuItems;
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

    public boolean isSidebarMenuItemsDisplayed(){
        return isElementsDisplayed(sideBarMenuItems);
    }

    public List<String> getSideBarMenuItemsText(){
        return sideBarMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public int getSideBarItemsNumber(){
        return sideBarMenuItems.size();
    }


}