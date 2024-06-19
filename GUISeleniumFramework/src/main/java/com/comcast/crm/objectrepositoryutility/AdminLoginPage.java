package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * @author theertha
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public class AdminLoginPage extends WebDriverUtility {
	
	WebDriver driver;
	public AdminLoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "username")
	private WebElement usernameEdt;
	
	@FindBy(name = "password")
	private WebElement passwordEdt;
	
	@FindBy(name = "submit")
	private WebElement loginbtn;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	//bussiness mewthod
	public void login(String username, String password)
	{
		HomePage hp= new HomePage(driver);
		hp.getAdminclickherebtn().click();
		switchToTabOnTitle(driver, "admin");
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}

}
