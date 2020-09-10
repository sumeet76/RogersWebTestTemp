package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChooseNumberPage extends BasePageClass {

	public RogersChooseNumberPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_select_new_number']")
	List<WebElement> btnSelectNewNumber;

	@FindBy(xpath = "//span[@checkout-res='checkout_use_existing_number']")
	List<WebElement> btnUseExistingNumber;

	@FindBy(xpath = "//button[@name='button_avail' and contains(@ng-click,'getAvailableNumbers')]")
	List<WebElement> btnFindAvailableNumbers;

	@FindBy(xpath = "//select[@name='selectedCity']")
	List<WebElement> ddlCity;

	@FindBy(xpath = "//div[contains(@class,'choose-number ctn')]/..//input[@type='radio']")
	List<WebElement> rdAvailableNumbers;

	@FindBy(xpath = "//button[contains(@class,'ctn-continue')]")
	WebElement btnContinue;

	@FindBy(xpath = "//button[contains(@class,'save-button')]")
	List<WebElement> btnSave;

	@FindBy(xpath = "//div[@ng-repeat='line in model.lineInfo']")
	List<WebElement> lblCTNLines;

	@FindBy(xpath = "//*[@id='line-choose-number-2']//span[@checkout-res='checkout_choose_number']")
	WebElement lblLineChooseNumber2;

	
	/**
	 * To verify the Rogers choose number Page load
	 * @author Saurav.Goyal
	 */
	public void verifyChooseNumberPageLoadedSuccessfully() {
		reusableActions.waitForElementVisibility(btnSelectNewNumber.get(0),60);
	}

	/**
	 * Clicks on the 'Select a number for your new phone' button
	 * @author rajesh.varalli1
	 */
	public void clkSelectNewNumber() {
		reusableActions.staticWait(2000);
		reusableActions.clickWhenReady(btnSelectNewNumber.get(0),60);
		reusableActions.staticWait(2000);
	}

	/**
	 * Clicks on the 'Use an existing number' button
	 * @author rajesh.varalli1
	 */
	public void clickUseExistingNumber() {
		reusableActions.clickWhenReady(btnUseExistingNumber.get(0));
	}

	/**
	 * Selects the city to find the phone number
	 * @param city Name of the City
	 * @author rajesh.varalli1
	 */
	public void selectCity(String city) {
		reusableActions.selectWhenReadyByVisibleText(ddlCity.get(0), city.toUpperCase());
	}

	/**
	 * Clicks on the 'FIND AVAILABLE NUMBERS' button
	 * @author rajesh.varalli1
	 */
	public void clkFindAvailableNumbers() {
		reusableActions.scrollToElementAndClick(btnFindAvailableNumbers.get(0));
	}

	/**
	 * Selects the First option in the list of Phone Numbers displayed
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailableNumber() {
		reusableActions.waitForElementVisibility(lblLineChooseNumber2, 30);
		reusableActions.executeJavaScriptClick(rdAvailableNumbers.get(0));
	}

	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.waitForElementInvisibility(btnSave.get(0), 30);
		reusableActions.clickWhenVisible(btnContinue);
		reusableActions.waitForElementVisibility(btnContinue,30);
	}

	/**
	 * Clicks on the 'Save' button
	 * @author rajesh.varalli1
	 */
	public void clkSave() {
		reusableActions.clickWhenVisible(btnSave.get(0));
	}

	public void selectNewPhoneNumber(String strCity) {
		for (int index = 0; index < lblCTNLines.size(); index++) {
			if(index != 0) {
				reusableActions.clickWhenReady(By.xpath("//span[@checkout-res-param-index='"+ (index+1) +"']"));
			}
			reusableActions.clickWhenReady(btnSelectNewNumber.get(index));
			reusableActions.staticWait(2000);
			reusableActions.selectWhenReadyByVisibleText(ddlCity.get(index), strCity.toUpperCase());
			reusableActions.scrollToElementAndClick(btnFindAvailableNumbers.get(0));
			reusableActions.executeJavaScriptClick(rdAvailableNumbers.get(index*10));
			reusableActions.clickWhenVisible(btnSave.get(index));
		}
	}

}