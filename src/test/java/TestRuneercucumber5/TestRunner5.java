
package TestRuneercucumber5;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features5",
    glue = "JavaFoldersnextstep5",
    plugin = {
        "pretty",
        "html:target/SystemTestReport5/html/index.html"
    },
    monochrome = true
)
public class TestRunner5 {
}
