package com.rogers.oneview.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import com.rogers.pages.base.BasePageClass;

import java.util.ArrayList;
import java.util.List;

public class TVDashboardPage  extends BasePageClass {

	public TVDashboardPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.resetParen']/ancestor::button")
	WebElement btnResetParentalControl;

	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.resetOnDem']")
	WebElement icnCustForgotPurchasePin;

	@FindBy(xpath = "//button[@rchtrackclickevent='generatePDF']")
	WebElement icnViewPdf;


	@FindBy(xpath = "//span[text()='View my channel lineup' or text()='Voir ma liste de chaînes']/ancestor::button")
	WebElement btnViewChannelLineUp;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContnueReset;

	@FindBy(xpath = "//div[@class='ds-modal__header d-flex align-items-start']")
	WebElement imgSuccess;

	@FindBy(xpath = "//div[contains(text(),'Success!')]")
	WebElement txtSuccess;

	@FindBy(xpath = "//button[@class='btn_s100 ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large ng-star-inserted']")
	WebElement btnSuccessOk;

	@FindBy(xpath = "//span[text()='OK']/ancestor::button")
	WebElement btnOk;

	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.restartWir']")
	WebElement btnRestartSetupbox;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnHeader;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnFooter;

	@FindBy(xpath = "//div[@class='second-level-nav__cta']//button[@class='b-linkCta']")
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

//	@FindBy(xpath = "(//div[@class='exchange-container x-out']//button[@role='button'])[1] | (//h4[@translate='global.dashboard.tv.manageChannelsAndThemePacks.vpAlacartes']/parent::div/following-sibling::div/descendant::span[text()='Remove'])[1]")
	@FindBy(xpath = "(//h4[@translate='global.dashboard.tv.manageChannelsAndThemePacks.vpAlacartes']/parent::div/following-sibling::div/descendant::span[text()='Remove'])[1]")
	WebElement btnFirstChannelToRemove;

	@FindBy(xpath = "(//div[@class='exchange-container x-out']//button[@role='button'])[3]")
	WebElement btnSecondChannelToRemove;

	@FindBy(xpath = "//span[text()='Sélectionner' or text()='Select']/ancestor::button")
	WebElement btnSelectChannel;

	@FindBy(xpath = "(//div[@class='col-12 exchange-channels-grid'])[2]//i[@class='rch-icon-search' and @_ngcontent-c33='']")
	WebElement icnSearchChannelToAdd;

	@FindBy(xpath = "(//div[@class='exchange-container x-in']//button[@role='button'])[1]")
	WebElement btnFirstChannelToAdd;

	@FindBy(xpath = "(//div[@class='exchange-container x-in']//button[@role='button'])[3]")
	WebElement btnSecondChannelToAdd;

	@FindBy(xpath = "//span[text()='Confirmer l’échange' or text()='Confirm exchange']/ancestor::button")
	WebElement btnConfirmExchange;

	@FindBy(xpath = "//span[text()='Exchange Flex Channels' or text()='Échanger chaînes flexibles']/ancestor::button")
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

	@FindBy(xpath = "//span[text()='Change TV package' or text()='Modifier le forfait Télé']/ancestor::button")
	WebElement btnChangeTvPackage;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.changeTVPackage']")
	WebElement btnManageChannelAndThemePack;

	@FindBy(xpath = "(//div[@class='tv-bundle-offer'])[1]")
	WebElement lowestTvPackage;


	@FindBy(xpath = "(//div[@class='tv-bundle-offer'])[2]")
	WebElement secondLowestTvPackage;

	@FindBy(xpath = "(//div[@class='internet-tile__body'])[1]//span[text()='Select' or text()='Sélectionner']/ancestor::button")
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

	@FindBy(xpath = "//div[contains(@id,'ds-radio-input-id-1-label-container')]/preceding-sibling::div[contains(@class,'ds-radioButton')]")
	WebElement btnImmediateBill;

	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement orderConfirmation;

