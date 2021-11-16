package com.rogers.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSolarisTVDashboardPage extends BasePageClass {

	public RogersSolarisTVDashboardPage(WebDriver driver) {
		super(driver);
	}

		
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'TV')]"),
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-tv' or @class='ds-icon d-inline-flex rds-icon-tv']")})
	WebElement btnSolaristvBadge;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement loaderTVdashboard;
	
	@FindBy(xpath = "//span[@translate='global.dashboard.tv.viewFlexChannels']")
	WebElement lnkViewMyChannelLineup;
    //ins[@usertype-translate='global.dashboard.tv.viewMyChannelLineup']

	@FindBy(xpath = "//span[@translate='global.modals.viewMyChannelsModal.viewAsPdf']")
	WebElement lnkViewAsPDF;
	//ins[@translate='global.modals.viewMyChannelsModal.viewAsPdf']

	@FindBy(xpath = "//embed[@id='plugin']")
	WebElement lnkPDFPage;

	@FindBy(xpath = "//div[@class='channels-container']")
	WebElement lstChannelList;
	//div[@class='channel-list-block']

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement popupCloseChannel;
	//button[@class='closeModalBtn']

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.viewLineup']")
	WebElement lnkViewfelxChannels;
	//ins[@usertype-translate='global.dashboard.tv.viewMyFlexChannels']

	@FindBy(xpath = "//button[contains(@aria-label,'Change TV package') or  contains(@aria-label,'Modifier le forfait Télé')]")
	WebElement btnChangeTVPackage;
	//ins[@translate='global.cta.changeTVPackage']

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.manageChannelsAndThemePacks.buttonName']")
	WebElement btnManageChannelsAndThemePacks;
	//ins[@translate='global.cta.addChannelsOrThemePacksTv']

	@FindBy(xpath = "//span[contains(text(),'Continue')]/ancestor::a/span")
	WebElement popupChangeTVPackage;
	//ins[@translate='global.cta.bysContinue']

	@FindBy(xpath = "//div[@class='popup-modal-component']//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement popupContatUS;
	//div[@class='live-support']

	@FindBy(xpath = "//span[@translate='global.dashboard.tv.exchangeFlexChannels']")
	WebElement lnkChangeFlexChannels;

	@FindBy(xpath = "//input[@id='searchFilter_swapout']")
	WebElement infoChannelSwapoutSeach;

	@FindBy(id = "searchFilter_swapin")
	WebElement infoChannelSwapinSeach;

	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnConfirmExchange;

	@FindBy(xpath = "//div[@id='tvPopupTitle']/i[@class='ute-icon']")
	WebElement infoSuccessIcon;	

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Starter') or contains(normalize-space(.),'Télé Élan Découverte')]")
	WebElement txtIgniteTVStarter;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Select') or contains(normalize-space(.),'Télé Élan Sélection')]")
	WebElement txtIgniteTVSelect;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite TV Premier') or contains(normalize-space(.),'Télé Élan Premier')]")
	WebElement txtIgniteTVPremier;
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite Flex 5') or contains(normalize-space(.),'Élan Flex 5')]")
	WebElement txtIgniteFlex5;
	 
	 
	@FindBy(xpath = "//h4[contains(normalize-space(.),'Ignite Flex 10') or contains(normalize-space(.),'Élan Flex 10')]")
	WebElement txtIgniteFlex10;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement successMessageParentalControlAndPinReset;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement successRefreshYourIgniteTVBox;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle ds-color-success']")
	WebElement successResetPurchasePIN;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement btnOk;

	@FindBy(xpath = "//span[contains(text(),'Réinitialiser le NIP pour le contrôle parental') or contains(text(),'Reset Parental Control PIN')]")
	WebElement lnkResetParentalConrolsAndPin;

	@FindBy(xpath = "//span[contains(text(),'Actualiser vos terminaux Télé Élan') or contains(text(),'Refresh your Ignite TV Box(es)') ]")
	WebElement lnkRefreshYourIgniteTVBox;

	@FindBy(xpath = "//span[contains(text(),'Reset Purchase PIN') or contains(text(),'Réinitialiser le NIP d’achat')]")
	WebElement lnkResetPurchasePIN;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnContinueParentalControlAndPinReset;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnRefreshYourIgniteTVBox;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnResetPurchasePIN;

	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;
		
	@FindBy(xpath = "//span[contains(text(),'Home Monitoring') or contains(text(),'Système domotique')]/ancestor::div[@class='subscription-detail']")
	WebElement btnSHMBadge;
	
	@FindBy(xpath = "//ins[@usertype-translate='global.dashboard.tv.digitalBoxes']")
	WebElement lblBoxHeader;

	@FindBy(xpath = "//ins[@translate='global.dashboard.tv.digitalBoxSettings']")
	WebElement lblBoxSettings;

	@FindBy(xpath = "//h1[@class='tv-dashboard-hdr' or text()='Ignite SmartStream']")
	WebElement lblHeaderTV;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement ldrTVdashboard;
	
	@FindBy(xpath = "//div[@class='loading']")
	WebElement ldrThemepack2;
	
	@FindBy(xpath = "//h2[@class='all-channels__header']")
	WebElement txtFlexChannels;
	//h3[@class='copy-1 font-medium margin-0']

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement loaderTVDashboard;

	
	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkResetParentalConrolsAndPin() {
		getReusableActionsInstance().clickWhenReady(lnkResetParentalConrolsAndPin,40);
	}

	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkRefreshYourIgniteTVBox() {
		getReusableActionsInstance().clickWhenReady(lnkRefreshYourIgniteTVBox,40);
	}

	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkResetPurchasePIN() {
		getReusableActionsInstance().clickWhenReady(lnkResetPurchasePIN,40);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkContinueParentalControlAndPinReset() {
		getReusableActionsInstance().clickWhenReady(btnContinueParentalControlAndPinReset,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkRefreshYourIgniteTVBoxContinue() {
		getReusableActionsInstance().clickWhenReady(btnRefreshYourIgniteTVBox,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkResetPurchasePINContinue() {
		getReusableActionsInstance().clickWhenReady(btnResetPurchasePIN,90);
	}

	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkOkContinue() {
		getReusableActionsInstance().clickWhenReady(btnOk,90);
	}

	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadge() {
		getReusableActionsInstance().getWhenReady(btnSolaristvBadge,90).click();
	}

	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadgeMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnSolaristvBadge,90);
		getReusableActionsInstance().executeJavaScriptClick(btnSolaristvBadge);
	}
	
	/**
	 * Verify the view my channel lineup link on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the view my channel lineup link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMyChannelLineup() {		
		return getReusableActionsInstance().isElementVisible(lnkViewMyChannelLineup);
	}

	/**
	 * Click the view my channel lineup link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewMyChannelLineup() {
		getReusableActionsInstance().waitForElementVisibility(lnkViewMyChannelLineup,60);
		getReusableActionsInstance().getWhenReady(lnkViewMyChannelLineup, 30).click();
	}

	/**
	 * Verify the PDF link on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the PDF link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPDF() {		
		return getReusableActionsInstance().isElementVisible(lnkPDFPage);
	}

	/**
	 * Click the PDF link on MyChannelLineup popup
	 * @return true if the PDF is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean clklAndVerifyViewPDF() {
		String mainWindow = getDriver().getWindowHandle();
		getReusableActionsInstance().getWhenReady(lnkViewAsPDF,90).click();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2);
		getReusableActionsInstance().switchToNewWindow(mainWindow);
		//the page is moving to new window
		getReusableActionsInstance().staticWait(1000);
		//getReusableActionsInstance().isElementVisible(lnkPDFPage);
		getReusableActionsInstance().closeCurrentWindow();
		getReusableActionsInstance().switchToMainWindow(mainWindow);
		//the page is moving to original window
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().waitForNumberOfWindowsToBe(1);
		return true;
	}

	/**
	 * Verify the channel list on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the channel list, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelList() {		
		return getReusableActionsInstance().isElementVisible(lstChannelList,20);
	}

	/**
	 * Click on close button on MyChannelLineup popup
	 * @author chinnarao.vattam
	 */
	public void clkCloseChannelsPopup() {
		getReusableActionsInstance().getWhenReady(popupCloseChannel,40);
		getReusableActionsInstance().executeJavaScriptClick(popupCloseChannel);
	}

	/**
	 * Click the ViewfelxChannels link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewfelxChannels() {
		getReusableActionsInstance().waitForElementVisibility(lnkViewfelxChannels, 60);
		getReusableActionsInstance().getWhenReady(lnkViewfelxChannels,10).click();
	}

	
	/**
	 * verify the ViewfelxChannels link on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the ViewfelxChannels link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyViewfelxChannels() {		
		return getReusableActionsInstance().isElementVisible(lnkViewfelxChannels,20);
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackage() {
		//NL and FL  Provinces taking long loading time to pull the dashboard details
		getReusableActionsInstance().staticWait(6000);
		//getReusableActionsInstance().waitForElementVisibility(btnChangeTVPackage,120);
		//getReusableActionsInstance().executeJavaScriptClick(btnChangeTVPackage);
		getReusableActionsInstance().getWhenReady(btnChangeTVPackage, 60).click();
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackageLetency() {
		//NL and FL  Provinces taking long loading time to pull the dashboard details
		//getReusableActionsInstance().waitForElementInvisibility(loaderTVDashboard,120);
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().waitForElementVisibility(btnChangeTVPackage,120);
		//getReusableActionsInstance().executeJavaScriptClick(btnChangeTVPackage);
		getReusableActionsInstance().getWhenReady(btnChangeTVPackage, 60).click();
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackageMobile() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(btnChangeTVPackage,90);
		getReusableActionsInstance().executeJavaScriptClick(btnChangeTVPackage);
	}
	/**
	 * Click the Manage Channels And Theme Packs link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkManageChannelsAndThemePacks() {
		getReusableActionsInstance().waitForElementVisibility(btnManageChannelsAndThemePacks,90);
		getReusableActionsInstance().getWhenReady(btnManageChannelsAndThemePacks, 30).click();
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannels() {
		getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		getReusableActionsInstance().getWhenReady(lnkChangeFlexChannels, 60).click();
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannelsMobile() {
		getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		//Need ti to pull channels from ATG
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().executeJavaScriptClick(lnkChangeFlexChannels);
	}
	/**
	 * To verify Exchange FlexChanne link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyExchangeFlexChannelLink() {
		return getReusableActionsInstance().isElementVisible(lnkChangeFlexChannels, 10);
       }
	
	/**
	 * To verify Exchange FlexChanne link
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyFlexChannelcount(String strFlexChannels) {
		// 0, 5, 44 channels
		String strChannels=getReusableActionsInstance().getWhenReady(txtFlexChannels, 50).getText();
		String[] channels = strChannels.split("\\s+");
		return channels[0].equals(strFlexChannels);
       }

	/**
	 * Selects the solaris tv package name to be upgrade or downgrade 
	 * @param strPackageNameEn solaris tv package name to be upgrade or downgrade
	 * @param strPackageNameFr solaris tv package name to be upgrade or downgrade  
	 * @author chinnarao.vattam
	 */
	public void selectSolarisTVPackage(String strPackageNameEn, String strPackageNameFr) {
		By packageNameLocator = By.xpath("//h3[contains(normalize-space(.),'" + strPackageNameEn + "') or contains(normalize-space(.),'" + strPackageNameFr + "')]/ancestor::div[contains(@class,'tv-bundle-tile__row')]//span[contains(text(),'Select')]");
		if(getReusableActionsInstance().isElementVisible(packageNameLocator,60))
		{		
		getReusableActionsInstance().getWhenReady(packageNameLocator, 20);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
		 }
	   else
		{
	    getReusableActionsInstance().getWhenReady(imgNext, 60);
	    getReusableActionsInstance().executeJavaScriptClick(imgNext);
	    WebElement pkg = getDriver().findElement(packageNameLocator);
	    getReusableActionsInstance().getWhenReady(pkg, 60);
	    getReusableActionsInstance().executeJavaScriptClick(pkg);
		}
	}

	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackage() {
		getReusableActionsInstance().getWhenReady(popupChangeTVPackage, 90).click();
	}

	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackageMobile() {
		getReusableActionsInstance().waitForElementVisibility(popupChangeTVPackage, 90);
		getReusableActionsInstance().executeJavaScriptClick(popupChangeTVPackage);
	}
	/**
	 * Verify the contact us popup on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the contat us popup , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifycontatUSPopUp() {		
		return getReusableActionsInstance().isElementVisible(popupContatUS, 90);
	}

	/**
	 * Click the confirm exchange button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkConfirmExchange() {		
		getReusableActionsInstance().clickWhenReady(btnConfirmExchange, 30);
	}

	/**
	 * Verify the successful exchange icon on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the successful exchange icon  , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessIcon() {		
		return getReusableActionsInstance().isElementVisible(infoSuccessIcon, 180);
	}
	
	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyResetParentalControlsAndPinSuccess() {		
		return getReusableActionsInstance().isElementVisible(successMessageParentalControlAndPinReset, 90);
	}

	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifysuccessRefreshYourIgniteTVBox() {
		return getReusableActionsInstance().isElementVisible(successRefreshYourIgniteTVBox, 90);
	}

	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifysuccessResetPurchasePIN() {
		return getReusableActionsInstance().isElementVisible(successResetPurchasePIN, 90);
	}

	/**
	 * It will take the channel list and search those channels on the in channel list panel, if it is available it will select and add to the channel list 
	 * @param strInChannellist channel list and search those channels on the in channel list panel
	 * @author chinnarao.vattam
	 */
	public void swapInChannel(String[] strInChannellist) {
		String strInChannel[] = strInChannellist;
		for (String channel : strInChannel) {
			getReusableActionsInstance().getWhenReady(infoChannelSwapinSeach, 90).clear();
			getReusableActionsInstance().getWhenReady(infoChannelSwapinSeach, 10).sendKeys(channel);
			By channelLocator = By.xpath("//a[@title='" + channel + "']");
			getReusableActionsInstance().getWhenReady(channelLocator, 90).click();
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			getReusableActionsInstance().getWhenReady(btnChannelLocator, 10).click();
				}
	}
/**
 * It will take the channel list and search those channels on the out channel list panel, if it is available it will select and delete from the channel list
 * @param strOutChannellist channel list and search those channels on the out channel list panel
 * @author chinnarao.vattam
 */
	public void swapOutChannel(String[] strOutChannellist) {
		String strOutChannel[] = strOutChannellist;
		for (String channel : strOutChannel) {
			getReusableActionsInstance().getWhenReady(infoChannelSwapoutSeach, 30).clear();
			getReusableActionsInstance().getWhenReady(infoChannelSwapoutSeach, 10).sendKeys(channel);
			//By channelLocator = By.xpath("//a[@title='" + channel + "']");
			getReusableActionsInstance().waitForElementStaleness(getDriver().findElement( By.xpath("//a[@title='" + channel + "']")),3);
			getReusableActionsInstance().getWhenReady(By.xpath("//a[@title='" + channel + "']"), 20).click();
			
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			getReusableActionsInstance().getWhenReady(btnChannelLocator, 20).click();
		}
	}
	

	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVStarterPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVStarter);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVSelectPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVSelect);
	}
	
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVPremierPackage() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteTVPremier);
	}
	
	/**
	 * Verify the Ignite Flex 5 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 5 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex5Package() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteFlex5);
	}
	
	/**
	 * Verify the Ignite Flex 10 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 10 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex10Package() {		
		return getReusableActionsInstance().isElementVisible(txtIgniteFlex10);
	}

	/**
	 * Checks if view my channel line up is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewMyChannelLineUpDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkViewMyChannelLineup,60);
	}

	/**
	 * Checks if view my flex channel  is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewFlexChannelsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkViewfelxChannels,60);
	}

	/**
	 * Clicks on SHM Badge
	 * @author Mirza.Kamran
	 */
	public void clkSHMBadge() {		
		getReusableActionsInstance().getWhenReady(btnSHMBadge,60).click();
	}

	

	/**
	 * verifies if the Tupelo Dashboard is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTupeloDashbaordIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblHeaderTV);
		
	}

	/**
	 * Verifies if the smart screen box is displayed
	 * @return true if the box is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyBoxCountIsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblBoxHeader);
	}

	/**
	 * Smart screen box settings is displayed
	 * @return true if the box settings is displayed
	 */
	public boolean verifyBoxSettingslsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblBoxSettings);
	}

}
