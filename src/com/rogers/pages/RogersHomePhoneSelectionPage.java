package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersHomePhoneSelectionPage extends BasePageClass {

	public RogersHomePhoneSelectionPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='digits']")
	WebElement txtChosePhoneNumber;

	@FindBy(xpath = "//h1[@class='rhp-port-in__header']")
	WebElement btnPortInOutPage;

	@FindBy(xpath = "//h2[@class='fr-spacing-top-30 -text-semi']")
	WebElement txtPhoneNumberSelectionPage;
	//h1[@class='fr-spacing-top-30 -text-semi']

	@FindBy(xpath = "//span[@class='ng-star-inserted']/ancestor::button[@type='submit']")
	WebElement btnGeneratePhoneNumber;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderPhoneNumberPage;

	@FindBy(xpath = "//span[@id='ariaPickNewNumber']//ancestor::a//span[@role='text']")
	WebElement btnSkipforNewNumber;
	//span[contains(text(),'new number') or contains(text(),'Je veux choisir un nouveau')]//ancestor::button

	@FindBy(xpath = "//label[@for='number-1']")
	WebElement rdoChosePhoneNumber;
	
	@FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::a")
	WebElement btnContinueHomePhoneSelection;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -tertiary -large ng-star-inserted']")
	WebElement popupNoContinue;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
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
 * To set a number to have phone number consisting the given number
 * @param strChosePhoneNumber a digit to get the phone number with the digit
 * @author chinnarao.vattam
 */
	public void setPhoneNumberWith(String strChosePhoneNumber) {
		getReusableActionsInstance().getWhenReady(txtChosePhoneNumber, 30).clear();
		getReusableActionsInstance().getWhenReady(txtChosePhoneNumber, 3).sendKeys(strChosePhoneNumber);
	}
	
	/**
	 * To set a number to have phone number consisting the given number
	 * @return true if, Generate PhoneNumber button is available on home phone page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyPhoneNumberPage() {
		return	getReusableActionsInstance().isElementVisible(txtPhoneNumberSelectionPage, 60);
	}

	/**
	 * To set a number to have phone number consisting the given number
	 * @return true if, Generate PhoneNumber button is available on home phone page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPortInOutPage() {
		if(getReusableActionsInstance().isElementVisible(loaderPhoneNumberPage,10)) {
			getReusableActionsInstance().waitForElementInvisibilityNOException(loaderPhoneNumberPage,20);
		}
		return	getReusableActionsInstance().isElementVisible(btnPortInOutPage, 90);
	}
	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkSkipforNewNumber() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnSkipforNewNumber, 60).click();
	  }

	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkSkipforNewNumberMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementVisibility(btnSkipforNewNumber, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnSkipforNewNumber);
	}
	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkPhoneNumberGenerator() {
		getReusableActionsInstance().executeJavaScriptClick(btnGeneratePhoneNumber);
	}
		
	
	/**
	 *Select the radio button to select one phone number for the generated phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkChosePhoneNumber() {
		getReusableActionsInstance().getWhenReady(rdoChosePhoneNumber, 60).click();
	}
	
	/**
	 *Click on Continue button after selecting the Phone number on the select phone number page 
	 * @author chinnarao.vattam
	 */
	public void clkContinueHomePhoneSelection() {
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().waitForElementVisibility(btnContinueHomePhoneSelection, 120);
		getReusableActionsInstance().executeJavaScriptClick(btnContinueHomePhoneSelection);
	}

	/**
	 *Click on Continue button after selecting the Phone number on the select phone number page
	 * @author chinnarao.vattam
	 */
	public void clkContinueHomePhoneMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueHomePhoneSelection, 120);
		getReusableActionsInstance().executeJavaScriptClick(btnContinueHomePhoneSelection);
	}
	/**
	 *Click on Continue button after selecting the Phone number on the select phone number page
	 * @author chinnarao.vattam
	 */
	public void clkContinueHomePhonePage() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueHomePhoneSelection, 120);
		getReusableActionsInstance().getWhenReady(btnContinueHomePhoneSelection, 90).click();
	}
}
