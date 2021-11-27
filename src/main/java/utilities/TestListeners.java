package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import commons.AbstractTest;
import commons.Constants;

public class TestListeners extends AbstractTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		// Start with a test
		extenttest = extentreport.createTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		// Log to report with a test case successful
		extenttest.log(Status.PASS, Constants.TESTCASE_PASS);
	}
	public void onTestFailure(ITestResult result) {
		// Log to report with a test case failure
		 	try {
		 		String path = TestUtilities.captureScreenshot(result.getName());
				extenttest.log(Status.FAIL, Constants.TESTCASE_FAIL);
				extenttest.addScreenCaptureFromPath(path);
				extenttest.log(Status.INFO, result.getThrowable());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
	public void onFinish(ITestContext context) {
		// flush to report when finish a test.
		extentreport.flush();
	}
}
