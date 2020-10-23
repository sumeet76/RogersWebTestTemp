package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersInternetPackageSelectionPage extends BasePageClass {

	public RogersInternetPackageSelectionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "downgradeWaystobuyBox")
	WebElement popupDowngradeWaystobuyBox;

	@FindBy(xpath = "//section[@id='section-2']//div[contains(@class,'owl-next')]")
	WebElement btnNextArrowPlans;

	@FindBy(xpath = "//section[@id='section-2']//div[contains(@class,'owl-prev')]")
	WebElement btnPrevArrowPlans;

	@FindBy(className = "bx-loading")
	WebElement popupLoading;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popUpLoading;
	
	@FindBy(id = "modemUpgradeContinue")
	WebElement btnUpgradeContinue;
	
	@FindBy(xpath = "//input[@class='checkoutButton']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//button//span[@translate='global.cta.continue']")
	WebElement btnInternetBuyContinue;
	
	@FindBy(xpath = "//button[@aria-label='Add Ignite Internet 500u to your cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
	WebElement btnInternetPackage;

	/**
	 * selects the Internet package if it visible and ready if not click on the next arrow to get the desired package
	 * @param strPackageNameEn Internet package to be selected 
	 * @param strPackageNameFr Internet package to be selected
	 * @param strLang Language
	 * @author Aditya.Dhingra
	 */
	public void selectInternetPackage(String strPackageNameEn, String strPackageNameFr, String strLang) {
		
		if(strLang.equalsIgnoreCase("en")) {
			if (reusableActions.isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 20))
			reusableActions.getWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']")).click();
		else if (reusableActions.isElementVisible(btnNextArrowPlans)) {
			reusableActions.getWhenReady(btnNextArrowPlans).click();
			reusableActions.clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else if (reusableActions.isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 10)) 
		{
			reusableActions.getWhenReady(btnPrevArrowPlans).click();
			reusableActions.clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else
			throw new NoSuchElementException("Given Package Doesnt Exist in Catalogue");
		}
		else
			if (reusableActions.isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 20))
			reusableActions.getWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']")).click();
		else if (reusableActions.isElementVisible(btnNextArrowPlans)) {
			reusableActions.getWhenReady(btnNextArrowPlans).click();
			reusableActions.clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else if (reusableActions.isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 10)) 
		{
			reusableActions.getWhenReady(btnPrevArrowPlans).click();
			reusableActions.clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else
			throw new NoSuchElementException("Given Package Doesnt Exist in Catalogue");
	}

	/**
	 * selects the Internet package 
	 * @param strPackageName Internet package to be selected 
	 * @return true if the package available on the page else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyInternetPackageSelection(String strPackageName) {
		String[] part = strPackageName.split("(?<=\\D)(?=\\d)");
		return reusableActions.isElementVisible(By.xpath("//span[contains(normalize-space(.) ,'" + part[0].trim()
				+ "') and contains(normalize-space(.) ,'" + part[1].trim() + "')]"));
	}

	/**
	 * Verify the  down grade Ways To Buy Box when we do on the Internet down grade process
	 * @return true if the Down grade Ways popup displayed  else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDowngradeWaysToBuyBox() {
		return reusableActions.isElementVisible(popupDowngradeWaystobuyBox);
	}

	public void clkUpgradeContinue() {
		//reusableActions.waitForElementVisibility(btnUpgradeContinue, 90);
		reusableActions.getWhenReady(btnUpgradeContinue, 90).click();
	}
	
	public void clkInternetPackage() {
		reusableActions.getWhenReady(btnInternetPackage, 90).click();
	}
		
	public void clkInternetBuyContinue() {
		reusableActions.waitForElementInvisibility(popUpLoading, 60);
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnInternetBuyContinue, 20).click();
	}
	
	public void clkCheckout() {
		reusableActions.waitForElementVisibility(btnCheckout, 90);
		reusableActions.scrollToElement(btnCheckout);
		reusableActions.getWhenReady(btnCheckout, 90).click();
	}
}
