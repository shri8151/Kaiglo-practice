package com.prctice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.kaiglo.geneicUtilityPackage.IConstantPath;

public class ExtentReportPractice {

	public static void main(String[]arg) {
		ExtentSparkReporter spark=new ExtentSparkReporter(IConstantPath.HTML_REPORT);
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "windows 10");	
		report.setSystemInfo("Browser Name", "chrome");
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("reporter name", "shri");
		
		
	    ExtentTest test1 = report.createTest("test1");
	    test1.info("This nformation coming from script");
	    test1.warning("warning message");
	    test1.fail("test fail");
	    
	    ExtentTest test2 = report.createTest("test2");
	    test2.info("This nformation coming from script");
	    test2.pass("test2 pass");
	    
	    ExtentTest test3 = report.createTest("test3");
	    test3.info("This nformation coming from script");
	    test3.fail("test3 is failed");
	    
	    report.flush();
	    
	    
	 	}
		
}
