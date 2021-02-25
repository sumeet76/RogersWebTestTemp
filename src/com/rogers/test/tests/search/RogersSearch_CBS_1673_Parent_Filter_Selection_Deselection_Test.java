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

public class RogersSearch_CBS_1673_Parent_Filter_Selection_Deselection_Test extends BaseTestClass {
	@DataProvider(name = "FilterData",parallel=false)
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
	public void validateParentFilterSelectionDeselection(String[] csvRow) {
	
		String strGrandParentText;
		getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
		getRogersSearchPage().isPageLoaded();
		List<WebElement> lstParentFilters;
		String strParentFilterName;
		String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
		for(int i=0; i<strFilters.length; i++) {

			getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
			reporter.reportLogWithScreenshot(strFilters[i]+" is clicked");
			strGrandParentText = getRogersSearchPage().getResultWindowText();
			lstParentFilters = getRogersSearchPage().getParentFilters(strFilters[i]);

			for(int j=0; j<lstParentFilters.size(); j++) {
				getRogersSearchPage().clkParentFilter(lstParentFilters.get(j));
				strParentFilterName = lstParentFilters.get(j).getText();
				reporter.reportLogWithScreenshot(strParentFilterName +" is selected");
				reporter.softAssert(getRogersSearchPage().validateResultsTag(strFilters[i],strParentFilterName),
						"Results tags verified", "Results tags mismatch");
				getRogersSearchPage().DeselectParentFilter(lstParentFilters.get(j));
				reporter.reportLogWithScreenshot(strParentFilterName+" is deselected");
				reporter.softAssert(getRogersSearchPage().validateResultsTag(strFilters[i]),
						"Results tags verified", "Results tags mismatch");
				reporter.softAssert(getRogersSearchPage().getResultWindowText().equals(strGrandParentText),
						"Results refreshed back to Grand Parent Filter",
						"Results Not refreshed back to Grand Parent Filter");
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