	@FindBy(xpath = "//div[@class='mini-cart-ss']//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement minicartContinue;

	@FindBy(xpath="//span[contains(text(),'Exchange later') or contains(text(),'Échanger plus tard')]/ancestor::button")
	WebElement exchangeLater;

	@FindBy(xpath="//span[@ng-reflect-translate='global.cta.continue']/ancestor::button")
	WebElement continueChannlesAndThemePacks;

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.manageChannelsAndThemePacks.buttonName']")
	WebElement manageChannelsAndThemeparks;

	@FindBy(xpath = "//button[@translate='global.cta.tabs.channels']")
	WebElement channelsTab;

	@FindBy(xpath = "//div[@role='tablist']")
	WebElement goToChannelOrThemepackTabs;

	@FindBy(xpath = "(//span[@translate='global.cta.add']/ancestor::button)[2]")
	WebElement addChannel;

	@FindBy(xpath = "(//label[@class='ds-radioLabel d-inline-flex align-items-start'])[2]")
	WebElement immediateDateChange;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
	WebElement cancel;

	@FindBy(xpath = "//span[@translate='global.label.reviewAddons']")
	WebElement reviewAddOns;

	@FindBy(xpath = "//span[@translate='global.cta.reviewAddonsLink']")
	WebElement addOnLink;


	@FindBy(xpath = "//ds-modal[@identifier='planChangeDateModal']/descendant::span[@translate='global.cta.continue']")
	WebElement continueChangeDate;


	@FindAll({
			@FindBy(xpath = "//button[@translate='global.cta.tabs.themePacks']"),
			@FindBy(xpath = "//span[contains(text(),'Theme Packs') or contains(text(), 'Forfaits à thème')]/ancestor::button")
	})
	WebElement themePacksTab;

	@FindBy(xpath = "//div[@class='themepack-detail channels-container']/descendant::span[@translate='global.cta.add']")
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


	/**
	 * Get list of all channels and themepacks and remove them one by one
	 * @author Aditi.jain
	 */
	public void getAllChannelAndThemepacks() {
		WebElement banner =getReusableActionsInstance().getWhenReady(existingPackages, 300);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,banner.getLocation().y-300);

		List<WebElement> allExistingChannels = getDriver().findElements(By.xpath(existingChannels));
		List<WebElement> allExistingThemepacks = getDriver().findElements(By.xpath(existingThemepacks));
		for (int i=0; i<allExistingChannels.size(); i++) {
			WebElement channel = getReusableActionsInstance().getWhenReady(By.xpath(existingChannels +"[1]"));
			getReusableActionsInstance().executeJavaScriptClick(channel);
		}
		for (int i=0; i<allExistingThemepacks.size(); i++) {
			WebElement themepack = getReusableActionsInstance().getWhenReady(By.xpath(existingThemepacks +"[1]"));
			getReusableActionsInstance().executeJavaScriptClick(themepack);
		}
	}

	/**
	 * Click Add to Cart for calling package
	 * @author Aditi.jain
	 */
	public void addToCartCallingPackage() {
		getReusableActionsInstance().waitForElementVisibility(callingAddToCart, 120);
		getReusableActionsInstance().javascriptScrollByVisibleElement(callingAddToCart);
		getReusableActionsInstance().getWhenReady(callingAddToCart, 120).click();
	}
	/**
	 * Click Add Themepack
	 * @author Aditi.jain
	 */
	public void addThemepack() {
		getReusableActionsInstance().waitForElementVisibility(addThemepack, 300);
		getReusableActionsInstance().executeJavaScriptClick(addThemepack);
		if(getReusableActionsInstance().isElementVisible(yesToContinue, 120)){
			getReusableActionsInstance().clickWhenReady(yesToContinue);
		}
	}

	/**
	 * click AddOn notification if available
	 * @author Aditi.jain
	 */
	public void clickAddOnIfPresent() {
		if(getReusableActionsInstance().isElementVisible(reviewAddOns, 120)){
			getReusableActionsInstance().waitForElementVisibility(addOnLink, 120);
			getReusableActionsInstance().executeJavaScriptClick(addOnLink);
		}
	}

