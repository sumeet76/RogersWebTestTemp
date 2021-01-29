package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class RogersPaymentOptionsPage extends BasePageClass {

	public RogersPaymentOptionsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[@translate='global.checkout.billingAndPayment.title']")
	WebElement txtPaymentpage;
	
	@FindBy(xpath = "//select[contains(@class,'-select') and contains(@id,'ds-form-input-id-')]")
	WebElement ddlPaymentMode;
	
	@FindBy(xpath = "//input[@id='transit-code']")
	WebElement txtTransitCode;

	@FindBy(xpath = "//input[@id='bank-code']")
	WebElement txtBankCode;

	@FindBy(xpath = "//input[@id='account-number']")
	WebElement txtAccountNumber;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;

	@FindBy(xpath = "//a[@href='http://www.cdnpay.ca/']")
	WebElement lnkCDPay;

	@FindBy(xpath = "//label[@class='margin-0-mobile']")
	WebElement chkCheckConsent;

	@FindBy(xpath = "//iframe[@class='credit-card-iframe ng-star-inserted']")
	WebElement fraSemaphone;
	//div[@class='semafone-container']//descendant::iframe
	
	@FindBy(xpath = "//input[@class='semafonemandatory']")
	WebElement txtCardNumber;
	
	@FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id-')]")
	WebElement txtCVV;

	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerCVV;
	

	@FindBy(xpath = "//rch-dropdown[@ng-reflect-selected-key='0']//select[contains(@id,'ds-form-input-id') and contains(@class,'select')]")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//rch-dropdown[@ng-reflect-selected-key='2020']//select[contains(@id,'ds-form-input-id') and contains(@class,'select')]")
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
		getReusableActionsInstance().waitForElementVisibility(downChevronYourCart, 200);
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the payment page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
		return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}
	
	/**
	 * Verify the Payment Modes page
	 * @return true if the Payment Mode drop down list is present, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPaymentModepage() {
		getReusableActionsInstance().waitForElementVisibility(txtPaymentpage, 60);
		return	getReusableActionsInstance().isElementVisible(txtPaymentpage, 20);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		getReusableActionsInstance().staticWait(120000);
		return getReusableActionsInstance().isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinueSession() {
		getReusableActionsInstance().getWhenReady(btnContinueSession, 20).click();
	}

	/**
	 * Verify the Payment Modes page
	 * @return true if the Payment Mode drop down list is present, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPaymentModepageMigration() {
		getReusableActionsInstance().waitForElementVisibility(btnPaymentConfirm, 200);
		return	getReusableActionsInstance().isElementVisible(btnPaymentConfirm, 20);
	}
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param strPaymentMode payment modes for the payment for the purchase of Rogers offers
	 * @author chinnarao.vattam
	 */
	public void selectPaymentMode(String strPaymentMode) {
		getReusableActionsInstance().waitForElementVisibility(ddlPaymentMode, 90);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlPaymentMode, strPaymentMode);
	}
	
	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToCreditCardIFrame() {
		getReusableActionsInstance().waitForElementVisibility(fraSemaphone,60);
		getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraSemaphone));
	}
	
	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of Pre-Auth credit card for payment
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumberIFrame(String strAccountNumber) {
		getReusableActionsInstance().getWhenReady(txtCardNumber,90);
		getReusableActionsInstance().getWhenReady(txtCardNumber,30).sendKeys(strAccountNumber);
	}
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfCreditCardIFrame() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Set the dynamic CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerCVV,50);
		getReusableActionsInstance().getWhenReady(txtContainerCVV,10).click();
		txtCVV.click();
		getReusableActionsInstance().getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Set the dynamic CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVVMobile() {
		String strCVV = FormFiller.generateCVVNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerCVV,180);
		getReusableActionsInstance().executeJavaScriptClick(txtContainerCVV);
		getReusableActionsInstance().getWhenReady(txtCVV, 30).clear();
		getReusableActionsInstance().getWhenReady(txtCVV,10).sendKeys(strCVV);
	}
	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		getReusableActionsInstance().getWhenReady(ddlExpiryMonth,30);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		getReusableActionsInstance().getWhenReady(ddlExpiryYear,30);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @param strCVV CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditcardCVV(String strCVV) {
		getReusableActionsInstance().clickWhenVisible(txtCVV);
		getReusableActionsInstance().getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Set the expire month of Pre-Auth credit card
	 * @param strMM expire month of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryMonth(String strMM) {
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the expire year of Pre-Auth credit card
	 * @param strYYYY expire year of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		getReusableActionsInstance().selectWhenReady(ddlExpiryYear, strYYYY);
	}
/**
 * Set the transit code for  Pre-Auth Debit card
 * @param strTransitCode transit code for  Pre-Auth Debit card
 * @author chinnarao.vattam
 */
	public void setTransitCode(String strTransitCode) {
		getReusableActionsInstance().clickWhenVisible(txtTransitCode);
		getReusableActionsInstance().getWhenReady(txtTransitCode).sendKeys(strTransitCode);
	}

	/**
	 * Set the bank code for  Pre-Auth Debit card
	 * @param strBankCode bank code for  Pre-Auth Debit card
	 * @author chinnarao.vattam
	 */
	public void setBankCode(String strBankCode) {
		getReusableActionsInstance().clickWhenVisible(txtBankCode);
		getReusableActionsInstance().getWhenReady(txtBankCode).sendKeys(strBankCode);
	}

	/**
	 * Set the account number for Pre-Auth Debit card
	 * @param strAccountNumber account number for Pre-Auth Debit card
	 * @author chinnarao.vattam
	 */
	public void setAccountNumber(String strAccountNumber) {
		getReusableActionsInstance().clickWhenVisible(txtAccountNumber);
		getReusableActionsInstance().getWhenReady(txtAccountNumber).sendKeys(strAccountNumber);
	}

	/**
	 * @author chinnarao.vattam
	 */
	public void clkCDPay() {
		getReusableActionsInstance().scrollToElement(lnkCDPay);
	}

	/**
	 * click on  the consent check box
	 * @author chinnarao.vattam
	 */
	public void clkCheckConsent() {
		getReusableActionsInstance().getWhenReady(chkCheckConsent, 10).click();
	}

	/**
	 * click on  the payment confirmation button
	 * @author chinnarao.vattam
	 * Updated by saurav.goyal as per discussion with chinnarao.vattam
	 */
	public void clkPaymentConfirm() {
		getReusableActionsInstance().getWhenReady(btnPaymentConfirm, 90).click();
	}
	
	/**
	 * click on  the payment confirmation button
	 * @author chinnarao.vattam
	 * Updated by saurav.goyal as per discussion with chinnarao.vattam
	 */
	public void clkPaymentConfirmMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnPaymentConfirm, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnPaymentConfirm);
	}
	
	/**
	 * click on  the payment confirmation button for Existing Customer
	 * @author chinnarao.vattam
	 */
	public void clkPaymentConfirmExistingCustomer() {
		getReusableActionsInstance().waitForElementTobeClickable(btnPaymentConfirm, 180);
		getReusableActionsInstance().executeJavaScriptClick(btnPaymentConfirm);
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
		getReusableActionsInstance().clickWhenReady(btnContinue);
	}
	
}
