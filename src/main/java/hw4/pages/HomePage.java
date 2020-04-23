package hw4.pages;

import hw4.pages.components.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomePage extends AbstractPage {

    private Benefits benefits;
    private IFrameElements IFrameElements;

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.IFrameElements = new IFrameElements(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException();
    }

    public void login(String username, String password) {
        headerMenu.login(username, password);
    }

    public boolean isUserNameDisplayed() {
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName() {
        return headerMenu.getUserName();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


    public MetalsAndColorsPage openMetalsAndColorsPage(WebDriver driver) {
        headerMenu.openMetalsAndColorsPage();
        return new MetalsAndColorsPage(driver);
    }

    public TablePage openTablePage(WebDriver driver) {
        headerMenu.openTablePage();
        return new TablePage(driver);
    }
}