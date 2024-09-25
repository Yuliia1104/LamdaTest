package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"}, // Plugins for reporting
        monochrome = true // Better readability in the console
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
