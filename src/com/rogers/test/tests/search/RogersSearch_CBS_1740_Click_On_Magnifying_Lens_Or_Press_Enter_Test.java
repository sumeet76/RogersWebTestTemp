package com.rogers.test.tests.search;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;

import utils.CSVReader;

public class RogersSearch_CBS_1740_Click_On_Magnifying_Lens_Or_Press_Enter_Test extends BaseTestClass {
    @DataProvider(name = "FilterData",parallel=true)
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
    public void validateResultLandingPage(String[] csvRow) throws UnsupportedEncodingException {
        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("CBS Search Page");
        getRogersSearchPage().enterTextSearch(csvRow[0]);
        reporter.reportLogWithScreenshot("Search field entered");
        reporter.hardAssert(getRogersSearchPage().isSuggestionsSectionDisplayed(), "label Suggestion Visible", "label Suggestion Not Visible");
        reporter.hardAssert(getRogersSearchPage().isSupportSectionDisplayed(), "label Support Visible", "label Support Not Visible");
        if(getRogersSearchPage().isSupportSectionPopulated() || getRogersSearchPage().isLeftSectionPopulated()) {
            reporter.reportLogPassWithScreenshot("Suggestion or Supports populated");
        } else {
            reporter.reportLogFailWithScreenshot("Suggestion and Support not populated");
        }
        getRogersSearchPage().clkOnMagnifyingLens();
        reporter.reportLogWithScreenshot("Search Results Page");
        reporter.hardAssert(getRogersSearchPage().validateURLContains(csvRow[0]), "Result Landing Page displayed", "Result Landing Page not displayed");
        for (int i = 1; i < csvRow.length; i++) {
            reporter.softAssert(getRogersSearchPage().isFilterDisplayed(csvRow[i]), "Filter " + csvRow[i] + " is Displayed", "Filter " + csvRow[i] + " is NOT Displayed");
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