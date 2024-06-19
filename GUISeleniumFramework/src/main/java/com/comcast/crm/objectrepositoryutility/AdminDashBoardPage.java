package com.comcast.crm.objectrepositoryutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author theertha
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public class AdminDashBoardPage {
	WebDriver driver;
	public AdminDashBoardPage(WebDriver driver) {            
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[text()='Doctor | Manage Patients']")
	private WebElement DrmanageText;
	
	public WebElement getDrmanageText() {
		return DrmanageText;
	}

	@FindBy(xpath="//h1[text()='Admin | View Patients']")
	private WebElement ViewpatientText;
	
	public WebElement getViewpatientText() {
		return ViewpatientText;
	}

	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patientDropdown;

	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement managepatientlnk;
	
//	@FindBy(xpath = "//td[text()='me']/..//i[@class=\"fa fa-eye\"]")
//	private WebElement adminActionicon;
//	
	
	public WebDriver getDriver() {
		return driver;
	}

//	public WebElement getAdminActionicon() {
//		return adminActionicon;
//	}

	public WebElement getPatientDropdown() {
		return patientDropdown;
	}

	public WebElement getManagepatientlnk() {
		return managepatientlnk;
	}

}
