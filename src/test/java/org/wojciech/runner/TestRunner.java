package org.wojciech.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)

//@CucumberOptions(
//        plugin = {"pretty", "html:target/html"},
//        features = {"classpath:features/feature.feature"},
//        snippets = CucumberOptions.SnippetType.CAMELCASE
@CucumberOptions(stepNotifications = true, plugin = {"pretty",
        "html:target/cucumber-report.html", "json:target/jsonReports/cucumber.json"},
        glue = "org.wojciech.functionaltest",
        features = "src/test/resources/features",
        tags = ("@smoke and not @disabled")
)

public class TestRunner {
}
