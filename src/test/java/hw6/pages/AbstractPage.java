package hw6.pages;

import hw6.pages.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private final WebDriver driver;
    private final HeaderMenu headerMenu;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderMenu getHeader() {
        return headerMenu;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }


}