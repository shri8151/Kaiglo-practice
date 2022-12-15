package com.kaiglo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * This class contains the object,web element declaration and initialization  of CommonPage.
 */
public class CommonPage {
	@FindBy(xpath="//a[text()='My Account' and @href='my-account.php']")
	private WebElement myAccountTab;
	
	@FindBy(xpath="//a[text()='Wishlist']")
	private WebElement wishlistTab;
	

	@FindBy(xpath="//a[text()='My Cart']/../../../ul[@class='list-unstyled']")
	private WebElement MyCartLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']/../../../ul[@class='nav navbar-nav']")
	private WebElement homeTab;
	
	@FindBy(xpath ="//li[@class='dropdown yamm']")
	private WebElement fashion90Tab;
	
	@FindBy(xpath="//div[@class='basket']")
	private WebElement basketTab;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	@FindBy(linkText=("My Cart"))
	private WebElement myCartLink;
	
	
	
	
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business library
	/**
	 * This method is used to click on the MyaccountTab.
	 */
	public void clickOnMyAccountTab() {
		myAccountTab.click();
	}
	/**
	 * This method is used to click on the LoginLink.
	 */
	public void clickOnloginLink() {
		loginLink.click();
	}
	/*
	 *  This method is used to click on the logout link.
	 */
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	/*
	 *  This method is used to click on the home tab.
	 */
	public void clickHomeTab() {
		homeTab.click();
	}
	/*
	 *  This method is used to click on the Fashoin 90 tab.
	 */
	public void clickOnFtTab() {
		fashion90Tab.click();
	}
/*
 *  This method is used to click on the basket icon.
 */
	public void clickOnBasketTab() {
		basketTab.click();
	}
	 /*
	  *  This method is used to click on the mycart link.
	  */
	public void clickOnMyCartLink() {
		myCartLink.click();
	}

	public WebElement getMyCartLink() {
		return MyCartLink;
	}

	
	
	
	
	
	
	
	
	
	
}
