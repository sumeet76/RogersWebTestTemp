package com.rogers.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//button[@aria-label='Take the quiz']/span")
	WebElement btnTakeQuiz;

	@FindBy(xpath = "//input[@id='dsQ1A2']/following::span[contains(text(),'Netflix')]")
	WebElement clkUsualInterentUsage;
	@FindBy(xpath = "//span[text()=' Continue ']")
	WebElement clkbtnContinue;
	@FindBy(xpath = "//span[text()=' 1 ']")
	WebElement clkNoOfPPLUsedInternet;
	@FindBy(xpath = "//span[text()=' 1-5 ']")
	WebElement clkNoOFDeviceConnectedToInternet;
	@FindBy(xpath = "//input[contains(@aria-label,'Yes')]/parent::label//span[contains(@class,'selection__label')]")
	WebElement clkAddSmartStreamAddon;
	@FindBy(xpath="//span[contains(text(),'Back to all pack')]")
	WebElement clkbtnBackToAllPackages;
	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']")
	WebElement VerifyRecommendedBannertitle;

	@FindBy(xpath = "//a[@aria-label='Ignite Internet 150u Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwn150pkgTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Ignite Internet 500u Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwn500pkgTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Add Ignite Internet 150u to your cart']/ancestor::div[@class='internet-bundle-tile__price']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnDST150pkgTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Ignite 150 Ultd + Streaming Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnSSpkgTypeOfContract;

	@FindBy(xpath="//h1[contains(@class,'dsa-hero-billboard__heading')]")
	WebElement headerInternet;


	@FindBy(xpath = "//a[@aria-label='Add Ignite Internet Gigabit to your cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")
	WebElement drpdwnTypeOfContract;

	@FindBy(xpath = "//a[@aria-label='Add Ignite Internet Gigabit to your cart']/ancestor::div[@class='internet-bundle-tile__main']/descendant::div[@class='internet-bundle-tile__content__checkbox']/descendant::label")
	WebElement chkbox1GbpsSmartStream;

	@FindBy(xpath = "//a[contains(@aria-label,'View internet bundles available to you')]/span")
	WebElement btnSmartStream;
	//div//a[@title='View internet bundles available to you']
	//(//div//a[@title='Get Ignite Internet + SmartStream now'])[1]
	//a[contains(@aria-label,'Get SmartStream')]/span

	@FindBy(xpath = "//a[contains(@title,'View internet bundles available to you')]")
	WebElement lnkSmartStream;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement btnyes;

	@FindBy(xpath = "//a[contains(@aria-label,'Continue to the next step')]/span")
	WebElement btnInternetBuyContinue;

	@FindBy(xpath = "//a[@aria-label='Ignite Internet 150u Add to cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']//span[text()='Add to cart']")
	WebElement btnInternetPackage;

	@FindBy(xpath="//h3[text()='Ignite Internet 150u']")
	WebElement headerIgniteInternet150;

	@FindBy(xpath = "//a[@aria-label='Ignite 1Gbps Ultd + SmartStream Add to cart']//span[@role='text']")
	WebElement btnInternet1GbpsPackage;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement btnUnderstand;

	//button[@aria-label='Add Ignite Internet 500u to your cart']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnInternet500uPackage;

	@FindBy(xpath = "//a[@aria-label='Ignite 150 Ultd + Streaming Add to cart']//span[@role='text']")
	WebElement btnSmartStreamPackage;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::span[@role='text']")
	WebElement btnSmartStream500uPackage;

	@FindBy(xpath = "//span[@id='ariaHowToGetIt_Ignite Internet 500u']/ancestor::div[@class='internet-bundle-tile']//div[@class='ds-checkbox__box my-12 rds-icon-check']")
	WebElement chkSmartStream;

	@FindBy(xpath = "//p[text()='Have a promo code?']")
	WebElement btnPromoCode;

	@FindBy(xpath = "//input[@id='promoCodeInput']")
	WebElement txtPromoCodeFormInput;

	@FindBy(xpath = "//input[@id='promoCodeInput']/..")
	WebElement txaPromoCodeContainer;

	@FindBy(xpath = "//span[contains(text(),'Check') or contains(text(),'Chèque')]/ancestor::button")
	WebElement btnPromoCodeCheck;

	@FindBy(xpath = "//span[contains(text(),'promo code is invalid')]")
	WebElement imgInvalidPromoCodeError;

	@FindBy(xpath = "//button[contains(@aria-label,'Take the quiz')]")
	WebElement btnTakeAquiz;

	@FindBy(xpath = "//img[@alt='Image of Disney+']")
	WebElement imgDisneyBanner;

	@FindBy(xpath="//span[text()='Choose professional installation on us!']")
	WebElement txtGWP;
	//div[@class='promo-banner-cms__copy-mixed']//span[text()='Choose professional installation on us!']

	@FindBy(xpath = "//div[@class='internet-sai-ss-package-details']")
	WebElement txtPackageDetails;

	@FindBy(xpath = "//a[@aria-label='Ignite 150 Ultd + Streaming Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::p[@rchapiexposer='internetOffersLabels.igniteSmartStream']/parent::div[@class='vertical-tile__section__container']/descendant::label/input")
	WebElement chkbox150IgniteStreaming;

	@FindBy(xpath = "//a[@class='m-navLink -dropdownNavbar' and @title='Newfoundland and Labrador']")
	WebElement lnkProvinceNL;

	@FindBy(xpath = "//ul[@class='dds_o-navLinkList']//span[contains(text(),'ON')]")
	WebElement lnkOptedON;

	@FindBy(xpath = "//a[@aria-label='Ontario']//span[@class='m-navLink__chevron rds-icon-expand']")
	WebElement lnkProvince;

	@FindBy(xpath = "//*[text()='Take the quiz']")
	WebElement btnquiz;

	@FindBy(xpath = "//label[@for='dsQ1A1']//span[contains(@class,'selection__label')]")
	WebElement btnWebEmail;

	@FindBy(xpath = "//label[@for='dsQ1A2']//span[contains(@class,'selection__label')]")
	WebElement btnStreamingMovies;

	@FindBy(xpath = "//label[@for='dsQ1A3']//span[contains(@class,'selection__label')]")
	WebElement btnOnlineGaming;

	@FindBy(xpath = "//label[@for='dsQ1A4']//span[contains(@class,'selection__label')]")
	WebElement btnSharingLargeFiles;

	@FindBy(xpath = "//label[@for='dsQ1A5']//span[contains(@class,'selection__label')]")
	WebElement btnSmartHomeDevices;

	@FindBy(xpath = "//label[@for='dsQ1A6']//span[contains(@class,'selection__label')]")
	WebElement btnWorkHome;

	@FindBy(xpath = "//*[text()=' Continue ']")
	WebElement btnDSTContinue;

	@FindBy(xpath = "//input[@aria-label='Select 2-3']/parent::label//span[contains(@class,'selection__label')]")
	WebElement btnInternetCount;

	@FindBy(xpath = "//input[@aria-label='Select 6 or more']/parent::label//span[contains(@class,'selection__label')]")
	WebElement btnInternetCount6OrMore;

	@FindBy(xpath = "//input[@aria-label='Select 4-7']/parent::label//span[contains(@class,'selection__label')]")
	WebElement btnInternetDevice;

	@FindBy(xpath = "//input[@aria-label='Select 16 or more']/parent::label//span[contains(@class,'selection__label')]")
	WebElement btnInternetDevice16OrMore;

	@FindBy(xpath = "//button[contains(@aria-label,'BEST FIT')]")
	WebElement VerifyBestFit;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement btnDSTClose;

	@FindBy(xpath = "//div[@class='vertical-tile__ribbon__body -promo-available']")
	WebElement VerifyYourBestFit;

	@FindBy(xpath = "//a[@aria-label='Ignite Internet 150u Add to cart']/span[@role='text']")
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
		
		getReusableActionsInstance().getWhenReady(btnInternetPackage, 120).click();
	}

	/**
	 * To select Ignite Internet Gigabit Package
	 * @author Manpreet.Kaur3
	 */
	public void clkInternet1GbpsPackage() {

		getReusableActionsInstance().getWhenReady(btnInternet1GbpsPackage, 90).click();
	}

	/**
	 * Click the I understand button on the important information popup
	 * @author Manpreet.Kaur3
	 */
	public void clkIUnderstand() {
		getReusableActionsInstance().getWhenReady(btnUnderstand, 120).click();
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

	/**
	 * To select type of contract to month-to-month
	 * @author Manpreet.Kaur3
	 */
	public void selectMonthToMonthTypeOfContact() {
		getReusableActionsInstance().waitForElementVisibility(drpdwnTypeOfContract, 120);
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Add Ignite Internet Gigabit to your cart']/ancestor::div[@class='internet-bundle-tile__price']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}

	/**
	 * To select type of contract to month-to-month for Ignite Internet 150 Mbps
	 * @author Manpreet.Kaur3
	 */
	public void select150MonthToMonthTypeOfContact() {
		getReusableActionsInstance().waitForElementVisibility(drpdwn150pkgTypeOfContract, 120);
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Internet 150u Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}
	/**
	 * To select type of contract to month-to-month for Ignite Internet 150 Mbps
	 * @author Manpreet.Kaur3
	 */
	public void select500MonthToMonthTypeOfContact() {
		getReusableActionsInstance().waitForElementVisibility(drpdwn500pkgTypeOfContract, 120);
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Internet 500u Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}


	/**
	 * To select type of contract to month-to-month for Ignite Internet 150 Mbps after DST
	 * @author Manpreet.Kaur3
	 */
	public void selectDST150MonthToMonthTypeOfContract() {
		getReusableActionsInstance().waitForElementVisibility(drpdwnDST150pkgTypeOfContract, 120);
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Add Ignite Internet 150u to your cart']/ancestor::div[@class='internet-bundle-tile__price']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}


	/**
	 * To select type of contract to month-to-month for SS Internet 150 Mbps
	 * @author Manpreet.Kaur3
	 */
	public void selectSmartStreamPkgMonthToMonthTypeOfContact() {
		getReusableActionsInstance().getWhenReady(drpdwnSSpkgTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite 150 Ultd + Streaming Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}


	/**
	 * To select the Ignite SmartSteam 1Gbps Package
	 * @author Manpreet.Kaur3
	 */
	public void selectIgniteSmartStream1GbpsCheckBox() {
		getReusableActionsInstance().waitForElementVisibility(chkbox1GbpsSmartStream, 10);
		if(!(chkbox1GbpsSmartStream.isSelected())) {
			getReusableActionsInstance().clickIfAvailable(chkbox1GbpsSmartStream);
		}
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

	/**
	 * To click on Take the Quiz for DST
	 * @author Manpreet.Kaur3
	 */
	public void clkTakeQuiz() {
		getReusableActionsInstance().getWhenReady(btnquiz, 90).click();
	}

	/**
	 * To select the WeB Email- Internet Usage activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkWebEmail() {
		getReusableActionsInstance().getWhenReady(btnWebEmail, 90).click();
	}

	/**
	 * To select the Work from Home- Internet Usage activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkWorkHome() {
		getReusableActionsInstance().getWhenReady(btnWorkHome, 90).click();
	}

	/**
	 * To select the Online Gaming- Internet Usage activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkOnlineGamingBtn() {
		getReusableActionsInstance().getWhenReady(btnOnlineGaming, 90).click();
	}

	/**
	 * To select the Sharing large videos- Internet Usage activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkSharingLargeVideosBtn() {
		getReusableActionsInstance().getWhenReady(btnSharingLargeFiles, 90).click();
	}

	/**
	 * To select the Smart Devices activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkSmartDevicesBtn() {
		getReusableActionsInstance().getWhenReady(btnSmartHomeDevices, 90).click();
	}

	/**
	 * To select the Streaming shows and Movies- Internet Usage activity of household
	 * @author Manpreet.Kaur3
	 */
	public void clkStreamingShowsBtn() {
		getReusableActionsInstance().getWhenReady(btnStreamingMovies, 90).click();
	}

	/**
	 * To click on DST continue on next page
	 * @author Manpreet.Kaur3
	 */
	public void clkDSTContinue() {
		getReusableActionsInstance().getWhenReady(btnDSTContinue, 90).click();
	}

	/**
	 * To select the Internet Count on DST
	 * @author Manpreet.Kaur3
	 */
	public void clkInternetCount() {
		getReusableActionsInstance().getWhenReady(btnInternetCount, 90).click();
	}

	/**
	 * To select the Internet Count on DST
	 * @author Manpreet.Kaur3
	 */
	public void clkInternetCount6OrMore() {
		getReusableActionsInstance().getWhenReady(btnInternetCount6OrMore, 90).click();
	}

	/**
	 * To select the Internet Devices on DST
	 * @author Manpreet.Kaur3
	 */
	public void clkInternetDevice() {
		getReusableActionsInstance().getWhenReady(btnInternetDevice, 90).click();
	}

	/**
	 * To select the Internet Devices on DST
	 * @author Manpreet.Kaur3
	 */
	public void clkInternetDevice16OrMore() {
		getReusableActionsInstance().getWhenReady(btnInternetDevice16OrMore, 90).click();
	}


	public void VerifyBestFit() {
		getReusableActionsInstance().getWhenReady(VerifyBestFit, 90).isDisplayed();
	}

	/**
	 * To close the DST
	 * @author Manpreet.Kaur3
	 */
	public void clkDSTClose() {
		getReusableActionsInstance().getWhenReady(btnDSTClose, 90).click();
	}

	public void VerifyYourBestFit() {
		getReusableActionsInstance().getWhenReady(VerifyYourBestFit, 90).isDisplayed();
	}


	public void clkBestAdd() {
		getReusableActionsInstance().getWhenReady(btnBestAdd, 60).click();
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

	/**
	 * To scroll to Ignite Starter at offers page
	 * @author Manpreet.Kaur3
	 */
	public void scrollToIgniteInternet150() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(headerIgniteInternet150);
	}

	public void selectMonthToMonthTypeOfContractMobile(){
		getReusableActionsInstance().waitForElementVisibility(drpdwn150pkgTypeOfContract, 30);
		getReusableActionsInstance().getWhenReady(drpdwn150pkgTypeOfContract,30).click();
		Select monthToMonthContact = new Select(getDriver().findElement(By.xpath("//a[@aria-label='Ignite Internet 150u Add to cart']/ancestor::div[@class='vertical-tile-component']/descendant::select[@aria-label='Show contract types and select an option']")));
		monthToMonthContact.selectByVisibleText("Month-to-month");
	}
	public void clkInternetBuyContinueMobile() {
		if(getReusableActionsInstance().isElementVisible(popUpLoading, 20)) {
			getReusableActionsInstance().waitForElementInvisibility(popUpLoading, 90);
		}
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().executeJavaScriptClick(btnInternetBuyContinue);

	}

	/**
	 * Verify the Cart Summary Page
	 * @return true if the Cart Summary header displayed  else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyCartSummaryHeader() {
		//getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().staticWait(6000);
		return getReusableActionsInstance().isElementVisible(txtCartSummaryHeader,60);
	}


	public void clkInternetBuyContinue() {
		/* if(!getReusableActionsInstance().isElementVisible(btnInternetBuyContinue, 20)) {
			getReusableActionsInstance().waitForElementInvisibility(popUpLoading, 90);
		} */
		if(getReusableActionsInstance().isElementVisible(popUpLoading, 20)) {
			getReusableActionsInstance().waitForElementInvisibility(popUpLoading, 90);
		}
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(btnInternetBuyContinue, 60);
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
		return getReusableActionsInstance().isElementVisible(btnPromoCode,40);
	}

	/**
	 * Verify the Internet header
	 * @return true if the internet header is displayed  else false
	 * @author manpreet.kaur3
	 */
	public boolean verifyInternetOffersPage() {
		//getReusableActionsInstance().staticWait(5000);
		return getReusableActionsInstance().isElementVisible(headerInternet, 90);

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
		getReusableActionsInstance().waitForElementVisibility(imgInvalidPromoCodeError, 60);
		Boolean isPromoCodeInvalid = getReusableActionsInstance().isElementVisible(imgInvalidPromoCodeError,10);
		getReusableActionsInstance().scrollToElement(btnTakeAquiz);
		return isPromoCodeInvalid;
	}

	/**
	 * To verify the PSEF promotion
	 * @return true if PSEF promotion available else false
	 * @author Manpreet.Kaur3
	 */
	public Boolean verifyDisneyImage() {
		return getReusableActionsInstance().isElementVisible(imgDisneyBanner, 20);
	}

	/**
	 * To verify the Ignite SmartSteam 150 Package checkbox is selected
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyIgniteStreamingIsChecked() {
		getReusableActionsInstance().waitForElementVisibility(chkbox150IgniteStreaming, 5);
		return chkbox150IgniteStreaming.isSelected();
	}

	/**
	 * To verify the GWP tag
	 * @return true if GWP tag available else false
	 * @author Manpreet.Kaur3
	 */
    public boolean verifyGWPTag() {
		return getReusableActionsInstance().isElementVisible(txtGWP, 20);
    }

	public void scrollToPackageDetails(){
		getReusableActionsInstance().javascriptScrollByVisibleElement(txtPackageDetails);
	}


}
