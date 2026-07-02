package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",        // Path to feature files
        glue = "stepDefinitions",                   // Step definitions package
//       tags = "@E2E_Test",                         // Tag filter
        plugin = {
                "pretty",                                                   // Console output
                "html:target/cucumber-basic-reports/Report.html",           // Basic Cucumber HTML
                "json:target/cucumber-reports/cucumber.json",               // JSON for Masterthought
                "junit:target/cucumber-reports/cucumber.xml",               // JUnit XML for CI/CD
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"          // Allure results
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
        // No code needed inside
}
