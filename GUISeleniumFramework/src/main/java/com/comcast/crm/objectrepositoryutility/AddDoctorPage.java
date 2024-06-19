package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Matti
 * 
 *         Contains Add Dcotor page elements
 */

public class AddDoctorPage {
	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Admin | Add Doctor']")
	private WebElement PageHeadVerifier;

	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement SpecializationDropdown;

	@FindBy(name = "docname")
	private WebElement DocNameTextfield;

	@FindBy(name = "clinicaddress")
	private WebElement ClinicAddressTextfield;

	@FindBy(name = "docfees")
	private WebElement DocFeeTextfield;

	@FindBy(name = "doccontact")
	private WebElement DocContactTextfield;

	@FindBy(name = "docemail")
	private WebElement DocMailTextfield;

	@FindBy(name = "npass")
	private WebElement DocPasswordTextfield;

	@FindBy(name = "cfpass")
	private WebElement DocCnfrmPassword;

	@FindBy(name = "submit")
	private WebElement SubmitButton;

	public WebElement getPageHeadVerifier() {
		return PageHeadVerifier;
	}

	public WebElement getSpecializationDropdown() {
		return SpecializationDropdown;
	}

	public WebElement getDocNameTextfield() {
		return DocNameTextfield;
	}

	public WebElement getClinicAddressTextfield() {
		return ClinicAddressTextfield;
	}

	public WebElement getDocFeeTextfield() {
		return DocFeeTextfield;
	}

	public WebElement getDocContactTextfield() {
		return DocContactTextfield;
	}

	public WebElement getDocMailTextfield() {
		return DocMailTextfield;
	}

	public WebElement getDocPasswordTextfield() {
		return DocPasswordTextfield;
	}

	public WebElement getDocCnfrmPassword() {
		return DocCnfrmPassword;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}

}
