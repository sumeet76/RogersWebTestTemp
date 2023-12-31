package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersCartSummaryPage extends BasePageClass {

	public RogersCartSummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	@FindBy(xpath = "//a[@checkout-res='checkout_see_add_a_line']")
	WebElement lnkAddAnotherLine;
	
	/**
	 * To verify the Rogers cart summary Page load
	 * @author Saurav.Goyal
	 */
	public void verifyCartSummaryPageLoadedSuccessfully() {
		getReusableActionsInstance().waitForElementVisibility(btnContinue, 60);
	}
	
	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().waitForElementTobeClickable(btnContinue, 60);
		getReusableActionsInstance().clickWhenReady(btnContinue);
	}
	
	/**
	 * Clicks on the 'Add Another Line' link
	 * @author rajesh.varalli1
	 */
	public void clkAddAnotherLine() {
		getReusableActionsInstance().clickWhenReady(lnkAddAnotherLine,60);
	}

}