package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

/**
 * @author theertha
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public class DrDashboardPage {
	WebDriver driver;
	public DrDashboardPage(WebDriver driver) {             //Rule 3 : Object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Doctor | Dashboard']")
	private WebElement DashBoardtext;
	
	@FindBy(xpath="//h1[text()='Doctor | Manage Patients']")
	private WebElement managepatientTxt;
	

	public WebElement getManagepatientTxt() {
		return managepatientTxt;
	}



	public WebElement getDashBoardtext() {
		return DashBoardtext;
	}

	@FindBy(xpath="//span[text()=' Dashboard ']")
	private WebElement Dashboard;
	
//	@FindBy(className="panel panel-white no-radius text-center")
//	private WebElement Myprofile;

	@FindBy(partialLinkText = "Update Profile")
	private WebElement MyAppointment;

	public WebElement getMyAppointment() {
		return MyAppointment;
	}

//	public WebElement getMyprofile() {
//		return Myprofile;
	//}

	@FindBy(xpath="//span[text()=' Appointment History']")
	private WebElement AppointmentHistory;

	public WebElement getDashboard() {
		return Dashboard;
	}
	
	@FindBy(xpath="//span[contains(text(),'Add')]")
	private WebElement AddPatient;
	
	@FindBy(xpath="//span[contains(text(),'Manage Patient')]")
	private WebElement ManagePatient;
	
	
	
	@FindBy(id="submit")
	private WebElement submit;
	

	public WebElement getSubmit() {
		return submit;
	}

	

	public WebElement getManagePatient() {
		return ManagePatient;
	}

	public WebElement getAddPatient() {
		return AddPatient;
	}

	public void setAddPatient(WebElement addPatient) {
		AddPatient = addPatient;
	}

	@FindBy(xpath ="//span[contains( text(),'Patients')]")
	private WebElement Patient;

	@FindBy(xpath="//span[text()=' Search ']")
	private WebElement Search;

	@FindBy(className="dropdown-toggle")
	private WebElement DrIcon;

	@FindBy(xpath="//a[contains(text(),'Log')]")
	private WebElement Logout;
	
	@FindBy(name="patname")
	private WebElement Upname;
	
	public WebElement getUpname() {
		return Upname;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	@FindBy(xpath="//span[@class='username']/i")
	private WebElement dropdown;

	public WebElement getLogout() {
		return Logout;
	}

	public WebElement getDrIcon() {
		return DrIcon;
	}

	public WebElement getAppointmentHistory() {
		return AppointmentHistory;
	}

	

	public WebElement getPatient() {
		return Patient;
	}

	public void setPatient(WebElement patient) {
		Patient = patient;
	}

	public WebElement getSearch() {
		return Search;
	}
	public void pat() {
		Actions a=new Actions(driver);
		a.moveToElement(Patient).build().perform();
		
	}

	public void logout() throws InterruptedException {
		
		DrIcon.click();
		//Thread.sleep(5000);
	    getLogout().click();
		//a.click(Logout).perform();
		
	}
}

