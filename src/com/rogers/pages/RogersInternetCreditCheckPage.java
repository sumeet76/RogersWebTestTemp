package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersInternetCreditCheckPage extends BasePageClass {

	public RogersInternetCreditCheckPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Année' or text()='Year']/..")
	WebElement ddlCreditCheckYear;

	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Mois' or text()='Month']/..")
	WebElement ddlCreditCheckMonth;

	@FindBy(xpath = "//rch-date-selection[@section='DOB']//select/option[text()='Jour' or text()='Day']/..")
	WebElement ddlCreditCheckDay;

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

	@FindBy(xpath = "//rch-dropdown[@accessibilitycontext='global.accessibility.secondIdOption']//select")
	WebElement ddlSecondIdOption;

	@FindBy(xpath = "//div[@class='passport-component']//input")
	WebElement txtPasportNumber;

	@FindBy(xpath = "//span[contains(text(),'expiry date')]//following::select[contains(@id,'ds-form-input-id-')][3]")
	WebElement ddlPassportExpiryYear;

	@FindBy(xpath = "//span[contains(text(),'expiry date')]//following::select[contains(@id,'ds-form-input-id-')][4]")
	WebElement ddlPassportExpiryMonth;

	@FindBy(xpath = "//span[contains(text(),'expiry date')]//following::select[contains(@id,'ds-form-input-id-')][5]")
	WebElement ddlPassportExpiryDay;

	@FindBy(xpath = "//span[contains(text(),'authorize')]/preceding::input[@type='checkbox']")
	WebElement chkConsent;

	@FindBy(xpath = "//span[@class='checkout-authorize-copy']")
	WebElement chkConsentSai;
//label[@for='ds-checkbox-id-0']

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement btnCreditCheckSubmit;
	//button[contains(@class,'-primary -large')]

	@FindBy(xpath = "//div[@class='input_container']//input/..")
	WebElement txtContainer;
	
	@FindBy(xpath = "//div[@class='passport-component']//input/..")
	WebElement txtContainerPasportNumber;
				
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersnew;
	
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
		getReusableActionsInstance().waitForElementVisibility(txtContainer,30);
		getReusableActionsInstance().getWhenReady(txtContainer,10).click();
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
		getReusableActionsInstance().getWhenReady(chkConsent, 50).click();
	}

	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSai() {
		getReusableActionsInstance().getWhenReady(chkConsentSai, 50).click();
	}

	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSaiMobile() {
		getReusableActionsInstance().waitForElementVisibility(chkConsentSai,20);
		getReusableActionsInstance().executeJavaScriptClick(chkConsentSai);
	}
	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentMobile() {
		getReusableActionsInstance().waitForElementVisibility(chkConsent,20);
		getReusableActionsInstance().executeJavaScriptClick(chkConsent);
	}
	
	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		getReusableActionsInstance().waitForElementVisibility(btnCreditCheckSubmit,20);
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

}
