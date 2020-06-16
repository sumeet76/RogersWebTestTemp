package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSolarisRHPDashboardPage extends BasePageClass {

	public RogersSolarisRHPDashboardPage(WebDriver driver) {
		super(driver);
	}

	
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Home Phone')]"),
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-home-phone']})
	WebElement btnSolarisrhpBadge;

	@FindBy(xpath = "//ins[@translate='global.label.homePhoneDashboard']")
	WebElement infoSolarisrhpDashboard;

	@FindBy(xpath = "//ins[@usertype-translate='global.cta.configureYourFeatures']")
	WebElement lnkConfigureYourCurrentFeatures;

	@FindBy(xpath = "//ins[@usertype-translate='global.cta.accessYourVoicemailSettings']")
	WebElement lnkAccessYourVoicemailSettings;

	@FindBy(xpath = "//ins[@usertype-translate='global.cta.resetVoicemailPassword']")
	WebElement lnkResetYourVoicemailPassword;

	@FindBy(xpath = "//a[@aria-label='Need help? Chat with a Rogers agent.']")
	WebElement lnkLiveChatOnRHPDashboard;

	/**
	 * Click on the Solaris RHP badge 
     * @param strBrowser - Browser
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisRHPBadge(String strBrowser ) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.getWhenReady(btnSolarisrhpBadge, 30).click();		
		}else
		{
			reusableActions.clickWhenReady(btnSolarisrhpBadge, 60);
		}
	}

	/**
	 * Verify the configure your current features link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the configure your current features link, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyConfigureYourCurrentFeatures() {
		reusableActions.waitForElementVisibility(lnkConfigureYourCurrentFeatures, 120);
		return reusableActions.isElementVisible(lnkConfigureYourCurrentFeatures);
	}
	/**
	 * Verify the access your voice mail settings link onSolaris RHP dashboard
	 * @return true if the RHP dash board display the access your voice mail settings link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyAccessYourVoicemailSettings() {
		return reusableActions.isElementVisible(lnkAccessYourVoicemailSettings);
	}
	/**
	 * Verify the reset your voice mail password link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the reset your voice mail password link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyResetYourVoicemailPassword() {
		return reusableActions.isElementVisible(lnkResetYourVoicemailPassword);
	}
	/**
	 * Verify the live chat on RHP dashboard link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the live chat on RHP dashboard link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyLiveChatOnRHPDashboard() {
		return reusableActions.isElementVisible(lnkLiveChatOnRHPDashboard);
	}

}
