package com.comcast.crm.objectrepositoryutility;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoard {
	
	
	
	public AdminDashBoard(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public WebElement getDashboardVerifier() {
		return DashboardVerifier;
	}


	public WebElement getAdminDropDown() {
		return AdminDropDown;
	}


	public WebElement getManageUserFromDashboard() {
		return ManageUserFromDashboard;
	}


	public WebElement getManageDoctorFromDashboard() {
		return ManageDoctorFromDashboard;
	}


	public WebElement getAppointmentsFromDashboard() {
		return AppointmentsFromDashboard;
	}


	public WebElement getManagePatientsFromDashboard() {
		return ManagePatientsFromDashboard;
	}


	public WebElement getQueriesFromDashboard() {
		return QueriesFromDashboard;
	}


	public WebElement getChangePassword() {
		return ChangePassword;
	}


	public WebElement getAdminLogout() {
		return AdminLogout;
	}


	public WebElement getDoctorsDropdown() {
		return DoctorsDropdown;
	}


	public WebElement getDoctorSpecializationModule() {
		return DoctorSpecializationModule;
	}


	public WebElement getAddDcotorModule() {
		return AddDcotorModule;
	}


	public WebElement getManageDoctorModule() {
		return ManageDoctorModule;
	}


	public WebElement getAppointmentHistoryModule() {
		return AppointmentHistoryModule;
	}


	public WebElement getDoctoSessionsModule() {
		return DoctoSessionsModule;
	}


	public WebElement getReportsDropdown() {
		return ReportsDropdown;
	}


	public WebElement getBWDateReports() {
		return BWDateReports;
	}


	public WebElement getPatientSearch() {
		return PatientSearch;
	}



	@FindBy(xpath = "//h1[text()='Admin | Dashboard']")
	private WebElement DashboardVerifier;
	
	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement AdminDropDown;
	
	@FindBy(xpath = "//h2[text()='Manage Users']/../p/a")
	private WebElement ManageUserFromDashboard;
	
	

	@FindBy(xpath = "//h2[text()='Manage Doctors']/../p/a")
	private WebElement ManageDoctorFromDashboard;
	

	@FindBy(xpath = "//h2[text()=' Appointments']/../p/a[2]")
	private WebElement AppointmentsFromDashboard;
	
	

	@FindBy(xpath = "//h2[text()='Manage Patients']/../p/a")
	private WebElement ManagePatientsFromDashboard;
	
	
	
	@FindBy(xpath = "//h2[text()=' New Queries']/../p/a[2]")
     private WebElement QueriesFromDashboard;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']/li/a")
private WebElement ChangePassword;
	
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-dark']/li[2]/a")
	private WebElement AdminLogout;
	
	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement DoctorsDropdown;
	
	
	
	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement DoctorSpecializationModule;
	

	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement AddDcotorModule;
	
	
	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement ManageDoctorModule;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistoryModule;
	
	
	@FindBy(xpath ="//span[text()=' Doctor Session Logs ']")
	private WebElement DoctoSessionsModule;
	
	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement ReportsDropdown;
	
	
	@FindBy(xpath ="//span[text()='B/w dates reports ']")
	private WebElement BWDateReports;
	
	
	@FindBy(xpath = "//span[text()=' Patient Search ']")
	private WebElement PatientSearch;
	
	
}
