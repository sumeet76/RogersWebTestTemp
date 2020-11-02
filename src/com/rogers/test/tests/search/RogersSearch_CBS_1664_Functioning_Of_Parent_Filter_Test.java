package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import utils.CSVReader;

public class RogersSearch_CBS_1664_Functioning_Of_Parent_Filter_Test extends BaseTestClass {


    @DataProvider(name = "FilterData")
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];

        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }

        return csvRowStrArray;


    }

    @Test(dataProvider = "FilterData")

    public void validateResultsForSubFilter(String[] csvRow) {
        List<WebElement> lstParentFilters;
        String strParentFilter;

        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);

        for (int i=1;i< csvRow.length;i++) {
            rogers_search_page.clkGrandParentFilter(csvRow[i]);
            reporter.reportLogWithScreenshot(csvRow[i]+" is clicked");
            lstParentFilters = rogers_search_page.getParentFilters(csvRow[i]);

            for(int j=0;j<lstParentFilters.size();j++) {
                rogers_search_page.clkParentFilter(lstParentFilters.get(j));
                strParentFilter = lstParentFilters.get(j).getText();
                reporter.reportLogWithScreenshot(strParentFilter +" is clicked");
                reporter.softAssert(rogers_search_page.validateResultsTag(csvRow[i],strParentFilter),
                        "Results belong to tag " + csvRow[i] + "-" + strParentFilter,
                        "Results do Not belong to tag " + csvRow[i] + "-" + strParentFilter);
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


