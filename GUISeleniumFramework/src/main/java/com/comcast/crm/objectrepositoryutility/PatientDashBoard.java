package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Matti
 * 
 *         Contains Patient Search page elements
 *
 */
public class PatientDashBoard {

	public PatientDashBoard(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=' Book Appointment ']")
	private WebElement BookAppointmrntModule;

	@FindBy(name = "Doctorspecialization")
	private WebElement DocSplDropdown;

	@FindBy(name = "doctor")
	private WebElement DocDropdown;

	@FindBy(xpath = "//label[contains(text(),'Date')]/../input")
	private WebElement Date;

	@FindBy(xpath = "//span[@class='username']/i")
	private WebElement patientProfile;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement PatientLogout;

	@FindBy(name = "username")
	private WebElement PatientUserName;

	@FindBy(name = "password")
	private WebElement PatientPassword;

	@FindBy(name = "submit")
	private WebElement PatientLoginButton;

	@FindBy(xpath = "//h2[text()=' HMS | Patient Login']")
	private WebElement PatientLoginPageVerifier;

	@FindBy(xpath = "//h1[text()='User | Dashboard']")
	private WebElement patientDashBoardVerifier;

	@FindBy(xpath = "//h1[text()='User | Book Appointment']")
	private WebElement BookAppointmentPageVerifier;

	public WebElement getTime() {
		return Time;
	}

	@FindBy(id = "timepicker1")
	private WebElement Time;

	public WebElement getPatientUserName() {
		return PatientUserName;
	}

	public WebElement getPatientPassword() {
		return PatientPassword;
	}

	public WebElement getPatientLoginButton() {
		return PatientLoginButton;
	}

	public WebElement getPatientLoginPageVerifier() {
		return PatientLoginPageVerifier;
	}

	public WebElement getPatientDashBoardVerifier() {
		return patientDashBoardVerifier;
	}

	public WebElement getBookAppointmentPageVerifier() {
		return BookAppointmentPageVerifier;
	}

	public WebElement getPatientProfile() {
		return patientProfile;
	}

	public WebElement getPatientLogout() {
		return PatientLogout;
	}

	public WebElement getBookAppointmrntModule() {
		return BookAppointmrntModule;
	}

	public WebElement getDocSplDropdown() {
		return DocSplDropdown;
	}

	public WebElement getDocDropdown() {
		return DocDropdown;
	}

	public WebElement getDate() {
		return Date;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	@FindBy(name = "submit")
	private WebElement submitbutton;

}
