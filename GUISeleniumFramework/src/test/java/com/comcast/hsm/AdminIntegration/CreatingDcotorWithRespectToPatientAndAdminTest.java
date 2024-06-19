package com.comcast.hsm.AdminIntegration;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddDoctorPage;
import com.comcast.crm.objectrepositoryutility.AddSpecialization;
import com.comcast.crm.objectrepositoryutility.AdminDashBoard;
import com.comcast.crm.objectrepositoryutility.AdminLoginPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.PatientDashBoard;

/**
 * 
 * @author Bharath Matti
 * 
 *         In this class will create a specialization and Doctor, By usig these
 *         two we will book an appointment as patient and we will check whether
 *         it is reflected in admin moduke or not
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingDcotorWithRespectToPatientAndAdminTest extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void creating_Dcotor_WithRespectTo_Patient_And_AdminTest() throws Throwable {

		/* verifying for Admin Dashboard */
		AdminDashBoard adb = new AdminDashBoard(driver);
		assertEquals(adb.getDashboardVerifier().getText(), "ADMIN | DASHBOARD");
		Reporter.log("Admin Dashboard displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Admin Dashboard displyed");

		/* navigate to doctor dropdown */
		adb.getDoctorsDropdown().click();

		/* navigating to AddSpecialization page */
		adb.getDoctorSpecializationModule().click();

		/* verifying for Add specialization page */
		AddSpecialization AddSpl = new AddSpecialization(driver);
		assertEquals(AddSpl.getASpageVerifier().getText(), "ADMIN | ADD DOCTOR SPECIALIZATION");
		Reporter.log("add doctor specialization page displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "add doctor specialization page displyed");

		/* enter the data of specialization && creating the specialization */
		String special = eLib.getDataFromExcel("org", 8, 1) + jLib.getRandomNumber();
		AddSpl.getSpecializationTextField().sendKeys(special);
		AddSpl.getSubmitButton().click();

		/* verifying the creation with message */
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

		/* filling the all necessary data for doctor creation */
		wutil.select(AddDoc.getSpecializationDropdown(), special);
		String doc = eLib.getDataFromExcel("org", 1, 1) + jLib.getRandomNumber();
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

		/* singing out as admin */
		adb.getAdminDropDown().click();
		adb.getAdminLogout().click();

		/* navigating to patient login page */
		Home hm = new Home(driver);
		hm.getPatientLoginButton().click();
		wutil.switchToTabOnURL(driver, "/hms/user-login.php");

		/* Logging As Patient */
		PatientDashBoard pdb = new PatientDashBoard(driver);
		pdb.getPatientUserName().sendKeys(eLib.getDataFromExcel("org", 4, 2));
		pdb.getPatientPassword().sendKeys(eLib.getDataFromExcel("org", 4, 3));
		pdb.getPatientLoginButton().click();

		/* verifying the user page... */
		assertEquals(pdb.getPatientDashBoardVerifier().getText(), "USER | DASHBOARD");
		Reporter.log("Patient dashboard displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Patient dashboard displyed");

		/* navigating to book appointmrnt page.. */
		pdb.getBookAppointmrntModule().click();

		/* verifying the page... */
		assertEquals(pdb.getBookAppointmentPageVerifier().getText(), "USER | BOOK APPOINTMENT");
		Reporter.log("Book Appointment Page displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Book Appointment Page displyed");

		/* selecting the newly created specialization... */
		wutil.select(pdb.getDocSplDropdown(), special);

		/* selecting the newly created doctor... */
		wutil.select(pdb.getDocDropdown(), doc);

		/* selecting the date.... */
		pdb.getDate().click();
		pdb.getDate().sendKeys(jLib.getSystemDateYYYYDDMM());

		/* getting the time from javautil.. */
		String time = jLib.CurrentTime("HH:mm:ss");
		pdb.getTime().sendKeys(time);
		pdb.getSubmitbutton().click();

		Alert alx = driver.switchTo().alert();
		String CnfMesg = alx.getText();
		alx.accept();

		/* verifying the message...... */
		assertEquals(CnfMesg, "Your appointment successfully booked");
		Reporter.log("Appointmnet Booked Withrespect to the Created Specialization", true);
		UtilityClassObject.getTest().log(Status.INFO, "Appointmnet Booked Withrespect to the Created Specialization");

		/* Loggingout from patient page...... */
		pdb.getPatientProfile().click();
		pdb.getPatientLogout().click();

		/* Logging into admin module */
		AdminLoginPage alp = new AdminLoginPage(driver);
		hm.getAdminLoginButton().click();
		wutil.switchToTabOnURL(driver, "/hms/admin/");
		alp.getUsernameTextField().sendKeys(fLib.getDataFromPropertiesFile("username"));
		alp.getPasswordTextField().sendKeys(fLib.getDataFromPropertiesFile("password"));
		alp.getLoginButton().click();

		/* navigating to Appointment history moduke to check the appointment created */
		adb.getAppointmentHistoryModule().click();

		/* stroing the selected doc name while booking from the admin module */
		String Docname = driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr[last()]/td[2]")).getText();

		/* verfiying the doctor details, whether they are same or not */
		assertEquals(Docname, doc);
		Reporter.log("Doctor Verified", true);
		UtilityClassObject.getTest().log(Status.INFO, "Doctor Verified and both doctors are same");

		/* stroing the patient name, who booked the appointment from the admin module */
		String Patientname = driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr[last()]/td[3]"))
				.getText();

		/* verfiying the Patient details, whether they are same or not */
		assertEquals(Patientname, eLib.getDataFromExcel("org", 4, 1));
		Reporter.log("Patient Verified", true);
		UtilityClassObject.getTest().log(Status.INFO, "Patient  Verified and both patients are same");

		Reporter.log("doctor created and booked appointment as patient and achecked in admin login", true);
		UtilityClassObject.getTest().log(Status.PASS, "All details ferified ");

	}

}
