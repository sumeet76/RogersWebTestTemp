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
	 * @author chinnarao.vattam
	 */
	public boolean verifyDailyBreakdownTable(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
		getReusableActionsInstance().javascriptScrollByVisibleElement(tblDailyBreakdown);
		return getReusableActionsInstance().isElementVisible(tblDailyBreakdown,120);
	}else
	{
		getReusableActionsInstance().scrollToElement(tblDailyBreakdown);
		return getReusableActionsInstance().isElementVisible(tblDailyBreakdown,120);
			}
	}

	/**
	 * Click on the Internet Monthly usage link
	 * @param   strBrowser is the browser to be run  
	 * @author chinnarao.vattam
	 */
	public void clkMonthlyUsage(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
			getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().getWhenReady(btnMonthlyUsage, 120).click();
			
		}else {
		getReusableActionsInstance().scrollToElement(btnMonthlyUsage);
		getReusableActionsInstance().clickWhenReady(btnMonthlyUsage,120);
	}
	}
	/**
	 * Verify the Internet Monthly Breakdown table Internet usage page
	 * @param   strBrowser is the browser to be run 
	 * @return true if element is visible, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyMonthlyBreakdownTable(String strBrowser) {	
		if (strBrowser.equalsIgnoreCase("firefox"))
		{
		getReusableActionsInstance().javascriptScrollByVisibleElement(tblMonthlyBreakdown);
		return getReusableActionsInstance().isElementVisible(tblMonthlyBreakdown,120);
	}else {
		getReusableActionsInstance().scrollToElement(tblMonthlyBreakdown);
		return getReusableActionsInstance().isElementVisible(tblMonthlyBreakdown,120);
		}
	}

	/**
	 * Click on the Usage Alerts link on Solaris Internet usage page
	 * @param   strBrowser is the browser to be run 
	 * @author chinnarao.vattam
	 */
	public void clkUsageAlerts(String strBrowser) {		
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().getWhenReady(btnUsageAlerts,120).click();
	}

}
