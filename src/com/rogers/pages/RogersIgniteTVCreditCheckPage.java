package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersIgniteTVCreditCheckPage extends BasePageClass {

	public RogersIgniteTVCreditCheckPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.year']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckYear;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.year']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckYearMigration;
		
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.month']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckMonth;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.month']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckMonthMigration;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.day']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckDay;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.dob.day']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlCreditCheckDayMigration;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.firstIdOp']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlFirstID;
	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.enterYour']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlProvince;
		
	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.driving_l']//select[contains(@id,'ds-form-input-id-')])[1]")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.driving_l']//select[contains(@id,'ds-form-input-id-')])[2]")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.driving_l']//select[contains(@id,'ds-form-input-id-')])[3]")
	WebElement ddlExpiryDay;
		
	@FindBy(xpath = "//input[contains(@aria-label,'license number') or  contains(@aria-label,'de licence') ]")
	WebElement txtLicenseNumber;
	  	
	@FindBy(xpath = "//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.secondIdO']//select[contains(@id,'ds-form-input-id-')]")
	WebElement ddlSecondIdOption;
	
	@FindBy(xpath = "//div[@class='passport-component']//input[@aria-label='Please enter your passport number']")
	WebElement txtPasportNumber;
		
	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.passport_']//select[contains(@id,'ds-form-input-id-')])[1]")
	WebElement ddlPassportExpiryYear;
		
	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.passport_']//select[contains(@id,'ds-form-input-id-')])[2]")
	WebElement ddlPassportExpiryMonth;
	
	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-accessibility-context='global.accessibility.passport_']//select[contains(@id,'ds-form-input-id-')])[3]")
	WebElement ddlPassportExpiryDay;
		
	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement chkConsent;

	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnCreditCheckSubmit;
	//button[@class='ute-btn-primary']
	
	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainer;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[2]")
	WebElement txtContainerPasportNumber;
	
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
	 * Set dynamic date of birth year on Credit check page for an existing customer
	 * @param strDOBYear year of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYearExistingCustomerMigration(String strDOBYear) {
		//getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers);
		getReusableActionsInstance().waitForElementVisibility(ddlCreditCheckYearMigration,120);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCheckYearMigration, strDOBYear);
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
		getReusableActionsInstance().selectWhenReady(ddlCreditCheckDay, strDOBDay);
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
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlFirstID, strFirstID);
	}
	
	/**
	 * Selects the Province for the driving license on Credit check page
	 * @param strProvince province for the driver's license 
	 * @author Chinnarao.Vattam
	 */
	public void selectProvince(String strProvince) {
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
	public void selectExpiryYearYYYY(String strYYYY) {
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
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
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
	public void setPassportNumberMobile() {
		String strPasportNumber = FormFiller.generatePassportNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerPasportNumber,30);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(txtContainerPasportNumber,10).click();
		getReusableActionsInstance().getWhenReady(txtPasportNumber, 30).clear();
		getReusableActionsInstance().getWhenReady(txtPasportNumber, 3).sendKeys(strPasportNumber);
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
