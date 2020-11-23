package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersDigitalTVPackageSelectionPage extends BasePageClass {

	public RogersDigitalTVPackageSelectionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "waysToChangeProductBox")
	WebElement popupWaysToChangeProductBox;

	@FindBy(className = "bx-loading")
	WebElement popupLoading;
	
	@FindBy(xpath = "//input[@class='checkoutButton withoutEOP']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[@class='bx-loading']")
	WebElement packageLoader;
	
		
	/**
	 * Select the  required TV package from the TV package selection page
	 * @param strPackageNameEn package name to selcet for the TV package selection 
	 * @param strPackageNameFr package name to selcet for the TV package selection 
	 * @author chinnarao.vattam 
	 */
	public void selectPackage(String strPackageNameEn, String strPackageNameFr) {	
		getReusableActionsInstance().waitForElementInvisibility(packageLoader, 90);
	    By packageNameLocator = By.xpath("//div[contains(normalize-space(@class),'pkgTitle_pkg') and text()='"+ strPackageNameEn+ "']/ancestor::div[@class='justForBorderStyle_pkg']//a[@class='redAddtocart_pkg']/parent::div");
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().waitForElementVisibility(pkg, 90);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(packageNameLocator, 30);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}
	
	/**
	 * Select the  required TV package from the TV package selection page
	 * @param strPackageNameEn package name to selcet for the TV package selection 
	 * @param strPackageNameFr package name to selcet for the TV package selection 
	 * @author chinnarao.vattam 
	 */
	public void selectPackageUpgarde(String strPackageNameEn, String strPackageNameFr) {
		getReusableActionsInstance().waitForElementInvisibility(packageLoader, 90);
		WebElement cartBanner = getDriver().findElement(By.xpath("//div[@class='runningCart avenirNextFont']"));
	    ((JavascriptExecutor)getDriver()).executeScript("arguments[0].style.visibility='hidden'", cartBanner);
	    By packageNameLocator = By.xpath("//div[contains(normalize-space(@class),'pkgTitle_pkg') and text()='"+ strPackageNameEn+ "']/ancestor::div[@class='justForBorderStyle_pkg']//a[@class='redAddtocart_pkg']/parent::div");
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().waitForElementVisibility(pkg, 90);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementVisibility(pkg, 30);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}

	/**
	 * To verify the downgrade Ways To Buy Box popup  
	 * @author chinnarao.vattam 
	 * @return true if ways To Change Product Box popup displayed; else false
	 */
	public boolean verifyDowngradeWaysToBuyBox() {
		return getReusableActionsInstance().isElementVisible(popupWaysToChangeProductBox,20);
	}
	
	/**
	 * To click checkout button 
	 * @author chinnarao.vattam 
	 */
	public void clkCheckout() {
		getReusableActionsInstance().waitForElementVisibility(btnCheckout, 90);
		//Javascript scroll used to support firefox (geckodriver)
		//getReusableActionsInstance().javascriptScrollByVisibleElement(btnCheckout);
		getReusableActionsInstance().getWhenReady(btnCheckout, 90).click();
	}
	
}
