package hw_API.functionalTests;

import hw_API.assertions.Assertions;
import hw_API.builder.InputParameters;
import hw_API.dto.DTO;
import hw_API.service.YandexSpellerMethods;
import org.testng.annotations.Test;

public class YandexSpellerCheckText {

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "rightWord")
    public void checkRightWordWithTextMethod(String text, String lang) {
        InputParameters request = InputParameters.builder()
                .text(text)
                .lang(lang)
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyEmptyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "wrongWord")
    public void checkWrongWordWithTextMethod(String text, String lang, String expected) {
        InputParameters request = InputParameters.builder()
                .text(text)
                .lang(lang)
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyNotEmptyResponse()
                .verifyOriginalWord(text)
                .verifyChoices(expected);
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "rightSentence")
    public void checkRightPhraseWithTextMethod(String text, String lang) {
        InputParameters request = InputParameters.builder()
                .text(text)
                .lang(lang)
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyEmptyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "wrongSentence")
    public void checkWrongPhraseWithTextMethod(String text, String lang, String expected) {
        InputParameters request = InputParameters.builder()
                .text(text)
                .lang(lang)
                .build();

        DTO[] result = new YandexSpellerMethods().getCheckText(request);
        new Assertions(result)
                .verifyNotEmptyResponse()
                .verifyChoices(expected);
    }
}
