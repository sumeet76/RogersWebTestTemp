package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersHomePage extends BasePageClass {

	public RogersHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='dds-navbar-nav']//a[@aria-label='Sign in to My Rogers']//span[text()='Sign in'  or text()='Connexion']")
	WebElement lnkSignIn;

	@FindBy(xpath = "//ul[@class='dds_o-headerNavDropdown -navbar']//a[@href='/web/preLogout.jsp']")
	WebElement lnkSignOut;
	
	@FindBy(xpath = "//li[@class='dds_o-navLinkList__item']/a[contains(@class,'dds_m-navLink dropdown-hide')]")
	WebElement btnShop;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/tv']")
	WebElement lnkDTV;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement lnkIgniteTV;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/internet']")
	WebElement lnkInternet;

	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/bundles']")
	WebElement lnkBundle;
	
	@FindBy(xpath = "//a[@href='/consumer/easyloginriverpage']")
	WebElement lnkMyRogersLink;
	
	@FindBy(xpath = "//a[@href='/web/totes/#/easylogin/main']")
	WebElement btnRegisterNowFromMyRogers;
	
	@FindBy(xpath = "//li[@class='dds_o-headerNavDropdown__item']/a[@href='/consumer/wireless']")
	WebElement lnkWireless;
	
	@FindBy(xpath = "//span[text()='View all devices']")
	WebElement btnViewAllDevices;
	
	@FindBy(xpath = "//div[@class='rch-modal']//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement continueBtnIgniteMultipleAddressLookupSubmit;

	@FindBy(xpath = "	//a[contains(@title,'See available Ignite Bundles') or  contains(@title,'Voyez les offres groupées Élan accessibles')]")
	WebElement btnServiceability;
	//a[@title='Check if Ignite Bundles are available in your area' or @title='Vérifiez si les offres groupées Élan sont disponibles dans votre secteur.']
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
	WebElement btnWelcomeback;	
	//a[@title='Check if Ignite Bundles are available in your area']
		
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -secondary -large']")
	WebElement btnAddress;
	
	@FindBy(xpath = "//button[@class='a-btnPrimary']")
	WebElement btnAddressValidation;
	
	@FindBy(xpath = "//input[contains(@id,'canada-post-address-complete')]")
	WebElement txaIgniteAddressLookup;		
	//input[contains(@class,'cdk-text-field-autofill-monitored')]
	
	@FindBy(xpath = "//span[contains(@class,'ds-formField__labelWrapper')]")
	WebElement txaIgniteAddressLookupLable;
	
	@FindBy(xpath = "//label[contains(@class,'ds-formField_label')] ")
	WebElement txaIgniteAddressLable;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c21-20')]//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaIgniteAddressContainer;	
	
	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaIgniteAddressContainerExisting;
	
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c15-0 ds-formField__typeds-input')]")
	WebElement txaIgniteLookup;
	
	@FindBy(xpath = "//li[@class='dds_o-navLinkList__item']//a[@title='MyRogers']")
	WebElement lnkMyRogers;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -secondary -large']")
	WebElement btnUseThisAddress;
		
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']")
	WebElement btnIgniteAddressLookupSubmit;
	
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
	
	/**
	 * Click the SignIn button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkSignIn() {		
		reusableActions.getWhenVisible(lnkSignIn, 30).click();
	}

	/**
	 * Click the Sign Out button from the top tile bar 
	 * @author chinnarao.vattam 
	 */
	public void clkSignOut() {		
		reusableActions.getWhenVisible(lnkSignOut, 90).click();
	}
	
	/**
	 * Click the shop dropdown list from the top tile bar on Home page
	 * @author chinnarao.vattam 
	 */
	public void clkShop() {
		reusableActions.getWhenReady(btnShop, 60).click();				
	}

	
	/**
	 * Click My Rogers button from the top tile bar
	 * @author chinnarao.vattam 
	 */
	public void clkMyRogers() {
		reusableActions.getWhenReady(lnkMyRogers, 60).click();
	}
	
	
	/**
	 * Click the Digital TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	
	public void clkDTV() {
		reusableActions.getWhenVisible(lnkDTV,40).click();
	}

	/**
	 * Click the Ignite TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteTV() {
		reusableActions.getWhenReady(lnkIgniteTV, 30).click();
	}
	
	/**
	 * Click the Ignite TV option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteTVExistingCustomer() {
		reusableActions.waitForElementVisibility(lnkIgniteTV, 30);
		reusableActions.executeJavaScriptClick(lnkIgniteTV);
	}

	/**
	 * Click the Internet option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkInternet() {		
		reusableActions.getWhenVisible(lnkInternet, 60).click();
	}

	/**
	 * Click the Bundle option from shop dropdown list
	 * @author chinnarao.vattam 
	 */
	public void clkBundle() {		
		reusableActions.getWhenVisible(lnkBundle, 60).click();
	}
	
	/**
	 * Click the MyRogers link from Home page
	 * @author chinnarao.vattam 
	 */
	public void clkMyRogersLink() {
		reusableActions.getWhenReady(lnkMyRogersLink).click();
		
	}
	
	/**
	 * Click the Register Now button from Home page
	 * @author chinnarao.vattam 
	 */
	public void clkRegisterNow() {		
		reusableActions.getWhenReady(btnRegisterNowFromMyRogers).click();
	}
	
	/**
	 * Clicks on the 'Wireless' menu link under 'Shop' menu
	 * @author rajesh.varalli1
	 */
	public void clkWireless() {
		reusableActions.clickWhenReady(lnkWireless);
	}
	
	/**
	 * Clicks on the 'View All Devices' button
	 * @author rajesh.varalli1
	 */
	public void clkViewAllDevices() {
		reusableActions.clickWhenVisible(btnViewAllDevices);
	}

	/**
	 * Clicks on the 'Service ability' button
	 * @author chinnarao.vattam
	 */
	public void clkServiceability() {
		reusableActions.getWhenReady(btnServiceability, 120).click();
	}
	
	/**
	 * To verify the Ignite page
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgnitepage() {
		return reusableActions.isElementVisible(btnServiceability, 120);
	}

	/**
	 * Clicks on the 'Service ability' button for Migration flow
	 * @author chinnarao.vattam
	 */
	public void clkServiceabilityMigration() {		
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam, 120);
		reusableActions.getWhenReady(btnServiceability, 120).click();
	}
	
	/**
	 * To verify the Service ability on Ignite page for Migration flow
	 * @return true if the Service ability button is available on Ignite page, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyServiceability() {
		return reusableActions.isElementVisible(btnServiceability, 60);
	}
	
	/**
	 * Clicks on the Address Check  button to check Service ability
	 * @author chinnarao.vattam
	 */
	public void clkAddressCheck() {
		reusableActions.waitForElementVisibility(btnAddress, 60);
		reusableActions.getWhenReady(btnAddress, 60).click();
	}
	
	/**
	 * Clicks on the 'Service ability' button
	 * @author rajesh.varalli1
	 */
	public void clkAddressValidation() {
		reusableActions.getWhenReady(btnAddressValidation, 60).click();
	}
	
	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @param strAddress address to check the service availability 
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookupCovid(String strAddress) {
		reusableActions.waitForElementVisibility(txaIgniteAddressContainer, 120);
		reusableActions.getWhenReady(txaIgniteAddressContainer, 3).click();
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).clear();
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}
	
	public void setIgniteAddressLookup(String strAddress) {
		reusableActions.waitForElementVisibility(txaIgniteAddressContainerExisting, 120);
		reusableActions.getWhenReady(txaIgniteAddressContainerExisting, 3).click();
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).clear();
		reusableActions.getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		reusableActions.getWhenReady(btnIgniteAddressLookupSubmit, 120).click();
	}
	
	/**
	 * Clicks on the 'View Smartphones' button
	 * @author rajesh.varalli1
	 */
	public void clkViewSmartPhones() {
		reusableActions.clickWhenReady(btnViewSmartPhones);
	}
	
	/**
	 * Clicks on the 'Upgrade your device' button
	 * @author rajesh.varalli1
	 */
	public void clkUpgradeYourDevice() {
		reusableActions.clickWhenReady(btnUpgradeYourDevice);
	}
	
	/**
	 * Clicks on the 'View Plans' button
	 * @author rajesh.varalli1
	 */
	public void clkViewPlans() {
		reusableActions.clickWhenReady(btnViewPlans);
	}
	
	/**
	 * Clicks on the 'Change your plan' button
	 * @author rajesh.varalli1
	 */
	public void clkChangeYourPlan() {
		reusableActions.clickWhenReady(btnChangeYourPlan);
	}

	/**
	 * To launch Fido home page, this method will be used to replace production page in recover user name flow.
	 * @param url, String, the url of Rogers home page
	 * @author ning.xue
	 */
	public void launchHomePage(String url) {
		reusableActions.navigateToPage(url);
	}
	
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author saurav.goyal
	 */
	public void clkContinueIgniteMultipleAddressLookupSubmit() {
		reusableActions.getWhenReady(continueBtnIgniteMultipleAddressLookupSubmit, 120).click();
		}

	/**
	 * Click welcome back popup abandoned  landing page
	 * @author chinnarao vattam
	 */
	public void clkWelcomeback() {
		reusableActions.waitForElementVisibility(btnWelcomeback, 120);
		reusableActions.getWhenReady(btnWelcomeback, 90).click();
		}
	
	/**
	 * Click on the existing address selection button
	 * @author chinnarao vattam
	 */
	public void clkUseThisAddress() {
		reusableActions.getWhenReady(btnUseThisAddress, 120).click();
		}
	
	
}

