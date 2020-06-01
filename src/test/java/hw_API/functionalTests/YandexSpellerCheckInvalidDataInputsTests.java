package hw_API.functionalTests;

import hw_API.assertions.Assertions;
import hw_API.builder.InputParameters;
import hw_API.dto.DTO;
import hw_API.service.YandexSpellerMethods;
import org.testng.annotations.Test;

import static hw_API.enums.YandexSpellerLanguages.ENG;
import static hw_API.enums.YandexSpellerLanguages.RUS;
import static hw_API.enums.TestData.InvalidDataInputs.*;
import static hw_API.enums.TestData.TestDataSet.ENG_WORD;

public class YandexSpellerCheckInvalidDataInputsTests {


    @Test
    public void checkWrongLanguage() {
        InputParameters request = InputParameters.builder()
                .text(ENG_WORD.getCorrect())
                .lang(RUS.getValue())
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyEmptyResponse();
    }

    @Test
    public void checkIllegalCharacter() {
        InputParameters request = InputParameters.builder()
                .text(INVALID_TEXT.getValue())
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyEmptyResponse();
    }


    @Test
    public void checkInvalidOptions() {
        InputParameters request = InputParameters.builder()
                .text(ENG_WORD.getCorrect())
                .lang(ENG.getValue())
                .options(INVALID_OPTIONS.getValue())
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyEmptyResponse();
    }


}