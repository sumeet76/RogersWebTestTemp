package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class OrderConfirmationPage  extends BasePageClass {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[text()='Thanks! We received the order.' or text()='Merci!  Nous avons reçu la commande.  ']")
	WebElement orderConfirmation;
	
	@FindAll({
		@FindBy(xpath = "//span[@class='thank-you']"),
		@FindBy(xpath = "//span[@class='UConfirmationHeading']")
	})	
	WebElement lblThankYou;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	WebElement lblOrderConfirmation;
	
	/**
	 * Verify Order is Placed
	 * @return true if Confirmation Message appeared, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyOrder() {	
		return reusableActions.isElementVisible(orderConfirmation,120);
	}
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		reusableActions.staticWait(5000);
		return reusableActions.isElementVisible(lblOrderConfirmation, 120);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyThankYouDisplayed() {
		return reusableActions.isElementVisible(lblThankYou,60);
	}
}

