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
		
	@FindBy(xpath = "//h2[@id='internetUsage-monthly-tab']")
	WebElement lnkMonthlyUsage;

	@FindBy(xpath = "//x-chartist[@class='monthlyUsage']")
	WebElement infoMonthlyBreakdown;
	
	@FindBy(xpath = "//table[@class='usage-table__table ng-star-inserted']")
	WebElement tblMonthlyBreakdown;
	
	@FindBy(xpath = "//table[@class='table  table-centred table-no-filter ng-table']")
	WebElement tblMonthlyBreakdownMobile;

	@FindBy(xpath = "//h2[@id='internetUsage-alerts-tab']")
	WebElement btnUsageAlerts;

	@FindBy(xpath = "//div[@class='internet-usage-alerts-component']")
	WebElement infoUsageAlerts;
	

	/**
	 * Verify the Internet Daily Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdown() {		
		return reusableActions.isElementVisible(infoDailyBreakdown,20);
	}

	/**
	 * Verify the Internet Daily Breakdown table on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdownTable() {		
		return reusableActions.isElementVisible(tblDailyBreakdown,20);
	}

	/**
	 * Verify the Internet Daily Breakdown table on solaris Internet usage page
	 * @return true if the Internet Daily Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyDailyBreakdownTableMobile() {		
		return reusableActions.isElementVisible(tblDailyBreakdownMobile,20);
	}
	
	/**
	 * Click on the Internet Monthly usage link on solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkMonthlyUsage() {		
		reusableActions.clickWhenReady(lnkMonthlyUsage,20);

	}

	/**
	 * Verify the Internet Monthly Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdown() {		 
		return reusableActions.isElementVisible(infoMonthlyBreakdown);
	}
	

	/**
	 * Verify the Internet Monthly Breakdown table on Solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown content displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdownTable() {		
		return reusableActions.isElementVisible(tblMonthlyBreakdown,40);
	}
	
	
	/**
	 * Verify the Internet Monthly Breakdown table heading text on solaris Internet usage page
	 * @return true if the Internet Monthly Breakdown table heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean verifyMonthlyBreakdownTableMobile() {		 
		return reusableActions.isElementVisible(tblMonthlyBreakdownMobile);
	}
	
	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @author Chinnarao.Vattam
	 */
	public void clkUsageAlerts() {		
		reusableActions.clickWhenReady(btnUsageAlerts,20);
	}

	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @return true if the Internet Usage Alerts heading displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean  verifyUsageAlerts() {		
		return reusableActions.isElementVisible(infoUsageAlerts,20);
	}
}
