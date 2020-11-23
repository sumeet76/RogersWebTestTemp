package com.rogers.oneview.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.rogers.pages.base.BasePageClass;

public class TVDashboardPage  extends BasePageClass {

	public TVDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.resetParen']/ancestor::button")
	WebElement btnResetParentalControl;
	
	@FindBy(xpath = "//span[@ng-reflect-translate='global.dashboard.tv.resetOnDem']/ancestor::button")
	WebElement icnCustForgotPurchasePin;
	
	@FindBy(xpath = "//button[@rchtrackclickevent='generatePDF']")
	WebElement icnViewPdf;
	
	
	@FindBy(xpath = "//span[text()='View my channel lineup' or text()='Voir ma liste de chaînes']/ancestor::button")
	WebElement btnViewChannelLineUp;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContnueReset;
	
	@FindBy(xpath = "//div[@class='nsm-dialog success nsm-dialog-open']//div[@class='rch-modal-header ']//i[@class='rch-icon']")
	WebElement imgSuccess;
	
	@FindBy(xpath = "//div[contains(text(),'Success!')]")
	WebElement txtSuccess;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -primary -large ng-star-inserted']")
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
	
	@FindBy(xpath = "(//div[@class='exchange-container x-out']//button[@role='button'])[1]")
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
	
	@FindBy(xpath = "//span[text()='Select Change Date']/parent::div/parent::div//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContinueChangeDate;

	@FindBy(xpath = "//div[@class='rch-modal']//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnContinueOn4kTVPack;
	
	
	@FindBy(xpath = "//div[@class='rch-modal']//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContinueOn4kChannelPack;
	
	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@class='button-set set-end-to-end']//button[@translate='global.cta.submit']")
	WebElement orderConfirmation;
	
	@FindBy(xpath = "//div[@class='mini-cart-ss']//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement minicartContinue;
	
	
	
	/**
	 * Clicks submit button for changing the TV package
	 * @return true if the element is visible, else false
	 * @author Drashti.Patel
	 */
	public boolean clickSubmit() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().getWhenReady(btnSubmit, 60).click();
		return getReusableActionsInstance().isElementVisible(orderConfirmation);
		
		}
	

	
	/**
	 * Clicks select the lowest TV package available
	 * @author Drashti.Patel
	 */
	public void clickSelectLowestTVPackage() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectLowestTvPackage, 60).click();
		//getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
		getReusableActionsInstance().waitForElementVisibility(btnContnueReset,120);
		
		}
	

