package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1674_Clicking_A_Grand_Parent_Filter_After_Selecting_Parent_Filter_Test extends BaseTestClass {
	@DataProvider(name = "FilterData")
	public Object[] testData() throws IOException {
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRow = new Object[csvData.size()];
        for(int i =0; i < csvData.size();i++){
        	csvRow[i] = csvData.get(i);
        }
        return csvRow;
	}
	
	@Test(dataProvider = "FilterData")
	public void validateParentFilterDeselection(String[] csvRow) {
		String strResultWindowText;
		List<WebElement> lstParentFilters;
		String strParentFilterName;

		getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
		strResultWindowText = rogers_search_page.getResultWindowText();
	
		String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
		for(int i=0; i<strFilters.length; i++) {
			
			rogers_search_page.clkGrandParentFilter(strFilters[i]);
			reporter.reportLogWithScreenshot(strFilters[i]+" is clicked");
			lstParentFilters = rogers_search_page.getParentFilters(strFilters[i]);

			for(int j=0; j<lstParentFilters.size(); j++) {
				rogers_search_page.clkParentFilter(lstParentFilters.get(j));
				strParentFilterName = lstParentFilters.get(j).getText();
				reporter.reportLogWithScreenshot(strParentFilterName +" is selected");
				reporter.hardAssert(rogers_search_page.validateResultsTag(strFilters[i],strParentFilterName),
						"Results tags verified", "Results tags mismatch");
		
				rogers_search_page.clkGrandParentFilter(strFilters[i]);
				reporter.reportLogWithScreenshot(strFilters[i]+" is clicked");
				reporter.softAssert(rogers_search_page.getResultWindowText().equals(strResultWindowText),
						"Results refreshed back to initial search",
						"Results Not refreshed back to initial search");

				rogers_search_page.clkGrandParentFilter(strFilters[i]);
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