package hw_API.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerOptions {

    IGNORE_DIGITS(2),
    IGNORE_URLS(4),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private Integer value;

    YandexSpellerOptions(Integer value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public String sumOptions(YandexSpellerOptions... options) {
        Integer sum = 0;
        for (YandexSpellerOptions o : options) {
            sum += o.value;
        }
        return String.valueOf(sum);
    }

}