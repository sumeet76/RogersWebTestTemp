package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersDigitalTVDashboardPage extends BasePageClass {

	public RogersDigitalTVDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@translate='tv_package_change']")
	WebElement btnChangeMyPackage;

	@FindBy(xpath = "//span[contains(@translate,'tvAddChannelsSupportPhoneNumber')]")
	WebElement txtSupportPhoneNumber;

	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-4 col-md-3 col-lg-3']/div/div[@class='plan-cta']")
	WebElement divPackageBlock;

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

	@FindBy(xpath = "//button[@id='ctaViewLineUp']//span[text()='View my channel lineup']")
	WebElement lnkViewMyChannels;

	@FindBy(xpath = "//div[@class='tv-page-component']//button//span[text()='View my Flex Channels']")
	WebElement lnkViewMyFlexChannels;

	@FindBy(xpath = "//button[@title='Press to close']")
	WebElement closeViewChannelsPopup;

	@FindBy(xpath="//button[@aria-label='Reset Digital Pin']/span")
	WebElement lnkResetDigitalPin;

	@FindBy(xpath="//button[contains(@aria-label,'Reset Digital Box')]/span")
	WebElement lnkResetDigitalBox;

	@FindBy(xpath = "//div[@class='ds-radioButton__outerCircle my-12']")
	WebElement rdoResetDigitalPin;

	@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continue')]")
	WebElement btnResetContinue;

	@FindBy(xpath="//span[contains(@class,'color-success')]")
	WebElement successResetIcon;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement btnOk;

	@FindBy(xpath="//button[@aria-label='Cancel']")
	WebElement btnCancelResetBox;

	@FindBy(xpath= "//span[text()= 'Cancel']")
	WebElement btnCancelResetPin;

	@FindBy(xpath="//span[contains(@class,'rds-icon-close')]/ancestor::span[@role='text']")
	WebElement btnClose;

	/**
	 * To verify the change package button on the legacy TV dash board
	 * @return true, if  ChangeMyPackage button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */	
	public boolean verifyChangeMyPackage() {
		return getReusableActionsInstance().isElementVisible(btnChangeMyPackage,60);
	}

	/**
	 *	To verify whether Package Block is present or not on the TV dashboard
	 * @return true, if Package Block is present on Digital TV Dashboard Page
	 * @author manpreet.kaur3
	 */
	public boolean isPackageBlock() {
		return getReusableActionsInstance().isElementVisible(divPackageBlock,45);
	}

	/**
	 *	To verify the Chat Block on the TV dashboard
	 * @return true, if support call number is visible on Digital TV Dashboard Page
	 * @author manpreet.kaur3
	 */
	public boolean verifyChatBlock() {
		return getReusableActionsInstance().isElementVisible(txtSupportPhoneNumber,60);
	}

	public boolean verifyChangeMyPackageMobile() {
		return getReusableActionsInstance().isElementVisible(btnChangeMyPackage,110);
	}
	/**
	 * Click on the  the change package button on the legacy TV dash board 
	 * @author chinnarao.vattam 
	 */	
	public void clkChangeMyPackage() {
		getReusableActionsInstance().isElementVisible(btnChangeMyPackage,90);
		getReusableActionsInstance().getWhenReady(btnChangeMyPackage,30).click();
	}
	/**
	 * Click on the  the View my channels link on the legacy TV dash board
	 * @author dharani.up
	 */
	public void clkViewMyChannelsLink() {
		getReusableActionsInstance().waitForElementTobeClickable(lnkViewMyChannels,60);
		getReusableActionsInstance().moveToElementAndClick(lnkViewMyChannels,30);
	}
	
	/**
	 * To verify the Change Bonus Channel button on the legacy TV dash board
	 * @return true, if  ChangeBonusChannel button is visible on Digital TV Dashboard Page 
	 * @author chinnarao.vattam 
	 */
	public boolean verifyChangeBonusChannel() {
		return getReusableActionsInstance().isElementVisible(btnChangeBonusChannel,20);
	}
	
	/**
	 * To verify the TV Add Themes button on the legacy TV dash board 
	 * @return true, if  TVAddThemes button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */
	public boolean verifyTVAddThemes() {
		return getReusableActionsInstance().isElementVisible(btnTVAddThemes,20);
	}
	
	/**
	 * To verify the TV Add Channels button on the legacy TV dash board 
	 * @return true, if  TVAddChannels button is visible on Digital TV Dashboard Page
	 * @author chinnarao.vattam 
	 */
	public boolean verifyTVAddChannels() {
		return getReusableActionsInstance().isElementVisible(btnTVAddChannels,20);
	}
	
	/**
	 * To verify the Contact Customer care Popup For TV Down grade French language 
	 * @return true, if the Contact Customer care Popup For TV Down grade French language else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyContactCustomercarePopupForFr() {
		return getReusableActionsInstance().isElementVisible(popupContactCustomercareForDigitalTVDowngradeFr,30);
	}
	
	/**
	 * Verify the  the buy now button on the legacy TV dash board
	 * @return true, if the DTV dash board has the buy now option else false 
	 * @author chinnarao.vattam 
	 */	
	public boolean verifyBuyNowIgnite() {
		return getReusableActionsInstance().isElementVisible(btnBuyNowIgnite,60);
	}
	
	/**
	 * Click on the  the buy now button on the legacy TV dash board 
	 * @author chinnarao.vattam 
	 */	
	public void clkBuyNowIgnite() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnBuyNowIgnite);
		getReusableActionsInstance().moveToElementAndClick(btnBuyNowIgnite,30);
	}

	public void clkviewMyFlexChannels() {
		getReusableActionsInstance().waitForElementTobeClickable(lnkViewMyFlexChannels,30);
		getReusableActionsInstance().moveToElementAndClick(lnkViewMyFlexChannels,30);
	}

	public void clkCloseViewMyChannels(){
		getReusableActionsInstance().waitForElementTobeClickable(closeViewChannelsPopup,20);
		getReusableActionsInstance().clickIfAvailable(closeViewChannelsPopup);
	}

	public boolean verifySuccessIcon() {
		return getReusableActionsInstance().isElementVisible(successResetIcon, 180);
	}

	public void clkOkContinue() {
		getReusableActionsInstance().getWhenReady(btnOk, 90).click();
	}

	public void clkResetContinue() {
		getReusableActionsInstance().getWhenReady(btnResetContinue, 90).click();
	}

	public void clkRadioDigitalPin() {
		getReusableActionsInstance().getWhenReady(rdoResetDigitalPin, 90).click();
	}

	public void clkResetDigitalBox() {
		getReusableActionsInstance().getWhenReady(lnkResetDigitalBox, 90).click();
	}

	public void clkResetDigitalPin() {
		getReusableActionsInstance().executeJavaScriptClick(lnkResetDigitalPin);
	}

	public void clkResetBoxCancel() {
		getReusableActionsInstance().getWhenReady(btnCancelResetBox, 90).click();
	}

	public void clkResetPinCancel() {
		getReusableActionsInstance().getWhenReady(btnCancelResetPin, 90).click();
	}

	public void clkResetClose() {
		getReusableActionsInstance().getWhenReady(btnClose, 90).click();
	}
}
