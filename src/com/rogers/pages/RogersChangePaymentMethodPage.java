package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath = "//button[contains(@translate,'pm_invoice_yes')]")
	WebElement btnCancelAutomaticPayments;

	@FindBy(xpath = "//div[text()='Success! Your payment method has been changed.' or contains(text(),'est fait! Votre mode de paiement a été modifié')]")
	WebElement lblChangePaymentMethodSuccess;
	
	@FindBy(xpath = "//div[@class='current-pm']//div[@class='current-pm-value']/span")
	WebElement lblCurrentPaymentMethod;
	
	@FindBy(xpath = "//md-radio-button[@aria-label='Use a bank account for automatic payments' or @aria-label='Effectuer des paiements automatiques à partir d’un compte bancaire']")
	WebElement optBankAccount;
	
	@FindBy(xpath = "//md-radio-button[contains(@aria-label,'credit card for automatic paymentsVisa Debit and Debit Mastercard are accepted') or contains(@aria-label,'Effectuer des paiements automatiques à partir d’un compte de carte')]")
	WebElement optCardAccount;
	
	@FindBy(xpath = "//md-radio-button[@aria-label='Switch to manual payments' or @aria-label='Passer au paiement manuel']")
	WebElement optManualPayments;
	
	@FindBy(xpath = "//button[@translate='ute.payment.method.pm_invoice_yes']")
	WebElement btnYesCancelAutoPayment;

	@FindBy(xpath = "//input[@id='transitNo']")
	WebElement txtTransit;
	
	@FindBy(xpath = "//input[@id='bankCode']")
	WebElement txtInstitution;
	
	@FindBy(xpath = "//input[@id='accountNo']")
	WebElement txtAccount;
	
	@FindBy(xpath = "//button[@translate='ute.payment.method.manual_payment_continue']")	
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='confirm-review']/button[@translate='ute.payment.method.manual_payment_continue']")
	WebElement btnContinueOnSecuredCC;
	
	@FindBy(xpath = "//span[text()='I accept the terms and conditions' or contains(text(),'accepte les modalités')]")
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
	
	@FindBy(xpath = "//div[@translate='ute.payment.method.pm_payment_for_next_billing_month_heading']")
	WebElement lblYouAutomaticPaymentWillStart;
	
	@FindBy(xpath = "//button[@translate='ute.payment.method.pm_done' or @translate='ute.payment.method.close_button']")
	WebElement btnDone;
	
	@FindBy(xpath = "//button[@translate='ute.payment.method.pm_done']")
	WebElement btnChangePaymentDone;

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
	
	/**
	 * Validates that the 'Change Payment Method' overlay is loaded successfully
	 * @return true if 'Change Payment Method' title is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePaymentMethodLoad() {
		return reusableActions.isElementVisible(lblChangePaymentMethod,30);
	}
	
	
	/**
	 * Clicks on the 'Yes, cancel automatic payments' button
	 * @author rajesh.varalli1
	 */
	public void clkYesCancelAutomaticPayment() {
		reusableActions.clickIfAvailable(btnCancelAutomaticPayments,30);
	}
	
	/**
	 * Validates if the Change Payment Method to Manual is successful
	 * @return true if Success Message is displayed AND Payment Method is Manual Payment; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePaymentMethodToManual() {
		return (reusableActions.isElementVisible(lblChangePaymentMethodSuccess, 60) &&(
				lblCurrentPaymentMethod.getText().equals("Manual payments")
				|| lblCurrentPaymentMethod.getText().equals("Paiements manuels")));
	}

	/**
	 * Click on Bank account radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseBankAccountForAutomaticPayments() {
		reusableActions.waitForElementVisibility(optBankAccount, 60);		
		reusableActions.clickWhenReady(optBankAccount);
	}
	
	/**
	 * Click on CC card radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseCCForAutomaticPayments() {
		reusableActions.waitForElementVisibility(optCardAccount, 60);		
		reusableActions.executeJavaScriptClick(optCardAccount);
	}
	
	/**
	 * Click on Switch to manual payments
	 * @author Mirza.Kamran
	 */
	public void clkSwitchToManualPayments() {
		reusableActions.waitForElementVisibility(optManualPayments, 60);		
		reusableActions.executeJavaScriptClick(optManualPayments);
	}

	/**
	 * Click on card radio button
	 * @author Mirza.Kamran
	 */
	public void clkUseCardForAutomaticPayments() {
		reusableActions.waitForElementVisibility(optCardAccount, 60);
		reusableActions.executeJavaScriptClick(optCardAccount);
	}

	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of Pre-Auth credit card for payment
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumber(String strAccountNumber) {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSemaphone, 30);
		reusableActions.getWhenReady(txtCardNumber,40).click();
		reusableActions.getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
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
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Selects the credit card expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateMonth();
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
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the expire year of Pre-Auth credit card
	 * @param strYYYY expire year of Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		reusableActions.selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}
	
	
	/**
	 * Set the bank transit code
	 * @param strTransitCode string transit code
	 * @author Mirza.Kamran
	 */
	public void setTransitCode(String strTransitCode) {
		reusableActions.waitForElementVisibility(txtTransit, 60);
		reusableActions.getWhenReady(txtTransit).sendKeys(strTransitCode);;
		
	}

	/**
	 * Set the bank code or institution code
	 * @param strBankCode string bank code
	 * @author Mirza.Kamran
	 */
	public void setBankCode(String strBankCode) {
		reusableActions.waitForElementVisibility(txtInstitution, 60);
		reusableActions.getWhenReady(txtInstitution).sendKeys(strBankCode);;		
	}
	
	/**
	 * Set the bank account number
	 * @param strAccountNumber string account number
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strAccountNumber) {
		reusableActions.waitForElementVisibility(txtAccount, 60);
		reusableActions.getWhenReady(txtAccount).sendKeys(strAccountNumber);
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(txtAccount).sendKeys(Keys.TAB);
		reusableActions.staticWait(1000);
	}

	/**
	 * Click on the continue button
	 * @author Mirza.Kamran
	 */
	public void clkContinue() {
		reusableActions.waitForElementTobeClickable(btnContinue, 60);
		reusableActions.executeJavaScriptClick(btnContinue);
	}
	
	/**
	 * Click on the TnC checkbox
	 * @author Mirza.Kamran
	 */
	public void clkTermsAndCond() {
		reusableActions.clickWhenReady(chkTnC);
	}
	
	/**
	 * Click on button submit
	 * @author Mirza.Kamran
	 */
	public void clkSubmit() {
		reusableActions.clickWhenReady(btnSubmit);
	}
	
	/**
	 * verify if the label success header is displayed
	 * @return true if the label is displayed hence false
	 * @author Mirza.Kamran
	 */
	public boolean verifySuccessMessageIsDisplayed() {
		reusableActions.waitForElementVisibility(lblSuccessHeader);
		return (reusableActions.isDisplayed(lblSuccessHeader) && reusableActions.isDisplayed(lblYouAutomaticPaymentWillStart));
	}
	
	/**
	 * Click on Done button
	 * @author Mirza.Kamran 
	 */
	public void clkOnDone() {
	reusableActions.executeJavaScriptClick(btnDone);
	}	
	
	/**
	 * Clicks on the Cancel Auto payments
	 */
	public void clkButtoncancelAutoPayment() {
		reusableActions.clickWhenReady(btnYesCancelAutoPayment);
	}
	
	/**
	 * Clicks on the button change payment done 
	 * @author Mirza.Kamran
	 */
	public void clkButtonDoneChangePayment() {
		reusableActions.clickIfAvailable(btnChangePaymentDone);
	}
	
    /**
     * Checks if the CC Secured msg displayed
     * @return true if the message is displayed else false
     * @author Mirza.Kamran
     */
	public Boolean labelCCDetailsWillBeKeptEncryptedMsgDisplayed() {
		return reusableActions.isDisplayed(lblCreditCardSecuredMsg);
	}
		
	/**
	 * Verifies if the CC details is displayed in secured mode
	 * @return true if the secured cc details displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isCCSecuredAreaDisplayed() {
		return (reusableActions.isDisplayed(lblCCheader)
				&& reusableActions.isDisplayed(lblCCNumber)
				&& reusableActions.isDisplayed(lblExpiryDate));
	}

	/**
	 * Clicks on continue button on Review page
	 * @author Mirza.Kamran
	 */
	public void clkContinueOnReviewPg() {
		reusableActions.executeJavaScriptClick(btnContinueOnSecuredCC);
		
	}	
	
}