package com.kaiglo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kaiglo.geneicUtilityPackage.PropetyFileKeys;
/*
 * This class contains the objects of LoginPage.
 */
public class LoginPage {
	
	@FindBy(id="exampleInputEmail1")
	private WebElement emailTextBox;
	
	@FindBy(name="password")
	private WebElement pwdTextBox;
	
	@FindBy(name="login")
	private WebElement loginButton;
	
	@FindBy(id="fullname")
	private WebElement fullNameTbx;
	
	@FindBy(id="email")
	private WebElement emailTbx;
	
	@FindBy(id="contactno")
	private WebElement contactTbx;
	
	@FindBy(id="password")
	private WebElement pwdTbx;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPwdTbx;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	public  LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);}
	
	//Business library
	/*
	 *  This method is used to ENTER  the EMAIL.
	 */
		public void enterEmail(String email) {
			emailTextBox.sendKeys(email);}
	/*
	 * 	This method is used to ENTER  the password.
	 */
		public void enterPassword(String password) {
			pwdTextBox.sendKeys(password);}
	/*
	 * This method is used to click on login link.
	 */
		public void clickLogin() {
			loginButton.click();}
		/*
		 * This method is used to ENTER  the full name.	
		 */
		public void enterFullName(String fullname) {
			fullNameTbx.sendKeys(fullname);}

		/*
		 * This method is used to ENTER  the New email.	
		 */
		public void enterNewEmail(String email) {
			emailTbx.sendKeys(email);}	
		/*
		 * This method is used to ENTER  the contact no.	
		 */
		public void enterContactNo(String contact) {
			contactTbx.sendKeys(contact);}
		/*
		 * This method is used to ENTER the new password.	
		 */
		public void enterNewPassword(String password) {
			pwdTbx.sendKeys(password);}
		/*
		 * This method is used to ENTER  confirmed password.
		 */
		public void enterConfirmPwd(String pwd) {
			confirmPwdTbx.sendKeys(pwd);
		}
		/*
		 * This method is used to click on submit.
		 */
		public void clickSubmit() {
			submitButton.click();
		}
		
	/*
	 * This method is used to login to application.
	 */
		public void loginToTheApplication(String userName, String password) {
			emailTextBox.sendKeys(userName);
			pwdTextBox.sendKeys(password);
			loginButton.click();
		}
		
	

}
