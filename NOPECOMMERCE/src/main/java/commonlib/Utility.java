package commonlib;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	
public void NormalWait(long duration)
{
	try {
		Thread.sleep(duration);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void pageLoadWait(long duration)
{
	Browser.driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

public void waitForElementPresent(long duration,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(Browser.driver, duration);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void alertAccept()
{
	Alert alert = Browser.driver.switchTo().alert();
	alert.accept();
}
public void alertDismiss()
{
	Alert alert=Browser.driver.switchTo().alert();
	alert.dismiss();
}
public void alertSendKeys(String data)
{
	Alert alert=Browser.driver.switchTo().alert();
	alert.sendKeys(data);
}
public void frameHandleIndex(int index)
{
	Browser.driver.switchTo().frame(index);
}
public void frameHandleString(String value)
{
	Browser.driver.switchTo().frame(value);
}
public void frameHandleWebElement(WebElement Element)
{
	Browser.driver.switchTo().frame(Element);
}
public void frameSwitchtoParent()
{
	Browser.driver.switchTo().parentFrame();
}
public Boolean verifyText(String Expected,WebElement Element)
{
	Boolean status=false;
	String Actual = Element.getText();
	if(Actual.equals(Expected))
	{
		status=true;
		System.out.println("Test Passed");
	}else
	{
		System.out.println("Test Failed");
	}
return status;
}
}
