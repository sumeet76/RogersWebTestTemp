package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//a[contains(@aria-label,'Learn how to get a Security package') or contains(@aria-label,'Voyez comment obtenir le forfait Sécurité')]")
	WebElement lnkHowToGetSecurityPackages;
	
	@FindBy(xpath = "//div[@id='shaShmServiceableCallCare']")
	WebElement popupSecurityPackagesModel;

	@FindBy(xpath = "//div[@id='shaShmServiceableCallCare']/descendant::a")
	WebElement lnkSecurityPackagesByCall;
	//div[@id='shaShmServiceableCallCare']/descendant::a[contains(@href,'18552203526')]
	//div[@id='shaShmServiceableCallCare']/descendant::a[contains(@href,'18668530923')]

	@FindBy(xpath = "//a[contains(@title,'Call Rogers at') or contains(@title,'Appelez Rogers au')]")
	WebElement lnkSHMCC;

	@FindAll({
			@FindBy(xpath = "//span[@bckey='shaShmCallCare']/div/a[@aria-label='global.chatWithAnAgent.shm']"),
			@FindBy(xpath = "//span[@bckey='shaShmCallCare']/div/a[@aria-label='global.chatWithAnAgent.sha']")})
	WebElement lnkSecurityPackagesByLivechat;

	@FindAll({
			@FindBy(xpath = "//a[@aria-label='global.chatWithAnAgent.sha']"),
			@FindBy(xpath = "//a[@aria-label='global.chatWithAnAgent.shm']")
	})
	WebElement lnkLiveChatwithRogers;

	@FindAll({
	@FindBy(xpath = "//a[@href='/stores/']"),
	@FindBy(xpath = "//a[@href='https://www.rogers.com/stores/']")})
	WebElement lnkSecurityPackagesFromStore;

	@FindBy(xpath = "//a[@title='Find a Rogers store' or @title='Trouver un magasin']")
	WebElement lnkFindRogersStore;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-chevron-down']")
	WebElement btnSeefullDetails;

	@FindBy(xpath = "//iframe[@name='bc-window']")
	WebElement ifrmLiveChat;

	@FindBy(xpath = "//input[@id='1.No']")
	WebElement rdoNoShmOption;

	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-minimize']")
	WebElement btnCloseLivechat;

	@FindBy(xpath = "//div[@class='bc-headbtn bc-headbtn-menulist']")
	WebElement btnCloseLivechatMenu;

	@FindBy(xpath = "//div[@class='bc-headbtn-icon bc-headbtn-close-icon']")
	WebElement btnCloseLivechatOption;

	@FindBy(xpath = "//h1[@class='SearchHero-title']")
	WebElement txtStorePage;


	@FindBy(xpath = "//button[contains(@aria-label,'View more details about the Assure package')]")
	WebElement btnAssurePackDetails;

	@FindBy(xpath = "//button[contains(@aria-label,'How to get the Assure package')]")
	WebElement btnHowToGetItAssurePack;

	@FindBy(xpath = "//button[contains(@aria-label,'View more details about the Control package')]")
	WebElement btnControlPackDetails;

	@FindBy(xpath = "//button[contains(@aria-label,'How to get the Automate package')]")
	WebElement btnHowToGetItAutomatePack;


	@FindBy(xpath = "//button[contains(@aria-label,'How to get the Control package')]")
	WebElement btnHowToGetItControl;

	@FindBy(xpath = "//ds-modal-container[@id='ds-modal-container-0']")
	WebElement popupPackageDetails;

	@FindBy(xpath = "//button[@aria-label='More details View more details about the Automate package']")
	WebElement btnAutomatePackageDetails;

	@FindBy(xpath = "//button[@title='Close Details']")
	WebElement popupPackageDetailsCloseModal;

	@FindBy(xpath="//button[@title='Close window for Address Found']/span")
	WebElement popupAddressFoundCloseModal;

	@FindBy(xpath = "//p[contains(text(),'Protect') or contains(text(),'Protection')]")
	WebElement txtProtectPackageDetails;

	@FindBy(xpath = "//p[contains(text(),'Assure') or contains(text(),'Tranquillité')]")
	WebElement txtAssurePackageDetails;

	@FindBy(xpath = "//p[contains(text(),'Control') or contains(text(),'Contrôle')]")
	WebElement txtControlPackageDetails;

	@FindBy(xpath = "//p[contains(text(),'Automate Package') or contains(text(),'du forfait Automatique')]")
	WebElement txtAutomatePackageDetails;


	@FindBy(xpath = "//a[contains(@aria-label,'View Smart Home Monitoring hardware')]")
	WebElement btnViewHardware;

	@FindBy(xpath = "//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtHardwarePage;

	@FindBy(xpath = "//a[contains(@aria-label,'View Smart Home Monitoring features')]/span")
	WebElement btnSHMfeatures;

	@FindBy(xpath = "//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtSHMFeasturePage;

	@FindBy(xpath = "//a[contains(@aria-label,'Learn more about the Smart Home Monitoring app')]")
	WebElement btnHomeMonitoringapp;

	@FindBy(xpath = "//img[contains(@src,'English-AppHero.png')]")
	WebElement txtSHMAppPage;

	@FindBy(xpath = "//a[contains(@aria-label,'View Automate package')]")
	WebElement btnViewAutomatePackage;

	@FindBy(xpath = "//a[contains(@aria-label,'View Security packages')]")
	WebElement btnViewSecurityPackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[@href='/consumer/support/homemonitoring']")
	WebElement lnkSHMSupport;

	@FindBy(xpath = "//h1[@class='dsa-billboard__copyHeading mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtAutomationPackagePage;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='Products' or @data-text='Produits']/ancestor::a//ds-icon[@name='down']")
	WebElement subNavProducts;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='App' or @data-text='Appli']/ancestor::a//ds-icon[@name='right']")
	WebElement subNavApp;

	@FindBy(xpath = "//ul[@class='list-none d-flex']//span[@data-text='Help and Support' or @data-text='Soutien']/ancestor::a//ds-icon[@name='down']")
	WebElement subNavHelpAndSupport;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@aria-label,'Moving?')]")
	WebElement subNavMovingYourServices;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@aria-label,'Why Smart Home Monitoring')]")
	WebElement lnkWhySHM;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@aria-label,'Automate Package')]")
	WebElement lnkAutomatePackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@aria-label,'Security Package')]")
	WebElement lnkSecurityPackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@href,'/home-monitoring/hardware')]")
	WebElement lnkHardwarePackage;

	@FindBy(xpath = "//ul[@class='list-none mt-0']//a[contains(@aria-label,'Features page')]")
	WebElement lnkFeatures;


	@FindBy(xpath = "//a[@href='/home-security/security-packages']")
	WebElement btnSecurityPack;

	//+++++++++++++++++++++++++++++++++++++++++//
	@FindBy(xpath = "//a[contains(@aria-label,'Learn how to get the Automate package') or contains(@aria-label,'Voyez comment obtenir le forfait Automatique')]")
	WebElement btnHowToGetAutomatePackage;

	@FindBy(xpath = "//a[@href='/home-security/automation-packages']")
	WebElement btnAutmationPack;

	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-')]/..")
	WebElement txaIgniteAddressContainerExisting;

	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-')]")
	WebElement txaIgniteAddressLookup;

	@FindBy(xpath = "//button[@id='checkAddressBtn']/span")
	WebElement btnIgniteAddressLookupSubmit;


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
		{
			String strExpectedTitle = "Forfaits – Sécurité résidentielle et vidéosurveillance | Rogers";
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
		{
			String strExpectedTitle = "Magasiner les solutions de domotique | Rogers";
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
		getReusableActionsInstance().waitForElementVisibility(lnkSecurityPackagesByLivechat, 60);
		getReusableActionsInstance().getWhenReady(lnkSecurityPackagesByLivechat, 30).click();
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
		getReusableActionsInstance().waitForElementVisibility(ifrmLiveChat, 120);
		return getReusableActionsInstance().isElementVisible(ifrmLiveChat);
	}

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToLivechatIFrame() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(ifrmLiveChat,30);
		getDriver().switchTo().frame(ifrmLiveChat);
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkSecurityPack() {
		getReusableActionsInstance().getWhenVisible(btnSecurityPack, 60).click();
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkAutmationPack() { getReusableActionsInstance().getWhenVisible(btnAutmationPack, 60).click();
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
	 * Click on How To Get It Automate Pack Button
	 * @author chinnarao.vattam
	 */
	public void clkHowToGetItAutomatePack() {
		getReusableActionsInstance().waitForElementVisibility(btnHowToGetItAutomatePack, 90);
		getReusableActionsInstance().getWhenReady(btnHowToGetItAutomatePack, 60).click();
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
	 * Checks if Package Details popup is displayed
	 * @return true if the Package Details popup is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyAutomatePackageDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(btnAutomatePackageDetails, 30);
		return getReusableActionsInstance().isElementVisible(btnAutomatePackageDetails);
	}

	/**
	 * Click on Automate Package Details button
	 * @author chinnarao.vattam
	 */
	public void clkAutomatePackageDetails() {
		getReusableActionsInstance().getWhenReady(btnAutomatePackageDetails, 60).click();
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
	 * Checks if Control Package Details is displayed
	 * @return true if the Control Package Details is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyAutomatePackageMoreDetails()
	{
		getReusableActionsInstance().waitForElementVisibility(txtAutomatePackageDetails, 30);
		return getReusableActionsInstance().isElementVisible(txtAutomatePackageDetails);
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
		//getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(txtHardwarePage, 90);
		return getReusableActionsInstance().isElementVisible(txtHardwarePage);
	}

	/**
	 * Checks if SHM Feasture Page is displayed
	 * @return true if the SHM Feasture Page is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifySHMFeasturePage()
	{
		getReusableActionsInstance().staticWait(10000);
		WebElement txtSHMFeaturePage = getDriver().findElement(By.xpath("//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']"));
		//getReusableActionsInstance().waitForElementVisibility(txtSHMFeasturePage, 90);
		return getReusableActionsInstance().isElementVisible(txtSHMFeaturePage, 90);
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
	 * Click on View Hardware
	 * @author chinnarao.vattam
	 */
	public void ViewTopOfPage() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
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
		//getReusableActionsInstance().waitForPageLoad();
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
	 * Checks if View Security Package button is displayed
	 * @return true if the View Security Package button is displayed else false
	 * @author chinnarao.vattam
	 */
	public Boolean verifyViewSecurityPackage()
	{
		getReusableActionsInstance().waitForElementVisibility(btnViewSecurityPackage, 30);
		return getReusableActionsInstance().isElementVisible(btnViewSecurityPackage);
	}

	/**
	 * Click on View Automate Package button
	 * @author chinnarao.vattam
	 */
	public void clkViewAutomatePackage() {
		getReusableActionsInstance().getWhenReady(btnViewAutomatePackage, 60).click();
	}

	/**
	 * Click on View Security Package button
	 * @author chinnarao.vattam
	 */
	public void clkViewSecurityPackage() {
		getReusableActionsInstance().getWhenReady(btnViewSecurityPackage, 60).click();
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
	 * Click on Automation Package Page
	 * @author chinnarao.vattam
	 */
	public void MoveToTopOfPage() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
	}

	/**
	 * Click on Security Package Page
	 * @author chinnarao.vattam
	 */
	public void ViewSecurityPackagePage() {
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
		getReusableActionsInstance().getWhenReady(lnkFeatures, 60);
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

	public void setIgniteAddressLookup(String strAddress) {
		getReusableActionsInstance().waitForElementTobeClickable(txaIgniteAddressContainerExisting, 60);
		//getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainerExisting, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 5).sendKeys(strAddress);
		String strAddressResultXpath = "//ul[@role='listbox']/li[contains(@ng-reflect-result,'') and contains(text(),'address')]";
		try{
			getReusableActionsInstance().getWhenReady(By.xpath(strAddressResultXpath.replace("address", strAddress.trim())), 10).click();

		}catch (Exception e){
			getReusableActionsInstance().getWhenReady(By.xpath("//ul[@role='listbox']/li[contains(@ng-reflect-result,'')]"), 10).click();
		}
	}

	public void clkIgniteAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 30).click();
		getReusableActionsInstance().waitForPageLoad();
		//getReusableActionsInstance().staticWait(15000);
	}

	/**
	 * Click on Address Found Close button
	 * @author manpreet.kaur3
	 */
	public void clkAddressFoundCloseModal() {
		getReusableActionsInstance().getWhenReady(popupAddressFoundCloseModal, 60).click();
	}
}
