package hw_jdi.pages.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @UI("[name=custom_radio_odd]")
    private RadioButtons oddSummary;
    @UI("[name=custom_radio_even]")
    private RadioButtons evenSummary;
    @Css("#elements-checklist input")
    private Checklist elements;
    @Css("#submit-button")
    private Button submit;

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown color;

    @JDropdown(root = "div[id=metals]",
            value = "input",
            list = "li",
            expand = ".caret")
    private Dropdown metal;

    @JDropdown(root = "div[id=vegetables]",
            value = "button",
            list = "li",
            expand = ".caret")
    private Dropdown vegetable;


    @Override
    public void submit(MetalsAndColorsData data) {

        oddSummary.select(String.valueOf(data.getOddSummary()));
        evenSummary.select(String.valueOf(data.geEvenSummary()));
        color.select(data.getColor());
        metal.select(data.getMetals());

        if (!asList(data.getVegetables()).contains("Vegetables")) {
            vegetable.select("Vegetables");
        }

        stream(data.getVegetables())
                .filter(dataVegetable -> !"Vegetables".equals(dataVegetable))
                .forEach(dataVegetable -> vegetable.select(dataVegetable));
        stream(data.getElements())
                .forEach(element -> elements.select(element));

        submit.click();
    }
}
