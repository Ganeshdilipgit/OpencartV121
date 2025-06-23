package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test
	public void verify_account_registration()
	{
        logger.info("******************Starting TC001_AccountRegistrationTest************************** ");
     try 
      {
        	
  
		HomePage hp = new HomePage(driver);
		
		hp.clickMyaccount();
		logger.info("Clicked on My Account");
		hp.clickRegister();
		logger.info("Clicked on My Register");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		String pasw = RandomAlphanumber();
		logger.info("Providing customer details.........");
		regpage.SetUsername(RandomAlphanumber());
		regpage.setPassword(pasw);
		regpage.setRPassword(pasw);
		regpage.SetFirstName("Ganesh");
		regpage.SetLastName("Dilip Kumar");
		regpage.SetEmail(RandomAlphanumber());
		
		regpage.SetPhone(RandomNumber());
		regpage.SetAdd1("zxy");
		regpage.SetAdd2("zxya");
		regpage.SetCity("Leon");
		regpage.SetState("GTO");
		regpage.SetCountry("Mexico");
		regpage.SetZip("3333");
		
		
		
		regpage.clickContinue();
		logger.info("Clicked on Continue..");
		//regpage.clicksignout();
		//logger.info("Clicked on logout..");
		AssertJUnit.assertTrue(true);
		
      }
      catch(Exception e)
     {
    	  logger.error("Test Failed...");
    	  logger.debug("Test Failed...");
    	  AssertJUnit.assertTrue(false);
    	 
     }
     
     logger.info("******************Finished TC001_AccountRegistrationTest************************** ");
	}

}
