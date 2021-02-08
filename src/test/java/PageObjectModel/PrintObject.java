package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrintObject {
WebDriver driver;

public PrintObject(WebDriver driver){
	this.driver=driver;
}

private By print=By.xpath("//li//a[contains(text(),'Print')]");

public void Print(){
	driver.findElement(print).click();
}

//PrintObject a=new PrintObject(driver);
}
