package hw_API.assertions;

import hw_API.dto.DTO;
import static org.assertj.core.api.Assertions.assertThat;

public class Assertions {

    private DTO[] result;
    private DTO[][] results;

    public Assertions(DTO[] result) {
        this.result = result;
    }

    public Assertions(DTO[][] results) {
        this.results = results;
    }

    public Assertions verifyChoices(String expected) {
        assertThat(result[0].getS().get(0))
                .withFailMessage("The word %s not equals %s", result[0].getS().get(0), expected)
                .isEqualTo(expected);
        return this;
    }

    public Assertions verifyErrorCode(Integer code) {
        assertThat(result[0].getCode())
                .withFailMessage("Error code is %s but expected %s", result[0].getCode(), code)
                .isEqualTo(code);
        return this;
    }

    public Assertions verifyOriginalWord(String word) {
        assertThat(this.result[0].getWord())
                .withFailMessage("The word %s not equals %s", result[0].getWord(), word)
                .isEqualTo(word);
        return this;
    }

    public void verifyEmptyResponse() {
        assertThat(result)
                .withFailMessage("Failed asserting that response is empty", result.toString())
                .isEmpty();
    }

    public Assertions verifyNotEmptyResponse() {
        assertThat(result)
                .withFailMessage("Failed asserting that response is not empty")
                .isNotEmpty();
        return this;
    }

    public void verifyEmptyBodyResponse() {
        assertThat(results[0])
                .withFailMessage("Failed asserting that response is empty", results[0].toString())
                .isEmpty();
    }

    public Assertions verifyNotEmptyBodyResponse() {
        assertThat(results[0])
                .withFailMessage("Failed asserting that response is not empty")
                .isNotEmpty();
        return this;
    }
}
