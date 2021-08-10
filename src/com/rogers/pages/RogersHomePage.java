package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//a[@class='m-navLink -dropdown' and contains(text(),'Internet')]")
	WebElement lnkExstingCustInternet;

	@FindBy(xpath = "//a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkTVBundle;

	@FindAll({
			@FindBy(xpath = "//div[@class='dds-navbar-nav']//a[@aria-label='Sign in to My Rogers']//span[text()='Sign in'  or text()='Connexion']"),
			@FindBy(xpath = "//div[@class='rcl-navbar-nav']//a[@class='m-navLink -navbar -login']//span[text()='Sign in'  or text()='Connexion']"),
			@FindBy(xpath = "//a[@title='Sign in' and contains(@class,'m-navLink')]")})
	WebElement lnkSignIn;

	@FindAll({
			@FindBy(xpath = "//ul[@class='dds_o-headerNavDropdown -navbar']//a[@href='/web/preLogout.jsp']"),
			@FindBy(xpath = "//a[@title='Sign out' and contains(@class,'m-navLink')]")})
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

	@FindAll({	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/web/consumer/ignite-bundles/tv-internet']"),
			@FindBy(xpath = "//li[@class='o-headerNavDropdown__item ng-star-inserted']//a[contains(text(),'TV Bundles') or contains(text(),'Offres groupées Télé')]")})
	WebElement lnkIgniteTV;
		
	@FindBy(xpath = "//li[@class='dds_o-mobileNavDropdown__item']//a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkIgniteTVMobile;	
	
	@FindBy(xpath = "//a[@class='m-navLink -dropdown' and contains(text(),'TV Bundles')]")
	WebElement lnkExistingCustomerIgniteTV;
		
	@FindBy(xpath = "//a[@href='/web/consumer/internet']")
	WebElement lnkInternet;

	@FindBy(xpath = "//li[@class='o-headerNavDropdown__item']//a[contains(text(),'Internet')]")
	WebElement lnkSmartInternet;


	@FindBy(xpath = "//li[@class='dds_o-mobileNavDropdown__item']/a[@href='/web/consumer/internet']")
	WebElement lnkInternetMobile;
	
	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/home-monitoring']")
	WebElement lnkHomeMonitering;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/bundles']")
	WebElement lnkBundle;

	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyRogersLink;

	@FindBy(xpath = "//a[@title='MyRogers']//span[@class='m-navLink__caption']")
	WebElement lnkMyRogersfromAccount;

	@FindBy(xpath = "//a[@href='/web/totes/#/easylogin/main']")
	WebElement btnRegisterNowFromMyRogers;

	@FindAll({
		@FindBy(xpath = "(//li[@class='o-headerNavDropdown__item'])[1]//a"),
		@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/wireless']")
	})
	WebElement lnkWireless;
	
	@FindBy(xpath = "//span[text()='View all devices']")
	WebElement btnViewAllDevices;
	
	@FindBy(xpath = "//div[@class='rch-modal']//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement continueBtnIgniteMultipleAddressLookupSubmit;

	@FindAll({
			@FindBy(xpath = "//a[contains(@title,'See available bundles') or  contains(@title,'Voir les offres groupées')]"),
			//@FindBy(xpath = "//a[contains(@title,'See bundles with Ignite TV and Internet') or  contains(@title,'Voir les offres groupées avec la Télé Élan et Élan Internet')]"),
			@FindBy(xpath = "//a[contains(@title,'View Ignite TV + Internet bundles available to you') or  contains(@title,'Voir les offres groupées Télé Élan + Internet qui vous sont proposées')]")})
	WebElement btnServiceability;

	@FindBy(xpath ="//div[@class='ng-star-inserted overlay']")
	WebElement overlayHomePage;
		
	@FindBy(xpath = "//a[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']")
	WebElement btnWelcomeback;

	@FindAll({
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large']"),
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -secondary -large']")})
	WebElement btnAddress;	

	@FindBy(xpath = "//button[@class='a-btnPrimary']")
	WebElement btnAddressValidation;

	@FindAll({
	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-')]"),
	@FindBy(xpath = "//input[contains(@id,'canada-post-address-complete')]")})
	WebElement txaIgniteAddressLookup;		

	@FindBy(xpath = "//div[@id='multipleUnitsModal'] ")
	WebElement popupIgniteAddressLookupLable;

	@FindBy(xpath = "//span[contains(@class,'ds-formField__labelWrapper')]")
	WebElement txaIgniteAddressLookupLable;
	
	@FindBy(xpath = "//label[contains(@class,'ds-formField_label')] ")
	WebElement txaIgniteAddressLable;
	
	@FindBy(xpath = "//div[@class='input-search']//div[contains(@class,'ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white')]")
	WebElement txaIgniteAddressContainer;	
	
	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaIgniteAddressContainerExisting;

	@FindBy(xpath = "//div[@class='pca-address-lookup-component ng-star-inserted']//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaAnotherAddressContainer;

	@FindBy(xpath = "//div[contains(text(),'BSMT')]")
	WebElement rdoBasement;

	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c15-0 ds-formField__typeds-input')]")
	WebElement txaIgniteLookup;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large']")
	WebElement btnUseThisAddress;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']/span")
	WebElement btnIgniteAddressLookupSubmit;

	@FindBy(xpath = "//div[@class='serviceability__cta ng-star-inserted']//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']/span")
	WebElement btnAnotherAddressLookupSubmit;

	@FindBy(xpath = "//div[@footer]//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']/span")
	WebElement btnAnotherLookupSubmit;

	@FindBy(xpath = "//ds-icon[@name='location']")
	WebElement lnkCheckAnotherAddress;

	@FindBy(xpath = "//span[@translate='global.targetedOffer.label.noContinueInternet']")
	WebElement lnkOnlyInternet;

	@FindBy(xpath = "//ul[@class='dds_o-navLinkList']//span[contains(text(),'ON')]")
	WebElement lnkOptedON;

	@FindBy(xpath = "//a[@aria-label='Ontario']//span[@class='m-navLink__chevron rds-icon-expand']")
	WebElement lnkProvince;

	@FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar' and @title='Ontario']")
	WebElement lnkProvinceON;

	@FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar' and @title='New Brunswick']")
	WebElement lnkProvinceNB;

	@FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar' and @title='Newfoundland and Labrador']")
	WebElement lnkProvinceNL;

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

	@FindAll({
	@FindBy(xpath = "//a[@title='Check availability of Ignite Internet ']"),
	//@FindBy(xpath = "//a[@title='View internet bundles available to you']/span")
	})
	WebElement lnkInternetAvailability;

	@FindAll({@FindBy(xpath = "//a[@title='View internet bundles available to you']/span")})
	WebElement lnkInternetwithSSAvailability;

	@FindAll({
	//@FindBy(xpath = "//span[@class='mb-0 flex-grow-1 text-title-4']"),
	@FindBy(xpath = "//p[@class='text-title-4 mb-0 py-16']")})
	WebElement txtInternetBuyPage;
  //@FindBy(xpath = "//h1[contains(text(),'Internet')]")

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderInternetServiceability;

	@FindBy(xpath = "//span[@class='m-navLink__icon rds-icon-avatar']")
	WebElement btnIconAvatar;

	@FindBy(xpath = "//dsa-subnav-desktop//a[@title='View links to Ignite Internet Information Pages']")
	WebElement subnavIgniteInternet;

	@FindAll({
	@FindBy(xpath = "//dsa-subnav-desktop//a[@title='View links to TV & Streaming information pages']"),
	@FindBy(xpath = "//span[contains(text(),'TV & Streaming') or contains(text(),'Télé et Diffusion en continu')]/ancestor::li[@role='menuitem']//ds-icon[@name='right']")})
	WebElement subnavIgniteSmartStream;

	@FindAll({
	@FindBy(xpath = "//dsa-subnav-desktop//a[@title='Open for help on Ignite SmartStream']"),
	@FindBy(xpath = "//dsa-subnav-desktop//a[@title='Open for help on Ignite Internet products']")})
	WebElement subnavHelpAndSupport;

	@FindBy(xpath = "//li[@class='mb-0 ng-star-inserted']//a[contains(@title,'Open to learn more about Ignite Internet') or contains(@title,'Ouvrir pour en savoir plus sur Élan Internet')]")
	WebElement lnkAboutIgniteInternet;

	@FindBy(xpath = "//li[@class='mb-0 ng-star-inserted']//a[contains(@title,'Ignite WiFi Promise') or contains(@title,'promesse Élan WiFi')]")
	WebElement lnkIgniteWiFiPromise;

	@FindBy(xpath = "//li[@class='mb-0 ng-star-inserted']//a[contains(@title,'Ignite WiFi Hub') or contains(@title,'centre Élan WiFi')]")
	WebElement lnkIgniteWiFiHub;

	@FindBy(xpath = "//li[@class='mb-0 ng-star-inserted']//a[contains(@title,'Check availability of Ignite') or contains(@title,'d’Élan Internet à votre adresse')]")
	WebElement lnkIgniteInternet;

	@FindBy(xpath = "//a[@class='c-navbar-link' and @translate='nav.overview.header']")
	WebElement btnAccOverview;

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
	 * click Add a line to my account add now
	 * @author chinnarao.vattam
	 */
	public void clkAccOverview() {
		getReusableActionsInstance().clickWhenReady(btnAccOverview, 30);
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
	public void clkSignIn() { getReusableActionsInstance().getWhenVisible(lnkSignIn, 60).click();
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
		getReusableActionsInstance().clickIfAvailable(lnkEasyInternet, 30);
	}

	/**
	 * Click the Ignite Internet from the sub navigator
	 * @author chinnarao.vattam
	 */
	public void clkSubnavIgniteInternet() {
		getReusableActionsInstance().getWhenVisible(subnavIgniteInternet, 30).click();
	}

	/**
	 * Click the Ignite Internet from the sub navigator
	 * @author chinnarao.vattam
	 */
	public void clkSubnavIgniteSmartStream() {
		getReusableActionsInstance().getWhenVisible(subnavIgniteSmartStream, 30).click();
	}

	/**
	 * Click the Ignite Internet from the sub navigator
	 * @author chinnarao.vattam
	 */
	public void clkSubnavHelpAndSupport() {
		getReusableActionsInstance().getWhenVisible(subnavHelpAndSupport, 30).click();
	}

	/**
	 * checks if the About Ignite Internet link is displayed
	 * @return true if the About Ignite Internet link is displayed else false
	 * @author chinnarao.vattam
	 */
	public boolean isSubnavIgniteInternetPresent()  {
		return getReusableActionsInstance().isElementVisible(subnavIgniteInternet, 30);
	}

	/**
	 * checks if the About Ignite Internet link is displayed
	 * @return true if the About Ignite Internet link is displayed else false
	 * @author chinnarao.vattam
	 */
	public boolean isSubnavIgniteSmartStream()  {
		return getReusableActionsInstance().isElementVisible(subnavIgniteSmartStream, 30);
	}

	/**
	 * checks if the About Ignite Internet link is displayed
	 * @return true if the About Ignite Internet link is displayed else false
	 * @author chinnarao.vattam
	 */
	public boolean isSubnavHelpAndSupport()  {
		return getReusableActionsInstance().isElementVisible(subnavHelpAndSupport, 30);
	}

	/**
	 * checks if the About Ignite Internet link is displayed
	 * @return true if the About Ignite Internet link is displayed else false
	 * @author chinnarao.vattam
	 */
	public boolean isAboutIgniteInternetLinkPresent()  {
		return getReusableActionsInstance().isElementVisible(lnkAboutIgniteInternet, 30);
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkExistingCustomerInternet() {
		getReusableActionsInstance().getWhenVisible(lnkExstingCustInternet, 30).click();
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkIgniteWiFiPromise() {
		getReusableActionsInstance().getWhenVisible(lnkIgniteWiFiPromise, 30).click();
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkIgniteWiFiHub() {
		getReusableActionsInstance().getWhenVisible(lnkIgniteWiFiHub, 30).click();
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkIgniteInternet() {
		getReusableActionsInstance().getWhenVisible(lnkIgniteInternet, 30).click();
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkSmartInternet() {
		getReusableActionsInstance().getWhenVisible(lnkSmartInternet, 30).click();
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
		getReusableActionsInstance().getWhenVisible(btnIconAvatar,30).click();
		getReusableActionsInstance().getWhenReady(lnkSignOut, 10).click();
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShop() {
	/*	if(!getReusableActionsInstance().isElementVisible(lnkOptedON,60)){
			getReusableActionsInstance().getWhenReady(lnkProvince,10).click();
			getReusableActionsInstance().getWhenReady(lnkProvinceON,10).click();
		}*/
		getReusableActionsInstance().getWhenReady(btnShop, 20).click();
	}

	public void clkShopAbandon() {
		getReusableActionsInstance().getWhenReady(btnShop, 20).click();
	}

	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam
	 */
	public void clkShopCartAbondon() {
		getReusableActionsInstance().getWhenReady(btnShop, 60).click();
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
		getReusableActionsInstance().getWhenReady(lnkMyRogersfromAccount, 30).click();
	}


	/**
	 * Click the MyRogers link from Home page
	 * @author chinnarao.vattam
	 */
	public void clkMyRogersLink() {
		getReusableActionsInstance().getWhenReady(lnkMyRogersLink).click();

	}

	/**
	 * To Click No thanks on welcome back page
	 * @author chinnarao.vattam 
	 */
	public void clkNoThnx() {	
		getReusableActionsInstance().clickIfAvailable(btnNoThnx, 60);
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
		getReusableActionsInstance().waitForElementVisibility(lnkExistingCustomerIgniteTV, 60);
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
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkTVBundlesForNL() {
		getReusableActionsInstance().isElementVisible(lnkOptedON,20);
		getReusableActionsInstance().getWhenReady(lnkProvince, 20).click();
		getReusableActionsInstance().getWhenReady(lnkProvinceNL, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkProvinceNL);
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkTVBundlesForNB() {
		getReusableActionsInstance().isElementVisible(lnkOptedON,20);
		getReusableActionsInstance().getWhenReady(lnkProvince, 20).click();
		getReusableActionsInstance().getWhenReady(lnkProvinceNB, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkProvinceNB);
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
	 * Clicks on the 'Service ability' button
	 * @author chinnarao.vattam
	 */
	public void clkServiceabilityMobile() {
		if(getReusableActionsInstance().isElementVisible(overlayHomePage,2))
		{
			getReusableActionsInstance().waitForElementInvisibility(overlayHomePage,5);
		}
		getReusableActionsInstance().getWhenReady(btnServiceability, 30);
		getReusableActionsInstance().executeJavaScriptClick(btnServiceability);
	}

	/**
	 * To verify the Ignite page
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgnitepage() {
		getReusableActionsInstance().staticWait(6000);
		return getReusableActionsInstance().isElementVisible(btnServiceability, 60);
	}

	/**
	 * Clicks on the 'Service ability' button for Migration flow
	 * @author chinnarao.vattam
	 */
	public void clkServiceabilityMigration() {
		//Migration flow loading for long to ger serviceability model
		getReusableActionsInstance().staticWait(6000);
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
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainer, 20);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainer, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 5).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}
	
	public void setIgniteAddressLookup1(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainerExisting, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 5).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.TAB);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup ).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup,10).sendKeys(Keys.ENTER);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}

	public void setIgniteAddressLookup(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
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

	public void setIgniteAddressLookupRetry() {
		getReusableActionsInstance().waitForElementVisibility(popupIgniteAddressLookupLable, 30);
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60);
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
	}

	public void setIgniteAddressLookupBasement() {
		getReusableActionsInstance().waitForElementVisibility(popupIgniteAddressLookupLable, 30);
		getReusableActionsInstance().getWhenReady(rdoBasement, 10).click();
	}

	public void selectIgniteAddressLookupBasement(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
		getReusableActionsInstance().getWhenReady(txaIgniteAddressContainerExisting, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 5).sendKeys(strAddress);
		String strAddressResultXpath = "//ul[@role='listbox']/li[contains(@ng-reflect-result,'') and contains(text(),'address')]";
		try{
			getReusableActionsInstance().getWhenReady(By.xpath(strAddressResultXpath.replace("address", "BSMT-"+strAddress.trim())), 10).click();

		}catch (Exception e){
			getReusableActionsInstance().getWhenReady(By.xpath("//ul[@role='listbox']/li[contains(@ng-reflect-result,'')]"), 10).click();
		}
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkAnotherAddressLookupSubmit() {
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().getWhenReady(btnAnotherAddressLookupSubmit, 60).click();
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkAnotherLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnAnotherLookupSubmit, 60).click();
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkCheckAnotherAddress() {
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().getWhenReady(lnkCheckAnotherAddress, 90);
		getReusableActionsInstance().executeJavaScriptClick(lnkCheckAnotherAddress);
	}

	public void setAnotherAddressLookup1(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaAnotherAddressContainer, 60);
		getReusableActionsInstance().getWhenReady(txaAnotherAddressContainer, 3).click();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 5).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.TAB);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup ).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 1).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 2).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}

	public void setAnotherAddressLookup(String strAddress) {
		getReusableActionsInstance().waitForElementVisibility(txaIgniteAddressContainerExisting, 60);
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
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmitSS() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 60).click();
		getReusableActionsInstance().staticWait(7000);
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
		getReusableActionsInstance().waitForElementVisibility(txtInternetBuyPage,90);
		return getReusableActionsInstance().isElementVisible(txtInternetBuyPage, 30);
	}
	/**
	 * Click the InternetAvailability link Internet on the page 
	 * @author chinnarao.vattam
	 */
	public void clkInternetAvailability() {
		getReusableActionsInstance().waitForElementVisibility(lnkInternetAvailability,120);
		getReusableActionsInstance().getWhenReady(lnkInternetAvailability,30).click();
		getReusableActionsInstance().clickIfAvailable(lnkInternetAvailability,30);
	}
	
}

