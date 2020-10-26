package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1704_URL_Persist_Selected_State_Test extends BaseTestClass {

	@Test
	public void validateParentFilterDeselection() throws UnsupportedEncodingException {

		String[] strDeviceType = {"Smartphone"};
		String[] strBrandType = {"Apple","Samsung"};
		String[] strStorageType = {"128GB","256GB"};
		String[] strColorType = {"Black","Blue"};
		int intIndex;
		String strCurrentUrl;

		getDriver().get(System.getProperty("SearchUrl")+"wireless");

		rogers_search_page.clkGrandParentFilter("Support");
		rogers_search_page.clkParentFilter("Support","Billing/Accounts");
		reporter.reportLogWithScreenshot("Support-Billing/Accounts Expanded");
		reporter.softAssert(rogers_search_page.validateFiltersInUrl("Support","Billing/Accounts"),
				"Support_Billing/Accounts appended in URL","Support_Billing/Accounts NOT appended in URL");
		strCurrentUrl = getDriver().getCurrentUrl();
		getDriver().get("about:blank");
		reporter.reportLogWithScreenshot("Blank Page Launched");

		getDriver().get(strCurrentUrl);
		reporter.reportLogWithScreenshot("Browser re-launched with url - " + strCurrentUrl);
		reporter.hardAssert(rogers_search_page.isGrandParentFilterExpanded("Support"),
				"Support filter expanded","Support filter Not expanded");
		reporter.hardAssert(rogers_search_page.isParentFilterExpanded("Support","Billing/Accounts"),
				"Billing/Accounts filter expanded","Billing/Accounts filter Not expanded");

		rogers_search_page.clkGrandParentFilter("Shop");
		rogers_search_page.clkParentFilter("Shop","Wireless");
		for (intIndex=0;intIndex<strDeviceType.length;intIndex++) {
			rogers_search_page.clkDeviceType(strDeviceType[intIndex]);
		}
		for (intIndex=0;intIndex<strBrandType.length;intIndex++) {
			rogers_search_page.clkBrandType(strBrandType[intIndex]);
		}
		for (intIndex=0;intIndex<strStorageType.length;intIndex++) {
			rogers_search_page.clkStorageType(strStorageType[intIndex]);
		}
		for (intIndex=0;intIndex<strColorType.length;intIndex++) {
			rogers_search_page.clkColorType(strColorType[intIndex]);
		}
		reporter.reportLogWithScreenshot("Filters Selected");
		reporter.softAssert(rogers_search_page.validateFiltersInUrl("Shop","Wireless"),
				"Shop_Wireless appended in URL","Shop_Wireless NOT appended in URL");
		reporter.softAssert(rogers_search_page.validateDeviceTypesInUrl(strDeviceType),
				Arrays.toString(strDeviceType) + " appended in URL",Arrays.toString(strDeviceType) + " NOT appended in URL");
		reporter.softAssert(rogers_search_page.validateBrandsInUrl(strBrandType),
				Arrays.toString(strBrandType) + " appended in URL",Arrays.toString(strBrandType) + " NOT appended in URL");
		reporter.softAssert(rogers_search_page.validateStoragesInUrl(strStorageType),
				Arrays.toString(strStorageType) + " appended in URL",Arrays.toString(strStorageType) + " NOT appended in URL");
		reporter.softAssert(rogers_search_page.validateColorsInUrl(strColorType),
				Arrays.toString(strColorType) + " appended in URL",Arrays.toString(strColorType) + " NOT appended in URL");
		strCurrentUrl = getDriver().getCurrentUrl();
		getDriver().get("about:blank");
		reporter.reportLogWithScreenshot("Blank Page Launched");

		getDriver().get(strCurrentUrl);
		reporter.reportLogWithScreenshot("Browser re-launched with url - " + strCurrentUrl);
		reporter.softAssert(rogers_search_page.isGrandParentFilterExpanded("Shop"),
				"Shop filter expanded","Shop filter expanded");
		reporter.softAssert(rogers_search_page.isParentFilterExpanded("Shop","Wireless"),
				"Wireless filter expanded","Wireless filter NOT expanded");
		for (intIndex=0;intIndex<strDeviceType.length;intIndex++) {
			reporter.softAssert(rogers_search_page.isFilterChecked(strDeviceType[intIndex]),
					strDeviceType[intIndex] + " is Checked",strDeviceType[intIndex] + " is Not Checked");
		}
		for (intIndex=0;intIndex<strBrandType.length;intIndex++) {
			reporter.softAssert(rogers_search_page.isFilterChecked(strBrandType[intIndex]),
					strBrandType[intIndex] + " is Checked",strBrandType[intIndex] + " is Not Checked");
		}
		for (intIndex=0;intIndex<strStorageType.length;intIndex++) {
			reporter.softAssert(rogers_search_page.isFilterChecked(strStorageType[intIndex]),
					strStorageType[intIndex] + " is Checked",strStorageType[intIndex] + " is Not Checked");
		}
		for (intIndex=0;intIndex<strColorType.length;intIndex++) {
			reporter.softAssert(rogers_search_page.isFilterChecked(strColorType[intIndex]),
					strColorType[intIndex] + " is Checked",strColorType[intIndex] + " is Not Checked");
		}
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