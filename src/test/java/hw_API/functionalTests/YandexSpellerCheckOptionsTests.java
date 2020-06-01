package hw_API.functionalTests;

import hw_API.assertions.Assertions;
import hw_API.builder.InputParameters;
import hw_API.dto.DTO;
import hw_API.service.YandexSpellerMethods;
import org.testng.annotations.Test;

import static hw_API.enums.YandexSpellerLanguages.ENG;
import static hw_API.enums.YandexSpellerLanguages.RUS;
import static hw_API.enums.YandexSpellerOptions.*;
import static hw_API.enums.TestData.TestDataWithOptions.*;

public class YandexSpellerCheckOptionsTests {

    @Test
    public void checkIgnoreDigits() {
        InputParameters request = InputParameters.builder()
                .text(DATA_IGNORE_DIGITS.getValue())
                .lang(ENG.getValue())
                .options(IGNORE_DIGITS.getValue())
                .build();
        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result).verifyEmptyResponse();
    }

    @Test
    public void checkIgnoreURLS() {
        InputParameters request = InputParameters.builder()
                .text(DATA_IGNORE_URL.getValue())
                .lang(ENG.getValue())
                .options(IGNORE_URLS.getValue())
                .build();
        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result).verifyEmptyResponse();
    }

    @Test
    public void checkIgnoreCapitalization() {
        InputParameters request = InputParameters.builder()
                .text(DATA_IGNORE_CAPITAL.getValue())
                .lang(RUS.getValue())
                .options(IGNORE_CAPITALIZATION.getValue())
                .build();
        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result).verifyEmptyResponse();
    }
}