package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersShippingPage extends BasePageClass {

	public RogersShippingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h2/span[@checkout-res='checkout_shipping_info']")
	WebElement lblShippingTitle;
		
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.getWhenReady(lblShippingTitle);
		reusableActions.staticWait(2000);
		reusableActions.clickWhenReady(btnContinue);
		reusableActions.waitForElementVisibility(btnContinue,60);
	}
	
}