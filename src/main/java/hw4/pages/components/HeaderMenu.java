package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
    List<WebElement> headerMenuElements;
    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceDropdown;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsPage;
    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tablePages;
    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalAndColorPage;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return headerMenuElements;
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user-icon"))).click();
        wait.until(ExpectedConditions.attributeToBe(By.className("uui-profile-menu"), "class",
                "dropdown uui-profile-menu open"));
        userNameInputField.sendKeys(user);
        passwordInputField.sendKeys(pass);
        submitLoginButton.click();
    }

    public boolean isUserNameDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        return userName.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public void openTablePage() {
        serviceDropdown.click();
        //wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".m-l8 .dropdown"), "class", "dropdown open"));
        tablePages.click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-content-hg")));
    }

    public void openMetalsAndColorsPage() {
        serviceDropdown.click();
        metalAndColorPage.click();
    }
}