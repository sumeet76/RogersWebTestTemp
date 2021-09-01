package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersOrderReviewPage extends BasePageClass {

	public RogersOrderReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ins[@translate='global.label.reviewHeading']")
	WebElement infoPackagechangeReview;

	@FindBy(xpath = "//ins[@translate='global.label.billingAddress']")
	WebElement infoPackagechangeBillingAddress;

	@FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
	WebElement txtAgreementPageInternet;
	
	@FindBy(xpath = "//h2[@translate='global.label.OrderReview']")
	WebElement txtAgreementPageBuy;
	//h3[@translate='global.label.OrderReview']

	@FindBy(xpath = "//ins[@translate='global.label.reviewHeading']")
	WebElement infoAgreementMobile;

	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;

	@FindBy(xpath = "//li[contains(text(),'819 994 6591')]")
	WebElement lnkAgreementToEndExistingCustomer;	
	
	@FindBy(xpath = "//li[contains(text(),'819 994 6591')]")
	WebElement lnkAgreementToEnd;	
	
	@FindBy(xpath = "//div[@class='agreement-container']")
	WebElement lnkAgreementContainer;
	
	@FindBy(xpath = "//div[@class='additional-agreement-details__content']")
	WebElement lnkAgreementContent;
	
	@FindBy(xpath = "//li[@id='headingDetails4']//button[@class='button-link']")
	WebElement lnkAgreementPrivacyPolicy;

	@FindBy(xpath = "//li[@id='headingDetails4']//div[@class='ute-link cursor-hand']")
	WebElement lnkAgreementPrivacyPolicyTCMobile;

	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement clkChangeAcceptCheckbox;
	
	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement clkChangeAcceptCheckboxMigration;

	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement clkSubmit;
	
	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement clkChangeAcceptCheckboxUpdate;
	//div[@id='ds-checkbox-id-0-label-container']
	//label[@for='tos_consent']

	@FindBy(xpath = "//span[contains(text(),'18yearsofage')][1]")
	WebElement clkCheckboxAcceptInstallContent;

	@FindAll({
	@FindBy(xpath = "//span[@class='checkout-authorize-copy']"),
			@FindBy(xpath = "//label[@class='ds-checkboxLabel d-inline-flex align-items-start']")})
	WebElement clkChangeAcceptCheckboxUpdateInternet;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;

	@FindBy(xpath = "//span[@translate='global.cta.submit']/ancestor::a")
	WebElement clkSubmitUpdate;
	//input[@name='submit']
    //input[@class='ute-btn-primary']

	@FindBy(xpath = "//span[@translate='global.cta.submitSmartStream']/ancestor::a")
	WebElement clkSubmitUpdateSS;

	@FindBy(xpath = "//span[@translate='global.cta.submitSmartStream']/ancestor::a")
	WebElement clkSubmitUpdateMobile;


	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement clkSubmitUpdateInternet;
	//span[@translate='global.cta.submit']/ancestor::a

	@FindBy(xpath = "//span[@translate='global.cta.submitSmartStream']")
	WebElement clkSubmitUpdateSAI;

	@FindBy(xpath = "//label[@for='shieldTermsCheckbox']")
	WebElement chbShieldTerms;
	
	@FindBy(xpath = "//label[@for='termsCheckbox']")
	WebElement chbTerms;
	
	@FindBy(xpath = "//label[@for='upfrontTermsCheckbox']")
	WebElement chbUpfrontTerms;

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;

	//@FindBy(xpath = "//input[@id='digital-copy']/../label")
	//@FindBy(xpath = "//label[@for='cxEmail']")
	@FindAll({
		@FindBy(xpath = "//input[@id='cxEmail']/../label"),
		@FindBy(xpath = "//input[@id='digital-copy']/../label")})
	WebElement rdbtnEmail;


	@FindAll({
			@FindBy(xpath = "//button[@data-test='continue-btn']"),
			@FindBy(xpath = "//button[@data-dtname='reviewOrder-submit']")})
	WebElement btnSubmitOrder;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath = "//input[@name='customerEmail']")
	WebElement txtCustomerEmail;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	WebElement lblPaymentStep;
	
	@FindBy(xpath = "//input[@id='birthDate']//following-sibling::div//span")
	WebElement clkDateOfBirthCalendarIcon;

	@FindBy(xpath = "//div[@class='owl-dt-calendar-main']")
	WebElement clkMainMenuCalendarYearChange;

	@FindBy(xpath = "//table[@class='owl-dt-calendar-table owl-dt-calendar-multi-year-table']//preceding-sibling::button//span")
	WebElement clkLeftControlButtonOnCalendar;	

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement clkChevron;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;	
	
	@FindBy(xpath = "//Span[@checkout-res='checkout_review_order']")
	WebElement lblReviewYourorder;	
	
	
	/**
	 * To verify the Rogers order review Page load
	 * @author Saurav.Goyal
	 */
	public void verifyOrderReviewPageLoadedSuccessfully() {
		getReusableActionsInstance().waitForElementVisibility(lblReviewYourorder, 60);
	}
	
	
    /**
     * To click on the chevron on the payment page
     * @author Saurav.Goyal
     */
    public void clkChevronYourCart() {
        getReusableActionsInstance().waitForElementVisibility(downChevronYourCart, 120);
        getReusableActionsInstance().getWhenReady(downChevronYourCart, 120).click();
    }
    
	/**
	 * To verify gwp promotion in the payment page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 60);
		return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		getReusableActionsInstance().staticWait(120000);
		return getReusableActionsInstance().isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinueSession() {
		getReusableActionsInstance().getWhenReady(btnContinueSession, 20).click();
	}
	
	/**
	 * Enter date of birth	
	 * @author Saurav.Goyal
	 * @param dateOfBirth date to be selected
	 * Function not complete, need to be updated once the HTO functionality will be working
	 */
	public void enterDateOfbirth(String dateOfBirth) {
		getReusableActionsInstance().waitForElementVisibility(clkDateOfBirthCalendarIcon,20);
		getReusableActionsInstance().getWhenReady(clkDateOfBirthCalendarIcon, 20).click();
		getReusableActionsInstance().waitForElementVisibility(clkMainMenuCalendarYearChange,20);
		getReusableActionsInstance().getWhenReady(clkMainMenuCalendarYearChange, 20).click();
		if(!getReusableActionsInstance().isElementVisible(By.xpath("//table[@class='owl-dt-calendar-table owl-dt-calendar-multi-year-table']//span[text()='1987']")))
		{
			getReusableActionsInstance().waitForElementVisibility(clkLeftControlButtonOnCalendar,20);
			getReusableActionsInstance().getWhenReady(clkLeftControlButtonOnCalendar, 20).click();
		}
	}
	/**
	 * Verify the order review page
	 * @return true if the Agreement is present on the order review page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreementPage() {
		getReusableActionsInstance().waitForElementVisibility(txtAgreementPageBuy, 120);
		return	getReusableActionsInstance().isElementVisible(txtAgreementPageBuy, 60);
	}

	public boolean verifyAgreementPageTVMobile() {
		return	getReusableActionsInstance().isElementVisible(infoAgreementMobile, 180);
	}

	/**
	 * Verify the order review page
	 * @return true if the Agreement is present on the order review page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreementPageInternet() {
		getReusableActionsInstance().waitForElementVisibility(txtAgreementPageInternet, 90);
	return	getReusableActionsInstance().isElementVisible(txtAgreementPageInternet, 60);
	}
	/**
	 * Verify the agreement block on the order review page
	 * @return true if the page displays the agreement , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyAgreement() {
		return getReusableActionsInstance().isElementVisible(infoAgreement, 90);
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdate() {		
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementToEndExistingCustomer, 50);
		//Javascript scroll used to support firefox (geckodriver)
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEndExistingCustomer);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxUpdate, 90).click();
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateTVMobile() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementToEndExistingCustomer, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEnd);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxUpdate, 30);
		getReusableActionsInstance().executeJavaScriptClick(clkChangeAcceptCheckboxUpdate);
	}
	/**
	 * Click on the Consent check box on the order review page
	 * @author nandhini.ventakachal
	 */
	public void clkAcceptenceCheckboxInstalltionContent()
	{
		getReusableActionsInstance().getWhenReady(clkCheckboxAcceptInstallContent, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkCheckboxAcceptInstallContent);
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateInternet() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		getReusableActionsInstance().getWhenReady(lnkAgreementPrivacyPolicy, 10).click();
		getReusableActionsInstance().getWhenVisible(lnkAgreementToEnd, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEnd);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxUpdateInternet, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkChangeAcceptCheckboxUpdateInternet);
		//getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxUpdateInternet, 90).click();
	}
	
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxUpdateInternetMobile() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkAgreementPrivacyPolicy);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEnd);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 5).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxUpdateInternet, 30);
		getReusableActionsInstance().executeJavaScriptClick(clkChangeAcceptCheckboxUpdateInternet);
	}
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxx() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		getReusableActionsInstance().getWhenReady(lnkAgreementPrivacyPolicy, 10).click();
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 30).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckbox, 90).click();
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		getReusableActionsInstance().getWhenReady(lnkAgreementPrivacyPolicy, 10).click();
		getReusableActionsInstance().getWhenVisible(lnkAgreementToEnd, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEnd);

		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckbox, 90).click();
	}

	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxMobile() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementPrivacyPolicy, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkAgreementPrivacyPolicy);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().javascriptScrollByVisibleElement(lnkAgreementToEnd);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 10).sendKeys(Keys.PAGE_DOWN);
		getReusableActionsInstance().getWhenVisible(lnkAgreementPrivacyPolicy, 5).sendKeys(Keys.PAGE_DOWN);
		
		getReusableActionsInstance().waitForElementVisibility(clkChangeAcceptCheckbox, 20);
		getReusableActionsInstance().executeJavaScriptClick(clkChangeAcceptCheckbox);
	}
	
	/**
	 * Click on the Consent check box on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkAcceptenceCheckboxMigration() {
		getReusableActionsInstance().waitForElementVisibility(lnkAgreementToEnd, 50);
		getReusableActionsInstance().scrollToElement(lnkAgreementToEnd);
		getReusableActionsInstance().getWhenReady(clkChangeAcceptCheckboxMigration, 90).click();
	}
	
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmit() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(clkSubmit, 30).click();
		getReusableActionsInstance().clickIfAvailable(clkSubmit, 30);
	}
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitMobile() {
		getReusableActionsInstance().waitForElementVisibility(clkSubmit, 30);
		getReusableActionsInstance().executeJavaScriptClick(clkSubmit);
	}
	
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdate() {
		getReusableActionsInstance().getWhenReady(clkSubmitUpdate, 100).click();
	}

	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateTV() {
		getReusableActionsInstance().getWhenReady(clkSubmitUpdateSS, 100).click();
	}

	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateMobile() {
		getReusableActionsInstance().waitForElementVisibility(clkSubmitUpdateMobile, 120);
		getReusableActionsInstance().executeJavaScriptClick(clkSubmitUpdateMobile);
	}
	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateInternet() {
		getReusableActionsInstance().getWhenReady(clkSubmitUpdateInternet, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkSubmitUpdateInternet);
	}

	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateSAI() {
		getReusableActionsInstance().moveToElementAndClick(clkSubmitUpdateSAI,90);
	}

	/**
	 * Click on the Submit button on the order review page
	 * @author chinnarao.vattam
	 */
	public void clkSubmitUpdateInternetMobile() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(clkSubmitUpdateInternet,30);
		getReusableActionsInstance().executeJavaScriptClick(clkSubmitUpdateInternet);
	}
	
	/**
	 * Clicks on the 'Device Financing Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkShieldAgreementCheckbox() {
		getReusableActionsInstance().clickWhenReady(chbShieldTerms,60);
	}

	/**
	 * Clicks on the 'Terms and Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsAgreementCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(chbTerms, 60);
		getReusableActionsInstance().clickWhenReady(chbTerms,60);
	}

	/**
	 * Clicks on the 'Upfront Terms' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkUpfrontTermsCheckbox() {
		getReusableActionsInstance().clickWhenReady(chbUpfrontTerms,60);
	}

	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 */
	public void clkEmailDigitalCopy() {
		getReusableActionsInstance().waitForElementVisibility(rdbtnEmail,60);
		getReusableActionsInstance().clickWhenVisible(rdbtnEmail,60);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 * @param strEmail string email
	 */
	public void selectEmailDigitalCopy(String strEmail) {
		getReusableActionsInstance().clickIfAvailable(rdbtnEmail,30);
		if(getReusableActionsInstance().isElementVisible(txtCustomerEmail)) {
			txtCustomerEmail.sendKeys(strEmail);
		}
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmitOrder() {
		getReusableActionsInstance().clickWhenVisible(btnSubmitOrder,60);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenReady(btnContinue,60);
	}
	
	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 */
	public boolean isPaymentRequired() {
		return getReusableActionsInstance().isElementVisible(lblPaymentStep, 30);
	}

}