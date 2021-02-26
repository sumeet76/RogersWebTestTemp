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

public class RogersSearch_CBS_1686_Clicking_On_A_Parent_Filter_After_Selecting_A_Child_Filter_Test extends BaseTestClass {

	@Test
	public void validateChildAndParentFilterSelection() {
		List<WebElement> lstParentFilters;
		List<String> strColorFilters;
		String strParentFilterName;
		int intCounter = 0;

		getDriver().get(System.getProperty("SearchUrl")+"wireless");
		getRogersSearchPage().isPageLoaded();
		getRogersSearchPage().waitTime();

		 getRogersSearchPage().clkGrandParentFilter("Shop");
		reporter.reportLogWithScreenshot("Shop is clicked");

		lstParentFilters = getRogersSearchPage().getParentFilters("Shop");

		getRogersSearchPage().clkParentFilter("Shop","Wireless");
		reporter.reportLogWithScreenshot("Wireless is selected");


		strColorFilters = getRogersSearchPage().getColorFilters();
		for(int i=0;i<strColorFilters.size();i++) {
			getRogersSearchPage().clkColorType(strColorFilters.get(i));
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");

			reporter.softAssert(getRogersSearchPage().validateResultsTag("Shop","Wireless"),
					"Results belong to tag 'Shop - Wireless'",
					"Results do not belong to tag 'Shop - Wireless'");

			reporter.softAssert(getRogersSearchPage().validateResultsColor(strColorFilters.get(i)),
					"All Results belong to color: "+strColorFilters.get(i),
					"All Results do Not belong to color: "+strColorFilters.get(i));

			if(intCounter == (lstParentFilters.size()-1)) {
				intCounter = 0;
			}

			strParentFilterName = lstParentFilters.get(intCounter).getText();
			getRogersSearchPage().clkParentFilter(lstParentFilters.get(intCounter));
			reporter.reportLogWithScreenshot("Parent filter " + lstParentFilters.get(intCounter).getText() + " is clicked");
			reporter.softAssert(getRogersSearchPage().validateResultsTag("Shop",strParentFilterName),
					"Results belong to tag 'Shop - "+ strParentFilterName +"'. Navigation Passed",
					"Results do not belong to tag 'Shop - "+ strParentFilterName +"'. Navigation Failed");

			intCounter++;
			getRogersSearchPage().clkParentFilter("Shop","Wireless");
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