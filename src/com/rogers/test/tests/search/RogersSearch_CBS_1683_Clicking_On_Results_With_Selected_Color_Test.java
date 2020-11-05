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

public class RogersSearch_CBS_1683_Clicking_On_Results_With_Selected_Color_Test extends BaseTestClass {
	


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
	
	public void validateResultsWithSelectedColors(String[] csvRow) {
	
	getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
	
	getRogersSearchPage().clkShopAndThenWirelessFilter();
	reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");
	
	reporter.hardAssert(getRogersSearchPage().verifyDifferentColorResultsDisplay(), "Color Results displayed correctly", "Color Results not displayed correctly");
	reporter.hardAssert(getRogersSearchPage().verifyResultsColorLabelWithSelectedColor(), "Color Label Displayed Correctly", "Color Label not Displayed Correctly");
				
				
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


