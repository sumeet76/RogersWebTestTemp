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
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

public class RogersSearch_CBS_1664_Functioning_Of_Parent_Filter_Test extends BaseTestClass {
	
	private List<String[]> parseCsvData(String fileName) throws IOException
	{
	BufferedReader input = null;
	  File file = new File(fileName);
	  input = new BufferedReader(new FileReader(file));
	  String line = null;
	  List<String[]> strArrayList = new ArrayList<String[]>();
	  while ((line = input.readLine()) != null)
	  {		
	    String in = line.trim();
	    String[] strTempArray = in.split(",");
	    strArrayList.add(strTempArray);
	  }
	  input.close();
	  return strArrayList;

	}

	@DataProvider(name = "FilterData")
	public Object[] testData() throws IOException
	{
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
		List<String[]> csvData = parseCsvData(csvFileName);
		Object[] csvRowStrArray = new Object[csvData.size()];
		 
        for(int i =0; i < csvData.size();i++){
        	csvRowStrArray[i] = csvData.get(i);
        }
 
        return csvRowStrArray;
		 
		
	}
	
	@Test(dataProvider = "FilterData")

		public void validateResultsForSubFilter(String[] csvRowStrArray) {
		
		System.out.println("URL is:"+System.getProperty("SearchUrl")+csvRowStrArray[0]);
		
		getDriver().get(System.getProperty("SearchUrl")+csvRowStrArray[0]);
		System.out.println(getDriver().getCurrentUrl());
				
				String[] strFilters = Arrays.copyOfRange(csvRowStrArray, 1, csvRowStrArray.length);
				
					reporter.softAssert(rogers_search_page.clkParentFilterAndVerifyResultsCategoryTagRelevancy(strFilters),"Result with "+ strFilters +" tag is Displayed","Result with "+ strFilters +" tag is NOT Displayed");
					reporter.reportLogWithScreenshot("Search QA Page - "+strFilters);
					
		
		System.out.println("end of set");
			
		}
		
	
	
	@BeforeMethod @Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("SearchUrl")+"wireless", strBrowser, strLanguage, RogersEnums.GroupName.search, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
	
	
}


