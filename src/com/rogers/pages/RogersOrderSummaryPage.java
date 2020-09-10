package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

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
		reusableActions.clickWhenReady(btnCheckout, 30);
	}
	
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail(){
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtContactEmail, 3).clear();
		reusableActions.getWhenReady(txtContactEmail,3).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic first name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstName(){
		String strName = FormFiller.generateRandomName();
		String strFname="Rogersaa" + strName;
		reusableActions.getWhenReady(txtContactFirstName, 3).clear();
		reusableActions.getWhenReady(txtContactFirstName,3).sendKeys(strFname);
	}
	
	/**
	 * Set dynamic last name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName(){
		String strName = FormFiller.generateRandomName();
		String strLname="Automation" + strName;
		reusableActions.getWhenReady(txtContactLastName, 3).clear();
		reusableActions.getWhenReady(txtContactLastName,3).sendKeys(strLname);
	}
	
	/**
	 * Set street number on the  Order Summary Page
	 * @param strStreetNumber street number of the address
	 * @author Chinnarao.Vattam
	 */
	public void setStreetNumber(String strStreetNumber) {
		reusableActions.getWhenReady(txtContactStreetNumber).clear();
		reusableActions.getWhenReady(txtContactStreetNumber, 5).sendKeys(strStreetNumber);
	}
	
	/**
	 * Set street name on the Order Summary Page
	 * @param strStreetName street name of the address
	 * @author chinnarao.vattam
	 */
	public void setStreetName(String strStreetName) {
		reusableActions.getWhenReady(txtContactStreetName).clear();
		reusableActions.getWhenReady(txtContactStreetName, 5).sendKeys(strStreetName);
	}
	
	/**
	 * Set City on the Order Summary Page
	 * @param strCity city of the address
	 * @author chinnarao.vattam
	 */
	public void setCity(String strCity) {
		reusableActions.getWhenReady(txtContactCity).clear();
		reusableActions.getWhenReady(txtContactCity, 5).sendKeys(strCity);
	}
	
	/**
	 * Set Province on the Order Summary Page
	 * @param strProvince province of the address
	 * @author chinnarao.vattam
	 */
	public void selectProvince(String strProvince) {
		reusableActions.selectWhenReady(ddlContactProvince, strProvince, 5);
	}
	
	/**
	 * Set PostalCode on the Order Summary Page
	 * @param strPostalCode postal code of the address
	 * @author chinnarao.vattam
	 */
	public void setPostalCode(String strPostalCode) {
		reusableActions.getWhenReady(txtContactPostalcode).clear();
		reusableActions.getWhenReady(txtContactPostalcode, 5).sendKeys(strPostalCode);
	}
	
	/**
	 * Set dynamic phone number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		String strLicenseNumber = FormFiller.generatePhoneNumber();
		reusableActions.getWhenReady(txtContactPhone, 3).clear();
		reusableActions.getWhenReady(txtContactPhone,3).sendKeys(strLicenseNumber);
		
	}

	/**
	 * Set DOB year on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.waitForElementVisibility(ddlDobYear,30);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReady(ddlDobYear, strDOBYear);
	}

	/**
	 * Set DOB month on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReady(ddlDobMonth, strDOBMonth);
	}

	/**
	 * Set DOB day on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlDobDay, strDOBDay);
		reusableActions.getWhenReady(ddlDobDay).sendKeys(Keys.TAB);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToCreditCardIFrame() {
		//driver.switchTo().frame(reusableActions.getWhenVisible(fraSemaphone,20));
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSemaphone, 10);
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
		Actions act= new Actions(reusableActions.getDriver());	
	    act.moveToElement(txtCreditCardNumber);
		act.click(txtCreditCardNumber).sendKeys(txtCreditCardNumber, strAccountNumber).build().perform();
	}
	else
	{
		txtCreditCardNumberMasked.click();
		reusableActions.staticWait(200);
		reusableActions.executeJavaScript("document.getElementById('pan').value='"+strAccountNumber+"'");
		txtCreditCardNumber.sendKeys(Keys.ENTER);
		reusableActions.staticWait(100);
	}
	}
	
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfCreditCardIFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * selects the credit card expire year
	 * @param strYYYY expire year of the credit card 
	 * @author chinnarao.vattam
	 */
	public void selectCreditcardExpiryYear(String strYYYY) {
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}
/**
 * selects the credit card expire month
 * @param strMM expire month of the credit card
 * @author chinnarao.vattam
 */
	public void selectCreditcardxpiryMonth(String strMM) {
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}

	/**
	 * selects dynamic expire year on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();		
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}

	/**
	 * selects dynamic expire month name on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}
	
	/**
	 * Selects the second identification on the Order Summary Page
	 * @param strSecondIDOption second identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIDOption(String strSecondIDOption) {
		reusableActions.waitForElementVisibility(ddlSecondID, 20);
		reusableActions.selectWhenReady(ddlSecondID, strSecondIDOption);
	}

	/**
	 * Set dynamic license number for British columbia  on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber() {
		String strLicenseNumber = FormFiller.generateLicenseNumber();
		reusableActions.getWhenReady(txtDrivingLicense, 30).clear();
		reusableActions.getWhenReady(txtDrivingLicense, 3).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Selects the Province for the driving license on the Order Summary Page
	 * @param strProvince province of the driviver's  license
	 * @author Chinnarao.Vattam
	 */
	public void selectDirivingLicenseProvince(String strProvince) {
		reusableActions.selectWhenReady(ddlProvince, strProvince);
	}
	
	/**
	 * Set dynamic expiry year for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReady(ddlLicenseExpiryYear, strYYYY);
	}

	/**
	 * Set dynamic expiry month for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlLicenseExpiryMonth, strMM);
	}

	/**
	 * Set dynamic expiry month name for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectLicenseExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		reusableActions.selectWhenReady(ddlLicenseExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expiry day for the license on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void selectDrivingLicenseExpiryDay() {
		String expiryDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlLicenseExpiryDay, expiryDay);
	}

	/**
	 * Click the Credit check Consent check box on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsent() {
		reusableActions.clickWhenReady(chkCreditConsentCheck, 30);
	}

	/**
	 * Click the Submit button on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		reusableActions.clickWhenReady(ddlCreditConsentSubmit, 30);
	}
	
	/**
	 * Click TechInstall radio button option
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstall() {
		reusableActions.clickWhenReady(rdoTechInstall, 30);
	}
	
	/**
	 * Click the communication mode checkbox
	 * @author Chinnarao.Vattam
	 */
	public void clkCommunicationMode() {
		reusableActions.clickWhenReady(chkCommunicationMode, 30);
	}
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreement() {
		List<WebElement> termsandconditions =  driver.findElements(By.xpath("//ol[@id='t1']//a"));
		termsandconditions.get(3).click();
		reusableActions.waitForElementVisibility(lnkWebsite,120);
		reusableActions.javascriptScrollByVisibleElement(lnkWebsite);
		reusableActions.getWhenVisible(lnkWebsite,10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(lnkWebsite, 10).sendKeys(Keys.ARROW_DOWN);
		
	}
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreementForBundleflow() {
		reusableActions.javascriptScrollByVisibleElement(lnkWebsiteBundleflow);
     }
	
	/**
	 * ScrollDown to the end of the agreement
	 * @author Chinnarao.Vattam
	 */
	public void scrollDownToAgreementForLegacyflow() {
		reusableActions.waitForElementVisibility(lnkWebsiteTVflow,120);
		reusableActions.javascriptScrollByVisibleElement(lnkWebsiteTVflow);	
	}
	
	/**
	 * Click on the Consent check box 
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckbox() {
		reusableActions.clickWhenVisible(chkConsentCheckbox, 40);
	}

	/**
	 * Click on the Consent check box for bundle flow
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckboxBundleflow() {	
		reusableActions.isElementVisible(lnkWebsiteBundleflow, 50);		
		reusableActions.javascriptScrollByVisibleElement(lnkWebsiteBundleflow);	
		reusableActions.executeJavaScriptClick(chkConsentCheckboxBundleflow);
	}
	
	/**
	 * Click on the Consent check box for bundle flow
	 * @author chinnarao.vattam
	 */
	public void clkConsentCheckboxLegacyFlow() {
		reusableActions.clickWhenVisible(chkConsentCheckboxDTV, 40);
	}
	
	
	
	/**
	 * Click the order submit button
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmit() {
		reusableActions.getWhenReady(btnSubmit, 20).click();
	}
	
	/**
	 * Click the order submit button
	 * @author Chinnarao.Vattam
	 */
	public void clkOrderSubmit() {
		reusableActions.clickWhenReady(btnDTVOrderSubmit, 20);
	}
	
	
	
}
