package Pages.com;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonlib.Browser;
import commonlib.Utility;

public class nopCommerceLogin extends Utility{
//Utilization
	public void EnterUsername(String usn) {
		Username.sendKeys(usn);
	}

	public void EnterPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void ClickLoginBtn() {
		LoginBtn.click();
	}
	

	
	public WebElement getUsername()
	{
		return Username;
	}
	public WebElement getPassword()
	{
		return Password;
	}
	
	public nopCommerceLogin(WebDriver driver)
	{
		Browser.driver=driver;
		PageFactory.initElements(Browser.driver, this);
	}

	//Declaration
	@FindBy(id="Email")
	private WebElement Username;
	
	@FindBy(id="Password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	private WebElement LoginBtn;
}
