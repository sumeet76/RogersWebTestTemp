package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersDigitalTVDashboardPage extends BasePageClass {

	public RogersDigitalTVDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@translate='tv_package_change']")
	WebElement btnChangeMyPackage;

	@FindBy(xpath = "//span[@translate='tv_change_bonus_channel']")
	WebElement btnChangeBonusChannel;
	
	@FindBy(xpath = "//span[@translate='tv_add_themes']")
	WebElement btnTVAddThemes;
	
	@FindBy(xpath = "//span[@translate='tv_add_channels']")
	WebElement btnTVAddChannels;
	
	@FindBy(xpath = "//div[@class='modal-content']//div[@class='main-modal totes-project']")
	WebElement popupContactCustomercareForDigitalTVDowngradeFr;
	
	@FindBy(xpath = "//div[@class='ute-btn-primary']//a[@href='/web/consumer/ignite-bundles/tv-internet']")
	WebElement btnBuyNowIgnite;
	
	
	
	/**
	 * To verify the change package button on the legacy TV dash board
	 * @return true, if  ChangeMyPackage button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */	
	public boolean verifyChangeMyPackage() {
		return reusableActions.isElementVisible(btnChangeMyPackage,60);
	}

	/**
	 * Click on the  the change package button on the legacy TV dash board 
	 * @author chinnarao.vattam 
	 */	
	public void clkChangeMyPackage() {
		reusableActions.isElementVisible(btnChangeMyPackage,180);
		reusableActions.getWhenReady(btnChangeMyPackage,180).click();
	}
	
	/**
	 * To verify the Change Bonus Channel button on the legacy TV dash board
	 * @return true, if  ChangeBonusChannel button is visible on Digital TV Dashboard Page 
	 * @author chinnarao.vattam 
	 */
	public boolean verifyChangeBonusChannel() {
		return reusableActions.isElementVisible(btnChangeBonusChannel,20);
	}
	
	/**
	 * To verify the TV Add Themes button on the legacy TV dash board 
	 * @return true, if  TVAddThemes button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */
	public boolean verifyTVAddThemes() {
		return reusableActions.isElementVisible(btnTVAddThemes,20);
	}
	
	/**
	 * To verify the TV Add Channels button on the legacy TV dash board 
	 * @return true, if  TVAddChannels button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */
	public boolean verifyTVAddChannels() {
		return reusableActions.isElementVisible(btnTVAddChannels,20);
	}
	
	/**
	 * To verify the Contact Customer care Popup For TV Down grade French language 
	 * @return true, if the Contact Customer care Popup For TV Down grade French language else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyContactCustomercarePopupForFr() {
		return reusableActions.isElementVisible(popupContactCustomercareForDigitalTVDowngradeFr,30);
	}
	
	/**
	 * Verify the  the buy now button on the legacy TV dash board
	 * @return true, if the DTV dash board has the buy now option else false 
	 * @author chinnarao.vattam 
	 */	
	public boolean verifyBuyNowIgnite() {
		return reusableActions.isElementVisible(btnBuyNowIgnite,60);
	}
	
	/**
	 * Click on the  the buy now button on the legacy TV dash board 
	 * @author chinnarao.vattam 
	 */	
	public void clkBuyNowIgnite() {
		reusableActions.javascriptScrollByVisibleElement(btnBuyNowIgnite);
		reusableActions.moveToElementAndClick(btnBuyNowIgnite,30);		
	}	
}
