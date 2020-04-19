package hw5.test.steps;

import hw5.pages.HomePage;
import hw5.utils.ConfigProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePageSteps {

    protected final static String URL = ConfigProperties.getProperty("url");
    private final WebDriver driver;
    private final HomePage homePage;
    private SoftAssert softAssert;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Step("I opened Home page")
    public void openSitePage() {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Step("Page title equals '{0}'")
    public void PageTitleEqualsHomePage(String expectedValue) {
        String actualValue = driver.getTitle();
        softAssert.assertEquals(actualValue, expectedValue);
    }

    @Step("I logged in as username:'{0}' password:'{1}'")
    public void login(String username, String password) {
        homePage.login(username, password);
    }

    @Step("User name is displayed")
    public void usernameIsDisplayed() {
        softAssert.assertTrue(homePage.isUserNameDisplayed());
    }

    @Step("User name equals '{0}'")
    public void usernameEqualsRomanIovlev(String value) {
        softAssert.assertEquals(homePage.getUserName(), value);
    }

    @Step("Header menu is displayed")
    public void headerMenuIsDisplayed() {
        softAssert.assertTrue(homePage.isHeaderMenuItemsDisplayed());
    }

    @Step("Header menu has '{0}' items")
    public void headerMenuHasFourItems(int amountOfItems) {
        softAssert.assertEquals(homePage.getHeaderMenuItemsText().size(), amountOfItems);
    }

    @Step("Header menu contains '{0}'")
    public void headerMenuContains(List<String> expectedHeaderText) {
        List<String> actualHeaderMenuItemsText = homePage.getHeaderMenuItemsText();
        softAssert.assertEquals(actualHeaderMenuItemsText.size(), 4);
        softAssert.assertEquals(actualHeaderMenuItemsText, expectedHeaderText);
    }

    @Step("Home page has '{0}' images")
    public void amountOfImagesEqualsFour(int amountOfItems) {
        softAssert.assertEquals(homePage.getBenefitImagesNumber(), amountOfItems);
    }

    @Step("Images on Home page are displayed")
    public void homePageImagesAreDisplayed() {
        softAssert.assertTrue(homePage.isBenefitIconsDisplayed());
    }

    @Step("Home page has '{0}' texts under images")
    public void amountOfTextsUnderImagesEqualsFour(int amountOfItems) {
        softAssert.assertEquals(homePage.getBenefitTexts().size(), amountOfItems);
    }

    @Step("Texts under images on Home page contain '{}'")
    public void textsUnderImagesContain(List<String> expectedText) {
        List<String> actualBenefitTexts = homePage.getBenefitTexts();
        softAssert.assertEquals(actualBenefitTexts, expectedText);
    }

    @Step("IFrame is displayed")
    public void IFrameButtonIsDisplayed() {
        softAssert.assertTrue(homePage.isIFrameDisplayed());
    }

    @Step("Switch to IFrame")
    public void switchToIFrameElements() {
        homePage.switchToFrame();
    }

    @Step("Button in iframe is displayed")
    public void iFrameButtonIsDisplayed() {
        softAssert.assertTrue(homePage.isIFrameButtonDisplayed());
    }

    @Step("Switch back to original window")
    public void switchToOriginalWindow() {
        homePage.switchToOriginalWindow();
    }

    @Step("Home page has '{0}' items in left sidebar menu")
    public void amountOfLeftSideBarMenuItemsIsFive(int value) {
        softAssert.assertEquals(homePage.getSideBarItemsNumber(), value);
    }

    @Step("Left sidebar menu contains '{0}'")
    public void leftSideBarMenuContains(List<String> expectedText) {
        softAssert.assertEquals(homePage.getSideBarMenuItemsText(), expectedText);
    }

    @Step("Left sidebar menu elements are displayed")
    public void leftSideBarMenuItemsAreDisplayed() {
        softAssert.assertTrue(homePage.isSidebarMenuItemsDisplayed());
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        homePage.openDifferentElementsPage();
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}