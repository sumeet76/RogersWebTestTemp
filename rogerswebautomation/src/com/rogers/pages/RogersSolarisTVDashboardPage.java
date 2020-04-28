package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSolarisTVDashboardPage extends BasePageClass {

	public RogersSolarisTVDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='ute-icon-tv']")
	WebElement btnSolaristvBadge;

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
	
	@FindBy(xpath = "//div[@class='modal-content']//ins[@translate='global.cta.yesResetPinNumber']")
	WebElement btnContinueParentalControlAndPinReset;	

	@FindBy(xpath = "//i[@class='ute-icon-button-right']")
	WebElement imgNext;
	
	@FindBy(xpath = "//i[@class='ute-icon-button-left']")
	WebElement imgPrevious;

	  
	
	/**
	 * Click on Reset Parental controls And Pin link
	 * @author Saurav.Goyal
	 */
	public void clkResetParentalConrolsAndPin() {
		reusableActions.clickWhenReady(lnkResetParentalConrolsAndPin,40);
	}
	
	/**
	 * Click on continue button on the Parental controls And Pin reset alert window
	 * @author Saurav.Goyal
	 */
	public void clkContinueParentalControlAndPinReset() {
		reusableActions.clickWhenReady(btnContinueParentalControlAndPinReset,40);
	}
	
	/**
	 * Click the TV badge on  account details page
	 * @author Chinnarao.Vattam
	 */
	public void clkTVBadge() {
		reusableActions.getWhenReady(btnSolaristvBadge,90).click();
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
		reusableActions.clickWhenReady(lnkViewMyChannelLineup, 60);		
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
		reusableActions.getWhenReady(lnkViewAsPDF,60).click();
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
		reusableActions.waitForElementInvisibility(lstChannelList, 180);
		reusableActions.waitForElementVisibility(lnkViewfelxChannels, 180);
		reusableActions.getWhenReady(lnkViewfelxChannels,60).click();		
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
		reusableActions.clickWhenReady(btnChangeTVPackage, 90);
	}
	
	/**
	 * Click the Manage Channels And Theme Packs link on solaris TV dashboard page
	 * @author Saurav.Goyal
	 */
	public void clkManageChannelsAndThemePacks() {
		reusableActions.clickWhenReady(btnManageChannelsAndThemePacks, 90);
	}

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannels() {
		reusableActions.waitForElementInvisibility(By.className("QSIPopOverShadowBox"),20);
		reusableActions.getWhenReady(infoChangeFlexChannels, 240).click();
	}

	/**
	 * Selects the solaris tv package name to be upgrade or downgrade 
	 * @param strPackageName solaris tv package name to be upgrade or downgrade  
	 * @author chinnarao.vattam
	 */
	public void selectSolarisTVPackage1(String strPackageName) {
		By packageNameLocator = By.xpath("//h4[contains(normalize-space(.),'" + strPackageName + "') or contains(normalize-space(.),'" + strPackageName + "')]/ancestor::div[contains(@class,'owl-item')]//ins[@translate='global.cta.select']");
		reusableActions.waitForElementInvisibility(popupLoadingFingers,180);
		reusableActions.getWhenReady(packageNameLocator, 60).click();
	}

	/**
	 * Selects the solaris tv package name to be upgrade or downgrade 
	 * @param strPackageNameEn solaris tv package name to be upgrade or downgrade
	 * @param strPackageNameFr solaris tv package name to be upgrade or downgrade  
	 * @author chinnarao.vattam
	 */
	public void selectSolarisTVPackage(String strPackageNameEn, String strPackageNameFr) {
		By packageNameLocator = By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn + "') or contains(normalize-space(.),'" + strPackageNameFr + "')]/ancestor::div[contains(@class,'owl-item')]//ins[@translate='global.cta.select']");
		//reusableActions.waitForElementInvisibility(popupLoadingFingers,180);
		if(reusableActions.isElementVisible(packageNameLocator,180))
		{		
		reusableActions.getWhenReady(packageNameLocator, 90).click();
		 }
	   else
		{
	    reusableActions.getWhenReady(imgNext, 180).click();  
	    reusableActions.isElementVisible(packageNameLocator,180);
		reusableActions.getWhenReady(packageNameLocator, 90).click();
		}
	}

	/**
	 * Click the ChangeTV Package button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkPopupChangeTVPackage() {
		reusableActions.clickWhenReady(popupChangeTVPackage, 60);
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
	 * @author saurav.goyal
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
			reusableActions.getWhenReady(driver.findElement( By.xpath("//a[@title='" + channel + "']")), 20).click();
			
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
				reusableActions.clickWhenReady(btnSelectChannelOne, 120);
	}
	
	/**
	 * Click the cross button to cancel the channel 
	 * @author chinnarao.vattam
	 */
	public void clkOutChannelTwo() {		
		reusableActions.getWhenReady(btnSelectChannelTwo, 30).click();
	}

	/**
	 * Click the cross button to cancel the channel 
	 * @author chinnarao.vattam
	 */
	public void clkOutChannelThree() {		
		reusableActions.getWhenReady(btnSelectChannelThree, 30).click();
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
		reusableActions.getWhenReady(txtEnterChannelToSerach, 60).clear();
		reusableActions.getWhenReady(txtEnterChannelToSerach, 60).sendKeys(strInChannel);
		reusableActions.waitForElementVisibility(btnSearchChannel,180);
		reusableActions.executeJavaScriptClick(btnSearchChannel);
		reusableActions.waitForElementVisibility(btnSelectChannel, 180);
		reusableActions.scrollToElement(btnSelectChannel);
		reusableActions.getWhenReady(btnSelectChannel, 120).click();	
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
		reusableActions.getWhenReady(btnClearSerachResults, 90).click();
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
		reusableActions.getWhenReady(btnConfirmSwap, 180).click();
		reusableActions.waitForElementInvisibility(popupLoadingFingers,220);
		
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

}
