package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1742_InvalidTerm_NoResultsPage_Test_WithoutTyphead extends BaseTestClass {
    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = null;
        csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/InvalidTerms.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Typehead", "Multilingual", "Sanity"})
    public void validateResultLandingPage(String[] csvRowStrArray) throws UnsupportedEncodingException {
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        reporter.reportLogWithScreenshot("Clicked on search icon");
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        reporter.hardAssert(getRogersSearchPage().validateURLContains(csvRowStrArray[0]),
                "Results URL is right", "Results URL is not right");
        reporter.hardAssert(getRogersSearchPage().isNoResultsDisplayed(),
                "No Results Found message is displayed", "No Results found message not displayed");
        reporter.hardAssert(!getRogersSearchPage().isFilterSectionDisplayed(),
                "Filter Section is Not Displayed", "Filter Section is Displayed");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("SearchUrl"), strBrowser, strLanguage, RogersEnums.GroupName.search, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}