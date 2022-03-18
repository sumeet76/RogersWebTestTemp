package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class RogersIgniteTVBuyPage extends BasePageClass {

	public RogersIgniteTVBuyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//h4[contains(normalize-space(.),'Télé Élan Sélection') or contains(normalize-space(.),'Ignite TV Select')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.label.activateLater']")
	WebElement chkActivateLater;
	
	@FindBy(xpath ="//button[@class='ute-btn-secondary']//ins[@translate='global.cta.yes']")
	WebElement btnActivateLater;

	@FindBy(xpath ="//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Select']/ancestor::a")
	WebElement btnSolarisSelectPackage;

	@FindBy(xpath ="//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Popular']/ancestor::a")
	WebElement btnSolarisPopularPackage;

	@FindAll({
	@FindBy(xpath ="//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Starter']/ancestor::a"),
	@FindBy(xpath = "//a[@aria-label='Add Rogers Ignite Starter Bundle to cart']//span[text()='Add to cart']")})
	WebElement btnSolarisStarterPackage;

	@FindAll({
   @FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Premier']/ancestor::a"),
	@FindBy(xpath = "//a[@aria-label='Add Rogers Ignite Premier Bundle to cart']//span[text()='Add to cart']")})
	WebElement btnSolarisPremierPackage;

	@FindBy(xpath = "//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 5']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtFlex5PackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 10']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtFlex10PackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 20+']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtFlex20PackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Starter']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtStarterPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Premier']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtPremierPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Popular']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtPopularPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Select']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtSelectPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 5']/ancestor::a")
	WebElement btnFlex5Package;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 10']/ancestor::a")
	WebElement btnFlex10Package;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 20+']/ancestor::a")
	WebElement btnFlex20Package;

	@FindBy(id = "addressLookup-modal")
	WebElement txaIgniteAddressLookup;

	@FindBy(xpath = "//ins[@translate='global.cta.check']")
	WebElement btnIgniteAddressLookupSubmit;
	
	@FindBy(xpath = "//div[@class='check-availability-btn']//ins[@translate='global.cta.checkAvailability']")
	WebElement btnIgniteCheckAvailability;

	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//span[contains(text(),'HomePhone')]/parent::div")
	WebElement checkboxHomephone;

	@FindBy(xpath = "//h2[@id='channels-tab']")
	WebElement btnChannelsTab;

	@FindBy(xpath = "//h2[@id='themepacks-tab']")
	WebElement btnThemepacksTab;

	@FindBy(xpath = "//div[@translate='global.message.buyChannelsLater']")
	WebElement bnrPriceIncreaseChannelCopy;

	@FindBy(xpath = "//div[@translate='global.message.buyThemepacksLater']")
	WebElement bnrPriceIncreaseThemeCopy;

	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@translate='global.cta.continue']")
	WebElement btnGoodNewsContinue;

	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//ins[@translate='global.common.buttons.noThanksContinue']")
	WebElement btnNoThanksContinue;
	
	@FindBy(xpath = "//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForExistingNumber')]")
	WebElement btnKeepMyNumber;
	
	@FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::a")
	WebElement btnHomePhoneContinue;

	//@FindBy(xpath = "//h1[@class='cart-summary__header']")
	@FindBy(xpath ="//div/h1[@class='cart-summary__header']")
	WebElement txtCartSummary;

	@FindBy(xpath = "//ds-radio-button[@aria-label='Select Yes']//div[contains(@id,'ds-radio-input')]")
	WebElement rdo4KTV;

	@FindBy(xpath = "//ds-radio-button[@aria-label='Select No']//div[contains(@id,'ds-radio-input')]")
	WebElement rdo4KTVNo;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Total')]")
	WebElement txtTotalChannels;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Total')]/ancestor::li//div//button")
	WebElement btnViewTotalChannels;

	@FindBy(xpath = "//button[contains(@aria-label,'4')]//span[@class='ds-icon rds-icon-info']")
	WebElement hvr4kChannels;

	@FindBy(xpath = "//div[@class='ds-modal__header d-flex align-items-start']//span[@class='ds-icon rds-icon-close']")
	WebElement hvrClose;

	@FindBy(xpath = "//button[contains(@aria-label,'What are Flex Channels?')]//span[@class='ds-icon rds-icon-info']")
	WebElement hvrFelxChannels;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Flex')]")
	WebElement txtFlexChannels;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Flex')]/ancestor::li//div//button")
	WebElement btnViewFlexChannels;

	@FindBy(xpath = "//button[contains(@aria-label,'pre-selected')]//span[@class='ds-icon rds-icon-info']")
	WebElement hvrPreSelectedChannels;

	@FindBy(xpath = "//button[contains(@aria-label,'available')]//span[@class='ds-icon rds-icon-info']")
	WebElement hvrAvailableChannels;

	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtEmailContainer;

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//h1[@class='dsa-billboard__copyHeading mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtBundlesPage;

	@FindBy(xpath = "//span[@translate='global.modals.cartAbandonment.successModal.primaryButtonLabel']")
	WebElement btnOkay;

	@FindBy(xpath = "//button[@type='submit']//span[@translate='global.modals.cartAbandonment.triggerEmailModal.primaryButtonLabel']")
	WebElement btnSubmit;

	@FindBy(xpath = "//span[@translate='global.modals.cartAbandonment.triggerEmailModal.startOverButtonLabel']/ancestor::button")
	WebElement btnStartOver;

	@FindBy(xpath = "//div[@class='ds-checkbox__box my-12']")
	WebElement clkEmailCheckbox;

	@FindBy(xpath = "//span[@class='sr-only']/ancestor::a")
	WebElement clkContinue;

	@FindBy(xpath = "//h1[@translate='global.modals.cartAbandonment.triggerEmailModal.title']")
	WebElement popupEmailModal;

	@FindBy(xpath = "//a[@title='MyRogers' or @title='MonRogers' and @class='m-navLink ng-star-inserted']")
	WebElement lnkMyRogers;

	@FindBy(xpath = "//span[@translate='global.cta.cancel']/ancestor::span[@role='text']")
	WebElement btnCheckoutCancel;

	@FindBy(xpath = "//span[@translate='global.cta.checkout']/ancestor::span[@role='text']")
	WebElement btnCheckout;

	@FindBy(xpath ="//div[@class='mt-auto w-100']//button[@aria-label='Order Rogers Ignite Starter online now' or @aria-label='Commandez Élan Découverte maintenant'] ")
	WebElement btnSolarisStarterPackageServiceability;	

	@FindBy(xpath = "//h3[contains(text(),'Ignite Premier') or contains(text(),'Élan Premier')]/ancestor::div[@class='dsa-rate-card__plan p-24']//h4/span")
	WebElement txtTotalChannelsRateCardHead;

	@FindBy(xpath = "//h3[contains(text(),'Ignite Premier') or contains(text(),'Élan Premier')]/ancestor::div[@class='dsa-rate-card__plan p-24']//h4[@class='bundle-tile__tv-channels__flex inline-block']")
	WebElement txtFlexChannelsRateCardHead;

	@FindAll({
			@FindBy(xpath = "//button[@aria-label='View more details about the Rogers Ignite Premier Bundle']"),
			@FindBy(xpath ="//button[@aria-label='Hide more details about the Rogers Ignite Premier Bundle']")})
	WebElement txtFlexChannelsRateCardExpansion;

	@FindBy(xpath = "//h3[contains(text(),'Ignite Premier') or contains(text(),'Élan Premier')]/ancestor::div[@class='dsa-rate-card ds-shadow ds-corners ds-no-overflow']//span[@translate='global.label.totalChannels']")
	WebElement txtTotalChannelsRateCardDetails;

	@FindBy(xpath = "//h3[contains(text(),'Ignite Premier') or contains(text(),'Élan Premier')]/ancestor::div[@class='dsa-rate-card ds-shadow ds-corners ds-no-overflow']//span[contains(text(),'Flex')]")
	WebElement txtFlexChannelsRateCardDetails;

	@FindBy(xpath ="//h3[contains(text(),'Ignite Starter') or contains(text(),'Élan Découverte')]/ancestor::div[@class='bundle-tile-row']//span[@translate='global.cta.addToCart']")
	WebElement btnSolarisStarterPackageMobile;	
	
	@FindBy(xpath = "(//div[@aria-label='$134.99 per m'])[2]")
	WebElement txtPackageCost;	
	
	@FindBy(xpath = "//p[@id='ds-modal-title-1']")
	WebElement popImportantInformation;
	   
	@FindBy(xpath = "//span[contains(text(),' Yes, I understand') or contains(text(),'comprends')]/ancestor::span")
	WebElement btnIUnderstand;

	@FindBy(xpath ="//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForNewNumber')]")
	WebElement rdoOptNewPhone;

	@FindBy(xpath ="//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForExistingNumber')]")
	WebElement rdoOptNewPhoneEnable;
	
	@FindBy(xpath ="//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
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

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;

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
	
	@FindBy(xpath = "//button[contains(@class,'stb-button increment')]//span[@class='ds-button__wrapper d-flex justify-content-center align-items-center']")
	WebElement buttonAddIgniteTVBoxes;

	@FindBy(xpath = "//span[@translate='global.cta.updateCart']/ancestor::button")
	WebElement buttonUpdateCart;
	
	@FindBy(xpath = "//ds-modal-container[contains(@id,'ds-modal-container')]")
	WebElement modalUpgradingToIgnitebundels;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement okayUpgradingToIgnitebundelsModal;
	
	@FindBy(xpath = "//span[contains(@class,'ds-icon rds-icon-chevron-down')]")
	WebElement downChevronCartSummary;
	
	@FindBy(xpath = "//span[contains(@class,'ds-icon rds-icon-chevron-up')]")
	WebElement upChevronCartSummary;
	
	@FindBy(xpath = "//div[contains(@class,'mini-cart-ss__body')]//tr[contains(@class,'cms-promotions-gwp ng-tns-c')]")
	WebElement gwpYourCart;
	
	@FindBy(xpath ="//input[contains(@id,'messageForExistingNumber')]//following-sibling::label")
	WebElement rdoKeepExistingPhoneNumber;

	@FindBy(xpath="//button[@class='ds-modal__closeButton ds-button ds-corners ds-pointer text-center mw-100 -icon d-inline-flex justify-content-center align-items-center -large ng-star-inserted']/span")
	WebElement btnClosePopupModal;

	@FindBy(xpath = "//rch-popup-modal[@class='ng-star-inserted']/div[@class='popup-modal-component']")
	WebElement divPopupContainer;

	@FindBy(xpath = "//button[contains(@class,'ds-modal__closeButton')]/span")
	WebElement btnClosePopUp;

	/**
	 * Click Starter package button for anonymous customer
	 * @param	bundleName : name of the bundle package
	 * @author Saurav.Goyal
	 */
	public void selectSolarisBundlePackage(String bundleName) {
		String xpathBundlePackage="//div[@class='mt-auto w-100']//button[contains(@aria-label,'"+ bundleName +"')]//span[@translate='global.cta.addToCart']";
		getReusableActionsInstance().clickWhenReady(By.xpath(xpathBundlePackage), 120);
	}
	
	/**
	 * To click on the chevron of your cart
	 * @author chinnarao.vattam
	 */
	public void clkChevronDownYourCart() {
		getReusableActionsInstance().waitForElementVisibility(downChevronCartSummary, 120);
		getReusableActionsInstance().clickWhenReady(downChevronCartSummary, 120);
	}


	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkHomephone() {
		getReusableActionsInstance().getWhenReady(checkboxHomephone, 60).click();
	}
	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkHomephoneMobile() {
		getReusableActionsInstance().waitForElementVisibility(checkboxHomephone, 60);
		getReusableActionsInstance().executeJavaScriptClick(checkboxHomephone);
	}

	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkChannelsTab() {
		getReusableActionsInstance().getWhenReady(btnChannelsTab, 60).click();
	}

	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkThemepacksTab() {
		getReusableActionsInstance().getWhenReady(btnThemepacksTab, 60).click();
	}
	/**
	 * To verify Price Increase Channel Copy banner
	 * @return true if the Price Increase Channel Copy banner is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPriceIncreaseChannelCopy() {
		getReusableActionsInstance().waitForElementVisibility(bnrPriceIncreaseChannelCopy, 120);
		return	getReusableActionsInstance().isElementVisible(bnrPriceIncreaseChannelCopy);
	}
	/**
	 * To verify Price Increase Theme Copy banner
	 * @return true if the Price Increase Theme Copy banner is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPriceIncreaseThemeCopy() {
		getReusableActionsInstance().waitForElementVisibility(bnrPriceIncreaseThemeCopy, 120);
		return	getReusableActionsInstance().isElementVisible(bnrPriceIncreaseThemeCopy);
	}
	/**
	 * To click on the chevron of your cart
	 * @author Chinnarao.vattam
	 */
	public void clkChevronUpYourCart() {
		getReusableActionsInstance().getWhenReady(upChevronCartSummary, 120).click();
	}
	
	/**
	 * To verify gwp promotion in the cart summary
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
			getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
			return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}

	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPage() {
		getReusableActionsInstance().waitForElementVisibility(txtBundlesPage, 120);
		return	getReusableActionsInstance().isElementVisible(txtBundlesPage);
	}

	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPageMobile() {
		getReusableActionsInstance().waitForElementVisibility(txtBundlesPage, 120);
		return	getReusableActionsInstance().isElementVisible(txtBundlesPage);
	}
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @param	bundleName : name of the bundle package
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPForStarterPackage(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[contains(@class,'d-flex')]/preceding-sibling::section//p";
		return	getReusableActionsInstance().isElementVisible(By.xpath(xpathBundlePackage), 120);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		getReusableActionsInstance().staticWait(120000);
		return getReusableActionsInstance().isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinueSession() {
		getReusableActionsInstance().getWhenReady(btnContinueSession, 20).click();
	}

	/**
	 * To click on the chevron of the starter bundel package
	 * @param	bundleName : name of the bundle package
	 * @author Saurav.Goyal
	 */
	public void clkChevronSolarisStarterPackageNew(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']";
		getReusableActionsInstance().getWhenReady(By.xpath(xpathBundlePackage), 120).click();
	}
	
	/**
	 * To click on the chevron of any given bundle package
	 * @param	bundleName : give the name of the bundle as parameter
	 * @author Saurav.Goyal
	 */
	public void clkChevronForBundle(String bundleName) {
		String bundleXpath = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']";
		getReusableActionsInstance().getWhenReady(By.xpath(bundleXpath), 120).click();
	}
	
	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyUpgradingToIgnitebundelsModal() {
			getReusableActionsInstance().waitForElementVisibility(modalUpgradingToIgnitebundels, 120);
			return	getReusableActionsInstance().isElementVisible(modalUpgradingToIgnitebundels);
	}
	
	/**
	 * To click okay on the modal Upgrading To Ignite bundels
	 * @author Saurav.Goyal
	 */
	public void clkOkayUpgradingToIgnitebundelsModal() {
		getReusableActionsInstance().getWhenReady(okayUpgradingToIgnitebundelsModal, 120).click();
	}
	
	
	/**
	 * Click keep my existing phone number radio button
	 * @author Saurav.Goyal
	 */
	public void clkRadioOptKeepMyExistingPhoneNumber() {
		getReusableActionsInstance().getWhenReady(rdoKeepExistingPhoneNumber, 60).click();
	}
	
	/**
	 * Click + to add STB ignite TV boxes
	 * @author Saurav.Goyal
	 */
	public void clkPlusAddIgniteTVBoxes() {
		getReusableActionsInstance().waitForElementVisibility(buttonAddIgniteTVBoxes, 90);
		getReusableActionsInstance().executeJavaScriptClick(buttonAddIgniteTVBoxes);
	}
	
	/**
	 * To Click Update cart button
	 * @author Saurav.Goyal
	 */
	public void clkUpdateCart() {
		getReusableActionsInstance().getWhenReady(buttonUpdateCart, 90).click();
	}
	
	/**
	 * Verify visibility of upgrade now button
	 * @return	boolean true if the element is present else false
	 * @author Saurav.Goyal 
	 */
	public boolean verifyButtonUpgradeNow() {		
		getReusableActionsInstance().waitForElementVisibility(buttonUpgradeNow, 120);
		return	getReusableActionsInstance().isElementVisible(buttonUpgradeNow);
	}
	
	/**
	 * click upgrade now button
	 * @author Saurav.Goyal 
	 */
	public void clkButtonUpgradeNow() {		
		getReusableActionsInstance().getWhenReady(buttonUpgradeNow, 120).click();
	}

	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @param strAddress address to check the service availability 
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookup(String strAddress) {
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).clear();
		getReusableActionsInstance().getWhenReady(txaIgniteAddressLookup, 3).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txaIgniteAddressLookup).sendKeys(Keys.ENTER);
	}

	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnIgniteAddressLookupSubmit, 30).click();
	}
	
	/**
	 * Click Continue button on Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkIgniteAvailability() {
		getReusableActionsInstance().getWhenReady(btnIgniteCheckAvailability, 30).click();
	}
	
	/**
	 * Click Activate Later button
	 * @author chinnarao.vattam
	 */
	public void clkActivateLater() {
		getReusableActionsInstance().clickWhenReady(chkActivateLater, 30);
	}

	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkConfirmActivateLater() {
		getReusableActionsInstance().clickWhenReady(btnActivateLater, 30);
		
	}
	/**
	 * To select the  Ignite TV Select package 
	 * @author chinnarao.vattam
	 */
	public void selectSolarisSelectPackage() {
		//getReusableActionsInstance().scrollToElementAndClick(btnSolarisSelectPackage);
		getReusableActionsInstance().getWhenReady(btnSolarisSelectPackage, 60).click();
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenReady(btnContinue, 60);
	}
	
	/**
	 * Click Continue on the  Good news popup
	 * @author chinnarao.vattam
	 */
	public void clkGoodNewsContinue() {
		getReusableActionsInstance().clickWhenReady(btnGoodNewsContinue, 30);
	}
	
	/**
	 * Click No thanks, continue button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkNoThanksContinue() {
		getReusableActionsInstance().clickWhenReady(btnNoThanksContinue, 60);
	}

	/**
	 * To verify the home phone options
	 * @return true if the phone popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyHomePhone() {
		getReusableActionsInstance().waitForElementVisibility(btnHomePhoneContinue, 60);
		return	getReusableActionsInstance().isElementVisible(btnHomePhoneContinue);
	}
	
	/**
	 * To verify the important information popup
	 * @return true if the information popup has launched, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		getReusableActionsInstance().waitForElementVisibility(popImportantInformation, 60);
		return	getReusableActionsInstance().isElementVisible(popImportantInformation);
	}
	
	/**
	 * Click the I understand button on the important information popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand() {
		getReusableActionsInstance().getWhenReady(btnIUnderstand, 60).click();
	}
		
	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhone() {
		getReusableActionsInstance().waitForElementVisibility(btnHomePhoneContinue, 30);
		getReusableActionsInstance().getWhenReady(btnHomePhoneContinue, 10).click();
	}

	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhoneMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnHomePhoneContinue, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnHomePhoneContinue);
	}
	/**
	 * Click Keep My Number button on port-in page
	 * @author chinnarao.vattam
	 */
	public void clkKeepMyNumber() {
		getReusableActionsInstance().getWhenReady(btnKeepMyNumber, 90).click();
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void set4KTV() {	
		getReusableActionsInstance().getWhenReady(rdo4KTV, 120);
		getReusableActionsInstance().scrollToElement(rdo4KTV);
		getReusableActionsInstance().getWhenReady(rdo4KTV,30).click();
		//getReusableActionsInstance().executeJavaScriptClick(rdo4KTV);
	}
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author dharani.up
	 */
	public void set4KTVNo() {
		getReusableActionsInstance().getWhenReady(rdo4KTVNo, 120);
		getReusableActionsInstance().scrollToElement(rdo4KTVNo);
		getReusableActionsInstance().getWhenReady(rdo4KTVNo,30).click();
		//getReusableActionsInstance().executeJavaScriptClick(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void set4KTVMobile() {		
		getReusableActionsInstance().executeJavaScriptClick(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTV() {
		getReusableActionsInstance().waitForElementVisibility(txtCartSummary,120);
		return	getReusableActionsInstance().isElementVisible(txtCartSummary,90);
	}
	
	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		getReusableActionsInstance().getWhenReady(btnCheckout, 20).click();
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
	}

	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckoutCancel() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		getReusableActionsInstance().getWhenReady(btnCheckoutCancel, 20).click();
	}

	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckoutMobile() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		getReusableActionsInstance().executeJavaScriptClick(btnCheckout);
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackage() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisStarterPackage, 120);
		getReusableActionsInstance().getWhenReady(btnSolarisStarterPackage, 60).click();
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisPremierPackage() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisPremierPackage, 120);
		getReusableActionsInstance().getWhenReady(btnSolarisPremierPackage, 60).click();
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisPremier() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisPremierPackage, 30);
		getReusableActionsInstance().executeJavaScriptClick(btnSolarisPremierPackage);
	}
	/**
	 * To verify Total Channel
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelAtRateCard() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisPremierPackage, 120);
		String strChannels=getReusableActionsInstance().getWhenReady(txtTotalChannelsRateCardHead, 50).getText();
		String[] channels = strChannels.split("\\s+");
		getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardExpansion,30).click();
		String strDetailChannels=getReusableActionsInstance().getWhenReady(txtTotalChannelsRateCardDetails, 50).getText();
		String[] detailChannels = strDetailChannels.split("\\s+");
		String detailChannelsValue=detailChannels[0];
		return channels[0].equals(detailChannelsValue);
	}

	/**
	 * To verify Flex Channel
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlexChannelAtRateCard() {
		String strFlexChannels=getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardHead, 50).getText();
		String[] flexChannels = strFlexChannels.split("\\s+");
		String strDetailFlexChannels=getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardDetails, 50).getText();
		String[] detailFlexChannels = strDetailFlexChannels.split("\\s+");
		String strFlexChannelsValue =detailFlexChannels[0];
		getReusableActionsInstance().executeJavaScriptClick(txtFlexChannelsRateCardExpansion);
		return flexChannels[0].equals(strFlexChannelsValue);
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisStarterPackage, 120);
		getReusableActionsInstance().executeJavaScriptClick(btnSolarisStarterPackage);
		//getReusableActionsInstance().getWhenReady(btnSolarisStarterPackageMobile, 60).click();
	}

	/**
	 * Click Starter package to check Service ability for Starter package
	 * @author chinnarao.vattam
	 */
	public void selectSolarisStarterPackageServiceability() {
		getReusableActionsInstance().clickWhenReady(btnSolarisStarterPackageServiceability, 90);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verify4KTVSelection() {
		return	getReusableActionsInstance().isElementVisible(rdo4KTV);
	}
	
	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyOptNewPhone() {
		getReusableActionsInstance().waitForElementVisibility(rdoOptNewPhone, 120);
		return	getReusableActionsInstance().isElementVisible(rdoOptNewPhone);
	}
	
	/**
	 * Select the New Phone radio button
	 * @author chinnarao.vattam
	 */
	public void selectOptNewPhone() {
		getReusableActionsInstance().getWhenReady(rdoOptNewPhone, 60).click();
		getReusableActionsInstance().waitForElementVisibility(rdoOptNewPhoneEnable,60);
	}

	/**
	 * Click the OptPhone button 
	 * @author chinnarao.vattam
	 */
	public void clickOptPhone() {
		getReusableActionsInstance().clickWhenReady(btnOptPhone, 120);
	}

	/**
	 * Click the Channels button
	 * @author chinnarao.vattam
	 */
	public void clickChannels() {
		getReusableActionsInstance().waitForElementVisibility(tabChannelsTab, 90);
		getReusableActionsInstance().moveToElementAndClick(tabChannelsTab, 90);
	}

	/**
	 * Click the Bundles button
	 * @author chinnarao.vattam
	 */
	public void clickBundles() {
		getReusableActionsInstance().waitForElementVisibility(tabBundles, 90);
		getReusableActionsInstance().moveToElementAndClick(tabBundles, 30);
	}

	/**
	 * To set the Lookup address on the service availability  Lookup popup
	 * @author chinnarao.vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtEmailContainer,60);
		getReusableActionsInstance().getWhenReady(txtEmailContainer,30).click();
		getReusableActionsInstance().clickWhenReady(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(strEmail);
	}

	/**
	 * Click the Okay button
	 * @author chinnarao.vattam
	 */
	public void clickOkay() {
		getReusableActionsInstance().getWhenReady(btnOkay, 60).click();
	}

	/**
	 * Click the Submit button
	 * @author chinnarao.vattam
	 */

	public void clickSubmit() {
		getReusableActionsInstance().clickWhenReady(btnSubmit, 20);
	}

	/**
	 * Click the StartOver button
	 * @author chinnarao.vattam
	 */

	public void clickStartOver() {
		getReusableActionsInstance().clickWhenReady(btnStartOver, 20);
	}


	/**
	 * Click the Email Checkbox
	 * @author chinnarao.vattam
	 */
	public void clickEmailCheckbox() {
		getReusableActionsInstance().clickWhenReady(clkEmailCheckbox, 20);
	}

	/**
	 * Click the Continue button
	 * @author chinnarao.vattam
	 */
	public void clickContinue() {
		getReusableActionsInstance().clickWhenReady(clkContinue, 20);
	}

	/**
	 * Verify the Welcome back Popup
	 * @return true if Welcome back Popup  display when we back to bundle buy, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyWelcomeBackPopup() {
		return getReusableActionsInstance().isElementVisible(clkContinue,30);
	}

	/**
	 * Verify the Email Modal
	 * @return true if Email Modal display the abondone action, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyEmailModal() {
		return getReusableActionsInstance().isElementVisible(popupEmailModal,30);
	}

	/**
	 * Verify the Confirmation Modal
	 * @return true if Email Modal display the abondone action, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyConfirmation() {
		return getReusableActionsInstance().isElementVisible(btnOkay,30);
	}

	/**
	 * Click the MyRogers link
	 * @author chinnarao.vattam
	 */
	public void clickMyRogers() {
		getReusableActionsInstance().clickWhenReady(lnkMyRogers, 20);
	}
	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageRatecard() {		
		return getReusableActionsInstance().isElementVisible(elmStarterRatecard);
	}
	
	/**
	 * Verify the Ignite TV Popular Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Popular Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageRatecard() {		
		return getReusableActionsInstance().isElementVisible(elmPopularRatecard);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageRatecard() {		
		return getReusableActionsInstance().isElementVisible(elmSelectRatecard);
	}
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageRatecard() {		
		return getReusableActionsInstance().isElementVisible(elmPremierRatecard);
	}
	
	/**
	 * Verify the Ignite TV Starter Package Channels on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package Channels, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageChannels() {		
		getReusableActionsInstance().isElementVisible(txtStarterChannels);
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
		getReusableActionsInstance().isElementVisible(txtPopularChannels);
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
		getReusableActionsInstance().isElementVisible(txtSelectChannels);
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
		getReusableActionsInstance().isElementVisible(txtPremierChannels);
		String strChannels = txtPremierChannels.getText().trim();
		if (strChannels.equalsIgnoreCase("192 chaînes") || strChannels.equalsIgnoreCase("192 Channels"))
		return true;
		else 
	    return false;
	}

	/**
	 * To verify Exchange FlexChanne link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlexChannelCount(String strFlexChannels) {
		// 0, 5, 44 channels
		String strChannels=getReusableActionsInstance().getWhenReady(txtFlexChannels, 50).getText();
		String[] channels = strChannels.split("\\s+");
		return channels[0].equals(strFlexChannels);
	}


	/**
	 * To verify Exchange Total Channel link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyTotalChannelCount(String strTotalChannels) {
		// 0, 5, 44 channels
		String strChannels=getReusableActionsInstance().getWhenReady(txtTotalChannels, 50).getText();
		String[] channels = strChannels.split("\\s+");
		return channels[0].equals(strTotalChannels);
	}

	/**
	 * Click the View Total Channels button
	 * @author chinnarao.vattam
	 */
	public void clkViewTotalChannels() {
		getReusableActionsInstance().getWhenReady(btnViewTotalChannels, 60).click();
	}

	/**
	 * Click the View Flex Channels button
	 * @author chinnarao.vattam
	 */
	public void clkViewFlexChannels() {
		getReusableActionsInstance().getWhenReady(btnViewFlexChannels, 60).click();
	}

	/**
	 * Click the Close button
	 * @author chinnarao.vattam
	 */
	public void clkHoverClose() {
		getReusableActionsInstance().getWhenReady(hvrClose, 20);
		getReusableActionsInstance().executeJavaScriptClick(hvrClose);
	}

	/**
	 * Click the View Flex Channels button
	 * @author chinnarao.vattam
	 */
	public void clkHover4kChannels() {
		getReusableActionsInstance().getWhenReady(hvr4kChannels, 60).click();
	}


	/**
	 * Click the View Flex Channels button
	 * @author chinnarao.vattam
	 */
	public void clkHoverFelxChannels() {
		getReusableActionsInstance().getWhenReady(hvrFelxChannels, 60).click();
	}

	/**
	 * Click the View Flex Channels button
	 * @author chinnarao.vattam
	 */
	public void clkHoverPreSelectedChannels() {
		getReusableActionsInstance().getWhenReady(hvrPreSelectedChannels, 60).click();
	}

	/**
	 * Click the View Flex Channels button
	 * @author chinnarao.vattam
	 */
	public void clkHoverAvailableChannels() {
		getReusableActionsInstance().getWhenReady(hvrAvailableChannels, 60).click();
	}

	/**
	 * To verify Select Package Cost
	 * @return true if the Select Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifySelectPackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtSelectPackageCost,10);
	}

	/**
	 * To verify Popular Package Cost
	 * @return true if the Popular Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtPopularPackageCost,10);
	}

	/**
	 * To verify Premier Package Cost
	 * @return true if the Premier Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtPremierPackageCost,10);
	}

	/**
	 * To verify Starter Package Cost
	 * @return true if the Starter Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtStarterPackageCost,10);
	}

	/**
	 * To verify Flex20 Package Cost
	 * @return true if the Flex20 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex20PackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtFlex20PackageCost,10);
	}

	/**
	 * To verify Flex10 Package Cost
	 * @return true if the Flex10 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex10PackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtFlex10PackageCost,10);
	}

	/**
	 * To verify Flex5 Package Cost
	 * @return true if the Flex5 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex5PackageCost() {
		return	getReusableActionsInstance().isElementVisible(txtFlex5PackageCost,30);
	}

	/**
	 * To Click on Close Window Button
	 * @author Shubhangi.Verma
	 */
	public void clkClosePopUp(){
		getReusableActionsInstance().clickWhenReady(btnClosePopUp,30);
	}
	/**
	 * @return true if popup container available else return false
	 * @author Shubhangi.Verma
	 */
	public boolean verifyPopupModal() {
		return getReusableActionsInstance().isElementVisible(divPopupContainer,30);
	}
	/**
	 * To close on PopUp
	 * @author Shubhangi.Verma
	 */
	public void clickClosePopupModal() {
		getReusableActionsInstance().getWhenReady(btnClosePopupModal,30).click();
	}




}
