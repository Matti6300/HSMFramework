package com.providence.hms.AdminTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.PatientBookAppointmentPage;
import com.comcast.crm.objectrepositoryutility.PatientDashboardPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;

public class MakeUsertoPatientTest extends BaseClass {

	@Test
	public void makeUserToPatient() throws Throwable
	{
		configAM();
		String name=eLib.getDataFromExcel("Admin", 1, 2)+jLib.getRandomNumber();
		String adress=eLib.getDataFromExcel("Admin", 1, 3);
		String city=eLib.getDataFromExcel("Admin", 1, 4);
		String email=eLib.getDataFromExcel("Admin", 1, 5)+jLib.getRandomNumber();;
		String pass=eLib.getDataFromExcel("Admin", 1, 6);	
		
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.createNewUser(name, adress, city, email, pass);
		pl.patientLogin(email, pass);
		PatientDashboardPage pdp= new PatientDashboardPage(driver);
		String header1 = pdp.getUserDashboardHeader().getText();
		assertEquals(header1,"USER | DASHBOARD");
		Reporter.log("USER | DASHBOARD is displayed",true);
		pdp.getBookappoinmentLink().click();
		PatientBookAppointmentPage pba= new PatientBookAppointmentPage(driver);
		String header2 = pba.getBookappointmentHeader().getText();
		assertEquals(header2,"USER | BOOK APPOINTMENT");
		Reporter.log("USER | BOOK APPOINTMENT",true);
		
		String docspeac=eLib.getDataFromExcel("Admin", 5, 3);
		String docname=eLib.getDataFromExcel("Admin", 5, 4);
		String date = jLib.getSystemDateYYYYDDMM();
		pba.bookAppointment(docspeac, docname, date);
		pdp.logout();
		configBM();
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		adp.getUsersdropdown().click();
		adp.getManageuserslnk().click();
		boolean status = driver.findElement(By.xpath("//td[text()='"+name+"']")).isDisplayed();
		System.out.println(status);	
		assertTrue(status, "true");
		Reporter.log("user displayed in manage users",true);
		adp.logout();
		
	
	}
}
