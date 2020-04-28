package hw6.steps;

import hw6.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class GivenSteps extends BaseStep {


    @Given("I am on the Home Page")
    public void iAmOnTheHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
    }

    @And("I login as {string} and {string}")
    public void iLoginAsUserAndPassword(String user, String password) {
        HomePage homePage = new HomePage(getDriver());
        homePage.login(user, password);
    }

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite() {
        iAmOnTheHomePage();
    }

    @And("I login as user {string}")
    public void iLoginAsUser(String userName) throws IOException {
        String user = getProperty("user");
        String password = getProperty("password");
        new HomePage(getDriver()).login(user, password);
    }


}