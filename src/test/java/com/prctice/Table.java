package com.prctice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("http://rmgtestingserver:8888/index.php?action=Login&module=Users");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//td[@class='tabSelected']/a[text()='Organizations']")).click();
	
	String expOrg = "amazon20";
	boolean counter;
	String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
	String pg = page.split(" ")[1];
	int p = Integer.parseInt(pg);
	for(int i=0;i<p;i++) {
	
	 List<WebElement> listOrg = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
	
	 for(int j=1;j<listOrg.size();j++) {
		 
		 String acOrg = listOrg.get(j).getText();
		 System.out.println(acOrg);
		 if(acOrg.equals(expOrg)) {
			 driver.findElement(By.xpath(""));
			 counter=true;
			 break;
		 }
		 
	 }
		 
	 }
	 
	 
	
	
	
	
	
	
	
	
	
	}

}
