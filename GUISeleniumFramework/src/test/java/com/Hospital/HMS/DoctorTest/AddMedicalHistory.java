package com.Hospital.HMS.DoctorTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.TheerthaBaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddMedicalHis;
import com.comcast.crm.objectrepositoryutility.DrDashboardPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddMedicalHistory extends TheerthaBaseclass {
	/**
	 * @author theer
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test
	public void VerifyDrAbleToAddMedicalHistory() throws Throwable {
		DrDashboardPage db = new DrDashboardPage(driver);
		/*
		 * click on patients button
		 */
		db.getPatient().click();
		System.out.println(db.getDashBoardtext().getText());

		/* click on Add patient button */
		db.getAddPatient().click();
		UtilityClassObject.getTest().log(Status.INFO, "PATIENT | ADD PATIENT");
		assertEquals(ap.getAddPatientText().getText(), "PATIENT | ADD PATIENT");
		Reporter.log("navigatiing from Dr.Dashboard to add patient page");

		// add patient page display

		System.out.println(ap.getAddPatientText().getText());

		/* Taking the details from */
		String pname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		ap.getPatName().sendKeys(pname);
		String patCon = eLib.getDataFromExcel("org", 1, 3);
		ap.getPatContact().sendKeys(patCon);
		String patEmail = eLib.getDataFromExcel("org", 1, 4) + jLib.getRandomNumber();
		ap.getPatEmail().sendKeys(patEmail);

		if (ap.getFemaleRadio().isSelected()) {
			Reporter.log("female is selected");
		} else
			ap.getMaleRadio().isSelected();

		String pAddress = eLib.getDataFromExcel("org", 1, 6);
		ap.getPatAddress().sendKeys(pAddress);
		String pAge = eLib.getDataFromExcel("org", 1, 7);
		ap.getPatAge().sendKeys(pAge);
		String pHistory = eLib.getDataFromExcel("org", 1, 8);
		ap.getPatmedhis().sendKeys(pHistory);
		ap.getAdd().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigating from Homepahe to Doctor dashboard page");
		Assert.assertEquals(ap.getAddPatientText().getText(), "PATIENT | ADD PATIENT");
		Reporter.log("Is able to Navigate PATIENT | ADD PATIENT ", true);
		db.getPatient().click();
		db.getManagePatient().click();

		/*dynamic path creating to click on patient eye icon*/
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[last()]/td/a[2]/i")).click();
		/*click on add medical history button */
		AddMedicalHis amh=new AddMedicalHis(driver);
		amh.getAddMedHistext().click();
		/*taking the patient medical history frome excel*/
		String pbp=eLib.getDataFromExcel("org",7,2)+jLib.getRandomNumber();
		amh.getBpText().sendKeys(pbp); String
		pbs=eLib.getDataFromExcel("org",7,3)+jLib.getRandomNumber();
		amh.getBsText().sendKeys(pbs); String
		pweigh=eLib.getDataFromExcel("org",7,4)+jLib.getRandomNumber();
		amh.getWeight().sendKeys(pweigh); String
		ptem=eLib.getDataFromExcel("org",7,5)+jLib.getRandomNumber();
		amh.getTemperature().sendKeys(ptem); String
		pprescrib=eLib.getDataFromExcel("org",7,6)+jLib.getRandomNumber();
		amh.getPrescription().sendKeys(pprescrib); amh.getSubmitaddHis().click();
		/*handling the popup successfully patient hiostory get creadted*/
		wLib.switchtoAlertAndAccept(driver);

	}

}
