package com.rogers.oneview.pages;

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
	
	
}

