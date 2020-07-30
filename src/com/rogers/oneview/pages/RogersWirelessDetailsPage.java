package com.rogers.oneview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersWirelessDetailsPage extends BasePageClass {

	public RogersWirelessDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindAll({@FindBy(xpath = "//h2[contains(text(),'My Wireless Usage')]"),
			@FindBy(xpath = "//t[contains(text(),'My Wireless')]")})
	WebElement lblMyWlsUsage;

	@FindBy(xpath = "//a[@class='my-line-change-number']")
	WebElement lnkChangeMyCallerId;
		
	@FindBy(xpath = "//span[contains(@data-translate,'overview')]")
	WebElement lnkOverview;
	
	@FindBy(xpath = "//a[@class='ute-resetVoicemailPassword-link']")
	WebElement lnkUpdateMyVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='newVoicemailPassword']")
	WebElement txtNewVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='confirmVoicemailPassword']")
	WebElement txtConfirmVoicemailPwd;
	
	@FindBy(xpath = "//button[@class='ute-resetVoicemailPassword-submit']")
	WebElement btnVoicemailPwdSubmit;
	
	@FindBy(xpath = "//span[@translate='ute.voicemail.resetPassword.responseMessage.successMessage']")
	WebElement lblResetVoicemailPwdSuccess;
	
	//@FindBy(xpath = "//ins[@translate='plans.btnText']/ancestor::button")
	@FindBy(xpath = "//div[@class='manage-plan']//preceding-sibling::div//button")
	WebElement btnChangePlan;
	
	@FindBy(xpath = "//span[@translate='mppc_entry_1_change_current_plan']")
	WebElement lnkChangeCurrentPlan;
	
	//@FindBy(xpath = "//span[@class='plan-cta-text']")
	
	@FindAll({
		@FindBy(xpath = "//button[@title='Changer mon appareil pour un nouveau' or @title='Upgrade my device to a new one']"),
		@FindBy(xpath = "//div[@class='device-details']//button[@class='upgrade-button no-bg']")
	})
	WebElement btnUpgradeMyDevice;
	
	/**
	 * Validates whether Wireless page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessPageLoad() {
		return reusableActions.isElementVisible(lblMyWlsUsage);
	}
	
	/**
	 * Clicks on the 'Change My Caller Id' link
	 * @author rajesh.varalli1
	 */
	public void clickChangeMyCallerId() {
		reusableActions.scrollToElement(lnkChangeMyCallerId);
		reusableActions.clickIfAvailable(lnkChangeMyCallerId);
	}
	
	/**
	 * Clicks on the Overview button/link on the top menu
	 * @author rajesh.varalli1
	 */
	public void clickOverview() {
		reusableActions.clickIfAvailable(lnkOverview);
	}

	/**
	 * Validates and clicks on the 'Update My Voice mail Password' link
	 * @return true if link found; else false
	 * @author rajesh.varalli1
	 */
	public boolean clickUpdateMyVoicemailPwd() {
		if(reusableActions.isElementVisible(lnkUpdateMyVoicemailPwd, 60)) {
			reusableActions.scrollToElement(lnkUpdateMyVoicemailPwd);
			reusableActions.clickIfAvailable(lnkUpdateMyVoicemailPwd);
			return true;
		}
		return false;
	}
	
	/**
	 * Enters the password in the new voicemail password field
	 * @param strPassword New voicemail password
	 * @author rajesh.varalli1
	 */
	public void setNewVoicemailPassword(String strPassword) {
		txtNewVoicemailPwd.sendKeys(strPassword);
	}
	
	/**
	 * Enters the password in the confirm voicemail password field
	 * @param strPassword New voicemail password
	 * @author rajesh.varalli1
	 */
	public void setConfirmVoicemailPassword(String strPassword) {
		txtConfirmVoicemailPwd.sendKeys(strPassword);
	}
	
	/**
	 * Clicks on the 'Submit' button
	 * @author rajesh.varalli1
	 */
	public void clickSubmitButton() {
		reusableActions.clickIfAvailable(btnVoicemailPwdSubmit);
	}
	
	/**
	 * Validates the Reset Voicemail Password successful message
	 * @return true if message displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyResetVoicemailPasswordSuccess() {
		return reusableActions.isElementVisible(lblResetVoicemailPwdSuccess,60);
	}
	
	/**
	 * Clicks on the 'Change Plan' button
	 * @author rajesh.varalli1
	 */
	public void clickChangePlanButton() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnChangePlan, 60));
	}
	
	/**
	 * Clicks on the 'Make changes to your current plan' link on the overlay
	 * @author rajesh.varalli1
	 */
	public void clickMakeChangesToCurrentPlan() {
		reusableActions.clickIfAvailable(lnkChangeCurrentPlan);
	}
	
	/**
	 * Clicks on the 'Upgrade My Device' button
	 * @author rajesh.varalli1
	 */
	public void clkUpgradeMyDevice() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnUpgradeMyDevice));
	}

}