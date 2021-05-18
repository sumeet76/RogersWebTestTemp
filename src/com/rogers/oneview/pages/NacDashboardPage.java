package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NacDashboardPage extends BasePageClass {

	public NacDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerTitle;

	@FindBy(xpath = "//p[contains(text(),'Consumer')]")
	WebElement customerButton;

	@FindBy(xpath = "//p[contains(text(),'SoHo')]")
	WebElement soHoButton;

	@FindBy(xpath = "//p[contains(text(),'Wireless')]")
	WebElement wirelessButton;

	@FindBy(xpath = "//oneview-canada-post[contains(@placeholder,'Address')]")
	WebElement shippingAddressField;

	@FindBy(xpath = "//input[contains(@placeholder,'Address')]")
	WebElement inputShippingAddressField;

	@FindBy(xpath = "//ul[contains(@role,'listbox')]")
	WebElement clkListBox;

	@FindBy(xpath = "//span[contains(@translate,'pro_on_go_delivery_eligible')]")
	WebElement chkAddressType;

	@FindBy(xpath = "//t[contains(text(),'Get a new phone')]")
	WebElement getANewPhoneButton;

	@FindBy(xpath = "//t[contains(text(),'Bring your own phone')]")
	WebElement bringYourOwnPhoneButton;

	@FindBy(xpath = "//t[contains(text(),'Continue')]")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;
	
	/**
	 * Verify the New Customer Dashboard Page is Displayed
	 * @return true if New Customer Dashboard Page is Displayed, else false
	 * @author Sidhartha.Vadrevu
	 */	
	public boolean verifyNewCustomerDashboard() {
		//getReusableActionsInstance().clickIfAvailable(collapse,60);
		return getReusableActionsInstance().isElementVisible(newCustomerTitle,10);
	
	}

	/**
	 * Click Customer Button
	 * @author Sidhartha.Vadrevu
	 */	
	public void clkCustomerButton() {
		getReusableActionsInstance().clickIfAvailable(customerButton,10);
		
	}

	/**
	 * Click Wireless Button
	 * @author Sidhartha.Vadrevu
	 */
	public void clkWirelessButton() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(wirelessButton);
		getReusableActionsInstance().clickIfAvailable(wirelessButton,10);

	}

	/**
	 * Click & Fill value in Shipping Address Field
	 * @param shippingAddress - Provides the required shipping address value to be filled.
	 * @author Sidhartha.Vadrevu
	 */
	public void fillShippingAddressField(String shippingAddress) {
		getReusableActionsInstance().clickWhenVisible(shippingAddressField,5);
		getReusableActionsInstance().getWhenReady(inputShippingAddressField,5).sendKeys(shippingAddress);
		getReusableActionsInstance().clickWhenVisible(clkListBox,5);
	}

	/**
	 * Verify if the shipping address is eligible for POTG
	 * @return true if shipping address is Eligible, else false
	 * @author Sidhartha.Vadrevu
	 */
	public boolean verifyPOTGAddressEligibility() {
		getReusableActionsInstance().waitForElementVisibility(chkAddressType, 10);
		return getReusableActionsInstance().isElementVisible(chkAddressType,10);

	}

	/**
	 * Click Get A New Phone Button
	 * @author Sidhartha.Vadrevu
	 */
	public void clkGetANewPhoneButton() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(wirelessButton);
		getReusableActionsInstance().clickIfAvailable(getANewPhoneButton,10);
		getReusableActionsInstance().waitForElementVisibility(continueButton,10);
		getReusableActionsInstance().clickWhenVisible(continueButton, 5);
	}

	/**
	 * Click Bring Your Own Phone Button
	 * @author Sidhartha.Vadrevu
	 */
	public void clkBringYourOwnPhoneButton() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(wirelessButton);
		getReusableActionsInstance().clickIfAvailable(bringYourOwnPhoneButton,10);
		getReusableActionsInstance().waitForElementVisibility(continueButton,10);
		getReusableActionsInstance().clickWhenVisible(continueButton, 5);
	}
}
