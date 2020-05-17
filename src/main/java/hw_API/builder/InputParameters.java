package hw_API.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(builderMethodName = "builder")

public class InputParameters {

    private String text;
    private String lang;
    private String options;
}
