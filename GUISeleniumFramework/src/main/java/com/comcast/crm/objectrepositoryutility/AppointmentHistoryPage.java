package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistoryPage {
	
	
	public AppointmentHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public WebElement getPageHeadVrifier() {
		return PageHeadVrifier;
	}



	@FindBy(xpath = "//h1[text()='Patients  | Appointment History']")
	private WebElement PageHeadVrifier;

}
