package com.providence.hms.AdminTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ManageUsersPage;
import com.comcast.crm.objectrepositoryutility.PatientLoginPage;

public class DeleteUserTest extends BaseClass {

	@Test
	public void mai() throws Throwable
	{
		String name=eLib.getDataFromExcel("Admin", 1, 2)+jLib.getRandomNumber();
		String adress=eLib.getDataFromExcel("Admin", 1, 3);
		String city=eLib.getDataFromExcel("Admin", 1, 4);
		String email=eLib.getDataFromExcel("Admin", 1, 5)+jLib.getRandomNumber();;
		String pass=eLib.getDataFromExcel("Admin", 1, 6);	
		
		AdminDashboardPage adp= new AdminDashboardPage(driver);
		adp.logout();
		
		PatientLoginPage pl= new PatientLoginPage(driver);
		pl.createNewUser(name, adress, city, email, pass);
		configBM();
		String header1=adp.getAdminDashboard().getText();
		assertEquals(header1,"ADMIN | DASHBOARD");
		Reporter.log("ADMIN | DASHBOARD is displayed",true);
		adp.getUsersdropdown().click();
		adp.getManageuserslnk().click();
		ManageUsersPage mu= new ManageUsersPage(driver);
		String header2=mu.getManageUserPageHeading().getText();
        assertEquals(header2,"ADMIN | MANAGE USERS");
        Reporter.log("DMIN | MANAGE USERS",true);
        mu.deleteUser(name);
        String msg= mu.getDatadeleted().getText();
        assertEquals(msg,"data deleted !!");
        Reporter.log("data deleted !! is displayed",true);
		configAM();
		pl.patientLogin(email, pass);
				
		String header3 = pl.getPatientloginheader().getText();
		assertEquals(header3,"HMS | Patient Login");
		 Reporter.log("HMS | Patient Login means it not loged in as user",true);
		WebDriverUtility wlib1= new WebDriverUtility();
		wlib1.switchToTabOnURL(driver, "/AppServer/Hospital_Doctor_Patient_Management_System/index.php");	
		configBM();
		
		
		
		
		
		


	}
}
