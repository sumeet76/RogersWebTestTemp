package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersHomePhonePortInPage extends BasePageClass {

	public RogersHomePhonePortInPage(WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtHomePhoneNumberFormcontainer;

	@FindBy(xpath = "//input[@name='phoneNumberIHP']")
	WebElement txtHomePhoneNumber;
	
	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@class='ds-button__wrapper d-flex justify-content-center align-items-center']")
	WebElement btnPhoneNumberEligibiltyCheck;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
	WebElement btnConfirmPhone;
	
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement imgPhoneNumberVerificationSuccess;	


	@FindBy(xpath ="//input[contains(@aria-label,'Enter your first name here')]")
	WebElement txtFirstName;

	@FindBy(xpath ="//input[contains(@aria-label,'Enter your last name here')]")
	WebElement txtLastName;
	
	@FindBy(xpath ="//input[contains(@id,'canada-post-address-complete-')]")
	WebElement txtInvoiceAddress;

	@FindBy(xpath ="//input[contains(@aria-label,'Enter your current phone provider here')]")
	WebElement txtCurrentPhoneNumber;
	
	@FindBy(xpath = "//input[contains(@aria-label,'Enter your current phone provider here')]/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtCurrentPhoneNumberContainer;

	@FindBy(xpath = "//select[contains(@aria-label,'Open list of account options')]")
	WebElement ddlAccountNumberOrIMEI;
		
	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white -select')]")
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
		reusableActions.getWhenReady(txtHomePhoneNumberFormcontainer, 30).click();
		reusableActions.getWhenReady(txtHomePhoneNumber, 40).clear();
		reusableActions.getWhenReady(txtHomePhoneNumber, 60).sendKeys(strPhoneNumber);
	}
	
	/**
	 * validate the home phone number success image
	 * @return true, if the success image displayed, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean   verifyPhoneNumberSuccess() {
		return reusableActions.isElementVisible(imgPhoneNumberVerificationSuccess, 60);
	}

	
	/**
	 * Click to Home phone number eligibility Check button on the Home phone Port-in page to validate the entered number
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneNumberEligibiltyCheck() {
		reusableActions.getWhenReady(btnPhoneNumberEligibiltyCheck, 120).click();
	}
	
	/**
	 * Click to Home phone phone confirm button
	 * @author Chinnarao.Vattam
	 */
	public void clkPhoneCheck() {
		reusableActions.getWhenReady(btnConfirmPhone, 120).click();
	}
	
	/**
	 * Set First Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setFirstName() {
		String strName = FormFiller.generateRandomName();
		String strFname="Rogersaa" + strName;
		reusableActions.waitForElementVisibility(imgPhoneNumberVerificationSuccess, 30);
		reusableActions.executeJavaScriptClick(txtFirstName);
		reusableActions.getWhenReady(txtFirstName, 10).sendKeys(strFname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		String strLname="Automation" + strName;
		reusableActions.executeJavaScriptClick(txtLastName);
		reusableActions.getWhenReady(txtLastName, 3).sendKeys(strLname);
	}
	
	/**
	 * Set Last Name on the Home phone Port-in page 
	 * @author Chinnarao.Vattam
	 */
	public void setCurrentPhoneNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		//Address loading taking time and interrupting the phone element 
		reusableActions.staticWait(3000);
		reusableActions.getWhenReady(txtCurrentPhoneNumberContainer,10).click();		
		reusableActions.getWhenReady(txtCurrentPhoneNumber,10).clear();
		reusableActions.getWhenReady(txtCurrentPhoneNumber, 10).sendKeys(strPhoneNumber);
	}
	
	
	/**
	 * Set Invoice Address on the Home phone Port-in page 
	 * @param strInvoiceAddress for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setInvoiceAddress(String strInvoiceAddress) {
		reusableActions.executeJavaScriptClick(txtInvoiceAddress);
		reusableActions.getWhenReady(txtInvoiceAddress, 3).clear();
		reusableActions.getWhenReady(txtInvoiceAddress, 3).sendKeys(strInvoiceAddress);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtInvoiceAddress).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Set Account Number or IMEI on the Home phone Port-in page
	 * @author Chinnarao.Vattam
	 */
	public void selIMEI() {
		reusableActions.getWhenReady(selIMEIContainer, 30);	
		reusableActions.waitForElementVisibility(ddlAccountNumberOrIMEI,90);
		reusableActions.selectWhenReadyByVisibleText(ddlAccountNumberOrIMEI, "IMEI");
	}
	
	/**
	 * Set Account Number or IMEI on the Home phone Port-in page
	 * @param strAccountNumberorIMEI Account Number or IMEI   for the port-in feature 
	 * @author Chinnarao.Vattam
	 */
	public void setAccountNumberOrIMEI(String strAccountNumberorIMEI) {
		reusableActions.executeJavaScriptClick(txtIMEIContainer);
		reusableActions.getWhenReady(txtAccountNumberOrIMEI, 60).clear();
		reusableActions.getWhenReady(txtAccountNumberOrIMEI, 3).sendKeys(strAccountNumberorIMEI);
	}
	
	/**
	 * Click to Confirm Phone Number button on the Home phone Port-in page to confirm the home phone details
	 * @author Chinnarao.Vattam
	 */
	public void clkConfirmPhoneNumber() {
		reusableActions.getWhenReady(btnConfirmPhoneNumber, 30).click();
	}
}
