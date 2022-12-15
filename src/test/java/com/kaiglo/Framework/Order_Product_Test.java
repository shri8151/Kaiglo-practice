package com.kaiglo.Framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.BaseClass;
import com.kaiglo.geneicUtilityPackage.ExcelUtility;
import com.kaiglo.geneicUtilityPackage.FileUtility;
import com.kaiglo.geneicUtilityPackage.IConstantPath;
import com.kaiglo.geneicUtilityPackage.JavaUtility;
import com.kaiglo.geneicUtilityPackage.PropetyFileKeys;
import com.kaiglo.geneicUtilityPackage.WebdriverUtility;
import com.kaiglo.pom.CommonPage;
import com.kaiglo.pom.MyAccountPage;
import com.kaiglo.pom.MyCartPage;
import com.kaiglo.pom.PaymentMethodPage;
import com.kaiglo.pom.ProductCategoryPage;

public class  Order_Product_Test extends BaseClass {
    @Test
	public  void orderProductTest() throws IOException {

        //search the product and add product to the cart
    	commonPage.clickOnFtTab();    
        String expectedlProductName = driver.findElement(By.xpath("//a[text()='T SHIRT 90']")).getText();
        ProductCategoryPage pc=new ProductCategoryPage(driver);
        pc.clickOnAddToCartButton();
		System.out.println(expectedlProductName+"----->product is added to cart");
		webDriverUtiity.handlingAlertPopup();
		
		//navigate to the my cart
	    commonPage.clickOnBasketTab();
	    commonPage.clickOnMyCartLink();
        
		//click on the check box for the product which has to be ordered and proceed to checkout
        MyCartPage m=new MyCartPage(driver);
        m.selectCheckBox();
        m.clickOnProceedToCheckOut();
		
		//select payment option radio button and click on submit.
         PaymentMethodPage pm=new PaymentMethodPage(driver);
         pm.selectCOD();
		 //goto my account and check order history.
        commonPage.clickOnMyAccountTab();
        MyAccountPage ma=new MyAccountPage(driver);
        ma.clickOnOrderHistory();
		
	    //fetching list of product names in order list.
	    List<WebElement> actualproductNames = driver.findElements(By.xpath("//th[text()='Product Name']/../../..//td[contains(text(),'2022-11-23 15:47:57  ')]/..//td[@class='cart-product-name-info']"));
	    String  actualTimeAndDate=driver.findElement(By.xpath("//th[text()='Product Name']/../../../tbody//td[text()='2022-11-23 15:47:57  ']")).getText();
		System.out.println("Order Date :"+actualTimeAndDate);
		String paymentMode = driver.findElement(By.xpath("//th[text()='Product Name']/../../..//td[contains(text(),'2022-11-23 15:47:57  ')]/..//td[text()='COD  ']")).getText();
	    System.out.println("payment mode is :"+paymentMode);
		
	     //verify the product is ordered.
	    for(WebElement acd:actualproductNames) {
		String	actualProductName=acd.getText();
		 
		if(actualProductName.equals(expectedlProductName)) {
		System.out.println("T SHIRT 90 product has been ordered--->test case pass");
		excelUtiity.writeToExcel("CustomerDetails", 4, 12, "TestCase Pass");
		break;	
	    }
		else {
			System.out.println("product is not ordered test case fail");
			webDriverUtiity.takeScreenshot("order not placed");
		      }
		 }
        
}
}
