package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class Mylistener extends BaseClass implements ITestListener
{
    public ExtentSparkReporter sparkReporter;  //UI of the report
    public ExtentReports extent; //populate common info on the report 
    public ExtentTest test; // creating test case entries in the report and update status of the test methods
    String reportrandomname =  Randomstring()+".html";

	   public void onFinish(ITestContext context) {
		   extent.flush();
		   
		    System.out.println(" onFinish");
		  }
	  
	   public void onStart(ITestContext context) 
	   {
		   
		   sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+reportrandomname);
		   sparkReporter.config().setDocumentTitle("Automation Report"); //Title of report
		   sparkReporter.config().setReportName("Functional Testing"); // Name of the report
		   sparkReporter.config().setTheme(Theme.DARK);
		   
		   extent=new ExtentReports();
		   extent.attachReporter(sparkReporter);
		   
		   extent.setSystemInfo("Computer Name", "Localhost");
		   extent.setSystemInfo("Environment", "QA");
		   extent.setSystemInfo("Tester Name", "Ganesh Dilip Kumar");
		   extent.setSystemInfo("OS", "MAC");
		   extent.setSystemInfo("Browers name", "Chrome");
		  
		  }
	   
	   public void onTestSkipped(ITestResult result) {
			  test= extent.createTest(result.getName());
			  test.log(Status.SKIP, "Test case Skipped is :"+ result.getName());
		  }
	   public void onTestFailure(ITestResult result) {
			  test= extent.createTest(result.getName());
			  test.log(Status.FAIL, "Test case Failed is :"+ result.getName());
			  test.log(Status.FAIL, "Test case Failed cause is :"+ result.getThrowable());
		  }

	   public void onTestSuccess(ITestResult result) {
		  test= extent.createTest(result.getName());
		  test.log(Status.PASS, "Test case PASSED is :"+ result.getName());
		  
		  }
	   
	   
	   public void onTestStart(ITestResult result) {
		   System.out.println(" onTestStart");
		  }
}
