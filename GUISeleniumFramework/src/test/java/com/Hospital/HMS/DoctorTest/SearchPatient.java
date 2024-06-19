package com.Hospital.HMS.DoctorTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DrDashboardPage;
import com.comcast.crm.objectrepositoryutility.SearchPatintPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class SearchPatient extends BaseClass{
	/**
	 * @author theer
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
@Test
 public void search() throws Throwable {
	/*click on the search patient button*/
	SearchPatintPage sp=new SearchPatintPage(driver);
	sp.getSearchIcon().click();
	/*enter the text on the search text box*/
	System.out.println(sp.getSearchpagetext().getText());
	UtilityClassObject.getTest().log(Status.INFO, "navigating from doctordashboard page to Dotcor|Manage Patients page");
	Assert.assertEquals(sp.getSearchpagetext().getText(), "DOCTOR | MANAGE PATIENTS");
	Reporter.log("navigating sucessfully",true);
	//sp.getSearchtextBox().click();
	/*taking data from the excele*/
	String name=eLib.getDataFromExcel("org",4,2);
	sp.getSearchtextBox().sendKeys(name);
	sp.getSearchButton().click();
	UtilityClassObject.getTest().log(Status.INFO, "navigating from doctordashboard page to Dotcor|Manage Patients page");
	Assert.assertEquals(sp.getSearchpagetext().getText(), "DOCTOR | MANAGE PATIENTS");
	Reporter.log("successfully searching the patient name and navigating to the DOCTOR | MANAGE PATIENTS page");
	
	
	
}
}
