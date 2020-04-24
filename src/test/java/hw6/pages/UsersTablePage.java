package hw6.pages;

import hw6.pages.components.LogComponent;
import hw6.entities.JDITestingUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersTablePage extends AbstractPage {

    private final LogComponent logComponent;

    @FindBy(css = "#user-table a")
    private List<WebElement> usersNames;
    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;
    @FindBy(css = "#user-table select")
    private List<WebElement> usersSelects;
    @FindBy(css = "#user-table span")
    private List<WebElement> imageDescriptions;
    @FindBy(css = "#user-table input")
    private List<WebElement> usersCheckboxes;
    @FindBy(xpath = "//td[text()=number()]")
    private List<WebElement> usersIds;


    public UsersTablePage(WebDriver driver) {
        super(driver);
        this.logComponent = new LogComponent(getDriver());
    }

    public void setVipCheckbox(String user) {
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(user)) {
                webElement.findElement(By.tagName("input")).click();
            }
        }
    }

    public boolean checkLogIsDidplayedAndContainsEntries(String parameter) {
        return logComponent.isLogDisplayed(parameter);
    }

    public List<WebElement> getUsersSelectors() {
        return usersSelects;
    }

    public List<WebElement> getUsersNameElements() {
        return usersNames;
    }

    public List<WebElement> getImageDescriptions() {
        return imageDescriptions;
    }

    public List<WebElement> getUsersCheckboxes() {
        return usersCheckboxes;
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }

    public List<WebElement> getUsersNames() {
        return usersNames;
    }

    public List<WebElement> getUsersIds() {
        return usersIds;
    }

    public List<JDITestingUser> getUsersData() {
        List<String> headerRow = getStringsFromRow(tableRows.get(0), "th");
        int numberPosition = headerRow.indexOf("Number");
        int userPosition = headerRow.indexOf("User");
        int descriptionPosition = headerRow.indexOf("Description");

        List<JDITestingUser> list = new ArrayList<>();

        for (int i = 1; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            List<String> listFromRow = getStringsFromRow(row, "td");
            String number = listFromRow.get(numberPosition);
            String user = listFromRow.get(userPosition);
            String description = listFromRow.get(descriptionPosition);

            list.add(new JDITestingUser(number, user, description.substring(0, description.length() - 3).trim()));
        }

        return list;
    }

    private List<String> getStringsFromRow(WebElement row, String selector) {
        List<String> list = new ArrayList<>();
        List<WebElement> elements = row.findElements(By.cssSelector(selector));

        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }

    public List<String> getUserRoles(String user) {
        for (WebElement webElement : tableRows) {
            if (webElement.getText().contains(user)) {
                return webElement.findElements(By.cssSelector("select option")).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}