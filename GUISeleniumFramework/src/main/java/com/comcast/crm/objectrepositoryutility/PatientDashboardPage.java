package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboardPage {

	WebDriver driver;
	public PatientDashboardPage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//h1[text()='User | Dashboard']")
	private WebElement userDashboardHeader;
	
	@FindBy(xpath = "//span[contains(text(), 'Book Appointment')]")
	private WebElement bookappoinmentLink;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement patientDropdown;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutlink;
	
	public WebElement getUserDashboardHeader() {
		return userDashboardHeader;
	}

	public WebElement getBookappoinmentLink() {
		return bookappoinmentLink;
	}
	//bussines method
		public void logout()
		{
			patientDropdown.click();
			logoutlink.click();
		}
	
}
