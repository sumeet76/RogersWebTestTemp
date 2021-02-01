package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersSolarisChannelsExchangePage extends BasePageClass {

	public RogersSolarisChannelsExchangePage(WebDriver driver) {
		super(driver);
	}

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
	
	@FindBy(xpath = "//div[contains(@class,'desktop')]//a[@aria-describedby='ariaExchangeChannelsPage' ]//span[@role='text']")
	WebElement btnConfirmSwapDesktop;

	@FindBy(xpath = "//div[contains(@class,'mobile')]//a[@aria-describedby='ariaExchangeChannelsPage' ]//span[@role='text']")
	WebElement btnConfirmSwapMobile;

	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement btnContinueSwap;	
	//button[@translate='global.dashboard.tv.exchangeFlexChannels.modalConfirmCTA']
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement btnOK;

	@FindBy(xpath = "//div[@class='channel-list ng-star-inserted']")
	WebElement lstChannelsPannel;

	@FindBy(xpath = "//div[@class='exchange-channels-page__header']//h1")
	WebElement txtExchangeChannelPage;

	/**
	 * Click the Change FlexChannels link on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkChangeFlexChannelsMobile() {
		//getReusableActionsInstance().waitForElementInvisibility(By.className("QSIPopOverShadowBox"),90);
		getReusableActionsInstance().waitForElementInvisibility(lnkChangeFlexChannels, 120);
		getReusableActionsInstance().executeJavaScriptClick(lnkChangeFlexChannels);
	}


	/**
	 * To verify the  ExchangeChannel page
	 * @return true if the Availability of Internet Menu is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyExchangeChannelPage() {
		return getReusableActionsInstance().isElementVisible(txtExchangeChannelPage, 90);
	}

	/**
	 * To verify the  Channels apnnel
	 * @return true if the Availability of Internet Menu is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyChannelsPannel() {
		//Loading all channels from ATG requires considerable time
		getReusableActionsInstance().staticWait(6000);
		return getReusableActionsInstance().isElementVisible(lstChannelsPannel, 90);
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
	 * Search for the required channel and will add it to the to be add list
	 * @param strInChannellist  are array of channels 
	 * @author chinnarao.vattam
	 */
	public void swapChannelIn(String[] strInChannellist) {
		String strInChannel[] = strInChannellist;
		for (String channel : strInChannel) {			
		getReusableActionsInstance().getWhenReady(txtEnterChannelToSerach, 90).clear();
		getReusableActionsInstance().getWhenReady(txtEnterChannelToSerach, 10).sendKeys(channel);
		getReusableActionsInstance().getWhenReady(btnSearchChannel, 30).click();
		getReusableActionsInstance().waitForElementVisibility(btnSelectChannel, 90);
		getReusableActionsInstance().scrollToElement(btnSelectChannel);
		getReusableActionsInstance().getWhenReady(btnSelectChannel, 90).click();
		getReusableActionsInstance().getWhenReady(btnConfirmSelectedChannel, 60).click();
		getReusableActionsInstance().getWhenReady(btnClearSerachResults, 180).click();
		}
	}

	/**
	 * Search for the required channel and will add it to the to be add list
	 * @param strInChannel  are channels 
	 * @author chinnarao.vattam
	 */
	public void swapChannelIn(String strInChannel) {
		By imgChannel = By.xpath("//span[contains(text(),'"+ strInChannel+"')]/ancestor::label//input[@type='checkbox']");
			getReusableActionsInstance().getWhenReady(imgChannel, 30).click();
	}

	/**
	 * Search for the required channel and will add it to the to be remove list
	 * @param strOutChannel  are channels
	 * @author chinnarao.vattam
	 */
	public void swapChannelOut(String strOutChannel) {
		By imgChannelOut = By.xpath("//span[contains(text(),'"+ strOutChannel+"')]/ancestor::label//input[@type='checkbox']");
		getReusableActionsInstance().getWhenReady(imgChannelOut, 30).click();
	}

	/**
	 * Search for the required channel and will add it to the to be add list
	 * @param strInChannel  are channels
	 * @author chinnarao.vattam
	 */
	public void swapChannelInMobile(String strInChannel) {
		getReusableActionsInstance().getWhenReady(txtEnterChannelToSerach, 60).clear();
		getReusableActionsInstance().getWhenReady(txtEnterChannelToSerach, 30).sendKeys(strInChannel);
		getReusableActionsInstance().waitForElementVisibility(btnSearchChannel,60);
		getReusableActionsInstance().executeJavaScriptClick(btnSearchChannel);
		By imgChannel = By.xpath("//div[@class='channel-title' and contains(text(), '"+ strInChannel+"')]/ancestor::div[@class='genre-channel']//span[@class='ute-icon-info']");
		getReusableActionsInstance().waitForElementVisibility(btnSearchChannel,90);
		getReusableActionsInstance().executeJavaScriptClick((WebElement) imgChannel);
	}

	/**
	 * Click the Channel Add button 
	 * @author chinnarao.vattam
	 */
	public void btnChannelAdd() {		
		getReusableActionsInstance().getWhenReady(btnConfirmSelectedChannel, 90).click();
	}
	
	/**
	 * Click the Serach Results on flex channels page
	 * @author chinnarao.vattam
	 */
		public void btnClearSerachResults() {	
			getReusableActionsInstance().waitForElementVisibility(btnClearSerachResults, 60);
			getReusableActionsInstance().scrollToElement(btnClearSerachResults);
			getReusableActionsInstance().executeJavaScriptClick(btnClearSerachResults);
		}
	
	/**
	 * Click the confirm channel list for swap 
	 * @author chinnarao.vattam
	 */
	public void clkConfirmChannels() {		
		getReusableActionsInstance().getWhenReady(btnConfirmSelectedChannel, 30).click();
	}
	
	/**
	 * Click the confirm channel swap 
	 * @author chinnarao.vattam
	 */
	public void clkConfirmSwap() {
		getReusableActionsInstance().waitForElementVisibility(btnConfirmSwapDesktop,30);
		getReusableActionsInstance().executeJavaScriptClick(btnConfirmSwapDesktop);
	}
	
	/**
	 * Click the continue channel swap 
	 * @author chinnarao.vattam
	 */
	public void clkSuccessSwap() {	
		getReusableActionsInstance().waitForElementVisibility(btnContinueSwap, 180);
		getReusableActionsInstance().getWhenReady(btnContinueSwap, 180).click();
	}
	
	/**
	 * Click the OK button on solaris TV dashboard page
	 * @author chinnarao.vattam
	 */
	public void clkOkButton() {	
		getReusableActionsInstance().waitForElementInvisibility(btnContinueSwap, 90);
		getReusableActionsInstance().clickWhenReady(btnOK, 30);
	}

}
