package com.rogers.oneview.pages;

import java.util.List;

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
public class RogersChoosePlanPage extends BasePageClass {

	public RogersChoosePlanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='No Tab' or text()='Flex']//ancestor::a")
	WebElement lnkNoTab;
	
	@FindBy(xpath = "//button[@class='btn btn-select']")
	List<WebElement> btnSelect;

	@FindBy(xpath = "//button[@class='btn btn-select']/ancestor::div[@class='plan-section']//span[@class='ng-binding']")
	List<WebElement> planSocCodes;
	
	@FindBy(xpath = "//div[contains(@class,'new-customer')]/a")
	WebElement lnkBuyOnline;
	
	@FindBy(xpath = "//md-select[@ng-model='model.filterByCategory']//span[@class='md-select-icon']")
	WebElement icnPlanCategory;
	
	@FindBy(xpath = "//md-select[@ng-model='model.filterByType']//span[@class='md-select-icon']")
	WebElement icnPlanType;
	
	@FindAll({
		@FindBy(xpath = "//span[@translate='mppc.summary.continue_button']/../parent::div[contains(@class,'summary-strip-section')]/button"),
		@FindBy(xpath = "//span[@translate='ppc_checkout_review_checkout']/../parent::div[contains(@class,'summary')]")
	})
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[@class='plan-socview']/span[@class='tabdata ng-scope']")
	WebElement lblCurrentPlanCategory;
	
	@FindBy(xpath = "//div[@class='existing-plan-header ng-scope']/following-sibling::div[@class='plan-listing']//div[@class='planview']//span[@class='price ng-binding']")
	WebElement lblCurrentPlanValue;
	
	@FindBy(xpath = "//h2[@translate='regular_plans_text']/..//span[@class='price ng-binding']")
	List<WebElement> lblNewPlanValue;
	
	@FindBy(xpath = "//a[@data-dtname='downgradeFeeAccept-continue']")
	WebElement btnDowngradeFeeContinue;

	@FindBy(xpath = "//a[@data-dtname='discountCancellationWarning-confirm']")
	WebElement btnDiscountCancellationWanringConfirm;


	
	@FindBy(xpath = "//span[@translate='_required']/ancestor::a")
	List<WebElement> lnkAdditionalLinesTabs;
	
	@FindBy(xpath = "//span[@translate='mppc.summary.continue_button']/../parent::div[contains(@class,'summary-strip-section')]/button")
	WebElement btnContinue;
	
	@FindBy(xpath = "//input[@value='createSharedGroup']//parent::label//span[@class='dsa-selection__caption text-center']")
	WebElement lblCreateSharedPlan;

	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnModalContinue;
	
	@FindBy(xpath = "//div[contains(@class,'ds-checkbox__box my-12')]")
	WebElement chkboxOnMultiLineSelect;
	
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnAddOnMultiLineSelect;

	@FindBy(xpath = "//div[@class='d-flex flex-column ds-border-xs-bottom p-xs-16']//div[@class='ds-radioButton__outerCircle my-12']")
	WebElement rdoSelectPrimaryLine;
	
	@FindBy(xpath = "//button[contains(@class,'-primary -large')]")
	WebElement btnContinuePrimaryLine;
	
	@FindBy(xpath = "//div[@class='current-plan']")
	WebElement lblChangesToExistingPlan;
	
	@FindBy(xpath = "//input[@value='todayDate']/ancestor::label//label")
	WebElement rdoSelectTodaysDate;
	
	@FindBy(xpath = "//li[contains(@class,'line-tab ng-scope')]")
	List<WebElement> linkLine;


	@FindBy(xpath = "//h2[@translate='current_plan_title']")
	WebElement lblYourCurrentPlan;

	/**
	 * Verify Choose Plan page
	 * @return true if the page is visible else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyChoosePlanPage() {
		return getReusableActionsInstance().isElementVisible(lblYourCurrentPlan,30);

	}
	
	/**
	 * Click on shared line 1
	 * @author Saurav.Goyal
	 */
	public void clkSharedLineOne() {
		getReusableActionsInstance().clickWhenReady(linkLine.get(0),30);
		
	}
	
	/**
	 * Click on shared line 2
	 * @author Saurav.Goyal
	 */
	public void clkSharedLineTwo() {
		getReusableActionsInstance().clickWhenReady(linkLine.get(1),30);
		
	}
	
	/**
	 * Clicks on label make Change to existing plan
	 * @author Saurav.Goyal
	 */
	public void clkMakeChangesToExistingPlan() {
		getReusableActionsInstance().clickIfAvailable(lblChangesToExistingPlan,30);
	}
	
	/**
	 * Clicks on radio button select a primary line for your new share plan 
	 * @author Saurav.Goyal
	 */
	public void clkRadioSelectPrimaryLine() {
		getReusableActionsInstance().clickWhenReady(rdoSelectPrimaryLine,60);
	}
	
	/**
	 * Clicks add on Share everything plan modal
	 * @author Saurav.Goyal
	 */
	public void clkContinueOnSelectPrimaryShareEveryThing() {
		getReusableActionsInstance().clickWhenReady(btnContinuePrimaryLine,60);
	}
	
	/**
	 * Clicks on check box to select a phone on multi line select modal window 
	 * @author Saurav.Goyal
	 */
	public void clkCheckBoxSelectAPhone() {
		getReusableActionsInstance().clickWhenReady(chkboxOnMultiLineSelect,60);
	}
	
	/**
	 * Clicks on label make Change to existing plan
	 * @author Saurav.Goyal
	 */
	public void clkCreateSharedPlanWithOtherLines() {
		getReusableActionsInstance().clickWhenReady(lblCreateSharedPlan,60);
	}
	
	/**
	 * Clicks add on Share everything plan modal
	 * @author Saurav.Goyal
	 */
	public void clkAddOnShareEveryThingModal() {
		getReusableActionsInstance().clickWhenReady(btnAddOnMultiLineSelect,60);
	}
	
	/**
	 * Clicks on continue button on the modal window
	 * @author Saurav.Goyal
	 */
	public void clkButtonModalContinue() {
		getReusableActionsInstance().clickIfAvailable(btnModalContinue,30);
	}
	
	/**
	 * Clicks on the 'No Tab' plan type
	 * @author rajesh.varalli1
	 */
	public void clkNoTab() {
		getReusableActionsInstance().clickWhenReady(lnkNoTab);
	}
	
	/**
	 * Clicks on the 'Get Plan' button on the first available plan tile
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePlan(String dataOptionIndex) {
		getReusableActionsInstance().scrollToElement(btnSelect.get(Integer.parseInt(dataOptionIndex)+1));
		if(planSocCodes.get(Integer.parseInt(dataOptionIndex)).getText().trim().startsWith("RPP")) {
			int updatedDataOptionIndex = Integer.parseInt(dataOptionIndex)-1;
			if(planSocCodes.get(updatedDataOptionIndex).getText().trim().startsWith("RPP")) {
				updatedDataOptionIndex = Integer.parseInt(dataOptionIndex)+1;
				getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnSelect.get(updatedDataOptionIndex), 30));
			}
			else {
				getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnSelect.get(updatedDataOptionIndex), 30));
			}
		}
		else {
			getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnSelect.get(Integer.parseInt(dataOptionIndex)), 30));
		}
	}
	
	/**
	 * Clicks on the 'Buy Online' link on the 'How To Get It' overlay
	 * @author rajesh.varalli1
	 */
	public void clkBuyOnline() {
		getReusableActionsInstance().clickWhenReady(lnkBuyOnline);
	}
	
	/**
	 * Selects the Price Plan Category filter
	 * @param strPlanCat Plan Tier name like Edge Fin, Edge 40, Edge 30, Edge 20, Talk and Text
	 * @author rajesh.varalli1
	 */
	public void selectPlanCategory(String strPlanCat) {
		switch (strPlanCat.trim().toUpperCase()) {
		case "EDGE FIN 24":
		case "EDGE FINANCING 24":
			strPlanCat = "edge financing 24mo";
			break;

		case "EDGE FIN 36":
		case "EDGE FINANCING 36":
			strPlanCat = "edge financing 36mo";
			break;

		case "EDGE 40":
		case "EDGE 40 TAB":
			strPlanCat = "edge 40 tab";
			break;

		case "EDGE 30":
		case "EDGE 30 TAB":
			strPlanCat = "edge 30 tab";
			break;

		case "EDGE 20":
		case "EDGE 20 TAB":
			strPlanCat = "edge 20 tab";
			break;
			
		case "FINANCING":
			strPlanCat = "financing";
			break;
			
		default:
			strPlanCat = "no tab";
			break;
		}
		getReusableActionsInstance().clickIfAvailable(By.xpath("//md-backdrop"),20);
		getReusableActionsInstance().waitForElementVisibility(icnPlanCategory , 30);
		getReusableActionsInstance().scrollToElement(icnPlanCategory);
		getReusableActionsInstance().clickWhenReady(icnPlanCategory, 60);
		getReusableActionsInstance().clickIfAvailable(By.xpath("//md-option[@value='" + strPlanCat +"']"));
		getReusableActionsInstance().staticWait(3000);
	}
	
	/**
	 * Selects the Plan Type filter
	 * @param strPlanType Plan Type like Rogers Infinite or Non-Shared
	 * @author rajesh.varalli1
	 */
	public void selectPlanType(String strPlanType) {
		if(strPlanType.toUpperCase().contains("INF")) {
			strPlanType = "share";
		} else {
			strPlanType = "nonshare";
		}
		getReusableActionsInstance().clickWhenReady(icnPlanType, 60);
		getReusableActionsInstance().clickWhenReady(By.xpath("//md-option[@value='"+ strPlanType +"']"));
		getReusableActionsInstance().staticWait(3000);
	}
	
	/**
	 * Clicks on the 'Checkout' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkCheckout() {
		getReusableActionsInstance().waitForElementTobeClickable(btnCheckout,60);
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(btnCheckout, 30);
		getReusableActionsInstance().clickIfAvailable(rdoSelectTodaysDate, 30);
		getReusableActionsInstance().clickIfAvailable(By.xpath("//div[@class='billingDateButtonClass inlineBlockClass']"));
	}
	
	/**
	 * Captures and returns the current plan monthly value
	 * @return plan value per month
	 * @author rajesh.varalli1
	 */
	public int getCurrentPlanValue() {
		return Integer.parseInt(lblCurrentPlanValue.getText());
	}
	
	/**
	 * Captures and returns the current plan tier name
	 * @return current plan tier name
	 * @author rajesh.varalli1
	 */
	public String getCurrentPlanCategory() {
		return lblCurrentPlanCategory.getAttribute("Translate");
	}

	/**
	 * Selects the next high tier price plan than the current price plan.
	 * If the current plan is in the highest tier, then a higher cost price plan in the same tier gets selected.
	 * @author rajesh.varalli1
	 */
	public void selectLowerPricePlan() {
		String strCurPlanCat = getCurrentPlanCategory().toUpperCase();
		int intCurPlanVal = getCurrentPlanValue();
		String strNewPlanCat = null;
		
		if(strCurPlanCat.contains("EDGEFIN")) {
			strNewPlanCat = "EDGE 40";
		} else if (strCurPlanCat.contains("EDGE40")) {
			strNewPlanCat = "EDGE 30";
		} else if (strCurPlanCat.contains("EDGE30")) {
			strNewPlanCat = "EDGE 20";
		} else {
			strNewPlanCat = "NO TAB";
		}
		
		selectPlanCategory(strNewPlanCat);
		
		for (int index = 0; index < lblNewPlanValue.size(); index++) {
			if(Integer.parseInt(lblNewPlanValue.get(index).getText()) < intCurPlanVal) {
				getReusableActionsInstance().executeJavaScriptClick(btnSelect.get(index));
				break;
			}
		}
	}
	
	/**
	 * Validates if the Downgrade Fee overlay is displayed and clicks on the 'Continue' button
	 * @return true if overlay is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAndClickDowngradeFeeContinue() {
		if(getReusableActionsInstance().isElementVisible(btnDowngradeFeeContinue, 20)) {
			getReusableActionsInstance().executeJavaScriptClick(btnDowngradeFeeContinue);
			return true;			
		} else if(getReusableActionsInstance().isElementVisible(btnDiscountCancellationWanringConfirm, 20)){
			getReusableActionsInstance().executeJavaScriptClick(btnDiscountCancellationWanringConfirm);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Handles the PPC for dependent additional lines by choosing the first price plan
	 * @author rajesh.varalli1
	 */
	public void handleAdditionalLinesPlanChange() {/*
		for (int index = 0; index < lnkAdditionalLinesTabs.size(); index++) {
			getReusableActionsInstance().clickWhenReady(lnkAdditionalLinesTabs.get(index));
			selectFirstAvailablePlan();
		}*/
	}
	
	/**
	 * Clicks on the 'Additional Line' CTN to choose a new plan
	 * @param strCTN Additional Line Subscriber number
	 * @author rajesh.varalli1
	 */
	public void selectAdditionalLine(String strCTN) {
		getReusableActionsInstance().getWhenReady(By.xpath("//span[@translate='_updated']"), 30);
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		getReusableActionsInstance().clickWhenReady(By.xpath("//span[text()='"+ strCTN +"']/ancestor::a"));
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenReady(btnContinue);
	}
	
}