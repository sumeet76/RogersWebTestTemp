package com.rogers.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBillingPage extends BasePageClass {

	public RogersBillingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(@translate,'billAndPayment')]")
	WebElement lblBillingAndPayment;
	
	@FindBy(xpath = "//iframe[@data-test-id='myr-viewBill-briteBillIFrame']")
	WebElement fraViewBill;
	
	//@FindBy(xpath = "//*[@id='bb-bill-summary-page']//bb-bs-grand-total//span[text()='Total' or text()='']/parent::div/bb-amount")
	//@FindBy(xpath = "//*[@id='bb-bill-summary-page']//div[@class='bb-bs-grand-total']")
	@FindBy(xpath = "//*[@class='bb-bs-grand-total']")
	WebElement lblTotalToPay;
	
	@FindBy(xpath = "//span[contains(@data-translate,'payNow.thankYouMessage')]")
	WebElement lblPaymentConfirmationMsg;
	
	@FindBy(xpath = "//span[contains(@data-translate,'payNow.thankYouMessage')]/following-sibling::span[1]")
	WebElement lblPaymentConfirmationAmount;

	@FindBy(xpath = "//div[@data-translate='ute.payment.ui.payNow.paymentReferenceId']/following-sibling::div")
	WebElement lblReferenceNumber;
		
	@FindBy(xpath = "//div[@class='history-list']//div[ @class='sorting-column']/span[@translate='history_payment_reference']")
	WebElement lblRefNumerColumnSort;

	@FindBy(xpath = "//div[@class='row pbm payment-item'][1]")
	WebElement rowPaymentHistoryFirst;
		
	@FindBy(xpath = "//span[@translate='history_payment_amount']/ancestor::div[contains(@data-ng-repeat,'payment in histories')]")
	List<WebElement> rowPaymentHistoryMobile;
	
	//@FindBy(xpath = "//*[@id='bb-bs-bill-total']//div[@class='text-right title-right-part']/bb-amount")
	@FindBy(xpath = "//*[@id='bb-bs-bill-total']")
	WebElement divBillValueNew;
	
	@FindBy(id = "bb_iframe_container bb_iframe")
	WebElement frameBillDetails;
	
	@FindBy (xpath = "//div[@translate='bb_error_message_no_bill']")
	WebElement noBillNote;

	@FindBy (xpath = "//span[@translate='ute.payment.method.history']")
	WebElement lnkPaymentHistory;
	
	/**
	 * Verify if the account has no bill.
	 * @return true if the account has no bill, else false
	 * @author ning.xue
	 */
	public boolean verifyIfAccountHasNoBill() {
		return reusableActions.isElementVisible(noBillNote, 20);

	}

	/**
	 * Switches to the iframe for view bill
	 * @author Mirza.Kamran
	 */
	public void switchToBillViewIframe() {
		reusableActions.getDriver().switchTo().defaultContent();
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(frameBillDetails, 60);
		
	}
	
	/**
	 * Verify if the account bill frame is displayed
	 * @return true if the account has no bill, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfViewBillFrameDisplayed() {
		return reusableActions.isElementVisible(frameBillDetails, 20);

	}
	
	/**
	 * Validates that the Billing and Payment page is loaded successfully
	 * @return true if 'Billing and Payment' title displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyBillingAndPaymentPageLoadIframe() {
 
		return reusableActions.isElementVisible(divBillValueNew);
	}
	
	/**
	 * Validates that the Bill is displayed successfully
	 * @return true if 'Sub Total' AND 'Total to Pay' are displayed; else false
	 * @author rajesh.varalli1 
	 */
	public boolean verifyYourBillDisplayedIFrame() {
		//driver.switchTo().frame(fraViewBill);
		return (reusableActions.isElementVisible(lblTotalToPay));
	}
	
	/**
	 * Scroll the focus to the middle of the view bill page.
	 * @author Ning.Xue
	 */
	public void scrollToMiddlePage() {
		reusableActions.javascriptScrollToMiddleOfPage();
	}
	
	/**
	 * Validates the Payment is successful and the Payment Amount processed
	 * @param strAmount - Payment Amount
	 * @return true if Payment Success msg and amount displayed are correct; else false
	 */
	public boolean verifyPaymentSuccessful(String strAmount) {
		return (reusableActions.isElementVisible(lblPaymentConfirmationMsg, 60) &&
				lblPaymentConfirmationAmount.getText().trim().replace("$", "").trim().contains(strAmount));
	}
	
	/**
	 * Returns the reference number after successful transactions
	 * @return string transaction reference number
	 * @author Mirza.Kamran
	 */
	public String getTransactionReferenceNumber() {
	return reusableActions.getWhenReady(lblReferenceNumber).getText().trim();	
	}
	
	/**
	 * Clicks on the payment history reference number header two times for sorting descending
	 * @author Mirza.Kamran
	 */
	public void sortPaymentHistoryTableByReferenceNumberDesc() {
		reusableActions.waitForElementTobeClickable(lblRefNumerColumnSort, 30);
		reusableActions.executeJavaScriptClick(lblRefNumerColumnSort);
		reusableActions.executeJavaScriptClick(lblRefNumerColumnSort);
	}

	/**
	 * Checks the payment history for reference number
	 * @param strRefNumber Reference number string
	 * @return true if reference matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyThePaymentHistoryRecord(String strRefNumber) {
		reusableActions.waitForElementTobeClickable(rowPaymentHistoryFirst, 30);
		String strRowText=reusableActions.getWhenReady(rowPaymentHistoryFirst).getText();
		return strRowText.contains(strRefNumber);
	}
	
	/**
	 * Checks the payment history for reference number
	 * @param strRefNumber Reference number string
	 * @return true if reference matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyThePaymentHistoryRecordMobile(String strRefNumber) {
		reusableActions.waitForElementTobeClickable(rowPaymentHistoryMobile.get(0), 30);
		for (WebElement row : rowPaymentHistoryMobile) {
			if(row.getText().contains(strRefNumber))
			{
				return true;				
			}
		}		
		return false;
	}
	
	
	/**
	 * This method is to switch out of the Bill view Iframe
	 * @author Saurav.Goyal
	 */
	public void switchOutOfBillViewIframe() {
	  	getDriver().switchTo().defaultContent();
  }

	/**
	 * Clicks on payment history link
	 * @author Mirza.Kamran
	 */
	public void clkPaymentHistoryLink() {
		reusableActions.getWhenReady(lnkPaymentHistory).click();
	}
}
