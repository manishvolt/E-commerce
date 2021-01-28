package PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class test {
WebDriver driver;

public By signin=By.className("login");
public By email=By.id("email");
public By password=By.id("passwd");
private By signin2=By.xpath("//i[@class='icon-lock left']");
private By WelcomeUser=By.xpath("//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]");


public test(WebDriver driver){
	this.driver=driver;
}

public void signin(){
	driver.findElement(signin).click();
}


public void sendKeys(By elementname,String value)
{
	driver.findElement(elementname).sendKeys(value);
}


public void SignInFinal() throws InterruptedException{

	driver.findElement(signin2).click();
	Thread.sleep(3000);
	if(driver.findElement(WelcomeUser).isDisplayed()){
		Assert.assertTrue(true);
	}
	else
	{
		Assert.fail();
	}
	
}

	
}

