package com.comcast.crm.objectrepositoryutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author theertha
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public class AddPatientPage {
	
	WebDriver driver;
	 public AddPatientPage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//h1[text()='Patient | Add Patient']")
	 private WebElement AddPatientText;
	 
	 @FindBy(name = "patname")
	 private WebElement PatName;
	 
	 @FindBy(name="patcontact")
	 private WebElement PatContact;
	 
	 @FindBy(id="patemail")
	 private WebElement patEmail;
	 
	 @FindBy(id="rg-female")
	 private WebElement femaleRadio;
	 
	 @FindBy(id="rg-male")
	 private WebElement maleRadio;
	 
	 @FindBy(name="pataddress")
	 private WebElement patAddress;
	 
	 @FindBy(name="patage")
	 private WebElement patAge;
	 
	 @FindBy(name="medhis")
	 private WebElement patmedhis;
	 
	 
	 @FindBy(id="submit")
	 private WebElement Add;
	 
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getAddPatientText() {
		return AddPatientText;
	}


	public WebElement getPatName() {
		return PatName;
	}


	public WebElement getPatContact() {
		return PatContact;
	}


	public WebElement getPatEmail() {
		return patEmail;
	}


	public WebElement getFemaleRadio() {
		return femaleRadio;
	}


	public WebElement getMaleRadio() {
		return maleRadio;
	}


	public WebElement getPatAddress() {
		return patAddress;
	}


	public WebElement getPatAge() {
		return patAge;
	}


	public WebElement getPatmedhis() {
		return patmedhis;
	}


	public WebElement getAdd() {
		return Add;
	}
	 
	 
	 
	 
	 

}
