package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;

import utils.CSVReader;

public class RogersSearch_CBS_1703_Results_To_Links_Detailed_Page_Test extends BaseTestClass {
	@DataProvider(name = "FilterData")
	public Object[] testData() throws IOException
	{
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRow = new Object[csvData.size()];

		for(int i =0; i < csvData.size();i++){
			csvRow[i] = csvData.get(i);
		}

		return csvRow;
	}

	@Test(dataProvider = "FilterData")

	public void validateResultsToLinksDetailedPage(String[] csvRow) {

		getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);

		List<WebElement> lstParentFilters;
		String strParentFilterName;
		String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
		for(int i=0; i<strFilters.length; i++) {

			rogers_search_page.clkGrandParentFilter(strFilters[i]);
			reporter.reportLogWithScreenshot("Grand Parent Filter "+strFilters[i]+" is clicked");
			lstParentFilters = rogers_search_page.getParentFilters(strFilters[i]);

			for(int j=0; j<lstParentFilters.size(); j++) {
				rogers_search_page.clkParentFilter(lstParentFilters.get(j));
				strParentFilterName = lstParentFilters.get(j).getText();
				reporter.reportLogWithScreenshot("Parent Filter "+strParentFilterName +" is selected");
				reporter.hardAssert(rogers_search_page.validateResultsLinks(),
						"Displayed Results are Links", "Displayed Results are not Links");
			}
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