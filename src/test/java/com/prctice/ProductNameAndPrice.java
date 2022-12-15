package com.prctice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ProductNameAndPrice {

	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='MIXNux']/following-sibling::div//div[@class='_4rR01T']"));
        
       List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='MIXNux']/following-sibling::div//div/following-sibling::div//div[@class='_30jeq3 _1_WHN1']"));
       for(int i=0;i<productName.size();i++) {
    	  String pp = productPrice.get(i).getText();
    	 String pn = productName.get(i).getText();
    	 System.out.println(pn+"------------->"+pp);
       }
	}

}
