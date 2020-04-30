package hw_jdi.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw_jdi.pages.forms.MetalsAndColorsForm;


public class MetalsAndColorsPage extends WebPage {

    @Css(".form")
    public MetalsAndColorsForm form;
    @Css(".results")
    public Section results;

}