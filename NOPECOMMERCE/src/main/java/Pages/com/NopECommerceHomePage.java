package Pages.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonlib.Browser;
import commonlib.Utility;

public class NopECommerceHomePage extends Utility
{
@FindBy(linkText="Logout")
private WebElement LogoutBtn;

@FindBy(xpath="//i[@class='nav-icon far fa-user']/..")
private WebElement CustomersMenu;

@FindBy(xpath="//p[text()=' Dashboard']/..")
private WebElement DashBoardOption;

@FindBy(xpath="//i[@class='nav-icon fas fa-shopping-cart']/..")
private WebElement SalesOption;

@FindBy(xpath="//p[text()=' Orders']")
private WebElement OrdersOption;

@FindBy(xpath="//input[@placeholder='Search']")
private WebElement SearchTxtBox;

@FindBy(xpath="//p[text()=' Customers']")
private WebElement CustomersOption;

public NopECommerceHomePage(WebDriver driver)
{
	Browser.driver=driver;
	PageFactory.initElements(Browser.driver, this);
	Browser.driver=driver;
	PageFactory.initElements(Browser.driver, this);}
public void ClickLogoutBtn() {
	LogoutBtn.click();
}

public void ClickCustomersMenu() {
	CustomersMenu.click();;
}


public void ClickDashBoardOption() {
	DashBoardOption.click();;
}

public void clickSalesOption() {
	SalesOption.click();;
}

public void ClickOrdersOption() {
	OrdersOption.click();;
}

public void ClickSearchTxtBox() {
	SearchTxtBox.click();;
}

public void setSearchTxtBox(String searchTxtBox) {
	SearchTxtBox.sendKeys(searchTxtBox);;
}

public void ClickCustomersOption() {
	CustomersOption.click();;
}

}
