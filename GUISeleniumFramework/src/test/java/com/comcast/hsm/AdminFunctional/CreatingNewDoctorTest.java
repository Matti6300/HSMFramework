package com.comcast.hsm.AdminFunctional;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddDoctorPage;
import com.comcast.crm.objectrepositoryutility.AdminDashBoard;

/**
 * 
 * @author Bharath Matti
 * 
 *         In this script we are creating a new doctor
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreatingNewDoctorTest extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void creatinga_NewDcotor_Test() throws Throwable {

		/* logged AS the Admin And Verifying the page */
		AdminDashBoard adb = new AdminDashBoard(driver);
		assertEquals(adb.getDashboardVerifier().getText(), "ADMIN | DASHBOARD");
		Reporter.log("Admin Dashboard displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Admin Dashboard displyed");

		/* navigating to the doctor dropdown */
		adb.getDoctorsDropdown().click();

		/* clicking on the add new doctor module */
		adb.getAddDcotorModule().click();

		/* verifying The Page.. */
		AddDoctorPage AddDoc = new AddDoctorPage(driver);
		assertEquals(AddDoc.getPageHeadVerifier().getText(), "ADMIN | ADD DOCTOR");
		Reporter.log("Add Doctor Page verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Add Doctor Page verified successfully");

		/* filling the necessary Data */
		wutil.select(AddDoc.getSpecializationDropdown(), 3);
		String doc = eLib.getDataFromExcel("org", 1, 1) + jLib.getRandomNumber();
		System.out.println(doc);
		/* storing the data for future reference */
		eLib.setDataIntoExcel("org", 1, 8, doc);

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

		/* checking whether doctor is created or not */
		assertEquals(Message, "Doctor info added Successfully");
		Reporter.log("Doctor Added successfully", true);
		UtilityClassObject.getTest().log(Status.PASS, "Docter created successfully");

	}

}
