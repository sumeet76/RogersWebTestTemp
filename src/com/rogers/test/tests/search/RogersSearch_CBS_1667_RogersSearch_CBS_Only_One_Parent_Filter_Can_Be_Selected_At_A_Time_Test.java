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

	@DataProvider(name = "FilterData",parallel=true)
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
		getRogersSearchPage().isPageLoaded();
		getRogersSearchPage().waitTime();
		List<WebElement> lstParentFilters;
		String strParentFilter;
		String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
		for(int i=0; i<strFilters.length; i++) {
			getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
			reporter.reportLogWithScreenshot(strFilters[i]+" is clicked");
			lstParentFilters = getRogersSearchPage().getParentFilters(strFilters[i]);
			for(int j=0; j<lstParentFilters.size(); j++) {
				getRogersSearchPage().clkParentFilter(lstParentFilters.get(j));
				strParentFilter = lstParentFilters.get(j).getText();
				reporter.reportLogWithScreenshot(strParentFilter +" is clicked");
				reporter.softAssert(getRogersSearchPage().isParentFilterExpanded(lstParentFilters.get(j)),
						strParentFilter +" is expanded", strParentFilter +" is not expanded");
				for(int k=0; k<lstParentFilters.size(); k++) {
					if(j!=k) {
						reporter.softAssert(!(getRogersSearchPage().isParentFilterExpanded(lstParentFilters.get(k))),
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