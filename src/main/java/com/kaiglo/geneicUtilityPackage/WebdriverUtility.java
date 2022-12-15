package com.kaiglo.geneicUtilityPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.kaiglo.pom.CommonPage;
import com.kaiglo.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains common web driver actions
 * @author Srikanth
 *
 */
public class WebdriverUtility {
	WebDriver driver;
	/**
	 * THis method is used for launch the browser based on browser which  has given.
	 * Maximize the browser and give implicitly wait
	 * and launch the application by using url.
	 * @param browser
	 * @param timeout
	 * @param url
	 * @param edriver 
	 * @return 
	 * @return 
	 */
	public WebDriver launchApplication(String browser,long timeout,String url ) 
	{
		
		if(browser.equals("chrome"))
				{
			ChromeOptions option =new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(option);
			 
		        }
		else if(browser.equals("firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		     }
		else if(browser.equals("ie")) {
			
			WebDriverManager.iedriver().setup();
		    driver = new InternetExplorerDriver();
		}
		else
			System.out.println("Plese enter valid browser name");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		driver.get(url);
		return driver;		
		
	  }
  /**
   * This method is used to implement the explicit wait for synchronization.
   * @param driver
   * @param element
   */
	public void initializeExplicitWait(WebDriver driver,WebElement element) {
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will be used to take screenshot.
	 * @param screenshotname
	 * @throws IOException
	 */
	
	public void takeScreenshot(String screenshotname)  {
        String dateTime = new JavaUtility().getDateTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotname+dateTime+".png");
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
	
	
	
	/**
	 * To handle the alert pop up we use this method.
	 */
	public void handlingAlertPopup() {
		driver.switchTo().alert().accept();

	}
	/**
	 * This method o close the browser.
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to take screen shot of web page and stored in local system.
	 * @param testCaseName
	 * @return
	 */
	public String takeScreenShots(String testCaseName) {
	
	String screenShotName = testCaseName+"_"+new JavaUtility().getDateTime();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/"+screenShotName+".png");
	try {
		Files.copy(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return dest.getAbsolutePath();
		
	}
	/**
	 * This method is used to get screenshot.
	 * @return
	 */
	public String takeScreenShot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
	    return ts.getScreenshotAs(OutputType.BASE64);
		
		
		}
			
	}
	
	

	
	


