package TestngTestScriptNop;

import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.com.NopECommerceCreateNewCustomerPage;
import Pages.com.NopECommerceHomePage;
import Pages.com.NopEcommerceCustomersPage;
import Pages.com.nopCommerceLogin;
import commonlib.Browser;
import commonlib.ExcelLibraries;
import commonlib.ProjectConstants;
import commonlib.Utility;

public class NOPLoginTest {
	
	nopCommerceLogin LoginPage;
	ExcelLibraries excel=new ExcelLibraries();
	NopECommerceCreateNewCustomerPage createCustomerPage;
	NopEcommerceCustomersPage CustomerPage;
	NopECommerceHomePage HomePage;
	Utility util;
	
@BeforeClass
public void LaunchBrowser()
{
	Browser.getBrowser();
	Browser.driver.get(ProjectConstants.url);
	Browser.driver.manage().window().maximize();
	LoginPage = new nopCommerceLogin(Browser.driver);
	createCustomerPage=new NopECommerceCreateNewCustomerPage(Browser.driver);
	HomePage=new NopECommerceHomePage(Browser.driver);
	CustomerPage=new NopEcommerceCustomersPage(Browser.driver);
	util=new Utility();
	}
@BeforeMethod
public void LoginNopECommerce()
{
	LoginPage.getUsername().clear();
	LoginPage.getPassword().clear();
	LoginPage.EnterUsername(ProjectConstants.Username);
	LoginPage.EnterPassword(ProjectConstants.Password);
	LoginPage.ClickLoginBtn();
}
@Test
public void VerifyTitle() throws InterruptedException, EncryptedDocumentException, IOException
{
	Thread.sleep(3000);
	String Actualtitle = Browser.driver.getTitle();
	System.out.println(Actualtitle);
	Thread.sleep(3000);
	
	String ExpectedTitle = excel.ReadData("Sheet1", 1, 1);
	System.out.println(ExpectedTitle);
	Assert.assertEquals(Actualtitle, ExpectedTitle,"Verify Title failed");
}

@Test
public void CreateNewCustomer() throws EncryptedDocumentException, IOException
{
	util.pageLoadWait(20);
	HomePage.ClickCustomersMenu();
	HomePage.ClickCustomersOption();
	CustomerPage.ClickAddNewCustomerBtn();
	createCustomerPage.setEmailTxtBox(excel.ReadData("Sheet2", 1, 0));
	createCustomerPage.setPasswordTxtBox(excel.ReadData("Sheet2", 1, 1));
	createCustomerPage.setFirstNameTxtBox(excel.ReadData("Sheet2", 1, 2));
	createCustomerPage.setLastNameTxtBox(excel.ReadData("Sheet2", 1, 3));
	createCustomerPage.ClickFemaleRadioBtn();
	createCustomerPage.setDOBTxtBox(excel.ReadData("Sheet2", 1, 4));
	createCustomerPage.setCompanyTxtBox(excel.ReadData("Sheet2", 1, 5));
	createCustomerPage.clickIsTaxExemptCheckBox();
	System.out.println("Enter newsletter");
	createCustomerPage.ClickNewsLetterTxtBox();
	util.NormalWait(1000);
	System.out.println("select new letter");
	createCustomerPage.clickNewsLetterOptionsList(excel.ReadData("Sheet2", 1, 6));
	createCustomerPage.ClickCustomerRolesTextBox();
	util.NormalWait(2000);
	createCustomerPage.clickCustomerRolesOptionsList(excel.ReadData("Sheet2", 1, 7));
	createCustomerPage.ClickManagerOfVendorDropDown();
	util.NormalWait(2000);
	createCustomerPage.clickVendorOptionsList(excel.ReadData("Sheet2", 1, 8));
	createCustomerPage.ClickActiveCheckBox();
	createCustomerPage.setAdminCommentTextBox(excel.ReadData("Sheet2", 1, 9));
	createCustomerPage.clickSaveCustomerBtn();
	util.NormalWait(2000);
	String ActualMsg = CustomerPage.ActualSuccessMsg();
	util.NormalWait(2000);
	String ExpectedMsg=excel.ReadData("Sheet2", 1, 10);
	Assert.assertEquals(ActualMsg, ExpectedMsg,"Customer not created Successfully");
}
@AfterMethod
public void LogoutNopECommerce()
{
	HomePage.ClickLogoutBtn();
}

@AfterClass
public void CloseBrowser()
{
	Browser.driver.close();
}
}
