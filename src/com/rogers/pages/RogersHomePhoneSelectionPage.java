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

	@FindBy(xpath = "//ins[@translate='global.checkout.numberSelection.sections.section1.cta']")
	WebElement btnGeneratePhoneNumber;
	//ins[@translate='global.checkout.numberSelection.sections.section1.cta2']

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderPhoneNumberPage;

	@FindBy(xpath = "//span[contains(text(),'I’ll pick a new number, skip this.') or contains(text(),'Je veux choisir un nouveau numéro et passer à étape suivante.')]//ancestor::button/span")
	WebElement btnSkipforNewNumber;

	@FindBy(xpath = "//label[@for='number-1']")
	WebElement rdoChosePhoneNumber;
	
	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//button[@class='ute-btn-primary']")
	WebElement btnContinueHomePhoneSelection;
	
	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btnContinueHomePhoneSelectionMigration;
	
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
 * To set a number to have phone number consisting the given number
 * @param strChosePhoneNumber a digit to get the phone number with the digit
 * @author chinnarao.vattam
 */
	public void setPhoneNumberWith(String strChosePhoneNumber) {
		reusableActions.getWhenReady(txtChosePhoneNumber, 30).clear();
		reusableActions.getWhenReady(txtChosePhoneNumber, 3).sendKeys(strChosePhoneNumber);
	}
	
	/**
	 * To set a number to have phone number consisting the given number
	 * @return true if, Generate PhoneNumber button is available on home phone page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyPhoneNumberPage() {
		return	reusableActions.isElementVisible(btnGeneratePhoneNumber, 60);
	}

	/**
	 * To set a number to have phone number consisting the given number
	 * @return true if, Generate PhoneNumber button is available on home phone page, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPortInOutPage() {
		reusableActions.waitForElementInvisibility(loaderPhoneNumberPage,90);
		return	reusableActions.isElementVisible(btnPortInOutPage, 60);
	}
	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkSkipforNewNumber() {
		//Todo
		reusableActions.staticWait(2000);
		//reusableActions.getWhenReady(btnSkipforNewNumber,30).click();
	}

	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkPhoneNumberGenerator() {
		reusableActions.executeJavaScriptClick(btnGeneratePhoneNumber);
	}
		
	
	/**
	 *Select the radio button to select one phone number for the generated phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkChosePhoneNumber() {
		reusableActions.getWhenReady(rdoChosePhoneNumber, 60).click();
	}
	
	/**
	 *Click on Continue button after selecting the Phone number on the select phone number page 
	 * @author chinnarao.vattam
	 */
	public void clkContinueHomePhoneSelection() {
		reusableActions.waitForElementVisibility(btnContinueHomePhoneSelection, 180);
		reusableActions.getWhenReady(btnContinueHomePhoneSelection, 90).click();
	}
	
	/**
	 *Click on Continue button after selecting the Phone number on the select phone number page 
	 * @author chinnarao.vattam
	 */
	public void clkContinueHomePhoneSelectionMigration() {
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnContinueHomePhoneSelectionMigration, 90);
		reusableActions.executeJavaScriptClick(btnContinueHomePhoneSelectionMigration);
		reusableActions.clickIfAvailable(popupNoContinue,30);
	}
	
	

}
