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

	@FindBy(xpath = "//h1[@class='cart-summary__header']")
	WebElement txtCartSummaryHeader;

	
	@FindBy(id = "modemUpgradeContinue")
	WebElement btnUpgradeContinue;
	
	@FindBy(xpath = "//input[@class='checkoutButton']")
	WebElement btnCheckout;

	@FindBy(xpath = "(//div//a[@title='Get Ignite Internet + SmartStream now'])[1]")
	WebElement btnSmartStream;

	@FindBy(xpath = "//a[contains(@title,'Ignite Internet with SmartStream')]")
	WebElement lnkSmartStream;

	@FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::span[contains(@class,'ds-button__wrapper')]")
	WebElement btnInternetBuyContinue;
	
	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnInternetPackage;
	//button[@aria-label='Add Ignite Internet 500u to your cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnSmartStreamPackage;


	/**
	 * selects the Internet package if it visible and ready if not click on the next arrow to get the desired package
	 * @param strPackageNameEn Internet package to be selected 
	 * @param strPackageNameFr Internet package to be selected
	 * @param strLang Language
	 * @author Aditya.Dhingra
	 */
	public void selectInternetPackage(String strPackageNameEn, String strPackageNameFr, String strLang) {
		
		if(strLang.equalsIgnoreCase("en")) {
			if (getReusableActionsInstance().isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 20))
			getReusableActionsInstance().getWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']")).click();
		else if (getReusableActionsInstance().isElementVisible(btnNextArrowPlans)) {
			getReusableActionsInstance().getWhenReady(btnNextArrowPlans).click();
			getReusableActionsInstance().clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else if (getReusableActionsInstance().isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 10))
		{
			getReusableActionsInstance().getWhenReady(btnPrevArrowPlans).click();
			getReusableActionsInstance().clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameEn+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else
			throw new NoSuchElementException("Given Package Doesnt Exist in Catalogue");
		}
		else
			if (getReusableActionsInstance().isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 20))
			getReusableActionsInstance().getWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']")).click();
		else if (getReusableActionsInstance().isElementVisible(btnNextArrowPlans)) {
			getReusableActionsInstance().getWhenReady(btnNextArrowPlans).click();
			getReusableActionsInstance().clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
		} else if (getReusableActionsInstance().isElementVisible(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"), 10))
		{
			getReusableActionsInstance().getWhenReady(btnPrevArrowPlans).click();
			getReusableActionsInstance().clickWhenReady(By.xpath("//h4[contains(normalize-space(.),'" + strPackageNameFr+ "')]/ancestor::div[@class='owl-item']//a[@class='selectButton']"),10);
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
		return getReusableActionsInstance().isElementVisible(By.xpath("//span[contains(normalize-space(.) ,'" + part[0].trim()
				+ "') and contains(normalize-space(.) ,'" + part[1].trim() + "')]"));
	}

	/**
	 * Verify the  down grade Ways To Buy Box when we do on the Internet down grade process
	 * @return true if the Down grade Ways popup displayed  else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDowngradeWaysToBuyBox() {
		return getReusableActionsInstance().isElementVisible(popupDowngradeWaystobuyBox);
	}

	public void clkUpgradeContinue() {
		//getReusableActionsInstance().waitForElementVisibility(btnUpgradeContinue, 90);
		getReusableActionsInstance().getWhenReady(btnUpgradeContinue, 90).click();
	}
	
	public void clkInternetPackage() {
		getReusableActionsInstance().getWhenReady(btnInternetPackage, 90).click();
	}

	public void clkSmartStreamPackage() {
		getReusableActionsInstance().getWhenReady(btnSmartStreamPackage, 90).click();
	}

	public void clkSmartStreamAvailability() {
		getReusableActionsInstance().waitForElementVisibility(btnSmartStream, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnSmartStream);
	}

	public void clkSmartStream() {
		getReusableActionsInstance().staticWait(10000);
	/*	getReusableActionsInstance().waitForElementVisibility(lnkSmartStream, 90);
		getReusableActionsInstance().executeJavaScriptClick(lnkSmartStream);*/
	}

	public void clkInternetPackageMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnInternetPackage, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnInternetPackage);
	}
	public void clkInternetBuyContinueMobile() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().moveToElementAndClick(btnInternetBuyContinue,90);
		getReusableActionsInstance().executeJavaScriptClick(btnInternetBuyContinue);
		getReusableActionsInstance().clickIfAvailable(btnInternetBuyContinue,90);
	}

	public void clkInternetBuyContinue() {
		if(!getReusableActionsInstance().isElementVisible(btnInternetBuyContinue, 20)) {
			getReusableActionsInstance().waitForElementInvisibility(popUpLoading, 30);
		}
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnInternetBuyContinue, 60).click();
	}

	public void clkCheckout() {
		getReusableActionsInstance().waitForElementVisibility(btnCheckout, 90);
		getReusableActionsInstance().scrollToElement(btnCheckout);
		getReusableActionsInstance().getWhenReady(btnCheckout, 90).click();
	}
}
