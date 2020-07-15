package com.rogers.oneview.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath = "//span[@translate='_select']/parent::button")
	List<WebElement> btnSelect;
	
	@FindBy(xpath = "//div[contains(@class,'new-customer')]/a")
	WebElement lnkBuyOnline;
	
	@FindBy(xpath = "//md-select[@ng-model='model.filterByCategory']//span[@class='md-select-icon']")
	WebElement icnPlanCategory;
	
	@FindBy(xpath = "//md-select[@ng-model='model.filterByType']//span[@class='md-select-icon']")
	WebElement icnPlanType;
	
	@FindBy(xpath = "//span[contains(@translate,'ppc')]/parent::button/parent::div[contains(@class,'summary')]")
	WebElement btnCheckout;
	
	@FindBy(xpath = "//div[@class='plan-socview']/span[@class='tabdata ng-scope']")
	WebElement lblCurrentPlanCategory;
	
	@FindBy(xpath = "//div[@class='existing-plan-header ng-scope']/following-sibling::div[@class='plan-listing']//div[@class='planview']//span[@class='price ng-binding']")
	WebElement lblCurrentPlanValue;
	
	@FindBy(xpath = "//h2[@translate='regular_plans_text']/..//span[@class='price ng-binding']")
	List<WebElement> lblNewPlanValue;
	
	@FindBy(xpath = "//a[@data-dtname='downgradeFeeAccept-continue']")
	WebElement btnDowngradeFeeContinue;
	
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
	
	
	/**
	 * Click on shared line 1
	 * @author Saurav.Goyal
	 */
	public void clkSharedLineOne() {
		reusableActions.clickWhenReady(linkLine.get(0),30);
		
	}
	
	/**
	 * Click on shared line 2
	 * @author Saurav.Goyal
	 */
	public void clkSharedLineTwo() {
		reusableActions.clickWhenReady(linkLine.get(1),30);
		
	}
	
	/**
	 * Clicks on label make Change to existing plan
	 * @author Saurav.Goyal
	 */
	public void clkMakeChangesToExistingPlan() {
		reusableActions.clickWhenReady(lblChangesToExistingPlan,60);
	}
	
	/**
	 * Clicks on radio button select a primary line for your new share plan 
	 * @author Saurav.Goyal
	 */
	public void clkRadioSelectPrimaryLine() {
		reusableActions.clickWhenReady(rdoSelectPrimaryLine,60);
	}
	
	/**
	 * Clicks add on Share everything plan modal
	 * @author Saurav.Goyal
	 */
	public void clkContinueOnSelectPrimaryShareEveryThing() {
		reusableActions.clickWhenReady(btnContinuePrimaryLine,60);
	}
	
	/**
	 * Clicks on check box to select a phone on multi line select modal window 
	 * @author Saurav.Goyal
	 */
	public void clkCheckBoxSelectAPhone() {
		reusableActions.clickWhenReady(chkboxOnMultiLineSelect,60);
	}
	
	/**
	 * Clicks on label make Change to existing plan
	 * @author Saurav.Goyal
	 */
	public void clkCreateSharedPlanWithOtherLines() {
		reusableActions.clickWhenReady(lblCreateSharedPlan,60);
	}
	
	/**
	 * Clicks add on Share everything plan modal
	 * @author Saurav.Goyal
	 */
	public void clkAddOnShareEveryThingModal() {
		reusableActions.clickWhenReady(btnAddOnMultiLineSelect,60);
	}
	
	/**
	 * Clicks on continue button on the modal window
	 * @author Saurav.Goyal
	 */
	public void clkButtonModalContinue() {
		reusableActions.clickWhenReady(btnModalContinue,60);
	}
	
	/**
	 * Clicks on the 'No Tab' plan type
	 * @author rajesh.varalli1
	 */
	public void clkNoTab() {
		reusableActions.clickWhenReady(lnkNoTab);
	}
	
	/**
	 * Clicks on the 'Get Plan' button on the first available plan tile
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePlan() {
		reusableActions.executeJavaScriptClick(reusableActions.getWhenReady(btnSelect.get(0), 30));
		reusableActions.staticWait(3000);
	}
	
	/**
	 * Clicks on the 'Buy Online' link on the 'How To Get It' overlay
	 * @author rajesh.varalli1
	 */
	public void clkBuyOnline() {
		reusableActions.clickWhenReady(lnkBuyOnline);
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
		reusableActions.clickWhenReady(icnPlanCategory, 60);		
		reusableActions.clickWhenReady(By.xpath("//md-option[@value='" + strPlanCat +"']"));
		reusableActions.staticWait(3000);
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
		reusableActions.clickWhenReady(icnPlanType, 60);
		reusableActions.clickWhenReady(By.xpath("//md-option[@value='"+ strPlanType +"']"));
		reusableActions.staticWait(3000);
	}
	
	/**
	 * Clicks on the 'Checkout' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkCheckout() {
		reusableActions.clickWhenReady(btnCheckout, 40);
		reusableActions.clickIfAvailable(rdoSelectTodaysDate, 40);
		reusableActions.clickIfAvailable(By.xpath("//div[@class='billingDateButtonClass inlineBlockClass']"));
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
				reusableActions.executeJavaScriptClick(btnSelect.get(index));
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
		if(reusableActions.isElementVisible(btnDowngradeFeeContinue, 90)) {
			reusableActions.executeJavaScriptClick(btnDowngradeFeeContinue);
			return true;			
		} else {
			return false;
		}
	}
	
	/**
	 * Handles the PPC for dependent additional lines by choosing the first price plan
	 * @author rajesh.varalli1
	 */
	public void handleAdditionalLinesPlanChange() {
		for (int index = 0; index < lnkAdditionalLinesTabs.size(); index++) {
			reusableActions.clickWhenReady(lnkAdditionalLinesTabs.get(index));
			selectFirstAvailablePlan();
		}
	}
	
	/**
	 * Clicks on the 'Additional Line' CTN to choose a new plan
	 * @param strCTN Additional Line Subscriber number
	 * @author rajesh.varalli1
	 */
	public void selectAdditionalLine(String strCTN) {
		reusableActions.getWhenReady(By.xpath("//span[@translate='_updated']"), 30);
		strCTN = strCTN.replace("-", "").replace(" ", "");
		strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		reusableActions.clickWhenReady(By.xpath("//span[text()='"+ strCTN +"']/ancestor::a"));
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue);
	}
	
}