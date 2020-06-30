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
	
	@FindBy(xpath = "//section[contains(@class,'summary-section')]//span/span/span[@res='_continue']")
	WebElement btnContinueHUP;
	
	@FindBy(xpath = "//span[@translate='mppc.summary.checkout_button']/../parent::div[contains(@class,'summary-strip-section')]/button")
	WebElement btnCheckout;
	
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
		reusableActions.waitForElementVisibility(btnCheckout, 60);
	}
}