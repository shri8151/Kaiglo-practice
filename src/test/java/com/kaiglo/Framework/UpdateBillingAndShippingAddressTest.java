package com.kaiglo.Framework;

import org.testng.annotations.Test;

import com.kaiglo.geneicUtilityPackage.BaseClass;
import com.kaiglo.geneicUtilityPackage.PropetyFileKeys;
import com.kaiglo.pom.MyAccountPage;

public class UpdateBillingAndShippingAddressTest extends BaseClass {
    @Test
	public void updateBillingTest()  {
	     //click on my account
    	 commonPage.clickOnMyAccountTab();		
		//click on billing & shipping address
		 MyAccountPage ma=new MyAccountPage(driver);		
		 ma.clickOnShippingAndBillingAdress();
		 
         //Get the customer billing address from the excel.
		 String billingAddress= excelUtiity.getExcelData("CustomerDetails", 2, 4);
		 String billingState= excelUtiity.getExcelData("CustomerDetails", 2, 5);
		 String billingCity= excelUtiity.getExcelData("CustomerDetails", 2, 6);
		 String billingPincode= excelUtiity.getExcelData("CustomerDetails", 2, 7);  
 	   
		 //Enter the billing address
		 ma.enterBillingAddress(billingAddress);
		 ma.enterBillingState(billingState);
		 ma.enterBillingCity(billingCity);
         ma.enterBillingPincode(billingPincode);
         ma.clickOnSubmitButton();
         webDriverUtiity.handlingAlertPopup();
         //logout the application.
         commonPage.clickOnLogoutLink();
         //again login the application with same user credential and goto my account,click on billing address.
         commonPage.clickOnloginLink();
        String userName =fileUtiity .getDataFromPropertyFile(PropetyFileKeys.USERNAME.convertToString());
 		String password =fileUtiity .getDataFromPropertyFile(PropetyFileKeys.PASSWORD.convertToString());
 		login.loginToTheApplication(userName, password);
        commonPage.clickOnMyAccountTab();
         ma.clickOnShippingAndBillingAdress();
     
        //fetch the billing address and compare with previously entered billing address.   
         String actualBillingAddress = ma.getBillingAddress();
         String actualBillingState = ma.getBillingState();
         String actualBillingCity=ma.getBillingCity();
         String actualBillingPincode = ma.getBillingPincode();
         
         if(billingAddress.equals(actualBillingAddress)&& billingState.equals(actualBillingState)&& billingCity.equals(actualBillingCity)&&billingPincode.equals(actualBillingPincode))
         {
        	 System.out.println("Billing Address are same as entered by the user--->Test Case Pass");
         }
         else		
		     System.out.println("Billing Address are not same as entered by the user");
         
				

				
	}	
	
}

