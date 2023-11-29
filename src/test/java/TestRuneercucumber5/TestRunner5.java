package TestRuneercucumber5;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/java/Features5"},
	glue = {"src/test/java/JavaFoldersnextstep5"},
    plugin = {"pretty",
    		"html:target/SystemTestReport5/html"})

public class TestRunner5 {

}
