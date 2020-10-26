package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

		
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Internet')]"),
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-internet']")})	
	WebElement btnSolarisInternetBadge;

	@FindBy(xpath = "//*[@translate='global.label.internet']")
	WebElement infoInternet;

	@FindBy(xpath = "//span[@translate='global.dashboard.internetUsage.usageAndAlerts']")
	WebElement lnkInternetUsageAlerts;
	
	@FindBy(xpath = "//*[@usertype-translate='global.label.usageAndAlerts' or @translate='global.dashboard.internet.usage']")
	WebElement infoUsageAndAlerts;

	@FindBy(xpath = "//span[@translate='global.dashboard.common.changeInternetPackage']")
	WebElement btnSolChangeInternetPackage;

	@FindBy(xpath = "//div[@class='live-support']")
	WebElement popupContatUS;
	
	@FindBy(xpath = "//div[@class='popup-modal-body__content']")
	WebElement popupContatUSInternetDowngarde;
	
	@FindBy(xpath = "//span[@class='ute-icon-circle-x']")
	WebElement popUpInternetPopup;
	
	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;
	
	@FindBy(xpath = "//a[@class='btn ute-btn-primary btn-block-xs ute-sm custom-modal-button']")
	WebElement btnInternetChangeOK;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;	
	
	@FindBy(xpath = "//div[@class='preloader loading-secondary']")
	WebElement popupLoadingFingersMobile;
	
	@FindBy(xpath = "//div[@class='owl-item active']//ins[@translate='global.cta.select']")
	WebElement btnSelectInternetPackageMobile;
	
	@FindBy(xpath = "//button[@id='va-button']")
	WebElement btnVaButton;
	
	@FindBy(xpath = "//h1[@translate='global.label.internet']")
	WebElement txtInternet;
	
	@FindBy(xpath = "//a[@href='#' and @class='mat-menu-trigger va-header-ham-button']")
	WebElement btnVaMenu;
	//a[@class='mat-menu-trigger va-header-ham-button']
	
	@FindBy(xpath = "//button[@id='va-menu-minimum-button']")
	WebElement btnVAMininmize;

	@FindBy(xpath = "//iframe[@id='va-iframe']")
	WebElement ifrmVA;

	
	@FindBy(xpath = "//div[@id='va-welcome-header']")
	WebElement txtVaWelcome;
	
	@FindBy(xpath = "//input[@id='va-welcome-input']")
	WebElement txtVaCustomerName;
	
	@FindBy(xpath = "//button[@id='va-welcome-send-button']")
	WebElement btnVaWelcomeSend;
	
	@FindBy(xpath = "//input[@name='va-welcome-input']")
	WebElement selVaTopicList;
	
	@FindBy(xpath = "//button[@id='va-menu-close-button']")
	WebElement btnVAClose;
	
	
	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @return true if the Internet usage displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetUsage() {	
		return reusableActions.isElementVisible(txtInternetUsage,30);
	}

	public boolean verifyInternetUsageMobile() {
		return reusableActions.isElementVisible(txtInternetUsage,110);
	}

	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @author Chinnarao.Vattam
	 */
	public void clkChangeInternetPackage() {
			reusableActions.getWhenReady(btnChangeInternetPackage,90).click();
	}
	
	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisInternetBadge() {
		reusableActions.getWhenReady(btnSolarisInternetBadge,60).click();
	}

	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetBadgeMobile() {
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.waitForElementVisibility(btnSolarisInternetBadge,90);
		reusableActions.executeJavaScriptClick(btnSolarisInternetBadge);
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
		reusableActions.waitForElementVisibility(lnkInternetUsageAlerts,60);
		reusableActions.executeJavaScriptClick(lnkInternetUsageAlerts);

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
		reusableActions.waitForElementVisibility(btnSolChangeInternetPackage, 90);
		reusableActions.getWhenReady(btnSolChangeInternetPackage, 60).click();
	}
	
	/**
	 * Click the Change Internet Package button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackageMobile() {	
		reusableActions.waitForElementVisibility(btnSolChangeInternetPackage, 90);
		reusableActions.executeJavaScriptClick(btnSolChangeInternetPackage);
	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetChangeOK() {		
		reusableActions.clickIfAvailable(btnInternetChangeOK, 30);

	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetPage() {	
		return reusableActions.isElementVisible(txtInternet, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAButton() {		
		reusableActions.getWhenReady(btnVaButton, 10).click();

	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMenu() {	
		reusableActions.getWhenReady(btnVaMenu, 20).click();
	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMininmize() {		
		reusableActions.getWhenReady(btnVAMininmize, 10).click();

	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAClose() {		
		reusableActions.getWhenReady(btnVAClose, 10).click();

	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVAButton() {	
		return reusableActions.isElementVisible(btnVaButton, 10);
	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcome() {
		return reusableActions.isElementVisible(txtVaWelcome, 90);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToVAIFrame() {
		driver.switchTo().frame(ifrmVA);
//		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaTopicList() {	
		return reusableActions.isElementVisible(selVaTopicList, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcomeSend() {
		return reusableActions.isElementVisible(btnVaWelcomeSend, 30);
	}


	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifycontatUSPopUp() {
		reusableActions.waitForElementInvisibility(popupLoadingFingers, 60);		
		return reusableActions.isElementVisible(popupContatUS, 20);
	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyContatUSInternetDowngarde() {
		reusableActions.waitForElementInvisibility(popupLoadingFingersInternet, 90);		
		return reusableActions.isElementVisible(popupContatUSInternetDowngarde, 20);
	}
	
	

	/**
	 * Select the  Internet Package on change Internet package page
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageOld(String strPackageNameEn,String strPackageNameFr) {
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.javascriptScrollToMiddleOfPage();
		if(reusableActions.isElementVisible(btnPackageSelection, 60))
		{		
	    reusableActions.getWhenReady(btnPackageSelection, 30).click();	
		 }
	   else
		{
	    reusableActions.getWhenReady(imgNext, 90).click();  
	    reusableActions.isElementVisible(btnPackageSelection, 60);
	    reusableActions.getWhenReady(btnPackageSelection, 30).click();	
		}
	}

	
	/**
	 * Select Solaris Internet Package
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage(String strPackageNameEn,String strPackageNameFr) {	
		By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='internet-bundle-tile__row']//button[contains(@aria-label,'Add Rogers Ignite')]");
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(packageNameLocator, 90);
		WebElement pkg = driver.findElement(packageNameLocator);
		reusableActions.executeJavaScriptClick(pkg);
	}

	/**
	 * Select Solaris Internet Package
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectStandAloneInternetPackage(String strPackageNameEn,String strPackageNameFr) {
		By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='internet-bundle-tile__row']//button[contains(@aria-label,'Add Ignite Internet')]");
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(packageNameLocator, 90);
		WebElement pkg = driver.findElement(packageNameLocator);
		reusableActions.executeJavaScriptClick(pkg);
	}
	/**
	 * Select the  Internet Package on change Internet package page
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMobile(String strPackageNameEn,String strPackageNameFr) {
		reusableActions.waitForElementInvisibility(popupLoadingFingersMobile,120);
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]");
		if(reusableActions.isElementVisible(btnPackageSelection, 60))
		{		
	    reusableActions.getWhenReady(btnSelectInternetPackageMobile, 30).click();	
		 }
	   else
		{
	    reusableActions.getWhenReady(imgNext, 90).click();  
	    reusableActions.isElementVisible(btnPackageSelection, 60);
	    reusableActions.getWhenReady(btnSelectInternetPackageMobile, 30).click();	
		}
		reusableActions.waitForElementInvisibility(popupLoadingFingersMobile,120);
	}
	
	/**
	 * Select the  Internet Package on change Internet package page for migration flow
	 * @param strPackageName Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMigration(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName
				+ "') or contains(normalize-space(text()),'Élan Internet gigabit')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.waitForElementInvisibility(popupLoadingFingers,90);
		reusableActions.getWhenReady(packageNameLocator, 60).click();
	}
	
	/**
	 * Select Solaris Internet Package
	 * @param strPackageName package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage1(String strPackageName) {		
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName+ "') or contains(normalize-space(text()),'Élan Internet 150i')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		reusableActions.getWhenReady(packageNameLocator, 90).click();
	}
}
