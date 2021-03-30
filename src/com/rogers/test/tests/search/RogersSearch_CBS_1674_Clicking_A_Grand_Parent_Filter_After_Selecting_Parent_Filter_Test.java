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
    public void validateNavigationFromParentToGrandParent(String[] csvRow) {
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        String strResultWindowText;
        List<WebElement> lstParentFilters;
        String strParentFilterName;
        strResultWindowText = getRogersSearchPage().getResultWindowText();
        String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
        for (int i = 0; i < strFilters.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(strFilters[i] + " is clicked");
            lstParentFilters = getRogersSearchPage().getParentFilters(strFilters[i]);
            for (int j = 0; j < lstParentFilters.size(); j++) {
                getRogersSearchPage().clkParentFilter(lstParentFilters.get(j));
                getRogersSearchPage().isPageLoaded();
                strParentFilterName = lstParentFilters.get(j).getText();
                reporter.reportLogWithScreenshot(strParentFilterName + " is selected");
                reporter.hardAssert(getRogersSearchPage().validateResultsTag(strFilters[i], strParentFilterName),
                        "Results tags verified", "Results tags mismatch");
                getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
                getRogersSearchPage().isPageLoaded();
                reporter.reportLogWithScreenshot(strFilters[i] + " is clicked");
                reporter.hardAssert(strResultWindowText.equals(getRogersSearchPage().getResultWindowText()),
                        "Successfully navigated to GrandParent from Parent filter", "Navigation from Parent to GrandParent filter failed");
                getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
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