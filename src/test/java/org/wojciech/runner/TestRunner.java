package org.wojciech.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(stepNotifications = true, plugin = {"pretty",
        "html:target/cucumber-report.html", "json:target/jsonReports/cucumber.json"},
        glue = "org.wojciech.functiontest",
        features = "src/test/resources/features",
        tags = ("@smoke and not @disabled")
)

public class TestRunner {
}
