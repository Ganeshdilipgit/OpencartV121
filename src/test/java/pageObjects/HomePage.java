package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
//Locator
	
@FindBy(xpath="//a[normalize-space()='Sign In']")
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register Now!']")
WebElement lnkRegister;


public void clickMyaccount()
{
	lnkMyaccount.click();
}


public void clickRegister()
{
	lnkRegister.click();
}
	

}
