package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h2[text()='Admin Login']")
	private WebElement AdminLoginPageVerifier;
	
	@FindBy(name = "username")
	private WebElement UsernameTextField;
	

	@FindBy(name = "password")
	private WebElement PasswordTextField;
	
	@FindBy(name = "submit")
	private WebElement LoginButton;
	
	
	@FindBy(xpath = "//a[text()='Bacto Home Page']")
	private WebElement BackToHomePageButton;


	public WebElement getAdminLoginPageVerifier() {
		return AdminLoginPageVerifier;
	}


	public WebElement getUsernameTextField() {
		return UsernameTextField;
	}


	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}


	public WebElement getLoginButton() {
		return LoginButton;
	}


	public WebElement getBackToHomePageButton() {
		return BackToHomePageButton;
	}
	 public void loginToapp(String username , String password) {
		 
		 	
		 
		 UsernameTextField.click();
		 UsernameTextField.sendKeys(username);
		 
		 PasswordTextField.click();
		 PasswordTextField.sendKeys(password);
		 LoginButton.click();
			
	 }
	
}
