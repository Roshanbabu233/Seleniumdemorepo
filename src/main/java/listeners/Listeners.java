package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	ExtentReports extentReporter = ExtentReporter.getExtentReport();
	ExtentTest extenttest ;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		extentTestThread.set(extenttest);
	String testName = result.getName();
	
 extenttest = extentReporter.createTest(testName+"test started guru");
 extentTestThread.set(extenttest);
 
 
	
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTestThread.get().log(Status.PASS,"Test Passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver d = null;
		
		
		
	String testMethodName = result.getName();
	extentTestThread.get().fail(result.getThrowable());

	try {
		d=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
	}catch (Exception e)
	{
		e.printStackTrace();
	}
		try {
			String screenshotFilePath = takeScreenshot(testMethodName, d);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReporter.flush();
		
	}
	
	
	
	
	

}