	/**
	 * To click Manage channels and themeparks
	 * @author Aditi.jain
	 */
	public void clickManageChannelsAndThemepacks() {
		getReusableActionsInstance().waitForElementVisibility(manageChannelsAndThemeparks, 240);
		getReusableActionsInstance().scrollToElement(manageChannelsAndThemeparks);
		getReusableActionsInstance().javascriptScrollByVisibleElement(manageChannelsAndThemeparks);
		getReusableActionsInstance().executeJavaScriptClick(manageChannelsAndThemeparks);
	}

	/**
	 * To click Click Channel Tab
	 * @author Aditi.jain
	 */
	public void clickThemepacksTab() {
		getReusableActionsInstance().waitForElementVisibility(goToChannelOrThemepackTabs, 120);
		getReusableActionsInstance().scrollToElement(goToChannelOrThemepackTabs);
		if(getReusableActionsInstance().isElementVisible(cancel)){
			getReusableActionsInstance().waitForElementVisibility(cancel);
			getReusableActionsInstance().getWhenReady(cancel, 240).click();
		}
		getReusableActionsInstance().getWhenReady(themePacksTab, 120).click();
	}

	/**
	 * Click Continue from date change
	 * @author Aditi.jain
	 */
	public void continueFromChangeDate() {
		getReusableActionsInstance().waitForElementVisibility(continueChangeDate, 60);
		getReusableActionsInstance().executeJavaScriptClick(continueChangeDate);

	}
	/**
	 * To click Click Channel Tab
	 * @author Aditi.jain
	 */
	public void clickChannelTab() {
		getReusableActionsInstance().waitForElementVisibility(goToChannelOrThemepackTabs, 120);
		getReusableActionsInstance().scrollToElement(goToChannelOrThemepackTabs);
		getReusableActionsInstance().getWhenReady(channelsTab, 120).click();
	}

