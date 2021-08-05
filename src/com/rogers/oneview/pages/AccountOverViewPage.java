package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AccountOverViewPage  extends BasePageClass {

	public AccountOverViewPage(WebDriver driver) {
		super(driver);
	}

	@FindAll({
			@FindBy(xpath = "//agent-notifications[contains(@state,'autopop')]/div[contains(@class,'blocker')]"),
			@FindBy(xpath = "//div[contains(@class,'blocker ng')]"),
			@FindBy(xpath = "//agent-notifications/div[contains(@class,'blocker')]"),
	})
	WebElement skipNotification;

	@FindBy(xpath = "//div[contains(@class,'IPTV')]")
	WebElement btnTVBadge;

	@FindBy(xpath = "//span[@class='icon rui-icon-internet-v2']")
	WebElement btnInternetBadge;

	@FindAll({
	@FindBy(xpath = "//t[text()='Ignite Home Phone']"),
			@FindBy(xpath = "//span[@class='ute-icon-home-phone']")})
	WebElement btnHomePhoneBadge;
//	@FindAll({
//	@FindBy(xpath = "//div[@translate='myaccoverview_get_ignite_bundle']/ancestor::div[@role='button']"),
//	@FindBy(xpath = "//t[contains(text(),'Ignite')]/ancestor::a")})


	@FindBy(xpath = "//app-service-badge-tv-care/descendant::div[@class='service-detail service-address'] | //div[@class='service-badge tv active-ind IPTV'] | //div[@class='service-badge tv active-ind DigitalTV']")
	WebElement btnGetIgniteTVBadge;

	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
	WebElement infoBalanceLable;

	//ToDo Change the index
	//@FindBy(xpath = "//div[@class='oneview-dialog']//button")
	@FindBy(xpath = "(//app-dialog//i[@class='close rui-icon-mobile-menu-exit'])[2]")
	WebElement btnOneViewDataManagerDialogue;

	@FindBy(xpath = "//div[@class='oneview-dialog']//button")
	WebElement btnOkOneViewDialogue;

	@FindAll({
			@FindBy(xpath = "//input[@class='hup-input']"),
			@FindBy(xpath = "//input[@name='dealerCode']")
	})
	WebElement delearCodeOneViewDialogue;

	@FindBy(xpath = "//button[@class='hup-button red']")
	WebElement btnSubmitOneViewDialogue;

	@FindAll({
			@FindBy(xpath = "//t[contains(text(),'Add new wireless line')]"),
			@FindBy(xpath = "//t[contains(text(),'Add a line')]")
	})
	WebElement addNewWirelessLineButton;
	@FindAll({
			@FindBy(xpath = "//button[contains(text(),'View all alerts') or contains(text(), 'Voir toutes les alertes')]"),
			@FindBy(xpath = "//div[@class='agent-notifications-popup ng-star-inserted']")
	})
	WebElement viewAllAlerts;

	@FindBy(xpath = "//img[@class='bell-icon'] | //a[@class='agent-notifications-icon']")
	WebElement notificationBell;

	@FindBy(xpath = "//div[@class='button-set set-left ng-star-inserted']/descendant::span[contains(text(),'TV')]")
	WebElement changeTVBundle;

	@FindBy(xpath = "//span[@class='rui-icon-plus']/following-sibling::t[contains(text(), 'Ignite') or contains(text(), 'Élan')]")
	WebElement migrateToIgnite;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement OK;

	@FindBy(xpath = "//h2[@ng-reflect-translate='global.label.noOfChannels']")
	WebElement tvOrChannelHeader;

	@FindBy(xpath = "//h3[@translate='global.dashboard.tv.customerHasTheFollowing']")
	WebElement customerFollowingHeader;


	/**
	 * Validate if either TV or channel header is visible
	 * @author aditi.jain
	 */
	public boolean verifyTVOrChannelHeader() {
		return getReusableActionsInstance().isElementVisible(tvOrChannelHeader, 90);
	}

	/**
	 * Validate if customer following header is visible
	 * @author aditi.jain
	 */
	public boolean verifyCustomerFollowingsHeader() {
		return getReusableActionsInstance().isElementVisible(customerFollowingHeader, 60);
	}

	/**
	 * To skip notification panel with a bell icon
	 * @author sidhartha.vadrevu
	 */
	public void setSkipNotification() {
		getReusableActionsInstance().clickIfAvailable(skipNotification, 30);
	}

	/**
	 * This method clicks on wireless link to add a new wireless line
	 * @author praveen.kumar7
	 */
	public void clkWirelessLink() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//t[contains(.,'Wireless') or contains(.,'Sans-fil')]/ancestor::a[contains(@class,'nac-link')]"),20));

	}

	/**
	 * To enter dealer code in dealer code dialogue box
	 * @author Saurav.Goyal
	 */
	public void enterDealerCodeDialogue() {
		if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue)) {
			getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
			getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue,30);
		}

	}
	/**
	 * Click notification bell if any notificaiton is present
	 * @author aditi.jain
	 */
	public void clickNotificationIfPresent() {

		if(getReusableActionsInstance().isElementVisible(viewAllAlerts,60)) {
			getReusableActionsInstance().waitForElementVisibility(notificationBell, 60);
			getReusableActionsInstance().executeJavaScriptClick(notificationBell);
		}
	}
	/**
	 * Selects the Get Ignite TV Badge on the account dashbaord
	 * @author aditi.jain
	 */
	public void clickIgniteTVBadge() {

		if(getReusableActionsInstance().isElementVisible(viewAllAlerts)) {
			getReusableActionsInstance().clickWhenReady(skipNotification);
		}
		if(getReusableActionsInstance().isElementVisible(btnGetIgniteTVBadge, 30)){
//			getReusableActionsInstance().executeJavaScriptClick(btnGetIgniteTVBadge);
			getReusableActionsInstance().scrollToElementAndClick(btnGetIgniteTVBadge);
			getReusableActionsInstance().clickWhenReady(btnGetIgniteTVBadge);
		}
//		getReusableActionsInstance().javascriptScrollToBottomOfPage();
//		getReusableActionsInstance().clickWhenReady(btnGetIgniteTVBadge, 120);
	}
	/**
	 * This method clicks on Ignite link
	 * @author aditi.jain
	 */
	public void clickIgnite() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(migrateToIgnite);
		if(getReusableActionsInstance().isElementVisible(OK,120)) {
			getReusableActionsInstance().executeJavaScriptClick(OK);
		}
	}

	/**
	 * Change TV Bundle, if present
	 * @author Aditi.jain
	 */
	public void selectBundleChangeIfPresent() {
		getReusableActionsInstance().clickIfAvailable(changeTVBundle,45);
	}

	/**
	 * To click on submit button in dealer code dialogue box
	 * @author Saurav.Goyal
	 */
	public void clkSubmitBtnDealerCodeDialogue() {
		getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue,30);
	}
	/**
	 * To click on Assign data manager in the dialogue box
	 * @author Saurav.Goyal
	 */
	public void clkCloseBtnAssignDataManager() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickIfAvailable(btnOneViewDataManagerDialogue,30);
	}

	/**
	 * Selects the Internet Badge on the account dashbaord
	 * @author chinnarao.vattam
	 */
	public void selectInternetBadage() {
		if(getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue,30)) {
			getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
			getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue,30);
		}
		if(getReusableActionsInstance().isElementVisible(skipNotification,50))
		{
			getReusableActionsInstance().clickWhenReady(skipNotification);
		}
		WebElement btn=getReusableActionsInstance().getWhenReady(btnInternetBadge,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnInternetBadge,45);
	}

	/**
	 * Selects the Home Phone Badge on the account dashbaord
	 * @author chinnarao.vattam
	 */
	public void selectHomePhoneBadge() {

		if(getReusableActionsInstance().isElementVisible(skipNotification,10))
		{
			getReusableActionsInstance().clickWhenReady(skipNotification);
		}

		WebElement btn=getReusableActionsInstance().getWhenReady(btnHomePhoneBadge,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnHomePhoneBadge,45);
		}

	/**
	 * Selects the TV Badge on the account dashbaord
	 * @author Chinnarao.Vattam
	 */
	public void selectTVBadage() {
		if(getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue,30)) {
			getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
			getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue,30);
		}
		if(getReusableActionsInstance().isElementVisible(skipNotification,50))
		{
			getReusableActionsInstance().clickWhenReady(skipNotification);
		}
		WebElement btn=getReusableActionsInstance().getWhenReady(btnTVBadge,90);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnTVBadge,45);
		}
	/**
	 * Selects the Get Ignite TV Badge on the account dashbaord
	 * @author Chinnarao.Vattam
	 */
	public void selectGetIgniteTVBadge() {
		if(getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue,30)) {
			getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
			getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue,30);
		}
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
			getReusableActionsInstance().getWhenReady(btnGetIgniteTVBadge, 50).sendKeys(Keys.ENTER);
		}
	/**
	 * Validates and clicks on the Wireless Phone Number
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyAndClickWirelessCTN(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = "(" + strCTN.substring(0, 3) + ") " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		String strCTNXpath = "//*[contains(text(),'" + strCTN + "')]";
		WebElement subNumber = getDriver().findElement(By.xpath("//*[contains(text(),'"+strCTN+"')]"));
		getReusableActionsInstance().clickIfAvailable(By.xpath("//div[@class='rep-notifications permitted']//div[@class='blocker']"));
		if(getReusableActionsInstance().isElementVisible(By.xpath(strCTNXpath))) {
			getReusableActionsInstance().javascriptScrollToBottomOfPage();
			//getReusableActionsInstance().clickWhenReady(By.xpath(strCTNXpath), 120);
			getReusableActionsInstance().executeJavaScriptClick(subNumber);
			return true;
		} else if (verifyAndClickShareEverythingCTN(strCTN)) {
			return true;
		}
		return false;
	}

	/**
	 * Validates and clicks on the Wireless Phone Number under Share Everything
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyAndClickShareEverythingCTN(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		String strCTNXpath = "//div[contains(@class,'sharedWireless')]//div[contains(text(),'" + strCTN +"')]/parent::div/button";
		if(getReusableActionsInstance().isElementVisible(By.xpath(strCTNXpath))) {
			getReusableActionsInstance().executeJavaScriptClick(getDriver().findElement(By.xpath(strCTNXpath)));
			return true;
		}
		return false;
	}

	/**
	 * To verify the successful login
	 * @return true if the balance label is present ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessfulLogin() {
		return getReusableActionsInstance().isElementVisible(infoBalanceLable,60);
	}

	/**
	 * Selects the Add a Wireless Line Button on the account dashbaord
	 * @author Sidhartha.Vadrevu
	 */
	public void selectAddAWirelessLineButton() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(addNewWirelessLineButton);
		getReusableActionsInstance().clickWhenReady(addNewWirelessLineButton,45);
	}
}

