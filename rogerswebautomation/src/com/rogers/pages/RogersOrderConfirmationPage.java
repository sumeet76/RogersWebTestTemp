package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath = "//ins[@translate='global.message.orderConfirmationThanksV3']")
	WebElement infoChangeOrderConfirmation;
	
	@FindBy(xpath = "//span[@class='thank-you']")
	WebElement lblThankYou;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	WebElement lblOrderConfirmation;
	
	@FindBy(xpath = "//div[@class='orderSummary']")
	WebElement btnDTVOrderSummary;
	
	@FindBy(className = "shoppingCartCheckOutButton")
	WebElement btnUpgradeCartCheckOutButton;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmation() {
		reusableActions.waitForElementInvisibility(popupLoadingFingers,180);
		return reusableActions.isElementVisible(infoSubmit, 60);
	}
	
	/**
	 * Verify the Continue Shopping button on order confirmation page
	 * @return true if the page display Continue Shopping button, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyContinueShopping() {
		return reusableActions.isElementVisible(btnContinueShopping, 10);
	}
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		return reusableActions.isElementVisible(lblOrderConfirmation, 120);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 */
	public boolean verifyThankYouDisplayed() {
		return reusableActions.isElementVisible(lblThankYou);
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLegacyUpgardeOrderConfirmation() {
		return reusableActions.isElementVisible(btnDTVOrderSummary, 180);
	}
	
	/**
	 * click on  the CheckOut Button
	 * @author chinnarao.vattam
	 */
	public void clkUpgradeCartCheckOutButton() {
		reusableActions.waitForElementVisibility(btnUpgradeCartCheckOutButton, 180);
		reusableActions.executeJavaScriptClick(btnUpgradeCartCheckOutButton);
	}
}
