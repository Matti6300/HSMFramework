package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientSearchPage {
	
	

	public PatientSearchPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPAgeHeadVerifier() {
		return PAgeHeadVerifier;
	}


	public WebElement getSerachTextField() {
		return SerachTextField;
	}


	public WebElement getSubmitButton() {
		return SubmitButton;
	}


	@FindBy(xpath = "//h1[text()='Admin | View Patients']")
	private WebElement PAgeHeadVerifier;
	
	@FindBy(id = "searchdata")
	private WebElement SerachTextField;
	
	
	@FindBy(id = "submit")
	private WebElement SubmitButton;
	
	
	
}
