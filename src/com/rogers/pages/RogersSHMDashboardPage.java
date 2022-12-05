package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.rogers.pages.base.BasePageClass;

public class RogersSHMDashboardPage extends BasePageClass {

	public RogersSHMDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@translate='shm_title']")
	WebElement titleSHMPage;
	
	@FindBy(xpath = "//a[@aria-label='Get insurance certificate']")
	WebElement lnkInsuranceCertificate;
	
	@FindBy(xpath = "//span[@translate='shm_shop_accessories']")	
	WebElement lnkShopForAccessories;
	
	@FindBy(xpath = "//a[@aria-label='Get started with tips and info about your new Smart Home system.']")
	WebElement lnkNewToSmartHome;
	
	@FindBy(xpath = "//a[@aria-label='Learn more about Smart Home Monitoring']")
	WebElement lnkLearnSmartHomeMonitoring;


	/**
	 *Checks if the SHM dashboard is open successfully
	 * @return true if the page is open, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifySHMDashBoardPageIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(titleSHMPage,60);
	}
	
	/**
	 * Verifies if the link Shop for accessories is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyShopForAccessoriesLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkShopForAccessories,30);
	}
	
	/**
	 * Verifies if the link New to smart home get started is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyNewToSmartHomeLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkNewToSmartHome,10);
	}
	
	/**
	 * Verifies if the link Inurance Certificate is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLearnAboutSmartHomeMonitoringLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkLearnSmartHomeMonitoring,60);
	}
	
	/**
	 * Verifies if the link Insurance Certificate is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyInsuranceCertificateLinkdisplayed()
	{
		return getReusableActionsInstance().isElementVisible(lnkInsuranceCertificate,10);
	}
	
	
}
