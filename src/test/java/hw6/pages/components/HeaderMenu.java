package hw6.pages.components;

import hw6.pages.AbstractPageComponents;
import hw6.pages.DifferentElementsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenu extends AbstractPageComponents {

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement userNameInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement submitLoginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(css = ".m-l8 > li")
    List<WebElement> headerMenuItems;
    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceMenu;
    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdownMenu;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu enterFirstName(String firstName) {
        this.userNameInputField.sendKeys(firstName);
        return this;
    }

    public HeaderMenu enterPassword(String password) {
        this.passwordInputField.sendKeys(password);
        return this;
    }

    public void submit() {
        this.submitLoginButton.click();
    }

    public boolean isUserNameVisible() {
        return userName.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public HeaderMenu clickDropdownMenuItem(String name) {
        WebElement element = dropdownMenu.stream()
                .filter(item -> item.getText().equals(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Unable to locate Dropdown menu item " + name));
        element.click();
        return this;
    }

    public DifferentElementsPage clickServiceButton() {
        serviceMenu.click();
        return new DifferentElementsPage(getDriver());
    }

    public boolean allMenuItemsAreDisplayed() {
        return headerMenuItems.stream()
                .allMatch(item -> item.isDisplayed());
    }

    public List<String> getMenuItemsText() {
        return headerMenuItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}