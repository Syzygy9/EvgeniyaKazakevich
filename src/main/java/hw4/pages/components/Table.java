package hw4.pages.components;

import hw4.pages.AbstractPageComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Table extends AbstractPageComponents {

    @FindBy(css = ".dataTable tbody tr")
    private List<WebElement> table;

    public Table(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<WebElement> getWebElements() {
        return table;
    }

    public int getRowsNumber() {
        return table.size();
    }
}