package com.rogers.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersMakePaymentPage extends BasePageClass {

	public RogersMakePaymentPage(WebDriver driver) {
		super(driver);
	}

	public enum MakePayOptions {
	    Bank,
	    credit,
	    Interac
	  }
	
	@FindBy(xpath = "//select[@ng-model='props.selectedPaymentOption']")
	WebElement ddlPaymentMode;

	@FindBy(xpath = "//label[@for='paper_method']")
	WebElement rdoPaperbill;

	@FindBy(xpath = "//button[@translate='global.cta.confirm']")
	WebElement btnPaymentConfirm;
	
	@FindBy(xpath = "//div[@class='semafone-container']//descendant::iframe")
	WebElement fraSemaphone;  
	
	@FindBy(xpath="//div[@class='cc-payment-section']//descendant::iframe")
	WebElement fraCC;

	@FindBy(xpath = "//input[@class='semafonemandatory']")
	WebElement txtCardNumber;

	@FindBy(id = "expiry-date")
	WebElement ddlExpiryMonth;

	@FindBy(name = "expYear")
	WebElement ddlExpiryYear;

	@FindBy(id = "cvv")
	WebElement txtCVV;
	
	@FindBy(xpath="//*[@id='paymentAmount']")
	WebElement txtAmount;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//ins[@translate='global.cta.updatePaymentMethod']")
	WebElement btnUpdatePaymentMethod;
	
	@FindBy(name="transitCode")
	WebElement txtTransitCode;
	
	@FindBy(id="bank-code")
	WebElement txtBankCode;
	
	@FindBy(id="account-number")
	WebElement txtbankAccountNumber;
	
	@FindBy(xpath="//label[@for='agree-to-terms-and-conditions']")
	WebElement chkAgreeTermsAndCond;
	
	@FindBy(xpath = "//*[@id='terms-conditions-scroll']/ins/div/ins/p[7]")
	WebElement lbltermsAndConditionBottom;
	
	@FindBy(xpath="//div[@class='pay-now-modal']//input[@value='Review & continue' or @value='Vérifier et continuer']")
	WebElement btnReviewAndContinue;

	@FindBy(xpath="//div[@class='pay-now-modal']//ins[@translate='global.cta.payNow']")
	WebElement btnPayNow;
	
	@FindBy(xpath="//ins[@translate='global.label.paymentConfirmationHeading']")
	WebElement lblPaymentReceived;
	
	@FindBy(xpath="//div[@class='pay-now-modal']//ins[@translate='global.cta.done']")
	private WebElement btnDone;
	
	@FindBy(xpath="//div[@class='pay-now-modal']//ins[@translate='global.cta.payIntreac']")
	WebElement btnPayOntheInteracSite;
	
	@FindBy(xpath="//div[@class='pay-now-payment-text']")
	WebElement paymentAmount;
	
	@FindBy(xpath="//div[@ng-if='paymentReferenceNumberExists']//div[@class='pay-now-payment-text uppercase']")
	WebElement lblRefrenceNumber;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12 hidden-xs']//ins[@translate='global.label.paymentHistoryView']")
	WebElement btnPaymentHistory;
	
	@FindBy(xpath="//div[@class='pay-now-modal']/div[@class='modal-header hidden-xs']/div/button[@class='close square-close-icon']")
	WebElement btnCloseMakePayment;
	
	
	@FindBy(xpath = "//div[@class='bank-section']")
	WebElement divBankPayment;
	
	
	@FindBy(xpath = "//div[contains(@class,'hidden-xs')]//ins[@translate='global.label.paymentHistoryView']")
	WebElement lnkPaymentHistoryOnConfirmationPageFooter;

	@FindBy(xpath = "//span[@translate='ute.payment.ui.payNow.bankMethod']")
	WebElement rdoBank;

	@FindBy(xpath = "//span[@translate='ute.payment.ui.payNow.cardMethod']")
	WebElement rdoCredit;

	@FindBy(xpath = "//span[@translate='ute.payment.ui.payNow.interacMethod']")
	WebElement rdoInterac;

	@FindBy(xpath = "//div[@class='bpi-bank-image']")
	WebElement imgSelectedbank;
	
	
	
	/**
	 * Set the Pre-Auth credit card at semaphone frame on the payment options page
	 * @param strAccountNumber account number of the Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumber(String strAccountNumber) {	
		getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraCC));
		getReusableActionsInstance().clickWhenVisible(txtCardNumber);
		getReusableActionsInstance().getWhenReady(txtCardNumber).sendKeys(strAccountNumber);
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateMonth();
		getReusableActionsInstance().selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * Set the CVV for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCVV() {
		String strCVV = FormFiller.generateCVVNumber();
		getReusableActionsInstance().clickWhenVisible(txtCVV);
		getReusableActionsInstance().getWhenReady(txtCVV).sendKeys(strCVV);

	}
	
	/**
	 * Selects the expire year for Pre-Auth credit card
	 * @param strYYYY expire year for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}

	/**
	 * Selects the expire month for Pre-Auth credit card
	 * @param strMM expire month for Pre-Auth credit card
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardxpiryMonth(String strMM) {
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
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
	 * Set the payment amount on Fido payment page
	 * @param strAmount amount to be paid
	 * @author chinnarao.vattam
	 */
	public void setPaymentAmount(String strAmount){
		getReusableActionsInstance().clickIfAvailable(txtAmount);
		//The default wrapper is not working on French hence added below line
		getReusableActionsInstance().enterText(txtAmount,Keys.chord(Keys.CONTROL,"a", Keys.DELETE), 30);
		getReusableActionsInstance().enterText(txtAmount,strAmount, 30);
	}
	
	/**
	 * Selects the payment modes (pac, pacc, invoice) on the payment options page
	 * @param payOption payment option to pay to buy Internet offer
	 * @author Mirza.Kamran
	 */
	public void selectHowWouldYouLikeToPay(MakePayOptions payOption) {
		//writing the below element in method since we want to dynamically generate this at run time
		if(payOption.toString().toLowerCase().equals("bank"))
		{
			getReusableActionsInstance().javascriptScrollByVisibleElement(rdoBank);
			getReusableActionsInstance().executeJavaScriptClick(rdoBank);
			
		}else if(payOption.toString().toLowerCase().equals("credit"))
		{
			getReusableActionsInstance().javascriptScrollByVisibleElement(rdoCredit);
			getReusableActionsInstance().executeJavaScriptClick(rdoCredit);
			
		}else if(payOption.toString().toLowerCase().equals("interac"))
		{
			getReusableActionsInstance().javascriptScrollByVisibleElement(rdoInterac);
			getReusableActionsInstance().executeJavaScriptClick(rdoInterac);
		}
								
	}
	
	
	
	/**
	 * Click on  the Review And Continue button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkReviewAndContinueButton()
	{	
		Actions act=new Actions(getDriver());
		act.moveToElement(getReusableActionsInstance().getWhenReady(btnReviewAndContinue)).click().build().perform();

	}
	
	/**
	 * Click on  the Paynow button on the make payment page
	 * @author Aditya.Dhingra
	 */
	public void clkPayNow()
	{		
		Actions act=new Actions(getDriver());
		act.moveToElement(getReusableActionsInstance().getWhenReady(btnPayNow)).click().build().perform();

	}
	
	/**
	 * Clicks on the button pay on Interac Site
	 * @author Mirza.Kamran
	 */
	public void clkPayOnInteracSite()
	{	
		Actions act=new Actions(getDriver());
		act.moveToElement(getReusableActionsInstance().getWhenReady(btnPayOntheInteracSite)).click().build().perform();

	}	
	
	/**
	 * Clicks on view payment history button
	 * @author Mirza.Kamran
	 */
	public void clkViewPaymentHistory() {
		getReusableActionsInstance().clickWhenReady(btnPaymentHistory);
		
	}
	
	/**
	 * Gets the refernce Number after the  payment is successful
	 * @return reference number from payment successful
	 * @author Mirza.Kamran
	 */
	public String getRefNumber()	{
		return getReusableActionsInstance().getWhenReady(lblRefrenceNumber).getText();
	}
	
	/**
	 * Verifes if the payment is successful label is displayed
	 * @return true if the label payment is successful label is displayed
	 * @author Mirza.Kamran
	 */
	public Boolean verifyPaymentSuccessfulMessageDisplayed() {
						
		if(! getReusableActionsInstance().isElementVisible(lblPaymentReceived)) {
			System.out.print("The Label payment received is not displayed it seems, please investigate");
			return false;
		}
		if(! (getReusableActionsInstance().getWhenVisible(lblRefrenceNumber).getText()!=null
			|| getReusableActionsInstance().getWhenVisible(lblRefrenceNumber).getText()!=""))
		{	
			System.out.print("The Label reference Number is either null or empty it seems, please investigate");
			return false;
		}
		return true;
	}

	/**
	 * Cliks on the link 'Payment history' on the transaction confirmation page
	 * @author Mirza.Kamran
	 */
	public void clkPaymentHistoryLinkOnConfirmationPage() {
		getReusableActionsInstance().clickWhenReady(lnkPaymentHistoryOnConfirmationPageFooter);
	}
	
	/**
	 * verifies if the bank section is visible
	 * @return true if the back section is visible
	 */
	public boolean verifyBankSection() {		
		return getReusableActionsInstance().isElementVisible(divBankPayment);
	}

	/**
	 * Selects the bank details
	 * @param strBankName string bank name
	 * @author Mirza.Kamran
	 */
	public void selectBank(String strBankName) {		
		By lblBankName= By.xpath("//area[@alt='"+strBankName+"']");
		getReusableActionsInstance().executeJavaScriptClick(getDriver().findElement(lblBankName));
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 30);
		getReusableActionsInstance().staticWait(3000);
	}
	
	/**
	 * Switch to the new window 
	 * @param strParentWindowHandle parent window handle
	 * @author Mirza.Kamran
	 */
	public void switchToCIBCBankPage(String strParentWindowHandle) {
		getReusableActionsInstance().switchToNewWindow(strParentWindowHandle);
	}

	/**
	 * Verfies if the new bank page is open successfully
	 * @param strWindowTitle the bank page title
	 * @return true if title matches else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyBankPageOpenedSuccessfully(String strWindowTitle) {		
		return getDriver().getTitle().contains(strWindowTitle);
	}

	/**
	 * Checks if the bank is selected successfully
	 * @return true if the bank image is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfTheSelectedBankIsDisplayedCorrectlyOnTheMakePaymentOverLay() {		
		return getReusableActionsInstance().isElementVisible(imgSelectedbank);
	}
}

