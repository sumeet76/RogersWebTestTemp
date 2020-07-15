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
	
	@FindBy(xpath = "//span[@translate='shm_insur_cert']")
	WebElement lnkInsuranceCertificate;
	
	@FindBy(xpath = "//span[@translate='shm_shop_accessories']")	
	WebElement lnkShopForAccessories;
	
	@FindBy(xpath = "//span[@translate='shm_get_started']")
	WebElement lnkNewToSmartHome;
	
	@FindBy(xpath = "//span[@translate='shm_learn_more']")
	WebElement lnkLearnSmartHomeMonitoring;
	
	

	
	/**
	 *Checks if the SHM dashboard is open successfully
	 * @return true if the page is open, else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifySHMDashBoardPageIsDisplayed() {
		return reusableActions.isElementVisible(titleSHMPage,60);
	}
	
	/**
	 * Verifies if the link Shop for accessories is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyShopForAccessoriesLinkdisplayed()
	{
		return reusableActions.isElementVisible(lnkShopForAccessories,10);
	}
	
	/**
	 * Verifies if the link New to smart home get started is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyNewToSmartHomeLinkdisplayed()
	{
		return reusableActions.isElementVisible(lnkNewToSmartHome,10);
	}
	
	/**
	 * Verifies if the link Inurance Certificate is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyLearnAboutSmartHomeMonitoringLinkdisplayed()
	{
		return reusableActions.isElementVisible(lnkLearnSmartHomeMonitoring,10);
	}
	
	/**
	 * Verifies if the link Insurance Certificate is displayed
	 * @return true if the link is available else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyInsuranceCertificateLinkdisplayed()
	{
		return reusableActions.isElementVisible(lnkInsuranceCertificate,10);
	}
	
	
}
