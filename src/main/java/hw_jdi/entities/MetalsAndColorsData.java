package hw_jdi.entities;

import lombok.*;
import static java.lang.String.*;
import static java.util.Arrays.stream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MetalsAndColorsData {

    private int[] summary;
    private String color;
    private String metals;
    private String[] vegetables;
    private String[] elements;


    public String getVegetablesAsString() {
        return getElementsAsString(vegetables);

    }

    public String getElementsAsString() {
        return getElementsAsString(elements);
    }

    public String getExpectedResult() {

        return format(
                "Summary: %s\n" +
                        "Elements: %s\n" +
                        "Color: %s\n" +
                        "Metal: %s\n" +
                        "Vegetables: %s",
                stream(this.summary).sum(),
                this.getElementsAsString(),
                this.color,
                this.metals,
                this.getVegetablesAsString());
    }

    private String getElementsAsString(String[] elements) {
        StringBuilder stringBuilder = new StringBuilder();
        return String.join(", ", elements);
    }

    public int getOddSummary() {
        return this.summary[0];
    }

    public int geEvenSummary() {
        return this.summary[1];
    }


}
