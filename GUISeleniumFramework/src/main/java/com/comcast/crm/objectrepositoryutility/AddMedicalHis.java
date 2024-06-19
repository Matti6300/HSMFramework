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
public class AddMedicalHis {
	
	WebDriver driver;
	 public AddMedicalHis(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//button[text()='Add Medical History']")
	 private WebElement AddMedHistext;
	 
	 @FindBy(name="bp")
	 private WebElement bpText;
	 
	 @FindBy(name="bs")
	 private WebElement bsText;
	 
	 @FindBy(name="weight")
	 private WebElement weight;
	 
	 @FindBy(name="temp")
	 private WebElement temperature;
	 
	 @FindBy(name="pres")
	 private WebElement prescription;
	 
	 @FindBy(xpath="//button[text()='Submit']")
	 private WebElement submitaddHis;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddMedHistext() {
		return AddMedHistext;
	}

	public WebElement getBpText() {
		return bpText;
	}

	public WebElement getBsText() {
		return bsText;
	}

	public WebElement getWeight() {
		return weight;
	}

	public WebElement getTemperature() {
		return temperature;
	}

	public WebElement getPrescription() {
		return prescription;
	}

	public WebElement getSubmitaddHis() {
		return submitaddHis;
	}
	 
	 
	 
	 
	 

}
