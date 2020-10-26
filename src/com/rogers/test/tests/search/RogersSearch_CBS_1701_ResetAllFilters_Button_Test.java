package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1701_ResetAllFilters_Button_Test extends BaseTestClass {

	@Test
	public void validateParentFilterDeselection() {

		List<String> strStorageOptions;
		List<String> strColorOptions;

		getDriver().get(System.getProperty("SearchUrl")+"wireless");

		rogers_search_page.clkGrandParentFilter("Support");
		reporter.hardAssert(rogers_search_page.isGrandParentFilterExpanded("Support"),
				"Support filter expanded","Support filter expanded");
		rogers_search_page.clkParentFilter("Support","Billing/Accounts");
		reporter.hardAssert(rogers_search_page.isParentFilterExpanded("Support","Billing/Accounts"),
				"Billing/Accounts filter expanded","Billing/Accounts filter expanded");
		reporter.hardAssert(rogers_search_page.validateResultsTag("Support","Billing/Accounts")
				,"Results' tags verified", "Results' tags mismatch");
		reporter.reportLogWithScreenshot("Shop-Billing/Accounts Expanded");
		rogers_search_page.clkResetAllFilters();
		reporter.reportLogWithScreenshot("Reset All Filters button clicked");
		reporter.hardAssert(rogers_search_page.validateAllFiltersCollapsed(),
				"All Filters are Reset","Filters Not Reset");
		reporter.hardAssert(rogers_search_page.validateResultsTag("Support"),
				"All Results Refreshed","Results Not Refreshed");

		rogers_search_page.clkGrandParentFilter("Shop");
		reporter.hardAssert(rogers_search_page.isGrandParentFilterExpanded("Shop"),
				"Shop filter expanded","Shop filter expanded");
		rogers_search_page.clkParentFilter("Shop","Wireless");
		reporter.hardAssert(rogers_search_page.isParentFilterExpanded("Shop","Wireless"),
				"Wireless filter expanded","Wireless filter expanded");
		rogers_search_page.clkDeviceType("Smartphone");
		rogers_search_page.clkBrandType("Apple");
		strStorageOptions = rogers_search_page.getStorageSelections();
		rogers_search_page.clkStorageType(strStorageOptions.get(0));
		strColorOptions = rogers_search_page.getColorSelections();
		rogers_search_page.clkColorType(strColorOptions.get(0));
		reporter.reportLogWithScreenshot("Device:Smartphone; Brand:Apple; Storage:" + strStorageOptions.get(0)
				+"; Color:" + strColorOptions.get(0) + " is Selected");
		rogers_search_page.clkResetAllFilters();
		reporter.reportLogWithScreenshot("Reset All Filters button clicked");
		reporter.hardAssert(rogers_search_page.validateAllFiltersCollapsed(),
				"All Filters are Reset","Filters Not Reset");
		reporter.hardAssert(rogers_search_page.validateResultsTag("Support"),
				"All Results Refreshed","Results Not Refreshed");
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SearchUrl") + "wireless", strBrowser, strLanguage, RogersEnums.GroupName.search, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}