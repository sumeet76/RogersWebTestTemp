package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersSecurityPackagesPage extends BasePageClass {

	public RogersSecurityPackagesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Learn how to get a Security package']")
	WebElement lnkHowToGetSecurityPackages;
	
	@FindBy(xpath = "//shm-ways-to-buy-modal//p[@class='ds-modal__heading text-title-3 mb-24']")
	WebElement popupSecurityPackagesModel;

	@FindAll({@FindBy(xpath = "//a[@href='1-855-214-6825']"),
	@FindBy(xpath = "//a[@href='1 855 214-6825']")})
	WebElement lnkSecurityPackagesByCall;

	@FindBy(xpath = "//a[contains(@title,'Call Rogers at') or contains(@title,'Call Rogers at')]")
	WebElement lnkSHMCC;

	@FindBy(xpath = "//a[@href='livechat']")
	WebElement lnkSecurityPackagesByLivechat;

	@FindBy(xpath = "//a[@title='Live Chat with Rogers']")
	WebElement lnkLiveChatwithRogers;

	@FindAll({
	@FindBy(xpath = "//a[@href='/stores/']"),
	@FindBy(xpath = "//a[@href='https://www.rogers.com/stores/']")})
	WebElement lnkSecurityPackagesFromStore;

	@FindBy(xpath = "//a[@title='Find a Rogers store']")
	WebElement lnkFindRogersStore;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-chevron-down']")
	WebElement btnSeefullDetails;

	@FindBy(xpath = "//iframe[@name='bc-window']")
	WebElement ifrmLiveChat;

	@FindBy(xpath = "//input[@id='1.No']")
	WebElement rdoNoShmOption;

	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-minimize']")
	WebElement btnCloseLivechat;

	@FindBy(xpath = "//div[@class='bc-headbtn-icon bc-headbtn-close-icon']")
	WebElement btnCloseLivechatOption;

	@FindBy(xpath = "//h1[@class='SearchHero-title']")
	WebElement txtStorePage;

	@FindBy(xpath = "//p[contains(text(),'Protect') or contains(text(),'Protection')]/ancestor::ds-tile//button[@title='View more details about the Protect package' or @title='Afficher plus de détails sur le forfait Protection']")
	WebElement btnProtectPackDetails;

	@FindBy(xpath = "//p[contains(text(),'Protect') or contains(text(),'Protection')]/ancestor::ds-tile//button[@title='How to get the Protect package'  or @title='Comment obtenir le forfait Protection']//ds-icon//span")
	WebElement btnHowToGetItProtectPack;

	@FindBy(xpath = "//p[contains(text(),'Assure') or contains(text(),'Tranquillité')]/ancestor::ds-tile//button[@title='View more details about the Assure package' or @title='Afficher plus de détails sur le forfait Tranquillité']")
	WebElement btnAssurePackDetails;

	@FindBy(xpath = "//p[contains(text(),'Assure') or contains(text(),'Tranquillité')]/ancestor::ds-tile//button[@title='How to get the Assure package'  or @title='Comment obtenir le forfait Tranquillité']//ds-icon//span")
	WebElement btnHowToGetItAssurePack;

	@FindBy(xpath = "//p[contains(text(),'Control') or contains(text(),'Contrôle')]/ancestor::ds-tile//button[@title='View more details about the Control package' or @title='Afficher plus de détails sur le forfait Contrôle']")
	WebElement btnControlPackDetails;

	@FindBy(xpath = "//p[contains(text(),'Control') or contains(text(),'Contrôle')]/ancestor::ds-tile//button[@title='How to get the Control package'  or @title='Comment obtenir le forfait Contrôle']//ds-icon//span")
	WebElement btnHowToGetItControl;

	@FindBy(xpath = "//ds-modal-container[@id='ds-modal-container-0']")
	WebElement popupPackageDetails;

	@FindBy(xpath = "//button[@title='close modal']")
	WebElement popupPackageDetailsCloseModal;

	@FindBy(xpath = "//p[contains(text(),'Protect') or contains(text(),'Protection')]")
	WebElement txtProtectPackageDetails;

	@FindBy(xpath = "//p[contains(text(),'Assure') or contains(text(),'Tranquillité')]")
	WebElement txtAssurePackageDetails;

	@FindBy(xpath = "//p[contains(text(),'Control') or contains(text(),'Contrôle')]")
	WebElement txtControlPackageDetails;

	@FindBy(xpath = "//a[contains(@title,'View Smart Home Monitoring hardware') or contains(@title,'View Smart Home Monitoring hardware')]")
	WebElement btnViewHardware;

	@FindBy(xpath = "//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtHardwarePage;

	@FindBy(xpath = "//a[contains(@title,'View Smart Home Monitoring features') or contains(@title,'View Smart Home Monitoring features')]")
	WebElement btnSHMfeatures;

	@FindBy(xpath = "//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtSHMFeasturePage;

	@FindBy(xpath = "//a[contains(@title,'Learn more about the Smart Home Monitoring app') or contains(@title,'Learn more about the Smart Home Monitoring app')]")
	WebElement btnHomeMonitoringapp;

	@FindBy(xpath = "//img[contains(@src,'English-AppHero.png')]")
	WebElement txtSHMAppPage;

	@FindBy(xpath = "//a[contains(@title,'View Automate package') or contains(@title,'View Automate package')]")
	WebElement btnViewAutomatePackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/consumer/support/homemonitoring']")
	WebElement lnkSHMSupport;

	@FindBy(xpath = "//h1[@class='dsa-billboard__copyHeading mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtAutomationPackagePage;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='Products']/ancestor::a//ds-icon[@name='down']")
	WebElement subNavProducts;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='App']/ancestor::a//ds-icon[@name='right']")
	WebElement subNavApp;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='Help and Support']/ancestor::a//ds-icon[@name='down']")
	WebElement subNavHelpAndSupport;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/support/moving-your-services']")
	WebElement subNavMovingYourServices;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/home-monitoring/why']")
	WebElement lnkWhySHM;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='automation-packages']")
	WebElement lnkAutomatePackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='security-packages']")
	WebElement lnkSecurityPackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/home-monitoring/hardware']")
	WebElement lnkHardwarePackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/home-monitoring/features']")
	WebElement lnkFeatures;

	//+++++++++++++++++++++++++++++++++++++++++//
	@FindBy(xpath = "//a[@title='Learn how to get the Automate package']")
	WebElement btnHowToGetAutomatePackage;


	/**
	 * Verify the Title of the page
	 * @param strActualTitle initial Actual Title
	 * @param strLanguage language of the application
	 * @return true, if the Title is matched, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifySecurityPackagesPageTitle(String strActualTitle, String strLanguage ) {
		if (strLanguage.equalsIgnoreCase("en"))
		{
			String strExpectedTitle = "Shop Home Security, Monitoring, Video Surveillance Packages | Rogers";
			strExpectedTitle.equalsIgnoreCase(strActualTitle);
			getReusableActionsInstance().getWhenReady(lnkHowToGetSecurityPackages, 60);
			return true;
		}
		else
		{//by the time of scripting, application is not impemented for french
			String strExpectedTitle = "Shop Home Security, Monitoring, Video Surveillance Packages | Rogers";
			strExpectedTitle.equalsIgnoreCase(strActualTitle);
			getReusableActionsInstance().getWhenReady(lnkHowToGetSecurityPackages, 60);
			return true;
		}

	}

	/**
	 * Verify the Title of the page
	 * @param strActualTitle initial Actual Title
	 * @param strLanguage language of the application
	 * @return true, if the Title is matched, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyAutomationPackagesPageTitle(String strActualTitle, String strLanguage ) {
		if (strLanguage.equalsIgnoreCase("en"))
		{
			String strExpectedTitle = "Shop Home Automation | Rogers";
			strExpectedTitle.equalsIgnoreCase(strActualTitle);
			getReusableActionsInstance().getWhenReady(txtAutomationPackagePage, 60);
			return true;
		}
		else
		{//by the time of scripting, application is not impemented for french
			String strExpectedTitle = "Shop Home Automation | Rogers";
			strExpectedTitle.equalsIgnoreCase(strActualTitle);
			getReusableActionsInstance().getWhenReady(txtAutomationPackagePage, 60);
			return true;
		}

	}

	/**
	 * Click on Get Security Packages by call
	 * @author chinnarao.vattam
	 */
	public void clkSecurityPackagesByCall() {
		getReusableActionsInstance().getWhenReady(lnkSecurityPackagesByCall, 60).click();
	}

	/**
	 * Click on Get Security Packages by Livechat
	 * @author chinnarao.vattam
	 */
	public void clkSecurityPackagesByLivechat() {
		getReusableActionsInstance().getWhenReady(lnkSecurityPackagesByLivechat, 60).click();
	}

	/**
	 * Click on Get Security Packages from Store
	 * @author chinnarao.vattam
	 */
	public void clkSecurityPackagesFromStore() {
		getReusableActionsInstance().getWhenReady(lnkSecurityPackagesFromStore, 60).click();
	}

	/**
	 * Checks if Security Packages Model is displayed
	 * @return true if the Security Packages Model is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySecurityPackagesModelDisplayed()
	{
		getReusableActionsInstance().waitForElementVisibility(popupSecurityPackagesModel, 90);
		return getReusableActionsInstance().isElementVisible(popupSecurityPackagesModel);
	}

	/**
	 * Click on How To Get Security Packages button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetSecurityPackages() {
		getReusableActionsInstance().getWhenReady(lnkHowToGetSecurityPackages, 60).click();
	}

	/**
	 * Checks if HowToGet Security Packages is displayed
	 * @return true if the LiveChat frame is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyHowToGetSecurityPackages()
	{
		getReusableActionsInstance().waitForElementVisibility(lnkHowToGetSecurityPackages, 90);
		return getReusableActionsInstance().isElementVisible(lnkHowToGetSecurityPackages);
	}

	/**
	 * Checks if LiveChat frame is displayed
	 * @return true if the LiveChat frame is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyIfrmLiveChatDisplayed()
	{
		getReusableActionsInstance().waitForElementVisibility(ifrmLiveChat, 90);
		return getReusableActionsInstance().isElementVisible(ifrmLiveChat);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToLivechatIFrame() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(ifrmLiveChat,10);
		getDriver().switchTo().frame(ifrmLiveChat);
	}

	/**
	 * Click on No Shm Option
	 * @author chinnarao.vattam
	 */
	public void clkNoShmOption() {
		getReusableActionsInstance().getWhenReady(rdoNoShmOption, 90).click();
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Click on Close Livechat button
	 * @author chinnarao.vattam
	 */
	public void clkCloseLivechat() {
		getReusableActionsInstance().waitForElementVisibility(btnCloseLivechat, 90);
		getReusableActionsInstance().getWhenReady(btnCloseLivechat, 60).click();
	}

	/**
	 * Checks if Store Page is displayed
	 * @return true if the Store Page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyStorePageDisplayed()
	{
		getReusableActionsInstance().waitForElementVisibility(txtStorePage, 30);
		return getReusableActionsInstance().isElementVisible(txtStorePage);
	}

	/**
	 * Click on Protect Pack Details button
	 * @author chinnarao.vattam
	 */
	public void clkProtectPackDetails() {
		getReusableActionsInstance().getWhenReady(btnProtectPackDetails, 60).click();
	}
	/**
	 * Click on How To Get It Protect Pack Button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetItProtectPack() {
		getReusableActionsInstance().waitForElementVisibility(btnHowToGetItProtectPack, 90);
		getReusableActionsInstance().getWhenReady(btnHowToGetItProtectPack, 60).click();
	}
	/**
	 * Click on Assure Pack Details button
	 * @author chinnarao.vattam
	 */
	public void clkAssurePackDetails() {
		getReusableActionsInstance().getWhenReady(btnAssurePackDetails, 60).click();
	}
	/**
	 * Click on How To Get It Assure Pack button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetItAssurePack() {
		getReusableActionsInstance().waitForElementVisibility(btnHowToGetItAssurePack, 90);
		getReusableActionsInstance().getWhenReady(btnHowToGetItAssurePack, 60).click();
	}
	/**
	 * Click on Control Pack Details button
	 * @author chinnarao.vattam
	 */
	public void clkControlPackDetails() {
		getReusableActionsInstance().getWhenReady(btnControlPackDetails, 60).click();
	}
	/**
	 * Click on How To Get It Control button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetItControlPack() {
		getReusableActionsInstance().getWhenReady(btnHowToGetItControl, 60).click();
	}


	/**
	 * Checks if Package Details popup is displayed
	 * @return true if the Package Details popup is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifypopupPackageDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(popupPackageDetails, 30);
		return getReusableActionsInstance().isElementVisible(popupPackageDetails);
	}

	/**
	 * Click on Package Details Close button
	 * @author chinnarao.vattam
	 */
	public void clkPackageDetailsCloseModal() {
		getReusableActionsInstance().getWhenReady(popupPackageDetailsCloseModal, 60).click();
	}


	/**
	 * Checks if Protect Package Details is displayed
	 * @return true if the Protect Package Details is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyProtectPackageDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(txtProtectPackageDetails, 90);
		return getReusableActionsInstance().isElementVisible(txtProtectPackageDetails);
	}

	/**
	 * Checks if Assure Package Details is displayed
	 * @return true if the Assure Package Details is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyAssurePackageDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(txtAssurePackageDetails, 30);
		return getReusableActionsInstance().isElementVisible(txtAssurePackageDetails);
	}

	/**
	 * Checks if Control Package Details is displayed
	 * @return true if the Control Package Details is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyControlPackageDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(txtControlPackageDetails, 30);
		return getReusableActionsInstance().isElementVisible(txtControlPackageDetails);
	}

	/**
	 * Click on View Hardware button
	 * @author chinnarao.vattam
	 */
	public void clkViewHardware() {
		getReusableActionsInstance().getWhenReady(btnViewHardware, 60).click();
	}


	/**
	 * Checks if View Hardware button is displayed
	 * @return true if the View Hardware button is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyViewHardware()
	{
		getReusableActionsInstance().waitForElementVisibility(btnViewHardware, 30);
		return getReusableActionsInstance().isElementVisible(btnViewHardware);
	}

	/**
	 * Checks if Hardware Page is displayed
	 * @return true if the Hardware Page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyHardwarePage()
	{
		getReusableActionsInstance().waitForElementVisibility(txtHardwarePage, 90);
		return getReusableActionsInstance().isElementVisible(txtHardwarePage);
	}

	/**
	 * Checks if SHM Feasture Page is displayed
	 * @return true if the SHM Feasture Page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySHMFeasturePage()
	{		getReusableActionsInstance().waitForElementVisibility(txtSHMFeasturePage, 90);
		return getReusableActionsInstance().isElementVisible(txtSHMFeasturePage);
	}

	/**
	 * Click on SHM Feasture
	 * @author chinnarao.vattam
	 */
	public void ViewSHMFeasture() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
	}

	/**
	 * Click on View Hardware
	 * @author chinnarao.vattam
	 */
	public void ViewHardwarePackages() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
	}

	/**
	 * Click on SHM features button
	 * @author chinnarao.vattam
	 */
	public void clkSHMfeatures() {
		getReusableActionsInstance().getWhenReady(btnSHMfeatures, 60).click();
	}


	/**
	 * Checks if SHM features button is displayed
	 * @return true if the SHM features button is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySHMfeatures()
	{
		getReusableActionsInstance().waitForElementVisibility(btnSHMfeatures, 30);
		return getReusableActionsInstance().isElementVisible(btnSHMfeatures);
	}

	/**
	 * Checks if Home Monitoring app button is displayed
	 * @return true if the Home Monitorin gapp button is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyHomeMonitoringapp()
	{
		getReusableActionsInstance().waitForElementVisibility(btnHomeMonitoringapp, 30);
		return getReusableActionsInstance().isElementVisible(btnHomeMonitoringapp);
	}

	/**
	 * Click on Home Monitoring app button
	 * @author chinnarao.vattam
	 */
	public void clkHomeMonitoringapp() {
		getReusableActionsInstance().getWhenReady(btnHomeMonitoringapp, 60).click();
	}

	/**
	 * Checks if SHM App Page is displayed
	 * @return true if the SHM App page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySHMAppPage()
	{
		getReusableActionsInstance().waitForElementVisibility(txtSHMAppPage, 90);
		return getReusableActionsInstance().isElementVisible(txtSHMAppPage);
	}

	/**
	 * Click on View SHM App page
	 * @author chinnarao.vattam
	 */
	public void ViewSHMAppPage() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
	}

	/**
	 * Checks if View Automate Package button is displayed
	 * @return true if the View Automate Package button is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyViewAutomatePackage()
	{
		getReusableActionsInstance().waitForElementVisibility(btnViewAutomatePackage, 30);
		return getReusableActionsInstance().isElementVisible(btnViewAutomatePackage);
	}

	/**
	 * Click on View Automate Package button
	 * @author chinnarao.vattam
	 */
	public void clkViewAutomatePackage() {
		getReusableActionsInstance().getWhenReady(btnViewAutomatePackage, 60).click();
	}

	/**
	 * Checks if Automation Package Page is displayed
	 * @return true if the Automation Package Page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyAutomationPackagePage()
	{
		getReusableActionsInstance().waitForElementVisibility(txtAutomationPackagePage, 90);
		return getReusableActionsInstance().isElementVisible(txtAutomationPackagePage);
	}

	/**
	 * Click on Automation Package Page
	 * @author chinnarao.vattam
	 */
	public void ViewAutomationPackagePage() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
	}

	/**
	 * Click on SHM Customer Care button
	 * @author chinnarao.vattam
	 */
	public void clkSHMCustomerCare() {
		getReusableActionsInstance().getWhenReady(lnkSHMCC, 60).click();
	}

	/**
	 * Click on Live Chat with Rogers  button
	 * @author chinnarao.vattam
	 */
	public void clkLiveChatwithRogers() {
		getReusableActionsInstance().getWhenReady(lnkLiveChatwithRogers, 60).click();
	}

	/**
	 * Click on Find a Rogers Store  button
	 * @author chinnarao.vattam
	 */
	public void clkFindRogersStore() {
		getReusableActionsInstance().waitForElementVisibility(lnkFindRogersStore, 90);
		getReusableActionsInstance().getWhenReady(lnkFindRogersStore, 60).click();
	}

	/**
	 * Click on See full Details  button
	 * @author chinnarao.vattam
	 */
	public void clkSeefullDetails() {
		getReusableActionsInstance().getWhenReady(btnSeefullDetails, 60).click();
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}

	/**
	 * Click on Products link from subNav
	 * @author chinnarao.vattam
	 */
	public void clkProducts() {
		getReusableActionsInstance().getWhenReady(subNavProducts, 60).click();
	}

	/**
	 * Click on App link from subNav
	 * @author chinnarao.vattam
	 */
	public void clkApp() {
		getReusableActionsInstance().getWhenReady(subNavApp, 60).click();
	}

	/**
	 * Click on Help And Support link from subNav
	 * @author chinnarao.vattam
	 */
	public void clkHelpAndSupport() {
		getReusableActionsInstance().getWhenReady(subNavHelpAndSupport, 60).click();
	}

	/**
	 * Click on Moving Your Services link from subNav
	 * @author chinnarao.vattam
	 */
	public void clkMovingYourServices() {
		getReusableActionsInstance().getWhenReady(subNavMovingYourServices, 60).click();
	}


	/**
	 * Click on Why SHM link
	 * @author chinnarao.vattam
	 */
	public void clkWhySHM() {
		getReusableActionsInstance().getWhenReady(lnkWhySHM, 60).click();
	}

	/**
	 * Click on Automate Package link
	 * @author chinnarao.vattam
	 */
	public void clkAutomatePackage() {
		getReusableActionsInstance().getWhenReady(lnkAutomatePackage, 60).click();
	}

	/**
	 * Click on Security Package link
	 * @author chinnarao.vattam
	 */
	public void clkSecurityPackage() {
		getReusableActionsInstance().getWhenReady(lnkSecurityPackage, 60).click();
	}

	/**
	 * Click on SHM Support link
	 * @author chinnarao.vattam
	 */
	public void clkSHMSupport() {
		getReusableActionsInstance().getWhenReady(lnkSHMSupport, 60).click();
	}

	/**
	 * Click on Hardware link
	 * @author chinnarao.vattam
	 */
	public void clkHardwarePackage() {
		getReusableActionsInstance().getWhenReady(lnkHardwarePackage, 60).click();
	}

	/**
	 * Click on Features link
	 * @author chinnarao.vattam
	 */
	public void clkFeatures() {
		getReusableActionsInstance().getWhenReady(lnkFeatures, 60).click();
	}

	//++++++++++++++++++++++++++++++++++//
	/**
	 * Click on How To Get Security Packages button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetAutomatePackage() {
		getReusableActionsInstance().getWhenReady(btnHowToGetAutomatePackage, 60).click();
	}
}
