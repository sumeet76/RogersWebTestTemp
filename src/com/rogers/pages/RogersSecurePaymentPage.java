package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath = "//input[@id='paymentAmount']")
	WebElement txtpaymentAmount;
	
	@FindBy(xpath = "//span[contains(@translate,'cardMethod')]")
	WebElement rdbtnPayWithCard;
	
	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;
	
	@FindBy(xpath = "//select[@name='month']")
	WebElement lstExpiryMonth;
	
	@FindBy(xpath = "//select[@name='year']")
	WebElement lstExpiryYear;
	
	@FindBy(xpath = "//input[@id='securityCode']")
	WebElement txtSecurityCode;
	
	@FindBy(xpath = "//button[contains(@translate,'continueAndReview')]")
	WebElement btnReviewAndContinue;
	
	@FindBy(xpath = "//button[contains(@translate,'payNowButtonLabel')]")
	WebElement btnPayNow;
	
	@FindBy(xpath = "//div[contains(@translate,'paymentAmount')]/following-sibling::div")
	WebElement lblPaymentAmount;
	
	@FindBy(xpath = "//div[contains(@translate,'paymentSuccessHeadline')]")
	WebElement lblPaymentSuccessMsg;
	
	@FindBy(xpath = "//button[contains(@class,'doneButton')]")
	WebElement btnDone;
	
	@FindBy(xpath = "//iframe[@id='sema']")
	WebElement fraCardNumber;
	
	@FindBy(xpath = "//div[@translate='ute.payment.ui.payNow.paymentReferenceId']/following-sibling::div")
	WebElement lblReferenceNumber;

	
	/**
	 * Validates the 'Make a Secure Payment' overlay is loaded
	 * @return true if the 'Make a Secure Payment' title is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifySecurePaymentLoad() {
		return getReusableActionsInstance().isElementVisible(lblMakeASecurePayment, 30);
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
	 * Enters the credit/debit card number
	 * @param strCardNumber - Debit/Credit card number
	 * @author rajesh.varalli1
	 */
	public void setCardNumber(String strCardNumber) {
		getDriver().switchTo().frame(fraCardNumber);
		txtCardNumber.sendKeys(strCardNumber);
		getDriver().switchTo().defaultContent();
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
	 * Clicks on the 'Review and Continue' button
	 * @author rajesh.varalli1
	 */
	public void clickReviewAndContinue() {
		getReusableActionsInstance().clickIfAvailable(btnReviewAndContinue, 30);
	}
	
	/**
	 * Clicks on the 'Pay Now' button
	 * @author rajesh.varalli1
	 */
	public void clickPayNow() {
		getReusableActionsInstance().clickIfAvailable(btnPayNow, 60);
	}
	
	/**
	 * Validates the Payment is successful and the Payment Amount processed
	 * @param strAmount - Payment Amount
	 * @return true if Payment Success msg and amount displayed are correct; else false
	 */
	public boolean verifyPaymentSuccessful(String strAmount) {
		getReusableActionsInstance().waitForElementVisibility(lblPaymentSuccessMsg, 60);
		return (getReusableActionsInstance().isElementVisible(lblPaymentSuccessMsg) &&
				lblPaymentAmount.getText().trim().replace("$", "").trim().contains(strAmount));
	}
	
	/**
	 * Clicks on the 'Done' button
	 */
	public void clickDone() {
		getReusableActionsInstance().clickIfAvailable(btnDone);
	}
	
	/**
	 * Returns the reference number after successful transactions
	 * @return string transaction reference number
	 * @author Mirza.Kamran
	 */
	public String getTransactionReferenceNumber() {
	return getReusableActionsInstance().getWhenReady(lblReferenceNumber).getText().trim();
	}
	
}