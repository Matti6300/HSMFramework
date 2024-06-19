package com.comcast.hsm.AdminFunctional;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AdminDashBoard;
import com.comcast.crm.objectrepositoryutility.ManageDoctorPage;

/**
 * 
 * @author Bharath Matti
 *
 *         In this Class we are Udating The Doctor
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class UpdatingTheDoctorTest extends BaseClass {

	// CreatingNewDoctorTest cd= new CreatingNewDoctorTest();

	@Test(groups = { "smokeTest", "regressionTest" })
	public void updating_TheDoctor_Test() throws Throwable {

		/* logged AS the Admin And Verifying the page */
		AdminDashBoard adb = new AdminDashBoard(driver);
		Reporter.log("Admin Dashboard displyed", true);
		UtilityClassObject.getTest().log(Status.INFO, "Admin Dashboard displyed");

		/* navigating to the manage doctor page */
		adb.getDoctorsDropdown().click();
		adb.getManageDoctorModule().click();

		/* verifying the new page with assertion */
		ManageDoctorPage mdp = new ManageDoctorPage(driver);
		assertEquals(mdp.getPageFeadVerifier().getText(), "ADMIN | MANAGE DOCTORS");
		Reporter.log("Manage Doctors Page verified successfully", true);
		UtilityClassObject.getTest().log(Status.INFO, "Manage Doctors Page verified successfully");
		String name = eLib.getDataFromExcel("org", 1, 8);
		System.out.println(name);
		WebElement ele1 = driver.findElement(
				By.xpath("//table[@class='table table-hover']/tbody/tr/td[text()='" + name + "']/../td[5]/div/a"));

		/* navigating the driver to the element */
		Actions act = new Actions(driver);
		act.scrollToElement(ele1);
		ele1.click();

		/* clearing the exisiting data */
		mdp.getEditAddress().clear();

		/* upadating the data */
		mdp.getEditAddress().sendKeys("bang");
		mdp.getSubmiutButton().click();

		/* verfying the update.. */
		System.out.println(mdp.getSuccessMessage().getText());
		Reporter.log("Doctor Updated successfully", true);
		UtilityClassObject.getTest().log(Status.PASS, "Doctor Updated successfully");

	}

}
