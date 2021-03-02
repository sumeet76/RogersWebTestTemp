package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
	
	@FindBy(xpath =  "//iframe[@id = 'bb_iframe_container bb_iframe' or @id='viewBill_iframe']")
	WebElement frameBillDetails;
	
	@FindBy (xpath = "//div[@translate='bb_error_message_no_bill' or @translate='bb_error_message_header_system_issue']")
	WebElement noBillNote;

	@FindBy (xpath = "//span[@translate='ute.payment.method.history']")
	WebElement lnkPaymentHistory;
	
	@FindBy(xpath = "//*[@translate='ute.common.label.billAndAccountBalance']")
	WebElement lblBillAndAccountBalanceHeader;

	@FindAll({
		@FindBy(xpath = "//span[@class='suspended-message']"),
		@FindBy(xpath = "//div[contains(@class,'warning-msg')]")
	})
	WebElement lblErrorMessageSuspendedAct;

	@FindAll({
			@FindBy (xpath = "//div[@chat-button='live-chat-link-suspended']"),
			@FindBy(xpath = "//div[contains(@class,'warning-chat')]")
	})
	WebElement lnkLiveChat;

	@FindBy(xpath = "//ds-modal//p")
	WebElement lblOnSaveOrPrint;

	@FindBy(xpath = "//ins[@translate='global.label.saveBillPDF']")
	WebElement lnkSaveBillAsPDF;

	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnDownloadBills;

	@FindBy(xpath = "//ds-icon[@name='rds-icon-save']/preceding-sibling::span")
	WebElement lnkSavePdf;

	@FindBy(xpath = "//span[contains(@class,'-success')]")
	WebElement lblSuccess;

	@FindBy(xpath = "//ds-icon[@name='rds-icon-print']//preceding-sibling::span//span")
	WebElement lnkPrintPdf;

	@FindBy(xpath = "//div[contains(@class,'printBillModal-body')]")
	WebElement modalPrintPdf;

	@FindBy(xpath = "//span[@translate='viewBill.viewBillTitle']")
	WebElement lblYourBillAndAccountBalance;

	@FindBy(xpath = "//iframe[@class='viewBill_iframe']")
	WebElement iframeCurrentBill;

	@FindBy(xpath = "//span[contains(text(),'Set up automatic payments') or contains(text(),'Configurer les paiements automatiques')]")
	WebElement linkSetUpAutomaticPayments;

	@FindBy(xpath = "//span[contains(text(),'Change payment method') or contains(text(),'Changer le mode de paiement')]")
	WebElement lnkChangePaymentMethod;


	/**
	 * Verify if the current bill iframe is present or not
	 * @return true if the current bill iframe is displayed else false
	 * @author Saurav.Goyal
	 */
	public Boolean verifyBillIframe() {
		return getReusableActionsInstance().isElementVisible(iframeCurrentBill, 20);
	}


	/**
	 * Click on download bills button
	 * @author Saurav.Goyal
	 */
	public void clkBtnDownloadBills() {
		getReusableActionsInstance().getWhenReady(btnDownloadBills, 20).click();
	}

	/**
	 * Click on link save bill as pdf link
	 * @author Saurav.Goyal
	 */
	public void clkLnkSaveBillAsPdf() {
		getReusableActionsInstance().getWhenReady(lnkSaveBillAsPDF, 20).click();
	}

	/**
	 * Click on save pdf link
	 * @author Saurav.Goyal
	 */
	public void clkLnkSavePdf() {
		getReusableActionsInstance().getWhenReady(lnkSavePdf, 20).click();
	}

	/**
	 * Click on print pdf link
	 * @author Saurav.Goyal
	 */
	public void clkLnkPrintPdf() {
		getReusableActionsInstance().getWhenReady(lnkPrintPdf, 20).click();
	}

	/**
	 * Click on print pdf link
	 * @return true if the print bill modal is displayed else false
	 * @author Saurav.Goyal
	 */
	public Boolean isPrintBillModalDisplayed() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(modalPrintPdf, 30);
		return getReusableActionsInstance().isElementVisible(modalPrintPdf);
	}


	/**
	 * Checks if success message is displayed
	 * @return true if the success message is displayed else false
	 * @author Saurav.Goyal
	 */
	public Boolean isSuccessMessageDisplayed()
	{
		getReusableActionsInstance().waitForElementVisibility(lblSuccess, 30);
		return getReusableActionsInstance().isElementVisible(lblSuccess);
	}

	/**
	 * Checks if the label is present in the modal displayed
	 * @return true if the label is displayed else false
	 * @author Saurav.Goyal
	 */
	public Boolean isModalSaveOrPrintBillDisplayed()
	{
		getReusableActionsInstance().waitForElementVisibility(lblOnSaveOrPrint, 300);
		return getReusableActionsInstance().isElementVisible(lblOnSaveOrPrint);
	}
	/**
	 * Verify the Live chat link in wireless dashboard page
	 * @return true if the Link to live chat is displayed else false
	 * @author Saurav.Goyal
	 */
	public Boolean verifyLinkLiveChat() {
		return getReusableActionsInstance().isElementVisible(lnkLiveChat, 20);
	}

	/**
	 * Verify if the suspend message displayed or not.
	 * @return true if the suspend message displayed else false
	 * @author Saurav.Goyal
	 */
	public boolean verifySuspendMessage() {
		return getReusableActionsInstance().isElementVisible(lblErrorMessageSuspendedAct, 20);
	}

	/**
	 * Checks if the page is loaded or not
	 * @return true if the link is visible else false
	 * @author Saurav.Goyal
	 */
	public Boolean verifyViewBillLoaded() {
		return getReusableActionsInstance().isElementVisible(lblYourBillAndAccountBalance , 30);
	}

	/**
	 * Verify if the account has no bill.
	 * @return true if the account has no bill, else false
	 * @author ning.xue
	 */
	public boolean verifyIfAccountHasNoBill() {
		return getReusableActionsInstance().isElementVisible(noBillNote, 20);

	}

	/**
	 * Switches to the iframe for view bill
	 * @author Mirza.Kamran
	 */
	public void switchToBillViewIframe() {
		getDriver().switchTo().defaultContent();
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(frameBillDetails, 60);
		
	}
	
	/**
	 * Verify if the account bill frame is displayed
	 * @return true if the account has no bill, else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfViewBillFrameDisplayed() {
		return getReusableActionsInstance().isElementVisible(frameBillDetails, 20);

	}
	
	/**
	 * Validates that the Billing and Payment page is loaded successfully
	 * @return true if 'Billing and Payment' title displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyBillingAndPaymentPageLoadIframe() {
 
		return getReusableActionsInstance().isElementVisible(divBillValueNew);
	}
	
	/**
	 * Validates that the Bill is displayed successfully
	 * @return true if 'Sub Total' AND 'Total to Pay' are displayed; else false
	 * @author rajesh.varalli1 
	 */
	public boolean verifyYourBillDisplayedIFrame() {
		//getDriver().switchTo().frame(fraViewBill);
		return (getReusableActionsInstance().isElementVisible(lblTotalToPay));
	}
	
	/**
	 * Scroll the focus to the middle of the view bill page.
	 * @author Ning.Xue
	 */
	public void scrollToMiddlePage() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
	}
	
	/**
	 * Validates the Payment is successful and the Payment Amount processed
	 * @param strAmount - Payment Amount
	 * @return true if Payment Success msg and amount displayed are correct; else false
	 */
	public boolean verifyPaymentSuccessful(String strAmount) {
		return (getReusableActionsInstance().isElementVisible(lblPaymentConfirmationMsg, 60) &&
				lblPaymentConfirmationAmount.getText().trim().replace("$", "").trim().contains(strAmount));
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
	 * Clicks on the payment history reference number header two times for sorting descending
	 * @author Mirza.Kamran
	 */
	public void sortPaymentHistoryTableByReferenceNumberDesc() {
		getReusableActionsInstance().waitForElementTobeClickable(lblRefNumerColumnSort, 30);
		getReusableActionsInstance().executeJavaScriptClick(lblRefNumerColumnSort);
		getReusableActionsInstance().executeJavaScriptClick(lblRefNumerColumnSort);
	}

	/**
	 * Checks the payment history for reference number
	 * @param strRefNumber Reference number string
	 * @return true if reference matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyThePaymentHistoryRecord(String strRefNumber) {
		getReusableActionsInstance().waitForElementTobeClickable(rowPaymentHistoryFirst, 30);
		String strRowText=getReusableActionsInstance().getWhenReady(rowPaymentHistoryFirst).getText();
		return strRowText.contains(strRefNumber);
	}
	
	/**
	 * Checks the payment history for reference number
	 * @param strRefNumber Reference number string
	 * @return true if reference matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyThePaymentHistoryRecordMobile(String strRefNumber) {
		getReusableActionsInstance().waitForElementTobeClickable(rowPaymentHistoryMobile.get(0), 30);
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
		getReusableActionsInstance().getWhenReady(lnkPaymentHistory).click();
	}
	
	/**
	 * Checks if the view bill page header is displayed 
	 * @return true if the header is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewBillPageHeaderDisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lblBillAndAccountBalanceHeader);
	}

	/**
	 *
	 * @return true if manual payment is set up
	 * @author Rohit.Kumar
	 */
	public boolean isManualPaymentEnabled() {

		return getReusableActionsInstance().isElementVisible(linkSetUpAutomaticPayments);
	}

	/**
	 * Clicks on Set up automatic payments link
	 * @author Rohit.Kumar
	 */
	public void clkSetUpAutomaticPaymentsLink() {
		getReusableActionsInstance().clickWhenReady(linkSetUpAutomaticPayments);
	}

	/**
	 * Clicks on Change Payment Method Link link
	 * @author Rohit.Kumar
	 */
	public void clkChangePaymentMethodLink() {
		//getReusableActionsInstance().waitForElementVisibility(lnkChangePaymentMethod, 60);
		//getReusableActionsInstance().executeJavaScriptClick(lnkChangePaymentMethod);

		getReusableActionsInstance().waitForElementTobeClickable(lnkChangePaymentMethod, 60);
		getReusableActionsInstance().clickWhenReady(lnkChangePaymentMethod);
	}



}
