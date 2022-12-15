package com.kaiglo.Framework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.BaseClass;
import com.kaiglo.pom.LoginPage;

@Listeners(com.kaiglo.geneicUtilityPackage.ListenerImplementationClass.class)
public class LoginTest extends BaseClass{

    @Test
	public void checkLoginTest() 
 {
		//click on login link
    	commonPage.clickOnLogoutLink();
    	commonPage.clickOnloginLink();
		
		//verify create account page is displayed.
		String text = driver.findElement(By.xpath("//h4[text()='create a new account']")).getText();
		if(text.contains("CREATE ACCOUNT"))
		System.out.println("create account page displyed");
		//fill the necessary details to create account and sign up.
	    LoginPage l=new LoginPage(driver);
	    String newEmail = excelUtiity.getExcelData("CustomerDetails", 7, 1);
	    String newPwd = excelUtiity.getExcelData("CustomerDetails", 9, 1);
	    int ran = javaUtiity.getRandomNumber(100);
	    l.enterFullName(excelUtiity.getExcelData("CustomerDetails", 6, 1));
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    l.enterNewEmail(ran+newEmail);
	    l.enterContactNo(excelUtiity.getExcelData("CustomerDetails", 8, 1));
	    l.enterNewPassword(newPwd);
	    l.enterConfirmPwd(newPwd);
	    l.clickSubmit();
	    webDriverUtiity.handlingAlertPopup();
	    
	    //try to login with new email and password
	    l.loginToTheApplication(ran+newEmail, newPwd);
	    //verify user can able to login
	    String expectedText = "Welcome -ramesh";
		String actualText = driver.findElement(By.xpath("//a[text()='Welcome -ramesh']")).getText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println("User is able to login");
		
		
		
		}
}



	
