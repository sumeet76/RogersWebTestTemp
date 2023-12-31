package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersLegacyBundleBuyPage extends BasePageClass {

	public RogersLegacyBundleBuyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='row bundle-pricing-wrapper bundles-new-customers']//a[@data-package='BUNDLE-BASIC3']")
	WebElement btnSelectBundle;
		
	@FindBy(id = "addressLookupField-0")
	WebElement txtAddressLookup;
	
	@FindBy(id = "addressLookupSubmit-0")
	WebElement btnAddressLookupSubmit;
	
	@FindBy(xpath = "//a[contains(@href,'/consumer/shop/ordersummary?lob=bundles&package')]")
	WebElement btnBuyOnline;
	
	@FindBy(xpath = "//a[@href='/consumer/shop/ordersummary/checkout']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//div[@class='modal-content active']//i[@class='rui-icon-success']")
	WebElement popupServiceabilitySuccess;
	
	@FindBy(xpath = "//div[@data-screen-name='retryServiceability']")
	WebElement popupMultipleAddress;
	
	@FindBy(xpath = "//input[@class='btn btn-primary multi-unit-continue-cta']")
	WebElement btnOptionOneMultipleAddress;
	
	
	/**
	 * Click on how to get it button for the desired bundle package on bundle page
	 * @author chinnarao.vattam
	 */
	public void clkSelectBundle() {
		getReusableActionsInstance().getWhenReady(btnSelectBundle,30).click();
	}
	
	/**
	 * To set the Lookup address on the service ability Lookup popup
	 * @param strAddress address for check the service ability
	 * @author chinnarao.vattam
	 */
	public void setAddressLookup(String strAddress) {
		getReusableActionsInstance().getWhenReady(txtAddressLookup,60).clear();
		getReusableActionsInstance().getWhenReady(txtAddressLookup,20).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.SPACE);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability
	 * @author chinnarao.vattam
	 */
	public void clkAddressLookupSubmit() {
		getReusableActionsInstance().getWhenReady(btnAddressLookupSubmit, 30).click();
	}
	
	/**
	 * Click the Buy Online button on buy options popup
	 * @author chinnarao.vattam
	 */
	public void clkBuyOnline() {		
		if (getReusableActionsInstance().isElementVisible(btnBuyOnline,60))
			{
				getReusableActionsInstance().getWhenReady(btnBuyOnline, 90).click();
		}
			else if (getReusableActionsInstance().isElementVisible(popupMultipleAddress,30))
			{
				getReusableActionsInstance().getWhenReady(btnOptionOneMultipleAddress, 30).click();
				getReusableActionsInstance().getWhenReady(btnBuyOnline, 90).click();
			} 		
			else 		
				throw new NoSuchElementException("Given Address dosen't have the service");	
		}

	
	/**
	 * Click the checkout button to continue for profile page
	 * @author chinnarao.vattam
	 */
	public void clkCheckout() {
		getReusableActionsInstance().clickWhenReady(btnCheckout, 30);
	}
	
	/**
	 * To verify the Contact Customer care pop up For legacy bundle buy French language 
	 * @return true, if the Contact Customer care pop up For legacy bundle buy French language else false
	 * @author chinnarao.vattam 
	 */
	public boolean verifyServiceabilitySuccess() {
		return getReusableActionsInstance().isElementVisible(popupServiceabilitySuccess,90);
	}
}
