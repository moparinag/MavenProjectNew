package Pages.com;

import java.util.Iterator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonlib.Browser;
import commonlib.Utility;

public class NopECommerceCreateNewCustomerPage extends Utility
{

@FindBy(xpath="//button[@name='save']")
private WebElement SaveCustomerBtn;


@FindBy(xpath="//button[@name='save-continue']")
private WebElement SaveAndContinueBtn;


@FindBy(id="Email")
private WebElement EmailTxtBox;

@FindBy(id="Password")
private WebElement PasswordTxtBox;

@FindBy(id="FirstName")
private WebElement FirstNameTxtBox;

@FindBy(id="LastName")
private WebElement LastNameTxtBox;

@FindBy(id="Gender_Male")
private WebElement MaleRadioBtn;

@FindBy(id="Gender_Female")
private WebElement FemaleRadioBtn;

@FindBy(id="DateOfBirth")
private WebElement DOBTxtBox;

@FindBy(id="Company")
private WebElement CompanyTxtBox;

@FindBy(id="IsTaxExempt")
private WebElement IsTaxExemptCheckBox;

@FindBy(xpath ="//label[text()='Newsletter']/../../../div[2]")
private WebElement NewsLetterTxtBox;

@FindBys({
	@FindBy(xpath="//ul[@id='SelectedNewsletterSubscriptionStoreIds_listbox']//li[@class='k-item']")})
private List<WebElement> NewsLetterOptionsList;


@FindBy(xpath="//label[text()='Customer roles']/../../../div[2]")
private WebElement CustomerRolesTextBox;

@FindBys({
	@FindBy(xpath="//ul[@id='SelectedCustomerRoleIds_listbox']//li[@class='k-item']")})
private List<WebElement> CustomerRolesOptionsList;

@FindBy(id="VendorId")
private WebElement ManagerOfVendorDropDown;

@FindBys({
	@FindBy(xpath="//select[@id='VendorId']//option")})
private List<WebElement> VendorOptionsList;


@FindBy(xpath="//label[text()='Active']/../../../div[2]")
private WebElement ActiveCheckBox;

@FindBy(id="AdminComment")
private WebElement AdminCommentTextBox;

public NopECommerceCreateNewCustomerPage(WebDriver driver)
{Browser.driver=driver;
PageFactory.initElements(Browser.driver, this);
}
public void clickSaveCustomerBtn() {
	SaveCustomerBtn.click();
}

public void clickSaveAndContinueBtn() {
	SaveAndContinueBtn.click();;
}

public void setEmailTxtBox(String emailTxtBox) {
	EmailTxtBox.sendKeys(emailTxtBox);
}
public void setPasswordTxtBox(String passwordTxtBox) {
	PasswordTxtBox.sendKeys(passwordTxtBox);;
}

public void setFirstNameTxtBox(String firstNameTxtBox) {
	FirstNameTxtBox.sendKeys(firstNameTxtBox);
}

public void setLastNameTxtBox(String lastNameTxtBox) {
	LastNameTxtBox.sendKeys(lastNameTxtBox);
}

public void ClickMaleRadioBtn() {
	MaleRadioBtn.click();
}

public void ClickFemaleRadioBtn() {
	FemaleRadioBtn.click();
}

public void setDOBTxtBox(String dOBTxtBox) {
	DOBTxtBox.sendKeys(dOBTxtBox);
}

public void setCompanyTxtBox(String companyTxtBox) {
	CompanyTxtBox.sendKeys(companyTxtBox);
}

public void clickIsTaxExemptCheckBox() {
	IsTaxExemptCheckBox.click();
}

public void ClickNewsLetterTxtBox() {
	NewsLetterTxtBox.click();
}

public void clickNewsLetterOptionsList(String option) {
	Iterator itr = NewsLetterOptionsList.iterator();
	while(itr.hasNext())
	{
	WebElement value = (WebElement) itr.next();
	String Actualvalue = value.toString();
	if(Actualvalue.equals(option))
	{
		value.click();
	}
	}
	
}

public void ClickCustomerRolesTextBox() {
	CustomerRolesTextBox.click();
}

public void clickCustomerRolesOptionsList(String option) {
	Actions action=new Actions(Browser.driver);
	Iterator itr = CustomerRolesOptionsList.iterator();
	while(itr.hasNext())
	{
	WebElement value = (WebElement) itr.next();
	String Actualvalue = value.toString();
	if(Actualvalue.equals(option))
	{
		action.click(value);
	}
	}
	
}

public void ClickManagerOfVendorDropDown() {
	ManagerOfVendorDropDown.click();
}

public void clickVendorOptionsList(String option) {
	Actions action=new Actions(Browser.driver);
	Iterator itr = VendorOptionsList.iterator();
	while(itr.hasNext())
	{
	WebElement value = (WebElement) itr.next();
	String Actualvalue = value.toString();
	if(Actualvalue.equals(option))
	{
		action.click(value);
	}
	}
	
}

public void ClickActiveCheckBox() {
	ActiveCheckBox.click();;
}

public void setAdminCommentTextBox(String adminCommentTextBox) {
	AdminCommentTextBox.sendKeys(adminCommentTextBox);;
}
}
