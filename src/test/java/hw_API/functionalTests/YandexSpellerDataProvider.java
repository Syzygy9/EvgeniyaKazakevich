package hw_API.functionalTests;

import org.testng.annotations.DataProvider;

import static hw_API.enums.YandexSpellerLanguages.*;
import static hw_API.enums.TestData.TestDataSet.*;

public class YandexSpellerDataProvider {

    @DataProvider
    public Object[][] rightWord() {
        return new Object[][]{
                {ENG_WORD.getCorrect(), ENG.getValue()},
                {RUS_WORD.getCorrect(), RUS.getValue()},
                {UKR_WORD.getCorrect(), UKR.getValue()},
        };
    }

    @DataProvider
    public Object[][] rightSentence() {
        return new Object[][]{
                {ENG_PHRASE.getCorrect(), ENG.getValue()},
                {RUS_PHRASE.getCorrect(), RUS.getValue()},
                {UKR_PHRASE.getCorrect(), UKR.getValue()},
        };
    }

    @DataProvider
    public Object[][] wrongWord() {
        return new Object[][]{
                {ENG_WRONG_WORD.getWrong(), ENG.getValue(), ENG_WRONG_WORD.getCorrect()},
                {RUS_WRONG_WORD.getWrong(), RUS.getValue(), RUS_WRONG_WORD.getCorrect()},
                {UKR_WRONG_WORD.getWrong(), UKR.getValue(), UKR_WRONG_WORD.getCorrect()},

        };
    }

    @DataProvider
    public Object[][] wrongSentence() {
        return new Object[][]{
                {ENG_WRONG_PHRASE.getWrong(), ENG.getValue(), ENG_WRONG_PHRASE.getCorrect()},
                {RUS_WRONG_PHRASE.getWrong(), RUS.getValue(), RUS_WRONG_PHRASE.getCorrect()},
                {UKR_WRONG_PHRASE.getWrong(), UKR.getValue(), UKR_WRONG_PHRASE.getCorrect()}
        };
    }

    @DataProvider
    public Object[][] checkTextsRightData() {
        return new Object[][]{
                {ENG_WORD.getCorrect(), ENG_PHRASE.getCorrect()},
                {RUS_WORD.getCorrect(), RUS_PHRASE.getCorrect()},
                {UKR_WORD.getCorrect(), UKR_PHRASE.getCorrect()}
        };
    }

    @DataProvider
    public Object[][] checkTextsWrongData() {
        return new Object[][]{
                {ENG_WRONG_WORD.getWrong(), ENG_WRONG_PHRASE.getWrong()},
                {RUS_WRONG_WORD.getWrong(), RUS_WRONG_PHRASE.getWrong()},
                {UKR_WRONG_WORD.getWrong(), UKR_WRONG_PHRASE.getWrong()}
        };
    }
}