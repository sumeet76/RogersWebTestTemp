package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.FormFiller;

public class RogersIgniteTVCreditCheckPage extends BasePageClass {

	public RogersIgniteTVCreditCheckPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Année' or text()='Year']/..")
	WebElement ddlCreditCheckYear;

	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Mois' or text()='Month']/..")
	WebElement ddlCreditCheckMonth;
	
	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Mois' or text()='Month']/..")
	WebElement ddlCreditCheckMonthMigration;
	
	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Jour' or text()='Day']/..")
	WebElement ddlCreditCheckDay;
	
	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Jour' or text()='Day']/..")
	WebElement ddlCreditCheckDayMigration;
	
	@FindBy(xpath = "//rch-dropdown[@accessibilitycontext='global.accessibility.firstIdOption']//select")
	WebElement ddlFirstID;
	
	@FindBy(xpath = "//rch-dropdown[@accessibilitycontext='global.accessibility.enterYourProvince']//select")
	WebElement ddlProvince;
		
	@FindBy(xpath = "//rch-date-selection[@section='Driving License']//select/option[text()='Année' or text()='Year']/..")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "//rch-date-selection[@section='Driving License']//select/option[text()='Mois' or text()='Month']/..")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//rch-date-selection[@section='Driving License']//select/option[text()='Jour' or text()='Day']/..")
	WebElement ddlExpiryDay;
		
	@FindBy(xpath = "//div[@class='input_container']//input")
	WebElement txtLicenseNumber;
	//input[contains(@aria-label,'license number') or  contains(@aria-label,'de licence')]

	@FindBy(xpath = "//rch-dropdown[@accessibilitycontext='global.accessibility.secondIdOption']//select")
	WebElement ddlSecondIdOption;
	
	@FindBy(xpath = "//div[@class='passport-component']//input")
	WebElement txtPasportNumber;

	@FindBy(xpath = "//div[@class='birth-certificate-component']//input[contains(@id,'ds-form-input-id')]")
	WebElement txtBirthCertificateNumber;

	@FindBy(xpath = "//ds-modal")
	WebElement popupAddressModal;

	@FindBy(xpath = "//ds-modal//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement TxtAddressContainer;

	@FindBy(xpath = "//ds-modal//input[@id='canada-post-address-complete-382']")
	WebElement TxtEnterAddress;

	@FindBy(xpath = "//ds-modal//input[contains(@id,'canada-post-address-complete')]")
	WebElement TxtReskRuleaddress;

	@FindBy(xpath = "//rch-date-selection[@section='passport expiry']//select/option[text()='Année' or text()='Year']/..")
	WebElement ddlPassportExpiryYear;
		
	@FindBy(xpath = "//rch-date-selection[@section='passport expiry']//select/option[text()='Moir' or text()='Month']/..")
	WebElement ddlPassportExpiryMonth;
	
	@FindBy(xpath = "//rch-date-selection[@section='passport expiry']//select/option[text()='Jour' or text()='Day']/..")
	WebElement ddlPassportExpiryDay;
		
	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement chkConsent;

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement btnCreditCheckSubmit;
	//button[@class='ute-btn-primary']
	//button[contains(@class,'-primary -large')]
	
	@FindBy(xpath = "//div[@class='input_container']//input/..")
	WebElement txtContainer;
	
	@FindBy(xpath = "//div[@class='passport-component']//input/..")
	WebElement txtContainerPasportNumber;

	@FindBy(xpath = "//div[@class='birth-certificate-component']//input[contains(@id,'ds-form-input-id')]/..")
	WebElement txtContainerBirthCertificateNumber;

	@FindBy(xpath = "//form[@name='cartAbandonmentForm']")
	WebElement popCartAbandonmentForm;
	
	@FindBy(xpath = "//form[@name='cartAbandonmentForm']//button[@class='ute-btn-primary']")
	WebElement btnCartAbandonmentForm;
	
	@FindBy(xpath = "//div[@class='modal-content']//button[@class='ute-btn-primary modal-right']")
	WebElement popCartEmailSuccess;
		
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersnew;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnIgniteAddressLookupSubmit;

	/**
	 * To click on the chevron on the credit check page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		getReusableActionsInstance().waitForElementVisibility(downChevronYourCart, 120);
		getReusableActionsInstance().getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the credit check page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
		return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}

	/**
	 * To verify Address Modal on the credit check page
	 * @return true if the Address Modal is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAddressModal() {
		return	getReusableActionsInstance().isElementVisible(popupAddressModal,60);
	}

	public void setIgniteAddressLookup(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(TxtAddressContainer, 60);
		getReusableActionsInstance().getWhenReady(TxtAddressContainer, 3).click();
		getReusableActionsInstance().getWhenReady(TxtEnterAddress, 3).clear();
		getReusableActionsInstance().getWhenReady(TxtEnterAddress, 5).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(TxtEnterAddress).sendKeys(Keys.TAB);
		getReusableActionsInstance().getWhenVisible(TxtEnterAddress, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(TxtEnterAddress, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(TxtEnterAddress, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(TxtEnterAddress).sendKeys(Keys.ENTER);
	}

	/**
	 * Address lookup
	 * @author manpreet.kaur3
	 */
	public void setIgniteAddressLookupSecond(String strAddress) {
		if(getReusableActionsInstance().isElementVisible(TxtAddressContainer,60)) {
			getReusableActionsInstance().waitForElementTobeClickable(TxtAddressContainer, 60);
			getReusableActionsInstance().getWhenReady(TxtAddressContainer, 3).click();
			getReusableActionsInstance().getWhenReady(TxtReskRuleaddress, 3).clear();
			for (int i = 0; i < strAddress.length(); i++) {
				char c = strAddress.charAt(i);
				String charAddress = new StringBuilder().append(c).toString();
				TxtReskRuleaddress.sendKeys(charAddress);
			}
			getReusableActionsInstance().staticWait(3000);
			getReusableActionsInstance().getWhenVisible(TxtReskRuleaddress).sendKeys(Keys.ENTER);
			clkIgniteAddressLookupSecondSubmit();
		}
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSecondSubmit() {
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().waitForElementVisibility(btnIgniteAddressLookupSubmit, 20);
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
		getReusableActionsInstance().staticWait(10000);
	}
	/**
	 * To verify the Credit Check Year drop down to verify the Credit Evalution Page
	 * @return true if it the credit check page displays the Credit Check Year drop down, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCreditEvalutionPage() {
		getReusableActionsInstance().waitForElementVisibility(ddlCreditCheckYear, 90);
		return	getReusableActionsInstance().isElementVisible(ddlCreditCheckYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		getReusableActionsInstance().waitForElementVisibility(ddlCreditCheckYear,20);
		String strDOBYear = FormFiller.generateDOBYear();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckYear, strDOBYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page for an existing customer
	 * @param strDOBYear year of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYearExistingCustomer(String strDOBYear) {
		//getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers);
		getReusableActionsInstance().waitForElementVisibility(ddlCreditCheckYear,20);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckYear, strDOBYear);
	}

	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckMonth, strDOBMonth);
	}
	
	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @param strDOBMonth month of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonthExistingCustomer(String strDOBMonth) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckMonth, strDOBMonth);
	}

	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @param strDOBMonth month of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonthExistingCustomerMigration(String strDOBMonth) {
		String dOBMonth = strDOBMonth+": Object";
		getReusableActionsInstance().selectWhenReady(ddlCreditCheckMonthMigration, dOBMonth);
	}

	/**
	 * Set dynamic date of birth date on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckDay, strDOBDay);
	}
	
	/**
	 * Set dynamic date of birth date on Credit check page
	 * @param strDOBDay date of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDayExistingCustomer(String strDOBDay) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckDay, strDOBDay);
	}

	/**
	 * Set dynamic date of birth date on Credit check page
	 * @param strDOBDay date of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDayExistingCustomerMigration(String strDOBDay) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckDayMigration, strDOBDay);
	}

	/**
	 * Selects the first identification on Credit check page
	 * @param strFirstID first identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectFirstID(String strFirstID) {
		getReusableActionsInstance().waitForElementVisibility(ddlFirstID,10);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlFirstID, strFirstID);
	}
	
	/**
	 * Selects the Province for the driving license on Credit check page
	 * @param strProvince province for the driver's license 
	 * @author Chinnarao.Vattam
	 */
	public void selectProvince(String strProvince) {
		getReusableActionsInstance().waitForElementVisibility(ddlProvince,10);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlProvince, strProvince);
	}
	
	/**
	 * Set dynamic expire year for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryYear,strYYYY);
	}
	
	/**
	 * Select expire year year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYearwithSpace() {
		Select listbox = new Select(getDriver().findElement(By.xpath("//select[@name='dlExpiryYear']")));
		listbox.selectByIndex(2);
	}
	
	
	/**
	 * Select expire year
	 * @param strYYYY Expire year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear(String strYYYY) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Set dynamic expire month for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth(String strMM) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryMonth, strMM);
	}

	/**
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryDay, strDD);
	}

	/**
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryDay(String strDD) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlExpiryDay, strDD);
	}

	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @param province of address
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber(String province) {
		String strLicenseNumber = FormFiller.generateLicenseNumber(province);
		getReusableActionsInstance().waitForElementVisibility(txtContainer,20);
		getReusableActionsInstance().getWhenReady(txtContainer,10).click();
		txtLicenseNumber.click();
		txtLicenseNumber.clear();
		txtLicenseNumber.sendKeys(strLicenseNumber);
	}

	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @param strLicenseNumber of address
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicense(String strLicenseNumber) {
		getReusableActionsInstance().waitForElementVisibility(txtContainer,20);
		getReusableActionsInstance().getWhenReady(txtContainer,10).click();
		txtLicenseNumber.click();
		txtLicenseNumber.clear();
		txtLicenseNumber.sendKeys(strLicenseNumber);
	}

	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @param province of address
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumberMobile(String province) {
		String strLicenseNumber = FormFiller.generateLicenseNumber(province);		
		getReusableActionsInstance().waitForElementVisibility(txtContainer,20);
		getReusableActionsInstance().executeJavaScriptClick(txtContainer);
		getReusableActionsInstance().getWhenReady(txtLicenseNumber,5).clear();
		getReusableActionsInstance().getWhenReady(txtLicenseNumber, 3).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Selects the second identification on Credit check page
	 * @param strSecondIDOption second identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIDOption(String strSecondIDOption) {
		getReusableActionsInstance().waitForElementVisibility(ddlSecondIdOption, 20);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlSecondIdOption, strSecondIDOption);
	}
	 
	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setPassportNumber() {
		String strPasportNumber = FormFiller.generatePassportNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerPasportNumber,30);
		getReusableActionsInstance().getWhenReady(txtContainerPasportNumber,10).click();
		getReusableActionsInstance().clickWhenReady(txtPasportNumber);
		txtPasportNumber.clear();
		txtPasportNumber.sendKeys(strPasportNumber);
	}

	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setBirthCertificateNumber(String strBirthCertificateNumber) {
		getReusableActionsInstance().waitForElementVisibility(txtContainerBirthCertificateNumber,30);
		getReusableActionsInstance().getWhenReady(txtContainerBirthCertificateNumber,10).click();
		getReusableActionsInstance().clickWhenReady(txtBirthCertificateNumber);
		txtBirthCertificateNumber.clear();
		txtBirthCertificateNumber.sendKeys(strBirthCertificateNumber);
	}

	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setPassportNumberMobile() {
		String strPasportNumber = FormFiller.generatePassportNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerPasportNumber,30);
		getReusableActionsInstance().getWhenReady(txtContainerPasportNumber,10).click();
		txtPasportNumber.clear();
		txtPasportNumber.sendKeys(strPasportNumber);

	}

	/**
	 * Set dynamic expire year for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlPassportExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryMonth() {
		String strMM = FormFiller.generateNameOfMonth();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlPassportExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expire day for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlPassportExpiryDay, strDD);
	}
	
	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsent() {
		getReusableActionsInstance().getWhenReady(chkConsent, 120).click();
	}

	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentMobile() {
		getReusableActionsInstance().executeJavaScriptClick(chkConsent);
	}
	
	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		getReusableActionsInstance().executeJavaScriptClick(btnCreditCheckSubmit);
	}
	
	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmitMobile() {
		getReusableActionsInstance().getWhenReady(btnCreditCheckSubmit, 30);
		getReusableActionsInstance().executeJavaScriptClick(btnCreditCheckSubmit);
	}

	/**
	 * verify the Cart Abandonment Form on the flow drop page
	 * @return true if it displays the  Cart Abandonment Form on the page where customer drop the flow, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCartAbandonmentForm() {
		getReusableActionsInstance().waitForElementVisibility(popCartAbandonmentForm, 30);
		return	getReusableActionsInstance().isElementVisible(popCartAbandonmentForm);
	}
	
	/**
	 * Click the Cart Abandonment Form button 
	 * @author Chinnarao.Vattam
	 */
	public void clkCartAbandonmentForm() {
		getReusableActionsInstance().clickWhenReady(btnCartAbandonmentForm, 90);
	}
	
	/**
	 * verify the Cart Email Success on the abandon page
	 * @return true if it displays the Cart Email Success on the page where customer drop the flow, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCartEmailSuccess() {
		getReusableActionsInstance().waitForElementVisibility(popCartEmailSuccess, 30);
		return	getReusableActionsInstance().isElementVisible(popCartEmailSuccess);
	}
	
	/**
	 * Click the Cart Email Success Ok button to dropt the flow
	 * @author Chinnarao.Vattam
	 */
	public void clkCartEmailSuccess() {
		getReusableActionsInstance().waitForElementVisibility(popCartEmailSuccess, 30);
		getReusableActionsInstance().clickWhenReady(popCartEmailSuccess, 20);
	}

}
