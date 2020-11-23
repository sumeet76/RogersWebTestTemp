package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChangePlanPage extends BasePageClass {

	public RogersChangePlanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='plan-heading']/h1[@translate='ppc_headline_choose_new_plan']")
	WebElement lblChooseNewPlan;
	
	@FindBy(xpath = "//md-select[@ng-model='model.filterByType']//span[@class='md-select-icon']")
	WebElement lstPlanType;
	
	@FindBy(xpath = "//md-option[@value='share']")
	WebElement lblRogersInfinite;
	
	@FindBy(xpath = "//md-option[@value='nonshare']")
	WebElement lblNonShared;
	
	@FindBy(xpath = "//plan-listing[@plan-model = 'availablePlan.plan']//button[@class='btn btn-select']")
	List<WebElement> btnSelectPlan;
	
	@FindBy(xpath = "//span[@translate='_view_plans']")
	WebElement lnkViewAllPlans;
	
	@FindBy(xpath = "//div[contains(@class,'summary-strip-section')]/div[@role='button']/span[@translate='ppc_checkout_review_checkout']")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[contains(@class,'existing-addons-title')]/h4[contains(@translate,'shop_add_ons')]")
	WebElement lblYourExistingAddons;
	
	@FindBy(xpath = "//div[@class='dropped-addons-footer']/button[@translate='_continue']")
	WebElement btnContinueDropAddons;
	
	@FindBy(xpath = "//span[@translate='_selected']/ancestor::div[@class='plan-listing']//span[contains(@class,'price')]")
	WebElement lblSelectedPlanPriceWhole;
	
	@FindBy(xpath = "//span[@translate='_selected']/ancestor::div[@class='plan-listing']//span[contains(@class,'supDecimalAndRange')]")
	WebElement lblSelectedPlanPriceDecimal;
	
	@FindBy(xpath = "//div[@class='line-details']")
	List<WebElement> lblLineDetails;
	
	@FindBy(xpath = "//button[@translate='mppc.entry.edit' and @aria-hidden='false']")
	List<WebElement> btnEdit;
	
	@FindBy(xpath = "//a[@translate='main_line_plan_migration_continue']")
	WebElement btnChangeMainLine;
	
	/**
	 * Validates whether Change plan page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangePlanPageLoad() {
		return getReusableActionsInstance().isElementVisible(lblChooseNewPlan);
	}
	
	/**
	 * Selects the type of plan filter
	 * @param planType 'Rogers Infinite' or 'Non-Shared'
	 * @author rajesh.varalli1
	 */
	public void selectPlanType(String planType) {
		getReusableActionsInstance().clickWhenVisible(lstPlanType);
		if(planType.toUpperCase().contains("INFINITE")) {
			getReusableActionsInstance().clickWhenVisible(lblRogersInfinite);
		} else {
			getReusableActionsInstance().clickWhenVisible(lblNonShared);
		}
	}
	
	/**
	 * Selects the First Regular plan from the table of Available plans
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePlan() {
		getReusableActionsInstance().clickWhenVisible(btnSelectPlan.get(0));
	}
	
	/**
	 * Clicks on the 'View All Plans' link
	 * @author rajesh.varalli1
	 */
	public void clickViewAllPlans() {
		getReusableActionsInstance().clickWhenVisible(lnkViewAllPlans);
	}
	
	/**
	 * Clicks on the 'Checkout' button
	 * @author rajesh.varalli1
	 */
	public void clickCheckout() {
		getReusableActionsInstance().clickWhenVisible(btnCheckout);
	}
	
	/**
	 * Validates if the Plan Add-ons' section is displayed
	 * @return true if displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAddonSectionVisible() {
		return getReusableActionsInstance().isElementVisible(lblYourExistingAddons, 30);
	}
	
	/**
	 * Returns the Amount of the Price Plan selected
	 * @return Amount in Decimal format
	 * @author rajesh.varalli1
	 */
	public float getSelectedPlanPrice() {
		return Float.parseFloat(lblSelectedPlanPriceWhole.getText() + lblSelectedPlanPriceDecimal.getText());
	}
	
	/**
	 * Clicks on the 'Edit' button against the respective Line
	 * @param strCTN Subscriber Number which needs to be Edited
	 * @author rajesh.varalli1
	 */
	public void clkEdit(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + " " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		
		getReusableActionsInstance().staticWait(5000);
		
		for (int index = 0; index < lblLineDetails.size(); index++) {
			if(lblLineDetails.get(index).getText().contains(strCTN)) {
				getReusableActionsInstance().clickWhenReady(btnEdit.get(index));
				break;
			}
		}
	}
	
	/**
	 * Clicks on the 'Change main line' button on the overlay
	 * @author rajesh.varalli1
	 */
	public void clkChangeMainLine() {
		getReusableActionsInstance().clickWhenVisible(btnChangeMainLine);
	}
	
}