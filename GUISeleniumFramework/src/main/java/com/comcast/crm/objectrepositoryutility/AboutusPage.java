package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AboutusPage extends WebDriverUtility {

	
	WebDriver driver;
	public AboutusPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setAboutusHeader(WebElement aboutusHeader) {
		this.aboutusHeader = aboutusHeader;
	}



	@FindBy(xpath = "//h1[text()='Admin  | Update the About us Content']")
	private WebElement aboutusHeader;
	@FindBy(xpath = "//div[@contenteditable='true']")
	private WebElement pagedescriptionEdt;
	@FindBy(name ="submit" )
	private WebElement submitbtn;
	
	public WebElement getAboutusHeader() {
		return aboutusHeader;
	}
	//bussiness method
	public void updateAboutus(String data)
	{
		pagedescriptionEdt.clear();
		pagedescriptionEdt.sendKeys(data);
		submitbtn.click();
		switchtoAlertAndAccept(driver);
		
	}
}
