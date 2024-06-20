package com.Hospital.HMS.DoctorTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.TheerthaBaseclass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AdminDashBoardPage;
import com.comcast.crm.objectrepositoryutility.AdminLoginPage;
import com.comcast.crm.objectrepositoryutility.DrDashboardPage;
import com.comcast.crm.objectrepositoryutility.SearchPatintPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class NavigateFromDrToAdmin  extends TheerthaBaseclass {
	/**
	 * @author theer
	 * @throws Throwable 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test
	public void VerifyPatientDetailsReflectingInAdmin() throws Throwable {
		/* opening the dashboard page*/
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

		/*login as doctor and get logout from dctr*/
		configAM();
		/*login as admin */
		AdminLoginPage lg=new AdminLoginPage(driver);
		lg.login("admin", "Test@12345");
		/*clicking on patient button and click on  manage patient to 
		 * cofirm the patient details which created by doctor*/
		AdminDashBoardPage ad=new AdminDashBoardPage(driver);
		ad.getPatientDropdown().click();
		//ad.getPatientDropdown().click();
		ad.getManagepatientlnk().click();
		UtilityClassObject.getTest().log(Status.INFO,"navigating from afmin dashboatrd page to View patient page");
		Assert.assertEquals(ad.getViewpatientText().getText(), "ADMIN | VIEW PATIENTS");
		Reporter.log("navigationg from ADMIN | DASHBOARD to ADMIN | VIEW PATIENTS",true);
		SearchPatintPage sp=new SearchPatintPage(driver);
		//String name=eLib.getDataFromExcel("org",4,2);
		//sp.getSearchtextBox().sendKeys(pname);
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[last()]/td/a/i")).click();
		UtilityClassObject.getTest().log(Status.INFO,"navigating from admin dashboatrd page to manage patient page");
		Assert.assertEquals(ad.getDrmanageText().getText(), "DOCTOR | MANAGE PATIENTS");
		Reporter.log("navigating to DOCTOR | MANAGE PATIENTS",true);





	}
}

