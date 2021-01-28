package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:Feature",
		glue="StepDefs",
		tags="@MultipleLogin",
		dryRun=false,
		monochrome=true,
		strict=true
		//plugin={"pretty", "html:target/html-cucumber-report", "json:target/cucumber.json",}
		)
public class TestRunner {

	
}


