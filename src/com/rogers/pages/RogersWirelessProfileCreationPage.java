package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersWirelessProfileCreationPage extends BasePageClass {

	public RogersWirelessProfileCreationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='cemail']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath = "//input[@id='fname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='lname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='phoneno']")
	WebElement txtContactNumber;
	
	@FindBy(xpath = "//input[@addresstype='billing']")
	WebElement txtBillingAddress;
	
	@FindBy(xpath = "//div[@class='pca pcalist']/div[contains(@class,'pcalastitem')]/span[@class='pcadescription']/..")
	WebElement lblAddressResult;
	
	@FindBy(xpath = "//label[@for='billingAddress']")
	WebElement lblBillingAddress;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']")
	WebElement btnContinue;
		
	/**
	 * Sets the generated email address at both the Email and Confirm Email fields
	 * @author rajesh.varalli1
	 */
	public void setCommunicationDetails(){
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().getWhenReady(txtEmail, 3).clear();
		txtEmail.sendKeys(strEmail);
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 3).clear();
		txtConfirmEmail.sendKeys(strEmail);
	}
	
	/**
	 * Sets the generated first name
	 * @author rajesh.varalli1
	 */
	public void setFirstName(){
		String strFname = FormFiller.generateRandomName();
		getReusableActionsInstance().getWhenReady(txtFirstName, 3).clear();
		txtFirstName.sendKeys(strFname);
	}
	
	/**
	 * Sets the generated last name
	 * @author rajesh.varalli1
	 */
	public void setLastName(){
		String strLname = FormFiller.generateRandomName();
		getReusableActionsInstance().getWhenReady(txtLastName, 3).clear();
		txtLastName.sendKeys(strLname);
	}
	
	/**
	 * Sets the generated phone number
	 * @author rajesh.varalli1
	 */
	public void setContactNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		setContactNumber(strPhoneNumber);
	}
	
	/**
	 * Sets the specified phone number
	 * @param strPhoneNumber Phone Number
	 * @author rajesh.varalli1
	 */
	public void setContactNumber(String strPhoneNumber) {
		getReusableActionsInstance().getWhenReady(txtContactNumber, 3).clear();
		txtContactNumber.sendKeys(strPhoneNumber);
	}
	
	/**
	 * Enters the billing address in the field and selects from the result list
	 * @param billingAddress Billing Address as one String
	 * @author rajesh.varalli1
	 */
	public void setBillingAddress(String billingAddress) {
		txtBillingAddress.sendKeys(billingAddress);
		txtBillingAddress.sendKeys("a");
		txtBillingAddress.sendKeys(Keys.BACK_SPACE);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().executeJavaScriptClick(lblAddressResult);
		getReusableActionsInstance().staticWait(3000);
	}
	
	/**
	 * Selects the 'Use Billing Address' option for the Shipping Address
	 * @author rajesh.varalli1
	 */
	public void clkUseBillingAddress() {
		getReusableActionsInstance().clickWhenReady(lblBillingAddress);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenReady(btnContinue);
	}
	
}