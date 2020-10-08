package com.rogers.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSpeedPassPage extends BasePageClass {

	public RogersSpeedPassPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (xpath = "//ss-select-data-topup")
	WebElement topUpSpeedPass;
	
	@FindBy (xpath = "//div[@class='selected-plan-details-item']")
	WebElement slctMaxSpeedData;
	
	@FindBy (xpath = "//a[contains(@class,'continue-button')]")
	WebElement btnContinueSpeedPass;
	
	@FindBy (xpath = "//span[@translate='purchaseData.purchasingPlansConfirmationModal.titleSP']")
	WebElement headerConfirmPurchase;
	
	@FindBy (xpath = "//ins[@translate='purchaseData.purchaseBtn']")
	WebElement btnPurchaseSP;
	
	@FindBy (xpath = "//h2[@class='add-data-modal-title success-title']")
	WebElement msgSuccessAddedSP;
	
	@FindBy (xpath = "//span[@class='ds-icon rds-icon-error' or @class='ds-icon rds-icon-close']")
	WebElement btnCloseSpeedPassTopup;
	
	@FindBy(xpath = "//h2[@class='add-data-modal-title error-title']")
	WebElement lblCannotAddSpeedPass;
	
	@FindBy(xpath = "//div[@class='selected-plan-details']")
	WebElement divAddSpeedPassSelectPlan;
		
	@FindBy (xpath = "//div[@class='selected-plan-details-item selected']/div")
	WebElement maxSpeedDataToBeAdded;
	
	/**
	 * To verify if the speed pass pop up display in wireless dashboard page
	 * @return true if the pop up displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifySpeedPassPopupIsDisplayed() {
		return (reusableActions.isElementVisible(topUpSpeedPass, 30)
				||reusableActions.isElementVisible(lblCannotAddSpeedPass, 30));
	}
	
	/**
	 * Click the Max Speed Data in speed pass pop up
	 * @author ning.xue
	 */
	public void clkMaxSpeedDataInSpeedPassPopup() {		
		reusableActions.getWhenReady(slctMaxSpeedData, 20).click();		
	} 
	
	/**
	 * Click the continue button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnContinueInSpeedPassPopup() {
		reusableActions.getWhenReady(btnContinueSpeedPass, 20).click();
	} 
	
	/**
	 * To verify if the header Confirm Purchase display in speed pass pop up
	 * @return true if the header Confirm Purchase displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyHeaderConfirmPurchaseIsDisplayed() {
		return reusableActions.isElementVisible(headerConfirmPurchase, 30);
	} 
	
	/**
	 * Click the Purchase button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnPurchaseInSpeedPassPopup() {
		reusableActions.getWhenReady(btnPurchaseSP, 20).click();
	} 
	
	/**
	 * To verify if the Message Success Added Speed Pass display in speed pass pop up
	 * @return true if the header message displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyMsgSuccessAddedSpeedPassIsDisplayed() {
		return reusableActions.isElementVisible(msgSuccessAddedSP, 30);
	} 
	
	/**
	 * Click the Close button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnCloseInSpeedPassPopup() {
		reusableActions.getWhenReady(btnCloseSpeedPassTopup, 20).click();
	}
	
	/**
	 * verifies if the overlay Cannot add speed pass header is displayed
	 * @return true if the overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCannotAddSpeedPassHeaderIsDisplayed() {
		return reusableActions.isElementVisible(lblCannotAddSpeedPass);
	}



}

