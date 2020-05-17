package hw_API.functionalTests;

import hw_API.assertions.Assertions;
import hw_API.dto.DTO;
import hw_API.service.YandexSpellerMethods;
import org.testng.annotations.Test;

public class YandexSpellerCheckTexts {

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "checkTextsRightData")
    public void checkRightDataWithTextsMethod(String firstText, String secondText) {
        DTO[][] results = new YandexSpellerMethods()
                .getCheckTexts(new String[]{firstText, secondText});

        new Assertions(results)
                .verifyEmptyBodyResponse();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "checkTextsWrongData")
    public void checkWrongDataWithTextsMethod(String firstText, String secondText) {
        DTO[][] results = new YandexSpellerMethods()
                .getCheckTexts(new String[]{firstText, secondText});

        new Assertions(results)
                .verifyNotEmptyBodyResponse();
    }
}