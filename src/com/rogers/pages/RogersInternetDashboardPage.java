package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.rogers.pages.base.BasePageClass;

public class RogersInternetDashboardPage extends BasePageClass {

	public RogersInternetDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='row usage-ctn']")
	WebElement txtInternetUsage;

	@FindBy(xpath = "//span[@data-test-id='myr-internetMyPackage-managePackage']")
	WebElement btnChangeInternetPackage;

	@FindBy(xpath = "//span[@class='ute-icon-internet']")
	WebElement btnSolarisInternetBadge;

	@FindBy(xpath = "//ins[@translate='global.label.internet']")
	WebElement infoInternet;

	@FindBy(xpath = "//a[contains(@class,'btn ute-btn-secondary')]")
	WebElement lnkInternetUsageAlerts;

	@FindBy(xpath = "//ins[@usertype-translate='global.label.usageAndAlerts']")
	WebElement infoUsageAndAlerts;

	@FindBy(xpath = "//ins[@translate='global.cta.changeInternetPackage']")
	WebElement btnSolChangeInternetPackage;

	@FindBy(xpath = "//div[@class='live-support']")
	WebElement popupContatUS;
	
	@FindBy(xpath = "//span[@class='ute-icon-circle-x']")
	WebElement popUpInternetPopup;
	
	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;

	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @return true if the Internet usage displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetUsage() {	
		return reusableActions.isElementVisible(txtInternetUsage,30);
	}

	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @param strBrowser - Browser
	 * @author Chinnarao.Vattam
	 */
	public void clkChangeInternetPackage(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.waitForElementVisibility(btnChangeInternetPackage,120);
		reusableActions.scrollToElement(btnChangeInternetPackage);
		reusableActions.getWhenReady(btnChangeInternetPackage,90).click();
		}else
		{
			reusableActions.getWhenReady(btnChangeInternetPackage,90).click();
		}
	}
	
	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 * @param strBrowser - Browser
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisInternetBadge(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.getWhenReady(btnSolarisInternetBadge,90).click();
			
		}
		else 
		{
		reusableActions.clickWhenReady(btnSolarisInternetBadge,40);
		}
	}

	/**
	 * Verify the Internet header text on the Solaris Internet dash board
	 * @return true if the Internet heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternet() {		
		return reusableActions.isElementVisible(infoInternet,40);		
	}

	/**
	 * Click on the Internet Usage Alerts link on solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetUsageAlerts() {		
		reusableActions.clickWhenReady(lnkInternetUsageAlerts,40);

	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dash board
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyUsageAndAlerts() {		
		return reusableActions.isElementVisible(infoUsageAndAlerts,30);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkInternetPopup() {
		reusableActions.clickIfAvailable(popUpInternetPopup, 40);
	}

	/**
	 * Click the Change Internet Package button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackage() {		
		reusableActions.clickWhenReady(btnSolChangeInternetPackage, 60);

	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifycontatUSPopUp() {		
		return reusableActions.isElementVisible(popupContatUS, 90);
	}

	/**
	 * Select the  Internet Package on change Internet package page
	 * @param strPackageName Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName+ "') or contains(normalize-space(text()),'" + strPackageName +"')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.javascriptScrollToMiddleOfPage();
    	for (int iteration = 0 ; iteration < 2 ;  iteration++ )
		{                  
    	 if(reusableActions.isElementVisible(packageNameLocator, 60)) 
    	 {
    	  reusableActions.getWhenReady(packageNameLocator, 20).click();
    	  reusableActions.waitForElementInvisibility(popupLoadingFingers,120);
         }  	  
	   }
    	reusableActions.waitForElementVisibility(infoAgreement, 60);
	}
	
	/**
	 * Select the  Internet Package on change Internet package page for migration flow
	 * @param strPackageName Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMigration(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName
				+ "') or contains(normalize-space(text()),'Élan Internet gigabit')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.waitForElementInvisibility(popupLoadingFingers,180);
		reusableActions.getWhenReady(packageNameLocator, 120).click();
	}
	
	/**
	 * Select Solaris Internet Package
	 * @param strPackageName package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage1(String strPackageName) {		
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName+ "') or contains(normalize-space(text()),'Élan Internet 150i')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.getWhenReady(packageNameLocator, 180).click();
	}
}
