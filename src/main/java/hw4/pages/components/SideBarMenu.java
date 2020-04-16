package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractPageComponents {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuElements;

    public SideBarMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return sideBarMenuElements;
    }

}