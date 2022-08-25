package com.rogers.oneview.pages;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class  RogersOVOrderConfirmationPage  extends BasePageClass {

	public RogersOVOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='text-title-2 text-bold mb-0 text-left']")
//	@FindBy(xpath = "//*[text()='We received the order.']")
	WebElement orderConfirmation;
	
	@FindAll({
		@FindBy(xpath = "//span[@class='UConfirmationHeading']"),
		@FindBy(xpath = "//span[@class='thank-you']")
	})	
	WebElement lblThankYou;

	@FindAll({
			@FindBy(xpath = "//h1[contains(@id,'bfa-page-title') and contains(.,'Confirmation')]"),
			@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	})
	WebElement lblOrderConfirmation;

	@FindBy(xpath = "//span[(@class='text-bold')]")
	WebElement BANOrderConfirmation;

	@FindBy(xpath = "//a[@role='link' and not(@data-test='ov-account-overview')]")
	WebElement aalButtonOrderConfirmation;
	
	/**
	 * Verify Order is Placed
	 * @return true if Confirmation Message appeared, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyOrder() {
		getReusableActionsInstance().staticWait(10000);
		return getReusableActionsInstance().isElementVisible(orderConfirmation,120);
	}
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		getReusableActionsInstance().staticWait(5000);
		return getReusableActionsInstance().isElementVisible(lblOrderConfirmation, 60);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyThankYouDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblThankYou,60);
	}

	/**
	 * Validates whether BAN shown in the Order Confirmation page matches to the BAN of the account given
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyBANOrderConfirmationPage(String banNo) {
		getReusableActionsInstance().staticWait(5000);
		String Ban = BANOrderConfirmation.getText().trim();
		if (Ban.equalsIgnoreCase(banNo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Clicks 'Add A Line' button
	 * @author sidhartha.vadrevu
	 */
	public void clickAddALineOrderConfirmation() {
		//getReusableActionsInstance().scrollToElement(aalButtonOrderConfirmation);
		getReusableActionsInstance().executeJavaScriptClick(aalButtonOrderConfirmation);
	}
}

