package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * 
 * @author rajesh.varalli1
 *
 */

public class RogersLinkAccountPage extends BasePageClass {

	public RogersLinkAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(@class,'myrLinkAccount-title')]/span[@translate='myrLinkAccount_title']")
	WebElement lblLinkAccount;
	
	@FindBy(xpath = "//div[contains(@class,'myrLinkAccount')]/input[@name='accountNumber']")
	WebElement txtAccountNumber;
	
	@FindBy(xpath = "//div[contains(@class,'myrLinkAccount')]/input[@name='postalCode']")
	WebElement txtPostalCode;
	
	@FindBy(xpath = "//button[@data-ng-click='submitPostPaidAccount()']")
	WebElement btnLinkAccount;
	
	/**
	 * Validates if the Link Account page is loaded successfully
	 * @return true if Link Account title found ;  else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyLinkAccountPageLoad() {
		return reusableActions.isElementVisible(lblLinkAccount);
	}
	
	/**
	 * Enters the Account Number
	 * @param strAccountNumber Account Number
	 * @author rajesh.varalli1
	 */
	public void setAccountNumber(String strAccountNumber) {
		reusableActions.getWhenReady(txtAccountNumber, 30).sendKeys(strAccountNumber);
	}
	
	/**
	 * Enters the Postal Code
	 * @param strPostalCode Postal Code in A1A1A1 format
	 * @author rajesh.varalli1
	 */
	public void setPostalCode(String strPostalCode) {
		reusableActions.getWhenReady(txtPostalCode, 30).sendKeys(strPostalCode);
	}
	
	/**
	 * Clicks on the 'Link Account' button
	 * @author rajesh.varalli1
	 */
	public void clkBtnLinkAccount() {
		reusableActions.getWhenReady(btnLinkAccount, 30).click();
		reusableActions.staticWait(50000);
	}
}