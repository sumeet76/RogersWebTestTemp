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
        @FindBy(xpath = "//span[@class='ds-icon rds-icon-tv']")})
	WebElement btnSolaristvBadge;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement loaderTVdashboard;
	
	@FindBy(xpath = "//ins[@usertype-translate='global.dashboard.tv.viewMyChannelLineup']")
	WebElement lnkViewMyChannelLineup;

	@FindBy(xpath = "//ins[@translate='global.modals.viewMyChannelsModal.viewAsPdf']")
	WebElement lnkViewAsPDF;

	@FindBy(xpath = "//embed[@id='plugin']")
	WebElement lnkPDFPage;

	@FindBy(xpath = "//div[@class='channel-list-block']")
	WebElement lstChannelList;

	@FindBy(xpath = "//button[@class='closeModalBtn']")
	WebElement popupCloseChannel;

	@FindBy(xpath = "//ins[@usertype-translate='global.dashboard.tv.viewMyFlexChannels']")
	WebElement lnkViewfelxChannels;

	@FindBy(xpath = "//ins[@translate='global.cta.changeTVPackage']")
	WebElement btnChangeTVPackage;		
	
	@FindBy(xpath = "//ins[@translate='global.cta.addChannelsOrThemePacksTv']")
	WebElement btnManageChannelsAndThemePacks;
	
	@FindBy(xpath = "//ins[@translate='global.cta.bysContinue']")
	WebElement popupChangeTVPackage;

	@FindBy(xpath = "//div[@class='live-support']")
	WebElement popupContatUS;

	@FindBy(xpath = "//a[@id='swapChannelsButton']")
	WebElement infoChangeFlexChannels;
	
	@FindBy(xpath = "//input[@id='searchFilter_swapout']")
	WebElement infoChannelSwapoutSeach;

	@FindBy(id = "searchFilter_swapin")
	WebElement infoChannelSwapinSeach;

	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnConfirmExchange;

	@FindBy(xpath = "//div[@id='tvPopupTitle']/i[@class='ute-icon']")
	WebElement infoSuccessIcon;	

	@FindBy(xpath = "(//div[@class='col-md-12 tv-channel-list']//span[@class='ute-icon-circle-cross'])[1]")
	WebElement btnSelectChannelOne;
	
	@FindBy(xpath = "(//div[@class='col-md-12 tv-channel-list']//span[@class='ute-icon-circle-cross'])[2]")
	WebElement btnSelectChannelTwo;
	
	@FindBy(xpath = "(//div[@class='col-md-12 tv-channel-list']//span[@class='ute-icon-circle-cross'])[3]")
	WebElement btnSelectChannelThree;
	
	@FindBy(xpath = "//input[contains(@class,'ng-empty')]")
	WebElement txtEnterChannelToSerach;
	
	@FindBy(xpath = "//span[contains(@class,'ute-icon-circle-x')]")
	WebElement btnClearSerachResults;
		
	@FindBy(xpath = "//span[@class='ute-icon-search2']")
	WebElement btnSearchChannel;
	
	@FindBy(xpath = "//span[@class='ute-icon-info']")
	WebElement btnSelectChannel;
	
	@FindBy(xpath = "//button[@translate='global.dashboard.tv.exchangeFlexChannels.modalCTA']")
	WebElement btnConfirmSelectedChannel;
	
	@FindBy(xpath = "//button[@translate='global.dashboard.tv.exchangeFlexChannels.CTAGreyedOut']")
	WebElement btnConfirmSwap;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement btnContinueSwap;	
	//button[@translate='global.dashboard.tv.exchangeFlexChannels.modalConfirmCTA']
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement btnOK;
	
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
	
	@FindBy(xpath = "//div[@class='modal-content']//ins[@usertype-translate='global.label.success']")
	WebElement successMessageParentalControlAndPinReset;
	
	@FindBy(xpath = "//div[@class='digital-box-settings']//ins[@translate='global.cta.resetParentalControlsPIN']")
	WebElement lnkResetParentalConrolsAndPin;
	
	@FindBy(xpath = "//div[@class='modal-content']//ins[contains(@ng-bind,'global.cta.yesResetPinNumber')]")
	WebElement btnContinueParentalControlAndPinReset;	

	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;
		
	@FindAll({
        @FindBy(xpath = "//span[@translate='myaccoverview_home_monotoring']"),
        @FindBy(xpath = "//span[contains(text(),'Home Monitoring') or contains(text(),'Système domotique')]/ancestor::div[@class='subscription-detail']")})
	WebElement btnSHMBadge;
	

	@FindBy(xpath = "//ins[@usertype-translate='global.dashboard.tv.digitalBoxes']")
	WebElement lblBoxHeader;

	@FindBy(xpath = "//ins[@translate='global.dashboard.tv.digitalBoxSettings']")
	WebElement lblBoxSettings;

	@FindBy(xpath = "//h1[@class='tv-dashboard-hdr']")
	WebElement lblHeaderTV;
	
	@FindBy(xpath = "//div[@class='col-md-12 loading']")
	WebElement ldrTVdashboard;
	
	@FindBy(xpath = "//div[@class='loading']")
	WebElement ldrThemepack2;
	
	
	/**
	 * Click on Reset Parental controls And Pin link
	 * @author chinnarao.vattam
	 */
	public void clkResetParentalConrolsAndPin() {
		reusableActions.clickWhenReady(lnkResetParentalConrolsAndPin,40);
	}
	
	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author chinnarao.vattam
	 */
	public void clkContinueParentalControlAndPinReset() {
		reusableActions.clickWhenReady(btnContinueParentalControlAndPinReset,90);
	}
	
	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadge() {
		reusableActions.getWhenReady(btnSolaristvBadge,30).click();
	}

	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadgeMobile() {
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnSolaristvBadge,30).click();
	}
	
	/**
	 * Verify the view my channel lineup link on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the view my channel lineup link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMyChannelLineup() {		
		return reusableActions.isElementVisible(lnkViewMyChannelLineup);
	}

	/**
	 * Click the view my channel lineup link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewMyChannelLineup() {
		reusableActions.waitForElementInvisibility(loaderTVdashboard,90);		
		reusableActions.getWhenReady(lnkViewMyChannelLineup, 60).click();		
	}

	/**
	 * Verify the PDF link on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the PDF link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPDF() {		
		return reusableActions.isElementVisible(lnkPDFPage);		
	}

	/**
	 * Click the PDF link on MyChannelLineup popup
	 * @return true if the PDF is displaying in new tab, else false
	 * @author chinnarao.vattam
	 */
	public boolean clklAndVerifyViewPDF() {
		String mainWindow = driver.getWindowHandle();
		reusableActions.getWhenReady(lnkViewAsPDF,90).click();
		reusableActions.waitForNumberOfWindowsToBe(2);
		reusableActions.switchToNewWindow(mainWindow);
		//the page is moving to new window
		reusableActions.staticWait(1000);
		reusableActions.isElementVisible(lnkPDFPage);
		reusableActions.closeCurrentWindow();
		reusableActions.switchToMainWindow(mainWindow);
		//the page is moving to original window
		reusableActions.staticWait(1000);
		reusableActions.waitForNumberOfWindowsToBe(1);		
		return true;
	}

	/**
	 * Verify the channel list on MyChannelLineup popup
	 * @return true if the MyChannelLineup popup display the channel list, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelList() {		
		return reusableActions.isElementVisible(lstChannelList,20);
	}

	/**
	 * Click on close button on MyChannelLineup popup
	 * @author chinnarao.vattam
	 */
	public void clkCloseChannelsPopup() {
		reusableActions.clickWhenReady(popupCloseChannel,40);
		}

	/**
	 * Click the ViewfelxChannels link on Solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkViewfelxChannels() {
		reusableActions.waitForElementInvisibility(lstChannelList, 90);
		reusableActions.waitForElementVisibility(lnkViewfelxChannels, 60);
		reusableActions.getWhenReady(lnkViewfelxChannels,30).click();		
	}

	/**
	 * verify the ViewfelxChannels link on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the ViewfelxChannels link, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyViewfelxChannels() {		
		return reusableActions.isElementVisible(lnkViewfelxChannels,20);
	}

	/**
	 * Click the ChangeTV Package link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeTVPackage() {
		reusableActions.waitForElementInvisibility(loaderTVdashboard,90);
		reusableActions.getWhenReady(btnChangeTVPackage, 30).click();
	}
	
	/**
	 * Click the Manage Channels And Theme Packs link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkManageChannelsAndThemePacks() {
		reusableActions.waitForElementInvisibility(loaderTVdashboard,90);
		reusableActions.getWhenReady(btnManageChannelsAndThemePacks, 30).click();
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannels() {
		reusableActions.waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		reusableActions.getWhenReady(infoChangeFlexChannels, 120).click();		
	}

	/**
	 * Selects the solaris tv package name to be upgrade or downgrade 
	 * @param strPackageNameEn solaris tv package name to be upgrade or downgrade
	 * @param strPackageNameFr solaris tv package name to be upgrade or downgrade  
	 * @author chinnarao.vattam
	 */
	public void selectSolarisTVPackage(String strPackageNameEn, String strPackageNameFr) {
		reusableActions.staticWait(3000);
		By packageNameLocator = By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn + "') or contains(normalize-space(.),'" + strPackageNameFr + "')]/ancestor::div[contains(@class,'owl-item')]//ins[@translate='global.cta.select']");
		WebElement pkg = driver.findElement(packageNameLocator);
		if(reusableActions.isElementVisible(packageNameLocator,150))
		{		
		reusableActions.getWhenReady(packageNameLocator, 120);
		reusableActions.executeJavaScriptClick(pkg);
		 }
	   else
		{
	    reusableActions.getWhenReady(imgNext, 120);
	    reusableActions.executeJavaScriptClick(imgNext);
	    reusableActions.getWhenReady(pkg, 120);
	    reusableActions.executeJavaScriptClick(pkg);
		}
	}
	
	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackage() {
		reusableActions.getWhenReady(popupChangeTVPackage, 120).click();
	}
	
	/**
	 * Verify the contact us popup on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the contat us popup , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifycontatUSPopUp() {		
		return reusableActions.isElementVisible(popupContatUS, 90);
	}

	/**
	 * Click the confirm exchange button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkConfirmExchange() {		
		reusableActions.clickWhenReady(btnConfirmExchange, 30);
	}

	/**
	 * Verify the successful exchange icon on solaris TV dashboard page
	 * @return true if the solaris TV dashboard page display the successful exchange icon  , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessIcon() {		
		return reusableActions.isElementVisible(infoSuccessIcon, 180);
	}
	
	/**
	 * Verify successful reset message of the Parental Controls And Pin
	 * @return true if success message is displayed successfully, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyResetParentalControlsAndPinSuccess() {		
		return reusableActions.isElementVisible(successMessageParentalControlAndPinReset, 90);
	}
	
	/**
	 * It will take the channel list and search those channels on the in channel list panel, if it is available it will select and add to the channel list 
	 * @param strInChannellist channel list and search those channels on the in channel list panel
	 * @author chinnarao.vattam
	 */
	public void swapInChannel(String[] strInChannellist) {
		String strInChannel[] = strInChannellist;
		for (String channel : strInChannel) {
			reusableActions.getWhenReady(infoChannelSwapinSeach, 180).clear();
			reusableActions.getWhenReady(infoChannelSwapinSeach, 10).sendKeys(channel);
			By channelLocator = By.xpath("//a[@title='" + channel + "']");
			reusableActions.getWhenReady(channelLocator, 120).click();
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			reusableActions.getWhenReady(btnChannelLocator, 10).click();
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
			reusableActions.getWhenReady(infoChannelSwapoutSeach, 30).clear();
			reusableActions.getWhenReady(infoChannelSwapoutSeach, 10).sendKeys(channel);
			//By channelLocator = By.xpath("//a[@title='" + channel + "']");
			reusableActions.waitForElementStaleness(driver.findElement( By.xpath("//a[@title='" + channel + "']")),3);
			reusableActions.getWhenReady(By.xpath("//a[@title='" + channel + "']"), 20).click();
			
			By btnChannelLocator = By.xpath("//a[@title='" + channel
					+ "']/ancestor::li[@class='tv-channel-li']//button[@class='select-channel-btn']");
			reusableActions.getWhenReady(btnChannelLocator, 20).click();
		}
	}
	

	/**
	 * Verify the Ignite TV Starter Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Starter Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVStarterPackage() {		
		return reusableActions.isElementVisible(txtIgniteTVStarter);
	}
	
	/**
	 * Click the cross button to cancel the channel 
	 * @author chinnarao.vattam
	 */
	public void clkOutChannelOne() {		
		reusableActions.getWhenReady(btnSelectChannelOne, 150).click();
	}
	
	/**
	 * Click the cross button to cancel the channel 
	 * @author chinnarao.vattam
	 */
	public void clkOutChannelTwo() {		
		reusableActions.getWhenReady(btnSelectChannelTwo, 90).click();
	}

	/**
	 * Click the cross button to cancel the channel 
	 * @author chinnarao.vattam
	 */
	public void clkOutChannelThree() {		
		reusableActions.getWhenReady(btnSelectChannelThree, 60).click();
	}
	
	/**
	 * Search for the required channel and will add it to the to be add list
	 * @param strInChannellist  are array of channels 
	 * @author chinnarao.vattam
	 */
	public void swapChannelIn(String[] strInChannellist) {
		String strInChannel[] = strInChannellist;
		for (String channel : strInChannel) {			
		reusableActions.getWhenReady(txtEnterChannelToSerach, 180).clear();
		reusableActions.getWhenReady(txtEnterChannelToSerach, 10).sendKeys(channel);
		reusableActions.getWhenReady(btnSearchChannel, 30).click();
		reusableActions.waitForElementVisibility(btnSelectChannel, 120);
		reusableActions.scrollToElement(btnSelectChannel);
		reusableActions.getWhenReady(btnSelectChannel, 90).click();	
		reusableActions.getWhenReady(btnConfirmSelectedChannel, 60).click();
		reusableActions.getWhenReady(btnClearSerachResults, 180).click();
		}
	}

	/**
	 * Search for the required channel and will add it to the to be add list
	 * @param strInChannel  are channels 
	 * @author chinnarao.vattam
	 */
	public void swapChannelIn(String strInChannel) {
			reusableActions.getWhenReady(txtEnterChannelToSerach, 120).clear();
			reusableActions.getWhenReady(txtEnterChannelToSerach, 30).sendKeys(strInChannel);
			reusableActions.waitForElementVisibility(btnSearchChannel,60);
			reusableActions.executeJavaScriptClick(btnSearchChannel);			
			By imgChannel = By.xpath("//div[@class='channel-title' and contains(text(), '"+ strInChannel+"')]/ancestor::div[@class='genre-channel']//span[@class='ute-icon-info']");
			reusableActions.waitForElementVisibility(btnSearchChannel,120);
			reusableActions.getWhenReady(imgChannel, 30).click();	
	}
	
	/**
	 * Click the Channel Add button 
	 * @author chinnarao.vattam
	 */
	public void btnChannelAdd() {		
		reusableActions.getWhenReady(btnConfirmSelectedChannel, 90).click();
	}
	
	/**
	 * Click the Serach Results on flex channels page
	 * @author chinnarao.vattam
	 */
		public void btnClearSerachResults() {	
			reusableActions.waitForElementVisibility(btnClearSerachResults, 60);
			reusableActions.scrollToElement(btnClearSerachResults);
			reusableActions.executeJavaScriptClick(btnClearSerachResults);
		}
	
	/**
	 * Click the confirm channel list for swap 
	 * @author chinnarao.vattam
	 */
	public void clkConfirmChannels() {		
		reusableActions.getWhenReady(btnConfirmSelectedChannel, 30).click();
	}
	
	/**
	 * Click the confirm channel swap 
	 * @author chinnarao.vattam
	 */
	public void clkConfirmSwap() {
		reusableActions.waitForElementVisibility(btnConfirmSwap,180);
		reusableActions.getWhenReady(btnConfirmSwap,90).click();
	}
	
	/**
	 * Click the continue channel swap 
	 * @author chinnarao.vattam
	 */
	public void clkSuccessSwap() {	
		reusableActions.waitForElementVisibility(btnContinueSwap, 180);
		reusableActions.getWhenReady(btnContinueSwap, 180).click();
	}
	
	/**
	 * Click the OK button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkOkButton() {	
		reusableActions.waitForElementInvisibility(btnContinueSwap, 120);
		reusableActions.clickWhenReady(btnOK, 30);
	}
	
	/**
	 * Verify the Ignite TV Select Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Select Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVSelectPackage() {		
		return reusableActions.isElementVisible(txtIgniteTVSelect);
	}
	
	
	/**
	 * Verify the Ignite TV Premier Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite TV Premier Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteTVPremierPackage() {		
		return reusableActions.isElementVisible(txtIgniteTVPremier);
	}
	
	/**
	 * Verify the Ignite Flex 5 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 5 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex5Package() {		
		return reusableActions.isElementVisible(txtIgniteFlex5);
	}
	
	/**
	 * Verify the Ignite Flex 10 Package on Solaris TV dashboard page
	 * @return true if the Solaris TV dashboard page display the Ignite Flex 10 Package, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteFlex10Package() {		
		return reusableActions.isElementVisible(txtIgniteFlex10);
	}

	/**
	 * Checks if view my channel line up is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewMyChannelLineUpDisplayed() {		
		return reusableActions.isElementVisible(lnkViewMyChannelLineup,60);
	}

	/**
	 * Checks if view my flex channel  is displayed
	 * @return treu if link displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyViewFlexChannelsDisplayed() {		
		return reusableActions.isElementVisible(lnkViewfelxChannels,60);
	}

	/**
	 * Clicks on SHM Badge
	 * @author Mirza.Kamran
	 */
	public void clkSHMBadge() {		
		reusableActions.getWhenReady(btnSHMBadge).click();
	}

	

	/**
	 * verifies if the Tupelo Dashboard is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTupeloDashbaordIsDisplayed() {
		return reusableActions.isElementVisible(lblHeaderTV);
		
	}

	/**
	 * Verifies if the smart screen box is displayed
	 * @return true if the box is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyBoxCountIsDisplayed() {		
		return reusableActions.isElementVisible(lblBoxHeader);
	}

	/**
	 * Smart screen box settings is displayed
	 * @return true if the box settings is displayed
	 */
	public boolean verifyBoxSettingslsDisplayed() {		
		return reusableActions.isElementVisible(lblBoxSettings);
	}

}
