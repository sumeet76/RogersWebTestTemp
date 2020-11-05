package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersPPCOrderConfirmationPage extends BasePageClass {

	public RogersPPCOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='thank-you']")
	WebElement lblThankYou;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	WebElement lblOrderConfirmation;
	
	@FindBy(xpath = "//div[@class='total-amount']/div/span")
	WebElement lblPricePlanAmount;
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		return getReusableActionsInstance().isElementVisible(lblOrderConfirmation, 60);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 */
	public boolean verifyThankYouDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblThankYou);
	}
	
	/**
	 * Returns the Amount of the Price Plan in the Order Confirmation
	 * @return Amount in Decimal format
	 */
	public float getPricePlanAmount() {
		return Float.parseFloat(lblPricePlanAmount.getText().replace("$", "").trim());
	}

}