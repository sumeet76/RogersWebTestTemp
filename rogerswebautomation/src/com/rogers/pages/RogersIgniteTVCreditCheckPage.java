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
	
	@FindBy(xpath = "//select[@id='creditCheckYear']")
	WebElement ddlCreditCheckYear;
	
	@FindBy(xpath = "//select[@id='creditCheckMonth']")
	WebElement ddlCreditCheckMonth;
	
	@FindBy(xpath = "//select[@id='creditCheckDay']")
	WebElement ddlCreditCheckDay;
	
	@FindBy(xpath = "//select[@id='firstIdOption']")
	WebElement ddlFirstID;
	
	@FindBy(xpath = "//select[@name='dlProvince']")
	WebElement ddlProvince;
		
	@FindBy(xpath = "//select[@name='dlExpiryYear']")
	WebElement ddlExpiryYear;
	
	@FindBy(xpath = "//select[@name='dlExpiryMonth']")
	WebElement ddlExpiryMonth;

	@FindBy(xpath = "//select[@name='dlExpiryDay']")
	WebElement ddlExpiryDay;
		
	@FindBy(xpath = "//input[@id='dlLicenseNumber']")
	WebElement txtLicenseNumber;
	  	
	@FindBy(xpath = "//select[@id='secondIdOption']")
	WebElement ddlSecondIdOption;
	
	@FindBy(xpath = "//input[@id='ppNumber']")
	WebElement txtPasportNumber;
		
	@FindBy(xpath = "//select[@name='ppExpiryYear']")
	WebElement ddlPassportExpiryYear;
		
	@FindBy(xpath = "//select[@name='ppExpiryMonth']")
	WebElement ddlPassportExpiryMonth;
	
	@FindBy(xpath = "//select[@name='ppExpiryDay']")
	WebElement ddlPassportExpiryDay;
		
	@FindBy(xpath = "//label[@for='credit_check_consent']")
	WebElement chkConsent;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnCreditCheckSubmit;
	
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
		reusableActions.waitForElementVisibility(downChevronYourCart, 120);
		reusableActions.getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the credit check page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		reusableActions.waitForElementVisibility(gwpYourCart, 120);
		return	reusableActions.isElementVisible(gwpYourCart);
	}
	
	/**
	 * To verify the Credit Check Year drop down to verify the Credit Evalution Page
	 * @return true if it the credit check page displays the Credit Check Year drop down, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCreditEvalutionPage() {
		reusableActions.waitForElementVisibility(ddlCreditCheckYear, 180);
		return	reusableActions.isElementVisible(ddlCreditCheckYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYear() {
		reusableActions.waitForElementVisibility(ddlCreditCheckYear,20);
		String strDOBYear = FormFiller.generateDOBYear();
		reusableActions.selectWhenReady(ddlCreditCheckYear, strDOBYear);
	}
	
	/**
	 * Set dynamic date of birth year on Credit check page for an existing customer
	 * @param strDOBYear year of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBYearExistingCustomer(String strDOBYear) {
		//reusableActions.waitForElementInvisibility(popupLoadingFingers);
		reusableActions.waitForElementVisibility(ddlCreditCheckYear,20);
		reusableActions.selectWhenReady(ddlCreditCheckYear, strDOBYear);
	}
	
	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonth() {
		String strDOBMonth = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlCreditCheckMonth, strDOBMonth);
	}
	
	/**
	 * Set dynamic date of birth Month on Credit check page
	 * @param strDOBMonth month of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBMonthExistingCustomer(String strDOBMonth) {
		reusableActions.selectWhenReady(ddlCreditCheckMonth, strDOBMonth);
	}
	
	/**
	 * Set dynamic date of birth date on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDay() {
		String strDOBDay = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlCreditCheckDay, strDOBDay);
	}
	
	/**
	 * Set dynamic date of birth date on Credit check page
	 * @param strDOBDay date of birth
	 * @author Chinnarao.Vattam
	 */
	public void selectDOBDayExistingCustomer(String strDOBDay) {
		reusableActions.selectWhenReady(ddlCreditCheckDay, strDOBDay);
	}
	
	/**
	 * Selects the first identification on Credit check page
	 * @param strFirstID first identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectFirstID(String strFirstID) {
		reusableActions.selectWhenReady(ddlFirstID, strFirstID);
	}
	
	/**
	 * Selects the Province for the driving license on Credit check page
	 * @param strProvince province for the driver's license 
	 * @author Chinnarao.Vattam
	 */
	public void selectProvince(String strProvince) {
		reusableActions.selectWhenReady(ddlProvince, strProvince);
	}
	
	/**
	 * Set dynamic expire year for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReady(ddlExpiryYear,strYYYY);
	}
	
	/**
	 * Select expire year year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYearwithSpace() {
		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='dlExpiryYear']")));
		listbox.selectByIndex(2);
	}
	
	
	/**
	 * Select expire year
	 * @param strYYYY Expire year
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryYearYYYY(String strYYYY) {
		reusableActions.selectWhenReady(ddlExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expire day for the license on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlExpiryDay, strDD);
	}
	
	/**
	 * Set dynamic license number for British Columbia  on Credit check page
	 * @param province of address
	 * @author Chinnarao.Vattam
	 */
	public void setDrivingLicenseNumber(String province) {
		String strLicenseNumber = FormFiller.generateLicenseNumber(province);
		reusableActions.getWhenReady(txtLicenseNumber, 30).clear();
		reusableActions.getWhenReady(txtLicenseNumber, 3).sendKeys(strLicenseNumber);
	}
	
	/**
	 * Selects the second identification on Credit check page
	 * @param strSecondIDOption second identification for the credit check
	 * @author Chinnarao.Vattam
	 */
	public void selectSecondIDOption(String strSecondIDOption) {
		reusableActions.waitForElementVisibility(ddlSecondIdOption, 20);
		reusableActions.selectWhenReady(ddlSecondIdOption, strSecondIDOption);
	}
	 
	/**
	 * Set dynamic passport number on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void setPassportNumber() {
		String strPasportNumber = FormFiller.generatePassportNumber();
		reusableActions.getWhenReady(txtPasportNumber, 30).clear();
		reusableActions.getWhenReady(txtPasportNumber, 3).sendKeys(strPasportNumber);
	}

	/**
	 * Set dynamic expire year for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryYear() {
		String strYYYY = FormFiller.generateExpiryYear();
		reusableActions.selectWhenReady(ddlPassportExpiryYear, strYYYY);
	}
	
	/**
	 * Set dynamic expire month for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryMonth() {
		String strMM = FormFiller.generateMonth();
		reusableActions.selectWhenReady(ddlPassportExpiryMonth, strMM);
	}
	
	/**
	 * Set dynamic expire day for the passport on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void selectPassportExpiryDay() {
		String strDD = FormFiller.generateCalendarDay();
		reusableActions.selectWhenReady(ddlPassportExpiryDay, strDD);
	}
	
	/**
	 * Click the Credit check Consent check box on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsent() {
		reusableActions.clickWhenReady(chkConsent, 120);
	}

	/**
	 * Click the Submit button on Credit check page
	 * @author Chinnarao.Vattam
	 */
	public void clkCreditConsentSubmit() {
		reusableActions.getWhenReady(btnCreditCheckSubmit, 120).click();
	}

	/**
	 * verify the Cart Abandonment Form on the flow drop page
	 * @return true if it displays the  Cart Abandonment Form on the page where customer drop the flow, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCartAbandonmentForm() {
		reusableActions.waitForElementVisibility(popCartAbandonmentForm, 30);
		return	reusableActions.isElementVisible(popCartAbandonmentForm);
	}
	
	/**
	 * Click the Cart Abandonment Form button 
	 * @author Chinnarao.Vattam
	 */
	public void clkCartAbandonmentForm() {
		reusableActions.clickWhenReady(btnCartAbandonmentForm, 90);
	}
	
	/**
	 * verify the Cart Email Success on the abandon page
	 * @return true if it displays the Cart Email Success on the page where customer drop the flow, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyCartEmailSuccess() {
		reusableActions.waitForElementVisibility(popCartEmailSuccess, 30);
		return	reusableActions.isElementVisible(popCartEmailSuccess);
	}
	
	/**
	 * Click the Cart Email Success Ok button to dropt the flow
	 * @author Chinnarao.Vattam
	 */
	public void clkCartEmailSuccess() {
		reusableActions.waitForElementVisibility(popCartEmailSuccess, 30);
		reusableActions.clickWhenReady(popCartEmailSuccess, 20);
	}

}
