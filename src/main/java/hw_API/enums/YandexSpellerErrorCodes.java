package hw_API.enums;

import lombok.Getter;

@Getter
public enum YandexSpellerErrorCodes {

    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3),
    ERROR_TOO_MANY_ERRORS(4);

    private Integer value;

    YandexSpellerErrorCodes(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
