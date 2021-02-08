package StepDefs;


import org.openqa.selenium.WebDriver;
import PageObjectModel.PrintObject;
import io.cucumber.java.en.Given;

public class stepdef_print {
public static WebDriver driver;
//PrintObject obj;

@Given("user clicks on Print")
public void user_clicks_on_Print() {
	PrintObject obj=new PrintObject(driver);
	obj.Print();
}

}
