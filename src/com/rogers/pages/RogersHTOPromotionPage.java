package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersHTOPromotionPage extends BasePageClass {


	public RogersHTOPromotionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[contains(@class,'dsa-billboard__overline')]")
	WebElement txtSpecialOffer;

	@FindBy(xpath = "//div[@class='current-bundle-details']")
	WebElement divCurrentBundleContainer;

	@FindBy(xpath = "//h2[contains(text(),'old')]")
	WebElement txtCurrentBundle;

	@FindBy(xpath = "//h2[contains(text(),'new') or contains(text(),'nouvelle')]")
	WebElement txtOfferBundle;

	@FindBy(xpath = "//h2[contains(text(),'current') or contains(text(),'actuelle')]")
	WebElement txtIgniteCurrentBundle;


	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement chkUpgrade;

	@FindBy(xpath ="//div[@class='ng-star-inserted overlay nsm-overlay-open']")
	WebElement overlayPromoPage;

	@FindBy(xpath = "//a[contains(@aria-label,'upgrade') or contains(@aria-label,'Upgrade')]/span")
	WebElement btnReviewYourUpgrade;

	@FindBy(xpath = "//div[contains(@class,'progress-loader')]")
	WebElement divProgressLoader;

	@FindBy(xpath = "//a[contains(@aria-label,'Upgrade to')]")
	WebElement btnUpgradeNow;

	@FindBy(xpath = "//div[@class='bundle-offer-details']")
	WebElement divOfferBundleContainer;

	@FindBy(xpath = "//h3[contains(text(),' New Ignite features')]//following-sibling::button//span[text()='Learn more']")
	WebElement lnkLearnMore;

	@FindBy(xpath = "//div[@class='bundle-offer-details__content__price']//div[contains(@class, 'ds-price__amountDollars')]")
	WebElement divOfferPrice;

	@FindBy(xpath = "//div[contains(@class, 'promotion-banner')]//h3")
	WebElement divBundleCredit;

	@FindBy(xpath = "//div[@class='bundle-offer-details__tile']//span[@class='text-body-sm']")
	WebElement divCurrentBundlePrice;


	@FindBy(xpath = "//button[contains(@aria-label ,'Learn more') or contains(@aria-label ,'Détails')]/span")
	WebElement lnkIgniteLearnMore;

	@FindBy(xpath = "//button[@aria-label='View next Ignite feature']/span")
	WebElement btnViewNextFeature;

	@FindBy(xpath = "//button[@aria-label='View previous Ignite feature']/span")
	WebElement btnViewPreviousFeature;

	@FindBy(xpath = "//button[@aria-label='Close this pop-up' or @title='Press to close']/span")
	WebElement btnCloseThisPopup;

	@FindBy(xpath = "//button[contains(@class,'custom-button-channel')]/span")
	WebElement lnkAvailableChannels;

	@FindBy(xpath = "//button[contains(@class,'custom-button-channel') and contains(@aria-label,'Flex Channels')]/span")
	WebElement lnkFlexChannels;

	@FindBy(xpath = "//button[@title='Press to close']/span")
	WebElement btnCloseAvailableChannelsPopup;

	@FindBy(xpath = "//button[@title='Press to close']/span")
	WebElement btnCloseFlexChannelsPopup;

	@FindBy(xpath = "//div[@class='view-channels-modal-component popup-modal-component']")
	WebElement divAvailableChannelsPopupModal;

	@FindBy(xpath = "//div[@class='view-channels-modal-component popup-modal-component']")
	WebElement divFlexChannelsPopupModal;

	@FindBy(xpath = "//div[@class='popup-modal-component']")
	WebElement divSorryPopupModal;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-warning ds-color-warning']")
	WebElement imgWarningIcon;

	@FindBy(xpath = "//h1[@aria-labelledby='ariaPopupHeader']")
	WebElement headerSorry;

	@FindBy(xpath = "//span[@class='-ml4' and contains(text(),'Sorry')]")
	WebElement txtSorry;

	@FindBy(xpath = "//a[@aria-label='Contact Rogers now to change your package']")
	WebElement lnkContactUS;

	@FindBy(xpath = "//a[@aria-label='Live Chat with an agent to continue your order ']")
	WebElement lnkLiveChat;

	@FindBy(xpath = "//a[@aria-label='Call 1 833 32-FIBRE to continue your order']")
	WebElement lnkCall;

	@FindBy(xpath = "//button[contains(@aria-label,'Flex Channels')]/span")
	WebElement btnViewFlexChannels;

		@FindBy(xpath = "//button[contains(@aria-label,'flex channels in this bundle') or contains(@aria-label,'chaînes flexibles comprises dans cette offre groupée')]/span")
	WebElement btnIgniteViewFlexChannels;

		@FindBy(xpath = "//button[contains(@aria-label,'total channels') or contains(@aria-label,'chaînes comprises dans cette offre groupée')]/span")
	WebElement btnViewTotalChannels;

	@FindBy(xpath = "//div[@class='price-strikethrough copy-red']/div")
	WebElement txtStrikeThrough;

	@FindBy(xpath = "//div[@class='-mr16'] | //span[@class='ds-icon d-inline-flex rds-icon-check']")
	WebElement imgPromoDiscounts;

	@FindBy(xpath = "//a[contains(@aria-label,'Change to the') or contains(@aria-label,'maintenant')]/span[@role='text']")
	WebElement lnkGetItNowPromoPage;

	@FindBy(xpath = "//ds-modal[@hasclosebutton='false']")
	WebElement loadingPopupModel;

	@FindBy(xpath= "//p[contains(@class,'dsa-hero-billboard__overline')]")
	WebElement txtPersonalizedOffer;

	@FindBy(xpath = "//div[@class='ignite-hto-promo-tiles-component']")
	WebElement divIgniteBundleContainer;

	@FindBy(xpath = "//button//span[text()='Additional channels and Theme Packs']")
	WebElement lnkAdditionalChannelsAndThemePacks;

	/**
	 * To verify the Home page
	 * @return true if the special offer text is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyPromotionPage() {
		return getReusableActionsInstance().isElementVisible(txtSpecialOffer, 90);
	}

	/**
	 * To verify the Home page
	 * @return true if the special offer text is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyIgnitePromotionPage() {
		return getReusableActionsInstance().isElementVisible(txtPersonalizedOffer, 90);
	}

	/**
	 * To verify the Current Bundle Container
	 * @return true if the old bundle details is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCurrentBundle() {
		getReusableActionsInstance().waitForElementVisibility(divCurrentBundleContainer, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		return getReusableActionsInstance().isElementVisible(txtCurrentBundle, 30);
	}

	/**
	 * To verify the Ignite Current Bundle Container
	 * @return true if the old bundle details is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyIgniteCurrentBundle() {
		getReusableActionsInstance().waitForElementVisibility(divIgniteBundleContainer, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		return getReusableActionsInstance().isElementVisible(txtIgniteCurrentBundle, 30);
	}

	/**
	 * To verify the Offer Bundle Container
	 * @return true if the new bundle details is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyOfferBundle() {
//		getReusableActionsInstance().waitForElementVisibility(divOfferBundleContainer, 30);
		return getReusableActionsInstance().isElementVisible(txtOfferBundle, 60);
	}

	public String getOfferBundlePrice() {
		getReusableActionsInstance().waitForElementVisibility(divOfferPrice, 30);
		String bundleOfferPrice = getReusableActionsInstance().getWhenReady(divOfferPrice, 60).getText();
		return bundleOfferPrice;
	};

	/**
	 * Gets the monthly promotional credit amount from 'Promotions and discounts' section. (e.g. Get $x.xx off per month)
	 * @author nandan.master
	 */
	public String getPromoCreditPerMonth(){
		getReusableActionsInstance().waitForElementVisibility(divBundleCredit, 30);
		String promoCreditTxt = getReusableActionsInstance().getWhenReady(divBundleCredit, 60).getText();
		String[] subs = promoCreditTxt.split("\\$");
		String[] promoCreditInLine = subs[1].split(" ");
		return promoCreditInLine[0];
	};

	/**
	 * Gets the monthly promotional credit amount from 'Promotions and discounts' section. (e.g. Get $x.xx off per month)
	 * @author nandan.master
	 */
	public String getCurrentBundlePrice(){
		getReusableActionsInstance().waitForElementVisibility(divCurrentBundlePrice, 30);
		String promoCreditTxt = getReusableActionsInstance().getWhenReady(divCurrentBundlePrice, 60).getText();
		String[] subs = promoCreditTxt.split("\\$");
		String[] promoCreditInLine = subs[1].split(" ");
		return promoCreditInLine[0];
	};

	/**
	 * To Click on Upgrade checkbox
	 * @author Manpreet.Kaur3
	 */
	public void clickIWantThisUpgrade() {
		getReusableActionsInstance().clickIfAvailable(chkUpgrade, 40);
		getReusableActionsInstance().waitForElementInvisibilityNOException(overlayPromoPage,10);
		getReusableActionsInstance().staticWait(2000);
	}

	/**
	 * To Click on Review your Upgrade button
	 * @author Manpreet.Kaur3
	 */
	public void clickReviewYourUpgrade() {
		getReusableActionsInstance().waitForElementVisibility(btnReviewYourUpgrade, 30);
		getReusableActionsInstance().clickWhenReady(btnReviewYourUpgrade, 60);
	}

	public void waitForProgressLoaderToComplete(){
		getReusableActionsInstance().waitForElementInvisibility(divProgressLoader, 200);
	}
	/**
	 * To Click on Learn More link
	 * @author Manpreet.Kaur3
	 */
	public void clickLearnMore() {
		getReusableActionsInstance().clickWhenReady(lnkLearnMore, 120);
	}

	/**
	 * To Click on Learn More link
	 * @author Manpreet.Kaur3
	 */
	public void clickIgniteLearnMore() {
		getReusableActionsInstance().clickIfAvailable(lnkIgniteLearnMore, 30);
	}

	/**
	 * To Click on View Next Feature Button
	 * @author Manpreet.Kaur3
	 */
	public void clickViewNextFeature() {
		getReusableActionsInstance().clickIfAvailable(btnViewNextFeature, 30);
	}

	/**
	 * To Click on View Previous Feature Button
	 * @author Manpreet.Kaur3
	 */
	public void clickViewPreviousFeature() {
		getReusableActionsInstance().clickWhenReady(btnViewPreviousFeature, 30);
	}

	/**
	 * To Click on Close This Popup Button
	 * @author Manpreet.Kaur3
	 */
	public void clickClosePopup() {
		try {
			getReusableActionsInstance().clickIfAvailable(btnCloseThisPopup, 30);
		}catch (TimeoutException e){
			System.out.println("Popup is unavailable to close.");
		}
	}

	/**
	 * To verify the Offer is displayed right on order review page
	 * @return true if it matches the offer price on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyBundleOfferPrice(String offerPrice, String customPrice) {
		return offerPrice.equals(customPrice);
	}

	/**
	 * To Click on Available Channels Link
	 * @author Manpreet.Kaur3
	 */
	public void clkAvailableChannelsLink() {
		getReusableActionsInstance().clickWhenReady(lnkAvailableChannels, 30);
	}

	/**
	 * To verify Available Channels Popup Modal on the learn page
	 * @return true if it matches the Popup Model is present on the offers Page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyAvailableChannelsPopupModal() {
		return getReusableActionsInstance().isElementVisible(divAvailableChannelsPopupModal,30);
	}

	/**
	 * To Click on Close This Popup Button
	 * @author Manpreet.Kaur3
	 */
	public void clkCloseAvailableChannelsPopupModal() {
		getReusableActionsInstance().clickWhenReady(btnCloseAvailableChannelsPopup, 30);
	}

	/**
	 * To Click on Flex Channels
	 * @author Manpreet.Kaur3
	 */
	public void clkFlexChannelsLink() {
		getReusableActionsInstance().clickWhenReady(lnkFlexChannels, 30);
	}

	/**
	 * To Click on Close This Popup Button
	 * @author Manpreet.Kaur3
	 */
	public void clkCloseFlexChannelsPopupModal() {
		getReusableActionsInstance().clickWhenReady(btnCloseFlexChannelsPopup, 30);
	}

	/**
	 * To verify Flex Channels Popup Modal on the offers page
	 * @return true if it matches the Popup Model is present on the offers Page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyFlexChannelsPopupModal() {
		return getReusableActionsInstance().isElementVisible(divFlexChannelsPopupModal,30);
	}

	/**
	 * To Click on Upgrade Now button
	 * @author Manpreet.Kaur3
	 */
	public void clickUpgradeNow() {
		getReusableActionsInstance().waitForElementVisibility(btnUpgradeNow, 30);
		getReusableActionsInstance().getWhenReady(btnUpgradeNow, 60).click();
	}

	/**
	 * To verify the LTQ Modal after Learn Page for downgrade HTO Package
	 * @return true if popup modal is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyDowngradeLTQModal() {
		return getReusableActionsInstance().isElementVisible(divSorryPopupModal,40);
	}

	/**
	 * To verify the Warning Icon for LTQ Modal
	 * @return true if warning icon img is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyWarningIconSorryModal() {
		return getReusableActionsInstance().isElementVisible(imgWarningIcon,10);
	}

	/**
	 * To verify the header for LTQ Modal
	 * @return true if header is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyPopUpHeader() {
		return getReusableActionsInstance().isElementVisible(headerSorry,10);
	}

	/**
	 * To verify the Sorry Header for LTQ Modal
	 * @return true if Sorry Header is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifySorryHeader() {
		return getReusableActionsInstance().isElementVisible(txtSorry,10);
	}

	/**
	 * To verify the Call Us Link for LTQ Modal
	 * @return true if Call Us Link img is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCallLink() {
		return getReusableActionsInstance().isElementVisible(lnkCall,10);
	}

	/**
	 * To verify the Live Chat link for LTQ Modal
	 * @return true if Live Chat link is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyLiveChatLink() {
		return getReusableActionsInstance().isElementVisible(lnkLiveChat,30);
	}

	/**
	 * To verify the Contact Us Link for LTQ Modal
	 * @return true if contact us link is present, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyContactUsLink() {
		return getReusableActionsInstance().isElementVisible(lnkContactUS,30);
	}

	/**
	 * Click the View Total Channels button
	 * @author manpreet.kaur3
	 */
	public void clickViewTotalChannels() {
		getReusableActionsInstance().getWhenReady(btnViewTotalChannels, 30).click();
    }

	/**
	 * Verify Strike through price is present
	 * @return true is strike through price available, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyPriceStrikeThrough() {
		return getReusableActionsInstance().isElementVisible(txtStrikeThrough, 5);
	}

	/**
	 * Verify Promo Discounts is present
	 * @return true if promo discount available, else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyPromoDiscounts() {
		return getReusableActionsInstance().isElementVisible(imgPromoDiscounts, 5);
	}

	/**
	 * Click Get it Now button on TV & Streaming page
	 * @author manpreet.kaur3
	 */
	public void clkGetItNow(){
		getReusableActionsInstance().waitForElementVisibility(lnkGetItNowPromoPage, 60);
		getReusableActionsInstance().getWhenReady(lnkGetItNowPromoPage,30).click();
		getReusableActionsInstance().waitForPageLoad();
	}

	/**
	 * Click the View Flex Channels button
	 * @author manpreet.kaur3
	 */
	public void clickViewFlexChannels() {
		getReusableActionsInstance().getWhenReady(btnViewFlexChannels, 30).click();
	}

	/**
	 * Click the View Flex Channels button
	 * @author manpreet.kaur3
	 */
	public void clickIgniteViewFlexChannels() {
		getReusableActionsInstance().getWhenReady(btnIgniteViewFlexChannels, 30).click();
	}

	/**
	 * Wait for the loading popup to be closed
	 * @return void
	 * @author Karthick.Murugiah
	 */

	public void waitForPopupToDisappear(){
		boolean elementVisible = getReusableActionsInstance().isElementVisible(loadingPopupModel, 45);
		if(elementVisible){
			getReusableActionsInstance().waitForElementInvisibility(By.xpath("//ds-modal[@hasclosebutton='false']"),240);
		}
	}

	public void clickAdditionChannelsAndThemePacks(){
		try {
			getReusableActionsInstance().clickWhenReady(lnkAdditionalChannelsAndThemePacks, 20);
		}catch (Exception e){
			System.out.println("Unable to click on Additional Channels and Themepacks");
			e.printStackTrace();
		}
	}
}

