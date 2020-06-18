package com.rogers.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSolarisTVChannelsAndThemepacksPage extends BasePageClass {

	public RogersSolarisTVChannelsAndThemepacksPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//ins[@translate='global.cta.continue']")
	WebElement btnContinueFromThemepacks;
	
	@FindBy(xpath = "//div[contains(@class,'ute-btn-group-set-accessibility')]//ins[@usertype-translate='global.cta.yesIHave4K']")
	WebElement btnYesIHave4K;
	
	@FindBy(xpath = "//button[contains(@class,'continue-btn-4k')]//ins[@translate='global.cta.continue']")
	WebElement btn4KContent;
	
	@FindBy(xpath = "//ins[@translate='global.cta.bysSwapLaterContinue']")
	WebElement btnExchangeLater;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//div[@class='channel-list-row']//button[@class='ute-btn-primary ute-sm ute-short']//ins")
	List<WebElement> addParticularChannelToCart;
	
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
	
	@FindBy(xpath = "//button[@class='ute-btn-primary ute-md']")
	WebElement yesContinueOnExistingChannelAlert;
	
	@FindBy(xpath = "//ins[@usertype-translate='global.cta.confirmChanges']")
	WebElement clkConfirmChangesOnManageChannelsAndThemePacks;

	@FindBy(xpath = "//div[@class='tv-channel-body']//ins[@translate='global.cta.remove']")
	WebElement btnRemoveFromYourChanges;
	
	/**
	 * Click on add button of the first pack in theme pack in manage channels and theme pack
	 * @author chinnarao.vattam	 
	 */
	public void clkAddButtonOnThemePackListOnManageChannelsAndThemePacks() {
		reusableActions.waitForElementVisibility(addThemePackListOnManageChannelsAndThemePacks.get(0), 240);
		reusableActions.getWhenReady(addThemePackListOnManageChannelsAndThemePacks.get(0), 60).click();
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
		reusableActions.getWhenReady(clkConfirmChangesOnManageChannelsAndThemePacks, 120).click();
	}	
	
	/**
	 * Add first channel from the list
	 * @author Saurav.Goyal	 
	 */
	public void addChannel() {
		reusableActions.staticWait(5000);
		reusableActions.waitForElementVisibility(addParticularChannelToCart.get(0), 240);
		reusableActions.getWhenReady(addParticularChannelToCart.get(0), 90).click();
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
		reusableActions.getWhenReady(yesContinueOnExistingChannelAlert, 120).click();
	}	
		
	/**
	 * Click on the ExchangeLater button 
	 * @author chinnarao.vattam
	 */
	public void clkExchangeLater() {
		reusableActions.getWhenReady(btnExchangeLater, 120).click();
	}
	
	/**
	 * Click on the continue from theme packs button
	 * @author chinnarao.vattam
	 */
	public void clkContinueFromThemepacks() {
		reusableActions.getWhenReady(btnContinueFromThemepacks, 30).click();
	}
	
	/**
	 * Click on the "YesIHave4K" button
	 * @author chinnarao.vattam
	 */
	public void clkYesIHave4K() {
		reusableActions.getWhenReady(btnYesIHave4K, 30).click();
	}
	
	/**
	 * Click on the "4KContent" button
	 * @author chinnarao.vattam
	 */
	public void clk4KContent() {
		reusableActions.getWhenReady(btn4KContent, 120).click();
	}
	
}
