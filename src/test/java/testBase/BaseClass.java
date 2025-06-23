package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	String user = Randomstring();
	String pass =RandomAlphanumber();
	
	
	@BeforeClass
    @Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//Configuration file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap= new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No matching os found");
			}
			
			switch(br.toLowerCase())
			{
				case "chrome": cap.setBrowserName("chrome"); break;
				case "edge"  : cap.setBrowserName("MicrosoftEdge");  break;
				case "firefox"  : cap.setBrowserName("firefox");  break;
				default      : System.out.println("Invalid Brower"); return;
				
			}
			driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), cap);
		}


		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		
		switch(br.toLowerCase())
		{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge"  : driver=new EdgeDriver();   break;
			case "safari": driver=new SafariDriver(); break;
			default      : System.out.println("Invalid Brower"); return;
			
		}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url1"));
		driver.manage().window().maximize();
        


		
		
	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

	public String Randomstring()
	{

	
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		return generatestring;
		
	}
	
	public String RandomNumber()
	{

		String generatenumber = RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String RandomAlphanumber()
	{
	
		String generatestring = RandomStringUtils.randomAlphabetic(5);
		String generatenumber = RandomStringUtils.randomNumeric(10);
		return (generatestring+"@"+generatenumber);
	}
}
