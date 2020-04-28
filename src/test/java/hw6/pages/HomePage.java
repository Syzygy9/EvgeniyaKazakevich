package hw6.pages;

import hw6.pages.components.HeaderMenu;
import hw6.pages.components.Benefits;
import hw6.pages.components.IFrameElements;
import hw6.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    private Benefits benefits;
    private IFrameElements IFrameElements;
    private SideBarMenu sideBarMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        this.benefits = new Benefits(driver);
        this.IFrameElements = new IFrameElements(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public static HomePage homePage (WebDriver driver) {
        return new HomePage(driver);
    }

    public HomePage open() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }


    public boolean isUsernameVisible() {
        return getHeader().isUserNameVisible();
    }

    public String getUsernameDisplayed() {
        return getHeader().getUserName();
    }

    public void login(String user, String password) {
        userIcon.click();
        getHeader().enterFirstName(user);
        getHeader().enterPassword(password);
        getHeader().submit();
    }

    public boolean areAllHeaderMenuItemsDisplayed() {
        return getHeader().allMenuItemsAreDisplayed();
    }

    public List<String> getHeaderMenuItemsNames() {
        return getHeader().getMenuItemsText();
    }

    public boolean allIconsAreDisplayed() {
        return benefits.allIconsAreDisplayed();
    }

    public List<String> getMenuItemsText() {
        return benefits.getMenuItemsText();
    }

    public boolean iframeIsDisplayed() {
        return IFrameElements.iframeIsDisplayed();
    }

    public boolean iframeButtonIsDisplayed() {
        return IFrameElements.iframeButtonIsDisplayed();
    }

    public void switchToPage() {
        getDriver().switchTo().defaultContent();
    }

    public boolean sideBarMenuItemsAreDisplayed() {
        return sideBarMenu.sideBarMenuItemsAreDisplayed();
    }

    public List<String> getSideBarMenuItemsNames() {
        return sideBarMenu.getSideBarMenuItemsText();
    }

    public void switchToFrame() {
        IFrameElements.switchToFrame();
    }



    public HeaderMenu clickUserIcon() {
        this.userIcon.click();
        return getHeader();
    }

}