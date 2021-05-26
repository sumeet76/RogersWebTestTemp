package com.rogers.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RogersSpeedPassPage extends BasePageClass {

	public RogersSpeedPassPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (xpath = "//ss-select-data-topup")
	WebElement topUpSpeedPass;
	
	@FindBy (xpath = "//div[@class='selected-plan-details-item']")
	WebElement slctMaxSpeedData;

	@FindBy (xpath = "//div[@class='selected-plan-details-item']")
	List<WebElement> SpeedPasses;
	
	@FindBy (xpath = "//a[contains(@class,'continue-button')]")
	WebElement btnContinueSpeedPass;
	
	@FindBy (xpath = "//span[@translate='purchaseData.purchasingPlansConfirmationModal.titleSP']")
	WebElement headerConfirmPurchase;
	
	@FindBy (xpath = "//ins[@translate='purchaseData.purchaseBtn']")
	WebElement btnPurchaseSP;
	
	@FindBy (xpath = "//h2[@class='add-data-modal-title success-title']")
	WebElement msgSuccessAddedSP;

	@FindAll({
	@FindBy(xpath = "//ds-modal-container//button[@title='Close']"),
	@FindBy (xpath = "//span[@class='ds-icon rds-icon-error' or @class='ds-icon rds-icon-close']")})
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
		return (getReusableActionsInstance().isElementVisible(topUpSpeedPass, 30)
				||getReusableActionsInstance().isElementVisible(lblCannotAddSpeedPass, 30));
	}
	
	/**
	 * Click the Max Speed Data in speed pass pop up
	 * @author ning.xue
	 */
	public void clkMaxSpeedDataInSpeedPassPopup() {		
		getReusableActionsInstance().getWhenReady(slctMaxSpeedData, 20).click();
	} 
	
	/**
	 * Click the continue button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnContinueInSpeedPassPopup() {
		getReusableActionsInstance().getWhenReady(btnContinueSpeedPass, 20).click();
	} 
	
	/**
	 * To verify if the header Confirm Purchase display in speed pass pop up
	 * @return true if the header Confirm Purchase displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyHeaderConfirmPurchaseIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerConfirmPurchase, 30);
	} 
	
	/**
	 * Click the Purchase button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnPurchaseInSpeedPassPopup() {
		getReusableActionsInstance().getWhenReady(btnPurchaseSP, 20).click();
	} 
	
	/**
	 * To verify if the Message Success Added Speed Pass display in speed pass pop up
	 * @return true if the header message displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyMsgSuccessAddedSpeedPassIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(msgSuccessAddedSP, 30);
	} 
	
	/**
	 * Click the Close button in speed pass pop up
	 * @author ning.xue
	 */
	public void clkBtnCloseInSpeedPassPopup() {
		getReusableActionsInstance().getWhenReady(btnCloseSpeedPassTopup, 20).click();
		getReusableActionsInstance().staticWait(5000);
	}
	
	/**
	 * verifies if the overlay Cannot add speed pass header is displayed
	 * @return true if the overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCannotAddSpeedPassHeaderIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblCannotAddSpeedPass);
	}


    public boolean verifyIfTopUpPriceIsCorrect() {
		HashMap<String,String> speedPassPrice = new HashMap<String,String>();
		speedPassPrice.put("3","20.00");
		speedPassPrice.put("10","40.00");
		for(int opt=0; opt<=SpeedPasses.size()-1;opt++)
		{
			String SpeedPassDataValue= SpeedPasses.get(opt).getText().split("\n")[0];
			String SpeedPassPriceValue= SpeedPasses.get(opt).getText().split("\n")[2];
			SpeedPassDataValue= getNumbersFromString(SpeedPassDataValue);
			SpeedPassPriceValue= getNumbersFromString(SpeedPassPriceValue);
			if(!speedPassPrice.get(SpeedPassDataValue).equals(SpeedPassPriceValue))
			{
				return false;
			}
		}

		return  true;


    }


	/**
	 * This will extract the numbers from string
	 * @param strMatch complete string to be matched
	 * @return String number
	 */
	public String getNumbersFromString(String strMatch) {
		Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
		Matcher match = pattern.matcher(strMatch.replaceAll(",", "."));
		match.find();
		return match.group();
	}

}

