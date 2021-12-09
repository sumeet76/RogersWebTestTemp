package com.rogers.oneview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import java.util.List;

public class InternetDashboardPage  extends BasePageClass {

	public InternetDashboardPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted'] | //span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContnue;

	@FindBy(xpath = "//div[@class='nsm-dialog success nsm-dialog-open']//preceding::i[@class='rch-icon']")
	WebElement imgSuccess;

	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnSuccessOk;


	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnHeader;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnFooter;

	@FindBy(xpath = "//div[@class='second-level-nav__cta']//button[@class='b-linkCta']")
	WebElement btnBackToAccountOverview;

	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large']")
	WebElement btnUsageAndAlerts;

	@FindBy(xpath = "//a[@href='https://www.rogers.com/consumer/internet/mesh-whole-home-wifi-network?ipn=1']")
	WebElement lnkLearnMoreWallToWallWifi;

	@FindBy(xpath = "//a[@href='/customer/support/article/understanding-wi-fi']")
	WebElement lnkUnderstandingWifi;

	@FindBy(xpath = "//a[@href='/customer/support/article/tips-for-placing-eeros']")
	WebElement lnkTipsForPlacingEero;

	@FindBy(xpath = "//a[@href='/customer/support/article/internet-speedtest']")
	WebElement lnkTestInternetSpeed;

	@FindBy(xpath = "//a[@href='/customer/support/article/how-to-optimize-your-internet-speed-and-wi-fi']")
	WebElement lnkHowToOptimizeSpeed;

	@FindBy(xpath = "//a[@href='/consumer/support/internet/IgniteInternet']")
	WebElement lnkGoToSupportSection;

	@FindBy(xpath="//span[(contains(text(),'Change internet package') or contains(text(),'Changer de forfait Internet')) or @translate='global.dashboard.common.changeInternetPackage']/ancestor::button")
	WebElement btnChangeInternetPackage;

	@FindBy(xpath = "//span[text()='Sélectionner' or text()='Select']/ancestor::button")
	WebElement btnSelectPackage;

	@FindBy(xpath="(//span[text()='Sélectionner' or text()='Select']/ancestor::button)[1]")
	WebElement firstLowestPackage;

	@FindBy(xpath="//div[text() ='Ignite TV Flex 20 + Sports']/ancestor::div[4]/ancestor::div[3]/child::div[2]/preceding::*[text()='Select'][1]")
	WebElement btnIgnite10Select;



	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContnueReset;

	@FindBy(xpath = "//p[text()='Select Change Date' or text()='Sélectionner la date du changement' ]/ancestor::div//span[text()='Continue' or text()='Continuer']")
	WebElement btnContinueChangeDate;

	@FindBy(xpath = "//div[contains(@id,'ds-radio-input-id-1-label-container')]/preceding-sibling::div[contains(@class,'ds-radioButton')]")
	WebElement btnImmediateBill;

	@FindBy(xpath="//span[contains(text(),'Add SmartStream') or contains(text(),'Ajouter le service Diffusion futée')]/ancestor::button")
	WebElement btnAddSmartStream;

	@FindBy(xpath="//span[contains(text(),'Select') or contains(text(),'Sélectionner')]/ancestor::button")
	WebElement btnSmartStreamSelect;

	@FindBy(xpath="//span[contains(text(),'Continue') or contains(text(),'Continuer')]/ancestor::button")
	WebElement btnContinueAddingStream;


	@FindBy(xpath="//div[@class='text-body text-bold text-uppercase']")
	WebElement currentSmartStream;

	String smartstreamTitle = "//div[@class='smartStream-tile__bundle-name']";
	String smartstreamSelect = "//span[@translate='global.cta.select']/ancestor::button";

	@FindBy(xpath = "//p[contains(text(),'Immediately')]/parent::div/preceding-sibling::div")
	WebElement rdImmediate;

	//@FindBy(xpath = "//button[contains(@class, 'expander ds-color-black ds-button ')]")
	@FindBy(xpath = "//*[text()='More details about this bundle']")
	WebElement expandMoreDetails;

	@FindBy(xpath = "//button[contains(@class, 'expander ds-color-black pl-16 ds-button ')]")
	WebElement expandSeeFullDetails;

	@FindBy(xpath = "//div[text() ='Ignite TV Flex 10']/following::*[text()='150 Mbps'][1]/parent::span/parent::span")
	//@FindBy(xpath = "//input[@id='ds-radio-input-id-9']")
	WebElement downloadSpeed;

	@FindBy(xpath="(//span[text()='Sélectionner' or text()='Select']/ancestor::button)[4]")
	WebElement igniteTVPremiumPackage;

