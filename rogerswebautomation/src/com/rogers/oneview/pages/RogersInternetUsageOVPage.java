package com.rogers.oneview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class RogersInternetUsageOVPage extends BasePageClass {

	public RogersInternetUsageOVPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table[@class='usage-table']")
	WebElement tblDailyBreakdown;
	
	@FindBy(xpath = "//button[@translate='global.dashboard.internetUsage.monthlyUsage']")
	WebElement btnMonthlyUsage;

	@FindBy(xpath = "//table[@class='usage-table ng-star-inserted']")
	WebElement tblMonthlyBreakdown;

	@FindBy(xpath = "//button[@translate='global.dashboard.internetUsage.usageAlerts']")
	WebElement btnUsageAlerts;


	/**
	 * Verify the Internet Daily Breakdown table on daily usage page
	 * @param   strBrowser is the browser to be run 
	 * @return true if element is visible, else false
	 * @author Drashti.Patel
	 */
	public boolean verifyDailyBreakdownTable(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
		reusableActions.javascriptScrollByVisibleElement(tblDailyBreakdown);
		return reusableActions.isElementVisible(tblDailyBreakdown,120);
	}else
	{
		reusableActions.scrollToElement(tblDailyBreakdown);
		return reusableActions.isElementVisible(tblDailyBreakdown,120);
		
	}
	}

	/**
	 * Click on the Internet Monthly usage link
	 * @param   strBrowser is the browser to be run  
	 * @author Drashti.Patel
	 */
	public void clkMonthlyUsage(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
			reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(btnMonthlyUsage, 120).click();
			
		}else {
		reusableActions.scrollToElement(btnMonthlyUsage);
		reusableActions.clickWhenReady(btnMonthlyUsage,120);

	}
	}
	/**
	 * Verify the Internet Monthly Breakdown table Internet usage page
	 * @param   strBrowser is the browser to be run 
	 * @return true if element is visible, else false
	 * @author Drashti.Patel
	 */
	public boolean verifyMonthlyBreakdownTable(String strBrowser) {	
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
		reusableActions.javascriptScrollByVisibleElement(tblMonthlyBreakdown);
		return reusableActions.isElementVisible(tblMonthlyBreakdown,120);
	}else {
		reusableActions.scrollToElement(tblMonthlyBreakdown);
		return reusableActions.isElementVisible(tblMonthlyBreakdown,120);
		}
	}

	
	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @param   strBrowser is the browser to be run 
	 * @author Drashti.Patel
	 */
	public void clkUsageAlerts(String strBrowser) {		
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.getWhenReady(btnUsageAlerts,120).click();
	}

}
