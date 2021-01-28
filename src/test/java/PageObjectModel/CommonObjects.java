package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonObjects {
WebDriver driver;

private By SignIn=By.className("login");
private By Email=By.id("email_create");
private By CreateAccount=By.xpath("//i[@class='icon-user left']");

private By RegisteredEmail=By.id("email");
private By RegisteredPassword=By.id("passwd");
private By SubMit=By.xpath("//button[@id='SubmitLogin']/span");

public CommonObjects(WebDriver driver){
this.driver=driver;
}

public void Signup(){
	driver.findElement(SignIn).click();
	}
public void Email(){
	WebElement EnterEmail=driver.findElement(Email);
	EnterEmail.sendKeys("volt@gmail.com");
}

public void CreateAccnt(){
	driver.findElement(CreateAccount).click();
}

public void login_with_registered_emailpassword(){
	WebDriverWait email=new WebDriverWait(driver, 20);
	WebElement EnterEmail=email.until(ExpectedConditions.elementToBeClickable(RegisteredEmail));
	EnterEmail.sendKeys("mnighut@gmail.com");
	
	WebElement password=driver.findElement(RegisteredPassword);
	password.sendKeys("ilovecs1.6");
}

public void Submit(){
	driver.findElement(SubMit).click();
}
}
	

