package com.prctice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchproductPrice {
	
	public static void main(String[]arg) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=vivo&ref=nb_sb_noss");
		driver.manage().window().maximize();
		List<String> productList=new ArrayList<String>();
		productList.add("Vivo Y01 (Elegant Black, 2GB RAM, 32GB ROM) with No Cost EMI/Additional Exchange Offers");
		productList.add("Vivo Y21 (Diamond Glow, 4GB RAM, 64GB Storage) Without Offers");
		productList.add("vivo Y16 (Drizzling Gold, 3GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers");
		for(String productName:productList) {
		 String price = driver.findElement(By.xpath("//span[text()='"+productName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole']")).getText();
		System.out.println(price);
	}
	}
 
}
