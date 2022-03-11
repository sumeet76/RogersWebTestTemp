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

	@FindAll({
	@FindBy(xpath = "//h1[@class='-mb8']"),
	@FindBy(xpath = "//*[@translate='global.label.internet']")})
	WebElement infoInternet;

	//@FindBy(xpath = "//span[@translate='global.dashboard.internetUsage.usageAndAlerts']")
	@FindBy(xpath = "//*[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted']")
	WebElement lnkInternetUsageAlerts;

	@FindBy(xpath = "//*[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted']")
	//@FindBy(xpath = "//*[@usertype-translate='global.label.usageAndAlerts' or @translate='global.dashboard.internet.usage']")
	WebElement infoUsageAndAlerts;

	@FindBy(xpath = "//div[contains(@class,'change-internet-button')]//button")
	WebElement btnSolChangeInternetPackage;
	//span[@translate='global.dashboard.common.changeInternetPackage']

	@FindBy(xpath = "//h1[@class='header-1 primary']")
	WebElement txtIgniteWifiHub;

	@FindBy(xpath = "//div[@class='live-support']")
	WebElement popupContatUS;
	
	@FindBy(xpath = "//div[@class='popup-modal-body__content']")
	WebElement popupContatUSInternetDowngarde;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
	WebElement popUpInternetPopup;

	//@FindBy(xpath = "//span[@id='ariaChangeWifiPassword']/ancestor::span[@role='text']")
	@FindBy(xpath = "//a[@aria-label='Change your WiFi password. The link will open a new tab in your browser.']//span[@class='ds-icon d-inline-flex rds-icon-open-new']")
	WebElement btnWifiPassword;

	@FindBy(xpath = "//div[@id='terms-conditions']")
	WebElement infoAgreement;
	
	@FindBy(xpath = "//span[text()='Continue']")
	WebElement btnInternetChangeOK;


	@FindBy(xpath = "//span[@id='ariaNoInternetOnly']/ancestor::a//ds-icon[@name='chevron-right']")
	WebElement btnSmartstreamPack;

	@FindBy(xpath = "//button[contains(@class,'-primary -large ng-star-inserted')]")
	WebElement btnSAInternetChangeOK;
	
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
	
	@FindBy(xpath = "//a[@href='#']/img")
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

	@FindBy(xpath = "//div[@id='va-chat-canned-responses1']")
	WebElement btnVAOptions;

	@FindBy(xpath = "//a[@href='#' and  text()='Ignite Internet']")
	WebElement optsIgniteInternet;

	@FindBy(xpath = "//div[@id='va-chat-canned-responses4']")
	WebElement optsInternetIssues;

	@FindBy(xpath = "//h1[@class='smart-stream-opt-in-modal__header']")
	WebElement headerSmartStreamModal;

	@FindBy(xpath = "//a[contains(@aria-label,'Reject')]/span")
	WebElement btnNoThanks;

	@FindBy(xpath = "//a[contains(@aria-label,'continue')]/span/span")
	WebElement btnContinue;

	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @return true if the Internet usage displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetUsage() {	
		return getReusableActionsInstance().isElementVisible(txtInternetUsage,30);
	}

	public boolean verifyInternetUsageMobile() {
		return getReusableActionsInstance().isElementVisible(txtInternetUsage,110);
	}

	/**
	 * Verify the Internet usage on the Internet dash board page
	 * @author Chinnarao.Vattam
	 */
	public void clkChangeInternetPackage() {
			getReusableActionsInstance().getWhenReady(btnChangeInternetPackage,90).click();
	}
	
	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 * @author Chinnarao.Vattam
	 */
	public void clkSolarisInternetBadge() {
		getReusableActionsInstance().getWhenReady(btnSolarisInternetBadge,60).click();
	}

	/**
	 * Click the Solaris Internet Badge on the Solaris account page
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetBadgeMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementVisibility(btnSolarisInternetBadge,90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolarisInternetBadge);
	}
	/**
	 * Verify the Internet header text on the Solaris Internet dash board
	 * @return true if the Internet heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternet() {		
		return getReusableActionsInstance().isElementVisible(infoInternet,40);
	}

	/**
	 * Click on the Internet Usage Alerts link on solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetUsageAlerts() {
		getReusableActionsInstance().waitForElementVisibility(lnkInternetUsageAlerts,60);
		getReusableActionsInstance().executeJavaScriptClick(lnkInternetUsageAlerts);

	}
	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dash board
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyUsageAndAlerts() {		
		return getReusableActionsInstance().isElementVisible(infoUsageAndAlerts,30);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkInternetPopup() {
		getReusableActionsInstance().clickIfAvailable(popUpInternetPopup, 60);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkIgniteInternetOption() {
		getReusableActionsInstance().clickIfAvailable(optsIgniteInternet, 60);
	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dash board
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetIssues() {
		return getReusableActionsInstance().isElementVisible(optsInternetIssues,30);
	}

	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkWifiPassword() {
		getReusableActionsInstance().clickIfAvailable(btnWifiPassword, 60);
	}

	/**
	 * Verify the Internet Usage Alerts link on Solaris Internet dash board
	 * @return true if the Internet Usage Alerts link displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyChangeWifiPassword() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		return getReusableActionsInstance().isElementVisible(btnWifiPassword,30);
	}

	/**
	 * Click the PDF link on MyChannelLineup popup
	 * @return true if the PDF is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean SwitchIgnitewifiPage() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2);
		getReusableActionsInstance().switchToNewWindow(mainWindow);
		//the page is moving to new window
		getReusableActionsInstance().staticWait(1000);
		return true;
	}

	public boolean verifyIgniteWifiHub() {
		return getReusableActionsInstance().isElementVisible(txtIgniteWifiHub, 90);
	}

	/**
	 * Click the Change Internet Package button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackage() {
		getReusableActionsInstance().staticWait(10000);

		getReusableActionsInstance().waitForElementVisibility(btnSolChangeInternetPackage, 120);
		getReusableActionsInstance().getWhenReady(btnSolChangeInternetPackage, 60).click();
	}
	
	/**
	 * Click the Change Internet Package button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSolChangeInternetPackageMobile() {	
		getReusableActionsInstance().waitForElementVisibility(btnSolChangeInternetPackage, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolChangeInternetPackage);
	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkInternetChangeOK() {		
		getReusableActionsInstance().clickIfAvailable(btnInternetChangeOK, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSmartstreamPack() {
		getReusableActionsInstance().clickIfAvailable(btnSmartstreamPack, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkSAInternetChangeOK() {
		getReusableActionsInstance().clickIfAvailable(btnSAInternetChangeOK, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyInternetPage() {	
		return getReusableActionsInstance().isElementVisible(txtInternet, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAButton() {		
		getReusableActionsInstance().getWhenReady(btnVaButton, 10).click();

	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMenu() {	
		getReusableActionsInstance().getWhenReady(btnVaMenu, 20).click();
	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAMininmize() {		
		getReusableActionsInstance().getWhenReady(btnVAMininmize, 10).click();

	}
	
	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVAClose() {		
		getReusableActionsInstance().getWhenReady(btnVAClose, 10).click();

	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVAButton() {	
		return getReusableActionsInstance().isElementVisible(btnVaButton, 10);
	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcome() {
		return getReusableActionsInstance().isElementVisible(txtVaWelcome, 90);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToVAIFrame() {
		getDriver().switchTo().frame(ifrmVA);
//		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaTopicList() {	
		return getReusableActionsInstance().isElementVisible(selVaTopicList, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVaWelcomeSend() {
		return getReusableActionsInstance().isElementVisible(btnVaWelcomeSend, 30);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyVAOptions() {
		return getReusableActionsInstance().isElementVisible(btnVAOptions, 30);
	}

	/**
	 * Click the Change Internet Package OK button on Solaris Internet dash board
	 * @author Chinnarao.Vattam
	 */
	public void clkVaWelcomeSend() {
		getReusableActionsInstance().getWhenReady(btnVaWelcomeSend, 10);
		getReusableActionsInstance().executeJavaScriptClick(btnVaWelcomeSend);
	}


	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifycontatUSPopUp() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers, 60);
		return getReusableActionsInstance().isElementVisible(popupContatUS, 20);
	}
	
	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyContatUSInternetDowngarde() {
		if (getReusableActionsInstance().isElementVisible(popupLoadingFingersInternet, 30)){
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersInternet, 60);
		}
		return getReusableActionsInstance().isElementVisible(popupContatUSInternetDowngarde, 20);
	}

	/**
	 * Checks if the pop up contact us is visible
	 * @return true when pop up contact us is visible else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyContatUSInternetDowngardeInternet() {
		getReusableActionsInstance().waitForElementVisibility(popupContatUSInternetDowngarde, 60);
		return getReusableActionsInstance().isElementVisible(popupContatUSInternetDowngarde, 20);
	}
	

	/**
	 * Select the  Internet Package on change Internet package page
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageOld(String strPackageNameEn,String strPackageNameFr) {
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		if(getReusableActionsInstance().isElementVisible(btnPackageSelection, 60))
		{		
	    getReusableActionsInstance().getWhenReady(btnPackageSelection, 30).click();
		 }
	   else
		{
	    getReusableActionsInstance().getWhenReady(imgNext, 90).click();
	    getReusableActionsInstance().isElementVisible(btnPackageSelection, 60);
	    getReusableActionsInstance().getWhenReady(btnPackageSelection, 30).click();
		}
	}

	
	/**
	 * Select Solaris Internet Package
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage(String strPackageNameEn,String strPackageNameFr) {
		getReusableActionsInstance().staticWait(5000);
		By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='change-internet-bundle-tile__row']//button[contains(@aria-label,'Add Rogers Ignite')]/span");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().getWhenReady(pkg,60).click();
	}

	/**
	 * Select Solaris Internet Package
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMobile(String strPackageNameEn,String strPackageNameFr) {
		getReusableActionsInstance().staticWait(3000);
		By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='change-internet-sai-tile__row']//button[contains(@aria-label,'Add Ignite Internet')]/span");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	/**
	 * Select Solaris Internet Package
	 * @param strPackageNameEn package name
	 * @param strPackageNameFr package name
	 * @author Chinnarao.Vattam
	 */
	public void selectStandAloneInternetPackage(String strPackageNameEn,String strPackageNameFr) {
		//By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]/ancestor::div[@class='internet-bundle-tile__row']//button[contains(@aria-label,'Add Ignite Internet')]");
		By packageNameLocator = By.xpath("//div[@class='change-internet-sai-tile__price']//button[contains(@aria-label,'" + strPackageNameEn+ "') or contains(@aria-label,'" + strPackageNameFr+ "')]/span");
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}
	/**
	 * Select the  Internet Package on change Internet package page
	 * @param strPackageNameEn Internet package to be selected
	 * @param strPackageNameFr Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectInternetPackageMobile(String strPackageNameEn,String strPackageNameFr) {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersMobile,120);
		By btnPackageSelection = By.xpath("//span[contains(normalize-space(text()),'" + strPackageNameEn+ "') or contains(normalize-space(text()),'" + strPackageNameFr +"')]");
		if(getReusableActionsInstance().isElementVisible(btnPackageSelection, 60))
		{		
	    getReusableActionsInstance().getWhenReady(btnSelectInternetPackageMobile, 30).click();
		 }
	   else
		{
	    getReusableActionsInstance().getWhenReady(imgNext, 90).click();
	    getReusableActionsInstance().isElementVisible(btnPackageSelection, 60);
	    getReusableActionsInstance().getWhenReady(btnSelectInternetPackageMobile, 30).click();
		}
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersMobile,120);
	}
	
	/**
	 * Select the  Internet Package on change Internet package page for migration flow
	 * @param strPackageName Internet package to be selected
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackageMigration(String strPackageName) {
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName
				+ "') or contains(normalize-space(text()),'Élan Internet gigabit')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingers,90);
		getReusableActionsInstance().getWhenReady(packageNameLocator, 60).click();
	}
	
	/**
	 * Select Solaris Internet Package
	 * @param strPackageName package name
	 * @author Chinnarao.Vattam
	 */
	public void selectSolarisInternetPackage1(String strPackageName) {		
		By packageNameLocator = By.xpath("//span[contains(normalize-space(text()),'" + strPackageName+ "') or contains(normalize-space(text()),'Élan Internet 150i')]/ancestor::div[@class='owl-item active']//ins[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 90).click();
	}

	/**
	 * Verify Smart Stream Modal
	 * @retun true if smart stream modal present
	 * @author Manpreet.Kaur3
	 */
	public boolean verifySmartStreamHeader() {
		return getReusableActionsInstance().isElementVisible(headerSmartStreamModal,30);
	}

	/**
	 * Close Smart Stream Modal
	 * @author Manpreet.Kaur3
	 */
	public void clkOnNoThanks() {
		getReusableActionsInstance().waitForElementVisibility(btnNoThanks, 30);
		getReusableActionsInstance().getWhenReady(btnNoThanks, 20).click();

	}

    public void clkContinueToChangeInternetPackage() {
		getReusableActionsInstance().waitForElementVisibility(btnContinue, 20);
		getReusableActionsInstance().getWhenReady(btnContinue, 20).click();
    }
}
