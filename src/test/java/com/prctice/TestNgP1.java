package com.prctice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.kaiglo.geneicUtilityPackage.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class TestNgP1 {
	
	@Test
	public void testing() {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/index.php");
	}
   @Parameters("browser")
   @Test
	public void testing2() {
		WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/index.php");
	}

	@Test
	public void testing3() {
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/index.php");
		driver.quit();
	}
	 @Parameters({"browser","url"})
	@Test
	public void testing4(String browser, String url) {
		WebdriverUtility w=new WebdriverUtility();
		w.launchApplication(browser, 10, url);
	}
    @Parameters({"browser","url"})
	@Test
	public void testing5(String browser, String url) {
		WebdriverUtility w=new WebdriverUtility();
		w.launchApplication(browser, 10, url);
	}
}
