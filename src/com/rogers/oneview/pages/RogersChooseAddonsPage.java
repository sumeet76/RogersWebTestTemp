package com.rogers.oneview.pages;

import org.openqa.selenium.By;
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
	})
	WebElement btnContinue;
	
	@FindAll({
	//@FindBy(xpath = "//section[contains(@class,'summary-section')]//span/span/span[@res='_continue']")
	@FindBy(xpath = "//section[contains(@class,'summary-section')]//p[@class='col-sm-6 btn button-continue ng-scope']"),
	@FindBy(xpath = "//button[@name='button_continue']//span")
	})
	WebElement btnContinueHUP;
	
	@FindAll({
		//@FindBy(xpath = "//span[@translate='mppc.summary.continue_button']/../parent::div[contains(@class,'summary-strip-section')]/button"),
		@FindBy(xpath = "//span[@translate='mppc.summary.checkout_button']/../parent::div[contains(@class,'summary-strip-section')]/button")
	})
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[contains(@data-ng-repeat,\"subscriber in vm.additionalSubscribers\")]//input[@type='checkbox']/..//label")
	WebElement checkBoxKeepCurrentPlanLine2;
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkCheckBoxKeepCurrentPlanLine2() {
		reusableActions.executeJavaScriptClick(checkBoxKeepCurrentPlanLine2);
		//reusableActions.clickIfAvailable(checkBoxKeepCurrentPlanLine2,30);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinueHUP() {
		reusableActions.executeJavaScriptClick(btnContinueHUP);
		reusableActions.clickIfAvailable(By.xpath("//div[@class='ngdialog-content']//button[@res='_continue']"),60);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.executeJavaScriptClick(btnContinue);
		reusableActions.waitForElementVisibility(btnContinue, 60);
	}
	
	/**
	 * Clicks on the 'Checkout' button
	 * @author rajesh.varalli1
	 */
	public void clkCheckout() {
		reusableActions.clickWhenReady(btnCheckout);
		//reusableActions.waitForElementVisibility(btnCheckout, 60);
	}
}