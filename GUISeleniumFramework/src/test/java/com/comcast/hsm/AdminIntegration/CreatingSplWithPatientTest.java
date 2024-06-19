package com.comcast.hsm.AdminIntegration;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddDoctorPage;
import com.comcast.crm.objectrepositoryutility.AddSpecialization;
import com.comcast.crm.objectrepositoryutility.AdminDashBoard;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.PatientDashBoard;

/**
 * 
 * @author Bharath Matti
 * 
 *         in this class we will creat a new specialization and booking
 *         appointment with that specialization
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingSplWithPatientTest extends BaseClass {

	@Test
	public void creating_Spl_Withrespect_To_Patient_Test() throws Throwable {

		/* verifying for Admin Dashboard */
		AdminDashBoard adb = new AdminDashBoard(driver);
		assertEquals(adb.getDashboardVerifier().getText(), "ADMIN | DASHBOARD");
		Reporter.log("Admin Dashboard displyed");
		UtilityClassObject.getTest().log(Status.INFO, "Admin Dashboard displyed");

		/* navigating to AddSpecialization page */
		adb.getDoctorsDropdown().click();
		adb.getDoctorSpecializationModule().click();

		/* verifying for Add specialization page */
		AddSpecialization AddSpl = new AddSpecialization(driver);
		assertEquals(AddSpl.getASpageVerifier().getText(), "ADMIN | ADD DOCTOR SPECIALIZATION");
		Reporter.log("add doctor specialization page displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "add doctor specialization page displyed");

		/* enter the date of specialization && creating the specialization */
		String special = eLib.getDataFromExcel("org", 8, 1) + jLib.getRandomNumber();
		AddSpl.getSpecializationTextField().sendKeys(special);
		AddSpl.getSubmitButton().click();

		/* verifying... the creation with message */
		assertEquals(AddSpl.getConfirmMEssage().getText(), "Doctor Specialization added successfully !!");
		Reporter.log("Doctor Specialization Added Successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Doctor Specialization Added Successfully");

		/* navigating to add doctor page */
		adb.getDoctorsDropdown().click();
		adb.getAddDcotorModule().click();

		/* verifying for add doctor page */
		AddDoctorPage AddDoc = new AddDoctorPage(driver);
		assertEquals(AddDoc.getPageHeadVerifier().getText(), "ADMIN | ADD DOCTOR");
		Reporter.log("Add Doctor Page Verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Add Doctor Page Verified successfully");

		/* Selecting the newly created specialization and filling the all details */
		wutil.select(AddDoc.getSpecializationDropdown(), special);
		String doc = eLib.getDataFromExcel("org", 2, 1) + jLib.getRandomNumber();
		AddDoc.getDocNameTextfield().sendKeys(doc);
		AddDoc.getClinicAddressTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 2));
		AddDoc.getDocFeeTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 3));
		AddDoc.getDocContactTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 4));
		AddDoc.getDocMailTextfield().sendKeys("abdce" + jLib.getRandomNumber() + "@gmail.com");
		AddDoc.getDocPasswordTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 6));
		AddDoc.getDocCnfrmPassword().sendKeys(eLib.getDataFromExcel("org", 1, 6));
		AddDoc.getSubmitButton().click();
		Alert alt = driver.switchTo().alert();
		String Message = alt.getText();
		alt.accept();

		/* verifying whether doctor created or not with message */
		assertEquals(Message, "Doctor info added Successfully");
		Reporter.log("Doctor added successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Doctor added successfully");

		// singing out as admin
		adb.getAdminDropDown().click();
		adb.getAdminLogout().click();

		/* navigating to patient login page and logging as patient */
		Home hm = new Home(driver);
		PatientDashBoard pdb = new PatientDashBoard(driver);
		hm.getPatientLoginButton().click();
		wutil.switchToTabOnURL(driver, "/hms/user-login.php");
		pdb.getPatientUserName().sendKeys(eLib.getDataFromExcel("org", 4, 2));
		pdb.getPatientPassword().sendKeys(eLib.getDataFromExcel("org", 4, 3));
		pdb.getPatientLoginButton().click();

		/* verifying the patient dashboard page... */
		assertEquals(pdb.getPatientDashBoardVerifier().getText(), "USER | DASHBOARD");
		Reporter.log("Patient dashboard displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Patient dashboard displyed");

		/* navigating ti the book appointment page */
		pdb.getBookAppointmrntModule().click();

		/* verifying the book appointment page... */
		assertEquals(pdb.getBookAppointmentPageVerifier().getText(), "USER | BOOK APPOINTMENT");
		Reporter.log("Book Appointment Page displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Book Appointment Page displyed");

		/* selecting the newly created specialization... */
		wutil.select(pdb.getDocSplDropdown(), special);

		/* selecting the newly created doctor... */
		wutil.select(pdb.getDocDropdown(), doc);

		/* giving the all neccessary date */
		pdb.getDate().sendKeys(jLib.getSystemDateYYYYDDMM());
		pdb.getTime().clear();

		/* getting the time from javautil.. */
		String time = jLib.CurrentTime("HH:mm:ss");
		pdb.getTime().sendKeys(time);

		pdb.getSubmitbutton().click();
		Alert alx = driver.switchTo().alert();
		String CnfMesg = alx.getText();
		alx.accept();

		// verifying the message......
		assertEquals(CnfMesg, "Your appointment successfully booked");
		Reporter.log("Appointmnet Booked Withrespect to the Created Specialization", true);
		UtilityClassObject.getTest().log(Status.PASS,
				"Appointment is booked with the newly created specialization and Doctor ");

	}

}
