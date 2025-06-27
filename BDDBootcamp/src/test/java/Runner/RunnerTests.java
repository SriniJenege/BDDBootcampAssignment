package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features/saucedemo.feature",glue = {"stepDefinition"},
        monochrome = true,
        plugin={"pretty","html:target/cucumber-reports/cucumber.html"})

public class RunnerTests {
}
