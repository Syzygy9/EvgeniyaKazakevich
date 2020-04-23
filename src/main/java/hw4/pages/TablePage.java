package hw4.pages;

import hw4.pages.components.SearchInputField;
import hw4.pages.components.ShowEntriesDropdown;
import hw4.pages.components.Table;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TablePage extends AbstractPage {

    private ShowEntriesDropdown dropdown;
    private SearchInputField searchInputField;
    private Table table;

    protected TablePage(WebDriver driver) {
        super(driver);
        dropdown = new ShowEntriesDropdown(driver);
        searchInputField = new SearchInputField(driver);
        table = new Table(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public void typeInSearchInputField(String keys) {
        searchInputField.getWebElement().sendKeys(keys);
    }

    public void setDropdownValue(String value){
        Select select = new Select(dropdown.getWebElement());
        select.selectByVisibleText(value);
    }

    public WebElement getSelectedDropdownValue() {
        Select select = new Select(dropdown.getWebElement());
        return select.getFirstSelectedOption();
    }

    public int getRowsNumber() {
        return table.getRowsNumber();
    }

    public List<WebElement> getTableValues() {
        return table.getWebElements();
    }
}