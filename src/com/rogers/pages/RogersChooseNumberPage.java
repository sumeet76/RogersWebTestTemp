package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

	@FindBy(xpath = "//*[@id='line-choose-number-1']//span[@checkout-res='checkout_choose_number']")
	WebElement lblLineChooseNumber2;

	
	/**
	 * To verify the Rogers choose number Page load
	 * @author Saurav.Goyal
	 */
	public void verifyChooseNumberPageLoadedSuccessfully() {
		getReusableActionsInstance().waitForElementVisibility(btnSelectNewNumber.get(0),60);
	}

	/**
	 * Clicks on the 'Select a number for your new phone' button
	 * @author rajesh.varalli1
	 */
	public void clkSelectNewNumber() {
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().clickWhenReady(btnSelectNewNumber.get(0),60);
		getReusableActionsInstance().staticWait(2000);
	}

	/**
	 * Clicks on the 'Use an existing number' button
	 * @author rajesh.varalli1
	 */
	public void clickUseExistingNumber() {
		getReusableActionsInstance().clickWhenReady(btnUseExistingNumber.get(0));
	}

	/**
	 * Selects the city to find the phone number
	 * @param city Name of the City
	 * @author rajesh.varalli1
	 */
	public void selectCity(String city) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCity.get(0), city.toUpperCase());
	}

	/**
	 * Clicks on the 'FIND AVAILABLE NUMBERS' button
	 * @author rajesh.varalli1
	 */
	public void clkFindAvailableNumbers() {
		getReusableActionsInstance().scrollToElementAndClick(btnFindAvailableNumbers.get(0));
	}

	/**
	 * Selects the First option in the list of Phone Numbers displayed
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailableNumber() {
		getReusableActionsInstance().waitForElementVisibility(lblLineChooseNumber2, 30);
		getReusableActionsInstance().executeJavaScriptClick(rdAvailableNumbers.get(0));
	}

	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().waitForElementInvisibility(btnSave.get(0), 30);
		getReusableActionsInstance().clickWhenVisible(btnContinue);
		getReusableActionsInstance().waitForElementVisibility(btnContinue,30);
	}

	/**
	 * Clicks on the 'Save' button
	 * @author rajesh.varalli1
	 */
	public void clkSave() {
		getReusableActionsInstance().clickWhenVisible(btnSave.get(0));
	}

	public void selectNewPhoneNumber(String strCity) {
		for (int index = 0; index < lblCTNLines.size(); index++) {
			if(index != 0) {
				getReusableActionsInstance().clickWhenReady(By.xpath("//span[@checkout-res-param-index='"+ (index+1) +"']"));
			}
			getReusableActionsInstance().clickWhenReady(btnSelectNewNumber.get(index));
			getReusableActionsInstance().staticWait(2000);
			getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCity.get(index), strCity.toUpperCase());
			getReusableActionsInstance().scrollToElementAndClick(btnFindAvailableNumbers.get(0));
			getReusableActionsInstance().executeJavaScriptClick(rdAvailableNumbers.get(index*10));
			getReusableActionsInstance().clickWhenVisible(btnSave.get(index));
		}
	}

}