	/**
	 * To click add channel
	 * @author Aditi.jain
	 */
	public void clickAddChannel() {
		WebElement bTn=getReusableActionsInstance().getWhenReady(addChannel, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,bTn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(addChannel, 60).click();
		getReusableActionsInstance().staticWait(3000);
	}


	/**
	 * continue making more selections
	 * @author aditi.jain
	 */
	public void clickYourChanges() {
		getReusableActionsInstance().waitForElementVisibility(yourChanges);
		getReusableActionsInstance().executeJavaScriptClick(yourChanges);
	}

	/**
	 * Clicks continue on change TV package
	 * @author chinnarao.vattam
	 */
	public void clickContinueForPackage() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(btnContnueReset, 120);
		getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
	}
	/**
	 * Click immediate date change
	 * @author Aditi.jain
	 */
	public void immediateDateChangeOption() {
		getReusableActionsInstance().waitForElementVisibility(immediateDateChange, 90);
		getReusableActionsInstance().getWhenReady(immediateDateChange, 90).click();
	}
	/**
	 * Click conitnue to add channel
	 * @author Aditi.jain
	 */
	public void clickContinueToManageChannel() {
		getReusableActionsInstance().waitForElementVisibility(cancel);
		getReusableActionsInstance().getWhenReady(cancel, 180).click();
	}
	/**
	 * Clicks submit button for changing the TV package
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
	 * @author chinnarao.vattam
	 */
	public void clickSelectLowestTVPackage() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60).click();
				}
	/*
	* To Select the TV package based on the inputted package name
	* @author suganya P
	* */
	public void selectTVPackage(String strPackageNameEn, String strPackageNameFr) {
		getReusableActionsInstance().waitForElementVisibility(btnSelectChannel, 90);
		By packageNameLocator = By.xpath("//span[contains(text(),'"+strPackageNameEn+"')or contains(text(),'"+strPackageNameFr+"')]/parent::div/following-sibling::div[@class='internet-tile__body']//span[text()='Select'or text()='Sélectionner']/ancestor::button");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 20);
			WebElement pkg = getDriver().findElement(packageNameLocator);
			getReusableActionsInstance().executeJavaScriptClick(pkg);
		}
	/**
	 * Clicks continue on change TV package
	 * @author chinnarao.vattam
	 */
	public void clickContinueChangeTVPackage() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author chinnarao.vattam
	 */
	public void clickContinue4kChannelPack() {
		getReusableActionsInstance().getWhenReady(btnContinueOn4kChannelPack,60).click();
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate,120);
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author chinnarao.vattam
	 */
	public void clickContinueOn4kTv() {
		if(getReusableActionsInstance().isElementVisible(btnContinueOn4kTv,120))
		getReusableActionsInstance().getWhenReady(btnContinueOn4kTv,60).click();
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author chinnarao.vattam
	 */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate,60);
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate,20).click();
	   }

	/**
	 * Clicks Exchange flex channels button
	 * @author chinnarao.vattam
	 */
	public void clickExchangeFlexChannels() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels,80);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels, 60).click();
		getReusableActionsInstance().waitForElementVisibility(btnFirstChannelToRemove, 120);
		}
	
	/**
	 * Clicks search icon on the channels to remove section
	 * @author chinnarao.vattam
	 */
	public void clickSearchChannelToRemove() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToRemove,20);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToRemove, 30).click();
		
		}

	/**
	 * Clicks first channel available in the list to be removed
	 * @author chinnarao.vattam
	 */
	public void clickFirstChannelToRemove() {
		WebElement bTn=getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,bTn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 60).click();
		}
	/**
	 * Clicks Second channel available in the list to be removed
	 * @author chinnarao.vattam
	 */
	public void clickSecondChannelToRemove() {
		WebElement bTn=getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,bTn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60).click();
		}
	/**
	 * Clicks select button on the channel to remove section
	 * @author chinnarao.vattam
	 */
	public void clickSelectChannelRemove() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSelectChannel, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 60).click();
		}
	
	/**
	 * Clicks Change TV Package  button on the TV dashboard
	 * @author chinnarao.vattam
	 */
	public void clickChangeTvPackage() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnChangeTvPackage, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnChangeTvPackage, 120).click();
		}
	
	
	/**
	 * Clicks select button on the channel to Add section
	 * @author chinnarao.vattam
	 */
	public void clickSelectChannelAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSelectChannel,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 120).click();
		}


	/**
	 * Clicks search icon on the channels to add section
	 * @author chinnarao.vattam
	 */
	public void clickSearchChannelToAdd() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToAdd,120);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToAdd, 120).click();
		
		}
	
	/**
	 * Clicks first channel available in the list to be added
	 * @author chinnarao.vattam
	 */
	public void clickFirstChannelToAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120).click();
		}

	/**
	 * Clicks Second channel available in the list to be added
	 * @author chinnarao.vattam
	 */
	public void clickSecondChannelToAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120).click();
		}
	
	/**
	 * Clicks Confirm Exchange buttton 
	 * @param   strBrowser is the browser to be run 
	 * @author chinnarao.vattam
	 */
	public void clickConfirmExchange(String strBrowser) {
		WebElement select=getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120).click();
	}

	/**
	 * Verifies if the Exchange flex channels section is loaded correctly or not
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
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyLnkUsingVoiceCommands() {
		getReusableActionsInstance().waitForElementVisibility(lnkUsingVoiceCommands, 120);
		return getReusableActionsInstance().isElementVisible(lnkUsingVoiceCommands);
	}
	
	/**
	 * Clicks back to overview button which brings user back to account overview page
	 * @author chinnarao.vattam
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview, 120).click();
		}
	
	/**
	 * Clicks view channel line up button 
	 * @author chinnarao.vattam
	 */
	public void clickViewChannelLineUp() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnViewChannelLineUp,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnViewChannelLineUp,120);
	//	getReusableActionsInstance().getWhenReady(btnViewChannelLineUp, 60).click();
		}

	/**
	 * Clicks view pdf on channel line up 
	 * @author chinnarao.vattam
	 */
	public void clickViewPdf() {
		String handle=getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(icnViewPdf, 120).click();
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().switchToNewWindow(handle);
		getReusableActionsInstance().staticWait(6000);
		}
	
	/**
	 * Verify the presence of view pdf on channel line up
	 * @return true if the element is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyViewPdf() {
		return getReusableActionsInstance().isElementVisible(icnViewPdf, 120);
		
		}

	/**
	 * Click the parental Control button to reset
	 * @author Chinnarao.Vattam
	 */
	public void clickResetParentalControl() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnResetParentalControl,240);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnResetParentalControl, 120).click();
		}	

	/**
	 * Verify the rest success
	 * @return true if reset is successful, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyResetSuccess() {	
		return getReusableActionsInstance().isElementVisible(imgSuccess,120);
	}
	
	/**
	 * Click "Ok" on success popup
	 * @author Chinnarao.Vattam
	 */
	public void clickSuccessOk() {
		getReusableActionsInstance().getWhenReady(btnSuccessOk, 120).click();
		}
	
	/**
	 * Verify the header availability
	 * @return true if header is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyHeader() {	
		getReusableActionsInstance().waitForElementVisibility(icnHeader,120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}
	
	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyFooter() {
		
		return getReusableActionsInstance().isElementVisible(icnFooter,120);
	}
	
	/**
	 * submit the parental Control for reset
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
	 * @author chinnarao.vattam
	 */
	public void clickCustForgotPurchasePin() {
		getReusableActionsInstance().waitForElementVisibility(icnCustForgotPurchasePin, 240);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().javascriptScrollByVisibleElement(icnCustForgotPurchasePin);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(icnCustForgotPurchasePin, 120).click();
		}
	
	/**
	 * submit the parental Control for reset
	 * @author Chinnarao.Vattam
	 */
	
	public void clickContinueReset() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 120).click();
			}
	/**
	 * click OK Button
	 * @author chinnarao.vattam
	 */
	
	public void clickOK() {
		getReusableActionsInstance().getWhenReady(btnOk, 120).click();
			}
		
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyLnkIntroToAppsOnIgniteTv() {
		getReusableActionsInstance().waitForElementVisibility(lnkIntroToAppsOnIgniteTv, 120);
		return getReusableActionsInstance().isElementVisible(lnkIntroToAppsOnIgniteTv);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyLnkFAQOnPowerSaver() {
		getReusableActionsInstance().waitForElementVisibility(lnkFAQOnPowerSaver, 120);
		return getReusableActionsInstance().isElementVisible(lnkFAQOnPowerSaver);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyLnkIgniteTvErrCode() {
		getReusableActionsInstance().waitForElementVisibility(lnkIgniteTvErrCode, 120);
		return getReusableActionsInstance().isElementVisible(lnkIgniteTvErrCode);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyLnkGoToSupportSection() {
		getReusableActionsInstance().waitForElementVisibility(lnkGoToSupportSection, 120);
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection);
	}
	
	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */	
	public void goToPageBottom() {		
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}

	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */	
	public void goToPageMid() {		
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();;
	}
	/*
	*To select immediate billing option
	* @author suganya.p
	* */
	public void clickImmediateBill() {
		getReusableActionsInstance().getWhenReady(btnImmediateBill,60).click();
	}
	/*
	* To select Exchange later in channel personalisation page
	* @author suganya p
	* */
	public void clickExchangeLater() {
		getReusableActionsInstance().getWhenReady(exchangeLater,60).click();

	}
	/*
	* To click on Continue in Channels and Theme pack page
	* @author suganya P
	* */
	public void clickContinueChannelsAndThemePacks() {
		getReusableActionsInstance().getWhenReady(continueChannlesAndThemePacks,60).click();

	}
}

