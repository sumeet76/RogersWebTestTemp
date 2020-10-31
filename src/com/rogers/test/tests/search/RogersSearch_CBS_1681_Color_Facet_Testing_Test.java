package com.rogers.test.tests.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import utils.CSVReader;

public class RogersSearch_CBS_1681_Color_Facet_Testing_Test extends BaseTestClass {

	@Test
	public void validateColorFilterSelection() {
		List<String> strColorFilters;
		getDriver().get(System.getProperty("SearchUrl")+"wireless");
	
		rogers_search_page.clkShopAndThenWirelessFilter();
		reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");
		strColorFilters = rogers_search_page.getColorFilters();
		for(int i=0;i<strColorFilters.size();i++) {
			rogers_search_page.clkColorType(strColorFilters.get(i));
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");

			reporter.softAssert(rogers_search_page.validateResultsColor(strColorFilters.get(i)),
					"All Results belong to color"+strColorFilters.get(i),
					"All Results do Not belong to color"+strColorFilters.get(i));

			rogers_search_page.clkColorType(strColorFilters.get(i));
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Deselected");
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


