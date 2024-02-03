package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation  implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
	   System.out.println("Suite Execution Starts");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	     System.out.println(result.getMethod().getMethodName()+"Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
         System.out.println(result.getMethod().getMethodName()+"Fail");
         System.out.println("Failed dut to:"+result.getThrowable());
         WebDriverUtility web = new WebDriverUtility();
         web.captureScreenshot(BaseClass.sdriver, BaseClass.sjutil , result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+"Skipped");
        System.out.println("Skipped dut to:"+result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
	   System.out.println("Suite Execution Terminates");
	}

	
	
    
	

}
