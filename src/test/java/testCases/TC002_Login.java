package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.signinPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {
	

	
	@Test
	public void login()
	{
		logger.info("******************Starting TC002_Login.java************************** ");
		try
		{
			
		
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on My Account");
		signinPage sg = new signinPage(driver);
		sg.SetUsername(p.getProperty("username"));
		sg.SetPassword(p.getProperty("password"));
		sg.Signon();
		sg.Signout();
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
	    	  logger.error("Test Failed...");
	    	  logger.debug("Test Failed...");
	    	  Assert.assertTrue(false);
	         
		}
		
		logger.info("******************Finished TC002_Login.java************************** ");
		
	}


	
}
