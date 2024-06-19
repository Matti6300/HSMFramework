package com.Hospital.HMS.DoctorTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.DrDashboardPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class Createpatients extends BaseClass {
	/**
	 * @author theer
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test(groups = { "smokeTest" })
	public void VerifyDrAbleToCreatePatinet() throws Throwable {

		/*
		 * opening the dashboard page
		 */
		DrDashboardPage db = new DrDashboardPage(driver);
		/*
		 * click on patients button
		 */
		db.getPatient().click();
		System.out.println(db.getDashBoardtext().getText());
		// comparing the actual and expected result
		//String aTitle = driver.getTitle();

		/* click on Add patient button */
		db.getAddPatient().click();

		// add patient page display

		System.out.println(ap.getAddPatientText().getText());
		/* comparing the actual and expected result */
		//Assert.assertEquals(ap.getAddPatientText().getText(), "PATIENT | ADD PATIENT", "pass");

		/* Taking the details from*/
		String pname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		ap.getPatName().sendKeys(pname);
		String patCon = eLib.getDataFromExcel("org", 1, 3);
		ap.getPatContact().sendKeys(patCon);
		String patEmail = eLib.getDataFromExcel("org", 1, 4) + jLib.getRandomNumber();
		ap.getPatEmail().sendKeys(patEmail);

		if(ap.getFemaleRadio().isSelected()) {
			Reporter.log("female is selected");
		}else
		ap.getMaleRadio().isSelected();

		String pAddress = eLib.getDataFromExcel("org", 1, 6);
		ap.getPatAddress().sendKeys(pAddress);
		String pAge = eLib.getDataFromExcel("org", 1, 7);
		ap.getPatAge().sendKeys(pAge);
		String pHistory = eLib.getDataFromExcel("org", 1, 8);
		ap.getPatmedhis().sendKeys(pHistory);
		ap.getAdd().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigating from Homepahe to Doctor dashboard page");
		Assert.assertEquals(ap.getAddPatientText().getText(), "PATIENT | ADD PATIENT","pass");
		Reporter.log("Is able to Navigate PATIENT | ADD PATIENT ",true);

	}


}
