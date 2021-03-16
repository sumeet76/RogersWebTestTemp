package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChangePaymentMethodPage extends BasePageClass {

	public RogersChangePaymentMethodPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='Change payment method' or text()='Set up automatic payments' or contains(text(),'des paiements')]")
	WebElement lblChangePaymentMethod;
	
	@FindBy(xpath = "//md-radio-button[@aria-label='Switch to manual payments' or @aria-label='Passer au paiement manuel']")
	WebElement rdbtnSwitchToManualPayments;
	
	@FindBy(xpath = "//rss-invoice-payment-method-review//button[@title='continue']")
	WebElement btnCancelAutomaticPayments;

	@FindBy(xpath = "//*[text()='Success! Your payment method has been changed.' or contains(text(),'est fait! Votre mode de paiement a été modifié')]")
	WebElement lblChangePaymentMethodSuccess;
	
	@FindBy(xpath = "//div[@class='current-pm']//div[@class='current-pm-value']/span")
	WebElement lblCurrentPaymentMethod;
	
	@FindBy(xpath = "//span[contains(text(),'Use a bank account for automatic payments') or contains(text(),' Effectuer des paiements automatiques à partir d’un compte bancaire ')]/ancestor::label")
	WebElement optBankAccount;
	
	@FindBy(xpath = "//span[contains(text(),' Use a credit card for automatic payments ') or contains(text(),' Effectuer des paiements automatiques à partir d’un compte de carte de crédit ')]/ancestor::label")
	WebElement optCardAccount;
	
	@FindBy(xpath = "//span[contains(text(),'Change to manual payments')]/ancestor::label")
	WebElement optManualPayments;
	
	@FindBy(xpath = "//span[contains(text(),' Yes, cancel automatic payments')]/ancestor::button")
	WebElement btnYesCancelAutoPayment;

	@FindBy(xpath = "//input[@formcontrolname='transit']")
	WebElement txtTransit;
		
	@FindBy(xpath = "//input[@formcontrolname='transit']/parent::div")
	WebElement lblTransit;
	
	@FindBy(xpath = "//input[@id='bankCode' or @formcontrolname='institution']")
	WebElement txtInstitution;
	
	@FindBy(xpath = "//input[@id='bankCode' or @formcontrolname='institution']/parent::div")
	WebElement lblInstitution;
	
	@FindBy(xpath = "//input[@id='accountNo' or @formcontrolname='account']")
	WebElement txtAccount;
	
	@FindBy(xpath = "//input[@id='accountNo' or @formcontrolname='account']/parent::div")
	WebElement lblAccount;
	
	@FindAll({		
	@FindBy(xpath = "//span[text()=' Continue ']"),
	@FindBy(xpath = "//button[@translate='ute.payment.method.manual_payment_continue']")})	
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='confirm-review']/button[@translate='ute.payment.method.manual_payment_continue']")
	WebElement btnContinueOnSecuredCC;
	
	@FindBy(xpath = "//rss-setup-payment-terms-and-conditions//span[@translate='payment.setup-pay-through-bank.agree-checkbox']")
	WebElement chkTnC;
	
	@FindBy(xpath = "//div[@translate='ute.payment.method.pm_cc_secure_message']")
	WebElement lblCreditCardSecuredMsg;		
	
	@FindBy(xpath = "//div[@translate='ute.payment.method.pm_cc_header']")
	WebElement lblCCheader;
			
	@FindBy(xpath = "//div[@class='cc-image-number']")
	WebElement lblCCNumber;
			
	@FindBy(xpath = "//div[@class='cc-expiry-section']")
	WebElement lblExpiryDate;
	
	@FindBy(xpath = "//button[text()='Submit' or text()='Soumettre']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@class='pm-success-text-content']/div[@class='success-header-text']")
	WebElement lblSuccessHeader;
	
	@FindBy(xpath = "//span[text()='Success! Starting next month your bill payments will be made automatically.' or text()='C’est réussi! À partir du mois prochain, vos paiements de facture se feront automatiquement.']")
	WebElement lblYouAutomaticPaymentWillStart;
	
	@FindBy(xpath = "//button[@translate='ute.payment.method.pm_done' or @translate='ute.payment.method.close_button']")
	WebElement btnDone;
	
	@FindBy(xpath = "//span[contains(text(),'Done') or contains(text(),'Terminé')]/ancestor::button")
	WebElement btnChangePaymentDone;
	
	@FindBy(xpath = "//span[contains(text(),'Success! Your payment method has been changed.')]/ancestor::p")
	WebElement msgChangePaymentSuccess;

	@FindBy(id = "sema")
	WebElement fraSemaphone;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindBy(id = "securityCode")
	WebElement txtCVV;

	@FindBy(xpath = "//select[@name='month']")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//select[@name='year']")
	WebElement ddlExpiryYear;

	@FindBy(xpath = "//ss-credit-card/following-sibling::div//button[@title='Continue' or @title='Continuer']")
	WebElement btnContinueSetCC;
	
	@FindBy(xpath = "//rss-setup-payment-terms-and-conditions//button[@title='Continue' or @title='Continuer']")
	WebElement btnSubmitTnC;
	
	@FindBy(xpath = "//rss-payment-card-detail-review/following-sibling::div//button[@title='Continue' or @title='Continuer']")
	WebElement btnContinueReview;

	@FindBy(xpath = "//p[text()='2. Review' or text()='2. Vérification']")
	WebElement lblReview;

	@FindBy(xpath = "//ds-picture/following-sibling::div//button[@title='Continue' or @title='Continuer']")
	WebElement btnContinueBank;
	
	/**
	 * Validates that the 'Change Payment Method' overlay is loaded successfully
	 * @return true if 'Change Payment Method' title is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePaymentMethodLoad() {
		return getReusableActionsInstance().isElementVisible(lblChangePaymentMethod,30);
	}
	
	
	/**
	 * Clicks on the 'Yes, cancel automatic payments' button
	 * @author rajesh.varalli1
	 */
	public void clkYesCancelAutomaticPayment() {
		getReusableActionsInstance().clickIfAvailable(btnContinue);
		getReusableActionsInstance().clickIfAvailable(btnCancelAutomaticPayments,30);
	}
	
	/**
	 * Validates if the Change Payment Method to Manual is successful
	 * @return true if Success Message is displayed AND Payment Method is Manual Payment; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePaymentMethodToManual() {
		return getReusableActionsInstance().isElementVisible(lblChangePaymentMethodSuccess, 60);
	}

	/**
	 * Click on Bank account radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseBankAccountForAutomaticPayments() {
		getReusableActionsInstance().waitForElementVisibility(optBankAccount, 60);
		getReusableActionsInstance().clickWhenReady(optBankAccount);
	}
	
	/**
	 * Click on CC card radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseCCForAutomaticPayments() {
		getReusableActionsInstance().waitForElementVisibility(optCardAccount, 60);
		getReusableActionsInstance().executeJavaScriptClick(optCardAccount);
	}
	
	/**
	 * Click on Switch to manual payments
	 * @author Mirza.Kamran
	 */
	public void clkSwitchToManualPayments() {
		getReusableActionsInstance().waitForElementVisibility(optManualPayments, 60);
		getReusableActionsInstance().executeJavaScriptClick(optManualPayments);
	}

	/**
	 * Click on card radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseCardForAutomaticPayments() {
		getReusableActionsInstance().waitForElementVisibility(optCardAccount, 60);
		getReusableActionsInstance().executeJavaScriptClick(optCardAccount);
	}

	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of Pre-Auth credit card for payment
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumber(String strAccountNumber) {
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraSemaphone, 30);
		getReusableActionsInstance().getWhenReady(txtCardNumber,40).click();
		getReusableActionsInstance().getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Set the dynamic CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		getReusableActionsInstance().clickWhenVisible(txtCVV);
		getReusableActionsInstance().getWhenReady(txtCVV).sendKeys(strCVV);
	}

	/**
	 * Selects the credit card expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateMonth();
		getReusableActionsInstance().selectWhenReady(ddlExpiryYear, strYYYY);
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
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the expire year of Pre-Auth credit card
	 * @param strYYYY expire year of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}
	
	
	/**
	 * Set the bank transit code
	 * @param strTransitCode string transit code
	 * @author Mirza.Kamran
	 */
	public void setTransitCode(String strTransitCode) {
		getReusableActionsInstance().waitForElementVisibility(lblTransit, 60);
		getReusableActionsInstance().clickIfAvailable(lblTransit);
		getReusableActionsInstance().getWhenReady(txtTransit).sendKeys(strTransitCode);;
		
	}

	/**
	 * Set the bank code or institution code
	 * @param strBankCode string bank code
	 * @author Mirza.Kamran
	 */
	public void setBankCode(String strBankCode) {
		getReusableActionsInstance().waitForElementVisibility(lblInstitution, 60);
		getReusableActionsInstance().clickIfAvailable(lblInstitution);
		getReusableActionsInstance().getWhenReady(txtInstitution).sendKeys(strBankCode);;
	}
	
	/**
	 * Set the bank account number
	 * @param strAccountNumber string account number
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strAccountNumber) {
		getReusableActionsInstance().waitForElementVisibility(lblAccount, 60);
		getReusableActionsInstance().clickIfAvailable(lblAccount);
		getReusableActionsInstance().getWhenReady(txtAccount).sendKeys(strAccountNumber);
		getReusableActionsInstance().staticWait(1000);

	}

	/**
	 * Click on the continue button
	 * @author Mirza.Kamran
	 */
	public void clkContinue() {
		getReusableActionsInstance().waitForElementTobeClickable(btnContinue, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnContinue);
	}
	
	/**
	 * Click on the TnC checkbox
	 * @author Mirza.Kamran
	 */
	public void clkTermsAndCond() {
		getReusableActionsInstance().clickWhenReady(chkTnC);
	}
	
	/**
	 * Click on button submit
	 * @author Mirza.Kamran
	 */
	public void clkSubmit() {
		getReusableActionsInstance().clickWhenReady(btnSubmitTnC);
	}
	
	/**
	 * verify if the label success header is displayed
	 * @return true if the label is displayed hence false
	 * @author Mirza.Kamran
	 */
	public boolean verifySuccessMessageIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblYouAutomaticPaymentWillStart,60);
	}
	
	/**
	 * Click on Done button
	 * @author Mirza.Kamran 
	 */
	public void clkOnDone() {
	getReusableActionsInstance().getWhenReady(btnChangePaymentDone).click();
	}	
	
	/**
	 * Clicks on the Cancel Auto payments
	 */
	public void clkButtoncancelAutoPayment() {
		getReusableActionsInstance().clickWhenReady(btnYesCancelAutoPayment);
	}
	
	/**
	 * Clicks on the button change payment done 
	 * @author Mirza.Kamran
	 */
	public void clkButtonDoneChangePayment() {
		getReusableActionsInstance().getWhenReady(btnChangePaymentDone,60).click();
	}
	
    /**
     * Checks if the CC Secured msg displayed
     * @return true if the message is displayed else false
     * @author Mirza.Kamran
     */
	public Boolean labelCCDetailsWillBeKeptEncryptedMsgDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblCreditCardSecuredMsg);
	}
		
	/**
	 * Verifies if the CC details is displayed in secured mode
	 * @return true if the secured cc details displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isCCSecuredAreaDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lblCCheader)
				&& getReusableActionsInstance().isElementVisible(lblCCNumber)
				&& getReusableActionsInstance().isElementVisible(lblExpiryDate));
	}

	/**
	 * Clicks on continue button on Review page
	 * @author Mirza.Kamran
	 */
	public void clkContinueOnReviewPg() {
		getReusableActionsInstance().getWhenReady(btnContinueReview).click();
		
	}

	/*
	 * 
	 */
	public void clkContinueSettingCC() {
		getReusableActionsInstance().getWhenReady(btnContinueSetCC).click();
	}


	/**
	 * 
	 * @return
	 */
	public boolean isReviewCCDetailsPageDisplayed() {
		// TODO Auto-generated method stub
		return getReusableActionsInstance().isElementVisible(lblReview);
	}

	/**
	 * 
	 */
	public void clkContinueBank() {
		getReusableActionsInstance().getWhenReady(btnContinueBank).click();
	}	
	
}