package hw6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/test/resources/hw6/features"
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}