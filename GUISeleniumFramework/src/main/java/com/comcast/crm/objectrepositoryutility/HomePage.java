package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class HomePage extends WebDriverUtility{                             

	WebDriver driver;
	public HomePage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h6[text()='Doctors login']/../a/button")
	private WebElement click;

	@FindBy(xpath="Logins")
	private WebElement login;

	public WebElement getClick() {
		return click;
	}

	public WebElement getLogin() {
		return login;
	}
	@FindBy(xpath = "//img[@src='assets/images/admin.jpg']/.. //button[text()='Click Here']")                        
	private WebElement adminclickherebtn;
	
	public WebElement getAdminclickherebtn() {
		return adminclickherebtn;
	}




}




