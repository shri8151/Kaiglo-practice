package com.kaiglo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * This class contains the objects of the My cart page.
 */
public class MyCartPage {
	
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkBox;
	
	@FindBy(name="ordersubmit")
	private WebElement checkoutButton;
	
	public  MyCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business library
	/*
	 * This method is used to select the check box.
	 */
	public void selectCheckBox() {
		checkBox.click();
	}
	/*
	 * This method is used to click on proceed to check out button.
	 */
	public void clickOnProceedToCheckOut() {
		checkoutButton.click();
	}

}
