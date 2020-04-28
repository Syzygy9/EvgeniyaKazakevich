package hw4.util;

import java.util.ArrayList;
import java.util.List;

public class Summary {

    public static String summ(List<String> numbers) {
        List<Integer> ints = new ArrayList<>();
        for (String number : numbers) {
            ints.add(Integer.parseInt(number));
        }
        return String.valueOf(ints.stream().mapToInt(Integer::intValue).sum());
    }
}