package essPackage.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/ESS.feature",
        glue = {"essPackage"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRuner extends AbstractTestNGCucumberTests {

}
