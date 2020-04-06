package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersWirelessCreditEvaluationPage extends BasePageClass {

	public RogersWirelessCreditEvaluationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//select[@id='dobyear']")
	WebElement ddlDOBYear;
	
	@FindBy(xpath = "//select[@id='dobmonth']")
	WebElement ddlDOBMonth;

	@FindBy(xpath = "//select[@id='dobday']")
	WebElement ddlDOBDay;
	
	@FindBy(xpath="//iframe[@id='sema']")
	WebElement frmCreditCard;
	
	@FindBy(xpath="//input[@id='maskedPan']")
	WebElement txtCreditCardNumberMasked;
	
	@FindBy(xpath="//input[@id='pan']")
	WebElement txtCreditCardNumber;
	
	@FindBy(xpath="//select[@name='month']")
	WebElement ddlCreditCardExpiryMonth;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement ddlCreditCardExpiryYear;
	
	@FindBy(xpath = "//select[@ng-model='obj.drivingLicenseProvince' and @name='province']")
	WebElement ddlDLProvince;

	@FindBy(xpath = "//select[@name='dlYear']")
	WebElement ddlDLExpiryYear;

	@FindBy(xpath = "//select[@name='dlMonth']")
	WebElement ddlDLExpiryMonth;

	@FindBy(xpath = "//select[@name='dlExpiryDate']")
	WebElement ddlDLExpiryDay;

	@FindBy(xpath = "//input[@name='dlCardNumber']")
	WebElement txtDLNumber;
	
	@FindBy(xpath = "//input[@name='creditCheckBox']")
	WebElement chbxCreditCheckConsent;
	
	@FindBy(xpath="//span[@checkout-res='checkout_continue_lbl']/parent::div")
	WebElement btnContinue;
	
	/**
	 * Sets the Date of Birth which is generated randomly
	 * @author rajesh.varalli1
	 */
	public void setDateOfBirth() {
		String strDOBMonth = "0" + FormFiller.generateMonth();
		
		reusableActions.selectWhenReady(ddlDOBYear, FormFiller.generateDOBYear());
		reusableActions.selectWhenReady(ddlDOBMonth, strDOBMonth.substring(strDOBMonth.length()-2));
		reusableActions.selectWhenReady(ddlDOBDay, FormFiller.generateCalendarDay());
	}
	
	/**
	 * Sets the Credit Card Number, Expiry Year and Expiry Month
	 * @param strCCNumber Credit Card Number
	 * @param strCCExpMonth Credit Card Expiry Month
	 * @param strCCExpYear Credit Card Expiry Year
	 * @author rajesh.varalli1
	 */
	public void setCreditCardDetails(String strCCNumber, String strCCExpMonth, String strCCExpYear) {
		driver.switchTo().frame(frmCreditCard);
		
		reusableActions.staticWait(5000);
		txtCreditCardNumberMasked.click();
		txtCreditCardNumber.click();
		txtCreditCardNumber.sendKeys(strCCNumber);
		
		driver.switchTo().defaultContent();
		
		reusableActions.selectWhenReady(ddlCreditCardExpiryMonth, strCCExpMonth);
		
		reusableActions.selectWhenReadyByVisibleText(ddlCreditCardExpiryYear, strCCExpYear);
	}
	
	/**
	 * Sets the Driving License Number, Expiry date and Province
	 * @param strDLProvince Driving License Province
	 * @author rajesh.varalli1
	 */
	public void setDrivingLicenseDetails(String strDLProvince) {
		String strDOBMonth = "0" + FormFiller.generateMonth();
		
		reusableActions.selectWhenReady(ddlDLProvince, strDLProvince);
		reusableActions.selectWhenReady(ddlDLExpiryYear, FormFiller.generateExpiryYear());
		reusableActions.selectWhenReady(ddlDLExpiryMonth, strDOBMonth.substring(strDOBMonth.length()-2));
		reusableActions.selectWhenReady(ddlDLExpiryDay, FormFiller.generateCalendarDay());
		reusableActions.getWhenReady(txtDLNumber, 10).sendKeys(FormFiller.generateLicenseNumber(strDLProvince));
	}
	
	/**
	 * Clicks on the Credit Check consent checkbox
	 * @author rajesh.varalli1
	 */
	public void setCreditCheckConsent() {
		reusableActions.clickWhenReady(chbxCreditCheckConsent);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenVisible(btnContinue);
	}
}