package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.util.List;

public class RogersOrderSummaryPage extends BasePageClass {

	public RogersOrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='/consumer/order-summary/checkout']")
	WebElement btnCheckout;
	
	@FindBy(id = "contact-first_name")
	WebElement txtContactFirstName;

	@FindBy(id = "contact-last_name")
	WebElement txtContactLastName;
	
	@FindBy(id = "contact-email")
	WebElement txtContactEmail;
	
	@FindBy(id = "contact-streetNumber")
	WebElement txtContactStreetNumber;
	
	
	@FindBy(id = "contact-streetName")
	WebElement txtContactStreetName;
	
	
	@FindBy(id = "city")
	WebElement txtContactCity;
	
	@FindBy(id = "contact-province")
	WebElement ddlContactProvince;
	
	
	@FindBy(id = "contact-postalcode")
	WebElement txtContactPostalcode;
	
	
	@FindBy(id = "contact-phone")
	WebElement txtContactPhone;
	
	@FindBy(xpath = "//label[@id='legal-CheckBox']")
	WebElement chkConsentCheckboxBundleflow;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.dob.year']")
	WebElement ddlDobYear;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.dob.month']")
	WebElement ddlDobMonth;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.dob.day']")
	WebElement ddlDobDay;

	@FindBy(xpath = "//iframe[@id='sema']")
	WebElement fraSemaphone;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.expiry.month']")
	WebElement ddlExpiryMonth;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.expiry.year']")
	WebElement ddlExpiryYear;

	@FindBy(name = "sid")
	WebElement ddlSecondID;
	
	@FindBy(xpath = "//input[@name='dl']")
	WebElement txtDrivingLicense;
	
	@FindBy(xpath = "//select[@id='dl_province']")
	WebElement ddlProvince;

	@FindBy(xpath = "//select[@ng-model='form.credit.sid.dl.expiry.year']")
	WebElement ddlLicenseExpiryYear;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.sid.dl.expiry.month']")
	WebElement ddlLicenseExpiryMonth;
	
	@FindBy(xpath = "//select[@ng-model='form.credit.sid.dl.expiry.day']")
	WebElement ddlLicenseExpiryDay;
	
	@FindBy(xpath = "//label[@for='consent_credit_check']")
	WebElement chkCreditConsentCheck;
	
	@FindBy(xpath = "//button[@class='submit consent']")
	WebElement ddlCreditConsentSubmit;
	
	@FindBy(xpath = "//li[@id='service2']")
	WebElement rdoTechInstall;
		
	@FindBy(xpath = "//input[@id='cis_flag']")
	WebElement chkCommunicationMode;
	
	@FindBy(xpath = "//a[@href='tel:819 994 6591']")
	WebElement lnkWebsite;
			
	@FindBy(xpath = "//label[@id='termsId']")
	WebElement chkConsentCheckbox;
	
	
	@FindBy(xpath = "//button[@class='submit pull-left']")
	WebElement btnSubmit;
	
	
	@FindBy(xpath = "//a[@href='http://www.privcom.gc.ca/']")
	WebElement lnkWebsiteBundleflow;
	
	@FindBy(xpath = "//a[@href='http://www.priv.gc.ca/en']")
	WebElement lnkWebsiteTVflow;
	
	@FindBy(xpath = "//label[@for='tos_consent']//span[@class='checkboxStyle']")
	WebElement chkConsentCheckboxDTV;
	
	@FindBy(xpath = "//a[@class='shoppingCartCheckOutButton btn']")
	WebElement btnDTVOrderSubmit;

	
	@FindBy(id="pan")
	WebElement txtCreditCardNumber;
	
	@FindBy(id="maskedPan")
	WebElement txtCreditCardNumberMasked;
		
	/**
	 * Click the checkout button the on Order Summary Page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		getReusableActionsInstance().clickWhenReady(btnCheckout, 30);
	}
	
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail(){
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().getWhenReady(txtContactEmail, 3).clear();
		getReusableActionsInstance().getWhenReady(txtContactEmail,3).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic first name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstName(){
		String strName = FormFiller.generateRandomName();
		String strFname="Rogersaa" + strName;
		getReusableActionsInstance().getWhenReady(txtContactFirstName, 3).clear();
		getReusableActionsInstance().getWhenReady(txtContactFirstName,3).sendKeys(strFname);
	}
	
	/**
	 * Set dynamic last name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName(){
		String strName = FormFiller.generateRandomName();
		String strLname="Automation" + strName;
		getReusableActionsInstance().getWhenReady(txtContactLastName, 3).clear();
		getReusableActionsInstance().getWhenReady(txtContactLastName,3).sendKeys(strLname);
	}
	
	/**
	 * Set street number on the  Order Summary Page
	 * @param strStreetNumber street number of the address
	 * @author Chinnarao.Vattam
	 */
	public void setStreetNumber(String strStreetNumber) {
		getReusableActionsInstance().getWhenReady(txtContactStreetNumber).clear();
		getReusableActionsInstance().getWhenReady(txtContactStreetNumber, 5).sendKeys(strStreetNumber);
	}
	
	/**
	 * Set street name on the Order Summary Page
	 * @param strStreetName street name of the address
	 * @author chinnarao.vattam
	 */
	public void setStreetName(String strStreetName) {
		getReusableActionsInstance().getWhenReady(txtContactStreetName).clear();
		getReusableActionsInstance().getWhenReady(txtContactStreetName, 5).sendKeys(strStreetName);
	}
	
	/**
	 * Set City on the Order Summary Page
	 * @param strCity city of the address
	 * @author chinnarao.vattam
	 */
	public void setCity(String strCity) {
		getReusableActionsInstance().getWhenReady(txtContactCity).clear();
		getReusableActionsInstance().getWhenReady(txtContactCity, 5).sendKeys(strCity);
	}
	
	/**
	 * Set Province on the Order Summary Page
	 * @param strProvince province of the address
	 * @author chinnarao.vattam
	 */
	public void selectProvince(String strProvince) {
		getReusableActionsInstance().selectWhenReady(ddlContactProvince, strProvince, 5);
	}
	
	/**
	 * Set PostalCode on the Order Summary Page
	 * @param strPostalCode postal code of the address
	 * @author chinnarao.vattam
	 */
	public void setPostalCode(String strPostalCode) {
		getReusableActionsInstance().getWhenReady(txtContactPostalcode).clear();
		getReusableActionsInstance().getWhenReady(txtContactPostalcode, 5).sendKeys(strPostalCode);
	}
	
	/**
	 * Set dynamic phone number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		String strLicenseNumber = FormFiller.generatePhoneNumber();
		getReusableActionsInstance().getWhenReady(txtContactPhone, 3).clear();
		getReusableActionsInstance().getWhenReady(txtContactPhone,3).sendKeys(strLicenseNumber);
		
	}

	/**
	 * Set DOB year on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		getReusableActionsInstance().waitForElementVisibility(ddlDobYear,30);
		String strDOBYear = FormFiller.generateDOBYear();
		getReusableActionsInstance().selectWhenReady(ddlDobYear, strDOBYear);
	}

	/**
	 * Set DOB month on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReady(ddlDobMonth, strDOBMonth);
	}

	/**
	 * Set DOB day on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		getReusableActionsInstance().selectWhenReady(ddlDobDay, strDOBDay);
		getReusableActionsInstance().getWhenReady(ddlDobDay).sendKeys(Keys.TAB);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToCreditCardIFrame() {
		//getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraSemaphone,20));
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraSemaphone, 10);
	}
	
	/**
	 * set the account number of semaphone frame
	 * @param strAccountNumber account number of the pre-auth credit card
	 * @author chinnarao.vattam
	 */
	public void setCreditCardNumberIFrame(String strAccountNumber){
    Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
	String browserName = cap.getBrowserName().toLowerCase();
	if(browserName.trim().equalsIgnoreCase("chrome"))
	 {	
		Actions act= new Actions(getReusableActionsInstance().getDriver());
	    act.moveToElement(txtCreditCardNumber);
		act.click(txtCreditCardNumber).sendKeys(txtCreditCardNumber, strAccountNumber).build().perform();
	}
	else
	{
		txtCreditCardNumberMasked.click();
		getReusableActionsInstance().staticWait(200);
		getReusableActionsInstance().executeJavaScript("document.getElementById('pan').value='"+strAccountNumber+"'");
		txtCreditCardNumber.sendKeys(Keys.ENTER);
		getReusableActionsInstance().staticWait(100);
	}
	}
	
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfCreditCardIFrame() {
		getDriver().switchTo().defaultContent();
	}
	
	/**
	 * selects the credit card expire year
	 * @param strYYYY expire year of the credit card 
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		getReusableActionsInstance().selectWhenReady(ddlExpiryYear, strYYYY);
	}
/**
 * selects the credit card expire month
 * @param strMM expire month of the credit card
 * @author chinnarao.vattam
 */
	public void selectCreditcardxpiryMonth(String strMM) {
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * selects dynamic expire year on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();		
		getReusableActionsInstance().selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * selects dynamic expire month name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReady(ddlExpiryMonth, strMM);
	}
	
	/**
	 * Selects the second identification on the Order Summary Page
	 * @param strSecondIDOption second identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIDOption(String strSecondIDOption) {
		getReusableActionsInstance().waitForElementVisibility(ddlSecondID, 20);
		getReusableActionsInstance().selectWhenReady(ddlSecondID, strSecondIDOption);
	}

	/**
	 * Set dynamic license number for British columbia  on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber() {
		String strLicenseNumber = FormFiller.generateLicenseNumber();
		getReusableActionsInstance().getWhenReady(txtDrivingLicense, 30).clear();
		getReusableActionsInstance().getWhenReady(txtDrivingLicense, 3).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Selects the Province for the driving license on the Order Summary Page
	 * @param strProvince province of the driviver's  license
	 * @author Chinnarao.Vattam
	 */
	public void selectDirivingLicenseProvince(String strProvince) {
		getReusableActionsInstance().selectWhenReady(ddlProvince, strProvince);
	}
	
	/**
	 * Set dynamic expiry year for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		getReusableActionsInstance().selectWhenReady(ddlLicenseExpiryYear, strYYYY);
	}

	/**
	 * Set dynamic expiry month for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		getReusableActionsInstance().selectWhenReady(ddlLicenseExpiryMonth, strMM);
	}

	/**
	 * Set dynamic expiry month name for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectLicenseExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReady(ddlLicenseExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expiry day for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryDay() {
		String expiryDay = FormFiller.generateCalendarDay();
		getReusableActionsInstance().selectWhenReady(ddlLicenseExpiryDay, expiryDay);
	}

	/**
	 * Click the Credit check Consent check box on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsent() {
		getReusableActionsInstance().clickWhenReady(chkCreditConsentCheck, 30);
	}

	/**
	 * Click the Submit button on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		getReusableActionsInstance().clickWhenReady(ddlCreditConsentSubmit, 30);
	}
	
	/**
	 * Click TechInstall radio button option
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstall() {
		getReusableActionsInstance().clickWhenReady(rdoTechInstall, 30);
	}
	
	/**
	 * Click the communication mode checkbox
	 * @author Chinnarao.Vattam
	 */
	public void clkCommunicationMode() {
		getReusableActionsInstance().clickWhenReady(chkCommunicationMode, 30);
	}
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreement() {
		List<WebElement> termsandconditions =  getDriver().findElements(By.xpath("//ol[@id='t1']//a"));
		termsandconditions.get(3).click();
		getReusableActionsInstance().waitForElementVisibility(lnkWebsite,60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkWebsite);
		getReusableActionsInstance().getWhenVisible(lnkWebsite,10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkWebsite, 10).sendKeys(Keys.ARROW_DOWN);
		
	}
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreementForBundleflow() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkWebsiteBundleflow);
     }
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreementForLegacyflow() {
		getReusableActionsInstance().waitForElementVisibility(lnkWebsiteTVflow,60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkWebsiteTVflow);
	}
	
	/**
	 * Click on the Consent check box 
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckbox() {
		getReusableActionsInstance().clickWhenVisible(chkConsentCheckbox, 40);
	}

	/**
	 * Click on the Consent check box for bundle flow
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckboxBundleflow() {	
		getReusableActionsInstance().isElementVisible(lnkWebsiteBundleflow, 50);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkWebsiteBundleflow);
		getReusableActionsInstance().executeJavaScriptClick(chkConsentCheckboxBundleflow);
	}
	
	/**
	 * Click on the Consent check box for bundle flow
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckboxLegacyFlow() {
		getReusableActionsInstance().clickWhenVisible(chkConsentCheckboxDTV, 40);
	}
	
	
	
	/**
	 * Click the order submit button
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmit() {
		getReusableActionsInstance().getWhenReady(btnSubmit, 20).click();
	}
	
	/**
	 * Click the order submit button
	 * @author Chinnarao.Vattam
	 */
	public void clkOrderSubmit() {
		getReusableActionsInstance().clickWhenReady(btnDTVOrderSubmit, 20);
	}
	
	
	
}
