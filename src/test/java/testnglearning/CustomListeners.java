package testnglearning;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {

		/*System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a target=\"_blank\" href=\"F:\\screenshot\\error.jpg\">Screenshot Captured</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"F:\\screenshot\\error.jpg\"><img src=\"f:\\screenshot\\error.jpg\" height=200 width=200></a>");
	
		*/
	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Test Case : "+result.getMethod().getMethodName()+"---"+result.getThrowable().getMessage());
		Reporter.log("<a target=\"_blank\" href=\"G:\\error.jpg\">Screenshot Captured</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"G:\\error.jpg\"><img src=\"G:\\error.jpg\" height=200 width=200></a>");
		
		
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
		// TODO Auto-generated method stub
		
	}

}
