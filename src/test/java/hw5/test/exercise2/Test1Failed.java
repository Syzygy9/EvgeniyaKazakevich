package hw5.test.exercise2;

import hw5.test.BaseTest;
import hw5.test.steps.HomePageSteps;
import hw5.utils.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureScreenshotListener.class})
public class Test1Failed extends BaseTest {

    @Feature("Testing functionality of https://jdi-testing.github.io/jdi-light/index.html with failure")
    @Story("Login on home page and assert web elements on page")
    @Test
    public void checkStepsForExercise1() {

        HomePageSteps homePage = new HomePageSteps(driver);

        // 1. Open site by URL
        homePage.openSitePage();

        // 2. Assert Browser title
        homePage.PageTitleEqualsHomePage("Home Page");

        // 3.
        homePage.login(USER, PASSWORD);

        //  4. Assert User name in the left-top side of screen that user is logged
        homePage.usernameIsDisplayed();
        homePage.headerMenuHasFourItems(3);
        homePage.usernameEqualsRomanIovlev("ROMAN IOVLEV");

        homePage.assertAll();
    }
}