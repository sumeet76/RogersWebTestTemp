package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersIgniteTVBuyPage extends BasePageClass {

	public RogersIgniteTVBuyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan Sélection') or contains(normalize-space(.),'Ignite TV Select')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.label.activateLater']")
	WebElement chkActivateLater;
	
	@FindBy(xpath ="//button[@class='ute-btn-secondary']//ins[@translate='global.cta.yes']")
	WebElement btnActivateLater;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan Découverte') or contains(normalize-space(.),'Ignite TV Starter')]/ancestor::div[@class='box-shadow-targeted-offer']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackage;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan ') or contains(normalize-space(.),'Ignite TV Popular')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisSelectPackage;
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan ') or contains(normalize-space(.),'Ignite TV Popular')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']")
	WebElement btnSolarisPopularPackage;
	
	@FindBy(id = "addressLookup-modal")
	WebElement txaIgniteAddressLookup;

	@FindBy(xpath = "//ins[@translate='global.cta.check']")
	WebElement btnIgniteAddressLookupSubmit;
	
	@FindBy(xpath = "//div[@class='check-availability-btn']//ins[@translate='global.cta.checkAvailability']")
	WebElement btnIgniteCheckAvailability;
	
		
	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@translate='global.cta.continue']")
	WebElement btnGoodNewsContinue;
	
		
	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//ins[@translate='global.common.buttons.noThanksContinue']")
	WebElement btnNoThanksContinue;
	
	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//ins[@translate='global.modals.rhpSplitterModal.portMyNumber']")
	WebElement btnKeepMyNumber;
	
	@FindBy(xpath = "//button[@class='continue-addon ds-button ds-focus ds-active -primary -large']")
	WebElement btnHomePhoneContinue;
	
	@FindBy(xpath = "//label[@for='have4K-yes']")
	WebElement rdo4KTV;
	
	@FindBy(xpath = "//span[@translate='global.cta.checkout']")
	WebElement btnCheckout;	
	//button[@class='mr-24 cart-summary-checkout ds-button ds-focus ds-active -primary -large']
	
	@FindBy(xpath ="//div[@class='mt-auto w-100']//button[@aria-label='Order Rogers Ignite Starter online now']")
	WebElement btnSolarisStarterPackageServiceability;	
	
	@FindBy(xpath ="//div[@class='mt-auto w-100']//button[@aria-label='Add Rogers Ignite Starter Bundle to cart']//span[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackageNew;	
	
	@FindBy(xpath = "//p[@id='ds-modal-title-1']")
	WebElement popImportantInformation;
	   
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']")
	WebElement btnIUnderstand;	  
	
	@FindBy(xpath ="//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForNewNumber')]")
	WebElement rdoOptNewPhone;
	////(//div[@class='a-radio'])[2]//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForNewNumber')]
	
	@FindBy(xpath ="(//div[@class='a-radio'])[2]//span")
	WebElement rdoOptNewPhoneEnable;
	
	@FindBy(xpath ="//button[@class='ds-button ds-focus ds-active -primary -large']")
	WebElement btnOptPhone;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Starter') or contains(normalize-space(.),'Élan Découverte')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmStarterRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Select') or contains(normalize-space(.),'Élan Sélection')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmSelectRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Premier') or contains(normalize-space(.),'Élan Premier')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmPremierRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Popular') or contains(normalize-space(.),'Élan Populaire')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmPopularRatecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Flex 10') or contains(normalize-space(.),'Élan Flex 10')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmFlex10Ratecard;
	
	@FindBy(xpath ="//h2[@ute-content-source='atg']//span[contains(normalize-space(.),'Ignite Flex 5') or contains(normalize-space(.),'Élan Flex 5')]/ancestor::div[@class='bundle-offer__tile']")
	WebElement elmFlex5Ratecard;
	
	@FindBy(xpath ="//ins[@translate='global.label.themePacksTab']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabThemePacksTab;
	
	@FindBy(xpath ="//ins[@translate='global.label.channelsTab']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabChannelsTab;
	
	@FindBy(xpath ="//ins[@translate='global.label.bundles']/ancestor::h2[@class='solaris-tab-list-header']")
	WebElement tabBundles;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Starter Bundle') or contains(normalize-space(.),'Offre groupée Élan Découverte')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtStarterChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Select Bundle') or contains(normalize-space(.),'Offre groupée Élan Sélection')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtSelectChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Premier Bundle') or contains(normalize-space(.),'Offre groupée Élan Premier')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtPremierChannels;
	
	@FindBy(xpath ="//h3[contains(normalize-space(.),'Rogers Ignite Popular Bundle') or contains(normalize-space(.),'Offre groupée Élan Populaire')]/ancestor::bundle-mini-component[@class='bundle-mini-component channel-column']//ins[@translate='global.label.tvChannelsCount']")
	WebElement txtPopularChannels;	
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -tertiary -large -hasDsIcon']//following-sibling::button")
	WebElement buttonUpgradeNow;
	
	@FindBy(xpath = "//button[contains(@class,'stb-button increment')]//span[@class='ds-button__copy w-100']")
	WebElement buttonAddIgniteTVBoxes;
	
	@FindBy(xpath = "//span[@translate='global.cta.updateCart']")
	WebElement buttonUpdateCart;
	
	@FindBy(xpath = "//ds-modal-container[contains(@id,'ds-modal-container')]")
	WebElement modalUpgradingToIgnitebundels;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement okayUpgradingToIgnitebundelsModal;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Starter Bundle to cart')]//ancestor::div[contains(@class,'d-flex')]/preceding-sibling::section//h2[@class='gwp-header']")
	WebElement gwpHeader;
	
	@FindBy(xpath = "//i[@class='ng-tns-c46-26 rch-icon-chevron-down']")
	WebElement downChevronCartSummary;
	
	@FindBy(xpath = "//div[contains(@class,'mini-cart-ss__body')]//tr[@class='cms-promotions-gwp ng-tns-c46-27 ng-star-inserted']")
	WebElement gwpYourCart;
	
	@FindBy(xpath ="//button[contains(@aria-label,'Starter Bundle')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']")
	WebElement chevronSolarisStarterPackageNew;	
	
	@FindBy(xpath ="//input[contains(@id,'messageForExistingNumber')]//following-sibling::label")
	WebElement rdoKeepExistingPhoneNumber;
	
	/**
	 * To click on the chevron of your cart
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		reusableActions.getWhenReady(downChevronCartSummary, 60).click();
	}
	
	/**
	 * To verify gwp promotion in the cart summary
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
			reusableActions.waitForElementVisibility(gwpYourCart, 120);
			return	reusableActions.isElementVisible(gwpYourCart);
	}
	
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPForStarterPackage() {
			reusableActions.waitForElementVisibility(gwpHeader, 120);
			return	reusableActions.isElementVisible(gwpHeader);
	}
		
	/**
	 * To click on the chevron of the starter bundel package
	 * @author Saurav.Goyal
	 */
	public void clkChevronSolarisStarterPackageNew() {
		reusableActions.getWhenReady(chevronSolarisStarterPackageNew, 60).click();
	}
	
	
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyUpgradingToIgnitebundelsModal() {
			reusableActions.waitForElementVisibility(modalUpgradingToIgnitebundels, 120);
			return	reusableActions.isElementVisible(modalUpgradingToIgnitebundels);
	}
	
	/**
	 * To click okay on the modal Upgrading To Ignite bundels
	 * @author Saurav.Goyal
	 */
	public void clkOkayUpgradingToIgnitebundelsModal() {
		reusableActions.getWhenReady(okayUpgradingToIgnitebundelsModal, 60).click();
	}
	
	
	/**
	 * Click keep my existing phone number radio button
	 * @author Saurav.Goyal
	 */
	public void clkRadioOptKeepMyExistingPhoneNumber() {
		reusableActions.getWhenReady(rdoKeepExistingPhoneNumber, 60).click();
	}
	
	/**
	 * Click + to add STB ignite TV boxes
	 * @author Saurav.Goyal
	 */
	public void clkPlusAddIgniteTVBoxes() {
		reusableActions.getWhenReady(buttonAddIgniteTVBoxes, 30).click();
	}
	
	/**
	 * To Click Update cart button
	 * @author Saurav.Goyal
	 */
	public void clkUpdateCart() {
		reusableActions.getWhenReady(buttonUpdateCart, 30).click();
	}
	
	/**
	 * Verify visibility of upgrade now button
	 * @return	boolean true if the element is present else false
	 * @author Saurav.Goyal 
	 */
	public boolean verifyButtonUpgradeNow() {		
		reusableActions.waitForElementVisibility(buttonUpgradeNow, 120);
		return	reusableActions.isElementVisible(buttonUpgradeNow);
	}
	
	/**
	 * click upgrade now button
	 * @author Saurav.Goyal 
	 */
	public void clkButtonUpgradeNow() {		
		reusableActions.getWhenReady(buttonUpgradeNow, 120).click();
	}

	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @param strAddress address to check the service availability 
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookup(String strAddress) {
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
		reusableActions.getWhenReady(btnIgniteAddressLookupSubmit, 30).click();
	}
	
	/**
	 * Click Continue button on Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAvailability() {
		reusableActions.getWhenReady(btnIgniteCheckAvailability, 30).click();
	}
	
	/**
	 * Click Activate Later button
	 * @author chinnarao.vattam
	 */
	public void clkActivateLater() {
		reusableActions.clickWhenReady(chkActivateLater, 30);
	}

	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkConfirmActivateLater() {
		reusableActions.clickWhenReady(btnActivateLater, 30);
		
	}

	/**
	 * To select the  Ignite TV Starter package on ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackage() {
		reusableActions.clickWhenReady(btnSolarisStarterPackage, 60);
	}
	
	/**
	 * To select the  Ignite TV Select package 
	 * @author chinnarao.vattam
	 */
	public void selectSolarisSelectPackage() {
		//reusableActions.scrollToElementAndClick(btnSolarisSelectPackage);
		reusableActions.getWhenReady(btnSolarisSelectPackage, 60).click();
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue, 60);
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkGoodNewsContinue() {
		reusableActions.clickWhenReady(btnGoodNewsContinue, 30);
	}
	
	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkNoThanksContinue() {
		reusableActions.clickWhenReady(btnNoThanksContinue, 60);
	}

	/**
	 * To verify the home phone options
	 * @return true if the phone popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyHomePhone() {
		reusableActions.waitForElementVisibility(btnHomePhoneContinue, 120);
		return	reusableActions.isElementVisible(btnHomePhoneContinue);
	}
	
	/**
	 * To verify the important information popup
	 * @return true if the information popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		reusableActions.waitForElementVisibility(popImportantInformation, 120);
		return	reusableActions.isElementVisible(popImportantInformation);
	}
	
	/**
	 * Click the I understand button on the important information popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand() {
		reusableActions.getWhenReady(btnIUnderstand, 120).click();
	}
		
	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhone() {
		reusableActions.getWhenReady(btnHomePhoneContinue, 120).click();
	}

	/**
	 * Click Keep My Number button on port-in page
	 * @author chinnarao.vattam
	 */
	public void clkKeepMyNumber() {
		reusableActions.getWhenReady(btnKeepMyNumber, 90).click();
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void set4KTV() {		
		reusableActions.getWhenReady(rdo4KTV, 120).click();
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTV() {
		reusableActions.waitForElementVisibility(rdo4KTV, 180);
		return	reusableActions.isElementVisible(rdo4KTV);
	}
	
	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,200);		
		reusableActions.getWhenReady(btnCheckout, 180);
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnCheckout, 180).click();
		reusableActions.waitForElementInvisibility(popupLoadingFingersciam,200);
	}
	
	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageNew() {
		reusableActions.clickWhenReady(btnSolarisStarterPackageNew, 90);
	}
	
	/**
	 * Click Starter package to check Service ability for Starter package
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageServiceability() {
		reusableActions.clickWhenReady(btnSolarisStarterPackageServiceability, 90);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTVSelection() {
		return	reusableActions.isElementVisible(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyOptNewPhone() {
		reusableActions.waitForElementVisibility(rdoOptNewPhone, 120);
		return	reusableActions.isElementVisible(rdoOptNewPhone);
	}
	
	/**
	 * Select the New Phone radio button
	 * @author chinnarao.vattam
	 */
	public void selectOptNewPhone() {
		reusableActions.getWhenReady(rdoOptNewPhone, 60).click();
		reusableActions.waitForElementVisibility(rdoOptNewPhoneEnable,60);		
	}

	/**
	 * Click the OptPhone button 
	 * @author chinnarao.vattam
	 */
	public void clickOptPhone() {
		reusableActions.clickWhenReady(btnOptPhone, 20);
	}
	
	public void clickChannels() {
		reusableActions.waitForElementVisibility(tabChannelsTab, 180);		
		reusableActions.moveToElementAndClick(tabChannelsTab, 180);
	}
	
	public void clickBundles() {
		reusableActions.waitForElementVisibility(tabBundles, 180);
		reusableActions.moveToElementAndClick(tabBundles, 180);
	}
	
	public void clickThemePacks() {
		reusableActions.clickWhenReady(tabThemePacksTab, 20);
	}
	
	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageRatecard() {		
		return reusableActions.isElementVisible(elmStarterRatecard);
	}
	
	/**
	 * Verify the Ignite TV Popular Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Popular Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageRatecard() {		
		return reusableActions.isElementVisible(elmPopularRatecard);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageRatecard() {		
		return reusableActions.isElementVisible(elmSelectRatecard);
	}
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageRatecard() {		
		return reusableActions.isElementVisible(elmPremierRatecard);
	}
	
	/**
	 * Verify the Ignite TV Starter Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageChannels() {		
		reusableActions.isElementVisible(txtStarterChannels);
		String strChannels = txtStarterChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("37 chaînes") || strChannels.equalsIgnoreCase("37 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Popular Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Popular Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageChannels() {		
		reusableActions.isElementVisible(txtPopularChannels);
		String strChannels = txtPopularChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("151 chaînes") || strChannels.equalsIgnoreCase("151 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Select Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageChannels() {		
		reusableActions.isElementVisible(txtSelectChannels);
		String strChannels = txtSelectChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("119 chaînes") || strChannels.equalsIgnoreCase("119 Channels"))
		return true;
		else 
	    return false;
	}
	
	/**
	 * Verify the Ignite TV Premier Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageChannels() {		
		reusableActions.isElementVisible(txtPremierChannels);
		String strChannels = txtPremierChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("192 chaînes") || strChannels.equalsIgnoreCase("192 Channels"))
		return true;
		else 
	    return false;
	}
}
