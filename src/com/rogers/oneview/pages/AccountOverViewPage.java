package com.rogers.oneview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class AccountOverViewPage  extends BasePageClass {

	public AccountOverViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='ute-icon-tv']")
	WebElement btnTVBadge;
	
	@FindBy(xpath = "//span[@class='ute-icon-internet']")
	WebElement btnInternetBadge;
	

	@FindBy(xpath = "//span[@class='ute-icon-home-phone']")
	WebElement btnHomePhoneBadge;
	
	@FindBy(xpath = "//div[@translate='myaccoverview_get_ignite_bundle']/ancestor::div[@role='button']")
	WebElement btnGetIgniteTVBadge;
	
	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
	WebElement infoBalanceLable;
	
	//ToDo Change the index
	//@FindBy(xpath = "//div[@class='oneview-dialog']//button")
	@FindBy(xpath = "(//app-dialog//i[@class='close rui-icon-mobile-menu-exit'])[2]")
	WebElement btnOneViewDataManagerDialogue;

	@FindBy(xpath = "//div[@class='oneview-dialog']//button")
	WebElement btnOkOneViewDialogue;
	
	/**
	 * To click on ok button after clicking on Assign data manager in the dialogue box @function clkBtnAssignDataManager
	 * @author Saurav.Goyal
	 */
	public void clkBtnOkOneViewDialoue() {
		if(reusableActions.isElementVisible(btnOkOneViewDialogue, 30))
			reusableActions.clickIfAvailable(btnOkOneViewDialogue);
	}
	
	/**
	 * To click on Assign data manager in the dialogue box
	 * @author Saurav.Goyal
	 */
	public void clkBtnAssignDataManager() {
		reusableActions.clickIfAvailable(btnOneViewDataManagerDialogue,30);
	}
	
	/**
	 * Selects the Internet Badge on the account dashbaord
	 * @author Drashti.Patel
	 */
	public void selectInternetBadage() {
		WebElement btn=reusableActions.getWhenReady(btnInternetBadge,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		reusableActions.clickWhenReady(btnInternetBadge,45);
		
		}
		
	/**
	 * Selects the Home Phone Badge on the account dashbaord
	 * @author Drashti.Patel
	 */
	public void selectHomePhoneBadge() {
		WebElement btn=reusableActions.getWhenReady(btnHomePhoneBadge,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		reusableActions.clickWhenReady(btnHomePhoneBadge,45);
		}

	
	/**
	 * Selects the TV Badge on the account dashbaord
	 * @param   strBrowser is the browser to be run 
	 * @author Chinnarao.Vattam
	 */
	public void selectTVBadage(String strBrowser) {
		WebElement btn=reusableActions.getWhenReady(btnTVBadge,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		reusableActions.clickWhenReady(btnTVBadge,45);
		
		}
	/**
	 * Selects the TV Badge on the account dashbaord
	 * @author Drashti.Patel
	 */
	public void selectTVBadage() {
		WebElement btn=reusableActions.getWhenReady(btnTVBadge,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		reusableActions.clickWhenReady(btnTVBadge,45);
		}
	/**
	 * Selects the Get Ignite TV Badge on the account dashbaord
	 * @author harpartap.virk
	 */
	public void selectGetIgniteTVBadge() {
			//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
			reusableActions.getWhenReady(btnGetIgniteTVBadge, 50).sendKeys(Keys.ENTER);
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
		reusableActions.clickIfAvailable(By.xpath("//div[@class='rep-notifications permitted']//div[@class='blocker']"));
		if(reusableActions.isElementVisible(By.xpath(strCTNXpath))) {
			reusableActions.scrollToElement(reusableActions.getWhenReady(By.xpath(strCTNXpath)));
			reusableActions.clickWhenReady(By.xpath(strCTNXpath), 120);
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
		if(reusableActions.isElementVisible(By.xpath(strCTNXpath))) {
			reusableActions.executeJavaScriptClick(driver.findElement(By.xpath(strCTNXpath)));
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
		return reusableActions.isElementVisible(infoBalanceLable,60);
	}
}