	//@FindBy(xpath = "(//span[text()='Sélectionner' or text()='Select']/ancestor::button)[2]")
	//WebElement igniteTvFlex10;




	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifLlnkLearnMoreWallToWallWifi() {
		getReusableActionsInstance().waitForElementVisibility(lnkLearnMoreWallToWallWifi, 120);
		WebElement btn=getReusableActionsInstance().getWhenReady(lnkLearnMoreWallToWallWifi,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-100);
		return getReusableActionsInstance().isElementVisible(lnkLearnMoreWallToWallWifi,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkUnderstandingWifi() {
		return getReusableActionsInstance().isElementVisible(lnkUnderstandingWifi,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkTipsForPlacingEero() {
		return getReusableActionsInstance().isElementVisible(lnkTipsForPlacingEero,120);
	}


	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkTestInternetSpeed() {
		return getReusableActionsInstance().isElementVisible(lnkTestInternetSpeed,120);
	}


	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkHowToOptimizeSpeed() {
		return getReusableActionsInstance().isElementVisible(lnkHowToOptimizeSpeed,120);
	}

	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLnkGoToSupportSection() {
		return getReusableActionsInstance().isElementVisible(lnkGoToSupportSection,120);
	}


	/**
	 * Click the view usage and alerts button
	 * @author chinnarao.vattam
	 */
	public void clickbtnUsageAndAlerts() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnUsageAndAlerts,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnUsageAndAlerts,45);
	}

	/**
	 * Click the back to overview button which brings the account overview page up
	 * @author chinnarao.vattam
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview,120).click();
	}

	/**
	 *click continue for the ongoing activity on Internet dashboard page
	 * @author chinnarao.vattam
	 */
	public void clickContinue() {
		getReusableActionsInstance().getWhenReady(btnContnue,30).click();
	}

	/**
	 * Verify the result
	 * @return true if operation is successful, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccess() {
		getReusableActionsInstance().waitForElementInvisibility(popupLoadingFinger, 120);
		return getReusableActionsInstance().isElementVisible(imgSuccess);
	}

	/**
	 * Click "Ok" on success popup
	 * @author chinnarao.vattam
	 */
	public void clickSuccessOk() {
		getReusableActionsInstance().getWhenReady(btnSuccessOk, 120).click();
	}

	/**
	 * Verify the header availability
	 * @return true if header is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyHeader() {
		getReusableActionsInstance().waitForElementVisibility(icnHeader,120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}

	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyFooter() {

		return getReusableActionsInstance().isElementVisible(icnFooter,120);
	}

	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */
	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}


	/**
	 * Go to Page bottom
	 * @author chinnarao.vattam
	 */
	public void goToPageMid() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();;
	}
	/*
	 * Clicks on change Internet package button
	 * @author suganya P
	 * */
	public void clickChangeInternetPackage() {
		WebElement select = getReusableActionsInstance().getWhenReady(btnChangeInternetPackage, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, select.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnChangeInternetPackage, 120).click();
	}
	/*
	 * Selects the first lowest internet package
	 * @author suganya P
	 * */
	public void selectFirstLowestPackage() {
		WebElement btn = getReusableActionsInstance().getWhenReady(firstLowestPackage, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(firstLowestPackage, 60).click();
	}

	public void selectButtonIgnite10() {
		WebElement btn = getReusableActionsInstance().getWhenReady(btnIgnite10Select, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(btnIgnite10Select, 60).click();
	}
	/*
	 * Clicks continue on change Internet package
	 * @author suganay P
	 * */
	public void clickContinueChangeInternetPackage() {
		getReusableActionsInstance().getWhenReady(btnContnueReset, 90).click();
	}
	/*
	 * Click on continue in Select billing date pop up
	 * @author suganya P
	 * */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate,60).click();
	}
	/*Selects the Immediate Billing option
	 * @author suganya p
	 * */
	public void clickImmediateBill() {
		getReusableActionsInstance().getWhenReady(btnImmediateBill,120).click();
	}
	/*Clicks on add smart stream button
	 * @author suganya p
	 * */
	public void clickAddSmartStream() {
		WebElement select=getReusableActionsInstance().getWhenReady(btnAddSmartStream, 120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,select.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnAddSmartStream, 120).click();
	}






	/*Choose the different plan
	 * @author aditi.jain
	 * */
	public void clickSelectSmartStreamChangeTier() {

		WebElement element = getReusableActionsInstance().getWhenReady(currentSmartStream);
		String[] currentTitle = element.getText().split(" ");
		String currentTitleLastWord = currentTitle[currentTitle.length - 1];

		List<WebElement> allSmartStreams = getDriver().findElements(By.xpath(smartstreamTitle));
		for (int i = 1; i <= allSmartStreams.size(); i++) {
			getReusableActionsInstance().staticWait(2000);
			if (getReusableActionsInstance().isElementVisible(btnContnue, 5)) {
				clickContinue();
			}

			WebElement smartStreamElement = getReusableActionsInstance().getWhenReady(By.xpath("(" + smartstreamTitle + ")" + "[" + i + "]"));

			String[] titles = smartStreamElement.getText().split(" ");
			String planToSelect = titles[titles.length - 1];

			if (!planToSelect.equalsIgnoreCase(currentTitleLastWord)) {
				int index = i / 2 + 1;
				WebElement selectISS = getReusableActionsInstance().getWhenReady(By.xpath("(" + smartstreamSelect + ")" + "[" + index + "]"));
				getReusableActionsInstance().scrollToElement(selectISS);
				getReusableActionsInstance().executeJavaScriptClick(selectISS);
				break;

			} else {
				i++;
			}


		}


	}


