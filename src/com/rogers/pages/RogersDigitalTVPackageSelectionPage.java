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
	 * @param strLang Language 
	 * @author chinnarao.vattam 
	 */
	public void selectPackage(String strPackageNameEn, String strPackageNameFr, String strLang) {	
	    By packageNameLocator = By.xpath("//div[contains(normalize-space(@class),'pkgTitle_pkg') and text()='"+ strPackageNameEn+ "']/ancestor::div[@class='justForBorderStyle_pkg']//a[@class='redAddtocart_pkg']/parent::div");
		WebElement pkg = driver.findElement(packageNameLocator);		
		reusableActions.waitForElementInvisibility(packageLoader, 90);
		reusableActions.javascriptScrollByVisibleElement(pkg);
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(packageNameLocator, 90).click();
	}
	
	/**
	 * Select the  required TV package from the TV package selection page
	 * @param strPackageNameEn package name to selcet for the TV package selection 
	 * @param strPackageNameFr package name to selcet for the TV package selection 
	 * @param strLang Language 
	 * @author chinnarao.vattam 
	 */
	public void selectPackageUpgarde(String strPackageNameEn, String strPackageNameFr, String strLang) {	
		WebElement cartBanner = driver.findElement(By.xpath("//div[@class='runningCart avenirNextFont']"));       
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", cartBanner);
	    By packageNameLocator = By.xpath("//div[contains(normalize-space(@class),'pkgTitle_pkg') and text()='"+ strPackageNameEn+ "']/ancestor::div[@class='justForBorderStyle_pkg']//a[@class='redAddtocart_pkg']/parent::div");
		WebElement pkg = driver.findElement(packageNameLocator);		
		reusableActions.waitForElementInvisibility(packageLoader, 90);
		reusableActions.scrollToElement(pkg);
		reusableActions.getWhenReady(packageNameLocator, 90).click();
	}

	/**
	 * To verify the downgrade Ways To Buy Box popup  
	 * @author chinnarao.vattam 
	 * @return true if ways To Change Product Box popup displayed; else false
	 */
	public boolean verifyDowngradeWaysToBuyBox() {
		return reusableActions.isElementVisible(popupWaysToChangeProductBox,20);
	}
	
	/**
	 * To click checkout button 
	 * @author chinnarao.vattam 
	 */
	public void clkCheckout() {
		reusableActions.waitForElementVisibility(btnCheckout, 90);
		reusableActions.scrollToElement(btnCheckout);
		reusableActions.getWhenReady(btnCheckout, 90).click();
	}
	
}
