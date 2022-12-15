package com.kaiglo.geneicUtilityPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.kaiglo.pom.CommonPage;
import com.kaiglo.pom.LoginPage;
/**
 * this class contains all the configuration methods of testng
 * @author Srikanth
 *
 */
public class BaseClass {
	
	/**
	 * create object for generic utility
	 * read data from property file
	 * open excel file
	 * launch browser application and set up browser
	 * create object for common pom class
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	protected ExcelUtility excelUtiity;
	protected FileUtility fileUtiity;
	protected JavaUtility javaUtiity;
	protected WebdriverUtility webDriverUtiity;
	protected WebDriver driver;
	protected LoginPage login;
	protected CommonPage commonPage;
	
	
	@BeforeClass
	public void classetup() {
		//create object for generic utility.
	     fileUtiity=new FileUtility();
		 javaUtiity=new  JavaUtility();
		 excelUtiity=new ExcelUtility();
		 webDriverUtiity=new WebdriverUtility();
		
		//read data from property file.
		 fileUtiity.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		 String browser = fileUtiity.getDataFromPropertyFile(PropetyFileKeys.BROWSER.convertToString());
		 String url = fileUtiity.getDataFromPropertyFile(PropetyFileKeys.URL.convertToString());
		 String timeout = fileUtiity.getDataFromPropertyFile(PropetyFileKeys.TIMEOUT.convertToString());
		 Long tm = (Long) javaUtiity.stringToAnyDataType(timeout, "long");
		 
		 //open excel file.
		 excelUtiity.openExelFile();
		 
		 //Launch browser,application and set up browser
		 ThreadSafe.setWebdriverUtility(webDriverUtiity);
		  driver=webDriverUtiity.launchApplication(browser, tm, url);
		 
		 //Create object for common pom class
		  login=new LoginPage(driver);
		  commonPage=new CommonPage(driver);
	}
	/*
	 * this method is used login to the application.
	 */
	@BeforeMethod
	public void methodLogin() {
		commonPage.clickOnloginLink();
		String userName =fileUtiity .getDataFromPropertyFile(PropetyFileKeys.USERNAME.convertToString());
		String password =fileUtiity .getDataFromPropertyFile(PropetyFileKeys.PASSWORD.convertToString());
		login.loginToTheApplication(userName, password);
	}
	/*
	 * this method is used logout from the application.
	 */
	@AfterMethod
	public void methodLogout() {
		commonPage.clickOnLogoutLink();	
	}
	/*
	 * This method used to close browser,excel and property file,
	 */
	@AfterClass
	public void classTearDown() {
		excelUtiity.closeExelFile();
		fileUtiity.closePropertyFile();
		webDriverUtiity.closeBrowser();
	}
	
	

}
