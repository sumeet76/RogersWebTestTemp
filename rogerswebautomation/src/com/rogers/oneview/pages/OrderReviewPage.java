package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class OrderReviewPage  extends BasePageClass {

	public OrderReviewPage(WebDriver driver) {
		super(driver);
	}
	
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
}

