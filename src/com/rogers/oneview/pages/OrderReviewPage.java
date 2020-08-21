package com.rogers.oneview.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class OrderReviewPage  extends BasePageClass {

	public OrderReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//label[@for='shieldTermsCheckbox']")
	WebElement chbShieldTerms;
	
	@FindBy(xpath = "//*[text()='Monthly Bill' or text()='Facture mensuelle']/ancestor::button")
	WebElement monthlyBill;
	
	@FindBy(xpath = "//*[text()='One-Time Fees and Credits' or text()='Frais et crédits uniques']/ancestor::button")
	WebElement oneTimeFees;
	
	@FindBy(xpath = "//span[text()='Submit' or text()='Soumettre']/ancestor::button")
	WebElement submitButton;
	
	@FindBy(xpath = "//span[text()='Campaign Codes' or text()='Codes de campagne']/ancestor::button")
	WebElement campaignCodes;
	
	@FindBy(xpath = "//span[contains(text(),'Enter campaign code') or contains(text(),' Entrez le code de campagne')]/ancestor::div[1]")
	WebElement campaignCodesContainer;
	
	@FindBy(xpath = "//span[contains(text(),'Enter campaign code') or contains(text(),' Entrez le code de campagne')]/ancestor::div[1]//input")
	WebElement campaignCodesInput;
	
	@FindBy(xpath = "//span[text()='Apply' or text()='Appliquer']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement apply;
	
	@FindBy(xpath = "//*[@translate='global.selfServe.reviewConfirm.totalMonthlyFees']/parent::div")
	WebElement totalMonthlyFees;
	
	@FindBy(xpath = "//label[@for='termsCheckbox']")
	WebElement chbTerms;
	
	@FindBy(xpath = "//label[@for='upfrontTermsCheckbox']")
	WebElement chbUpfrontTerms;
	
	@FindBy(xpath = "//input[@name='customerEmail']")
	WebElement txtCustomerEmail;
	
	@FindBy(xpath = "//label[@class='check-label']")
	List<WebElement> termsCheckBoxes;
	
	@FindAll({
		@FindBy(xpath = "//input[@id='cxEmail']/../label"),
		@FindBy(xpath = "//input[@id='digital-copy']/../label")})
	WebElement rdbtnEmail;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_step_pay']")
	WebElement lblPaymentStep;
	
	@FindBy(xpath = "//span[@checkout-res='checkout_continue_lbl']/parent::button")
	WebElement btnContinue;
	
	////span[@checkout-res='checkout_submit_order']/parent::button
	//button[@data-dtname='reviewOrder-submit']
	@FindBy(xpath = "//span[@checkout-res='checkout_submit_order']/parent::button")
	WebElement btnSubmitOrder;
	
	/**
	 * Expand Monthly Bill
	 * @author Harpartap.Virk
	 */	
	public void expandMonthlyBill() {
		reusableActions.clickWhenReady(monthlyBill,120);
	}
	/**
	 * Expand Monthly Bill
	 * @author Harpartap.Virk
	 */	
	public void expandOneTimeFees() {
		if(reusableActions.isElementVisible(oneTimeFees,120))
		reusableActions.javascriptScrollByVisibleElement(oneTimeFees);
		reusableActions.staticWait(5000);
		reusableActions.clickWhenReady(oneTimeFees,120);
	}
	/**
	 * Click Submit Button  
	 * @author Harpartap.Virk
	 */	
	public void clkSubmit() {	
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.staticWait(3000);
		reusableActions.clickWhenReady(submitButton);
		//reusableActions.staticWait(8000);
	}
	/**
	 * Verify Monthly Charges Appear
	 * @return true if Monthly Charges Appear, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyMonthlyCharges() {	
	if(reusableActions.isElementVisible(totalMonthlyFees,120)){
		WebElement btn=reusableActions.getWhenReady(totalMonthlyFees);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		return true;
	}else
		return false;
	
	}
	
	/**
	 * Clicks on all 'Terms and Agreement' checkbox
	 * @author Saurav.Goyal
	 */
	public void clkAllTermsAgreementCheckboxs() {
		reusableActions.waitForAllElementsVisible(termsCheckBoxes, 60);
		for(WebElement element:termsCheckBoxes) {
			reusableActions.waitForElementVisibility(element, 60);
			reusableActions.clickWhenReady(element,60);
		}
	}
	
	/**
	 * Clicks on the 'Terms and Agreement' checkbox
	 * @author rajesh.varalli1
	 */
	public void clkTermsAgreementCheckbox() {
		reusableActions.waitForElementVisibility(chbTerms, 100);
		reusableActions.clickWhenReady(chbTerms,100);
	}
	
	/**
	 * Clicks on the 'Email a Digital Copy' radio button
	 * @author rajesh.varalli1
	 * @param strEmail string email
	 */
	public void selectEmailDigitalCopy(String strEmail) {
		reusableActions.clickWhenVisible(rdbtnEmail,30);
		if(reusableActions.isElementVisible(txtCustomerEmail)) {
			txtCustomerEmail.sendKeys(strEmail);
		}
	}
	
	/**
	 * Determines if payment is required or not
	 * @return true if 'Payment' appears in the Steps above; else false
	 * @author rajesh.varalli1
	 */
	public boolean isPaymentRequired() {
		return reusableActions.isElementVisible(lblPaymentStep, 30);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue,60);
	}
	
	/**
	 * Clicks on the 'Submit Order' button
	 * @author rajesh.varalli1
	 */
	public void clkSubmitOrder() {
		reusableActions.clickWhenVisible(btnSubmitOrder,60);
	}
}

