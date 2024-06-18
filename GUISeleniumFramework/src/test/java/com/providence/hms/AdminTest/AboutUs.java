package com.providence.hms.AdminTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.AboutusPage;
import com.comcast.crm.objectrepositoryutility.AdminDashboardPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class AboutUs extends BaseClass{

	@Test
	public void updateAboutUs() throws Throwable
	{
		String data=eLib.getDataFromExcel("Admin", 3, 2)+jLib.getRandomNumber();

		String actrl="http://49.249.28.218:8081/AppServer/Hospital_Doctor_Patient_Management_System/hms/admin/about-us.php";
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		String header1=adp.getAdminDashboard().getText();
		assertEquals(header1,"ADMIN | DASHBOARD");
		Reporter.log("ADMIN | DASHBOARD is displayed",true);
		adp.getPagesLink().click();
		adp.getAboutusLink().click();
		AboutusPage ap= new AboutusPage(driver);
		String header2=driver.getCurrentUrl();
		assertEquals(header2,actrl);
		Reporter.log("ADMIN | UPDATE THE ABOUT US CONTENT URL is displayed",true);
		ap.updateAboutus(data);
		configAM();
		HomePage hp= new HomePage(driver);
		hp.getAboutusLink().click();
		String aboutus = driver.findElement(By.xpath("//p[text()='"+data+"']")).getText();
		assertEquals(aboutus,data);
		Reporter.log("Same data is displayed ",true);
		configBM();
		
	}
}
