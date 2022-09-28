package Pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonlib.Browser;
import commonlib.Utility;

public class NopEcommerceCustomersPage extends commonlib.Utility{
	
@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
private WebElement AddNewCustomerBtn;

@FindBy(xpath="//button[@class='btn btn-success']")
private WebElement ExportBtn;


@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
private WebElement SuccessMsg;

public NopEcommerceCustomersPage(WebDriver driver)
{
	Browser.driver=driver;
	PageFactory.initElements(Browser.driver, this);
	}

public	void ClickAddNewCustomerBtn() {
	AddNewCustomerBtn.click();;
}


public void ClickExportBtn() {
	ExportBtn.click();
}


public String ActualSuccessMsg() {
	
	return SuccessMsg.getText();
}

}
