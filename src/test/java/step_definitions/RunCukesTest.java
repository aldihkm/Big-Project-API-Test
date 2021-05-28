package step_definitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@RegressTest" }, features = { "classpath:features/" }, glue = {
		"classpath:step_definitions" }, plugin = { "json:target/cucumber.json" })
public class RunCukesTest {

}