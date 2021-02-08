package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:Feature",
		glue="StepDefs",
		tags="@Testcase2 and @MultipleLogin",
		dryRun=false,
		monochrome=true,
		plugin={"pretty", "html:target/html/htmlreport.html", "json:target/json/file.json",}
		)
public class TestRunner {

	
}


