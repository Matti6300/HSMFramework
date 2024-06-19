package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Matti
 * 
 *         Contains manage Doctor elements
 *
 */
public class ManageDoctorPage {

	public ManageDoctorPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[text()='Admin | Manage Doctors']")
	private WebElement PageFeadVerifier;

	@FindBy(name = "clinicaddress")
	private WebElement EditAddress;

	@FindBy(name = "submit")
	private WebElement submiutButton;

	@FindBy(xpath = "//div[contains(@class,'col-md')]/h5")
	private WebElement SuccessMessage;

	public WebElement getSubmiutButton() {
		return submiutButton;
	}

	public WebElement getSuccessMessage() {
		return SuccessMessage;
	}

	public WebElement getEditAddress() {
		return EditAddress;
	}

	public WebElement getPageFeadVerifier() {
		return PageFeadVerifier;
	}

}