	/**
	 * Clicks continue on change TV package
	 * @author Drashti.Patel
	 */
	public void clickContinueChangeTVPackage() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
		getReusableActionsInstance().waitForElementVisibility(minicartContinue,120);
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author Drashti.Patel
	 */
	public void clickContinue4kChannelPack() {
		getReusableActionsInstance().getWhenReady(btnContinueOn4kChannelPack,60).click();
		getReusableActionsInstance().waitForElementVisibility(btnContinueChangeDate,120);
		
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author Drashti.Patel
	 */
	public void clickContinueOn4kTv() {
		if(getReusableActionsInstance().isElementVisible(btnContinueOn4kTv,120))
		getReusableActionsInstance().getWhenReady(btnContinueOn4kTv,60).click();
		getReusableActionsInstance().waitForElementVisibility(btnContinueOn4kChannelPack,120);
		
		}
	
	/**
	 * Clicks continue on change TV package
	 * @author Drashti.Patel
	 */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate,60).click();
		getReusableActionsInstance().waitForElementVisibility(btnSubmit, 120);
	   }

	/**
	 * Clicks Exchange flex channels button
	 * @author Drashti.Patel
	 */
	public void clickExchangeFlexChannels() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels,80);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnExchangeFlexChannels, 60).click();
		getReusableActionsInstance().waitForElementVisibility(btnFirstChannelToRemove, 120);
		}
	
	/**
	 * Clicks search icon on the channels to remove section
	 * @author Drashti.Patel
	 */
	public void clickSearchChannelToRemove() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToRemove,20);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToRemove, 30).click();
		
		}
	
	/**
	 * Clicks first channel available in the list to be removed
	 * @author Drashti.Patel
	 */
	public void clickFirstChannelToRemove() {
		WebElement bTn=getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,bTn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToRemove, 60).click();
		}
	/**
	 * Clicks Second channel available in the list to be removed
	 * @author Drashti.Patel
	 */
	public void clickSecondChannelToRemove() {
		WebElement bTn=getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,bTn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToRemove, 60).click();
		}
	/**
	 * Clicks select button on the channel to remove section
	 * @author Drashti.Patel
	 */
	public void clickSelectChannelRemove() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSelectChannel, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 60).click();
		}
	
	/**
	 * Clicks Change TV Package  button on the TV dashboard
	 * @author Drashti.Patel
	 */
	public void clickChangeTvPackage() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnChangeTvPackage, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		//getReusableActionsInstance().waitForElementVisibility(btnViewChannelLineUp, 120);
		//getReusableActionsInstance().javascriptScrollByVisibleElement(btnViewChannelLineUp);
		getReusableActionsInstance().getWhenReady(btnChangeTvPackage, 120).click();
		getReusableActionsInstance().waitForElementVisibility(btnSelectChannel, 120);
		}
	
	
	/**
	 * Clicks select button on the channel to Add section
	 * @author Drashti.Patel
	 */
	public void clickSelectChannelAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSelectChannel,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 120).click();
		}


	/**
	 * Clicks search icon on the channels to add section
	 * @author Drashti.Patel
	 */
	public void clickSearchChannelToAdd() {
		getReusableActionsInstance().waitForElementVisibility(icnSearchChannelToAdd,120);
		getReusableActionsInstance().javascriptScrollByVisibleElement(exchangeFlexChannelContainer);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToAdd, 120).click();
		
		}
	
	/**
	 * Clicks first channel available in the list to be added
	 * @author Drashti.Patel
	 */
	public void clickFirstChannelToAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnFirstChannelToAdd, 120).click();
		}

	/**
	 * Clicks Second channel available in the list to be added
	 * @author Drashti.Patel
	 */
	public void clickSecondChannelToAdd() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSecondChannelToAdd, 120).click();
		}
	
	/**
	 * Clicks Confirm Exchange buttton 
	 * @param   strBrowser is the browser to be run 
	 * @author Drashti.Patel
	 */
	public void clickConfirmExchange(String strBrowser) {
		WebElement select=getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnConfirmExchange, 120).click();
	/*	if (strBrowser.equalsIgnoreCase("firefox"))
		{
			getReusableActionsInstance().getWhenReady(btnConfirmExchange, 60).click();
		}else
		{
		getReusableActionsInstance().scrollToElement(txtRecordAndSave);
		getReusableActionsInstance().getWhenReady(btnConfirmExchange, 60).click();
		}*/
	}
	
	
	
	/**
	 * Verifies if the Exchange flex channels section is loaded correctly or not
	 * @return true if the element is visible, else false
	 * @author Drashti.Patel
	 */
	public boolean verifyExchangeFlexChannelIsLoaded() {
		getReusableActionsInstance().waitForElementInvisibility(popUpFlexChannelLoader, 120);
		getReusableActionsInstance().getWhenReady(icnSearchChannelToRemove, 120);
		return getReusableActionsInstance().isElementVisible(icnSearchChannelToRemove, 120);
		}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkUsingVoiceCommands() {
		getReusableActionsInstance().waitForElementVisibility(lnkUsingVoiceCommands, 120);
		return getReusableActionsInstance().isElementVisible(lnkUsingVoiceCommands);
	}
	
	/**
	 * Clicks back to overview button which brings user back to account overview page
	 * @author Drashti.Patel
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview, 120).click();
		}
	
	/**
	 * Clicks view channel line up button 
	 * @author Drashti.Patel
	 */
	public void clickViewChannelLineUp() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnViewChannelLineUp,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnViewChannelLineUp,120);
	//	getReusableActionsInstance().getWhenReady(btnViewChannelLineUp, 60).click();
		}
	
	
	/**
	 * Clicks view pdf on channel line up 
	 * @author Drashti.Patel
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
	 * @author Drashti.Patel
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
	 * @author Drashti.Patel
	 */	
	public boolean verifyHeader() {	
		getReusableActionsInstance().waitForElementVisibility(icnHeader,120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}
	
	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author Drashti.Patel
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
	 * @author Drashti.Patel
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
	 * @author harpartap.virk
	 */
	
	public void clickOK() {
		getReusableActionsInstance().getWhenReady(btnOk, 120).click();
			}
		
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkIntroToAppsOnIgniteTv() {
		getReusableActionsInstance().waitForElementVisibility(lnkIntroToAppsOnIgniteTv, 120);
		return getReusableActionsInstance().isElementVisible(lnkIntroToAppsOnIgniteTv);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkFAQOnPowerSaver() {
		getReusableActionsInstance().waitForElementVisibility(lnkFAQOnPowerSaver, 120);
		return getReusableActionsInstance().isElementVisible(lnkFAQOnPowerSaver);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkIgniteTvErrCode() {
		getReusableActionsInstance().waitForElementVisibility(lnkIgniteTvErrCode, 120);
		return getReusableActionsInstance().isElementVisible(lnkIgniteTvErrCode);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkGoToSupportSection() {
		getReusableActionsInstance().waitForElementVisibility(lnkGoToSupportSection, 120);
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection);
	}
	
	/**
	 * Go to Page bottom
	 * @author Drashti.Patel
	 */	
	public void goToPageBottom() {		
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}
	
	
	/**
	 * Go to Page bottom
	 * @author Drashti.Patel
	 */	
	public void goToPageMid() {		
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();;
	}
	
	
}

