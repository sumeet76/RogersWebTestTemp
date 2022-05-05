package com.rogers.oneview.pages;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import com.rogers.pages.base.BasePageClass;

import java.util.LinkedList;
import java.util.List;

public class TVDashboardPage  extends BasePageClass {

	public TVDashboardPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//span[text()='Reset Parental Controls & PIN' or text()='Réinitialiser le contrôle parental et le NIP']")
	WebElement btnResetParentalControl;

	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.resetOnDem']")
	WebElement icnCustForgotPurchasePin;

	@FindBy(xpath = "//button[@rchtrackclickevent='generatePDF']")
	WebElement icnViewPdf;


	@FindBy(xpath = "//span[text()='View my channel lineup' or text()='Voir ma liste de chaînes']/ancestor::button")
	WebElement btnViewChannelLineUp;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button | (//rch-conflict-modals/descendant::span[@ng-reflect-translate='global.modals.conflictWarnings'])")
	WebElement btnContnueReset;

	@FindBy(xpath = "//div[@class='ds-modal__header d-flex align-items-start']")
	WebElement imgSuccess;

	@FindBy(xpath = "//div[contains(text(),'Success!')]")
	WebElement txtSuccess;

	@FindBy(xpath = "//button[@class='btn_s100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']")
	WebElement btnSuccessOk;

	@FindBy(xpath = "//span[text()='OK']/ancestor::button")
	WebElement btnOk;


	@FindBy(xpath = "//span[text()='Restart box(es)' or text()='Redémarrer les terminaux numériques']")
	WebElement btnRestartSetupbox;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnHeader;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnFooter;

	@FindBy(xpath = "//span[text()='Back to Overview' or text()='Retourner à l’aperçu']")
	WebElement btnBackToAccountOverview;

	@FindBy(xpath = "//a[@href='/customer/support/article/using-voice-commands']")
	WebElement lnkUsingVoiceCommands;

	@FindBy(xpath = "//a[@href='/customer/support/article/using-apps-on-ignite-tv']")
	WebElement lnkIntroToAppsOnIgniteTv;

	@FindBy(xpath = "//a[@href='/customer/support/article/ignite-tv-power-saver']")
	WebElement lnkFAQOnPowerSaver;

	@FindBy(xpath = "//a[@href='/customer/support/article/ignite-tv-error-codes']")
	WebElement lnkIgniteTvErrCode;

	@FindBy(xpath = "//span[text()='Go to support section' or text()='Aller à la section de soutien']")
	WebElement lnkGoToSupportSection;


	@FindBy(xpath = "(//div[@class='col-12 exchange-channels-grid'])[1]//input[@placeholder='Search for a channel']")
	WebElement txtSearchChannelBox;

	@FindBy(xpath = "(//div[@class='col-12 exchange-channels-grid'])[1]//i[@class='rch-icon-search' and @_ngcontent-c33='']")
	WebElement icnSearchChannelToRemove;

	@FindBy(xpath = "(//h4[@translate='global.dashboard.tv.manageChannelsAndThemePacks.vpAlacartes']/parent::div/following-sibling::div/descendant::span[text()='Remove'])[1] | (//rch-channel/descendant::rch-channel-logo/descendant::div)[1]")
	WebElement btnFirstChannelToRemove;

	@FindBy(xpath = "(//div[@class='exchange-container x-out']//button[@role='button'])[3] | (//rch-channel/descendant::rch-channel-logo/descendant::div)[3]")
	WebElement btnSecondChannelToRemove;

	@FindBy(xpath = "//span[text()='Sélectionner' or text()='Select']/ancestor::button | //span[@translate='global.cta.select']/ancestor::button")
	WebElement btnSelectChannel;

	@FindBy(xpath = "(//div[@class='col-12 exchange-channels-grid'])[2]//i[@class='rch-icon-search' and @_ngcontent-c33='']")
	WebElement icnSearchChannelToAdd;

	@FindBy(xpath = "(//div[@class='exchange-container x-in']//button[@role='button'])[1] | ((//div[@class='swapCountLimit'])[2]/descendant::rch-channel/descendant::rch-channel-logo/descendant::div)[1]")
	WebElement btnFirstChannelToAdd;

	@FindBy(xpath = "(//div[@class='exchange-container x-in']//button[@role='button'])[3] | ((//div[@class='swapCountLimit'])[2]/descendant::rch-channel/descendant::rch-channel-logo/descendant::div)[3]")
	WebElement btnSecondChannelToAdd;

	@FindBy(xpath = "//span[text()='Confirmer l’échange' or text()='Confirm exchange']/ancestor::button")
	WebElement btnConfirmExchange;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.exchangeFlexChannels']/ancestor::button")
	WebElement btnExchangeFlexChannels;

	@FindBy(xpath = "//*[@translate='global.swap.exchangeChannels']/parent::div/parent::div/parent::div")
	WebElement popUpFlexChannelLoader;


	@FindBy(xpath = "//div[@class='row ng-star-inserted']//preceding::rch-self-serve-exchange-channels[@class='ng-star-inserted']")
	WebElement exchangeFlexChannelContainer;

	@FindBy(xpath = "//div[@translate='global.message.WhenFinishedYourChannels']")
	WebElement txtConfirmToContinue;


	@FindBy(xpath = "//div[starts-with(@class,'cl-popup ng-tns-c55')]")
	WebElement selectChannelPopup;

	@FindBy(xpath = "//h3[@ng-reflect-translate='global.dashboard.tv.recordAndS']")
	WebElement txtRecordAndSave;

	@FindBy(xpath = "//span[text()='Change package' or text()='Changer de forfait']/ancestor::button")
	WebElement btnChangePackage;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.changeTVPackage']")
	WebElement btnManageChannelAndThemePack;

	@FindBy(xpath = "(//div[@class='tv-bundle-offer'])[1]")
	WebElement lowestTvPackage;


	@FindBy(xpath = "(//span[@ng-reflect-translate='global.cta.select' ]/ancestor::button)[2]")
	WebElement secondLowestTvPackage;

	//@FindBy(xpath = "(/div[@class='internet-tile__body'])[1]//span[text()='Select' or text()='Sélectionner']/ancestor::button")
	@FindBy(xpath = "(//span[contains(text(),'Select')]/ancestor::button)[1]")
	WebElement btnSelectLowestTvPackage;


	@FindBy(xpath = "(//div[@class='tv-bundle-offer'])[2]//following-sibling::button[@translate='global.cta.select']")
	WebElement btnSelectSecondLowestTvPackage;


	@FindBy(xpath = "//button[@class='a-btnPrimary float-right ng-tns-c39-10 ng-star-inserted']")
	WebElement btnContinueChangeTvPackage;

	@FindBy(xpath = "//div[@class='in-package-flag ng-star-inserted']")
	WebElement freeWithThisBundle;

	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement btnContinueOn4kTv;

	@FindBy(xpath = "//p[text()='Select Change Date']/ancestor::div//span[text()='Continue']")
	WebElement btnContinueChangeDate;

	@FindBy(xpath = "//div[@class='rch-modal']//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnContinueOn4kTVPack;


	@FindBy(xpath = "(//span[text()='Continuer' or text()='Continue']/ancestor::button)[2]")
	WebElement btnContinueOn4kChannelPack;

	@FindBy(xpath = "(//div[@class='ds-radioButton__outerCircle my-12'])[2]")
	WebElement btnImmediateBill;

	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement orderConfirmation;

	@FindBy(xpath = "//div[@class='mini-cart-ss']//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement minicartContinue;

	@FindBy(xpath = "//span[contains(text(),'Exchange later') or contains(text(),'Échanger plus tard')]/ancestor::button")
	WebElement exchangeLater;

	@FindBy(xpath = "//button[@rchtrackclickevent='exchangeLater']")
	WebElement ExchangeLaterBtn;

	@FindBy(xpath = "//span[text()='Continue' or text()='Continuer']")
	WebElement continueChannlesAndThemePacks;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.manageChannelsAndThemePacks.buttonName']")
	WebElement manageChannelsAndThemeparks;

	@FindBy(xpath = "//button[@translate='global.cta.tabs.channels']")
	WebElement channelsTab;

//	@FindBy(xpath = "//div[@role='tablist'] | //button[@ng-reflect-translate='global.cta.tabs.themePacks']")
//	WebElement goToChannelOrThemepackTabs;

	@FindBy(xpath = "(//span[@translate='global.cta.add']/ancestor::button)[2]")
	WebElement addChannel;

	@FindBy(xpath = "(//label[@class='ds-radioLabel d-inline-flex align-items-start'])[2]")
	WebElement immediateDateChange;

	@FindBy(xpath = "//span[text()='Cancel' or text()='Annuler']/ancestor::button | //button[@title='close']")
	WebElement cancel;

	@FindBy(xpath = "//span[@translate='global.label.reviewAddons']")
	WebElement reviewAddOns;

	@FindBy(xpath = "//span[@translate='global.cta.reviewAddonsLink']")
	WebElement addOnLink;


	@FindBy(xpath = "//ds-modal[@identifier='planChangeDateModal']/descendant::span[@translate='global.cta.continue']")
	WebElement continueChangeDate;

	@FindBy(xpath = "//span[text()='Exchange Flex Channels' or text()='Échanger chaînes flexibles']/ancestor::button")
	WebElement ExchangeFlexChannels;

	@FindBy(xpath = "//span[@translate='global.cta.tabs.themePacks']")
	WebElement themePacksTab;

	@FindBy(xpath = "//div[@class='channels-container themepack-detail']/descendant::span[@translate='global.cta.add']")
	WebElement addThemepack;

	@FindBy(xpath = "(//div[@class='with-question']/descendant::button)[1]")
	WebElement continueToAddThemepack;

	@FindBy(xpath = "//span[contains(text(), 'Your Changes')]")
	WebElement yourChanges;

	@FindBy(xpath = "//h3[@translate='global.dashboard.tv.customerHasTheFollowing']")
	WebElement existingPackages;

	@FindBy(xpath = "(//span[@translate='global.cta.addToCart']/ancestor::button)[1]")
	WebElement callingAddToCart;


	@FindBy(xpath = "(//span[@ng-reflect-translate='global.modals.conflictWarnings'])[1] | //span[text()='Oui, continuer' or text()='Yes, continue']/ancestor::button")
	WebElement yesToContinue;


//	String dollarAmount = "//div[@class='ect-body']/descendant::div[@class='ds-price__amountDollars text-semi ng-star-inserted']";
//	String centsAmount = "(//div[@class='ect-body']/descendant::span[@class='ds-price__amountCents text-body mb-0 ng-star-inserted'])";


	String existingChannels = "(//h4[@translate='global.dashboard.tv.manageChannelsAndThemePacks.vpAlacartes']/parent::div/following-sibling::div/descendant::span[text()='Remove'])";
	String existingThemepacks = "(//h4[@translate='global.dashboard.tv.manageChannelsAndThemePacks.vpThemepacks']/parent::div/following-sibling::div/descendant::span[text()='Remove'])";

	@FindAll({
			@FindBy(xpath = "//div[@class='add-remove-themepack__name']")})
	List<WebElement> existingThemepackNames;

	@FindBy(xpath = "//h4[contains(@translate,'manageChannelsAndThemePacks.vpThemepacks')]")
	WebElement existingThemepackSection;


	@FindBy(xpath = "//div[@class='cart-removed-list']//div[@class='add-remove-themepack__name']")
	WebElement removedItems;

	@FindBy(xpath = "//span[contains(@translate,'global.cta.continue') or contains(text(),'Continuer')]")
	WebElement yourChangeContinue;

	@FindBy(xpath = "(//span[@translate='global.cta.select'])[1]")
	WebElement selectFirstChannel;

	@FindBy(xpath = "//span[contains(text(),'View my Flex Channels')]")
	WebElement ViewMyFlexChannelsLink;

	@FindBy(xpath = "//label[text()='What is Cloud Storage?']/parent::div/ds-popover")
	WebElement CloudStorageBubble;

	@FindBy(xpath = "//label[text()='What is Download & Go?']/parent::div/ds-popover")
	WebElement DownloadGoBubble;

	@FindBy(xpath = "//button[@title='Reset purchase PIN']/span")
	WebElement ResetPurchasePin;

	//@FindBy(xpath = "//span[contains(text(),'Reset purchase PIN') or contains(text(),'Réinitialisez le NIP d’achat')]")
	@FindBy(xpath = "//span[contains(text(),'Reset purchase PIN') or contains(text(),'Réinitialisez le NIP d’achat')]/ancestor::button")
	WebElement resetPurchasePin;

	@FindBy(xpath = "//button[@rchtrackclickevent='themepacks']")
	WebElement addThemepackFromBundle;


	@FindBy(xpath = "//*[text()='View offers']")
	WebElement viewOffer;

	@FindBy(xpath = "//*[text()='BEST']/following::*[text()='Select']/ancestor::button")
	WebElement recommendedOffer;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']/ancestor::button")
	WebElement closeButton;

	@FindBy(xpath = "//*[text()='Exchange now']/ancestor::button")
	WebElement exchangeNow;


	@FindBy(xpath = "//*[text()='Select']")
	WebElement selectChannel;

	@FindBy(xpath = "//*[text()=' I have reviewed all issues with the customer. ']/ancestor::button")
	WebElement reviewedIssuesWithCustomer;


	@FindBy(xpath = "//*[text()='No, they don’t']")
	WebElement noTheyDontBtn;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueBottomOfPage;

	@FindBy(xpath = "//span[text()='View my channel lineup' or text()='Voir ma liste de chaînes']")
	WebElement viewMyChannelLineUpLink;

	@FindBy(xpath = "//button[@id='cl-65619']")
	WebElement removeChannel;

	@FindBy(xpath = "//button[@id='cl-73142']")
	WebElement addChannelBtn;

	@FindBy(xpath = "//span[text()='Change package']")
	WebElement changePackageBtnEN;

	@FindBy(xpath = "//span[text()='Changer de forfait']")
	WebElement changePackageBtnFR;

	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted'] | //span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContnue;

	@FindBy(xpath = "//p[@class='ds-modal__heading mb-24 text-title-3']/following::*[text()='Cancel']")
	WebElement cancelOrder;

	@FindBy(xpath = "//div[@class='ng-tns-c166-12'] | //span[text()='Package Details' or text()='Détails du forfait']")
	WebElement packageDetailsExpander;

	@FindBy(xpath = "//li[contains(text(),'Download speeds') or contains(text(),'Location de la passerelle')]")
	WebElement downloadSpeed;

	@FindBy(xpath = "//li[contains(text(),'Upload speeds') or contains(text(),'Vitesses de téléversement')]")
	WebElement uploadSpeed;


	/**
	 * Get list of all channels and themepacks and remove them one by one
	 *
	 * @author Aditi.jain
	 */
	public void getAllChannelAndThemepacks() {
		WebElement banner = getReusableActionsInstance().getWhenReady(existingPackages, 180);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, banner.getLocation().y - 300);

		List<WebElement> allExistingChannels = getDriver().findElements(By.xpath(existingChannels));
		List<WebElement> allExistingThemepacks = getDriver().findElements(By.xpath(existingThemepacks));
		for (int i = 0; i < allExistingChannels.size(); i++) {
			WebElement channel = getReusableActionsInstance().getWhenReady(By.xpath(existingChannels + "[1]"));
			getReusableActionsInstance().executeJavaScriptClick(channel);
		}
		for (int i = 0; i < allExistingThemepacks.size(); i++) {
			WebElement themepack = getReusableActionsInstance().getWhenReady(By.xpath(existingThemepacks + "[1]"));
			getReusableActionsInstance().executeJavaScriptClick(themepack);
		}
	}

	/**
	 * Click Add to Cart for calling package
	 *
	 * @author Aditi.jain
	 */
	public void addToCartCallingPackage() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(callingAddToCart, 60);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(callingAddToCart);
	}

	/**
	 * Click Add Themepack
	 *
	 * @author Aditi.jain
	 */
	public void addThemepack() {
		getReusableActionsInstance().waitForElementVisibility(addThemepack, 300);
		getReusableActionsInstance().executeJavaScriptClick(addThemepack);
		/*if (getReusableActionsInstance().isElementVisible(yesToContinue, 120)) {
			getReusableActionsInstance().clickWhenReady(yesToContinue);
		}*/
	}

	/**
	 * click AddOn notification if available
	 *
	 * @author Aditi.jain
	 */
	public void clickAddOnIfPresent() {
		if (getReusableActionsInstance().isElementVisible(reviewAddOns, 120)) {
			getReusableActionsInstance().waitForElementVisibility(addOnLink, 120);
			getReusableActionsInstance().executeJavaScriptClick(addOnLink);
		}
	}

	/**
	 * To click Manage channels and themeparks
	 *
	 * @author Aditi.jain
	 */
	public void clickManageChannelsAndThemepacks() {
		//TODO: Put a comment on timeout
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(manageChannelsAndThemeparks, 60);
		getReusableActionsInstance().scrollToElement(manageChannelsAndThemeparks);
		getReusableActionsInstance().javascriptScrollByVisibleElement(manageChannelsAndThemeparks);
		getReusableActionsInstance().waitForElementVisibility(manageChannelsAndThemeparks, 60);
		getReusableActionsInstance().executeJavaScriptClick(manageChannelsAndThemeparks);
	}


	/**
	 * To click Click Channel Tab
	 *
	 * @author Aditi.jain
	 */
	public void clickThemepacksTab() {

//		if (getReusableActionsInstance().isElementVisible(cancel)) {
//			clickCancel();
//		}
		getReusableActionsInstance().waitForElementVisibility(themePacksTab, 45);
		getReusableActionsInstance().scrollToElement(themePacksTab);
		getReusableActionsInstance().executeJavaScriptClick(themePacksTab);
//		getReusableActionsInstance().getWhenReady(themePacksTab, 30).click();
	}

	/**
	 * Click Continue from date change
	 *
	 * @author Aditi.jain
	 */
	public void continueFromChangeDate() {
		getReusableActionsInstance().waitForElementVisibility(continueChangeDate, 45);
		getReusableActionsInstance().executeJavaScriptClick(continueChangeDate);

	}

	/**
	 * To click Click Channel Tab
	 *
	 * @author Aditi.jain
	 */
	public void clickChannelTab() {
		getReusableActionsInstance().waitForElementVisibility(channelsTab, 60);
		getReusableActionsInstance().scrollToElement(channelsTab);
//		getReusableActionsInstance().getWhenReady(channelsTab, 30).click();
		getReusableActionsInstance().executeJavaScriptClick(channelsTab);
	}

	/**
	 * To click add channel
	 *
	 * @author Aditi.jain
	 */
	public void clickAddChannel() {
		WebElement bTn = getReusableActionsInstance().getWhenReady(addChannel, 90);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, bTn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(addChannel, 60).click();
		getReusableActionsInstance().staticWait(3000);
	}


	/**
	 * continue making more selections
	 *
	 * @author aditi.jain
	 */
	public void clickYourChanges() {
		getReusableActionsInstance().waitForElementVisibility(yourChanges);
		getReusableActionsInstance().executeJavaScriptClick(yourChanges);
	}


	/**
	 * Clicks continue on change TV package
	 *
	 * @author aditi.jain
	 */
	public void clickYesContinueIfPresent() {
		if (getReusableActionsInstance().isElementVisible(yesToContinue, 30)) {
			getReusableActionsInstance().getWhenReady(yesToContinue).click();
		}

	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author chinnarao.vattam
	 */
	public void clickContinueForPackage() {
		getReusableActionsInstance().waitForElementVisibility(btnContnueReset, 60);
		getReusableActionsInstance().getWhenReady(btnContnueReset, 30).click();
	}

	/**
	 * Click immediate date change
	 *
	 * @author Aditi.jain
	 */
	public void immediateDateChangeOption() {
		getReusableActionsInstance().waitForElementVisibility(immediateDateChange, 90);
		getReusableActionsInstance().getWhenReady(immediateDateChange, 45).click();
	}

	/**
	 * Click conitnue to add channel
	 *
	 * @author Aditi.jain
	 */
	public void clickCancel() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(cancel);
		getReusableActionsInstance().getWhenReady(cancel, 60).click();
	}

	/**
	 * Clicks submit button for changing the TV package
	 *
	 * @return true if the element is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean clickSubmit() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().getWhenReady(btnSubmit, 60).click();
		return getReusableActionsInstance().isElementVisible(orderConfirmation);
	}

	/**
	 * Clicks select the lowest TV package available
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSelectLowestTVPackage() {
		WebElement btn = getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60);
		//getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		//getReusableActionsInstance().javascriptScrollByVisibleElement(btnSelectLowestTvPackage);
		getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60).click();
	}

	/*
	 * To Select the TV package based on the inputted package name
	 * @author suganya P
	 * */
	public void selectTVPackage(String strPackageNameEn, String strPackageNameFr) {
		//getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		//getReusableActionsInstance().staticWait(5000);
		//getReusableActionsInstance().waitForElementVisibility(btnSelectChannel, 90);
		//By packageNameLocator = By.xpath("//span[contains(text(),'" + strPackageNameEn + "')or contains(text(),'" + strPackageNameFr + "')]/parent::div/following-sibling::div[@class='internet-tile__body']//span[text()='Select'or text()='Sélectionner']/ancestor::button");
		By packageNameLocator = By.xpath("//div[contains(text(),'" + strPackageNameEn + "')or contains(text(),'" + strPackageNameFr + "')]/ancestor::div[3]/following-sibling::div/rch-bundle-price/child::div/child::div[3]/child::button");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 30);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author chinnarao.vattam
	 */
	public void clickContinueChangeTVPackage() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author chinnarao.vattam
	 */
	public void clickContinue4kChannelPack() {
		getReusableActionsInstance().getWhenReady(btnContinueOn4kChannelPack, 60).click();
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate, 120);
	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author jarmanjeet.batth
	 */

	public void clickContinueToCancelOrder() {
		getReusableActionsInstance().getWhenReady(btnContinueOn4kChannelPack, 60).click();
	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author chinnarao.vattam
	 */
	public void clickContinueOn4kTv() {
		if (getReusableActionsInstance().isElementVisible(btnContinueOn4kTv, 120))
			getReusableActionsInstance().getWhenReady(btnContinueOn4kTv, 60).click();
	}

	/**
	 * Clicks continue on change TV package
	 *
	 * @author chinnarao.vattam
	 */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate, 60);
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate, 20).click();
	}

	/**
	 * Clicks Exchange flex channels button
	 *
	 * @author chinnarao.vattam
	 */
	public void clickExchangeFlexChannels() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(btnExchangeFlexChannels, 60);
