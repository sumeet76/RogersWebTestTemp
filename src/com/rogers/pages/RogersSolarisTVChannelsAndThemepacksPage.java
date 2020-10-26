package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersSolarisTVChannelsAndThemepacksPage extends BasePageClass {

	public RogersSolarisTVChannelsAndThemepacksPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinueFromThemepacks;
	
	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@usertype-translate='global.cta.yesIHave4K']")
	WebElement btnYesIHave4K;

	@FindBy(xpath = "(//button[contains(@class,'ute-btn-primary margin-right-0 margin-left-15')]//ins[@usertype-translate='global.cta.yesIHave4K'])[1]")
	WebElement btnYesIHave4KMobile;

	@FindBy(xpath = "//button[contains(@class,'continue-btn-4k')]//ins[@translate='global.cta.continue']")
	WebElement btn4KContent;
	
	@FindBy(xpath = "//ins[@translate='global.cta.bysSwapLaterContinue']")
	WebElement btnExchangeLater;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//div[@class='channel-list-row']//button[@class='ute-btn-primary ute-sm ute-short']//ins")
	List<WebElement> addParticularChannelToCart;
	
	@FindBy(xpath = "//div[@class='channel-list-row']//button[@class='ute-btn-primary ute-sm ute-short']//ins")
	WebElement addChannelToCart;
	
	@FindBy(xpath = "//input[@id='searchTyping_']")
	WebElement iconSearch;
	
	
	@FindBy(xpath = "//button[contains(@id,'remove-channel')]//ins")
	WebElement removeParticularChannelFromCart;
	
	@FindBy(xpath = "//button[@id='remove-themepack-button']")
	WebElement removeParticularThemePackFromCart;
	
	@FindBy(xpath = "//h4[@class='added-removed-header']//i[@class='ute-icon-chevron-up']")
	WebElement chevronUp;

	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set ute-btn')]//ins[@translate='global.cta.removeChannel']")
	WebElement buttonRemoveChannelFromAlert;
	
	@FindBy(xpath = "//ins[@translate='global.label.bysThemePacksTab']/ancestor::h2")
	WebElement tabThemePacks;
	
	@FindBy(xpath = "//button[contains(@id,'add-themepack')]//ins[@translate='global.cta.add']")
	List<WebElement> addThemePack;
	
	@FindBy(xpath = "//button[@id='add-themepack-button']")
	List<WebElement> addThemePackListOnManageChannelsAndThemePacks;
	
	@FindBy(xpath = "//h3[@class='header-1 font-regular margin-0' and contains(text(),'Classic TV & Movies')]/ancestor::div[@class='row theme-header']//button[@id='add-themepack-button']")
	WebElement addThemePackClassicTVThemePacks;
	
	@FindBy(xpath = "//h3[@class='header-1 font-regular margin-0' and contains(text(),'Super Sports Pack (TP)')]/ancestor::div[@class='row theme-header']//button[@id='add-themepack-button']")
	WebElement addThemePackClassicTVThemePacks4plus1;
	
	
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement yesContinueOnExistingChannelAlert;
	
	@FindBy(xpath = "//ins[@usertype-translate='global.cta.confirmChanges']")
	WebElement clkConfirmChangesOnManageChannelsAndThemePacks;

	@FindBy(xpath = "//div[@class='tv-channel-body']//ins[@translate='global.cta.remove']")
	WebElement btnRemoveFromYourChanges;	
	
	@FindBy(xpath = "//div[@class='solaris-loader']")
	WebElement ldrThemepackChannel;
	
	@FindBy(xpath = "//div[@class='preloader loading-secondary']")
	WebElement ldrThemepack;
		
	@FindBy(xpath = "//span[@class='ute-icon-search noClickIcon']")
	WebElement btnSearchChannel;
	
	/**
	 * Click on add button of the first pack in theme pack in manage channels and theme pack
	 * @author chinnarao.vattam	 
	 */
	public void clkAddButtonOnThemePackListOnManageChannelsAndThemePacks() {
		//Taking more time to load all the themepacks
		reusableActions.waitForElementVisibility(addThemePackClassicTVThemePacks, 120);
		reusableActions.executeJavaScriptClick(addThemePackClassicTVThemePacks);		
	}		
	
	/**
	 * Click on add button of the first pack in theme pack in manage channels and theme pack
	 * @author chinnarao.vattam	 
	 */
	public void clkAddButtonOnThemePackListOnManageChannelsAndThemePacks4plus1() {
		//Taking more time to load all the themepacks
		reusableActions.waitForElementVisibility(addThemePackClassicTVThemePacks4plus1, 120);
		reusableActions.executeJavaScriptClick(addThemePackClassicTVThemePacks4plus1);		
	}
	/**
	 * Click on remove from your changes Manage channels and theme packs
	 * @author Saurav.Goyal	 
	 */
	public void clkRemoveFromYourChanges() {
		reusableActions.getWhenReady(btnRemoveFromYourChanges, 120).click();
	}	
	
	
	/**
	 * Click on Confirm changes While adding channels in Manage channels and theme packs
	 * @author chinnarao.vattam	 
	 */
	public void clkConfirmChangesOnManageChannelsAndThemePacks() {
		//Taking more time to load all the themepacks
		reusableActions.getWhenReady(clkConfirmChangesOnManageChannelsAndThemePacks, 120).click();
	}	
	
	/**
	 * Add first channel from the list
	 * @author chinnarao.vattam	 
	 */
	public void addChannel() {
		reusableActions.waitForElementVisibility(addChannelToCart, 60);
		reusableActions.getWhenReady(addChannelToCart, 30).click();
	}
	
	/**
	 * Add first channel from the list
	 * @param strInChannel  available channel
	 * @author chinnarao.vattam	 
	 */
	public void searchChannel(String strInChannel) {
		reusableActions.waitForElementVisibility(iconSearch,120);
		reusableActions.getWhenReady(iconSearch,20).click();
		reusableActions.getWhenReady(iconSearch, 30).sendKeys(strInChannel);	
		reusableActions.getWhenReady(btnSearchChannel,30).click();
	}
	
	/**
	 * Add first channel from the list
	 * @author chinnarao.vattam	 
	 */
	public void addChannelThemepack() {
		reusableActions.waitForElementInvisibility(ldrThemepack, 240);
		reusableActions.getWhenReady(addThemePackClassicTVThemePacks, 120).click();
	}
	
	/**
	 * Remove an added channel
	 * @author Saurav.Goyal	 
	 */
	public void removeChannel() {
		reusableActions.getWhenReady(removeParticularChannelFromCart, 120).click();
	}	
	
	
	/**
	 * Remove a theme pack
	 * @author Saurav.Goyal	 
	 */
	public void removeThemePack() {
		reusableActions.getWhenReady(removeParticularThemePackFromCart, 120).click();
	}	
	
	/**
	 * Click button to Remove channel in the alert
	 * @author Saurav.Goyal	 
	 */
	public void clkButtonRemoveChannelFromAlert() {
		reusableActions.getWhenReady(buttonRemoveChannelFromAlert, 180).click();
	}	
	
	
	/**
	 * Click theme pack tab
	 * @author chinnarao.vattam	 
	 */
	public void clkThemePacks() {
		reusableActions.staticWait(5000);
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.waitForElementVisibility(tabThemePacks, 180);
		reusableActions.getWhenReady(tabThemePacks, 120).click();
	}	
	
	/**
	 * Add first theme pack
	 * @author Saurav.Goyal	 
	 */
	public void addThemePacks() {
		reusableActions.waitForElementVisibility(addThemePack.get(0), 180);
		reusableActions.getWhenReady(addThemePack.get(0), 90).click();
	}	
	
	/**
	 * Click continue on existing channel alert window
	 * @author chinnarao.vattam	 
	 */
	public void clkContinueOnExistingChannelAlertWindow() {
		reusableActions.waitForElementVisibility(yesContinueOnExistingChannelAlert, 120);
		reusableActions.getWhenReady(yesContinueOnExistingChannelAlert, 120).click();
	}	
		
	/**
	 * Click on the ExchangeLater button 
	 * @author chinnarao.vattam
	 */
	public void clkExchangeLater() {
		reusableActions.getWhenReady(btnExchangeLater, 180).click();
	}
	
	/**
	 * Click on the continue from theme packs button
	 * @author chinnarao.vattam
	 */
	public void clkContinueFromThemepacks() {
		//Need time to load all the TV packages
		reusableActions.staticWait(7000);
/*		reusableActions.waitForElementVisibility(addParticularChannelToCart.get(0), 240);*/
		reusableActions.getWhenReady(btnContinueFromThemepacks, 120).click();
	}
	
	/**
	 * Click on the "YesIHave4K" button
	 * @author chinnarao.vattam
	 */
	public void clkYesIHave4K() {
		reusableActions.getWhenReady(btnYesIHave4K, 90).click();
	}

	/**
	 * Click on the "YesIHave4K" button
	 * @author chinnarao.vattam
	 */
	public void clkYesIHave4KMobile() {
		reusableActions.getWhenReady(btnYesIHave4KMobile, 90).click();
	}

	/**
	 * Click on the "4KContent" button
	 * @author chinnarao.vattam
	 */
	public void clk4KContent() {
		reusableActions.getWhenReady(btn4KContent, 180).click();
	}
	
}