	/*Choose the first avaialble smart stream package
	 * @author suganya P
	 * */
	public void clickSelectSmartStream() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnSmartStreamSelect, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().getWhenReady(btnSmartStreamSelect,60).click(); }
	/*
	 * clicks continue on the Smart Stream
	 * @author suganya p
	 * */
	public void clickContinueAddingStream() {
		getReusableActionsInstance().getWhenReady(btnContinueAddingStream,60).click();
	}
	/* Selects the internet package based on the inputted package name
	 * @autho suganya P
	 * */
	public void selectInternetPackage(String strUpgradePlanEn, String strUpgradePlanFr) {
		By packageNameLocator = By.xpath("//p[contains(text(),'"+strUpgradePlanEn+"') or contains(text(),'"+strUpgradePlanFr+"')]/ancestor::div[@class='internet-tile__body']//span[contains(text(),'Select')]/ancestor::button");
		getReusableActionsInstance().getWhenReady(packageNameLocator, 20);
		WebElement pkg = getDriver().findElement(packageNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);
	}


	public void clickWalltoWallWifiLink(){
		getReusableActionsInstance().clickWhenReady(lnkLearnMoreWallToWallWifi);
	}



/*	public void selectIgniteTVFlex10() {
		getReusableActionsInstance().staticWait(5000);
		WebElement btn = getReusableActionsInstance().getWhenReady(btnIgniteTvFlex10, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(igniteTvFlex10, 60).click();
	}*/

	public void selectRadioImmediate()
	{
		getReusableActionsInstance().isElementVisible(rdImmediate, 60);
		getReusableActionsInstance().scrollToElementAndClick(rdImmediate);
		getReusableActionsInstance().clickWhenReady(rdImmediate,60);
	}

	/*public void selectMoreDetails()
	{
		getReusableActionsInstance().isElementVisible(expandMoreDetails, 60);
		getReusableActionsInstance().scrollToElementAndClick(expandMoreDetails);
		getReusableActionsInstance().clickIfAvailable(expandMoreDetails,60);
	}*/
	/*public void selectSeeFullDetails()
	{
		getReusableActionsInstance().isElementVisible(expandSeeFullDetails, 60);
		getReusableActionsInstance().scrollToElementAndClick(expandSeeFullDetails);
		getReusableActionsInstance().clickIfAvailable(expandSeeFullDetails,60);
	}*/

	public void selectDownloadSpeed()
	{
		getReusableActionsInstance().isElementVisible(downloadSpeed, 60);
		//getReusableActionsInstance().scrollToElementAndClick(downloadSpeed);
		getReusableActionsInstance().clickWhenReady(downloadSpeed,60);
	}


	//***********
	@FindBy(xpath="//span[contains(text(),'Current bundle')]/following-sibling::span")
	WebElement currentBundle;

	public void selectPlanUnderSameTvPackage(String internetPlan) {
		getReusableActionsInstance().staticWait(6000); /*To get the current tv bundle name and select the internet plan variation under the same tv bundle*/
		String tvPackage= currentBundle.getText();
		By planNameLocator = By.xpath("//div[contains(text(),'"+tvPackage.substring(10)+"')]/ancestor::div[@class='bundle-tile__body__row']/following-sibling::div//span[text()='"+internetPlan+"']");
		getReusableActionsInstance().getWhenReady(planNameLocator, 120);
		WebElement pkg = getDriver().findElement(planNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg); /*To click on Select button*/
		By selectLocator = By.xpath("//div[contains(text(),'"+tvPackage.substring(10)+"')]/ancestor::div[contains(@class,'bundle-tile__table')]/following-sibling::div//span[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(selectLocator, 20);
		WebElement button = getDriver().findElement(selectLocator);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}

	/*
	 * Selects the internet plan variation form corresponding tv package
	 * @author suganya P
	 * */
	public void selectPlanUnderTvPackage(String tvPackage,String internetPlan) {
		getReusableActionsInstance().staticWait(6000);



		/*To click on internet plan*/
		By planNameLocator = By.xpath("//div[contains(text(),'"+tvPackage+"')]/ancestor::div[@class='bundle-tile__body__row']/following-sibling::div//span[text()='"+internetPlan+"']");
		getReusableActionsInstance().getWhenReady(planNameLocator, 120);
		WebElement pkg = getDriver().findElement(planNameLocator);
		getReusableActionsInstance().executeJavaScriptClick(pkg);



		/*To click on Select button*/
		By selectLocator = By.xpath("//div[contains(text(),'"+tvPackage+"')]/ancestor::div[contains(@class,'bundle-tile__table')]/following-sibling::div//span[@translate='global.cta.select']");
		getReusableActionsInstance().getWhenReady(selectLocator, 20);
		WebElement button = getDriver().findElement(selectLocator);
		getReusableActionsInstance().executeJavaScriptClick(button);
	}




}

