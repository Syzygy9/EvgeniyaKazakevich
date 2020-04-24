package hw6.steps;

import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import hw6.pages.UsersTablePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseStep {


    @When("I go to the Header Menu {string}")
    public void iGoToTheHeaderMenu(String name) {
        new HomePage(getDriver())
                .getHeader()
                .clickServiceButton();
    }

    @When("I click the link {string} in Service Menu")
    public void iClickTheLinkInServiceMenu(String itemName) {
        new HomePage(getDriver())
                .getHeader()
                .clickDropdownMenuItem(itemName);
    }

    @And("I click on {string} button in Service Menu")
    public void iClickOnUserTableButtonInServiceMenu(String itemName) {
        iClickTheLinkInServiceMenu(itemName);
    }

    @And("I click on {string} button in Header Menu")
    public void iClickOnButtonInHeaderMenu(String name) {
        iGoToTheHeaderMenu(name);
    }


    @When("I click checkbox {string} on the Different Elements page")
    public void iClickCheckboxOnTheDifferentElementsPage(String name) {
        new DifferentElementsPage(getDriver())
                .checkCheckboxBy(name);

    }

    @When("I set radiobutton {string} on the Different Elements page")
    public void iSetRadiobuttonOnTheDifferentElementsPage(String name) {
        new DifferentElementsPage(getDriver())
                .checkRadiobuttonBy(name);
    }

    @When("I set {string} in colors dropdown")
    public void iSetColorInColorsDropdown(String color) {
        new DifferentElementsPage(getDriver())
                .setColor(color);
    }

    @When("I set {string} checkbox for {string}")
    public void iSetVipCheckboxFor(String checkbox, String name) {
        new UsersTablePage(getDriver())
                .setVipCheckbox(name);
    }
}
