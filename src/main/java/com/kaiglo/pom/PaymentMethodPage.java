package com.kaiglo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * This class contains the objects of Payment Method page.
 */
public class PaymentMethodPage {
	
	
	@FindBy(xpath="//input[@value='COD' and @type='radio']")
	private WebElement codradioButton;
	
	@FindBy(xpath="//input[@type='radio' and @value='Internet Banking']")
	private WebElement iBankingRadioButton;
	
	@FindBy(xpath="//input[@type='radio' and @value='Debit / Credit card']")
	private WebElement debitOrCreditRadioBtn;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	

	public PaymentMethodPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

/*
 * This method is used to select the COD payment option.
 */
	public void selectCOD() {

		codradioButton.click();
		submitButton.click();
	}
	 /*
	  * This method is used to select the Internet Banking payment option.
	  */
	public void selectInternetBanking() {

		iBankingRadioButton.click();
		submitButton.click();
	}
	/*
	 * This method is used to select the Credit/Debit payment option.
	 */
	public void selectDebitCard() {

		debitOrCreditRadioBtn.click();
		submitButton.click();
	}
	
	
	
	
}
