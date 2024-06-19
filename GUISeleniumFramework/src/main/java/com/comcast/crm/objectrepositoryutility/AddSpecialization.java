package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Matti
 * 
 * Contains Add Specialization page elements
 */
public class AddSpecialization {

	
	public AddSpecialization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='mainTitle']")
	private WebElement ASpageVerifier;
	
	public WebElement getASpageVerifier() {
		return ASpageVerifier;
	}


	public WebElement getSpecializationTextField() {
		return SpecializationTextField;
	}


	public WebElement getSubmitButton() {
		return SubmitButton;
	}


	public WebElement getConfirmMEssage() {
		return ConfirmMEssage;
	}

	@FindBy(name = "doctorspecilization")
	private WebElement SpecializationTextField;
	
	@FindBy(name = "submit")
    private WebElement SubmitButton;
	
	
	@FindBy(xpath = "//p[text()='Doctor Specialization added successfully !!								']")
	private WebElement ConfirmMEssage;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