//		WebElement btn=getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels,80);
//		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
//		getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels, 60).click();
//		getReusableActionsInstance().waitForElementVisibility(btnFirstChannelToRemove, 120);
	}

	/**
	 * Clicks search icon on the channels to remove section
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSearchChannelToRemove() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToRemove, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToRemove, 30).click();

	}

	/**
	 * Clicks first channel available in the list to be removed
	 *
	 * @author chinnarao.vattam
	 */
	public void clickFirstChannelToRemove() {
		WebElement bTn = getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, bTn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 60).click();
	}

	/**
	 * Clicks Second channel available in the list to be removed
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSecondChannelToRemove() {
		WebElement bTn = getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, bTn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60).click();
	}

	/**
	 * Clicks select button on the channel to remove section
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSelectChannelRemove() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnSelectChannel, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 60).click();
	}

	/**
	 * Clicks Change TV Package  button on the TV dashboard
	 *
	 * @author chinnarao.vattam
	 */
	public void clickChangePackage() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnChangePackage, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnChangePackage, 120).click();
	}


	/**
	 * Clicks select button on the channel to Add section
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSelectChannelAdd() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnSelectChannel, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 120).click();
	}


	/**
	 * Clicks search icon on the channels to add section
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSearchChannelToAdd() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToAdd, 120).click();

	}

	/**
	 * Clicks first channel available in the list to be added
	 *
	 * @author chinnarao.vattam
	 */
	public void clickFirstChannelToAdd() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120).click();
	}

	/**
	 * Clicks Second channel available in the list to be added
	 *
	 * @author chinnarao.vattam
	 */
	public void clickSecondChannelToAdd() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120).click();
	}

	/**
	 * Clicks Confirm Exchange buttton
	 *
	 * @param strBrowser is the browser to be run
	 * @author chinnarao.vattam
	 */
	public void clickConfirmExchange(String strBrowser) {
		WebElement select = getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120).click();
	}

	/**
	 * Verifies if the Exchange flex channels section is loaded correctly or not
	 *
	 * @return true if the element is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyExchangeFlexChannelIsLoaded() {
		getReusableActionsInstance().waitForElementInvisibility(popUpFlexChannelLoader, 120);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToRemove, 120);
		return getReusableActionsInstance().isElementVisible(icnSearchChannelToRemove, 120);
	}

	/**
	 * Verify the result
	 *
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkUsingVoiceCommands() {
		getReusableActionsInstance().waitForElementVisibility(lnkUsingVoiceCommands, 120);
		return getReusableActionsInstance().isElementVisible(lnkUsingVoiceCommands);
	}

	/**
	 * Clicks back to overview button which brings user back to account overview page
	 *
	 * @author chinnarao.vattam
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview, 120).click();
	}

	/**
	 * Clicks view channel line up button
	 *
	 * @author chinnarao.vattam
	 */
	public void clickViewChannelLineUp() {
		WebElement btn = getReusableActionsInstance().getWhenReady(btnViewChannelLineUp, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
//		getReusableActionsInstance().clickWhenReady(btnViewChannelLineUp, 120);
		getReusableActionsInstance().getWhenReady(btnViewChannelLineUp, 60).click();
	}

	/**
	 * Clicks view pdf on channel line up
	 *
	 * @author chinnarao.vattam
	 */
	public void clickViewPdf() {
		String handle = getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(icnViewPdf, 120).click();
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().switchToNewWindow(handle);
		getReusableActionsInstance().staticWait(6000);
	}

	/**
	 * Verify the presence of view pdf on channel line up
	 *
	 * @return true if the element is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyViewPdf() {
		return getReusableActionsInstance().isElementVisible(icnViewPdf, 120);

	}

	/**
	 * Click the parental Control button to reset
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clickResetParentalControl() {
		WebElement btn = getReusableActionsInstance().getWhenReady(btnResetParentalControl, 240);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnResetParentalControl, 120).click();
	}

	/**
	 * Verify the rest success
	 *
	 * @return true if reset is successful, else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyResetSuccess() {
		return getReusableActionsInstance().isElementVisible(imgSuccess, 120);
	}

	/**
	 * Click "Ok" on success popup
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clickSuccessOk() {
		getReusableActionsInstance().getWhenReady(btnSuccessOk, 120).click();
	}

	/**
	 * Verify the header availability
	 *
	 * @return true if header is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyHeader() {
		getReusableActionsInstance().waitForElementVisibility(icnHeader, 120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}

	/**
	 * Verify the footer availability
	 *
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFooter() {

		return getReusableActionsInstance().isElementVisible(icnFooter, 120);
	}

	/**
	 * submit the parental Control for reset
	 *
	 * @author Chinnarao.Vattam
	 */
	public void clickRestartSetupbox() {
		getReusableActionsInstance().waitForElementVisibility(btnRestartSetupbox, 240);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnRestartSetupbox);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnRestartSetupbox, 120).click();
	}

	/**
	 * submit the parental Control for reset
	 *
	 * @author chinnarao.vattam
	 */
	public void clickCustForgotPurchasePin() {
		getReusableActionsInstance().waitForElementVisibility(icnCustForgotPurchasePin, 240);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().javascriptScrollByVisibleElement(icnCustForgotPurchasePin);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().executeJavaScriptClick(icnCustForgotPurchasePin);
	}

	/**
	 * submit the parental Control for reset
	 *
	 * @author Chinnarao.Vattam
	 */

	public void clickContinueReset() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 120).click();
	}

	/**
	 * click OK Button
	 *
	 * @author chinnarao.vattam
	 */

	public void clickOK() {
		getReusableActionsInstance().getWhenReady(btnOk, 120).click();
	}

	/**
	 * Verify the result
	 *
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkIntroToAppsOnIgniteTv() {
		getReusableActionsInstance().waitForElementVisibility(lnkIntroToAppsOnIgniteTv, 120);
		return getReusableActionsInstance().isElementVisible(lnkIntroToAppsOnIgniteTv);
	}

	/**
	 * Verify the result
	 *
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkFAQOnPowerSaver() {
		getReusableActionsInstance().waitForElementVisibility(lnkFAQOnPowerSaver, 120);
		return getReusableActionsInstance().isElementVisible(lnkFAQOnPowerSaver);
	}

	/**
	 * Verify the result
	 *
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkIgniteTvErrCode() {
		getReusableActionsInstance().waitForElementVisibility(lnkIgniteTvErrCode, 120);
		return getReusableActionsInstance().isElementVisible(lnkIgniteTvErrCode);
	}

	/**
	 * Verify the result
	 *
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkGoToSupportSection() {
		getReusableActionsInstance().waitForElementVisibility(lnkGoToSupportSection, 120);
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection);
	}

	/**
	 * Go to Page bottom
	 *
	 * @author chinnarao.vattam
	 */
	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}

	/**
	 * Go to Page bottom
	 *
	 * @author chinnarao.vattam
	 */
	public void goToPageMid() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		;
	}

	/*
	 *To select immediate billing option
	 * @author suganya.p
	 * */
	public void clickImmediateBill() {
		getReusableActionsInstance().getWhenReady(btnImmediateBill, 60).click();
	}

	/*
	 * To select Exchange later in channel personalisation page
	 * @author suganya p
	 * */
	public void clickExchangeLater() {
		//getReusableActionsInstance().staticWait(5000);
		WebElement btn = getReusableActionsInstance().getWhenReady(exchangeLater, 240);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().executeJavaScriptClick(exchangeLater);
	}

	/*
	 * To click on Continue in Channels and Theme pack page
	 * @author suganya P
	 * */
	public void clickContinueChannelsAndThemePacks() {
		getReusableActionsInstance().getWhenReady(continueChannlesAndThemePacks, 60).click();

	}

	/*To check for the existing themepacks
	 * @suganya p*/
	public boolean verifyExistingThemepack() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(existingThemepackSection, 90);
		return getReusableActionsInstance().isElementVisible(existingThemepackSection);
	}

	/*To get the count of added number of themepacks
	 * @suganya p*/
	public int getExistingThemepackCount() {
		return existingThemepackNames.size();
	}

	/*To list the names of existing themepacks
	 * @suganya p*/
	public List getExistingThemepackNames() {
		List packnames = new LinkedList();

		for (int i = 0; i < existingThemepackNames.size(); i++) {
			WebElement themepack = existingThemepackNames.get(i);
			packnames.add(i, themepack.getText());
		}
		return packnames;
	}


	/*To remove the specifed themepack
	 * @suganya p*/
	public void removeThemepack(String themepackNameEn, String themepackNameFr) {
		By removeThemepack = By.xpath("//div[contains(text(),'" + themepackNameEn + "') or contains(text(),'" + themepackNameFr + "')]/parent::div//button/span");
		//getReusableActionsInstance().clickWhenReady(removeThemepack,120);

		WebElement btn = getReusableActionsInstance().getWhenReady(removeThemepack, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(removeThemepack, 90).click();
	}

	/*To verify the your change section and expanding it if not
	 * @author suganya p*/
	public boolean verifyYourChangeSection() {
		return getReusableActionsInstance().isElementVisible(yourChanges, 30);
	}

	/*To click on continue in the your chnage section
	 * @author suganya p*/
	public void yourChangeContinue() {
			/*if (getReusableActionsInstance().isElementVisible(removedItems, 60)) {
				getReusableActionsInstance().clickWhenReady(yourChangeContinue);
			} else {*/
		//	getReusableActionsInstance().clickWhenReady(yourChanges);
		getReusableActionsInstance().clickWhenReady(yourChangeContinue, 60);
		//}
	}

	/*
	 * Select first TV package
	 * @author aditi.jain
	 * */
	public void selectFirstTVPackage() {
		getReusableActionsInstance().waitForElementVisibility(selectFirstChannel, 45);
		getReusableActionsInstance().executeJavaScriptClick(selectFirstChannel);
	}

	public void clickViewMyFlexChannelsLink() {
		getReusableActionsInstance().clickWhenReady(ViewMyFlexChannelsLink);
	}

	public void clickCloudStorageBubble() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(CloudStorageBubble);
	}

	public void clickDownloadGoBubble() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(DownloadGoBubble);

	}

	public void clickResetPurchasePin() {

		getReusableActionsInstance().waitForElementVisibility(resetPurchasePin, 30);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().javascriptScrollByVisibleElement(resetPurchasePin);
		getReusableActionsInstance().getWhenReady(resetPurchasePin, 30).click();
	}

	public void clickSecondLowestpackage() {
		//getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().getWhenReady(secondLowestTvPackage, 30);
		getReusableActionsInstance().executeJavaScriptClick(secondLowestTvPackage);
	}

	public void SelectLowestPackage() {
		getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage);
		getReusableActionsInstance().executeJavaScriptClick(btnSelectLowestTvPackage);
	}

	/**
	 * Click Add Themepack
	 *
	 * @author Aditi.jain
	 */
	public void clickThemepackTabFromBundle() {
		getReusableActionsInstance().waitForElementVisibility(addThemepackFromBundle, 300);
		getReusableActionsInstance().executeJavaScriptClick(addThemepackFromBundle);
	}

	public void ScrolltoConfirmExchangeBtn() {
		getReusableActionsInstance().scrollToElement(btnConfirmExchange);
	}

	public void clkExchangeFlexChannels() {
		//getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().getWhenReady(ExchangeFlexChannels, 30);
		getReusableActionsInstance().executeJavaScriptClick(ExchangeFlexChannels);
	}

	public void clickViewOffers() {
		getReusableActionsInstance().staticWait(20);
		//getReusableActionsInstance().waitForElementVisibility(viewOffer, 30);
		getReusableActionsInstance().executeJavaScriptClick(viewOffer);
	}

	public void selectRecommendedOffer() {
		getReusableActionsInstance().waitForElementVisibility(recommendedOffer, 30);
		getReusableActionsInstance().executeJavaScriptClick(recommendedOffer);
	}

	public boolean verifyRecommendedOffer() {
		return getReusableActionsInstance().isElementVisible(recommendedOffer, 30);
	}

	public void clickViewDetails(String strPackageNameEn, String strPackageNameFr) {
		By packageNameLocator = By.xpath("//div[contains(text(),'" + strPackageNameEn + "')or contains(text(),'" + strPackageNameFr + "')]/ancestor::div[3]/following-sibling::div/rch-bundle-price/child::div/child::div[3]/child::button/parent::div/following-sibling::div/child::button");
		WebElement btn = getReusableActionsInstance().getWhenReady(packageNameLocator, 30);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	public void clickCloseButton() {
		getReusableActionsInstance().waitForElementVisibility(closeButton, 30);
		getReusableActionsInstance().executeJavaScriptClick(closeButton);
	}

	public void clickExchangeNow() {
		WebElement btn = getReusableActionsInstance().getWhenReady(exchangeNow, 30);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().executeJavaScriptClick(exchangeNow);
	}


	public void clickSelectChannel() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(selectChannel, 30);
		getReusableActionsInstance().executeJavaScriptClick(selectChannel);


	}

	public void clickReviewedAllIssuesWithCustomer() {
		getReusableActionsInstance().waitForElementVisibility(reviewedIssuesWithCustomer, 30);
		getReusableActionsInstance().executeJavaScriptClick(reviewedIssuesWithCustomer);


	}

	public void clickNoTheyDont() {
		//getReusableActionsInstance().waitForElementVisibility(noTheyDontBtn, 20);
		getReusableActionsInstance().clickWhenReady(noTheyDontBtn);


	}

	public void clickContinueBottomOfPage() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(continueBottomOfPage, 30);
		getReusableActionsInstance().clickWhenReady(continueBottomOfPage);


	}

	public boolean verifyManageChannelsAndThemePacks() {
		return getReusableActionsInstance().isElementVisible(manageChannelsAndThemeparks, 30);
	}

	public boolean verifyExchangeFlexChannels() {
		return getReusableActionsInstance().isElementVisible(btnExchangeFlexChannels, 30);
	}

	public boolean verifyChangeTvPackage() {
		return getReusableActionsInstance().isElementVisible(btnChangePackage, 30);
	}

	public boolean verifyRestartSetUpBox() {
		return getReusableActionsInstance().isElementVisible(btnRestartSetupbox, 30);
	}

	public boolean verifyResetPurchasePin() {
		return getReusableActionsInstance().isElementVisible(resetPurchasePin, 30);
	}

	public boolean verifyResetParentalControl() {
		return getReusableActionsInstance().isElementVisible(btnResetParentalControl, 30);
	}

	public boolean verifyViewMyFlexChannelsLink() {
		return getReusableActionsInstance().isElementVisible(viewMyChannelLineUpLink, 30);
	}

	public boolean verifyViewMyChannelLineUpLink() {
		return getReusableActionsInstance().isElementVisible(viewMyChannelLineUpLink, 30);
	}

	public void clickRemoveChannel() {
		WebElement btn = getReusableActionsInstance().getWhenReady(removeChannel, 30);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 100);
		getReusableActionsInstance().waitForElementVisibility(removeChannel, 30);
		getReusableActionsInstance().executeJavaScriptClick(removeChannel);


	}

	public void clickAddChannelBtn() {
		WebElement btn = getReusableActionsInstance().getWhenReady(addChannelBtn, 30);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 100);
		getReusableActionsInstance().waitForElementVisibility(addChannelBtn, 30);
		getReusableActionsInstance().executeJavaScriptClick(addChannelBtn);


	}

	public boolean verifyChangePackageButtonEN() {
		WebElement btn = getReusableActionsInstance().getWhenReady(changePackageBtnEN, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().waitForElementVisibility(changePackageBtnEN, 30);
		return getReusableActionsInstance().isElementVisible(changePackageBtnEN);
	}

	public boolean verifyChangePackageButtonFR() {
		WebElement btn = getReusableActionsInstance().getWhenReady(changePackageBtnFR, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().waitForElementVisibility(changePackageBtnFR, 30);
		return getReusableActionsInstance().isElementVisible(changePackageBtnFR);
	}

	public void clickContinue() {
		getReusableActionsInstance().getWhenReady(btnContnue, 30).click();
	}

	public void clickPackageDetailsExpander() {

		getReusableActionsInstance().getWhenReady(packageDetailsExpander, 30);
		getReusableActionsInstance().executeJavaScriptClick(packageDetailsExpander);
	}

	/**
	 * Verifies download and upload speed whether symmetrical or not
	 *
	 * @author jasmeen.kaur
	 */
	public boolean verifyDownloadAndUploadSpeed() {
		getReusableActionsInstance().scrollToElement(downloadSpeed);
		getReusableActionsInstance().scrollToElement(uploadSpeed);
		String download = getReusableActionsInstance().getElementText(downloadSpeed);
		String upload = getReusableActionsInstance().getElementText(uploadSpeed);
		String[] d1 = download.split(":");
		System.out.println(d1[1]);
		String[] u1 = upload.split(":");
		System.out.println(u1[1]);
		Boolean areEqual = d1[1].equals(u1[1]);
		if (areEqual) {
			System.out.println("Download and Upload speed Symmetrical");
			return true;
		} else {
			System.out.println("Download and Upload speed is not Symmetrical");
			return false;
		}
	}

	public boolean verifyContinueAndCancelButton() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().isElementVisible(cancel);
		getReusableActionsInstance().isElementVisible(btnContnueReset);
		return true;
	}
}









