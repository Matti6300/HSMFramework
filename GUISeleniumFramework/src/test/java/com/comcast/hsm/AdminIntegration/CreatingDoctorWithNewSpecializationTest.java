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

/**
 * 
 * @author Bharath Matti
 * 
 *         In this class will create a specialization and we will create a new
 *         doctor for that new specialization
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingDoctorWithNewSpecializationTest extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void creating_Dcotor_With_New_Specialization_Test() throws Throwable {

		/* verifying for Admin Dashboard */
		AdminDashBoard adb = new AdminDashBoard(driver);
		assertEquals(adb.getDashboardVerifier().getText(), "ADMIN | DASHBOARD");
		Reporter.log("admin dashboard verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "admin dashboard verified successfully");

		/* navigate to doctor dropdown */
		adb.getDoctorsDropdown().click();

		/* navigating to AddSpecialization page */
		adb.getDoctorSpecializationModule().click();

		/* verifying for Add specialization page */
		AddSpecialization AddSpl = new AddSpecialization(driver);
		assertEquals(AddSpl.getASpageVerifier().getText(), "ADMIN | ADD DOCTOR SPECIALIZATION");
		Reporter.log("Add Doctor specialization Page  verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Add Doctor specialization Page  verified successfully");

		/* enter the date of specialization && creating the specialization */
		String special = eLib.getDataFromExcel("org", 7, 1) + jLib.getRandomNumber();
		AddSpl.getSpecializationTextField().sendKeys(special);
		AddSpl.getSubmitButton().click();

		/* verifying with message */
		assertEquals(AddSpl.getConfirmMEssage().getText(), "Doctor Specialization added successfully !!");
		Reporter.log("Doctor Specialization added successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Doctor Specialization added successfully");

		/* navigating to doctor dropdown */
		adb.getDoctorsDropdown().click();

		/* navigating to add doctor page */
		adb.getAddDcotorModule().click();

		/* verifying for page */
		AddDoctorPage AddDoc = new AddDoctorPage(driver);
		assertEquals(AddDoc.getPageHeadVerifier().getText(), "ADMIN | ADD DOCTOR");
		Reporter.log(" Add Doctor Page Verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Add Doctor Page Verified successfully");

		/* slecting the newly created specialization for doctor creation */
		wutil.select(AddDoc.getSpecializationDropdown(), special);

		/* filling the all necessary data of doctor creation */
		String doc = eLib.getDataFromExcel("org", 1, 1) + jLib.getRandomNumber();
		AddDoc.getDocNameTextfield().sendKeys(doc);
		AddDoc.getClinicAddressTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 2));
		AddDoc.getDocFeeTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 3));
		AddDoc.getDocContactTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 4));
		AddDoc.getDocMailTextfield().sendKeys("abdce" + jLib.getRandomNumber() + "@gmail.com");
		AddDoc.getDocPasswordTextfield().sendKeys(eLib.getDataFromExcel("org", 1, 6));
		AddDoc.getDocCnfrmPassword().sendKeys(eLib.getDataFromExcel("org", 1, 6));
		AddDoc.getSubmitButton().click();

		/*
		 * TakesScreenshot sh = (TakesScreenshot) UtilityClassObject.getDriver(); String
		 * filePath = sh.getScreenshotAs(OutputType.BASE64); String time = new
		 * Date().toString().replace(" ", "_").replace(":", "_");
		 * UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath,
		 * "screenshot" + jLib.getRandomNumber() + "_" + time);
		 */

		Alert alt = driver.switchTo().alert();
		String Message = alt.getText();
		alt.accept();

		/* verifying whether doctor created or not with message */
		assertEquals(Message, "Doctor info added Successfully");
		Reporter.log("Doctor added successfully", true);
		UtilityClassObject.getTest().log(Status.PASS, "Doctor created successfully with newly created specialization");

	}

}
