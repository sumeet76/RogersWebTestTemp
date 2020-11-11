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
		return getReusableActionsInstance().isElementVisible(lblChangePaymentMethod,30);
	}
	
	
	/**
	 * Clicks on the 'Yes, cancel automatic payments' button
	 * @author rajesh.varalli1
	 */
	public void clkYesCancelAutomaticPayment() {
		getReusableActionsInstance().clickIfAvailable(btnCancelAutomaticPayments,30);
	}
	
	/**
	 * Validates if the Change Payment Method to Manual is successful
	 * @return true if Success Message is displayed AND Payment Method is Manual Payment; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePaymentMethodToManual() {
		return (getReusableActionsInstance().isElementVisible(lblChangePaymentMethodSuccess, 60) &&(
				lblCurrentPaymentMethod.getText().equals("Manual payments")
				|| lblCurrentPaymentMethod.getText().equals("Paiements manuels")));
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
		getReusableActionsInstance().waitForElementVisibility(txtTransit, 60);
		getReusableActionsInstance().getWhenReady(txtTransit).sendKeys(strTransitCode);;
		
	}

	/**
	 * Set the bank code or institution code
	 * @param strBankCode string bank code
	 * @author Mirza.Kamran
	 */
	public void setBankCode(String strBankCode) {
		getReusableActionsInstance().waitForElementVisibility(txtInstitution, 60);
		getReusableActionsInstance().getWhenReady(txtInstitution).sendKeys(strBankCode);;
	}
	
	/**
	 * Set the bank account number
	 * @param strAccountNumber string account number
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strAccountNumber) {
		getReusableActionsInstance().waitForElementVisibility(txtAccount, 60);
		getReusableActionsInstance().getWhenReady(txtAccount).sendKeys(strAccountNumber);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().getWhenReady(txtAccount).sendKeys(Keys.TAB);
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
		getReusableActionsInstance().clickWhenReady(btnSubmit);
	}
	
	/**
	 * verify if the label success header is displayed
	 * @return true if the label is displayed hence false
	 * @author Mirza.Kamran
	 */
	public boolean verifySuccessMessageIsDisplayed() {
		getReusableActionsInstance().waitForElementVisibility(lblSuccessHeader);
		return (getReusableActionsInstance().isElementVisible(lblSuccessHeader) && getReusableActionsInstance().isElementVisible(lblYouAutomaticPaymentWillStart));
	}
	
	/**
	 * Click on Done button
	 * @author Mirza.Kamran 
	 */
	public void clkOnDone() {
	getReusableActionsInstance().executeJavaScriptClick(btnDone);
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
		getReusableActionsInstance().clickIfAvailable(btnChangePaymentDone);
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
		getReusableActionsInstance().executeJavaScriptClick(btnContinueOnSecuredCC);
		
	}	
	
}