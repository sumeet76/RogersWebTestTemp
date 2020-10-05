package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChangeMyCallerIdPage extends BasePageClass {

	public RogersChangeMyCallerIdPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//p[contains(text(),'exceeded the limit for Caller ID changes.') or contains(text(),'atteint la limite de changements')]")
	WebElement msgExceedLimit;
	
	@FindBy (xpath = "//button[contains(@class,'exceeded-close-button')]/span")
	WebElement btnDoneInExceedLimitOverlay;
	
	@FindBy(xpath = "//input[@id='caller-firstName']/parent::div")
	WebElement divCallerIdFirstName;
	
	@FindBy(xpath = "//input[@id='caller-firstName']")
	WebElement txtCallerIdFirstName;

	@FindBy(xpath = "//input[@id='caller-lastName']/parent::div")
	WebElement divCallerIdLastName;
	
	@FindBy(xpath = "//input[@id='caller-lastName']")
	WebElement txtCallerIdLastName;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continuer')]")
	WebElement btnContinue;

	@FindBy(xpath = "//span[contains(text(),'Submit') or contains(text(),'Soumettre')]")
	WebElement btnSubmit;

	@FindBy(xpath = "//p[contains(text(),'Caller ID changed') or contains(text(),'des appels a été modifié')]")
	WebElement lblChangeCallerIdSuccess;
	
	@FindBy (xpath = "//img[@src='./assets/images/widget-loader.gif']")
	WebElement imgLoading;

	@FindBy(xpath = "//button[@title='Done' or @title='Terminé']")
	WebElement btnDone;
	
	@FindBy (xpath = "//span[contains(text(),'Live Chat') or contains(text(),'Clavardage en direct')]")
	WebElement lnkLiveChat;
	
	/**
	 * Check if the change caller ID exceed limit pop up displayed
	 * @return true if the pop up is visible, otherwise false
	 * @author ning.xue
	 */
	public boolean isExceedLimitOverlayPopup() {
		return reusableActions.isElementVisible(msgExceedLimit, 10);
	}
	
	/**
	 * Click Done button in Exceed limit overlay.
	 * @author ning.xue
	 */
	public void clkBtnDoneInExceedLimitOverlay() {
		reusableActions.clickWhenReady(btnDoneInExceedLimitOverlay, 10);
	}
	
	/**
	 * Sets the First Name for the new Caller ID
	 * @param strFirstName First name for the new Caller ID
	 * @author rajesh.varalli1
	 */
	public void setNewCallerIdFirstName(String strFirstName) {
		reusableActions.getWhenReady(divCallerIdFirstName, 20).click();
		reusableActions.getWhenReady(txtCallerIdFirstName,10).clear();
		reusableActions.getWhenReady(txtCallerIdFirstName).sendKeys(strFirstName);
	}
	
	/**
	 * Sets the Last Name for the new Caller ID
	 * @param strLastName Last name for the new Caller ID 
	 * @author rajesh.varalli1
	 */
	public void setNewCallerIdLastName(String strLastName) {
		reusableActions.getWhenReady(divCallerIdLastName, 10).click();
//		reusableActions.getWhenReady(txtCallerIdFirstName,10).clear();
		reusableActions.getWhenReady(txtCallerIdLastName).sendKeys(strLastName);
	}
	
	/**
	 * Click on the Continue button
	 * @author rajesh.varalli1
	 */
	public void clickContinue() {
		reusableActions.getWhenReady(btnContinue,30).click();
	}
	
	/**
	 * Clicks on 'Update And Continue' button
	 * @author rajesh.varalli1
	 */
	public void clickSubmit() {
		reusableActions.getWhenReady(btnSubmit,30).click();
	}
	
	/**
	 * Validates successful Caller ID change message
	 * @return true if message displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyCallerIdChangeSuccessMsg() {
		return reusableActions.isElementVisible(lblChangeCallerIdSuccess,60);
	}
	
	/**
	 * Clicks on the 'Done' button
	 * @author rajesh.varalli1
	 */
	public void clickDone() {
		if (reusableActions.isElementVisible(imgLoading)) {
			reusableActions.waitForElementInvisibility(imgLoading, 30);
		}
		reusableActions.getWhenReady(btnDone,20).click();
	}
	
	/**
	 * Validates live chat link in exceed limit overlay
	 * @return true if the link displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkLiveChatOnExceedLimitOverlay() {
		return reusableActions.isElementVisible(lnkLiveChat,20);
	}
	
	/**
	 * Clicks on 'Live Chat' link
	 * @author ning.xue
	 */
//TODO
	public void clkLinkLiveChatOnExceedLimitOverlay() {
		reusableActions.getWhenReady(lnkLiveChat,30).click();
		reusableActions.staticWait(1000);
		reusableActions.getWhenReady(lnkLiveChat,10).click();
	}
}