package hw_API.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerLanguages {

    RUS("rus"),
    ENG("eng"),
    UKR("ukr");

    private String value;

    YandexSpellerLanguages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}