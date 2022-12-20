package com.kaiglo.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.BaseClass;
import com.kaiglo.geneicUtilityPackage.FileUtility;
import com.kaiglo.geneicUtilityPackage.IConstantPath;
import com.kaiglo.geneicUtilityPackage.JavaUtility;
import com.kaiglo.geneicUtilityPackage.PropetyFileKeys;
import com.kaiglo.geneicUtilityPackage.WebdriverUtility;
import com.kaiglo.pom.CommonPage;
import com.kaiglo.pom.LoginPage;
import com.kaiglo.pom.MyAccountPage;
import com.kaiglo.pom.ProductCategoryPage;


@Listeners(com.kaiglo.geneicUtilityPackage.ListenerImplementationClass.class)
public class Add_Product_To_Cart_Test extends BaseClass {

	   @Test
	   public void addProducttest() {


		commonPage.clickHomeTab();
         //Verify home page is displayed 
        MyAccountPage ma=new MyAccountPage(driver);
		String expectedText = "Welcome -shri";
		String actualText = ma.getTextFromUserIcon();
		
		if(actualText.equals(expectedText))
		System.out.println("User Home page is displayed");
        //Search the product
		commonPage.clickOnFtTab();
		//add product to the cart by clicking on Add to cart button
		String expectedlProducttName = driver.findElement(By.xpath("//a[text()='T SHIRT 90']")).getText();
		ProductCategoryPage pc=new ProductCategoryPage(driver);
		pc.clickOnAddToCartButton();
		//handling pop up.
		webDriverUtiity.handlingAlertPopup();
        //Verify the product is present in the cart.
        commonPage.clickOnBasketTab();
        commonPage.clickOnMyCartLink();
		String  cart = driver.findElement(By.xpath("//li[@class='active']")).getText();
	    if(cart.equals("Shopping Cart")) 
		{
            List<WebElement> actualProductNames = driver.findElements(By.xpath("//h4[@class='cart-product-description']/a[text()='T SHIRT 90']"));
		    for(WebElement acd:actualProductNames) {
		    String	actualProductName=acd.getText();
		    Assert.assertEquals(actualProductName, expectedlProducttName);
		    System.out.println(actualProductName +"---->is present in  the cart");
					System.out.println("Test case is pass");
					break;
				 }
		}
			
			webDriverUtiity.takeScreenshot("product not added");
				   
			
		
          
	   }
	}
	  


