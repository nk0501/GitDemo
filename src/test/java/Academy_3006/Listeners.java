package Academy_3006;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener{
	
	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // for parallel execution .
	public void onTestStart(ITestResult result) {
	 test = extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
	 
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			// this step is required to get access of the fields of t class inside  which the methods fails.
			//getRealClass() -- access given to the instance of the test class
			
		    } 
		catch(Exception e)
		{
			
		}
		
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver),  result.getMethod().getMethodName());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
