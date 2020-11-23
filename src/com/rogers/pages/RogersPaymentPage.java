package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersPaymentPage extends BasePageClass {

	public RogersPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//iframe[@id='sema']")
	WebElement frmCreditCard;
	
	@FindBy(xpath="//input[@id='maskedPan']")
	WebElement txtCreditCardNumberMasked;
	
	@FindBy(xpath="//input[@id='pan']")
	WebElement txtCreditCardNumber;
	
	@FindBy(xpath="//select[@name='month']")
	WebElement ddlCreditCardExpiryMonth;
	
	@FindBy(xpath="//select[@name='year']")
	WebElement ddlCreditCardExpiryYear;

	@FindBy(xpath = "//button[@checkout-res='checkout_submit_order']")
	WebElement btnSubmitOrder;
	
	@FindBy(xpath = "//input[@name='securityCode']")
	WebElement txtSecurityCode;

	@FindAll({
			@FindBy(xpath = "//span[@checkout-res='checkout_pay_submit']/parent::button"),
			@FindBy(xpath = "//span[@checkout-res='checkout_submit_order']/parent::button")
	})
	WebElement btnSubmit;

	/**
	 * Sets the Credit Card Number, Expiry Year and Expiry Month
	 * @param strCCNumber Credit Card Number
	 * @param strCCExpMonth Credit Card Expiry Month
	 * @param strCCExpYear Credit Card Expiry Year
	 * @param strCCSecurityCode Credit Card Security Code or CVV
	 * @author rajesh.varalli1
	 */
	public void setCreditCardDetails(String strCCNumber, String strCCExpMonth, String strCCExpYear, String strCCSecurityCode) {
		getDriver().switchTo().frame(frmCreditCard);
		getReusableActionsInstance().staticWait(5000);
		txtCreditCardNumberMasked.click();
		txtCreditCardNumber.click();
		txtCreditCardNumber.sendKeys(strCCNumber);
		
		getDriver().switchTo().defaultContent();
		
		getReusableActionsInstance().selectWhenReady(ddlCreditCardExpiryMonth, strCCExpMonth);
		
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlCreditCardExpiryYear, strCCExpYear);
		
		txtSecurityCode.sendKeys(strCCSecurityCode);
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmitOrder() {
		getReusableActionsInstance().clickWhenVisible(btnSubmitOrder);
	}

	/**
	 * Clicks on the 'Submit' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmit() {
		getReusableActionsInstance().clickWhenVisible(btnSubmit);
	}

}