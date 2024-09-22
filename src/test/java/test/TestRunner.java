package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"steps"},
        plugin = {"pretty", "html:cucumberReport.html", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false,
        tags = "${cucumber.filter.tags}",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner extends AbstractTestNGCucumberTests {

}