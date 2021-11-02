package com.rogers.pages;

import org.openqa.selenium.*;
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

	@FindBy(xpath = "//span[text()='Take the quiz']")
	WebElement btnTakeQuiz;
	@FindBy(xpath = "//input[@id='dsQ1A2']/following::span[contains(text(),'Netflix')]")
	WebElement clkUsualInterentUsage;
	@FindBy(xpath = "//span[text()=' Continue ']")
	WebElement clkbtnContinue;
	@FindBy(xpath = "//span[text()=' 2-3 ']")
	WebElement clkNoOfPPLUsedInternet;
	@FindBy(xpath = "//span[text()=' 1-5 ']")
	WebElement clkNoOFDeviceConnectedToInternet;
	@FindBy(xpath = "//span[text()=' Yes ']")
	WebElement clkAddSmartStreamAddon;
	@FindBy(xpath = "//span[text()=' < Back to all packages ']")
	WebElement clkbtnBackToAllPackages;
	@FindBy(xpath = "//h2[text()='Here’s the package we recommend for you']")
	WebElement VerifyRecommendedBannertitle;

	@FindBy(xpath = "//a[@title='View internet bundles available to you']/span")
	WebElement btnSmartStream;
	//div//a[@title='View internet bundles available to you']
	//(//div//a[@title='Get Ignite Internet + SmartStream now'])[1]

	@FindBy(xpath = "//a[contains(@title,'View internet bundles available to you')]")
	WebElement lnkSmartStream;

	@FindBy(xpath = "//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']//span[text()='Continue']")
	WebElement btnInternetBuyContinue;
	
	@FindBy(xpath = "//a[@aria-label='Add Ignite Internet 150u to your cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']//span[text()='Add to cart']")
	WebElement btnInternetPackage;
	//button[@aria-label='Add Ignite Internet 500u to your cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnInternet500uPackage;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 150u']/preceding::span[text()='Add to cart']")
	WebElement btnSmartStreamPackage;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnSmartStream500uPackage;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::div[@class='internet-bundle-tile']//div[@class='ds-checkbox__box my-12 rds-icon-check']")
	WebElement chkSmartStream;

	@FindBy(xpath = "//span[text()='Have a promo code?']")
	WebElement btnPromoCode;

	@FindBy(xpath = "//div[@class='expanded']//input[contains(@id,'ds-form-input-id-')]")
	WebElement txtPromoCodeFormInput;

	@FindBy(xpath = "//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txaPromoCodeContainer;

	@FindBy(xpath = "//span[contains(text(),'Check') or contains(text(),'Chèque')]/ancestor::button")
	WebElement btnPromoCodeCheck;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-warning-circle ds-color-error']")
	WebElement imgInvalidPromoCodeError;

	@FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar' and @title='Newfoundland and Labrador']")
	WebElement lnkProvinceNL;

	@FindBy(xpath = "//ul[@class='dds_o-navLinkList']//span[contains(text(),'ON')]")
	WebElement lnkOptedON;

	@FindBy(xpath = "//a[@aria-label='Ontario']//span[@class='m-navLink__chevron rds-icon-expand']")
	WebElement lnkProvince;

	@FindBy(xpath = "//*[text()='Take the quiz']")
	WebElement btnquiz;

	@FindBy(xpath = "//*[text()=' Web browsing and email ']")
	WebElement btnWebEmail;

	@FindBy(xpath = "//*[text()=' Working from home (e.g. Teams, Skype, Zoom) ']")
	WebElement btnWorkHome;

	@FindBy(xpath = "//*[text()=' Continue ']")
	WebElement btnDSTContinue;

	@FindBy(xpath = "//*[text()=' 2-3 ']")
	WebElement btnInternetCount;

	@FindBy(xpath = "//*[text()=' 1-5 ']")
	WebElement btnInternetDevice;

	@FindBy(xpath = "//button[@aria-label='BEST FITIgnite Internet 150u']")
	WebElement VerifyBestFit;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
	WebElement btnDSTClose;

	@FindBy(xpath = "//*[text()='Here’s the package we recommend for you']")
	WebElement VerifyYourBestFit;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 150u']/preceding::span[text()='Add to cart']")
	WebElement btnBestAdd;

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

	public boolean verifyInternetPacakesPage() {
		return getReusableActionsInstance().isElementVisible(btnInternetPackage,90);
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

	public void clkInternet500uPackage() {

		getReusableActionsInstance().getWhenReady(btnInternet500uPackage, 90).click();
	}

	public void clkTakQuiz()
	{
		getReusableActionsInstance().waitForElementVisibility(btnTakeQuiz, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnTakeQuiz);
	}
	public void clkInternetUsage()
	{
		getReusableActionsInstance().waitForElementVisibility(clkUsualInterentUsage, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkUsualInterentUsage);
	}
	public void clkContinueQuiz()
	{
		getReusableActionsInstance().waitForElementVisibility(clkbtnContinue, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkbtnContinue);
	}
	public void clkPPLUsedInteret()
	{
		getReusableActionsInstance().waitForElementVisibility(clkNoOfPPLUsedInternet, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkNoOfPPLUsedInternet);
	}

	public void clkDeviceConnectedToInteret()
	{
		getReusableActionsInstance().waitForElementVisibility(clkNoOFDeviceConnectedToInternet, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkNoOFDeviceConnectedToInternet);
	}

	public void clkAddSmartStream()
	{
		getReusableActionsInstance().waitForElementVisibility(clkAddSmartStreamAddon, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkAddSmartStreamAddon);
	}

	public void clkBackToPackagesPage()
	{
		getReusableActionsInstance().waitForElementVisibility(clkbtnBackToAllPackages, 90);
		getReusableActionsInstance().executeJavaScriptClick(clkbtnBackToAllPackages);
	}

	public boolean VerifyRecommendedBanner()
	{
		getReusableActionsInstance().waitForElementVisibility(VerifyRecommendedBannertitle, 90);
		return getReusableActionsInstance().isElementVisible(VerifyRecommendedBannertitle,30);
	}

	public void clkTakeQuiz() {
		getReusableActionsInstance().getWhenReady(btnquiz, 90).click();
	}

	public void clkWebEmail() {
		getReusableActionsInstance().getWhenReady(btnWebEmail, 90).click();
	}

	public void clkWorkHome() {
		getReusableActionsInstance().getWhenReady(btnWorkHome, 90).click();
	}

	public void clkDSTContinue() {
		getReusableActionsInstance().getWhenReady(btnDSTContinue, 90).click();
	}

	public void clkInternetCount() {
		getReusableActionsInstance().getWhenReady(btnInternetCount, 90).click();
	}

	public void clkInternetDevice() {
		getReusableActionsInstance().getWhenReady(btnInternetDevice, 90).click();
	}

	public void VerifyBestFit() {
		getReusableActionsInstance().getWhenReady(VerifyBestFit, 90).isDisplayed();
	}

	public void clkDSTClose() {
		getReusableActionsInstance().getWhenReady(btnDSTClose, 90).click();
	}

	public void VerifyYourBestFit() {
		getReusableActionsInstance().getWhenReady(VerifyYourBestFit, 90).isDisplayed();
	}

	public void clkBestAdd() {
		getReusableActionsInstance().getWhenReady(btnBestAdd, 2000).click();
	}

	public void clkSmartStreamPackage() {
		getReusableActionsInstance().getWhenReady(btnSmartStreamPackage, 90).click();
	}

	public void clkSmartStream500uPackage() {
		getReusableActionsInstance().getWhenReady(btnSmartStream500uPackage, 90).click();
	}

	public void clkSmartStreamCheckBox() {
		getReusableActionsInstance().getWhenReady(chkSmartStream, 90).click();
	}
	public void clkSmartStreamAvailability() {
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().waitForElementVisibility(btnSmartStream, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnSmartStream);
		getReusableActionsInstance().staticWait(8000);
	}

	/**
	 * Click the SignIn button from the top tile bar
	 * @author chinnarao.vattam
	 */
	public void clkISSforNL() {
		getReusableActionsInstance().isElementVisible(lnkOptedON,20);
		getReusableActionsInstance().getWhenReady(lnkProvince, 20).click();
		getReusableActionsInstance().getWhenReady(lnkProvinceNL, 30);
		getReusableActionsInstance().executeJavaScriptClick(lnkProvinceNL);
	}

	public void clkSmartStream() {
		getReusableActionsInstance().waitForElementVisibility(lnkSmartStream, 90);
		getReusableActionsInstance().executeJavaScriptClick(lnkSmartStream);
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
			getReusableActionsInstance().waitForElementInvisibility(popUpLoading, 90);
		}
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnInternetBuyContinue, 60).click();
	}

	public void clkCheckout() {
		getReusableActionsInstance().waitForElementVisibility(btnCheckout, 90);
		getReusableActionsInstance().scrollToElement(btnCheckout);
		getReusableActionsInstance().getWhenReady(btnCheckout, 90).click();
	}

	/**
	 * Verify the Promo Code Button
	 * @return true if the Promo Code Button displayed  else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPromoCodeButton() {
		return getReusableActionsInstance().isElementVisible(btnPromoCode,60);
	}

	/**
	 * Click on the Promo Code Button
	 * @author chinnarao.vattam
	 */
	public void clkPromoCode() {
		getReusableActionsInstance().getWhenReady(btnPromoCode, 10).click();
	}

	/**
	 * Enter on the Promo Code
	 * @author chinnarao.vattam
	 */
	public void setIgniteAddressLookup(String strPromoCode) {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementVisibility(txaPromoCodeContainer, 60);
		getReusableActionsInstance().getWhenReady(txaPromoCodeContainer, 3).click();
		getReusableActionsInstance().getWhenReady(txtPromoCodeFormInput, 3).clear();
		getReusableActionsInstance().getWhenReady(txtPromoCodeFormInput, 5).sendKeys(strPromoCode);
	}

	/**
	 * Click on the Promo Code Check button
	 * @author chinnarao.vattam
	 */
	public void clkPromoCodeCheck() {
		getReusableActionsInstance().getWhenReady(btnPromoCodeCheck, 10).click();
	}

	/**
	 * Verify the Promo Code Error message
	 * @return true if the Promo Code Error message displayed  else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyPromoCodeError() {
		return getReusableActionsInstance().isElementVisible(imgInvalidPromoCodeError,60);
	}


}
