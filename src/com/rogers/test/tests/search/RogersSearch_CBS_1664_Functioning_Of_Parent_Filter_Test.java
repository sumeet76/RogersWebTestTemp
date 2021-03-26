package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import utils.CSVReader;

/**
 * Validates results tags are displayed correctly based on grandparent-parent filter selection
 * @author pankaj.patil
 */
public class RogersSearch_CBS_1664_Functioning_Of_Parent_Filter_Test extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName = null;
        if (System.getProperty("Language").equalsIgnoreCase("en"))
            csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        else if (System.getProperty("Language").equalsIgnoreCase("fr"))
            csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataFR.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter"})
    public void validateResultsForSubFilter(String[] csvRow) {
        List<WebElement> lstParentFilters;
        String strParentFilter;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        for (int i = 1; i < csvRow.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(csvRow[i]);
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(csvRow[i] + " is clicked");
            lstParentFilters = getRogersSearchPage().getParentFilters(csvRow[i]);
            for (int j = 0; j < lstParentFilters.size(); j++) {
                getRogersSearchPage().clkParentFilter(lstParentFilters.get(j));
                getRogersSearchPage().isPageLoaded();
                strParentFilter = lstParentFilters.get(j).getText();
                reporter.reportLogWithScreenshot(strParentFilter + " is clicked");
                reporter.softAssert(getRogersSearchPage().validateResultsTag(csvRow[i], strParentFilter),
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