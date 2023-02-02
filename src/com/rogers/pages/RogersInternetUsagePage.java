package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class RogersInternetUsagePage extends BasePageClass {

	public RogersInternetUsagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//x-chartist[@class='daily-usage-chart']")
	WebElement infoDailyBreakdown;

	@FindBy(xpath = "//table[@class='usage-table__table ng-star-inserted']")
	WebElement tblDailyBreakdown;

	@FindBy(xpath = "//table[@class='table  table-centred ng-table']")
	WebElement tblDailyBreakdownMobile;
		
	@FindBy(xpath = "//button[@id='internetUsage-monthly-tab']")
	WebElement lnkMonthlyUsage;

	@FindBy(xpath = "//x-chartist[@class='monthlyUsage']")
	WebElement infoMonthlyBreakdown;
	
	@FindBy(xpath = "//table[@class='usage-table__table ng-star-inserted']")
	WebElement tblMonthlyBreakdown;
	
	@FindBy(xpath = "//table[@class='table  table-centred table-no-filter ng-table']")
	WebElement tblMonthlyBreakdownMobile;

	@FindBy(xpath = "//button[@id='internetUsage-alerts-tab']")
	WebElement btnUsageAlerts;

	@FindBy(xpath = "//div[@class='rch-tabs__dropdown']/select")
	WebElement selUsageMobile;
	
	@FindBy(xpath = "//div[@class='internet-usage-alerts-component']")
	WebElement infoUsageAlerts;
	

	/**
	 * Verify the Internet Daily Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdown() {		
		return getReusableActionsInstance().isElementVisible(infoDailyBreakdown,20);
	}

	/**
	 * Verify the Internet Daily Breakdown table on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdownTable() {		
		return getReusableActionsInstance().isElementVisible(tblDailyBreakdown,20);
	}

	/**
	 * Verify the Internet Daily Breakdown table on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdownTableMobile() {		
		return getReusableActionsInstance().isElementVisible(tblDailyBreakdownMobile,20);
	}
	
	/**
	 * Click on the Internet Monthly usage link on solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkMonthlyUsage() {		
		getReusableActionsInstance().clickWhenReady(lnkMonthlyUsage,20);

	}

	/**
	 * Click on the Internet Monthly usage link on solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkMonthlyUsageMobile() {	
		getReusableActionsInstance().waitForElementVisibility(selUsageMobile,20);
		getReusableActionsInstance().selectWhenReadyByVisibleText(selUsageMobile, "Monthly Usage");
	}
	
	/**
	 * Click on the Internet Monthly usage link on solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkUsageAlertsMobile() {	
		getReusableActionsInstance().waitForElementVisibility(selUsageMobile,20);
		getReusableActionsInstance().selectWhenReadyByVisibleText(selUsageMobile, "Usage Alerts");
	}
	
	/**
	 * Verify the Internet Monthly Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdown() {		 
		return getReusableActionsInstance().isElementVisible(infoMonthlyBreakdown);
	}
	

	/**
	 * Verify the Internet Monthly Breakdown table on Solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdownTable() {		
		return getReusableActionsInstance().isElementVisible(tblMonthlyBreakdown,40);
	}
	
	
	/**
	 * Verify the Internet Monthly Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdownTableMobile() {		 
		return getReusableActionsInstance().isElementVisible(tblMonthlyBreakdownMobile);
	}
	
	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkUsageAlerts() {		
		getReusableActionsInstance().clickWhenReady(btnUsageAlerts,20);
	}

	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @return true if the Internet Usage Alerts heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean  verifyUsageAlerts() {		
		return getReusableActionsInstance().isElementVisible(infoUsageAlerts,20);
	}
}
