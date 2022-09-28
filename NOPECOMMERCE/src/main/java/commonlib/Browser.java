package commonlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
public static	WebDriver driver;

public static void getBrowser()
{
	if(ProjectConstants.browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VEGI\\MavenProjectNew\\NOPECOMMERCE\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}else if(ProjectConstants.browser.equals("Firefox")){
		System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\VEGI\\MavenProjectNew\\NOPECOMMERCE\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
}
}
