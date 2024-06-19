package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Bharath Matti
 *
 * Contains Doctor Sessions page elements
 */
public class DoctorSessionPage {
	
	
	
	public DoctorSessionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPageHeadVerifier() {
		return PageHeadVerifier;
	}

	@FindBy(xpath = "//h1[text()='Admin  | Doctor Session Logs']")
	private WebElement PageHeadVerifier;
    

}
