package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class OrderConfirmationPage  extends BasePageClass {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[text()='Thanks! We received the order.' or text()='Merci!  Nous avons reçu la commande.  ']")
	WebElement orderConfirmation;
	/**
	 * Verify Order is Placed
	 * @return true if Confirmation Message appeared, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyOrder() {	
		return reusableActions.isElementVisible(orderConfirmation,120);
	}
}

