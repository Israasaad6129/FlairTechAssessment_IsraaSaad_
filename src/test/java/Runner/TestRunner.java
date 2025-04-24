package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resourses/features/loginpage.feature",

        glue = {"org.opensource.stepdefs.LoginPageStepDef"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
