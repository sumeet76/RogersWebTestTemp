package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersPaymentOptionsPage extends BasePageClass {

	public RogersPaymentOptionsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//select[@id='paymentOptionsSelect' or @id='nacPaymentMethod']")
	WebElement ddlPaymentMode;

	@FindBy(xpath = "//input[@id='transit-code']")
	WebElement txtTransitCode;

	@FindBy(xpath = "//input[@id='bank-code']")
	WebElement txtBankCode;

	@FindBy(xpath = "//input[@id='account-number']")
	WebElement txtAccountNumber;

	@FindBy(xpath = "//a[@href='http://www.cdnpay.ca/']")
	WebElement lnkCDPay;

	@FindBy(xpath = "//label[@class='margin-0-mobile']")
	WebElement chkCheckConsent;

	@FindBy(xpath = "//div[@class='semafone-container']//descendant::iframe")
	WebElement fraSemaphone;

	@FindBy(xpath = "//input[@class='semafonemandatory']")
	WebElement txtCardNumber;

	@FindBy(id = "cvv")
	WebElement txtCVV;

	@FindBy(xpath = "//select[@name='ccExpiryMonth']")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//select[@name='ccExpiryYear']")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnPaymentConfirm;

	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/..")
	WebElement btnContinue;
		
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//tr[@class='cms-promotions-gwp ng-tns-c46-27 ng-star-inserted']")
	WebElement gwpYourCart;

	/**
	 * To click on the chevron on the payment page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		reusableActions.getWhenReady(downChevronYourCart, 60).click();
	}

	/**
	 * To verify gwp promotion in the payment page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		reusableActions.waitForElementVisibility(gwpYourCart, 120);
		return	reusableActions.isElementVisible(gwpYourCart);
	}
	
	/**
	 * Verify the Payment Modes page
	 * @return true if the Payment Mode drop down list is present, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPaymentModepage() {
		reusableActions.waitForElementVisibility(ddlPaymentMode, 200);
		return	reusableActions.isElementVisible(ddlPaymentMode, 20);
	}
	
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param strPaymentMode payment modes for the payment for the purchase of Rogers offers
	 * @author chinnarao.vattam
	 */
	public void selectPaymentMode(String strPaymentMode) {
		reusableActions.selectWhenReady(ddlPaymentMode, strPaymentMode);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToCreditCardIFrame() {
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone));
	}
	
	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of Pre-Auth credit card for payment
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumberIFrame(String strAccountNumber) {
		reusableActions.clickWhenVisible(txtCardNumber);
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
	}
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfCreditCardIFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Set the dynamic CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = "number:" + FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = "number:" + FormFiller.generateExpiryYear();
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditcardCVV(String strCVV) {
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Set the expire month of Pre-Auth credit card
	 * @param strMM expire month of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryMonth(String strMM) {
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the expire year of Pre-Auth credit card
	 * @param strYYYY expire year of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}
/**
 * Set the transit code for  Pre-Auth Debit card
 * @param strTransitCode transit code for  Pre-Auth Debit card
 * @author chinnarao.vattam
 */
	public void setTransitCode(String strTransitCode) {
		reusableActions.clickWhenVisible(txtTransitCode);
		reusableActions.getWhenReady(txtTransitCode).sendKeys(strTransitCode);
	}

	/**
	 * Set the bank code for  Pre-Auth Debit card
	 * @param strBankCode bank code for  Pre-Auth Debit card
	 * @author chinnarao.vattam
	 */
	public void setBankCode(String strBankCode) {
		reusableActions.clickWhenVisible(txtBankCode);
		reusableActions.getWhenReady(txtBankCode).sendKeys(strBankCode);
	}

	/**
	 * Set the account number for Pre-Auth Debit card
	 * @param strAccountNumber account number for Pre-Auth Debit card
	 * @author chinnarao.vattam
	 */
	public void setAccountNumber(String strAccountNumber) {
		reusableActions.clickWhenVisible(txtAccountNumber);
		reusableActions.getWhenReady(txtAccountNumber).sendKeys(strAccountNumber);
	}

	/**
	 * @author chinnarao.vattam
	 */
	public void clkCDPay() {
		reusableActions.scrollToElement(lnkCDPay);
	}

	/**
	 * click on  the consent check box
	 * @author chinnarao.vattam
	 */
	public void clkCheckConsent() {
		reusableActions.getWhenReady(chkCheckConsent, 10).click();
	}

	/**
	 * click on  the payment confirmation button
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirm() {
		reusableActions.waitForElementTobeClickable(btnPaymentConfirm, 180);
		reusableActions.getWhenReady(btnPaymentConfirm, 180).click();
	}
	
	/**
	 * click on  the payment confirmation button for Existing Customer
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirmExistingCustomer() {
		reusableActions.waitForElementInvisibility(popupLoadingFingers, 180);
		reusableActions.waitForElementTobeClickable(btnPaymentConfirm, 180);
		reusableActions.getWhenReady(btnPaymentConfirm, 180).click();
	}
	/**
	 * Selects the Payment Method as 'Invoive (manual payments)'
	 * @author rajesh.varalli1
	 */
	public void setManualPaymentMethod() {
		selectPaymentMode("invoice");
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue);
	}
	
}
