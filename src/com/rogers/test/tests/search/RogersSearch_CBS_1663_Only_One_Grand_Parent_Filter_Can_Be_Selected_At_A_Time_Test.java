package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import utils.CSVReader;

public class RogersSearch_CBS_1663_Only_One_Grand_Parent_Filter_Can_Be_Selected_At_A_Time_Test extends BaseTestClass {


    @DataProvider(name = "FilterData",parallel=false)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

	@Test(dataProvider = "FilterData",groups={"Search","Filter"})
	public void validateGrandParentFilterSelection(String[] csvRow) {
	    getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        getRogersSearchPage().waitTime();
        for(int i=1; i<csvRow.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(csvRow[i]);
            reporter.reportLogWithScreenshot(csvRow[i]+" is selected");
            reporter.softAssert(getRogersSearchPage().isGrandParentFilterExpanded(csvRow[i]),
                    csvRow[i]+" is Expanded", csvRow[i]+" is not Expanded");
            for(int j=1; j<csvRow.length; j++) {
                if(i!=j) {
                    reporter.softAssert(!(getRogersSearchPage().isGrandParentFilterExpanded(csvRow[j])),
                            csvRow[j]+" is not Expanded", csvRow[j]+" is Expanded");
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


