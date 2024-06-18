package com.providence.hms.AdminTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class trial extends BaseClass {

	@Test
	public void tc() throws Throwable
	{
		String data=eLib.getDataFromExcel("Admin", 3, 2)+jLib.getRandomNumber();

		configAM();
		HomePage hp= new HomePage(driver);
		hp.getAboutusLink().click();
	String aboutus = driver.findElement(By.xpath("//p[text()='Hello this is Providence hospital4241.']")).getText();
		System.out.println(aboutus);
		assertEquals(aboutus,"Hello this is Providence hospital4241.");
		Reporter.log("Same data is displayed ",true);
		configBM();
		
	}
}
