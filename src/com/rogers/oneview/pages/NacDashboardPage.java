package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NacDashboardPage extends BasePageClass {

	public NacDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(@class,'other-language')]")
	WebElement changeLanguage;

	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerTitle;

	@FindBy(xpath = "//p[contains(text(),'Consumer') or contains(text(),'Consommateur')]")
	WebElement customerButton;

	@FindBy(xpath = "//p[contains(text(),'SoHo') or contains(text(),'Petites entreprises/bureaux à domicile')]")
	WebElement soHoButton;

	@FindBy(xpath = "//p[contains(text(),'Wireless') or contains(text(),'Sans-fil')]")
	WebElement wirelessButton;

	@FindBy(xpath = "//input[contains(@class,'address-input')]")
	WebElement shippingAddressField;

	@FindBy(xpath = "//input[contains(@placeholder,'Address') or contains(@placeholder,'Adresse')]")
	WebElement inputShippingAddressField;

	@FindBy(xpath = "//ul[contains(@class,'list')]//li[1]")
	WebElement clkListBox;

	@FindBy(xpath = "//oneview-text-field[contains(@class,'apt-tb')]")
	WebElement apartmentField;

	@FindBy(xpath = "//oneview-text-field[contains(@class,'apt-tb')]//input")
	WebElement inputApartmentField;

	@FindBy(xpath = "//span[contains(@translate,'pro_on_go_delivery_eligible')]")
	WebElement chkAddressType;

	@FindBy(xpath = "//t[contains(text(),'Get a new phone') or contains(text(),'Obtenez un nouveau téléphone')]")
	WebElement getANewPhoneButton;

	@FindBy(xpath = "//t[contains(text(),'Bring your own phone') or contains(text(),'Apportez votre téléphone')]/../..")
	WebElement bringYourOwnPhoneButton;

	@FindBy(xpath = "//button[contains(@class,'confirm-btn')]")
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
	 * This method selects french language
	 * @author praveen.kumar7
	 */
	public void selectFrenchLanguage() {
		getReusableActionsInstance().clickWhenReady(changeLanguage,20);
	}

	/**
	 * Click Customer Button
	 * @author Sidhartha.Vadrevu
	 */	
	public void clkCustomerButton() {
		getReusableActionsInstance().clickWhenReady(customerButton,10);
	}

	/**
	 * Click Wireless Button
	 * @author Sidhartha.Vadrevu
	 */
	public void clkWirelessButton() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(wirelessButton);
		getReusableActionsInstance().clickWhenReady(wirelessButton,10);

	}

	/**
	 * Click & Fill value in Shipping Address Field
	 * @param shippingAddress - Provides the required shipping address value to be filled.
	 * @author Sidhartha.Vadrevu
	 */
	public void fillShippingAddressField(String shippingAddress) {
		getReusableActionsInstance().executeJavaScriptClick(shippingAddressField);
		getReusableActionsInstance().staticWait(2000);
		shippingAddressField.sendKeys(shippingAddress);
		//getReusableActionsInstance().getWhenReady(inputShippingAddressField,5).sendKeys(shippingAddress);
		getReusableActionsInstance().clickWhenReady(clkListBox,5);
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * Click & Fill value in Apartment Field
	 * @param apartment - Provides the required apartment value to be filled.
	 * @author Sidhartha.Vadrevu
	 */
	public void fillApartmentField(String apartment) {
		getReusableActionsInstance().clickWhenVisible(apartmentField,5);
		getReusableActionsInstance().getWhenReady(inputApartmentField,5).sendKeys(apartment);
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
