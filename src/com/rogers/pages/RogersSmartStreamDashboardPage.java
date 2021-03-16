package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersSmartStreamDashboardPage extends BasePageClass {

	public RogersSmartStreamDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='/customer/support/article/using-voice-commands']//span[@class='-mr4']")
	WebElement lnkUsingVoiceCommands;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/using-apps-on-ignite-tv']//span[@class='-mr4']")
	WebElement lnkUsingAppsOnIgniteTv;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/ignite-tv-power-saver']//span[@class='-mr4']")
	WebElement lnkIgniteTvPowerSaver;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/ignite-tv-error-codes']//span[@class='-mr4']")
	WebElement lnkIgniteTvErrorCodes;
	
	@FindBy(xpath = "//a[@href='/consumer/support/tv/IgniteTV']")
	WebElement lnkGoToSupportSection;

	@FindBy(xpath = "//h1[@class='ng-star-inserted']")
	WebElement txtSmartStream;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popLoader;



	/**
	 *Checks if SmartStream dash board  displayed
	 * @return true if the page is open, else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySmartStreamdashboard() {
		return getReusableActionsInstance().isElementVisible(txtSmartStream,60);
	}

	/**
	 *Checks if SmartStream Using Voice Commands link is displayed
	 * @return true if the page is open, else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyUsingVoiceCommandsLinkdisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkUsingVoiceCommands,20);
	}
	
	/**
	 * Checks if SmartStream Using Apps On Ignite Tv link is displayed
	 * @return true if the link is available else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyUsingAppsOnIgniteTvLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkUsingAppsOnIgniteTv,30);
	}
	
	/**
	 * Checks if SmartStream Ignite Tv Power Saver link is displayed
	 * @return true if the link is available else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyIgniteTvPowerSaverLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkIgniteTvPowerSaver,10);
	}
	
	/**
	 * Checks if SmartStream Ignite Tv Error Codes link is displayed
	 * @return true if the link is available else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyIgniteTvErrorCodesLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkIgniteTvErrorCodes,10);
	}
	
	/**
	 * Checks if SmartStream Go To Support Section link is displayed
	 * @return true if the link is available else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyGoToSupportSectionLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection,10);
	}
	
	
}
