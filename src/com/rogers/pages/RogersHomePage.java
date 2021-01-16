package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersHomePage extends BasePageClass {

	public RogersHomePage(WebDriver driver) {
		super(driver);
	}
	 
	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkEasyLogin;
	
	@FindBy(xpath = "//a[@href='/consumer/internet']")
	WebElement lnkEasyInternet;
	
	@FindBy(xpath = "//a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkTVBundle;

	@FindAll({
			@FindBy(xpath = "//div[@class='dds-navbar-nav']//a[@aria-label='Sign in to My Rogers']//span[text()='Sign in'  or text()='Connexion']"),
			@FindBy(xpath = "//div[@class='rcl-navbar-nav']//a[@class='m-navLink -navbar -login']//span[text()='Sign in'  or text()='Connexion']")
	})
	WebElement lnkSignIn;

	@FindBy(xpath = "//ul[@class='dds_o-headerNavDropdown -navbar']//a[@href='/web/preLogout.jsp']")
	WebElement lnkSignOut;
	
	@FindAll({
	@FindBy(xpath = "//li[@class='dds_o-navLinkList__item']/a[contains(@class,'dds_m-navLink dropdown-hide')]"),
	@FindBy(xpath = "//div[@class='rcl-navmain']//li[@class='o-navLinkList__item nav-list-active']//a[@class='m-navLink']//Span[@class='m-navLink__caption']"),
	@FindBy(xpath = "//a[@class='m-navLink']//span[@class='m-navLink__chevron rds-icon-expand']")})
	WebElement btnShop;
	
	@FindBy(xpath = "//li[@id='Shop-mobileDropdown']")
	WebElement btnShopMobile;	
	
	@FindBy(xpath="//a[@class='dds-header-mobilenav']")
	WebElement lnkNavMobile;
	
	@FindBy(xpath = "//a[@class='m-navLink']//span[@class='m-navLink__chevron rds-icon-expand']")
	WebElement btnExistingCustomerShop;
	

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/tv']")
	WebElement lnkDTV;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkIgniteTV;
		
	@FindBy(xpath = "//li[@class='dds_o-mobileNavDropdown__item']//a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkIgniteTVMobile;	
	
	@FindBy(xpath = "//a[@class='m-navLink -dropdown' and contains(text(),'TV Bundles')]")
	WebElement lnkExistingCustomerIgniteTV;
		
	@FindBy(xpath = "//a[@href='/web/consumer/internet']")
	WebElement lnkInternet;

	@FindBy(xpath = "//li[@class='dds_o-mobileNavDropdown__item']/a[@href='/web/consumer/internet']")
	WebElement lnkInternetMobile;
	
	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/home-monitoring']")
	WebElement lnkHomeMonitering;
    //li[@class='o-headerNavDropdown__item']/a[@class='m-navLink -dropdown' and contains(text(),' Home Monitoring')]


	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/bundles']")
	WebElement lnkBundle;


	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyRogersLink;
	
	@FindBy(xpath = "//a[@href='/web/totes/#/easylogin/main']")
	WebElement btnRegisterNowFromMyRogers;
	
	//@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/wireless']")
	@FindAll({
		@FindBy(xpath = "(//li[@class='o-headerNavDropdown__item'])[1]//a"),
		@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/wireless']")
	})
	WebElement lnkWireless;
	
	@FindBy(xpath = "//span[text()='View all devices']")
	WebElement btnViewAllDevices;
	
	@FindBy(xpath = "//div[@class='rch-modal']//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement continueBtnIgniteMultipleAddressLookupSubmit;

	@FindBy(xpath = "//a[contains(@title,'See available bundles') or  contains(@title,'Voir les offres groupées')]")
	WebElement btnServiceability;
	//a[contains(@title,'See available Ignite Bundles') or  contains(@title,'Voyez les offres groupées Élan accessibles')]
	//a[@title='Check if Ignite Bundles are available in your area' or @title='Vérifiez si les offres groupées Élan sont disponibles dans votre secteur.']
	
	@FindBy(xpath ="//div[@class='ng-star-inserted overlay']")
	WebElement overlayHomePage;
		
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
	WebElement btnWelcomeback;	
	//a[@title='Check if Ignite Bundles are available in your area']
		
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large']")
	WebElement btnAddress;	
	//button[@class='a-btnSecondary']
	//button[@class='ds-button ds-focus ds-active -secondary -large']
	
	@FindBy(xpath = "//button[@class='a-btnPrimary']")
	WebElement btnAddressValidation;
	
	@FindBy(xpath = "//input[contains(@id,'canada-post-address-complete')]")
	WebElement txaIgniteAddressLookup;		
	//input[contains(@class,'cdk-text-field-autofill-monitored')]
	//span[contains(@class,'ds-formField__labelWrapper position-absolute')]
	//input[contains(@id,'canada-post-address-complete')]
	
	@FindBy(xpath = "//span[contains(@class,'ds-formField__labelWrapper')]")
	WebElement txaIgniteAddressLookupLable;
	
	@FindBy(xpath = "//label[contains(@class,'ds-formField_label')] ")
	WebElement txaIgniteAddressLable;
	
	@FindBy(xpath = "//div[@class='input-search']//div[contains(@class,'ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white')]")
	WebElement txaIgniteAddressContainer;	
	
	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaIgniteAddressContainerExisting;
	
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c15-0 ds-formField__typeds-input')]")
	WebElement txaIgniteLookup;
	
	@FindBy(xpath = "//a[@title='MyRogers']//span[@class='m-navLink__caption']")
	WebElement lnkMyRogers;
	
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large']")
	WebElement btnUseThisAddress;
	//button[@class='ds-button ds-focus ds-active -secondary -large']
	
	
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement btnIgniteAddressLookupSubmit;		
	//button[@class='a-btnPrimary']	
	
	@FindBy(xpath = "//span[@translate='global.targetedOffer.label.noContinueInternet']")
	WebElement lnkOnlyInternet;

	@FindBy(xpath = "//ul[@class='dds_o-navLinkList']//span[contains(text(),'ON')]")
	WebElement lnkOptedON;

	@FindBy(xpath = "//li[@id='province']//span[@class='dds_m-navLink__chevron rds-icon-expand']")
	WebElement lnkProvince;

	@FindBy(xpath = "//a[@class='dds_m-navLink -dropdownNavbar' and @id='ON']")
	WebElement lnkProvinceON;

	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	@FindBy(xpath = "//a[@title='Voir les téléphones intelligents' or @title='View smartphones']")
	WebElement btnViewSmartPhones;
	
	@FindBy(xpath = "//a[@title='Rehaussez votre appareil' or @title='Upgrade your device']")
	WebElement btnUpgradeYourDevice;
	
	@FindBy(xpath = "//a[@title='Voir les forfaits' or @title='View plans']")
	WebElement btnViewPlans;
	
	@FindBy(xpath = "//a[@title='Changez votre forfait' or @title='Change Your Plan']")
	WebElement btnChangeYourPlan;
	
	@FindBy(xpath = "//a[@data-option='financing']")
	WebElement lnkGetNewPhone;
	
	@FindBy(xpath = "//a[@data-option='bring-your-own-phone']")
	WebElement lnkBringMyOwnPhone;
	
	@FindBy(xpath = "//span[@translate='EOP.CTAS.PROMOTION_OFFER_BADGE.LABEL']")
	WebElement lnkPromotionOfferBadge;
	
	@FindBy(xpath = "//div[contains(@class,'ds-modal')]//button[@variant='tertiary']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
	WebElement btnNoThanks;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -tertiary -large ng-star-inserted']")
	WebElement btnNoThnx;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-red']")
	WebElement btnAddNow;
	
	@FindBy(xpath = "//div[@class='subscription-detail']")
	List<WebElement> linkAddSecondLine;
	
	@FindBy(xpath = "//div[@class='line-icon line-shared-icon']")
	WebElement btnToSharedPlan;
	
	@FindBy(xpath = "//div[@class='dds-header-hamburger-nav']")
	WebElement lnkHamburgerMobile;
	
	@FindBy (xpath = "//span[@class='dds_m-mobileNavLink__caption' and (text()='Sign in' or text()='Connexion')]")
	WebElement lnkSignInMobile;
	
	@FindBy(xpath = "//a[@aria-label='View navigation']")
	WebElement lnkViewNavigationMobile;
	
	@FindBy(xpath = "//a[@title='Check availability of Ignite Internet ']/span")
	WebElement lnkInternetAvailability;

	@FindBy(xpath = "(//div[@class='dsa-billboard__wrapper position-relative'])[2]")
	WebElement divInternetBuyPage;

	@FindBy(xpath = "//h2[contains(@class,'dsa-billboard__copyHeading ng-star-inserted')]")
	WebElement txtInternetBuyPage;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderInternetServiceability;
	
	/**
	 * To verify the Home page
	 * @return true if the signin link is available on home page, else false 
	 * @author Saurav.Goyal
	 */
	public boolean verifyHomepage() {
		return getReusableActionsInstance().isElementVisible(lnkSignIn, 60);
	}
	
	/**
	 * Click on add link to add new line
	 * @author Saurav.Goyal
	 */
	public void clkAddSecondLine() {
		getReusableActionsInstance().clickWhenVisible(linkAddSecondLine.get(linkAddSecondLine.size()-1) , 30);
	}
	
	/**
	 * click button add device to a shared plan
	 * @author Saurav.Goyal 
	 */
	public void clkAddDeviceToSharedPlan() {	
		getReusableActionsInstance().clickIfAvailable(btnToSharedPlan, 90);
	}
	
	
	/**
	 * click Add a line to my account add now
	 * @author Saurav.Goyal 
	 */
	public void clkAddNow() {	
		getReusableActionsInstance().clickWhenReady(btnAddNow, 90);
	}
	
	/**
	 * Click on myAccount button on the home page
	 * @author chinnarao.vattam
	 */	
	public void clkNavMobile() {
		getReusableActionsInstance().getWhenReady(lnkNavMobile,20).click();
	}
	
	/**
	 * To Click No thanks on welcome back page
	 * @author Saurav.Goyal 
	 */
	public void clkNoThanks() {	
		getReusableActionsInstance().clickIfAvailable(btnNoThanks, 90);
	}
	
	/**
	 * To Click the Promotion offer badge
	 * @author Saurav.Goyal 
	 */
	public void clkPromotionOfferBadge() {		
		getReusableActionsInstance().getWhenVisible(lnkPromotionOfferBadge, 30).click();
	}
	
	/**
	 * Click the SignIn button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkSignIn() {		
		getReusableActionsInstance().getWhenVisible(lnkSignIn, 60).click();
	}
	
	/**
	 * Click the SignIn button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkTVBundle() {		
		getReusableActionsInstance().getWhenVisible(lnkTVBundle, 30).click();
	}
	
	/**
	 * Click the SignIn button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkEasyLogin() {		
		getReusableActionsInstance().getWhenVisible(lnkEasyLogin, 30).click();
	}
	
	/**
	 * Click the SignIn button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkEasyInternet() {		
		getReusableActionsInstance().getWhenVisible(lnkEasyInternet, 30).click();
	}
		
	/**
	 * checks if the contenful url is displayed
	 * @return true if the contentful url is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isContentFulURLDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkEasyLogin, 30);
		
	}
	
	/**
	 * Click the Sign Out button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkSignOut() {		
		getReusableActionsInstance().getWhenVisible(lnkSignOut, 30).click();
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShop() {
		if(!getReusableActionsInstance().isElementVisible(lnkOptedON,30)){
			getReusableActionsInstance().getWhenReady(lnkProvince,10).click();
			getReusableActionsInstance().getWhenReady(lnkProvinceON,10).click();
		}
		getReusableActionsInstance().getWhenReady(btnShop, 20).click();
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShopMobile() {
		getReusableActionsInstance().getWhenReady(btnShopMobile, 30).click();
	}
	

	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkExistingCustomerShop() {
		getReusableActionsInstance().getWhenReady(btnExistingCustomerShop, 90).click();
	}
	
	
	/**
	 * Click My Rogers button from the top tile bar
	 * @author chinnarao.vattam 
	 */
	public void clkMyRogers() {
		getReusableActionsInstance().getWhenReady(lnkMyRogers, 30).click();
	}
	
	/**
	 * To Click No thanks on welcome back page
	 * @author chinnarao.vattam 
	 */
	public void clkNoThnx() {	
		getReusableActionsInstance().clickIfAvailable(btnNoThnx, 30);
	}
	
	/**
	 * Click the Digital TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	
	public void clkDTV() {
		getReusableActionsInstance().getWhenVisible(lnkDTV,40).click();
	}

	/**
	 * Click the Ignite TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteTV() {
		getReusableActionsInstance().getWhenReady(lnkIgniteTV, 30).click();
	}
	
	/**
	 * Click the Ignite TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteTVMobile() {
		getReusableActionsInstance().getWhenReady(lnkIgniteTVMobile, 30).click();
	}
	
	/**
	 * Click the Ignite TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteTVExistingCustomer() {
		getReusableActionsInstance().waitForElementVisibility(lnkExistingCustomerIgniteTV, 30);
		getReusableActionsInstance().getWhenReady(lnkExistingCustomerIgniteTV).click();
	}

	/**
	 * Click the Internet option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkInternet() {		
		getReusableActionsInstance().getWhenVisible(lnkInternet, 30).click();
	}

	/**
	 * Click the Internet option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkInternetMobile() {		
		getReusableActionsInstance().getWhenVisible(lnkInternetMobile, 30).click();
	}
	
	/**
	 * Click the Home Monitering option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkHomeMonitering() {		
		getReusableActionsInstance().getWhenVisible(lnkHomeMonitering, 30).click();
	}
	
	
	/**
	 * Click the Bundle option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkBundle() {		
		getReusableActionsInstance().getWhenVisible(lnkBundle, 30).click();
	}
	
	/**
	 * Click the MyRogers link from Home page
	 * @author chinnarao.vattam 
	 */
	public void clkMyRogersLink() {
		getReusableActionsInstance().getWhenReady(lnkMyRogersLink).click();
		
	}
	
	/**
	 * Click the Register Now button from Home page
	 * @author chinnarao.vattam 
	 */
	public void clkRegisterNow() {		
		getReusableActionsInstance().getWhenReady(btnRegisterNowFromMyRogers).click();
	}
	
	/**
	 * Clicks on the 'Wireless' menu link under 'Shop' menu
	 * @author rajesh.varalli1
	 */
	public void clkWireless() {
		getReusableActionsInstance().clickWhenReady(lnkWireless);
	}
	
	/**
	 * Clicks on the 'View All Devices' button
	 * @author rajesh.varalli1
	 */
	public void clkViewAllDevices() {
		getReusableActionsInstance().clickWhenVisible(btnViewAllDevices);
	}

	/**
	 * Clicks on the 'Service ability' button
	 * @author chinnarao.vattam
	 */
	public void clkServiceability() {
	if(getReusableActionsInstance().isElementVisible(overlayHomePage,2))
		{
		getReusableActionsInstance().waitForElementInvisibility(overlayHomePage,5);
		}
	getReusableActionsInstance().getWhenReady(btnServiceability, 30).click();
	}
	
	/**
	 * To verify the Ignite page
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgnitepage() {
		return getReusableActionsInstance().isElementVisible(btnServiceability, 60);
	}

	/**
	 * Clicks on the 'Service ability' button for Migration flow
	 * @author chinnarao.vattam
	 */
	public void clkServiceabilityMigration() {		
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam, 90);
		getReusableActionsInstance().getWhenReady(btnServiceability, 30).click();
	}
	
	/**
	 * To verify the Service ability on Ignite page for Migration flow
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyServiceability() {
		return getReusableActionsInstance().isElementVisible(btnServiceability, 60);
	}
	
	/**
	 * Clicks on the Address Check  button to check Service ability
	 * @author chinnarao.vattam
	 */
	public void clkAddressCheck() {
		getReusableActionsInstance().waitForElementVisibility(btnAddress, 90);
		getReusableActionsInstance().getWhenReady(btnAddress, 20).click();
	}
	
	/**
	 * Clicks on the 'Service ability' button
	 * @author rajesh.varalli1
	 */
	public void clkAddressValidation() {
		getReusableActionsInstance().getWhenReady(btnAddressValidation, 60).click();
	}
	
	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @param strAddress address to check the service availability 
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookupLearn(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainer, 90);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainer, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}
	
	public void setIgniteAddressLookup(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainerExisting, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 5).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.TAB);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
	}
	
	/**
	 * Click the OnlyInternet lick to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkOnlyInternet() {
		getReusableActionsInstance().getWhenReady(lnkOnlyInternet, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkOnlyInternet);
	}
	
	/**
	 * Click the OnlyInternet lick to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkOnlyInternetMobile() {
		getReusableActionsInstance().waitForElementInvisibility(loaderInternetServiceability,50);
		getReusableActionsInstance().waitForElementVisibility(lnkOnlyInternet, 10);
		getReusableActionsInstance().executeJavaScriptClick(lnkOnlyInternet);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmitMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnIgniteAddressLookupSubmit,90);
		getReusableActionsInstance().executeJavaScriptClick(btnIgniteAddressLookupSubmit);
	}
	
	/**
	 * Clicks on the 'View Smartphones' button
	 * @author rajesh.varalli1
	 */
	public void clkViewSmartPhones() {
		getReusableActionsInstance().clickWhenReady(btnViewSmartPhones);
	}
	
	/**
	 * Clicks on the 'Upgrade your device' button
	 * @author rajesh.varalli1
	 */
	public void clkUpgradeYourDevice() {
		getReusableActionsInstance().clickWhenReady(btnUpgradeYourDevice);
	}
	
	/**
	 * Clicks on the 'View Plans' button
	 * @author rajesh.varalli1
	 */
	public void clkViewPlans() {
		getReusableActionsInstance().clickWhenReady(btnViewPlans);
	}
	
	/**
	 * Clicks on the 'Change your plan' button
	 * @author rajesh.varalli1
	 */
	public void clkChangeYourPlan() {
		getReusableActionsInstance().clickWhenReady(btnChangeYourPlan);
	}

	/**
	 * To launch Fido home page, this method will be used to replace production page in recover user name flow.
	 * @param url, String, the url of Rogers home page
	 * @author ning.xue
	 */
	public void launchHomePage(String url) {
		getReusableActionsInstance().navigateToPage(url);
	}
	
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author saurav.goyal
	 */
	public void clkContinueIgniteMultipleAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(continueBtnIgniteMultipleAddressLookupSubmit, 30).click();
		}

	/**
	 * Click welcome back popup abandoned  landing page
	 * @author chinnarao vattam
	 */
	public void clkWelcomeback() {
		getReusableActionsInstance().waitForElementVisibility(btnWelcomeback, 60);
		getReusableActionsInstance().getWhenReady(btnWelcomeback, 20).click();
		}
	
	
	/**
	 * To verify the Service ability on Ignite page for Migration flow
	 * @return true if the Welcomeback popup is available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyWelcomeback(){
		return getReusableActionsInstance().isElementVisible(btnWelcomeback, 60);
	}
	
	/**
	 * Click on the existing address selection button
	 * @author chinnarao vattam
	 */
	public void clkUseThisAddress() {
		getReusableActionsInstance().getWhenReady(btnUseThisAddress, 90).click();
		}
	
	/**
	 * Click the hamburger from the top right corner on the page 
	 * @author ning.xue
	 */
	public void clkHamburgerMobile() {		
		getReusableActionsInstance().getWhenVisible(lnkHamburgerMobile, 30).click();
	}
	
	/**
	 * Click the link "Sign in" on the page 
	 * @author ning.xue
	 */
	public void clkSignInMobile() {		
		getReusableActionsInstance().getWhenVisible(lnkViewNavigationMobile,30).click();
		getReusableActionsInstance().getWhenVisible(lnkSignInMobile, 30).click();
	}
	
	
	
	/**
	 * To verify the Service ability on Ignite page for Migration flow
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyInternetpage() {
		//page is taking more time to load , temporary wait
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(divInternetBuyPage,90);
		return getReusableActionsInstance().isElementVisible(txtInternetBuyPage, 30);
	}
	/**
	 * Click the InternetAvailability link Internet on the page 
	 * @author chinnarao.vattam
	 */
	public void clkInternetAvailability() {
		getReusableActionsInstance().waitForElementVisibility(lnkInternetAvailability,120);
		getReusableActionsInstance().getWhenReady(lnkInternetAvailability,30).click();
	}
	
}

