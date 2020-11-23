package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChooseAddonsPage extends BasePageClass {

	public RogersChooseAddonsPage(WebDriver driver) {
		super(driver);
	}

	
	@FindAll({
		@FindBy(xpath = "//p[@res='_continue']"),
		@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']")
		//@FindBy(xpath = "//section[contains(@class,'summary-section')]//p[@class='col-sm-6 btn button-continue ng-scope']")
	})
	WebElement btnContinue;
	
	//@FindBy(xpath = "//section[contains(@class,'summary-section')]//span/span/span[@res='_continue']")
	@FindBy(xpath = "//section[contains(@class,'summary-section')]//p[@class='col-sm-6 btn button-continue ng-scope']")
	WebElement btnContinueHUP;
	
	@FindBy(xpath = "//span[@translate='mppc.summary.checkout_button']/../parent::div[contains(@class,'summary-strip-section')]/button")
	WebElement btnCheckout;
	
	
	@FindBy(xpath = "//a[@res='ppc_conflicting_step_one' or @res='back_to_device_arrow']")
	WebElement lnkStep2SelectMyPlan;
	
	
	/**
	 * To verify the Rogers choose addon plan Page load
	 * @author Saurav.Goyal
	 */
	public void verifyChooseAddOnsPageLoadedSuccessfully() {
		getReusableActionsInstance().waitForElementVisibility(lnkStep2SelectMyPlan, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueHUP() {
		getReusableActionsInstance().executeJavaScriptClick(btnContinueHUP);
		//getReusableActionsInstance().clickIfAvailable(By.xpath("//div[@class='ngdialog-content']//button[@res='_continue']"),60);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().executeJavaScriptClick(btnContinue);
		getReusableActionsInstance().waitForElementVisibility(btnContinue, 60);
	}
	
	/**
	 * Clicks on the 'Checkout' button
	 * @author rajesh.varalli1
	 */
	public void clkCheckout() {
		getReusableActionsInstance().clickWhenReady(btnCheckout);
		//getReusableActionsInstance().waitForElementVisibility(btnCheckout, 60);
	}
}