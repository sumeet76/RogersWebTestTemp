package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersPPCOrderReviewPage extends BasePageClass {

	public RogersPPCOrderReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@checkout-res='checkout_review_order']")
	WebElement lblReviewYourOrder;
	
	@FindBy(xpath = "//span[@class='__order_summary_total']")
	WebElement lblOrderSummaryTotal;
	
	@FindBy(xpath = "//div[@class='total-amount']/div/span")
	WebElement lblPricePlanAmount;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_terms_and_conditions']")
	WebElement lblAdditionalAgreementDetails;
	
	@FindBy(xpath = "//input[@id='termsCheckbox']/../label")
	WebElement chkboxTerms;
	
	@FindBy(xpath = "//input[@id='digital-copy']/../label")
	WebElement rdbtnEmail;
	
	@FindBy(xpath = "//button[@data-dtname='reviewOrder-submit']")
	WebElement btnSubmitOrder;
	
	/**
	 * Validates whether the Order Review page has loaded
	 * @return true if 'Review Your Order' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyReviewOrderPageLoad() {
		return reusableActions.isElementVisible(lblReviewYourOrder, 60);
	}
	
	/**
	 * Validates if the 'Order Summary Total' section is displayed
	 * @return true if 'Order Summary Total' header is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderSummaryTotalDisplayed() {
		return reusableActions.isElementVisible(lblOrderSummaryTotal);
	}
	
	/**
	 * Returns the Amount of the Price Plan in the Order Summary
	 * @return Amount in Decimal format
	 */
	public float getPricePlanAmount() {
		return Float.parseFloat(lblPricePlanAmount.getText().replace("$", "").trim());
	}
	
	/**
	 * Validates if the 'Additional Agreement Details' section is displayed
	 * @return true if 'Additional Agreement Details' header is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAdditionalAgreementDetailsDisplayed() {
		return reusableActions.isElementVisible(lblAdditionalAgreementDetails);
	}
	
	/**
	 * Clicks on the Terms checkbox
	 * @author rajesh.varalli1
	 */
	public void clickTermsCheckbox() {
		reusableActions.clickWhenVisible(chkboxTerms);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 */
	public void clickEmailDigitalCopy() {
		reusableActions.clickWhenVisible(rdbtnEmail);
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clickSubmitOrder() {
		reusableActions.clickWhenVisible(btnSubmitOrder);
	}

}