package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersSecurePaymentPage extends BasePageClass {

	public RogersSecurePaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@translate,'makeAPayment')]")
	WebElement lblMakeASecurePayment;
	
	@FindBy(xpath = "//rss-payment-amount//input[@id='paymentAmount' or contains(@id,'ds-form-input-id')]")
	WebElement txtpaymentAmount;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-1']")
	WebElement txtpaymentAmountNew;
	
	@FindBy(xpath = "//span[contains(@translate,'cardMethod')]")
	WebElement rdbtnPayWithCard;
	
	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;
	
	@FindBy(xpath = "//select[@name='month']")
	WebElement lstExpiryMonth;
	
	@FindBy(xpath = "//select[@name='year']")
	WebElement lstExpiryYear;
	
	@FindBy(xpath = "//input[@id='securityCode' or @formcontrolname='cvc']")
	WebElement txtSecurityCode;
	
	@FindBy(xpath = "//input[@id='securityCode' or @formcontrolname='cvc']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblSecurityCode;
	
	@FindBy(xpath = "//button[contains(@translate,'continueAndReview') or @title='Review and Continue']")
	WebElement btnReviewAndContinue;
	
	@FindBy(xpath = "//button[contains(@translate,'payNowButtonLabel') or @title='Pay Now']")
	WebElement btnPayNow;
	
	@FindBy(xpath = "//div[contains(@translate,'paymentAmount')]/following-sibling::div")
	WebElement lblPaymentAmount;
	
	@FindAll({
	@FindBy(xpath = "//span[text()='Thank you! We received your payment.']"),	
	@FindBy(xpath = "//div[contains(@translate,'paymentSuccessHeadline')]")})
	WebElement lblPaymentSuccessMsg;
	
	@FindBy(xpath = "//button[contains(@class,'doneButton') or @title='Done']")
	WebElement btnDone;
	
	@FindBy(xpath = "//iframe[@id='sema']")
	WebElement fraCardNumber;
	
	@FindBy(xpath = "//ss-semafone-credit-card/iframe")
	WebElement fraCardNumberNew;
	
	@FindBy(xpath = "//div[@translate='ute.payment.ui.payNow.paymentReferenceId']/following-sibling::div")
	WebElement lblReferenceNumber;
		
	@FindBy(xpath = "//rss-payment-message//p[contains(text(),'A confirmation email will be sent')]")
	WebElement lblReferenceNumberNew;

	@FindBy(xpath = "//p[text()='How would you like to pay?' or text()='Comment souhaitez-vous payer?']")
	WebElement lblHowWouldYouPay;

	@FindBy(xpath = "//div/input[@id='expiryDate']")
	WebElement txtExpiry;

	@FindBy(xpath = "//div/input[@id='expiryDate']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblExpiry;
	
	/**
	 * Validates the 'Make a Secure Payment' overlay is loaded
	 * @return true if the 'Make a Secure Payment' title is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifySecurePaymentLoad() {
		return getReusableActionsInstance().isElementVisible(lblMakeASecurePayment, 30);
	}
	
	/**
	 * Validates the 'Make a Secure Payment' overlay is loaded
	 * @return true if the 'Make a Secure Payment' title is displayed; else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyNewMakePaymentViewLoad() {
		return getReusableActionsInstance().isElementVisible(lblHowWouldYouPay, 30);
	}
	
	/**
	 * Enters the Payment Amount
	 * @param strAmount - Payment amount
	 * @author Mirza.Kamran
	 */
	public void setPaymentAmount(String strAmount) {	
				
		getReusableActionsInstance().executeJavaScriptClick(txtpaymentAmount);
		for (int itr = 0; itr < 6; itr++){
			getReusableActionsInstance().getWhenReady(txtpaymentAmount).sendKeys(Keys.DELETE);
			getReusableActionsInstance().getWhenReady(txtpaymentAmount).sendKeys(Keys.BACK_SPACE);
	    }
		getReusableActionsInstance().enterText(txtpaymentAmount,strAmount, 30);
	}
	
	/**
	 * Enters the Payment Amount
	 * @param strAmount - Payment amount
	 * @author Mirza.Kamran
	 */
	public void setPaymentAmountNew(String strAmount) {	
		
		
		/*getReusableActionsInstance().executeJavaScriptClick(txtpaymentAmount); 
		for (int itr = 0; itr < 6; itr++){
			getReusableActionsInstance().getWhenReady(txtpaymentAmount).sendKeys(Keys.DELETE);
			getReusableActionsInstance().getWhenReady(txtpaymentAmount).sendKeys(Keys.BACK_SPACE);
	    }
	    //getReusableActionsInstance().enterText(txtpaymentAmount,strAmount, 30);
	     
	     */
	    
		getReusableActionsInstance().getWhenReady(txtpaymentAmount).clear();
		getReusableActionsInstance().getWhenReady(txtpaymentAmount).sendKeys(strAmount);
		
		
	}
	
	/**
	 * Enters the credit/debit card number
	 * @param strCardNumber - Debit/Credit card number
	 * @author rajesh.varalli1
	 */
	public void setCardNumber(String strCardNumber) {
		//getDriver().switchTo().frame(fraCardNumber);
		txtCardNumber.sendKeys(strCardNumber);
		getDriver().switchTo().defaultContent();
	}
	
	/**
	 * Enters the credit/debit card number
	 * @param strCardNumber - Debit/Credit card number
	 * @author Mirza.Kamran
	 */
	public void setCardNumberNew(String strCardNumber) {		
		getDriver().switchTo().frame(fraCardNumberNew);
				txtCardNumber.sendKeys(strCardNumber);
				getDriver().switchTo().defaultContent();
	}
	
	/**
	 * Selects the Expire Month for the card entered
	 * @param strExpiryMonthYearMMYY - Card Expire Month
	 * @author Mirza.Kamran
	 */
	public void setCardExpiry(String strExpiryMonthYearMMYY) {						
		getReusableActionsInstance().getWhenReady(lblExpiry,20).click();
		getReusableActionsInstance().getWhenVisible(txtExpiry, 30).clear();
		getReusableActionsInstance().getWhenVisible(txtExpiry).sendKeys(strExpiryMonthYearMMYY);
	}
	
	/**
	 * Selects the Expire Month for the card entered
	 * @param strExpiryMonth - Card Expire Month
	 * @author rajesh.varalli1
	 */
	public void setCardExpiryMonth(String strExpiryMonth) {
				
		getReusableActionsInstance().selectWhenReadyByVisibleText(lstExpiryMonth, strExpiryMonth);
	}
	
	/**
	 * Selects the Expire Year for the card entered
	 * @param strExpiryYear - Card Expire Year
	 * @author rajesh.varalli1
	 */
	public void setCardExpiryYear(String strExpiryYear) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(lstExpiryYear, strExpiryYear);
	}
	
	/**
	 * Enters the Security code/CVV for the card
	 * @param strSecurityCode - Security Code/CVV for the card
	 */
	public void setSecurityCode(String strSecurityCode) {
		txtSecurityCode.sendKeys(strSecurityCode);
		txtSecurityCode.sendKeys(Keys.TAB);
	}
	
	/**
	 * Enters the Security code/CVV for the card
	 * @param strSecurityCode - Security Code/CVV for the card
	 * @author Mirza.Kamran
	 */
	public void setSecurityCodeNew(String strSecurityCode) {
		getReusableActionsInstance().getWhenReady(txtSecurityCode).click();
		txtSecurityCode.sendKeys(strSecurityCode);
		txtSecurityCode.sendKeys(Keys.TAB);
	}
	
	/**
	 * Clicks on the 'Review and Continue' button
	 * @author rajesh.varalli1
	 */
	public void clickReviewAndContinue() {
		getReusableActionsInstance().getWhenReady(btnReviewAndContinue, 30).click();
	}
	
	/**
	 * Clicks on the 'Pay Now' button
	 * @author rajesh.varalli1
	 */
	public void clickPayNow() {
		getReusableActionsInstance().getWhenReady(btnPayNow, 60).click();
	}
	
	/**
	 * Validates the Payment is successful and the Payment Amount processed
	 * @param strAmount - Payment Amount
	 * @return true if Payment Success msg and amount displayed are correct; else false
	 */
	public boolean verifyPaymentSuccessful(String strAmount) {
		getReusableActionsInstance().waitForElementVisibility(lblPaymentSuccessMsg, 60);
		return (getReusableActionsInstance().isElementVisible(lblPaymentSuccessMsg) &&
				lblReferenceNumberNew.getText().trim().replace("$", "").trim().contains(strAmount));
	}
	
	/**
	 * Clicks on the 'Done' button
	 */
	public void clickDone() {
		getReusableActionsInstance().clickIfAvailable(btnDone,30);
	}
	
	/**
	 * Returns the reference number after successful transactions
	 * @return string transaction reference number
	 * @author Mirza.Kamran
	 */
	public String getTransactionReferenceNumber() {
	return getReusableActionsInstance().getWhenReady(lblReferenceNumber).getText().trim();
	}
	
	
	/**
	 * Returns the reference number after successful transactions
	 * @return string transaction reference number
	 * @author Mirza.Kamran
	 */
	public String getTransactionReferenceNumberNew() {
	return getReusableActionsInstance().getWhenReady(lblReferenceNumberNew).getText().trim();
	}
}