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
	 * Verify that Shipping page is loaded properly
	 * Return true if the page is loaded properly else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyShippingPage() {
		return getReusableActionsInstance().isElementVisible(btnContinue , 50);
	}



    /**
     * Clicks on the 'Continue' button at the bottom of the page
     * Clicks on the billing address radio button
     * @author Saurav.Goyal
     */
    public void clkRadioBillingAddress() {
		getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().clickWhenReady(rdoBillingAddress , 30);
    }
    
    /**
     * Clicks on the radio button normal delivery
	 * @author rajesh.varalli1
	 */
	public void clkRadioNormalDelivery() {
		getReusableActionsInstance().clickWhenReady(rdoNormalDelivery , 30);
	}

	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().getWhenReady(lblShippingTitle,60);
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().waitForElementVisibility(btnContinue,60);
		getReusableActionsInstance().clickWhenReady(btnContinue);
	}

	/**
	 * Clicks on the 'Reserve' button at the bottom of the page after selectin the time slot
	 * @author Saurav.Goyal
	 */
	public void clkReserve() {
		getReusableActionsInstance().clickWhenReady(btnReserve , 120);
	}

	/**
	 * Select the first available slot
	 * @author Saurav.Goyal
	 */
	public void clkSelectAvailableTime() {
		getReusableActionsInstance().scrollToElement(lblSelectAvailableTime.get(0));
		getReusableActionsInstance().clickWhenReady(lblSelectAvailableTime.get(0) , 60);
	}

	/**
	 * Enter email id
	 * @author Saurav.Goyal
	 */
	public void setEmailIDAndSave() {
		String strEmail = FormFiller.generateEmail();
		if(getReusableActionsInstance().isElementVisible(lblMandatoryEmail,30)) {
			if(!getReusableActionsInstance().isElementVisible(btnEmailEdit,30)) {
				getReusableActionsInstance().clickWhenReady(lblMandatoryEmail,30);
				inputEmail.clear();
				inputEmail.sendKeys(strEmail);
				getReusableActionsInstance().clickWhenReady(btnSaveEmail , 30);
			}  
		}
	}

	/**
	 * Enter phone number
	 * @author Saurav.Goyal
	 */
	public void setPhoneNumberAndSave() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		if(getReusableActionsInstance().isElementVisible(lblPhoneNumber,30)) {
			if(!getReusableActionsInstance().isElementVisible(btnContactEdit, 30)) {
				getReusableActionsInstance().clickWhenReady(lblPhoneNumber);
				getReusableActionsInstance().waitForElementVisibility(inputPhoneNumber,30);
				inputPhoneNumber.clear();
				inputPhoneNumber.sendKeys(strPhoneNumber);
				getReusableActionsInstance().clickWhenReady(btnSaveNumber , 30);
			}
		}
	}
}