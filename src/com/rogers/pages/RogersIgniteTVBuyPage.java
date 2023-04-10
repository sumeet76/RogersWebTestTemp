package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.FormFiller;

import java.util.List;

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

	//a[@aria-label='Ignite Flex 5 Add to cart']//span[text()='Add to cart']
	@FindBy(xpath = "//a[@aria-label='Ignite Starter Add to cart']//span[text()='Add to cart']")
	WebElement btnSolarisStarterPackage;

	@FindBy(xpath = "//a[@aria-label='Ignite Premier Add to cart']/span")
	WebElement btnSolarisPremierPackage;

	@FindBy(xpath= "//h3[contains(text(),'Ignite Premier') or contains(text(),'Élan Premier')]")
	WebElement headerIgnitePremier;

	@FindBy(xpath="//button//ds-icon[@name='right']")
	WebElement scrollHorizontalToChoosePlan;

	@FindBy(xpath="//h3[text()='Ignite Starter']")
	WebElement headerIgniteStarter;

	@FindBy(xpath = "//button[contains(@aria-label,'Take the quiz')]/span[@role='text']")
	WebElement btnTakeQuiz;

	@FindBy(xpath = "//label[@for='dsQ1A1']/span")
	WebElement btnLiveTVChannels;

	@FindBy(xpath = "//label[@for='dsQ1A2']/span")
	WebElement btnLiveSports;

	@FindBy(xpath = "//label[@for='dsQ1A3']/span")
	WebElement btnFlexibleChannels;

	@FindBy(xpath = "//label[@for='dsQ1A4']/span")
	WebElement btnMobileApp;

	@FindBy(xpath = "//button[contains(@aria-label,'Continue')]/span")
	WebElement btnDSTcontinue;

	@FindBy(xpath = "//ds-icon[@title='Rate network category 4 stars']/span")
	WebElement imgRateNetworkCategoryFour;

	@FindBy(xpath = "//ds-icon[@title='Rate news category 4 stars']/span")
	WebElement imgRateNewsCategoryFour;

	@FindBy(xpath = "//ds-icon[@title='Rate entertainment category 4 stars']/span")
	WebElement imgRateEntertainmentCategoryFour;

	@FindBy(xpath = "//ds-icon[@title='Rate lifestyle category 4 stars']/span")
	WebElement imgRateLifestyleCategoryFour;

	@FindBy(xpath = "//input[@aria-label='Select 6 to 11']/parent::label/span")
	WebElement btnInternetDevices;

	@FindBy(xpath="//input[@aria-label='Yes, add Ignite Home Phone for an additional $10/mo']/parent::label/span")
	WebElement btnAddHomePhoneDST;

	@FindBy(xpath= "//span[contains(text(),'BEST FIT')]")
	WebElement txtBestFit;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement btnDSTClose;

	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']")
	WebElement VerifyYourBestFit;

	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']/ancestor::div[@class='vertical-tile-component']/descendant::a[@aria-label='Ignite Flex 10 Add to cart']/span/span")
	WebElement btnBestAdd;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 5 Add to cart']/ancestor::div[@class='vertical-tile-component']//span[text()='/mo*']")
	WebElement txtFlex5PackageCost;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 10 Add to cart']/ancestor::div[@class='vertical-tile-component']//span[text()='/mo*']")
	WebElement txtFlex10PackageCost;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']//span[text()='/mo*']")
	WebElement txtFlex20PackageCost;

	@FindBy(xpath = "//a[@aria-label='Ignite Starter Add to cart']/ancestor::div[@class='vertical-tile-component']//span[text()='/mo*']")
	WebElement txtStarterPackageCost;

	@FindBy(xpath = "//a[@aria-label='Ignite Premier Add to cart']/ancestor::div[@class='vertical-tile-component']//span[text()='/mo*']")
	WebElement txtPremierPackageCost;

	@FindBy(xpath = "//a[@aria-label='Add Rogers Ignite Premier Bundle to cart']")
	WebElement txtPremierPackage;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Popular']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtPopularPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-row']//span[@id='ariaBundlesAddToCart_Rogers Ignite Select']/ancestor::div[@class='bundle-tile-price']//span[text()='/mo*']")
	WebElement txtSelectPackageCost;

	@FindBy(xpath = "//div[@class='bundle-tile-price']//span[@id='ariaBundlesAddToCart_Rogers Ignite Flex 5']/ancestor::a")
	WebElement btnFlex5Package;

	@FindAll({
			@FindBy(xpath="//a[contains(@aria-label,'Ignite Flex 10 Add to cart')]//span[text()='Order online']"),
			@FindBy(xpath = "//a[@aria-label='Ignite Flex 10 Add to cart']/span/span")
	})
	WebElement btnFlex10Package;


	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/span/span")
	WebElement btnFlex20Package;

	@FindBy(xpath = "//td[contains(@class,'second-child')]//div[@class='ds-price -inline']")
	WebElement divBundleCostInline;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 5 Add to cart']/ancestor::div[@class='vertical-tile-component']//div[@class='ds-price']")
	WebElement divBundleCost;

	@FindBy(id = "addressLookup-modal")
	WebElement txaIgniteAddressLookup;

	@FindBy(xpath = "//ins[@translate='global.cta.check']")
	WebElement btnIgniteAddressLookupSubmit;

	@FindBy(xpath = "//div[@class='check-availability-btn']//ins[@translate='global.cta.checkAvailability']")
	WebElement btnIgniteCheckAvailability;

	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//div[@class='rhp-section']/descendant::label")
	WebElement checkboxHomephone;

	@FindBy(xpath = "//h2[@id='channels-tab'] | //button[@id='channels-tab']")
	WebElement btnChannelsTab;

	@FindBy(xpath = "//h2[@id='themepacks-tab'] | //button[@id='themepacks-tab']")
	WebElement btnThemepacksTab;

	@FindBy(xpath = "//div[@translate='global.message.buyChannelsLater']")
	WebElement bnrPriceIncreaseChannelCopy;

	@FindBy(xpath = "//div[@class='alert-box__copy']")
	WebElement bnrAlertCopy;

	@FindBy(xpath="//h2[@translate='global.modals.flexChannelsModal.preSelectedFlexChannelsHeader']")
	WebElement txtPreselectedFlexChannels;

	@FindBy(xpath = "//div[@translate='global.message.buyThemepacksLater']")
	WebElement bnrPriceIncreaseThemeCopy;

	@FindBy(xpath="//h2[text()='Your bundle comes with:']")
	WebElement headerBundlesChannelsAndThemepacks;

	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@translate='global.cta.continue']")
	WebElement btnGoodNewsContinue;

	@FindBy(xpath = "//div[@class='buttons-block hidden-xs']//ins[@translate='global.common.buttons.noThanksContinue']")
	WebElement btnNoThanksContinue;

	@FindBy(xpath = "//label[contains(@for,'global.modals.activateIgniteHomePhoneModal.messageForExistingNumber')]")
	WebElement btnKeepMyNumber;

	@FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::a")
	WebElement btnHomePhoneContinue;

	@FindBy(xpath = "//a[@aria-label='Press here to continue with this number']/span[@role='text']")
	WebElement btnHomePhoneAddOnContinue;

	@FindBy(xpath = "//a[@aria-label='Click here to continue to the next step']/span")
	WebElement btnReviewCallerInfoContinue;

	@FindBy(xpath = "//h1[@translate='global.rhpAddOns.homePhoneAddons']")
	WebElement headerHomePageAddOn;

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

	@FindBy(xpath = "//button[contains(@aria-label,'4')]//span[@class='ds-icon d-inline-flex rds-icon-info']")
	WebElement hvr4kChannels;

	@FindBy(xpath = "//div[@class='ds-modal__header d-flex align-items-start']//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement hvrClose;

	@FindBy(xpath = "//button[contains(@aria-label,'What are Flex Channels?')]//span")
	WebElement hvrFelxChannels;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Flex')]")
	WebElement txtFlexChannels;

	@FindBy(xpath = "//div[@class='mr-8 d-inline-block' and contains(text(),'Flex')]/ancestor::li//div//button")
	WebElement btnViewFlexChannels;

	@FindBy(xpath = "//button[contains(@aria-label,'pre-selected') or contains(@aria-label,'présélectionnée')]//span")
	WebElement hvrPreSelectedChannels;

	@FindBy(xpath = "//button[contains(@aria-label,'available')]//span[@class='ds-icon rds-icon-info']")
	WebElement hvrAvailableChannels;

	@FindBy(xpath = "//input[@formcontrolname='firstName']/..")
	WebElement txtFirstNameContainer;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']/..")
	WebElement txtLastNameContainer;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@formcontrolname='mobile']/..")
	WebElement btnPhoneContainer;

	@FindBy(xpath = "//input[@formcontrolname='mobile']")
	WebElement btnPhone;

	@FindBy(xpath = "//input[@type='email']/..")
	WebElement txtEmailContainer;

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//h1[@class='dsa-hero-billboard__headingH1 mb-16 mb-md-24 ng-star-inserted']")
	WebElement txtBundlesPage;

	@FindBy(xpath = "//h2[@translate='global.label.ourBundles']")
	WebElement txtOffersPage;

	@FindBy(xpath = "//a[@aria-label='Ignite Premier Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnPremierTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Ignite Starter Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnStarterPackageTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnFlex20PackageTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 10 Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnFlex10PackageTypeOfContract;

	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']/parent::div/following-sibling::div/descendant::select[@aria-label='Open list of internet speeds and select one']")
	WebElement drpdwnRecommendedPkgInternetSpeed;

	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']/parent::div/following-sibling::div/descendant::a[contains(@aria-label,'View more details')]")
	WebElement lnkRecommendedPkgViewMoreDetails;

	@FindBy(xpath = "//button[@aria-label='Okay, close this window']/span")
	WebElement btnOkay;

	@FindBy(xpath = "//button[@aria-label='Submit this form']/span")
	WebElement btnSubmit;

	@FindBy(xpath = "//button[@aria-label='Cancel this form']/span")
	WebElement btnStartOver;

	@FindBy(xpath = "//div[contains(@class,'ds-checkbox__box my-12')]")
	WebElement clkEmailCheckbox;

	@FindBy(xpath = "//a[@aria-label='Continue to my cart']/span")
	WebElement clkContinue;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane ds-modalWindow']")
	WebElement popupEmailModal;

	@FindBy(xpath = "//a[@title='MyRogers' or @title='MonRogers' and @class='m-navLink ng-star-inserted']")
	WebElement lnkMyRogers;

	@FindBy(xpath = "//span[@translate='global.cta.cancel']/ancestor::span[@role='text']")
	WebElement btnCheckoutCancel;

	@FindBy(xpath = "//span[@translate='global.cta.checkout']/ancestor::span[@role='text']")
	WebElement btnCheckout;

	@FindBy(xpath ="//div[@class='mt-auto w-100']//button[@aria-label='Order Rogers Ignite Starter online now' or @aria-label='Commandez Élan Découverte maintenant'] ")
	WebElement btnSolarisStarterPackageServiceability;

	@FindBy(xpath = "//button[@aria-label='See all channels included in the Ignite Premier Bundle']//span[@class ='price-details__count']")
	WebElement txtTotalChannelsRateCardHead;

	@FindBy(xpath = "//button[@aria-label='See all flex channels included in the Ignite Premier Bundle']//span[@class ='price-details__count']")
	WebElement txtFlexChannelsRateCardHead;

    /* @FindAll({
            @FindBy(xpath = "//a[@aria-label='Ignite Premier View more details']//span[@role='text']"),
            @FindBy(xpath ="//button[@aria-label='Hide more details about the Rogers Ignite Premier']")})
    WebElement txtFlexChannelsRateCardExpansion; */

	@FindBy(xpath = "//a[@aria-label='Ignite Premier View more details']//span[@role='text']")
	WebElement txtFlexChannelsRateCardExpansion;

	@FindBy(xpath = "//span[@translate='global.label.totalChannels']")
	WebElement txtTotalChannelsRateCardDetails;

	@FindBy(xpath = "//span[@class='genre-dropdown-component']/descendant::select")
	WebElement drpdwnGenre;

	@FindBy(xpath = "//div[@class='tile-see-full-details-modal']")
	WebElement divViewMoreDetailsPopup;

	@FindBy(xpath = "//button[@aria-label='Enter your address to check package prices and offers now.']/span")
	WebElement btnEnterAddress;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::button[contains(@aria-label,'See all channels')]//span[@class='price-details__label']")
	WebElement btnTotalChannelsFlex20;

	@FindBy(xpath = "//a[@aria-label='Ignite Premier Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::button[contains(@aria-label,'See all channels')]//span[@class='price-details__label']")
	WebElement btnTotalChannelsPremier;

	@FindBy(xpath = "//a[@aria-label='Ignite Premier Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::button[contains(@aria-label,'See all flex channels')]//span[@class='price-details__label']")
	WebElement btnFlexChannelsPremier;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::button[contains(@aria-label,'See all flex channels')]//span[@class='price-details__label']")
	WebElement btnFlexChannelsFlex20;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::a[contains(@aria-label,'View more details')]//span[@role='text']")
	WebElement btnViewMoreDetailsFlex20;

	@FindBy(xpath = "//a[@aria-label='Ignite Flex 10 Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::a[contains(@aria-label,'View more details')]//span[@role='text']")
	WebElement btnViewMoreDetailsFlex10;

	@FindBy(xpath = "//span[@translate ='global.label.totalFlexChannels']")
	WebElement txtFlexChannelsRateCardDetails;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement iconCloseModal;

	@FindAll({
			@FindBy(xpath="//div[contains(@class, 'ds-tile')]//div[@rchapiexposer=\"planIncludes.discountedPrice\"]"),
			@FindBy(xpath = "//rch-tile-see-full-detials-modal//div[@class='price-legal__OTBC ng-star-inserted']/span"),
			@FindBy(xpath = "//span[@class='text-overline mb-0 mw-100']")
//			@FindBy(xpath = "//div[contains(@class, 'ds-tile')]//span[@class='text-overline mb-0 mw-100'][normalize-space()='CREDIT']"),
//			@FindBy(xpath="//div[contains(@class, 'ds-tile')]//span[contains(text(),'Credit will appear on the Order Review page and be')]"),
//			@FindBy(xpath="//div[contains(@class, 'ds-tile')]//span[contains(text(),'Credit appears in')]")
	})
	WebElement txtOtbcCampaign;

	@FindBy(xpath = "//h3[contains(text(),'pending work order on your ac')]")
	WebElement headerPendingOrder;

	@FindBy(xpath = "//div[@class='pending-order-modal-component']//span[@class = 'ds-icon d-inline-flex rds-icon-close']")
	WebElement btnPendingOrderClose;

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

	@FindBy(xpath = "//span[@translate='global.cta.updateCart']/ancestor::span[@role='text']")
	WebElement buttonUpdateCart;

	@FindBy(xpath = "//ds-modal-container[contains(@id,'ds-modal-container')]")
	WebElement modalUpgradingToIgnitebundels;

	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large']//span[@class='ds-button__copy w-100']")
	WebElement okayUpgradingToIgnitebundelsModal;

	@FindBy(xpath = "//button[@aria-label='Hide your full cart']//span[contains(@class,'rds-icon-chevron-up')]")
	WebElement upChevronCartSummary;

	@FindBy(xpath = "//button[@aria-label='View your full cart']//span[contains(@class,'rds-icon-chevron-down')]")
	WebElement downChevronCartSummary;

	@FindBy(xpath = "//div[contains(@class,'mini-cart-ss__body')]//tr[contains(@class,'cms-promotions-gwp ng-tns-c')]")
	WebElement gwpYourCart;

	@FindBy(xpath ="//input[contains(@id,'messageForExistingNumber')]//following-sibling::label")
	WebElement rdoKeepExistingPhoneNumber;


	/**
	 * Click Starter package button for anonymous customer
	 * @param    bundleName : name of the bundle package
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
		getReusableActionsInstance().getWhenReady(btnChannelsTab, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnChannelsTab);
		//getReusableActionsInstance().getWhenReady(btnChannelsTab, 60).click();
	}

	/**
	 * To click on  Home phone checkbox
	 * @author chinnarao.vattam
	 */
	public void clkThemepacksTab() {
		getReusableActionsInstance().executeJavaScriptClick(btnThemepacksTab);
		//getReusableActionsInstance().getWhenReady(btnThemepacksTab, 60).click();
	}

	/**
	 * To verify Price Increase Channel Copy banner
	 * @return true if the Price Increase Channel Copy banner is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPriceIncreaseChannelCopy() {
		getReusableActionsInstance().waitForElementVisibility(bnrPriceIncreaseChannelCopy, 30);
		Boolean isBannerAvailable = getReusableActionsInstance().isElementVisible(bnrPriceIncreaseChannelCopy);
		getReusableActionsInstance().javascriptScrollByVisibleElement(bnrPriceIncreaseChannelCopy);
		return isBannerAvailable;
	}

	/**
	 * To verify Price Increase Theme Copy banner
	 * @return true if the Price Increase Theme Copy banner is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPriceIncreaseThemeCopy() {
		getReusableActionsInstance().waitForElementVisibility(bnrPriceIncreaseThemeCopy, 30);
		Boolean isBannerAvailable = getReusableActionsInstance().isElementVisible(bnrPriceIncreaseThemeCopy);
		getReusableActionsInstance().javascriptScrollByVisibleElement(bnrPriceIncreaseThemeCopy);
		//getReusableActionsInstance().javascriptScrollByVisibleElement(headerBundlesChannelsAndThemepacks);
		return isBannerAvailable;
	}

	/**
	 * To click on the chevron of your cart
	 * @author Chinnarao.vattam
	 */
	public void clkChevronUpYourCart() {
		if(getReusableActionsInstance().isElementVisible(popupLoadingFingersciam,20)) {
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam, 90);
		}
		getReusableActionsInstance().getWhenReady(upChevronCartSummary, 20).click();
	}

	/**
	 * Validates the bundleName in mini cart
	 *
	 * @param bundleName from offers page
	 * @return true if bundle name is matching, else false
	 * @author nandan.master
	 */
	public boolean verifyBundleNameMiniCart(String bundleName) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//td[normalize-space()='"+bundleName+"']"));
	}

	/**
	 * To verify gwp promotion in the cart summary
	 *
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
		return getReusableActionsInstance().isElementVisible(gwpYourCart);
	}

	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPage() {
		getReusableActionsInstance().waitForElementVisibility(txtBundlesPage, 120);
		return getReusableActionsInstance().isElementVisible(txtBundlesPage);
	}

	/**
	 * To verify Offers Page
	 * @return true if the Offers are available else return false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyOffersPage() {
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().waitForElementVisibility(txtOffersPage, 60);
		return getReusableActionsInstance().isElementVisible(txtOffersPage);
	}


	/**
	 * To select type of contract to month-to-month
	 * @author Manpreet.Kaur3
	 */
	public void selectPremierMonthToMonthTypeOfContract() {
		//	getReusableActionsInstance().javascriptScrollByVisibleElement(drpdwnPremierTypeOfContract);
		getReusableActionsInstance().waitForElementVisibility(drpdwnPremierTypeOfContract, 30);
		getReusableActionsInstance().getWhenReady(drpdwnPremierTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Premier Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}

	/**
	 * To select type of contract to month-to-month
	 * @author Manpreet.Kaur3
	 */
	public void selectStarterPackageMonthToMonthTypeOfContract() {
		getReusableActionsInstance().waitForElementVisibility(drpdwnStarterPackageTypeOfContract, 120);
		getReusableActionsInstance().getWhenReady(drpdwnStarterPackageTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Starter Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}

	/**
	 * To select type of contract to month-to-month
	 * @author Manpreet.Kaur3
	 */
	public void selectFlex20PackageMonthToMonthTypeOfContract() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(drpdwnFlex20PackageTypeOfContract, 120);
		getReusableActionsInstance().getWhenReady(drpdwnFlex20PackageTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Flex 20 Including Sports Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}


	/**
	 * To verify Bundles Page
	 * @return true if the Bundles is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyBundlesPageMobile() {
		getReusableActionsInstance().waitForElementVisibility(txtBundlesPage, 120);
		return getReusableActionsInstance().isElementVisible(txtBundlesPage);
	}

	/**
	 * To verify Upgrading To Ignite bundels Modal
	 * @param    bundleName : name of the bundle package
	 * @return true if the modal is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPForStarterPackage(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[contains(@class,'d-flex')]/preceding-sibling::section//p";
		return getReusableActionsInstance().isElementVisible(By.xpath(xpathBundlePackage), 120);
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
	 * @param    bundleName : name of the bundle package
	 * @author Saurav.Goyal
	 */
	public void clkChevronSolarisStarterPackageNew(String bundleName) {
		String xpathBundlePackage = "//button[contains(@aria-label,'"+ bundleName +"')]//ancestor::div[@class='row']//following-sibling::div[contains(@class,'dsa-rate-card__detail')]//span[@class='ds-icon rds-icon-chevron-down']";
		getReusableActionsInstance().getWhenReady(By.xpath(xpathBundlePackage), 120).click();
	}

	/**
	 * To click on the chevron of any given bundle package
	 * @param    bundleName : give the name of the bundle as parameter
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
		return getReusableActionsInstance().isElementVisible(modalUpgradingToIgnitebundels);
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
		//getReusableActionsInstance().executeJavaScriptClick(buttonAddIgniteTVBoxes);
		getReusableActionsInstance().clickWhenReady(buttonAddIgniteTVBoxes);
	}

	/**
	 * Click 5 times + to add over 4 STB ignite TV boxes
	 * @author Manpreet.Kaur3
	 */
	public void clkPlusAddOverFourIgniteTVBoxes() {
		getReusableActionsInstance().waitForElementVisibility(buttonAddIgniteTVBoxes, 90);
		for(int i = 0; i < 5; i++){
			getReusableActionsInstance().clickWhenReady(buttonAddIgniteTVBoxes);
			//getReusableActionsInstance().executeJavaScriptClick(buttonAddIgniteTVBoxes);
		}
	}

	/**
	 * To Click Update cart button
	 * @author Saurav.Goyal
	 */
	public void clkUpdateCart() {
getReusableActionsInstance().staticWait(3000);
		if(getReusableActionsInstance().isElementVisible(popupLoadingFingersciam,20)) {
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam, 90);
		}
		getReusableActionsInstance().waitForElementTobeClickable(buttonUpdateCart, 60);
		getReusableActionsInstance().getWhenReady(buttonUpdateCart, 60).click();
	}

	/**
	 * Verify visibility of upgrade now button
	 * @return boolean true if the element is present else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyButtonUpgradeNow() {
		getReusableActionsInstance().waitForElementVisibility(buttonUpgradeNow, 120);
		return getReusableActionsInstance().isElementVisible(buttonUpgradeNow);
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
		return getReusableActionsInstance().isElementVisible(btnHomePhoneContinue);
	}

	/**
	 * To verify the important information popup
	 * @return true if the information popup has launched, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		getReusableActionsInstance().waitForElementVisibility(popImportantInformation, 60);
		return getReusableActionsInstance().isElementVisible(popImportantInformation);
	}

	/**
	 * Click the I understand button on the important information popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand() {
		getReusableActionsInstance().getWhenReady(btnIUnderstand, 60).click();
		getReusableActionsInstance().waitForPageLoad();
	}

	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhone() {
		getReusableActionsInstance().waitForElementVisibility(btnHomePhoneContinue, 60);
		getReusableActionsInstance().getWhenReady(btnHomePhoneContinue, 10).click();
	}

	/**
	 * Click Home phone button on Ignite Home Phone popup
	 * @author chinnarao.vattam
	 */
	public void clkHomePhoneAddOn() {
		getReusableActionsInstance().waitForElementVisibility(btnHomePhoneAddOnContinue, 30);
		getReusableActionsInstance().getWhenReady(btnHomePhoneAddOnContinue, 10).click();
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
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().waitForElementVisibility(txtCartSummary,120);
		return getReusableActionsInstance().isElementVisible(txtCartSummary,90);
	}

	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		if(getReusableActionsInstance().isElementVisible(popupLoadingFingersciam,20)){
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		}
		getReusableActionsInstance().scrollToElement(btnCheckout);
		getReusableActionsInstance().getWhenReady(btnCheckout, 20).click();

	}

	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckoutCancel() {
		if(getReusableActionsInstance().isElementVisible(popupLoadingFingersciam,20)){
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		}
		getReusableActionsInstance().waitForElementTobeClickable(btnCheckoutCancel, 60);
		getReusableActionsInstance().getWhenReady(btnCheckoutCancel, 20).click();
	}

	/**
	 * Click checkout button on Ignite-bundles/tv-internet page
	 * @author chinnarao.vattam
	 */
	public void clkCheckoutMobile() {
		if(getReusableActionsInstance().isElementVisible(popupLoadingFingersciam,20)){
			getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersciam,90);
		}
		getReusableActionsInstance().executeJavaScriptClick(btnCheckout);
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
	 * Click Flex20+ package button for anonymous customer
	 * @author manpreet.kaur3
	 */
	public void selectFlex20Package() {
		getReusableActionsInstance().getWhenReady(btnFlex20Package, 60).click();

	}

	public void selectFlex10Package() {
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().waitForElementVisibility(btnFlex10Package, 60);
		getReusableActionsInstance().getWhenReady(btnFlex10Package, 30).click();

	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisPremierPackage() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSolarisPremierPackage);
		getReusableActionsInstance().getWhenReady(btnSolarisPremierPackage, 60).click();
	}

	/**
	 * Click Starter package button for anonymous customer
	 * @author chinnarao.vattam
	 */
	public void selectSolarisPremier() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(btnSolarisPremierPackage);
		getReusableActionsInstance().getWhenReady(btnSolarisPremierPackage, 60).click();
		//getReusableActionsInstance().waitForElementVisibility(btnSolarisPremierPackage, 30);
		//getReusableActionsInstance().executeJavaScriptClick(btnSolarisPremierPackage);
	}

	public void selectIgniteBundle(){
		//a[contains(@aria-label,'Ignite Starter')]/ancestor::div[@class='vertical-tile-component']//button[contains(@aria-label,'See all channels')]
	}

	/**
	 * To get Total Channel
	 *@return total channels count on the offers page
	 * @author manpreet.kaur3
	 */
	public String getTotalChannelCount() {
		getReusableActionsInstance().waitForElementVisibility(btnSolarisPremierPackage, 50);
		String strChannels=getReusableActionsInstance().getWhenReady(txtTotalChannelsRateCardHead, 20).getText();
		String channels = strChannels.trim();
		return channels;

	}

	/**
	 * To verify Total Channel
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelAtRateCard(String channels) {

		getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardExpansion,30).click();
		String strDetailChannels=getReusableActionsInstance().getWhenReady(txtTotalChannelsRateCardDetails, 50).getText();
		String[] detailChannels = strDetailChannels.split("\\s+");
		String detailChannelsValue=detailChannels[0];
		return channels.equals(detailChannelsValue);

	}


	/**
	 * To get Flex Channel
	 *@return flex channels count on the offers page
	 * @author manpreet.kaur3
	 */
	public String getFlexChannelCount() {

		String strFlexChannels=getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardHead, 50).getText();
		String flexChannels = strFlexChannels.trim();
		return flexChannels;

	}

	/**
	 * To verify Flex Channel
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlexChannelAtRateCard(String flexChannels) {
		String strDetailFlexChannels=getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardDetails, 50).getText();
		String[] detailFlexChannels = strDetailFlexChannels.split("\\s+");
		String strFlexChannelsValue =detailFlexChannels[0];
		getReusableActionsInstance().clickWhenReady(iconCloseModal);
		return flexChannels.equals(strFlexChannelsValue);
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
		return getReusableActionsInstance().isElementVisible(rdo4KTV);
	}

	/**
	 * Click 4K TV radio button on Ignite-bundles/tv-internet page
	 * @return true if the 4K TV ratio has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOptNewPhone() {
		getReusableActionsInstance().waitForElementVisibility(rdoOptNewPhone, 120);
		return getReusableActionsInstance().isElementVisible(rdoOptNewPhone);
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
	 * Set dynamic first name on email modal popup at cart summary page
	 * @author Manpreet.Kaur3
	 */
	public void setFirstname() {
		String strName = FormFiller.generateRandomName();
		//getReusableActionsInstance().executeJavaScriptClick(txtFirstName);
		getReusableActionsInstance().waitForElementVisibility(txtFirstNameContainer,60);
		getReusableActionsInstance().getWhenReady(txtFirstNameContainer,30).click();
		getReusableActionsInstance().clickWhenReady(txtFirstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(strName);
	}

	/**
	 * Set dynamic last name on email modal popup at cart summary page
	 * 	 * @author Manpreet.Kaur3
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		//getReusableActionsInstance().executeJavaScriptClick(txtLastName);
		getReusableActionsInstance().waitForElementVisibility(txtLastNameContainer,60);
		getReusableActionsInstance().getWhenReady(txtLastNameContainer,30).click();
		getReusableActionsInstance().clickWhenReady(txtLastName);
		txtLastName.clear();
		txtLastName.sendKeys(strName);
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
		getReusableActionsInstance().waitForPageLoad();
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
	 * Set dynamic phone number on Email Modal at cart summary Page
	 * @author Manpreet.Kaur3
	 */
	public void setPhone() {
		//getReusableActionsInstance().executeJavaScriptClick(btnPhone);
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		getReusableActionsInstance().waitForElementVisibility(btnPhoneContainer,60);
		getReusableActionsInstance().getWhenReady(btnPhoneContainer,30).click();
		getReusableActionsInstance().clickWhenReady(btnPhone);
		btnPhone.clear();
		btnPhone.sendKeys(strPhoneNumber);
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
		return getReusableActionsInstance().isElementVisible(txtSelectPackageCost,10);
	}

	/**
	 * To verify Popular Package Cost
	 * @return true if the Popular Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPopularPackageCost() {
		return getReusableActionsInstance().isElementVisible(txtPopularPackageCost,10);
	}

	/**
	 * To verify Premier Package Cost
	 * @return true if the Premier Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPremierPackageCost() {
		return getReusableActionsInstance().isElementVisible(txtPremierPackageCost,10);
	}

	/**
	 * To verify Premier Package
	 * @return true if the Premier Package is available else return false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyPremierPackage() {
		return getReusableActionsInstance().isElementVisible(txtPremierPackage,10);
	}

	/**
	 * To verify Starter Package Cost
	 * @return true if the Starter Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyStarterPackageCost() {
		return getReusableActionsInstance().isElementVisible(txtStarterPackageCost,10);
	}

	/**
	 * To verify Flex20 Package Cost
	 * @return true if the Flex20 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex20PackageCost() {
		return getReusableActionsInstance().isElementVisible(txtFlex20PackageCost,10);
	}

	/**
	 * To verify Flex10 Package Cost
	 * @return true if the Flex10 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex10PackageCost() {
		return getReusableActionsInstance().isElementVisible(txtFlex10PackageCost,10);
	}

	/**
	 * To verify Flex5 Package Cost
	 * @return true if the Flex5 Package Cost is available else return false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFlex5PackageCost() {
		return getReusableActionsInstance().isElementVisible(txtFlex5PackageCost,30);
	}

	public boolean verifyHomePhoneAddOnPage() {
		return getReusableActionsInstance().isElementVisible(headerHomePageAddOn, 40);
	}

	/**
	 * To scroll to Ignite Premier at offers page
	 * @author Manpreet.Kaur3
	 */
	public void scrollToSolarisPremier() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(headerIgnitePremier);
	}

	/**
	 * To scroll to Ignite Starter at offers page
	 * @author Manpreet.Kaur3
	 */
	public void scrollToIgniteStarter() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(headerIgniteStarter);
	}

	/**
	 * To click on take the quiz
	 * @author Manpreet.Kaur3
	 */
	public void clkTaketheQuiz() {
		getReusableActionsInstance().waitForElementVisibility(btnTakeQuiz, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnTakeQuiz);
	}

	/**
	 * To select Live TV channels in DST
	 * @author Manpreet.Kaur3
	 */
	public void clkLiveTVChannels() {
		getReusableActionsInstance().getWhenReady(btnLiveTVChannels, 30).click();
	}

	/**
	 * To select Flexible channels in DST
	 * @author Manpreet.Kaur3
	 */
	public void clkFlexibleChannels() {
		getReusableActionsInstance().getWhenReady(btnFlexibleChannels, 30).click();
	}

	/**
	 * To select Live Sports plus in DST
	 * @author Manpreet.Kaur3
	 */
	public void clkLiveSports() {
		getReusableActionsInstance().getWhenReady(btnLiveSports, 30).click();
	}

	/**
	 * To select Mobile App with Download and Go in DST
	 * @author Manpreet.Kaur3
	 */
	public void clkMobileApp() {
		getReusableActionsInstance().getWhenReady(btnMobileApp, 30).click();
	}

	/**
	 * To Click on DST Continue to next question
	 * @author Manpreet.Kaur3
	 */
	public void clkDSTContinue() {
		getReusableActionsInstance().getWhenReady(btnDSTcontinue, 30).click();
	}

	/**
	 * To select 4 starts for network category
	 * @author Manpreet.Kaur3
	 */
	public void clkFourStarsNetworkCategory() {
		getReusableActionsInstance().getWhenReady(imgRateNetworkCategoryFour, 30).click();
	}

	/**
	 * To select 4 starts for entertainment category
	 * @author Manpreet.Kaur3
	 */
	public void clkFourStarsEntertainmentCategory() {
		getReusableActionsInstance().getWhenReady(imgRateEntertainmentCategoryFour, 30).click();
	}

	/**
	 * To select 4 starts for network category
	 * @author Manpreet.Kaur3
	 */
	public void clkFourStarsNewsCategory() {
		getReusableActionsInstance().getWhenReady(imgRateNewsCategoryFour, 30).click();
	}

	/**
	 * To select 4 starts for lifestyle category
	 * @author Manpreet.Kaur3
	 */
	public void clkFourStarsLifestyleCategory() {
		getReusableActionsInstance().getWhenReady(imgRateLifestyleCategoryFour, 30).click();
	}

	/**
	 * To select Internet devices DST
	 * @author Manpreet.Kaur3
	 */
	public void clkInternetDevices() {
		getReusableActionsInstance().getWhenReady(btnInternetDevices, 30).click();
	}

	/**
	 * To select Add Home Phone DST
	 * @author Manpreet.Kaur3
	 */
	public void clkAddHomePhoneDST() {
		getReusableActionsInstance().getWhenReady(btnAddHomePhoneDST, 30).click();
	}

	/**
	 * To Verify the DST best fit
	 * @return true if best fit is displayed, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyBestFit() {
		return getReusableActionsInstance().getWhenReady(txtBestFit, 60).isDisplayed();
	}

	/**
	 * To close DST
	 * @author Manpreet.Kaur3
	 */
	public void clkDSTClose() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(btnDSTClose, 40).click();
	}

	/**
	 * To Verify the best fit on offers page
	 * @return true if best fit promo is displayed, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean VerifyYourBestFit() {
		return getReusableActionsInstance().getWhenReady(VerifyYourBestFit, 90).isDisplayed();
	}

	/**
	 * To select type of contract to month-to-month
	 * @author Manpreet.Kaur3
	 */
	public void selectFlex10PackageMonthToMonthTypeOfContract() {
		getReusableActionsInstance().getWhenReady(drpdwnFlex10PackageTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Flex 10 Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}

	/**
	 * Click Continue on review caller information page
	 * @author manpreet.kaur3
	 */
	public void clkReviewCallerContinuebtn() {
		getReusableActionsInstance().waitForElementVisibility(btnReviewCallerInfoContinue, 60);
		getReusableActionsInstance().getWhenReady(btnReviewCallerInfoContinue, 10).click();
	}

	/**
	 * Click Add to Cart on recommeded pkg
	 * @author manpreet.kaur3
	 */
	public void clkBestAdd() {
		getReusableActionsInstance().getWhenReady(btnBestAdd, 60).click();
	}

	/**
	 * Click Total Channels on Flex20 pkg
	 * @author manpreet.kaur3
	 */
	public void clkTotalChannelsFlex20() {
		getReusableActionsInstance().getWhenReady(btnTotalChannelsFlex20, 30).click();
	}

	/**
	 * Click Total Channels on Flex20 pkg
	 * @author manpreet.kaur3
	 */
	public void clkViewMoreDetailsFlex20() {
		getReusableActionsInstance().getWhenReady(btnViewMoreDetailsFlex20, 30).click();
	}

	public void clkViewMoreDetailsFlex10() {
		getReusableActionsInstance().getWhenReady(btnViewMoreDetailsFlex10, 30).click();
	}

	/**
	 * Click Flex Channels on Flex20
	 * @author manpreet.kaur3
	 */
	public void clkFlexChannelsFlex20() {
		getReusableActionsInstance().getWhenReady(btnFlexChannelsFlex20, 30).click();
	}

	/**
	 * Click Total Channels on Premier pkg
	 * @author manpreet.kaur3
	 */
	public void clkTotalChannelsPremier() {
		getReusableActionsInstance().getWhenReady(btnTotalChannelsPremier, 30).click();
	}

	/**
	 * Click Flex Channels on Premier
	 * @author manpreet.kaur3
	 */
	public void clkFlexChannelsPremier() {
		getReusableActionsInstance().getWhenReady(btnFlexChannelsPremier, 30).click();
	}

	/**
	 * verify Total Channels popup
	 * @return true if displayed, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyViewTotalChannelsPopupModal() {
		//getReusableActionsInstance().waitForElementVisibility(drpdwnGenre, 40);
		return getReusableActionsInstance().isElementVisible(drpdwnGenre, 60);
	}

	/**
	 * verify Flex Channels popup
	 * @return true if displayed, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyViewFlexChannelsPopupModal() {
		return getReusableActionsInstance().isElementVisible(drpdwnGenre, 60);
	}

	/**
	 * Clicks on close button for Total Channels/Flex Channels popup
	 * @author manpreet.kaur3
	 */
	public void clkCloseChannelsPopup() {
		getReusableActionsInstance().getWhenReady(iconCloseModal, 20).click();
	}

	/**
	 * verify SVOD is removed from genre dropdown
	 * @return true if  not available in the list, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifySVODRemovedFromGenre() {
		getReusableActionsInstance().waitForElementVisibility(drpdwnGenre, 90);
		getReusableActionsInstance().getWhenReady(drpdwnGenre, 30).click();
		Select DrpDwnGenreSel = new Select(drpdwnGenre);
		List<WebElement> DrpDwnGenreList = DrpDwnGenreSel.getOptions();
		for (WebElement indElem : DrpDwnGenreList) {
			if (indElem.getText().contains("SVOD")) {
				return false;
			}
		}
		return true;
	}

	/**
	 * verify Flex Channels filter is present in the dropdown
	 * @return true if available in the list, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyFlexChannelsPresentInGenre() {
		getReusableActionsInstance().waitForElementVisibility(drpdwnGenre, 90);
		getReusableActionsInstance().getWhenReady(drpdwnGenre, 30).click();
		Select DrpDwnGenreSel = new Select(drpdwnGenre);
		List<WebElement> DrpDwnGenreList = DrpDwnGenreSel.getOptions();
		for (WebElement indElem : DrpDwnGenreList) {
			if (indElem.getText().contains("Flex Channels")) {
				DrpDwnGenreSel.selectByVisibleText("Flex Channels");
				return true;
			}
		}
		return false;
	}

	/**
	 * Click on enter address button on offers page
	 * @author manpreet.kaur3
	 */
	public void clkEnterAddress() {
		getReusableActionsInstance().getWhenReady(btnEnterAddress, 60).click();
	}

	public void selectRecommendedPkg1GbpsInternetSpeed() {
		getReusableActionsInstance().getWhenReady(drpdwnRecommendedPkgInternetSpeed,30).click();
		Select internetSpeed = new Select(getDriver().findElement(By.xpath("//div[@class='vertical-tile__ribbon__body -promo-available']/parent::div/following-sibling::div/descendant::select[@aria-label='Open list of internet speeds and select one']")));
		internetSpeed.selectByVisibleText("1 Gbps");
	}

	public void clkRecommendedPkgViewMoreDetails() {
		getReusableActionsInstance().getWhenReady(lnkRecommendedPkgViewMoreDetails, 30).click();
	}

	public boolean verifyMoreDetailsPopup() {
		return getReusableActionsInstance().isElementVisible(divViewMoreDetailsPopup, 60);
	}

	public boolean verify4KChannelsAlert() {
		//getReusableActionsInstance().staticWait(50000);
		getReusableActionsInstance().waitForElementVisibility(bnrAlertCopy, 120);
		Boolean isBannerAvailable = getReusableActionsInstance().isElementVisible(bnrAlertCopy);
		return isBannerAvailable;
	}

	/**
	 * Gets the Flex Channels header copy - Preselected
	 * @return true if Actual copy is matching the desired copy, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyFlexChannelsHeader() {
		//h2[@translate='global.modals.flexChannelsModal.preSelectedFlexChannelsHeader']
		String flexChannelsHeaderDesired = "Pre-selected Flex channels";
		String flexChannelsHeaderActual = getReusableActionsInstance().getWhenReady(txtPreselectedFlexChannels, 20).getText();
		if(flexChannelsHeaderActual.equals(flexChannelsHeaderDesired)){
			return true;
		}

		return false;
	}

	/**
	 * Gets the bundles price in mini cart
	 * @param bundleCost from offers page
	 * @return true if price is matching with the bundles cost at offers page, else false
	 * @author manpreet.kaur3
	 */
	public Boolean isPriceCorrectMiniCart(String bundleCost) {
		String bundleCostText = getReusableActionsInstance().getWhenReady(divBundleCostInline, 40).getAttribute("aria-label");
		String[] subs= bundleCostText.split("\\$");
		String[] bundleCostInline = subs[1].split(" ");
		if(bundleCostInline[0].equals(bundleCost)){
			return true;
		}
		return false;
	}

	/**
	 * Gets the selected Bundles cost
	 * @return cost as String
	 * @author manpreet.kaur3
	 */
	public String getBundlePrice() {
		String bundleCostText = getReusableActionsInstance().getWhenReady(divBundleCost, 40).getAttribute("aria-label");
		String[] subs= bundleCostText.split("\\$");
		String[] bundleCost = subs[1].split(" ");
		return bundleCost[0];
	}

	/**
	 * To get Total Channel
	 * @param bundleName from yaml file
	 * @return total channels count on the offers page
	 * @author manpreet.kaur3
	 */
	public String getTotalChannelCount(String bundleName) {

		getReusableActionsInstance().waitForElementVisibility(btnSolarisStarterPackage, 10);
		String xpathBundlePackage = "//a[contains(@aria-label,'"+ bundleName +"')]/ancestor::div[@class='vertical-tile-component']//button[contains(@aria-label,'See all channels')]//span[@class ='price-details__count']";
		String strChannels=getReusableActionsInstance().getWhenReady(By.xpath(xpathBundlePackage), 60).getText();
		String channels = strChannels.trim();
		return channels;
	}

	/**
	 * To get Flex Channel for particular bundle
	 * @param bundleName
	 * @return flex channels count on the offers page
	 * @author manpreet.kaur3
	 */
	public String getFlexChannelCount(String bundleName) {
		By txtFlexChannelsRateCardHead= By.xpath("//button[@aria-label='See all flex channels included in the "+ bundleName +" Bundle']//span[@class ='price-details__count']");
		String strFlexChannels=getReusableActionsInstance().getWhenReady(txtFlexChannelsRateCardHead, 50).getText();
		String flexChannels = strFlexChannels.trim();
		return flexChannels;
	}

	public Boolean validateOTBCBundleOffers(String bundleName) {
		By divOTBCRateCardHead= By.xpath("//a[@aria-label='"+ bundleName +" Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::span[contains(text(), 'CREDIT')]");
		return getReusableActionsInstance().isElementVisible(divOTBCRateCardHead, 50);
	}

	public Boolean validateOTBCCampaign() {
		return getReusableActionsInstance().isElementVisible(txtOtbcCampaign, 40);
	}

	/**
	 * Validates whether OTBC credit amount is presentable in two decimal points.
	 * @param bundleName
	 * @return true if amount is 2 decimal places
	 * @author nandan.master
	 */
	public Boolean isOTBCPresentmentTwoDecimal(String bundleName) {
		By divOTBCRateCardHead = By.xpath("//a[@aria-label='" + bundleName + " Add to cart']/ancestor::div[@class='vertical-tile-component']//div[@class='price-legal__OTBC ng-star-inserted']/span");
		String otbcText = getReusableActionsInstance().getWhenReady(divOTBCRateCardHead, 40).getText();
		String[] subs = otbcText.split("\\$");
		String[] otbcAmountInLine = subs[1].split(" ");
		String[] otbcDecimalSplit = otbcAmountInLine[0].split("\\.");
		int decimalLength = otbcDecimalSplit[1].length();
		if (decimalLength == 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPendingOrderHeader() {
		return getReusableActionsInstance().isElementVisible(headerPendingOrder, 20);
	}

	public void clkCloseButtonPendingOrder() {
		getReusableActionsInstance().getWhenReady(btnPendingOrderClose, 30).click();
	}

	/**
	 * Click Total Channels for particular bundle
	 * @param bundleName
	 * @author manpreet.kaur3
	 */
	public void clkTotalChannels(String bundleName) {
		By btnTotalChannels= By.xpath("//a[contains(@aria-label,'"+ bundleName +"')]/ancestor::div[@class='vertical-tile-component']//button[contains(@aria-label,'See all channels')]");
		getReusableActionsInstance().getWhenReady(btnTotalChannels, 30).click();
	}

	/**
	 * Click Flex Channels for particular bundle
	 * @param bundleName
	 * @author manpreet.kaur3
	 */
	public void clkFlexChannels(String bundleName) {
		By btnFlexChannels = By.xpath("//a[@aria-label='"+ bundleName +" Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::button[contains(@aria-label,'See all flex channels')]//span[@class='price-details__label']");
		getReusableActionsInstance().getWhenReady(btnFlexChannels, 30).click();
	}

	/**
	 * Click Add to cart for particular bundle
	 * @param bundleName
	 * @author manpreet.kaur3
	 */
	public void selectSolarisPackage(String bundleName) {
		By btnSolarisPackage = By.xpath("//a[@aria-label='"+ bundleName +" Add to cart']//span[text()='Add to cart']");
		getReusableActionsInstance().getWhenReady(btnSolarisPackage, 60).click();
	}

	public void selectInternetSpeeed(String planName,String speed){
		String str_element = "//h3[contains(text(),'"+planName+"')]/ancestor::div[@class='vertical-tile ds-shadow']//select[contains(@aria-label,'speeds')]";
		By element = By.xpath(str_element);
		WebElement dropdownbox = getReusableActionsInstance().getWhenReady(element, 180);
		getReusableActionsInstance().selectWhenReady(dropdownbox,4);
	}
}
