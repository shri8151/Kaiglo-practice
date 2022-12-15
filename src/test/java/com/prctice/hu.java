package com.prctice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hu {

	public static void main(String[] args) {

		String a="ramesh";
	    String   b  ="678";
	    String   c  ="hjak";
	    String   d  ="467";
	    
		
			List<String>adress=new ArrayList<String>();
			adress.add("ramesh");
			adress.add("678");
			adress.add("hjak");
			adress.add("467");
		   
	for(String list:adress) {
		if(a.equals(list)||b.equals(list)||c.equals(list)||d.equals(list)) {
			System.out.println("good");
		}
		else
			System.out.println("hjsk");
	}
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);    
	
	
}
}
