package hw5.pages;

import hw5.pages.components.Benefits;
import hw5.pages.components.IFrameElements;
import hw5.pages.components.HeaderMenu;
import hw5.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class HomePage extends AbstractPage {

    private Benefits benefits;
    private IFrameElements IFrameElements;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.IFrameElements = new IFrameElements(driver);
        this.sideBarMenu = new SideBarMenu(driver);
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

    public List<String> getHeaderMenuItemsText() {
        return headerMenu.getHeaderMenuItemsText();
    }

    public boolean isHeaderMenuItemsDisplayed() {
        return headerMenu.isElementsDisplayed(headerMenu.getWebElements());
    }

    public int getBenefitImagesNumber() {
        return benefits.getBenefitImagesNumber();
    }

    public int getBenefitTextsNumber() {
        return benefits.getBenefitTextsNumber();
    }

    public List<String> getBenefitTexts() {
        return benefits.getBenefitTexts();
    }

    public boolean isBenefitIconsDisplayed() {
        return benefits.isElementsDisplayed(benefits.getWebElements());
    }

    public boolean isIFrameDisplayed() {
        return IFrameElements.isFrameDisplayed();
    }

    public boolean isIFrameButtonDisplayed() {
        return IFrameElements.isButtonDisplayed();
    }

    public void switchToFrame() {
        IFrameElements.switchToFrame();
    }

    public void switchToOriginalWindow() {
        IFrameElements.switchToOriginalWindow();
    }

    public boolean isSidebarMenuItemsDisplayed() {
        return sideBarMenu.isSidebarMenuItemsDisplayed();
    }

    public List<String> getSideBarMenuItemsText() {
        return sideBarMenu.getSideBarMenuItemsText();
    }

    public int getSideBarItemsNumber() {
        return sideBarMenu.getSideBarItemsNumber();
    }

    public void openDifferentElementsPage() {
        headerMenu.openDifferentElementsPage();
    }
}