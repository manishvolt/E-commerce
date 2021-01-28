package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormObjects {
WebDriver driver;

private By Title=By.id("id_gender1");
public By FirstName=By.id("customer_firstname");
public By LastName=By.id("customer_lastname");
public By PassWord=By.id("passwd");
private By day=By.id("days");
private By month=By.id("months");
private By year=By.xpath("//select[@name='years']");
public By Company=By.id("company");
public By Address=By.id("address1");
public By Address2=By.id("address2");
public By City=By.id("city");
private By state=By.id("id_state");
public By ZipCode=By.id("postcode");
private By country=By.id("id_country");
public By phone=By.id("phone");
private By SubmitButton=By.xpath("//span[contains(text(),'Register')]");


public FormObjects(WebDriver driver){
	this.driver=driver;
}

public void SelectTitle(){
	driver.findElement(Title).click();
}

public void FirstName(){
	WebElement Name=driver.findElement(FirstName);
	Name.sendKeys("manish");
}

public void LastName(){
	WebElement lastname=driver.findElement(LastName);
	lastname.sendKeys("nighut");
}

public void PassWord(){
	WebElement password=driver.findElement(PassWord);
	password.sendKeys("ilovecs1.6");
}

public void day(){
	WebElement DayToBeSelected=driver.findElement(day);
	Select a=new Select(DayToBeSelected);
	a.selectByValue("12");
}

public void month(){
	WebElement MonthToBeSelected=driver.findElement(month);
	Select b=new Select(MonthToBeSelected);
	b.selectByValue("3");
}

public void year(){
	WebElement YearToBeSelected=driver.findElement(year);
	Select c=new Select(YearToBeSelected);
		c.selectByValue("1993"); 
	/*List <WebElement> YearToBeSelected=driver.findElements(year);
	 for(int i=0; i<YearToBeSelected.size(); i++){
		 System.out.println(YearToBeSelected.get(i).getText()); 
		 if(YearToBeSelected.get(i).getText().equals("1993")){
			 YearToBeSelected.get(i).click(); 
		 }
	 }*/
	 
}

public void Company(){
	driver.findElement(Company).sendKeys("gridlogics");
}

public void Address(){
	driver.findElement(Address).sendKeys("kharadi");
}

public void Address2(){
	driver.findElement(Address2).sendKeys("chandan nagar");
}

public void City(){
	driver.findElement(City).sendKeys("pune");
}

public void state(){
	WebElement statename=driver.findElement(state);
	Select a =new Select (statename);
	a.selectByVisibleText("Florida");
}

public void Zip(){
	driver.findElement(ZipCode).sendKeys("41101");
}

public void country(){
	WebElement CountryName=driver.findElement(country);
    Select a=new Select(CountryName);
    a.selectByVisibleText("United States");
}

public void phone(){
	driver.findElement(phone).sendKeys("7507190724");
}

public void submit(){
	driver.findElement(SubmitButton).click();
}

public void sendkeys(By elementname, String value){
	driver.findElement(elementname).sendKeys(value);
}

}



