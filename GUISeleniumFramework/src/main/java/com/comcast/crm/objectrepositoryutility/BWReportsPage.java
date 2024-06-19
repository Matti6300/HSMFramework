package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Bharath Matti
 *
 *         Contains Between Dates Report page elements
 *
 */
public class BWReportsPage {

	public BWReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPageHeadVerifier() {
		return PageHeadVerifier;
	}

	public WebElement getFromDate() {
		return FromDate;
	}

	public WebElement getToDate() {
		return ToDate;
	}

	public WebElement getSubmitButoon() {
		return SubmitButoon;
	}

	public WebElement getMessageVerifier() {
		return MessageVerifier;
	}

	@FindBy(xpath = "//h1[text()='Between Dates | Reports']")
	private WebElement PageHeadVerifier;

	@FindBy(name = "fromdate")
	private WebElement FromDate;

	@FindBy(name = "todate")
	private WebElement ToDate;

	@FindBy(name = "submit")
	private WebElement SubmitButoon;

	@FindBy(xpath = "//div[@class='col-md-12']/h5")
	private WebElement MessageVerifier;

}
