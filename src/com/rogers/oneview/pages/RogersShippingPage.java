package com.rogers.oneview.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

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

	@FindBy(xpath = "//span[@class='text-lowercase ng-binding']")
	List<WebElement> lblSelectAvailableTime;

	@FindBy(xpath = "//span[@checkout-res='reserveTime']")
	WebElement btnReserve;

	@FindBy(xpath = "//label[@for='input-email-field']//span[@checkout-res='mandatory']")
	WebElement lblMandatoryEmail;

	@FindBy(xpath = "//input[@id='input-email-field']")
	WebElement inputEmail;

	@FindBy(xpath = "//label[@for='input-ctn']//span[@checkout-res='mandatory']")
	WebElement lblPhoneNumber;

	@FindBy(xpath = "//input[@id='input-ctn']")
	WebElement inputPhoneNumber;

	@FindBy(xpath = "//button[@class='__rdButton size-sm -save-email']")
	WebElement btnSaveEmail;

	@FindBy(xpath = "//button[@class='__rdButton size-sm -mb-5']")
	WebElement btnSaveNumber;

	@FindBy(xpath = "//div[@class='__normalDeliveryMethod']")
	WebElement rdoNormalDelivery;
	
    @FindBy(xpath = "//span[@class='mobile-block -mt4mb10']//span[@class='__checkoutEditLink']")
    WebElement btnContactEdit;
    
    @FindBy(xpath = "//span[@class='mobile-block -mb-10']//span[@class='__checkoutEditLink']")
    WebElement btnEmailEdit;
    
    @FindBy(xpath = "//span[@checkout-res='checkout_billing_address']")
    WebElement rdoBillingAddress;
    
    /**
     * Clicks on the 'Continue' button at the bottom of the page
     * Clicks on the billing address radio button
     * @author Saurav.Goyal
     */
    public void clkRadioBillingAddress() {
        reusableActions.clickWhenReady(rdoBillingAddress , 30);
    }
    
    /**
     * Clicks on the radio button normal delivery
	 * @author rajesh.varalli1
	 */
	public void clkRadioNormalDelivery() {
		reusableActions.clickWhenReady(rdoNormalDelivery , 30);
	}

	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.getWhenReady(lblShippingTitle,60);
		reusableActions.staticWait(2000);
		reusableActions.waitForElementVisibility(btnContinue,60);
		reusableActions.clickWhenReady(btnContinue);
	}

	/**
	 * Clicks on the 'Reserve' button at the bottom of the page after selectin the time slot
	 * @author Saurav.Goyal
	 */
	public void clkReserve() {
		reusableActions.clickWhenReady(btnReserve , 120);
	}

	/**
	 * Select the first available slot
	 * @author Saurav.Goyal
	 */
	public void clkSelectAvailableTime() {
		reusableActions.scrollToElement(lblSelectAvailableTime.get(0));
		reusableActions.clickWhenReady(lblSelectAvailableTime.get(0) , 120);
	}

	/**
	 * Enter email id
	 * @author Saurav.Goyal
	 */
	public void setEmailIDAndSave() {
		String strEmail = FormFiller.generateEmail();
		if(reusableActions.isElementVisible(lblMandatoryEmail,30)) {
			if(!reusableActions.isElementVisible(btnEmailEdit,30)) {
				reusableActions.clickWhenReady(lblMandatoryEmail,30);
				inputEmail.clear();
				inputEmail.sendKeys(strEmail);
				reusableActions.clickWhenReady(btnSaveEmail , 30);
			}  
		}
	}

	/**
	 * Enter phone number
	 * @author Saurav.Goyal
	 */
	public void setPhoneNumberAndSave() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		if(reusableActions.isElementVisible(lblPhoneNumber,30)) {
			if(!reusableActions.isElementVisible(btnContactEdit, 30)) {
				reusableActions.clickWhenReady(lblPhoneNumber);
				reusableActions.waitForElementVisibility(inputPhoneNumber,30);
				inputPhoneNumber.clear();
				inputPhoneNumber.sendKeys(strPhoneNumber);
				reusableActions.clickWhenReady(btnSaveNumber , 30);
			}
		}
	}
}