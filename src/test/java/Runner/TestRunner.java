package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\nitesh.sahu\\Desktop\\cucumber data\\cucumber-local-saucelabs\\Features\\Login.feature"},
        glue = "StepDefinitions"
)
public class TestRunner{
}
