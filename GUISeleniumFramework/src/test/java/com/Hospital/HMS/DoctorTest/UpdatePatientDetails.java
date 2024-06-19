package com.Hospital.HMS.DoctorTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DrDashboardPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class UpdatePatientDetails extends BaseClass{
	/**
	 * @author theer
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@Test
	public void UVerifyDrAbleToUpdate() throws Throwable {
		DrDashboardPage db = new DrDashboardPage(driver);
		/*click on patients button*/	
		db.getPatient().click();
		System.out.println(db.getDashBoardtext().getText());
		/*comparing the actual and expected result*/
		//Assert.assertEquals(db.getDashBoardtext().getText(), "DOCTOR | DASHBOARD", "pass");
		/*click on Add patient button*/
		db.getAddPatient().click();
		/*  Taking patient details and updating */
		String pname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		ap.getPatName().sendKeys(pname);
		String patCon = eLib.getDataFromExcel("org", 1, 3) + jLib.getRandomNumber();
		ap.getPatContact().sendKeys(patCon);
		String patEmail = eLib.getDataFromExcel("org", 1, 4) + jLib.getRandomNumber();
		ap.getPatEmail().sendKeys(patEmail);
		if(ap.getFemaleRadio().isSelected()){
			System.out.println("female radio button is created");
		}
		else {
			ap.getMaleRadio().isSelected();
		}
		String pAddress = eLib.getDataFromExcel("org", 1, 6);
		ap.getPatAddress().sendKeys(pAddress);
		String pAge = eLib.getDataFromExcel("org", 1, 7);
		ap.getPatAge().sendKeys(pAge);
		String pHistory = eLib.getDataFromExcel("org", 1, 8);
		ap.getPatmedhis().sendKeys(pHistory);
		ap.getAdd().click();

		/*click on patients button*/
		db.getPatient().click();
		/* click on manage patient*/
		db.getManagePatient().click();
         
		/*creating dynamic path*/
		driver.findElement(By.xpath("//td[text()='"+pname+"']/..//i[@class=\"fa fa-edit\"]")).click();
		UtilityClassObject.getTest().log(Status.INFO, "navigating from doctordashboard page to add patient page");
		Assert.assertEquals(ap.getAddPatientText().getText(), "PATIENT | ADD PATIENT");
		Reporter.log("navigationg from DOCTOR | MANAGE PATIENTS to PATIENT | ADD PATIENT",true);
		/*getting updated name*/
		String Upname = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
		/*clear the exist name*/
		db.getUpname().clear();
		/*update the new name*/
		db.getUpname().sendKeys(Upname);
		db.getSubmit().click();
		UtilityClassObject.getTest().log(Status.INFO,"navigating from the add patient page to the managepatient page");
		Assert.assertEquals(db.getManagepatientTxt().getText(), "DOCTOR | MANAGE PATIENTS");
		Reporter.log("navigationg from PATIENT | ADD PATIENT to  DOCTOR | MANAGE PATIENTS",true);
		
	}

}

