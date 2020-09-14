package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Features/bookings/bookings.feature"},
        plugin = {"pretty", "html:target/Destination/index.html"},
        glue = "stepdefinitions"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
