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

	@Test(groups={"Search","Filter"})
	public void validateParentFilterDeselection() {

		List<String> strStorageOptions;
		List<String> strColorOptions;
		getDriver().get(System.getProperty("SearchUrl")+"wireless");
		getRogersSearchPage().isPageLoaded();
		getRogersSearchPage().waitTime();
		String resultBeforeReset = getRogersSearchPage().numberOfResults();
		getRogersSearchPage().clkGrandParentFilter("Support");
		reporter.hardAssert(getRogersSearchPage().isGrandParentFilterExpanded("Support"),
				"Support filter expanded","Support filter expanded");
		getRogersSearchPage().clkParentFilter("Support","Billing/Accounts");
	//	reporter.hardAssert(getRogersSearchPage().isParentFilterExpanded("Support","Billing/Accounts"),
			//	"Billing/Accounts filter expanded","Billing/Accounts filter expanded");
		reporter.hardAssert(getRogersSearchPage().validateResultsTag("Support","Billing/Accounts")
				,"Results' tags verified", "Results' tags mismatch");
		reporter.reportLogWithScreenshot("Support-Billing/Accounts Expanded");
		getRogersSearchPage().clkResetAllFilters();
		reporter.reportLogWithScreenshot("Reset All Filters button clicked");
		getRogersSearchPage().isPageLoaded();
		String resultAfterReset = getRogersSearchPage().numberOfResults();
		reporter.hardAssert(getRogersSearchPage().validateAllFiltersCollapsed(),
				"All Filters are Reset","Filters Not Reset");
		reporter.hardAssert(getRogersSearchPage().stringMatch(resultBeforeReset,resultAfterReset), "Results refreshed", "Results not refreshed");
			reporter.hardAssert(getRogersSearchPage().validateResultsTag("Shop"),
				"All Results Refreshed","Results Not Refreshed");
		getRogersSearchPage().clkGrandParentFilter("Shop");
		reporter.hardAssert(getRogersSearchPage().isGrandParentFilterExpanded("Shop"),
				"Shop filter expanded","Shop filter expanded");
		getRogersSearchPage().clkParentFilter("Shop","Wireless");
		//reporter.hardAssert(getRogersSearchPage().isParentFilterExpanded("Shop","Wireless"),
		//		"Wireless filter expanded","Wireless filter expanded");
		getRogersSearchPage().clkDeviceType("Smartphone");
		reporter.reportLogWithScreenshot("Smartphone clicked");
		getRogersSearchPage().clkBrandType("Apple");
		reporter.reportLogWithScreenshot("Apple clicked");
		strStorageOptions = getRogersSearchPage().getStorageSelections();
		getRogersSearchPage().clkStorageType(strStorageOptions.get(0));
		strColorOptions = getRogersSearchPage().getColorSelections();
		getRogersSearchPage().clkColorType(strColorOptions.get(0));
		reporter.reportLogWithScreenshot("Device:Smartphone; Brand:Apple; Storage:" + strStorageOptions.get(0)
				+"; Color:" + strColorOptions.get(0) + " is Selected");
		getRogersSearchPage().clkResetAllFilters();
		reporter.reportLogWithScreenshot("Reset All Filters button clicked");
		reporter.hardAssert(getRogersSearchPage().validateAllFiltersCollapsed(),
				"All Filters are Reset","Filters Not Reset");
		reporter.hardAssert(getRogersSearchPage().validateResultsTag("Shop"),
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