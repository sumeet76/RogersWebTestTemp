package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import com.rogers.pages.base.BasePageClass;

public class RogersAccountOverviewPage extends BasePageClass {

	public RogersAccountOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='ute-icon-internet']")
	WebElement btnInternetBadge;
			
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Internet')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-internet icon')]/ancestor::div[@role='button']")})
	WebElement btnLegacyInternetBadge;
	
	@FindBy (xpath ="//div[@class='ute-dataManager-badgeList-individualBadge']")
	WebElement btnCtnBadge;
			
	@FindAll({
        @FindBy(xpath = "//div[@class='subscription-detail']//rss-subscription-detail//a"),
        @FindBy (xpath ="//div[@class='ute-dataManager-badgeList-individualBadge']//div[@class='ute-dataManager-badgeList-individualBadgeInfo']")})
	List<WebElement> lstCtnBadges;
	
	
	@FindBy(xpath = "//div[@class='row modal-content-header']//button[@class='close']")
	WebElement popUpInternetPopup;

	
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'TV') or contains(text(),'Télévision')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-tv icon')]/ancestor::div[@role='button']")})
	WebElement btnTVBadge;

	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Home Phone') or contains(text(),'Téléphonie résidentielle')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-home-phone icon')]/ancestor::div[@role='button']")})
	WebElement btnRHPBadge;

	@FindBy(xpath = "//div[@linkurl='tvdashboard']/parent::div")
	WebElement btnTVBadgeConsolidated;

	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde']")
	WebElement infoBalanceLable;

	@FindBy(xpath = "//span[@translate='ute.rogers.rhpDashboard.homePhone']")
	WebElement infoLegacyrhpDashboard;
	
	@FindBy(xpath = "//span[@translate='ute.rogers.rhpDashboard.contactMangerFeatures']")
	WebElement lnkContactUsToManageFeaturess;
		
	@FindAll({
        @FindBy(xpath = "//span[text()=' View your bill ' or text()=' Afficher votre facture ']"),
        @FindBy(xpath = "//span[@translate='ute.rogers.account.balance.view_your_bill']")})
    WebElement btnViewYourBill;


	@FindAll({
	@FindBy(xpath = "//div[@class='rogers-self-serve-nav']//div[@class='c-dropdown-menu-holder']//span[text()='Lier un autre compte' or text()='Link another account']"),
	@FindBy(xpath = "//span[contains(@data-translate,'linkAnotherAccount')]")
	})
	WebElement lnkLinkAnotherAccount;
	
	@FindBy(xpath = "//div[@translate='linked_acc_success']")
	WebElement lblLinkAccountSuccess;
	
	
	
	@FindAll({
	@FindBy(xpath = "//div[@class='account']//a[@class='dropdown-toggle menu-click']"),
	@FindBy(xpath = "//span[contains(@class,'arrow-down-account')]")})
	WebElement lnkAccountdropdown;
	
	
	@FindAll({
        @FindBy(xpath = "//a[contains(text(),'Billing & Payment') or contains(text(),'Facturation et paiement')]"),
        @FindBy(xpath = "//span[@data-translate='ute.common.label.billAndPayment']")})	
	WebElement lnkBillingAndPayment;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.changePaymentMethod']")
	WebElement lnkChangePaymentMethod;
		
	@FindAll({
        @FindBy(xpath = "//rss-billing-widget//span[contains(text(),'Set up automatic payments') or contains(text(),'Établir les paiements automat.')]"),
        @FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.setUpAutomaticPayments']")})	
	WebElement lnkSetUpAutomaticPaymentMethod;
	
	@FindBy(xpath = "//button/span[@translate='ute.rogers.account.balance.make_a_payment']")
	WebElement btnMakeAPayment;
	
	@FindBy(xpath = "//div[@ng-show='loadingImg']")
	WebElement imgLoadingFingers;
	
	@FindAll({
        @FindBy(xpath = "//a[text()='Profile & Settings' or text()='Profil et paramètres']"),
        @FindBy(xpath = "//span[@data-translate='ute.common.label.profileAndSetting']")})
    WebElement menuProfileNSettings;

	@FindBy(xpath = "//a/span[text()='Profile & Settings' or text()='Profil et paramètres']")
	WebElement menuProfileAndSettingsMobile;
	
	@FindBy(xpath = "//button[contains(text(),'Overview') or contains(text(),'Survol')]")
	WebElement btnOverViewMobile;
	
	@FindAll({
		@FindBy (xpath = "//p[text()='Quel compte souhaitez-vous consulter?' or text()='Which account would you like to view today?']"),
		@FindBy (xpath = "//h3[@translate='acc_overview_which_account']")
	})	
	WebElement headerAccountSelect;
	
	@FindBy (xpath = "//h1[@class='profile-header']")
	WebElement headerProfileNSettings;
	
	@FindBy (xpath = "//div[@translate='ute.payment.method.payment_method' or @translate='ute.payment.method.will_auto_charge']")
	WebElement lblAutoPayment;
	
	@FindBy(xpath = "//div[@translate='ute.payment.method.account_prefix']")
	WebElement lblAutoPaymentAccountPreFix;

	@FindBy(xpath = "//div[contains(@class,'cc-image')]")
	WebElement imgCC;

	@FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.makePayment']")
	WebElement lnkMakePayment;
	
	@FindAll({
		@FindBy (xpath = "//a[text()='Usage & Services ' or text()='Utilisation et services ']"),
		@FindBy (xpath = "//span[@data-translate='ute.common.label.myServices']")
	})
	WebElement menuUsageAndService;
	
	@FindBy (xpath = "//span[contains(text(),'Wireless Usage') or contains(text(),'Utilisation sans-fil')]")
	WebElement subMenuWirelessUsage;

	@FindBy (xpath = "//div[@id='carouselBlock']")
	WebElement newLookPopUp;
	
	@FindBy (xpath = "//span[@class='ds-icon rds-icon-error']")
	WebElement iconCloseInPopup;

	@FindBy(xpath="//*[@id='paymentAmount']")
	WebElement txtAmount;
	
	@FindAll({
        @FindBy(xpath = "//span[contains(@class,'subscription-name')]"),
        @FindBy(xpath = "//div[@class='ute-dataManager-badgeList-individualBadge']//div[@class='ute-dataManager-badgeList-individualBadgeInfo']")})	
	WebElement lblCTNWirelessName;
	

	@FindAll({
        @FindBy(xpath = "//div[@class='c-dropdown-menu-holder']/a"),
        @FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.wireless.phone']")})	
	WebElement subMenuUsageDropDown;
	
	@FindBy (xpath = "//div[@class='account-number-ctn']")
	WebElement selectAccountMultipleSubscription;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.label.overview']")
	WebElement clkOverview;
	
	@FindBy(xpath = "//div[@class='module-account-overview-dialog']")
	WebElement popUpMultipleAccounts;

	@FindBy(xpath = "//button//span[@class='ute-secondLevelNav-arrow-down ute-secondLevelNav-arrow-down-account']")
	WebElement downArrowAccount;
	
	@FindBy(xpath = "//div[contains(@id,'menu_container_0')]//button")
	List<WebElement> lstAccountBans;

	@FindBy(xpath = "//div[@class='account-ctn']")
	List<WebElement> lstAccountInPopUp;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.label.overview']/ancestor::button[@ng-click='navigationBar.MobileViewOnClick(nav)']")
	WebElement btnNavigationBarMobile;
	
	@FindBy (xpath = "//button[@aria-label='ute.common.label.profileAndSetting']")
	WebElement btnProfileSettingsMobile;
	
	@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Entertainment')]/ancestor::div[@class='subscription-detail']"),
        @FindBy(xpath = "//span[@translate='ute.subscriptionBadge.smartStream']")})	
	WebElement btnEntertainmentBadge;

	/**
	 * Checks if more than one ban present in the pop up window, the count will be more than 1
	 * @return true if more than one ban present else false
	 * @author Saurav.Goyal
	 */
	public boolean isMoreThanOneBanPresentInThePopUp() {
		return (lstAccountInPopUp.size()>1);
	} 
	
	/**
	 * To remove cookie after login successfully
	 * @param cookieName, string cookie name;
	 */
	public void removeCookieAfterLogin(String cookieName) {
		reusableActions.removeCookie(cookieName);
	}
	
	/**
	 * Clicks on the 'InternetBadge' option on the dash board
	 * @param strBrowser- strBrowser
	 * @author chinnarao.vattam
	 */
	public void clkInternetBadge(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.clickAndHoldFor(btnInternetBadge, 90);
		}else {
			reusableActions.clickIfAvailable(btnInternetBadge, 90);
		}
	}
	
	/**
	 * Clicks on the Legacy 'InternetBadge' option on the dash board
	 * @param strBrowser browser type
	 * @author chinnarao.vattam
	 */
	public void clkLegacyInternetBadge(String strBrowser) {
		if (strBrowser.toLowerCase().contains("chrome"))
		{
		reusableActions.getWhenReady(btnLegacyInternetBadge, 120).click();
		}else {
			reusableActions.clickIfAvailable(btnLegacyInternetBadge, 120);
		}
	}
	
	/**
	 * Clicks on the Legacy 'InternetBadge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkLegacyInternetBadge() {
		reusableActions.getWhenReady(btnLegacyInternetBadge, 120).click();
	}
	

	/**
	 * To click on the CTN badge in account overview page
	 * @param strLast4DigitCtn, String, last 4 digit of the CTN
	 * @author ning.xue 
	 */
	public void clkCtnBadge(String strLast4DigitCtn) {
		
		reusableActions.getWhenReady(By.xpath("//ute-data-manager-badge-list-directive//div[contains(text(),'" + strLast4DigitCtn + "')]/parent::div"), 30).click();
	}
	
	/**
	 * Close the New Look Pop up if visible on the dash board
	 * @author ning.xue
	 */
	public void clkCloseInNewLookPopupIfVisible() {
		if (reusableActions.isElementVisible(newLookPopUp, 10)){
			reusableActions.getWhenReady(iconCloseInPopup, 10).click();
			//reusableActions.clickIfAvailable(iconCloseInPopup,10);
		}
	}
	
	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @param strBrowser- strBrowser
	 * @author chinnarao.vattam
	 */
	public void clkInternetPopup(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.clickIfAvailable(popUpInternetPopup, 60);
		}else {
			reusableActions.clickIfAvailable(popUpInternetPopup, 60);			
		}
	}

	/**
	 * Clicks on the 'TV Badge' option on the dash board
	 * @param strBrowser- strBrowser
	 * @author chinnarao.vattam
	 */
	public void clkTVBadge(String strBrowser ) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{		
		reusableActions.getWhenReady(btnTVBadge, 120).click();
		}else
		{
			reusableActions.clickIfAvailable(btnTVBadge,120);
		}		
	}

	/**
	 * Clicks on the 'TV Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkTVBadge() {	
		reusableActions.getWhenReady(btnTVBadge, 120).click();	
	}
	
	/**
	 * Clicks on the 'RHP Badge' option on the dash board
	 * @param strBrowser- strBrowser
	 * @author chinnarao.vattam
	 */
	public void clkRHPBadge(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		reusableActions.getWhenReady(btnRHPBadge, 120).click();;
		}else {
			reusableActions.clickIfAvailable(btnRHPBadge, 120);
			}
		}
	
	/**
	 * Clicks on the 'RHP Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkRHPBadge() {
		reusableActions.getWhenReady(btnRHPBadge, 120).click();;
		}
	
	/**
	 * Check if the account selection header display or not
	 * @return true if it display, otherwise false.
	 * @author ning.xue
	 */
	public Boolean isAccountSelectionPopupDisplayed() {
		return reusableActions.isElementVisible(headerAccountSelect, 10);
	}

	/**
	 * To Select Account on the accounts popup
	 * @param strAccountNumber account number of the Roger's customer
	 * @author ning.xue
	 */
	public void selectAccount(String strAccountNumber) {
			reusableActions.clickIfAvailable((By.xpath("//span[contains(@class,'account')]/following-sibling::span[text()='" + strAccountNumber + "']")), 20);
	}
	
	/**
	 * To check if account is already linked
	 * @param strAccountNumber account number of the Roger's customer
	 * @return true if the account number match otherwise false.
	 * @author ning.xue
	 */
	public Boolean isAccountLinked(String strAccountNumber) {
		return reusableActions.isElementVisible(
				(By.xpath("//span[contains(@class,'account')]/following-sibling::span[text()='" + strAccountNumber + "']")), 
				20);
	}
	
	/**
	 * To click Menu UsageAndService in account overview page.
	 * @author ning.xue
	 */
	public void clkMenuUsageAndService() {
		boolean clickSuccess=false;
		int count=0;
		while (count<=2 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Usage and service click");
//			// buffer static wait added to handle anomalies on firefox
//			reusableActions.staticWait(4000);
			reusableActions.getWhenReady(menuUsageAndService,30).click();			
			if(reusableActions.isElementVisible(subMenuUsageDropDown, 10)
					|| reusableActions.isElementVisible(subMenuWirelessUsage, 10))
			{
				System.out.println("Usage and service click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
		
	} 
	
	/**
	 * To click sub-Menu Wireless Usage of UsageAndService drop down in account overview page.
	 * @author ning.xue
	 */
	public void clkSubMenuWirelessUsage() {
		reusableActions.clickWhenReady(subMenuWirelessUsage, 10);
	}
	
	/**
	 * To check if account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string account number
	 * @return true if element visible else false
	 * @author Ning.Xue
	 */
	public boolean isAccountShowInDropDown(String strLast4DigAcctNum) {
		return reusableActions.isElementVisible(
				(By.xpath("//span[contains(@data-translate-values,'" + strLast4DigAcctNum + "') or contains(text(),'" + strLast4DigAcctNum + "')]")), 
				10);
	}
	
	/**
	 * To check if account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string last four digits of account number
	 * @author Ning.Xue
	 */
	public void clkDropDownAccount(String strLast4DigAcctNum) {
		reusableActions.getWhenReady(
				(By.xpath("//span[contains(text(),'" + strLast4DigAcctNum + "')or contains(text(),'" + strLast4DigAcctNum + "')]")), 
				10).click();

	}
	
	/**
	 * Click on menu Profile and Settings
	 * @author ning.xue
	 */
	public void clkLnkProfileNSettings() {

		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Profile and settings click");
//			// buffer static wait added to handle anomalies on firefox
//			reusableActions.staticWait(4000);
			reusableActions.getWhenReady(menuProfileNSettings,30).click();			
			reusableActions.waitForElementVisibility(headerProfileNSettings,60);
			if(reusableActions.isDisplayed(headerProfileNSettings))
			{
				System.out.println("Profile and settings click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
	}
	
	/**
	 * Click on menu Profile and Settings on Mobile
	 * @author Mirza.Kamran
	 */
	public void clkLnkProfileNSettingsMobile() {
		
		reusableActions.getWhenReady(btnOverViewMobile,30).click();			
		reusableActions.getWhenReady(menuProfileAndSettingsMobile,30).click();			
		reusableActions.waitForElementVisibility(headerProfileNSettings,60);
					
	}
	
	/**
	 * To verify the successful login
	 * @return true if the balance label is present ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessfulLogin() {
		return reusableActions.isElementVisible(infoBalanceLable,60);
	}

	/**
	 * To Verify the RHP Banner on the Legacy RHP dash board
	 * @return true if the package name is Home Phone ; else false
	 * @author chinnarao.vattam
	 */
	//TODO please move this to dashboard page
	public boolean verifyRHPBanner() {
		return reusableActions.isElementVisible(infoLegacyrhpDashboard, 20);
	}

	/**
	 * To Verify the RHP Banner on the Legacy RHP dash board
	 * @return true if the package name is Home Phone ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verfyContactUsToManageFeaturess() {
		return reusableActions.isElementVisible(lnkContactUsToManageFeaturess, 20);
	}
	
	/**
	 * Validates and clicks on the Wireless Phone Number under Share Everything
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAndClickShareEverythingCTN(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		String strCTNXpath = "//div[contains(@class,'sharedWireless')]//div[contains(text(),'" + strCTN +"')]/parent::div/button";
		
		if(reusableActions.isElementVisible(By.xpath(strCTNXpath))) {
			reusableActions.executeJavaScriptClick(driver.findElement(By.xpath(strCTNXpath)));
			return true;
		}
		return false;
	}

	/**
	 * Validates the First Name of the Caller ID under Share Everything 
	 * @param strFirstName First Name of the Caller ID
	 * @return true if the name matches ; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifySECallerIdFirstName(String strFirstName) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(@class,'sharedWireless')]//div[contains(text(),'" + strFirstName.toUpperCase() +"')]"),60);
	}
	
	/**
	 * Validates and clicks on the Wireless Phone Number
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAndClickWirelessCTN(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);		
		String strCTNXpath = "//div[@class='myServiceName']//div[contains(text(),'" + strCTN + "')]";		
		if(reusableActions.isElementVisible(By.xpath(strCTNXpath))) {
			reusableActions.scrollToElement(reusableActions.getWhenReady(By.xpath(strCTNXpath)));
			//reusableActions.javascriptScrollByVisibleElement(reusableActions.getWhenReady(By.xpath(strCTNXpath)));
			reusableActions.clickWhenReady(By.xpath(strCTNXpath), 120);
			//reusableActions.scrollToElementAndClick(reusableActions.getWhenReady(By.xpath(strCTNXpath)));
			return true;
		} else if (verifyAndClickShareEverythingCTN(strCTN)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Validates the First Name of the Caller ID for non-SE subscriber
	 * @param strFirstName First Name of the Caller ID 
	 * @return true if the name matches ; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessCallerIdCTNBadgeName(String strFirstName) {
		
		return reusableActions.getWhenReady(lblCTNWirelessName,20).getText().trim().toLowerCase().contains(strFirstName.toLowerCase());		
	}
	
	/**
	 * Validates the Message - 'Your account was successfully linked to your profile!'
	 * @return true if message displayed ; else false;
	 * @author rajesh.varalli1
	 */
	public boolean verifyLinkAccountSuccessful() {
		return reusableActions.isElementVisible(lblLinkAccountSuccess,120);
	}
	
	/**
	 * Clicks on the 'Link Another Account' option in the Account menu
	 * @author rajesh.varalli1
	 */
	public void clkLinkAnotherAccount() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.clickIfAvailable(lnkAccountdropdown);
		reusableActions.clickIfAvailable(lnkLinkAnotherAccount);
	}
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkSetUpAutomaticPaymentMethod() {
		reusableActions.waitForElementVisibility(lnkBillingAndPayment);
		reusableActions.clickIfAvailable(lnkBillingAndPayment);
		reusableActions.clickIfAvailable(lnkSetUpAutomaticPaymentMethod);
	}
	
	/**
	 * Clicks on the submenu of 'Billing and Payment'  'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkBillngsAndPaymentsSubMenuSetUpAutomaticPaymentMethod() {
		reusableActions.waitForElementVisibility(lnkSetUpAutomaticPaymentMethod);		
		reusableActions.clickIfAvailable(lnkSetUpAutomaticPaymentMethod);
	}
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Change Payment Method' option
	 * @author rajesh.varalli1
	 */
	public void clickChangePaymentMethod() {
		reusableActions.clickIfAvailable(lnkBillingAndPayment);
		reusableActions.clickIfAvailable(lnkChangePaymentMethod);
	}
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Change Payment Method' option
	 * @author Mirza.Kamran
	 */
	public void clkBillingAndPaymentsSubMenuChangePaymentMethod() {		
		reusableActions.clickIfAvailable(lnkChangePaymentMethod);
	}
	
	/**
	 * Clicks on the 'Make a payment' button
	 * @author rajesh.varalli1
	 */
	public void clickMakePayment() {
		reusableActions.clickIfAvailable(btnMakeAPayment,10);
	}
	
	/**
	 * Clicks on the 'View Your Bill' button
	 * @author rajesh.varalli1
	 */
	public void clickViewYourBill() {
		reusableActions.clickIfAvailable(btnViewYourBill);
	}

	/**
	 * Checks if the auto payment is set
	 * @return true if set automatic payment sub menu is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetAutoPaymentDisplayed() {
		reusableActions.waitForElementTobeClickable(lnkBillingAndPayment, 30);
		reusableActions.staticWait(2000);
		reusableActions.executeJavaScriptClick(lnkBillingAndPayment);
		reusableActions.staticWait(3000); //extra static buffers added for firefox
		return reusableActions.isDisplayed(lnkSetUpAutomaticPaymentMethod);
	}

	/**
	 * Checks if the auto payment option is set successfully
	 * @return true if the payment option is set successfully
	 * @author Mirza.Kamran
	 */
	public boolean verifyThatAutoPaymentIsDisplayedOnAccountOverViewPage() {
		reusableActions.waitForElementVisibility(lblAutoPayment);
		return (reusableActions.isDisplayed(lblAutoPayment)
			 && reusableActions.isDisplayed(lblAutoPaymentAccountPreFix));
	}	
	
	/**
	 * Checks if the auto payment option is set successfully to CC
	 * @return true if the payment option is set successfully
	 * @author Mirza.Kamran
	 */
	public boolean verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage() {
		reusableActions.waitForElementVisibility(lblAutoPayment);
		return (reusableActions.isDisplayed(lblAutoPayment)
			 && reusableActions.isDisplayed(imgCC));
	}

	/**
	 * Clicks on the menu Billing and Payments and selects the submenu Make Payment option
	 * @author Mirza.Kamran
	 */
	public void clkBillingAndPaymentsMakeAPayment() {	
	
		boolean clickSuccess=false;
		int count=0;
	try {	
		while (count<=3 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Billing and payments");
			reusableActions.waitForElementTobeClickable(lnkBillingAndPayment, 360);
			// buffer static wait added to handle anomalies on firefox
			reusableActions.staticWait(4000);
			reusableActions.executeJavaScriptClick(lnkBillingAndPayment);			
			reusableActions.waitForElementVisibility(lnkMakePayment);
			reusableActions.executeJavaScriptClick(lnkMakePayment);	
			if(reusableActions.isDisplayed(txtAmount))
			{
				System.out.println("Billing and payment click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
	}catch (StaleElementReferenceException e) {
		// TODO:  the stale ref exception if encountered
	}
		
		
	}
	
	/**
	 * The Wireless usage and service is visible
	 * @param strFirstName parameter First name
	 * @return boolean true if the ctn is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyWirelessCallerIdUpdatedInDropDownToSelectWirelessUsage(String strFirstName) {					
		return reusableActions.isElementVisible((By.xpath("//span[contains(@data-translate-values,'" + strFirstName + "')]")),20);
	}
	
	/**
	 * Checks if more than one ban present, the count will be more than 3
	 * @return true if more than one ban present else false
	 * @author Mirza.Kamran
	 */
	public boolean isMoreThanOneBanPresent() {
		return (lstAccountBans.size()>3);
	} 

	/**
	 * Click on the Account drop down
	 * @author Saurav.Goyal
	 */
	public void clickAccount() {
		reusableActions.clickIfAvailable(downArrowAccount);
	}
	
	/**
	 * Click on the Overview tab
	 * @author Saurav.Goyal
	 */
	public void clickOverview() {
		reusableActions.clickIfAvailable(clkOverview);
	}
	
	/**
	 * To select first account from the account drop down
	 * @author Saurav.Goyal
	 */
	public void selectAnAccountFromTheAccountDropDown() {
		reusableActions.getWhenReady(lstAccountBans.get(1), 120).click();
	}

	/**
	 * Checks if the no of CTNS are more than 5
	 * @return true if the no of CTNS are more than 5
	 * @author Mirza.Kamran
	 */
	public boolean isCTNMoreThanSix() {		
		return lstCtnBadges.size()>5;
	}

	/**
	 * Checks if the no of CTNS are more than 1
	 * @return true if the no of CTNS are more than 5
	 * @author Mirza.Kamran
	 */
	public boolean isCTNMoreThanOne() {		
		return lstCtnBadges.size()>1;
	}
	/**
	 * retruns total no of CTNS
	 * @return int value total no of CTNs
	 * @author Mirza.Kamran
	 */
	public int getTotalCTN() {		
		return lstCtnBadges.size();
	}
	
	/**
	 * Click the overview navigation button on the page 
	 * @author ning.xue
	 */
	public void clkBtnNavigationMobile() {		
		reusableActions.getWhenVisible(btnNavigationBarMobile, 30).click();
	}
	
	/**
	 * Clicks on Profile and settings button on mobile
	 * @author ning.xue
	 */
	public void clkBtnProfileSettingsMobile() {		
		reusableActions.getWhenVisible(btnProfileSettingsMobile, 30).click();
	}
	
	/**
	 * Scroll to middle of page
	 * @author Mirza.Kamran
	 */
	public void scrollToMiddleOfPage() {
		reusableActions.javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrollToBottomOfPage() {
		reusableActions.javascriptScrollToBottomOfPage();
		
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrollToTopOfPage() {
		reusableActions.javascriptScrollToTopOfPage();
	}
	
	/**
	 * Clicks on Tupelo entertainment badge
	 * @author Mirza.Kamran
	 */
	public void clkEntertainmentBadge() {
		reusableActions.getWhenReady(btnEntertainmentBadge).click();
		
	}

	public void clkViewBill() {
	reusableActions.clickIfAvailable(btnViewYourBill);
		
	}
}
