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
        assertThat(result[0].getS().get(0)).isEqualTo(expected);
        return this;
    }

    public Assertions verifyErrorCode(Integer code) {
        assertThat(result[0].getCode()).isEqualTo(code);
        return this;
    }

    public Assertions verifyOriginalWord(String word) {
        assertThat(this.result[0].getWord()).isEqualTo(word);
        return this;
    }

    public void verifyEmptyResponse() {
        assertThat(result).isEmpty();
    }

    public Assertions verifyNotEmptyResponse() {
        assertThat(result).isNotEmpty();
        return this;
    }

    public void verifyEmptyBodyResponse() {
        assertThat(results[0]).isEmpty();
    }

    public Assertions verifyNotEmptyBodyResponse() {
        assertThat(results[0]).isNotEmpty();
        return this;
    }
}
