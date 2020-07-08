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
	
	@FindBy(xpath = "//h2[@translate='global.checkout.billingAndPayment.title']")
	WebElement txtPaymentpage;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-38']")
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

	@FindBy(xpath = "//iframe[@class='credit-card-iframe ng-star-inserted']")
	WebElement fraSemaphone;
	//div[@class='semafone-container']//descendant::iframe
	
	@FindBy(xpath = "//input[@class='semafonemandatory']")
	WebElement txtCardNumber;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-44']")
	WebElement txtCVV;

	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerCVV;
	
	@FindBy(xpath = "//select[@id='ds-form-input-id-42']")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//select[@id='ds-form-input-id-43']")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btnPaymentConfirm;

	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/..")
	WebElement btnContinue;
		
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;

	/**
	 * To click on the chevron on the payment page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		reusableActions.waitForElementVisibility(downChevronYourCart, 200);
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(downChevronYourCart, 120).click();
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
		reusableActions.waitForElementVisibility(txtPaymentpage, 180);
		return	reusableActions.isElementVisible(txtPaymentpage, 20);
	}
	
	/**
	 * Verify the Payment Modes page
	 * @return true if the Payment Mode drop down list is present, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPaymentModepageMigration() {
		reusableActions.waitForElementVisibility(btnPaymentConfirm, 200);
		return	reusableActions.isElementVisible(btnPaymentConfirm, 20);
	}
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param strPaymentMode payment modes for the payment for the purchase of Rogers offers
	 * @author chinnarao.vattam
	 */
	public void selectPaymentMode(String strPaymentMode) {
		reusableActions.selectWhenReadyByVisibleText(ddlPaymentMode, strPaymentMode);
	}
	
	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToCreditCardIFrame() {
		reusableActions.waitForElementVisibility(fraSemaphone,60);
		driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone));
	}
	
	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of Pre-Auth credit card for payment
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumberIFrame(String strAccountNumber) {
		reusableActions.getWhenReady(txtCardNumber,90);
		reusableActions.getWhenReady(txtCardNumber,30).sendKeys(strAccountNumber);
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
		reusableActions.waitForElementVisibility(txtContainerCVV,180);
		reusableActions.getWhenReady(txtContainerCVV,10).click();
		reusableActions.clickWhenVisible(txtCVV);
		reusableActions.getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
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
	 * Updated by saurav.goyal as per discussion with chinnarao.vattam
	 */
	public void clkPaymentConfirm() {
		reusableActions.getWhenReady(btnPaymentConfirm, 90).click();
	}
	
	/**
	 * click on  the payment confirmation button for Existing Customer
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirmExistingCustomer() {
		reusableActions.waitForElementTobeClickable(btnPaymentConfirm, 180);
		reusableActions.executeJavaScriptClick(btnPaymentConfirm);
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
