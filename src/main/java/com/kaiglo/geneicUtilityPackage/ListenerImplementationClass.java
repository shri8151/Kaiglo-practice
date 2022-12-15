package com.kaiglo.geneicUtilityPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass   implements ITestListener{
	private ExtentReports report;

	public void onTestStart(ITestResult result) {
		
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test);
	}

	public void onTestSuccess(ITestResult result) {
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+"is passed");
		
	}

	public void onTestFailure(ITestResult result) {
	
		String testName = result.getMethod().getMethodName();
		ThreadSafe.getExtentTest().fail(testName+"is failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable());//get the exception information.
		String screenshot = ThreadSafe.getWebdriverUtility().takeScreenShot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot);
		
	}

      public void onTestSkipped(ITestResult result) {
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+"is failed");
		ThreadSafe.getExtentTest().skip(result.getThrowable());
		String screenshot = ThreadSafe.getWebdriverUtility().takeScreenShot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot);
		
	}
    /**
     * 
     * @param result
     */
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter(IConstantPath.HTML_REPORT);
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows 10");	
		report.setSystemInfo("Browser Name", "chrome"); 
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("reporter name", "shri");
	
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	
}
