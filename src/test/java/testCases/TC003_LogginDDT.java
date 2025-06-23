package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.signinPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LogginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDD(String username, String password, String res)
	{
		logger.info("******************Starting verify_loginDD************************** ");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			
			logger.info("Clicked on My Account");
			signinPage sg = new signinPage(driver);
		
			sg.SetUsername(username);
			sg.SetPassword(password);
			sg.Signon();
			
			if(res.equalsIgnoreCase("Valid"))
			{
				sg.Signout();
				Assert.assertTrue(true);
			
			}
			else
			{
				Assert.assertFalse(false);
			}
			
			if(res.equalsIgnoreCase("Invalid"))
			{
				sg.Signout();
				Assert.assertTrue(false);
			
			}
			else
			{
				Assert.assertFalse(true);
			}
		
			logger.info("******************Finished Terify_loginDD************************** ");
		}
		
		catch(Exception e)
		{
			Assert.assertFalse(false);
		}

	
		
		
	}

	

}
