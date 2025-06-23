package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signinPage extends BasePage {

	WebDriver driver;
	
	public signinPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator
	@FindBy(name="username")
	WebElement txtUserid;

	@FindBy(name="password")
	WebElement txtPassword1;
	
	@FindBy(xpath="//input[@name='signon']")
	WebElement btnSignon;
	
	
	@FindBy(xpath="//a[normalize-space()='Sign Out']")
	WebElement btnSignout;
	
	
	

	//Action Method
	
	public void SetUsername(String uname)
	{
		txtUserid.sendKeys(uname);
	}

	public void SetPassword(String pwd1)
	{
		txtPassword1.clear();
    	txtPassword1.sendKeys(pwd1);
	
	}
	
	public void Signon()
	{
		btnSignon.click();

	}
	public void Signout()
	{
		btnSignout.click();

	}
			
}
