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
	
	@FindBy(xpath = "//ins[@translate='global.checkout.numberSelection.sections.section1.cta']")
	WebElement btnGeneratePhoneNumber;	
	//ins[@translate='global.checkout.numberSelection.sections.section1.cta2']
	
	@FindBy(xpath = "//label[@for='number-1']")
	WebElement rdoChosePhoneNumber;
	
	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//button[@class='ute-btn-primary']")
	WebElement btnContinueHomePhoneSelection;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
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
		reusableActions.waitForElementInvisibility(popupLoadingFingers, 120);
		return	reusableActions.isElementVisible(btnGeneratePhoneNumber, 60);
	}
	
	/**
	 * Click on Generate Phone Number button to generate phone numbers
	 * @author chinnarao.vattam
	 */
	public void clkPhoneNumberGenerator() {
		reusableActions.getWhenReady(btnGeneratePhoneNumber, 60).click();
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
		reusableActions.clickWhenReady(btnContinueHomePhoneSelection, 90);
	}

}
