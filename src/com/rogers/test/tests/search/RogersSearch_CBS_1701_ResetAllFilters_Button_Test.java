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

public class RogersSearch_CBS_1701_ResetAllFilters_Button_Test extends BaseTestClass {
    @DataProvider(name = "FilterData", parallel = true)
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

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Multilingual", "Sanity"})
    public void validateParentFilterDeselection(String[] csvRowStrArray) {
        List<String> strColorFilters;
        String[] strFilters;
        String gpfilter, pfilter;
        List<String> strSizeOptions;
        String resultAfterReset, resultBeforeReset;
        int i = 0;
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().waitTime();
        resultBeforeReset = getRogersSearchPage().numberOfResults();
        gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strColorFilters = getRogersSearchPage().getColorFilters();
        getRogersSearchPage().clkColorType(strColorFilters.get(i));
        reporter.reportLogWithScreenshot(strColorFilters.get(i) + ": Color is selected");
        getRogersSearchPage().isPageLoaded();
        getRogersSearchPage().clkResetAllFilters();
        getRogersSearchPage().waitTime();
        reporter.reportLogWithScreenshot("Reset All Filters button clicked");
        resultAfterReset = getRogersSearchPage().numberOfResults();
        reporter.hardAssert(getRogersSearchPage().validateAllFiltersCollapsed(),
                "All Filters are Reset", "Filters Not Reset");
        reporter.softAssert(getRogersSearchPage().filterCount(),"Filter Count is set to 0", "Filter count is not set to 0");
        reporter.hardAssert(getRogersSearchPage().stringMatch(resultBeforeReset, resultAfterReset), "Results refreshed", "Results not refreshed");
        strFilters = Arrays.copyOfRange(csvRowStrArray, 1, csvRowStrArray.length);
        reporter.softAssert(getRogersSearchPage().verifyResultsCategoryTagRelevancy(strFilters),
                "Relevant Results tags Displayed are displayed on the landing page for the search filters", "Relevant Results tags are not displayed on the landing page for the search filters");
        resultBeforeReset = getRogersSearchPage().numberOfResults();
        gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        getRogersSearchPage().clkWatchDeviceType();
        reporter.reportLogWithScreenshot("Selected device Watch");
        strSizeOptions = getRogersSearchPage().getSizeSelections();
        reporter.hardAssert(strSizeOptions.size() != 0, "Size Options Available", "Size Options Unavailable");
        for (int j = 0; i < strSizeOptions.size(); i++) {
            getRogersSearchPage().clkSizeType(strSizeOptions.get(i));
            reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i) + " is selected");
        }
        getRogersSearchPage().clkResetAllFilters();
        reporter.reportLogWithScreenshot("Reset All Filters button clicked");
        resultAfterReset = getRogersSearchPage().numberOfResults();
        reporter.hardAssert(getRogersSearchPage().validateAllFiltersCollapsed(),
                "All Filters are Reset", "Filters Not Reset");
        reporter.softAssert(getRogersSearchPage().filterCount(),"Filter Count is set to 0", "Filter count is not set to 0");
        reporter.hardAssert(getRogersSearchPage().stringMatch(resultBeforeReset, resultAfterReset), "Results refreshed", "Results not refreshed");
        strFilters = Arrays.copyOfRange(csvRowStrArray, 1, csvRowStrArray.length);
        reporter.softAssert(getRogersSearchPage().verifyResultsCategoryTagRelevancy(strFilters),
                "Relevant Results tags Displayed are displayed on the landing page for the search filters", "Relevant Results tags are not displayed on the landing page for the search filters");
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