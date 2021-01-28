package StepDefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObjectModel.CommonObjects;
import PageObjectModel.End_to_End_Objects;
import PageObjectModel.FormObjects;
import PageObjectModel.Product;
import PageObjectModel.test;
import WebDriverFactory.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	private static final Logger logger = LogManager.getLogger(StepDefinition.class);
	public static WebDriver driver;
	String url="http://Automationpractice.com";
	CommonObjects cmnobjects;
	FormObjects formobjects;
	Product product;
	End_to_End_Objects End;
	test Test;
	
	String Expected="Welcome to your account. Here you can manage all of your personal information and orders.";
	Scenario scn;
	
	@Before
	public void user_launches_browser(Scenario scn) throws Exception {
	String BrowserName=WebDriverFactory.BrowserName();
	driver=	WebDriverFactory.GetDriverForBrowser(BrowserName);
	logger.info("browser invoked");
	formobjects=new FormObjects(driver);
	cmnobjects=new CommonObjects(driver); 
	End=new End_to_End_Objects(driver);
	Test=new test(driver);
	this.scn=scn;
	}

	@Given("user hits the url")
	public void user_hits_the_url() {
		driver.get(url);
		//scn.log("application URL opened " + url );
	}

	@Given("user clicks on signin")
	public void user_clicks_on_signin() {
	cmnobjects.Signup();
	
	}

	@When("user fill up the form and register")
	public void user_fill_up_the_form_and_register(DataTable Dt) throws InterruptedException {
		cmnobjects.Email();
		cmnobjects.CreateAccnt();
		
		formobjects.SelectTitle();
		List<String> L=Dt.asList();
		for(int i=0; i<L.size(); i++){
			System.out.println(L.get(i));
		}
		formobjects.sendkeys(formobjects.FirstName, L.get(0));
		formobjects.sendkeys(formobjects.LastName, L.get(1));
		formobjects.sendkeys(formobjects.PassWord, L.get(3));
		formobjects.day();
		formobjects.month();
		formobjects.year();
		formobjects.sendkeys(formobjects.Company, L.get(4));
		formobjects.sendkeys(formobjects.Address, L.get(5));
		formobjects.sendkeys(formobjects.Address2, L.get(6));
		formobjects.sendkeys(formobjects.City, L.get(7));
		formobjects.state();
		formobjects.sendkeys(formobjects.ZipCode, L.get(8));
		formobjects.sendkeys(formobjects.phone, L.get(9));
		formobjects.submit();
		}

	@Then("user is logged in")
	public void user_is_logged_in() {
		
		WebElement LoginVerify=driver.findElement(By.xpath("//p[@class='info-account']"));
		
	    Assert.assertEquals(Expected, LoginVerify.getText()); 
		System.out.println("user is logged in");
	}
	
	@Given("User goes in Tshirt")
	public void user_goes_in_Tshirt() throws InterruptedException {
	   product=new Product(driver);
	   product.TshirtSec();
	   Thread.sleep(6000);
	}

	@Given("User selects product")
	public void user_selects_product() {
	    product.SelectProduct();
	    //scn.log("product is selected");
	}

	@Given("User chooses sendtofriend option")
	public void user_chooses_sendtofriend_option() {
	   product.SendToFriend();
	}

	@When("Recipients info is entered and submitted")
	public void recipients_info_is_entered_and_submitted() {
	  product.FriendsInfo();
	}

	@Then("email is being sent")
	public void email_is_being_sent() {
	    //scn.log("email sent");
	}
	
	
	@When("user enters credential")
	public void user_enters_credential() throws InterruptedException {
		Thread.sleep(2000);
	    cmnobjects.login_with_registered_emailpassword();
	}
	
	@Given("user verifies the price of product")
	public void user_verifies_the_price_of_product() throws InterruptedException {
		//End=new End_to_End_Objects(driver);
		Thread.sleep(3000);
		String Amount=driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
		Float Amt=Float.parseFloat(Amount.replace("$", ""));
		//scn.log("price verified " + Amt);
	}

	@Given("user selects quanity")
	public void user_selects_quanity() {
		End.Select_Quantity();
		
	}
	@Given("user selects size")
	public void user_selects_size() {
	   End.Select_Size();
	}
	@Given("user clicks on add to cart")
	public void user_clicks_on_add_to_cart() throws InterruptedException {
	Thread.sleep(2000); 
	End.Add_to_cart();
	 Thread.sleep(3000);
	 }

	@Then("product is successfully added to cart")
	public void product_is_successfully_added_to_cart() {
		if(driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2")).getText().contains("Product successfully added to your shopping cart")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
			
		}
		
		Assert.assertEquals("Orange, L", driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/div[2]/span[2]")).getText().toString());
		
		String Total_Amount =driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();
		float Total=Float.parseFloat(Total_Amount.replace("$", ""));
		
		String QuanityOfProduct=driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
		int Quantity=Integer.parseInt(QuanityOfProduct);
		
		String Amount_of_1product=driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
		Float Amount=Float.parseFloat(Amount_of_1product.replace("$", ""));
		
		if(Amount*Quantity==Total){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
		}
		
	}
	
	@Then("proceed to checkout")
	public void proceed_to_checkout() throws InterruptedException{
		End.Proceedtocheckout();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td//p//a[contains(text(),'Faded Short Sleeve T-shirts')]")).getText().contains("Faded Short Sleeve T-shirts")){
			Assert.assertTrue(true);
			System.out.println("product name is avaialble");
		}
		else{
			Assert.fail();
		}
		
		if(driver.findElement(By.xpath("//span[@class='label label-success']")).getText().contains("In stock")){
			Assert.assertTrue(true);
			//scn.log("item in stock");
		}
		else{
			Assert.fail();
		}
		
		if(driver.findElement(By.xpath("//span[contains(text(),'$16.51')]")).getText().contains("$16.51")){
			Assert.assertTrue(true);
			//scn.log("unit price is correct");
		}
		
		else{
			Assert.fail();
		}
		
		String Quant=driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
		Assert.assertEquals(Quant, driver.findElement(By.xpath("//td//input[@class='cart_quantity_input form-control grey']")).getText());
		
		String SinglePrice=driver.findElement(By.xpath("//span[contains(text(),'$16.51')]")).getText().replace("$", "");
		float singleproductprice=Float.parseFloat(SinglePrice);
		
		String TotalShiping=driver.findElement(By.xpath("//td[@id='total_shipping']")).getText().replace("$", "");
		float ShipingCost=Float.parseFloat(TotalShiping);
		
		String TotalProductPrice=driver.findElement(By.xpath("//span[@id='total_price']")).getText().replace("$", "");
		float priceintotal=Float.parseFloat(TotalProductPrice);
		
		if(singleproductprice+singleproductprice+ShipingCost==priceintotal){
			Assert.assertTrue(true);
			//scn.log("Total is equal to twice the amount with $ 2 for shipping");
		}
		else{
			Assert.fail();
			
		}
	}
	
	@Then("complete order payment")
	public void complete_order_payment() throws InterruptedException{
		driver.findElement(By.xpath("//p/a/span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button//span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button//span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button//span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Close']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='cgv']")).click();
		driver.findElement(By.xpath("//button//span[contains(text(),'Proceed to checkout')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		Thread.sleep(2000);
        driver.findElement(By.xpath("//button//span[contains(text(),'I confirm my order')]")).click();
        
        if(driver.findElement(By.xpath("//p//strong[@class='dark']")).getText().contains("Your order on My Store is complete.")){
        	Assert.assertTrue(true);
        }
        else{
        	Assert.fail();
        }
        
        String Amount="$35.02";
        if(driver.findElement(By.xpath("//span[@class='price']//strong")).getText().equals(Amount)){
        	Assert.assertTrue(true);
        	//scn.log("test case passed");
        }
        else{
        	Assert.fail();
        }
		
	}
	
	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		Test.sendKeys(Test.email, email);
		Test.sendKeys(Test.password, password);
	    cmnobjects.Submit();
	} 
	
	/*@When("user enters email as and password")
	public void user_enters_email_as_and_password(DataTable DT) {
	List<List<String>> l=DT.asLists();
	for(int i=0; i<l.size(); i++){
		System.out.println(l.get(i).get(0));
	}*/
			
		/*Test.signin();
		Test.sendKeys(Test.email, uname);
		Test.sendKeys(Test.password, password);*/
		


	/*@Then("user logs in")
	public void user_logs_in() throws InterruptedException {
		Test.SignInFinal();
		System.out.println("logged in");
	}
	*/
	
	
	/*@After(order=2)
	public void Screenshot(Scenario s){
		if(s.isFailed()){
			TakesScreenshot scrnshot=(TakesScreenshot)driver;
			byte[] data=scrnshot.getScreenshotAs(OutputType.BYTES);
			//scn.attach(data, "image/png", "failed step " +s.getName());
		}
		else{
			//scn.log("test case passed");
		}
	}*/


	@After
	public void CleanUp(){
		driver.quit();
	}
}
