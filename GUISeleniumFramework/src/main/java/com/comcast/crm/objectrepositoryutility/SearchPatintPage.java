package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author theertha
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public class SearchPatintPage {
	WebDriver driver;
	 public SearchPatintPage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//h1[text()='Doctor | Manage Patients']")
	 private WebElement searchpagetext;
	 
	 @FindBy(xpath = "//button[text()='Add Medical History']")
	 private WebElement ClickOnMedicalHistory;
	 
	 public WebElement getClickOnMedicalHistory() {
		return ClickOnMedicalHistory;
	}

	public WebElement getSearchpagetext() {
		return searchpagetext;
	}
	@FindBy(xpath="//span[contains(text(),'Search')]")
	 private WebElement searchIcon;
	 
	 public WebElement getSearchIcon() {
		return searchIcon;
	}
	@FindBy(linkText="Search by Name/Mobile No.")
	 private WebElement searchText;
	 
	 @FindBy(id="searchdata")
	 private WebElement searchtextBox;
	 
	 @FindBy(id="submit")
	 private WebElement searchButton;
	 

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchtextBox() {
		return searchtextBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	 
	 

}
