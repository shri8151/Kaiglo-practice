package com.kaiglo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
 * this class contains the object of ProductCategory page
 */
public class ProductCategoryPage {

	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addToCartButton;
	
	public ProductCategoryPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business library
	/*
	 * /*
	 * This method is used to click on add to cart button.	
	 */
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
}
