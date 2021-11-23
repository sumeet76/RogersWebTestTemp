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
	
	@FindBy(xpath = "//*[text()='Thanks! We received the order.' or text()='Merci!  Nous avons reçu la commande.  ']")
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

	@FindBy(xpath = "//span[contains(text(),'Add a line ')]")
	WebElement aalButtonOrderConfirmation;
	
	/**
	 * Verify Order is Placed
	 * @return true if Confirmation Message appeared, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyOrder() {	
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
		getReusableActionsInstance().scrollToElement(aalButtonOrderConfirmation);
		getReusableActionsInstance().executeJavaScriptClick(aalButtonOrderConfirmation);
	}
}

