package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class End_to_End_Objects {
	
WebDriver driver;

private By Quantity=By.xpath("//a//span//i[@class='icon-plus']");
private By Size=By.xpath("//select[@id='group_1']");
private By Add=By.xpath("//span[contains(text(),'Add to cart')]");
private By checkout=By.xpath("//span[contains(text(),'Proceed to checkout')]");


public End_to_End_Objects(WebDriver driver){
	this.driver=driver;
}

public void Select_Quantity(){
	WebDriverWait a=new WebDriverWait(driver,20);
	WebElement QuantityButton=a.until(ExpectedConditions.elementToBeClickable(Quantity));
	QuantityButton.click();
	
}

public void Select_Size(){
	WebElement ELement=driver.findElement(Size);
	Select Ref=new Select(ELement);
	Ref.selectByValue("3");
}

public void Add_to_cart(){
	driver.findElement(Add).click();
}

public void Proceedtocheckout(){
	driver.findElement(checkout).click();
}

}
