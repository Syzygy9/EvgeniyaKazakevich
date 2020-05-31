package hw_API.lowLevelTests;

import hw_API.service.URI;
import hw_API.utils.ConfigProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static hw_API.enums.YandexSpellerErrorCodes.*;
import static hw_API.enums.YandexSpellerLanguages.ENG;
import static hw_API.enums.YandexSpellerLanguages.RUS;
import static hw_API.enums.TestData.TestDataSet.ENG_WORD;
import static hw_API.enums.TestData.TestDataSet.RUS_WRONG_WORD;
import static hw_API.enums.YandexSpellerParams.*;
import static hw_API.service.URI.BASE_URI;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class LowLevelTests {

    protected RequestSpecification REQUEST_SPECIFICATION;

    @BeforeMethod
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @Test
    public void checkRightText() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(PARAM_TEXT, ENG_WORD)
                .param(PARAM_LANG, ENG.getValue())
                .log().everything()
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("[]"));
    }

    @Test
    public void checkWrongText() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(PARAM_TEXT, RUS_WRONG_WORD.getWrong())
                .param(PARAM_LANG, RUS.getValue())
                .log().everything()
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("s[0]", hasItem(RUS_WRONG_WORD.getCorrect()))
                .body("word[0]", is(RUS_WRONG_WORD.getWrong()))
                .body("code[0]", is(ERROR_UNKNOWN_WORD.getValue()));
    }

    @Test
    public void checkStatusCode() {
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}