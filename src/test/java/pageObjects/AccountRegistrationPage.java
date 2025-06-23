package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//locator
	



@FindBy(name="username")
WebElement txtUserid;

@FindBy(xpath="//input[@name='password']")
WebElement txtPassword;

@FindBy(xpath="//input[@name='repeatedPassword']")
WebElement txtRPassword;


@FindBy(xpath="//input[@name='account.firstName']")
WebElement txtFirstname;


@FindBy(xpath="//input[@name='account.lastName']")
WebElement txtLastname;

@FindBy(xpath="//input[@name='account.email']")
WebElement txtEmail;

@FindBy(xpath="//input[@name='account.phone']")
WebElement txtphone;

@FindBy(xpath="//input[@name='account.address1']")
WebElement txtAdd1;

@FindBy(xpath="//input[@name='account.address2']")
WebElement txtAdd2;

@FindBy(xpath="//input[@name='account.city']")
WebElement txtCity;

@FindBy(xpath="//input[@name='account.state']")
WebElement txtState;

@FindBy(xpath="//input[@name='account.zip']")
WebElement txtZip;


@FindBy(xpath="//input[@name='account.country']")
WebElement txtCountry;

@FindBy(xpath="//a[normalize-space()='Sign Out']")
WebElement btnsignout;







@FindBy(xpath="//input[@name='newAccount']")
WebElement btnContinue;



//Action method

public void SetUsername(String uname)
{
	txtUserid.sendKeys(uname);
}

public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
	
}

public void setRPassword(String rpwd)
{
	txtRPassword.sendKeys(rpwd);
	
}


public void SetFirstName(String fname)
{
	txtFirstname.sendKeys(fname);
}

public void SetLastName(String lname)
{
	txtLastname.sendKeys(lname);
	
}


public void SetEmail(String email)
{
	txtEmail.sendKeys(email);
	
}

public void SetPhone(String phone)
{
	txtphone.sendKeys(phone);
	
}

public void SetAdd1(String add1)
{
	txtAdd1.sendKeys(add1);
	
}

public void SetAdd2(String add2)
{
	txtAdd2.sendKeys(add2);
	
}


public void SetCity(String city)
{
	txtCity.sendKeys(city);
	
}

public void SetState(String State)
{
	txtState.sendKeys(State);
	
}

public void SetZip(String zip)
{
	txtZip.sendKeys(zip);
	
}

public void SetCountry(String country)
{
	txtCountry.sendKeys(country);
	
}







public void clickContinue()
{
	btnContinue.click();
	
}

public void clicksignout()
{
	btnsignout.click();
	
}



}

