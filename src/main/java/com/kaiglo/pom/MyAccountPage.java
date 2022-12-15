package com.kaiglo.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * This class contains the Objects of my account page.
 */
public class MyAccountPage {
	
	
	@FindBy(xpath="//a[@class='collapsed' and @href='#collapseOne']")
	private WebElement myProfileTab;
	

	@FindBy(xpath="//a[@class='collapsed' and @href='#collapseTwo']")
	private WebElement changePwdTab ;
	

	@FindBy(linkText=("Order History"))
	private WebElement orderHistoryLink;
	

	@FindBy(linkText=("My Account"))
	private WebElement myAccountLink;
	
	@FindBy(linkText=("Shipping / Billing Address"))
	private WebElement shippingAndBillingLink;
	

	@FindBy(linkText=("Payment Pending Order"))
	private  WebElement paymentPendingOrderLink ;
	
	@FindBy(name="billingaddress")
	private  WebElement billingaddressTxtBox;
	
	@FindBy(name="bilingstate")
	private  WebElement billingStateTxtBox;
	
	@FindBy(name="billingcity")
	private  WebElement billingCityTxtBox;
	
	@FindBy(name="billingpincode")
	private  WebElement billingPincodeTxtBox;
	
	@FindBy(name="update")
	private  WebElement updateButton;
	
	@FindBy(xpath="//a[@href='#']//i[@class='icon fa fa-user']")
	private WebElement userIconLink;
	
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/*
	 * This method is used to fetch text of user icon link.
	 */
	public String getTextFromUserIcon() {
		String text = userIconLink.getText();
		return text;	
	}
	
	/*
	 * This method is used to click on order history. 
	 */
	public void clickOnOrderHistory() {
		orderHistoryLink.click();
	}
	
	public void clickOnShippingAndBillingAdress() {
		shippingAndBillingLink.click();
	}
	/*
	 * This method is used to click on submit. 
	 */
	public void clickOnSubmitButton() {
		updateButton.click();
	}
	/*
	 * This method is used to enter the billing state.
	 */
	public void enterBillingState(String state) {
		billingStateTxtBox.clear();
		billingStateTxtBox.sendKeys(state);
		}
	/*
	 * This method is used to enter the billing city.
	 */
	public void enterBillingCity(String city) {
		billingCityTxtBox.clear();
		billingCityTxtBox.sendKeys(city);
	}
	/*
	 * This method is used to enter the billing pin code.
	 */
	public void enterBillingPincode(String pincode) {
		billingPincodeTxtBox.clear();
		billingPincodeTxtBox.sendKeys(pincode);
	}
	/*
	 * This method is used to enter the billing Address.
	 */
    public void enterBillingAddress(String address) {
		billingaddressTxtBox.clear();
		billingaddressTxtBox.sendKeys(address);
	}
    /*
	 * This method is used to get the billing Address.
	 */
	public String getBillingAddress() {
		String ba = billingaddressTxtBox.getText();
		return ba;
	}
	/*
	 * This method is used to get the billing state.
	 */
	public String getBillingState() {
		String bs =billingStateTxtBox.getAttribute("value");
		return bs;
	}
	/*
	 * This method is used to get the billing city.
	 */
	 
	public String getBillingCity() {
		String bc =billingCityTxtBox.getAttribute("value");
		return bc;
	}
	/*
	 * This method is used to get billing pin code.
	 */
	public String getBillingPincode() {
		String bp =billingPincodeTxtBox.getAttribute("value");
		return bp;
	}
	
	
	/**
	 * This method is to fetch all the details of billing address.
	 * @return
	 */
	public List<String> getAllBillngAddress() {
		List<String>adress=new ArrayList<String>();
		adress.add(billingaddressTxtBox.getText());
		adress.add(billingStateTxtBox.getAttribute("value"));
		adress.add( billingCityTxtBox.getAttribute("value"));
		adress.add(billingPincodeTxtBox.getAttribute("value"));
	    return adress;
	    
	}


}
