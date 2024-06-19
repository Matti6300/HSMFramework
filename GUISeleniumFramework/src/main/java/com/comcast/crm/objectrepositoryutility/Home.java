package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Bharath Matti
 * 
 * Contains Logins page elements 
 *
 */  
public class Home extends WebDriverUtility{                             
                           
	WebDriver driver;
	 public Home(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 
	 @FindBy(xpath = "//div[@id='menu']/ul/li[6]/a")
	 private WebElement LoginsModule;
	 
	 
	 @FindBy(xpath = "//h6[text()='Admin Login']/../a/button")
	 private WebElement AdminLoginButton;
	 
	 
	 @FindBy(xpath = "//h6[text()='Patient Login']/../a/button")
	 private WebElement PatientLoginButton;
	 
	 @FindBy(xpath = "//h6[text()='Doctors login']/../a/button")
	 private WebElement DoctorLoginButton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLoginsModule() {
		return LoginsModule;
	}

	public WebElement getAdminLoginButton() {
		return AdminLoginButton;
	}

	public WebElement getPatientLoginButton() {
		return PatientLoginButton;
	}

	public WebElement getDoctorLoginButton() {
		return DoctorLoginButton;
	}
	 
	 
	/*public void logout() {
		
	}*/

	

	
	
}
