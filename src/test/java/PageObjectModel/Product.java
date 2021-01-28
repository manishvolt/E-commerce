package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {
WebDriver driver;

private By TshirtSection=By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a");
private By FadedshortSleve=By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
private By SendToFriend=By.xpath("//a[@id='send_friend_button']");
private By FriendsName=By.id("friend_name");
private By FriendsEmail=By.id("friend_email");
private By Send=By.xpath("//button[@id='sendEmail']//span[contains(text(),'Send')]");

public Product(WebDriver driver){
	this.driver=driver;
}

public void TshirtSec() throws InterruptedException{
	driver.findElement(TshirtSection).click();
	Thread.sleep(5000);
}

public void SelectProduct(){
	driver.findElement(FadedshortSleve).click();
}

public void SendToFriend(){
	driver.findElement(SendToFriend).click();
}

public void FriendsInfo(){
	WebElement EnterName=driver.findElement(FriendsName);
	EnterName.sendKeys("vicky");
	WebElement EnterEmail=driver.findElement(FriendsEmail);
	EnterEmail.sendKeys("viks@gmail.com");
	driver.findElement(Send).click();
}
}
