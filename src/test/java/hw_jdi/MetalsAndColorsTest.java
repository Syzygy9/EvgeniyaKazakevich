package hw_jdi;

import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.entities.User;
import org.testng.annotations.*;
import utils.MetalsAndColorsDataProvider;


public class MetalsAndColorsTest extends BasicTest {

    @Test (dataProvider = "dataProvider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void metalsAndColorPageTest(MetalsAndColorsData data) {

        JDISite.open();

        JDISite.homePage.checkOpened();
        JDISite.homePage.login(User.ROMAN);
        JDISite.homePage.usersFullName.is().text(User.ROMAN.getFullName());
        JDISite.homePage.headerMenu.select("Metals & Colors");

        JDISite.metalsAndColorsPage.checkOpened();
        JDISite.metalsAndColorsPage.form.submit(data);
        JDISite.metalsAndColorsPage.results.has().text(data.getExpectedResult());
    }
}