package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersOrderConfirmationPage extends BasePageClass {

	public RogersOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='info-bubble ute-large-right']")
	WebElement infoSubmit;
	
	@FindBy(xpath = "//a[@href='/consumer/rogers-internet' and @class='rui-cta-button']")
	WebElement btnContinueShopping;
	
	// Thanks! We received your order. 
	@FindBy(xpath = "//div[@class='confirmation-bubble']")
	WebElement infoChangeOrderConfirmationnew;
	
	@FindBy(xpath = "//ins[@translate='global.message.orderConfirmationThanksV3']")
	WebElement infoChangeOrderConfirmation;
	//ins[@translate='global.message.orderConfirmationThanksV3']

	@FindBy(xpath = "//img[@src='/cms/rogers/page-specific/shop/ordersummary/thankyou/images/thankyou-badge-desktop.png']")
	WebElement infoChangeOrderConfirmationLegacy;
	
	@FindBy(xpath = "//div[@class='confirmation-bubble']")
	WebElement infoOrderConfirmation;
	//ins[@translate='global.message.orderConfirmationThanksV2']

	@FindAll({
		@FindBy(xpath = "//span[@class='thank-you']"),
		@FindBy(xpath = "//span[@class='UConfirmationHeading']"),
		@FindBy(xpath = "//p[@class='text-body mb-40 ng-star-inserted']")
	})	
	WebElement lblThankYou;

	@FindAll({
		@FindBy(xpath = "//h1[@id='bfa-page-title']"),
		@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	})
	WebElement lblOrderConfirmation;
	
	@FindBy(xpath = "//div[@class='orderSummary']")
	WebElement btnDTVOrderSummary;
	
	@FindBy(className = "shoppingCartCheckOutButton")
	WebElement btnUpgradeCartCheckOutButton;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;

	@FindAll({
			@FindBy(xpath = "//ds-expander[@id='orderTable-refId-11']//div[@class='ds-price']"),
			@FindBy(xpath = "//span[@checkout-res='checkout_order_summary_total']")
	})
	WebElement lblOrderSummaryTotal;	
	
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmationLegacy() {
		getReusableActionsInstance().waitForElementVisibility(infoChangeOrderConfirmationLegacy,90);
		return getReusableActionsInstance().isElementVisible(infoChangeOrderConfirmationLegacy, 30);
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmation() {
		return getReusableActionsInstance().isElementVisible(infoOrderConfirmation, 120);
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmationNew() {
		return getReusableActionsInstance().isElementVisible(infoChangeOrderConfirmationnew, 120);
	}
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderSuccess() {
		getReusableActionsInstance().waitForElementVisibility(infoOrderConfirmation,90);
		return getReusableActionsInstance().isElementVisible(infoOrderConfirmation, 30);
	}
	
	
	/**
	 * Verify the Continue Shopping button on order confirmation page
	 * @return true if the page display Continue Shopping button, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyContinueShopping() {
		return getReusableActionsInstance().isElementVisible(btnContinueShopping, 10);
	}
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		getReusableActionsInstance().staticWait(10000);
		return getReusableActionsInstance().isElementVisible(lblOrderConfirmation, 60);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyThankYouDisplayed() {
		getReusableActionsInstance().waitForElementVisibility(lblOrderSummaryTotal, 60);
		if(lblThankYou.isDisplayed()) {
			return getReusableActionsInstance().isElementVisible(lblThankYou,60);
		}
		return false;
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLegacyUpgardeOrderConfirmation() {
		return getReusableActionsInstance().isElementVisible(btnDTVOrderSummary, 180);
	}
	
	/**
	 * click on  the CheckOut Button
	 * @author chinnarao.vattam
	 */
	public void clkUpgradeCartCheckOutButton() {
		getReusableActionsInstance().waitForElementVisibility(btnUpgradeCartCheckOutButton, 180);
		getReusableActionsInstance().executeJavaScriptClick(btnUpgradeCartCheckOutButton);
	}
}
