package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersShareEverythingPage extends BasePageClass {

	public RogersShareEverythingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//canvas[contains(@class,'dataManager')]")
	WebElement imgSharedData;

	@FindBy(xpath = "//span[contains(text(),'Shared Data Usage')]")
	WebElement lblSharedDataUsage;

	@FindBy(xpath = "//a[@class='my-line-change-number']")
	WebElement lnkChangeMyCallerId;
		
	@FindBy(xpath = "//span[contains(@class,'menu') and contains(@data-translate,'overview')]")
	WebElement lnkOverview;
	
	@FindBy(xpath = "//div[contains(@class,'upgradePlan')]/button[contains(@class,'upgradePlan')]")
	WebElement btnChangePlan;
	
	/**
	 * Validates whether Share Everything page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyShareEverythingPageLoad() {
		return (reusableActions.isElementVisible(imgSharedData) && reusableActions.isElementVisible(lblSharedDataUsage));
	}
	
	/**
	 * Clicks on the 'Change My Caller Id' link
	 * @author rajesh.varalli1
	 */
	public void clickChangeMyCallerId() {
		reusableActions.scrollToElement(lnkChangeMyCallerId);
		reusableActions.clickIfAvailable(lnkChangeMyCallerId);
	}
	
	/**
	 * Clicks on the Overview button/link on the top menu
	 * @author rajesh.varalli1
	 */
	public void clickOverview() {
		reusableActions.clickIfAvailable(lnkOverview);
	}
	
	/**
	 * Clicks on the 'Change Plan' icon
	 * @author rajesh.varalli1
	 */
	public void clickChangePlanButton() {
		reusableActions.clickIfAvailable(btnChangePlan);
	}
	
}