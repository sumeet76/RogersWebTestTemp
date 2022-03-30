package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersHomePhonePortInPage extends BasePageClass {

	public RogersHomePhonePortInPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath = "//input[@name='phoneNumberIHP']/..")
	WebElement txtHomePhoneNumberFormcontainer;

	@FindBy(xpath = "//input[@name='phoneNumberIHP']")
	WebElement txtHomePhoneNumber;

	@FindAll({
	@FindBy(xpath = "//button[@aria-label='Check if your number is eligible to transfer over.']/span"),
	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@class='ds-button__wrapper d-flex justify-content-center align-items-center']")})
	WebElement btnPhoneNumberEligibiltyCheck;


	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
	WebElement btnConfirmPhone;
	
	
	@FindBy(xpath = "//span[contains(@class,'ds-color-success')]")
	WebElement imgPhoneNumberVerificationSuccess;	


	@FindBy(xpath ="//input[@formcontrolname = 'firstName']")
	WebElement txtFirstName;

	@FindBy(xpath ="//input[@formcontrolname = 'lastName']")
	WebElement txtLastName;

	@FindBy(xpath ="//input[@formcontrolname = 'firstName']/..")
	WebElement txtFirstNameContainer;

	@FindBy(xpath ="//input[@formcontrolname = 'lastName']/..")
	WebElement txtLastNameContainer;

	@FindBy(xpath ="//input[contains(@id,'canada-post-address-complete-')]")
	WebElement txtInvoiceAddress;

	@FindBy(xpath ="//input[@formcontrolname = 'currentPhoneProvider']")
	WebElement txtCurrentPhoneNumber;
	
	@FindBy(xpath = "//input[@formcontrolname = 'currentPhoneProvider']/..")
	WebElement txtCurrentPhoneNumberContainer;

	@FindBy(xpath = "//select[@formcontrolname = 'accountSelectOption']")
	WebElement ddlAccountNumberOrIMEI;
		
	@FindBy(xpath = "//select[@formcontrolname = 'accountSelectOption']/..")
	WebElement selIMEIContainer;

	@FindBy(xpath = "//input[@name='imei']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtIMEIContainer;

		@FindBy(xpath = "//input[@name='imei']")
	WebElement txtAccountNumberOrIMEI;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary']//ins[@translate='global.common.buttons.continue']")
	WebElement btnConfirmPhoneNumber;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	
	/**
	 * Set Home phone number on the Home phone Port-in page
	 * @param strPhoneNumber phone number for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setHomePhoneNumber(String strPhoneNumber) {
		getReusableActionsInstance().getWhenReady(txtHomePhoneNumberFormcontainer, 30).click();
		getReusableActionsInstance().getWhenReady(txtHomePhoneNumber, 40).clear();
		getReusableActionsInstance().getWhenReady(txtHomePhoneNumber, 60).sendKeys(strPhoneNumber);
	}
	
	/**
	 * validate the home phone number success image
	 * @return true, if the success image displayed, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean   verifyPhoneNumberSuccess() {
		return getReusableActionsInstance().isElementVisible(imgPhoneNumberVerificationSuccess, 60);
	}

	
	/**
	 * Click to Home phone number eligibility Check button on the Home phone Port-in page to validate the entered number
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneNumberEligibiltyCheck() {
		getReusableActionsInstance().getWhenReady(btnPhoneNumberEligibiltyCheck, 120).click();
	}
	
	/**
	 * Click to Home phone phone confirm button
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneCheck() {
		getReusableActionsInstance().getWhenReady(btnConfirmPhone, 120).click();
	}
	
	/**
	 * Set First Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setFirstName() {
		String strName = FormFiller.generateRandomName();
		String strFname="Rogersaa" + strName;
		//getReusableActionsInstance().waitForElementVisibility(imgPhoneNumberVerificationSuccess, 30);
		//getReusableActionsInstance().executeJavaScriptClick(txtFirstName);
		getReusableActionsInstance().getWhenReady(txtFirstNameContainer, 5).click();
		getReusableActionsInstance().getWhenReady(txtFirstName, 5).sendKeys(strFname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		String strLname="Automation" + strName;
		//getReusableActionsInstance().executeJavaScriptClick(txtLastName);
		getReusableActionsInstance().getWhenReady(txtLastNameContainer, 5).click();
		getReusableActionsInstance().getWhenReady(txtLastName, 5).sendKeys(strLname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setCurrentPhoneNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		//Address loading taking time and interrupting the phone element 
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(txtCurrentPhoneNumberContainer,10).click();
		getReusableActionsInstance().getWhenReady(txtCurrentPhoneNumber,10).clear();
		getReusableActionsInstance().getWhenReady(txtCurrentPhoneNumber, 10).sendKeys(strPhoneNumber);
	}
	
	
	/**
	 * Set Invoice Address on the Home phone Port-in page 
	 * @param strInvoiceAddress for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setInvoiceAddress(String strInvoiceAddress) {
		getReusableActionsInstance().executeJavaScriptClick(txtInvoiceAddress);
		getReusableActionsInstance().getWhenReady(txtInvoiceAddress, 3).clear();
		getReusableActionsInstance().getWhenReady(txtInvoiceAddress, 3).sendKeys(strInvoiceAddress);
		getReusableActionsInstance().getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtInvoiceAddress).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Set Account Number or IMEI on the Home phone Port-in page
	 * @author Chinnarao.Vattam
	 */
	public void selIMEI() {
		getReusableActionsInstance().getWhenReady(selIMEIContainer, 30);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlAccountNumberOrIMEI, "IMEI");
	}
	
	/**
	 * Set Account Number or IMEI on the Home phone Port-in page
	 * @param strAccountNumberorIMEI Account Number or IMEI   for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setAccountNumberOrIMEI(String strAccountNumberorIMEI) {
		getReusableActionsInstance().executeJavaScriptClick(txtIMEIContainer);
		getReusableActionsInstance().getWhenReady(txtAccountNumberOrIMEI, 60).clear();
		getReusableActionsInstance().getWhenReady(txtAccountNumberOrIMEI, 3).sendKeys(strAccountNumberorIMEI);
	}
	
	/**
	 * Click to Confirm Phone Number button on the Home phone Port-in page to confirm the home phone details
	 * @author Chinnarao.Vattam
	 */
	public void clkConfirmPhoneNumber() {
		getReusableActionsInstance().getWhenReady(btnConfirmPhoneNumber, 30).click();
	}
}
