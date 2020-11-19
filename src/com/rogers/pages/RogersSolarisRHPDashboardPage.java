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
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-home-phone']")})
	WebElement btnSolarisrhpBadge;

	@FindBy(xpath = "//ins[@translate='global.label.homePhoneDashboard']")
	WebElement infoSolarisrhpDashboard;

	@FindBy(xpath = "//span[@translate='ute.rogers.rhpDashboard.homePhone']")
	WebElement infoLegacyrhpDashboard;

	@FindBy(xpath = "//span[contains(text(),'Configure your current features') or contains(text(),'Configuration des fonctions')]")
	WebElement lnkConfigureYourCurrentFeatures;
    //ins[@usertype-translate='global.cta.configureYourFeatures']

	@FindBy(xpath = "//span[contains(text(),'Access your voicemail settings') or contains(text(),'Paramètres de messagerie vocale')]")
	WebElement lnkAccessYourVoicemailSettings;
	//ins[@usertype-translate='global.cta.accessYourVoicemailSettings']

	@FindBy(xpath = "//span[contains(text(),'Reset your voicemail password') or contains(text(),'Mot de passe de la messagerie')]")
	WebElement lnkResetYourVoicemailPassword;
   //ins[@usertype-translate='global.cta.resetVoicemailPassword']

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
		getReusableActionsInstance().getWhenReady(btnSolarisrhpBadge, 30).click();
		}else
		{
			getReusableActionsInstance().clickWhenReady(btnSolarisrhpBadge, 60);
		}
	}

	/**
	 * To Verify the RHP Banner on the Legacy RHP dash board
	 * @return true if the package name is Home Phone ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyRHPBanner() {
		return getReusableActionsInstance().isElementVisible(infoLegacyrhpDashboard, 20);
	}

	/**
	 * Verify the configure your current features link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the configure your current features link, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyConfigureYourCurrentFeatures() {
		getReusableActionsInstance().waitForElementVisibility(lnkConfigureYourCurrentFeatures, 120);
		return getReusableActionsInstance().isElementVisible(lnkConfigureYourCurrentFeatures);
	}
	/**
	 * Verify the access your voice mail settings link onSolaris RHP dashboard
	 * @return true if the RHP dash board display the access your voice mail settings link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyAccessYourVoicemailSettings() {
		return getReusableActionsInstance().isElementVisible(lnkAccessYourVoicemailSettings);
	}
	/**
	 * Verify the reset your voice mail password link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the reset your voice mail password link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyResetYourVoicemailPassword() {
		return getReusableActionsInstance().isElementVisible(lnkResetYourVoicemailPassword);
	}
	/**
	 * Verify the live chat on RHP dashboard link on Solaris RHP dashboard
	 * @return true if the RHP dash board display the live chat on RHP dashboard link, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verfyLiveChatOnRHPDashboard() {
		return getReusableActionsInstance().isElementVisible(lnkLiveChatOnRHPDashboard);
	}

}
