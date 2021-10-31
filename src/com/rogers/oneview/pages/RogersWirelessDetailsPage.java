package com.rogers.oneview.pages;

import org.openqa.selenium.By;
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

	@FindAll({
			@FindBy(xpath = "//h2[contains(text(),'My Wireless Usage')]"),
			@FindBy(xpath = "//t[contains(text(),'My Wireless') or contains(.,'Mon forfait')]")
	})
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
	@FindBy(xpath = "(//div[contains(@class,'upgrade-button')])[1]//button[1]")
	WebElement btnChangePlan;
	
	@FindBy(xpath = "//span[@translate='mppc_entry_1_change_current_plan']")
	WebElement lnkChangeCurrentPlan;
	
	//@FindBy(xpath = "//span[@class='plan-cta-text']")

	@FindAll({
			@FindBy(xpath = "//button[contains(@class,'upgrade-button') and (contains(.,'Upgrade') or contains(.,'Rehausser'))]"),
			@FindBy(xpath = "//t[contains(.,'Upgrade') or contains(.,'Rehausser')]/ancestor::button")
	})
	WebElement btnUpgradeMyDevice;

	@FindBy(xpath = "//h4[contains(.,'customer type') or contains(.,'type de client')]/following-sibling::div//t[contains(.,'Consumer') or contains(.,'Consommateur')]")
	WebElement btnConsumerCusType;

	@FindBy(xpath = "//h4[contains(.,'customer type') or contains(.,'type de client')]/following-sibling::div//t[contains(.,'SOHO') or contains(.,'Petites')]")
	WebElement btnSohoCusType;

	@FindBy(xpath = "//h4[contains(.,'customer type') or contains(.,'type de client')]/following-sibling::div//t[contains(.,'Rogers')]")
	WebElement btnRPPCusType;

	@FindBy(xpath = "//ds-modal-container")
	WebElement modalContainer;


	/**
	 * Validates whether Wireless page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessPageLoad() {
		//getReusableActionsInstance().waitForElementVisibility(lblMyWlsUsage);
		return getReusableActionsInstance().isElementVisible(lblMyWlsUsage , 40);
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
	 * Validates the Reset Voicemail Password successful message
	 * @return true if message displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyResetVoicemailPasswordSuccess() {
		return getReusableActionsInstance().isElementVisible(lblResetVoicemailPwdSuccess,60);
	}
	
	/**
	 * Clicks on the 'Change Plan' button
	 * @author rajesh.varalli1
	 */
	public void clickChangePlanButton() {
		getReusableActionsInstance().scrollToElement(btnChangePlan);
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnChangePlan, 60));
	}
	
	/**
	 * Clicks on the 'Upgrade My Device' button
	 * @author rajesh.varalli1
	 */
	public void clkUpgradeMyDevice() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblMyWlsUsage);
		getReusableActionsInstance().waitForElementVisibility(btnUpgradeMyDevice , 30);
		getReusableActionsInstance().executeJavaScriptClick(btnUpgradeMyDevice);
		getReusableActionsInstance().waitForElementInvisibility(btnUpgradeMyDevice,30);
	}

	/**
	 * This method selects the customer type in the customer type modal
	 * @param className Name of the class
	 * @author praveen.kumar7
	 */
	public void setCustomerType(String className) {
		if(className.toUpperCase().contains("SOHO")) {
			getReusableActionsInstance().clickWhenReady(btnSohoCusType);
		}
		else if(className.toUpperCase().contains("RPP")) {
			getReusableActionsInstance().clickWhenReady(btnRPPCusType);
		}
		else getReusableActionsInstance().clickWhenReady(btnConsumerCusType);
	}

}