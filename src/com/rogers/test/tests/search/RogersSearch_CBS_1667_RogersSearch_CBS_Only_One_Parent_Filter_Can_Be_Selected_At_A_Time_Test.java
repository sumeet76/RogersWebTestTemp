package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import utils.CSVReader;

public class RogersSearch_CBS_1667_RogersSearch_CBS_Only_One_Parent_Filter_Can_Be_Selected_At_A_Time_Test extends BaseTestClass {

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
	public void validateParentFilterSelection(String[] csvRow) {
		getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
	
		List<WebElement> lstParentFilters;
		String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
		for(int i=0; i<strFilters.length; i++) {
			rogers_search_page.clkGrandParentFilter(strFilters[i]);
			reporter.reportLogWithScreenshot(strFilters[i]+" is clicked");
			lstParentFilters = rogers_search_page.getParentFilters(strFilters[i]);
			for(int j=0; j<lstParentFilters.size(); j++) {
				rogers_search_page.clkParentFilter(lstParentFilters.get(j));
				reporter.reportLogWithScreenshot(lstParentFilters.get(j).getText()+" is clicked");
				reporter.softAssert(rogers_search_page.isParentFilterExpanded(lstParentFilters.get(j)),
						lstParentFilters.get(j).getText()+" is expanded", lstParentFilters.get(j).getText()+" is not expanded");
				for(int k=0; k<lstParentFilters.size(); k++) {
					if(j!=k) {
						reporter.softAssert(!(rogers_search_page.isParentFilterExpanded(lstParentFilters.get(k))),
								lstParentFilters.get(k).getText()+" is not expanded", lstParentFilters.get(k).getText()+" is expanded");
					}
				}
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