package WebDriverFactory;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

private static WebDriver driver=null;	
public static WebDriver GetDriverForBrowser(String browser) throws Exception{
	switch(browser.toLowerCase()){
	case"chrome":
		driver=new ChromeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
	default: throw new Exception("incorrect browser sent" + browser);
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}

public static String BrowserName(){
	String DefaultBrowser="chrome";
	String BrowserSentCmd=System.getProperty("browser");
	if(BrowserSentCmd==null){
		return DefaultBrowser;
		}
	else{
		return BrowserSentCmd;
	}
}

}
