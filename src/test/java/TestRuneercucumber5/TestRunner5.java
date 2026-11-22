package TestRuneercucumber5;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/java/Features5"},
	glue = {"src/test/java/JavaFoldersnextstep5"},
    plugin = {"pretty",
    		"html:target/SystemTestReport5/html"})

public class TestRunner5 {

}
