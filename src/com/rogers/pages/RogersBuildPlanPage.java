package com.rogers.pages;

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
public class RogersBuildPlanPage extends BasePageClass {

	public RogersBuildPlanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@res='_add']")
	List<WebElement> btnAdd;

	@FindAll({
		@FindBy(xpath = "//span[@class='col-sm-6 pull-right btn button-continue ng-scope']"),
		@FindBy(xpath = "//p[@res='_continue']") //first xpath in HUP second in AAL
	})
	WebElement btnContinue;

	@FindBy(xpath = "//span[contains(@class,'ui-slider-handle')]")
	WebElement planSlider;

	@FindBy(xpath = "//div[@res='Category-EDGEFIN3TAB']")
	WebElement lblEdge40;

	@FindBy(xpath = "//span[contains(@translate-values, 'month:') and contains(@translate-values, '24')]")
	WebElement lblfin;

	@FindBy(xpath = "//span[@translate='Okay']/parent::button")
	WebElement btnOkay;

	@FindBy(xpath = "//button[@res='_remove']")
	WebElement btnRemove;

	@FindBy(xpath = "//span[@res='get_this_offer']/parent::button")
	WebElement btnGetThisOffer;

	@FindBy(xpath = "//span[@translate='see.add_line']")
	WebElement lnkAddALine;

	@FindBy(xpath = "//span[@res='_continue']/parent::button")
	WebElement btnOverlayContinue;

	@FindBy(xpath = "//p[@res='_select']")
	WebElement btnSelect;

	@FindBy(xpath = "//div[contains(@class,'current-balance-container')]//span[contains(@data-ng-bind-html,'planMSFValue')]/span")
	WebElement lblCurrentPlanValue;

	@FindBy(xpath = "//div[contains(@class,'current-balance-container')]//div[@class='balance-view balance-today']")
	WebElement lblCurrentPlanName;

	@FindBy(xpath = "//button[@res='_add']/../..//span[@class='priceValue']")
	List<WebElement> lblPlanValue;

	@FindBy(xpath = "//a[@res='keep-existing']")
	WebElement lnkKeepExisting;

	@FindBy(xpath = "//span[@res='select_existing_plan']/parent::button")
	WebElement btnSelectExistingPlan;
	
	@FindBy(xpath = "//div[@res='you-selected']")
	WebElement lblYouSelected;

	@FindBy(xpath = "//div[@id='ds-radio-input-id-10-label-container']")
	WebElement payfordeviceinfull;
	

	/**
	 * To verify the Rogers build plan Page load
	 * @author Saurav.Goyal
	 */
	public void verifyBildPlanPageLoadedSuccessfully() {
		getReusableActionsInstance().waitForElementVisibility(lblYouSelected, 60);
	}
	
	/**
	 * Clicks on the 'Add' button against the first available price plan
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePlan() {
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().waitForElementVisibility(btnAdd.get(0), 60);
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnAdd.get(0)));
		getReusableActionsInstance().staticWait(2000);
	}

	/**
	 * Handles the Today's Offer overlay by clicking on 'Get this offer' button and 
	 * clicking on 'Continue to Addons' button after.
	 * @return true if no overlay is displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean handleTodayOfferOverlay() {
		if(getReusableActionsInstance().isElementVisible(btnGetThisOffer, 3)) {
			getReusableActionsInstance().clickWhenReady(btnGetThisOffer);
			getReusableActionsInstance().clickWhenVisible(By.xpath("//span[@res='continue_to_addons']/parent::button"), 10);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Clicks on the 'Continue' button at the bottom of the page
	 * @author rajesh.varalli1
	 */
	public void clkContinue() {
		if(handleTodayOfferOverlay()) {
			getReusableActionsInstance().clickWhenReady(btnContinue,60);
		}

		if(getReusableActionsInstance().isElementVisible(By.xpath("//span[@res='_upfront_amount']"),2)) {
			getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//a[@translate='new_Confirm']")));
			//getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//div[@class='upfront-popup-button']/a[@translate='new_Confirm']")));
		}

		if(getReusableActionsInstance().isElementVisible(planSlider, 2)) {
			getReusableActionsInstance().waitForElementVisibility(planSlider, 60);
			//getReusableActionsInstance().clickIfAvailable(btnContinue, 120);
		}
		if(getReusableActionsInstance().isElementVisible(planSlider, 2)) {
			getReusableActionsInstance().waitForElementVisibility(planSlider, 60);
			//getReusableActionsInstance().clickIfAvailable(btnContinue, 120);
		}
	}

	/**
	 * Selects the plan type category by moving the Slider bar
	 * @param planCat Type of the plan
	 * @author rajesh.varalli1
	 */
	public void selectPlanCategory(String planCat) {
		String strTermMonths = null;

		switch (planCat.trim().toUpperCase()) {
		case "EDGE FIN 24":
		case "EDGE FINANCING 24":
			planCat = "EDGEFIN3TAB' or @res='Category-EDGEFIN2TAB";
			strTermMonths = "24";
			break;

		case "EDGE FIN 36":
		case "EDGE FINANCING 36":
			planCat = "EDGEFIN3TAB' or @res='Category-EDGEFIN2TAB";
			strTermMonths = "36";
			break;

		case "EDGE 40":
		case "EDGE 40 TAB":
			planCat = "EDGE40TAB";
			break;

		case "EDGE 30":
		case "EDGE 30 TAB":
			planCat = "EDGE30TAB";
			break;

		case "EDGE 20":
		case "EDGE 20 TAB":
			planCat = "EDGE20TAB";
			break;

		case "TALK TEXT":
		case "TALK AND TEXT":
			planCat = "TALKANDTEXT";
			break;

		default:
			planCat = "";
			break;
		}

		getReusableActionsInstance().dragAndDrop(planSlider, getReusableActionsInstance().getWhenReady(By.xpath("//div[@res='Category-" + planCat + "']"),60));
		getReusableActionsInstance().dragAndDrop(planSlider, getReusableActionsInstance().getWhenReady(By.xpath("//div[@res='Category-" + planCat + "']")));
		if(planCat.contains("FIN")) {
			getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(@translate-values, 'month:') and contains(@translate-values, '" + strTermMonths.trim() + "')]")));
		}
	}

	/**
	 * Selects the Edge Financing plan type and sets the term of the plan
	 * @param strTermMonths Term for the Financing plan in months like 24, 36
	 * @author rajesh.varalli1
	 */
	public void selectEdgeFinancing(String strTermMonths) {
		selectPlanCategory("EDGE FIN");
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(@translate-values, 'month:') and contains(@translate-values, '" + strTermMonths.trim() + "')]")));
	}

	/**
	 * Clicks on the 'Okay' button in the calling options overlay
	 * @author rajesh.varalli1
	 */
	public void clkCallingOptionsOkay() {
		getReusableActionsInstance().waitForElementVisibility(btnOkay, 100);
		getReusableActionsInstance().clickWhenReady(btnOkay);
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * Clicks on the 'Add a line' link
	 * @author rajesh.varalli1
	 */
	public void clkAddALine() {
		getReusableActionsInstance().clickWhenReady(lnkAddALine);
	}

	/**
	 * Clicks on the 'Continue' button on the overlay
	 * @author rajesh.varalli1
	 */
	public void clkOverlayContinue() {
		getReusableActionsInstance().clickWhenReady(btnOverlayContinue);
	}

	/**
	 * Clicks on the 'Select' button in the Add a line section
	 * @author rajesh.varalli1
	 */
	public void clkSelect() {
		getReusableActionsInstance().executeJavaScriptClick(btnSelect);
	}

	/**
	 * Captures and returns the current plan monthly value
	 * @return plan value per month
	 * @author rajesh.varalli1
	 */
	public double getCurrentPlanValue() {
		return Double.parseDouble(lblCurrentPlanValue.getText().replace("/mo", "").replace("$", "").trim());
	}

	/**
	 * Captures and returns the current plan tier name
	 * @return current plan tier name
	 * @author rajesh.varalli1
	 */
	public String getCurrentPlanCategory() {
		return lblCurrentPlanName.getText();
	}

	/**
	 * Selects the next low tier price plan than the current price plan.
	 * If the current plan is in the lowest tier, then a lower cost price plan in the same tier gets selected.
	 * @author rajesh.varalli1
	 */
	public void selectLowerPricePlan() {
		getReusableActionsInstance().getWhenReady(By.xpath("//button[@res='_add']"), 40);
		String newPlan = null;
		String strCurPln = getCurrentPlanCategory().toUpperCase();
		double dblCurPlnVal = getCurrentPlanValue();

		if(strCurPln.contains("EDGE FIN")) {
			newPlan = "EDGE 40";
		} else if (strCurPln.contains("EDGE 40")) {
			newPlan = "EDGE 30";
		} else if (strCurPln.contains("EDGE 30")) {
			newPlan = "EDGE 20";
		} else {
			newPlan = "TALK AND TEXT";
		}

		selectPlanCategory(newPlan);

		for (int index=0; index<lblPlanValue.size(); index++) {
			if(Double.parseDouble(getReusableActionsInstance().getWhenReady(lblPlanValue.get(index),30).getText().replace("$", "").trim()) < dblCurPlnVal) {
				getReusableActionsInstance().executeJavaScriptClick(btnAdd.get(index));
				break;
			}
		}
	}

	/**
	 * Selects the next high tier price plan than the current price plan.
	 * If the current plan is in the highest tier, then a higher cost price plan in the same tier gets selected.
	 * @author rajesh.varalli1
	 */
	public void selectHigherPricePlan() {
		getReusableActionsInstance().getWhenReady(By.xpath("//button[@res='_add']"), 40);
		String newPlan = null;
		String strCurPln = getCurrentPlanCategory().toUpperCase();
		double dblCurPlnVal = getCurrentPlanValue();

		if(strCurPln.contains("TALK AND TEXT")) {
			newPlan = "EDGE 20";
		} else if (strCurPln.contains("EDGE 20")) {
			newPlan = "EDGE 30";
		} else if (strCurPln.contains("EDGE 30")) {
			newPlan = "EDGE 40";
		} else {
			newPlan = "EDGE FIN";
		}

		selectPlanCategory(newPlan);

		for (int index=0; index<lblPlanValue.size(); index++) {
			if(Double.parseDouble(getReusableActionsInstance().getWhenReady(lblPlanValue.get(index),30).getText().replace("$", "").trim()) > dblCurPlnVal) {
				getReusableActionsInstance().executeJavaScriptClick(btnAdd.get(index));
				break;
			}
		}
	}

	/**
	 * Selects the Existing Plan
	 * @author rajesh.varalli1
	 */
	public void selectExistingPlan() {
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(lnkKeepExisting, 60));
		getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(btnSelectExistingPlan, 60));
	}

	/**
	 * This method clicks pay for device in full option
	 * @auther: Nitin.Arora
	 */
	public void clickPayforDeviceinFull() {
		getReusableActionsInstance().scrollToElement(payfordeviceinfull);
		getReusableActionsInstance().clickWhenReady(payfordeviceinfull,20);
	}
}