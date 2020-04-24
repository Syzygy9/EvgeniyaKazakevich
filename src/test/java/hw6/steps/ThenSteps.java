package hw6.steps;

import hw6.pages.components.LogComponent;
import hw6.entities.JDITestingUser;
import hw6.pages.DifferentElementsPage;
import hw6.pages.HomePage;
import hw6.pages.UsersTablePage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ThenSteps extends BaseStep {

    @Then("I see log containing {string}")
    public void iSeeLogContaining(String parameter) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getDriver());
        LogComponent logComponent = differentElementsPage.getLogComponent();
        assertTrue(logComponent.isLogDisplayed(parameter));
    }

    @Then("I see User name {string} on the right top side of the screen")
    public void iSeeUserNameOnTheRightSideOfTheScreen(String expected) {
        HomePage homePage = new HomePage(getDriver());
        assertTrue(homePage.isUsernameVisible());
        assertEquals(expected, homePage.getUsernameDisplayed());
    }

    @Then("Page title equals to {string}")
    public void pageTitleEqualsTo(String string) {
        HomePage homePage = new HomePage(getDriver());
        assertEquals(string, homePage.getPageTitle());
    }

    @Then("Log should be displayed and contain {string}")
    public void logShouldBeDisplayedAndContainParameters(String parameter) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getDriver());
        LogComponent logComponent = differentElementsPage.getLogComponent();
        assertTrue(logComponent.isLogDisplayed(parameter));

    }

    @Then("{int} log row has {string} text in log component")
    public void logRowHasTextInLogComponent(int arg0, String parameter) {
        assertTrue(new UsersTablePage(getDriver()).checkLogIsDidplayedAndContainsEntries(parameter));
    }

    @Then("{string} page should be opened")
    public void userTablePageShouldBeOpened(String pageName) {
        assertEquals(pageName, getDriver().getTitle());

    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        assertEquals(size, new UsersTablePage(getDriver()).getUsersSelectors().size());
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> usersNameElements = usersTablePage.getUsersNameElements();
        assertEquals(size, usersNameElements.size());
        assertTrue(checkAllElementsAreVisible(usersNameElements));
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> imageDescriptions = usersTablePage.getImageDescriptions();
        assertEquals(size, imageDescriptions.size());
        assertTrue(checkAllElementsAreVisible(imageDescriptions));
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> usersCheckboxes = usersTablePage.getUsersCheckboxes();
        assertEquals(size, usersCheckboxes.size());
        assertTrue(checkAllElementsAreVisible(usersCheckboxes));
    }

    @DataTableType
    public JDITestingUser jdiTestingUser(Map<String, String> entries) {
        return new JDITestingUser(
                entries.get("Number"),
                entries.get("User"),
                entries.get("Description"));
    }

    @And("User table should contain following values:")
    public void userTableShouldContainFollowingValues(List<JDITestingUser> users) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        assertEquals(users, usersTablePage.getUsersData());
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(List<String> dropdownValues) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<String> actual = usersTablePage.getUserRoles("Roman");
        List<String> expected = dropdownValues.subList(1, dropdownValues.size());
        assertEquals(expected, actual);
    }

    private boolean checkAllElementsAreVisible(List<WebElement> webElements) {
        return webElements.stream()
                .allMatch(WebElement::isDisplayed);
    }
}
