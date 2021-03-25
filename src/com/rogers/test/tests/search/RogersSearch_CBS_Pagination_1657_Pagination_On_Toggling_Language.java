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

/**
 * This class contains the test method to validate the current page context validation for search
 *
 * @author naina.agarwal
 *
 * Test steps:
 *
 * Validate that on toggling language (EN/FR), irrespective of any number of filters or pagination
 * functionality (page number, current highlighted page) selected should reset
 * except for the term on which the search was performed.
 **/
public class RogersSearch_CBS_Pagination_1657_Pagination_On_Toggling_Language extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName=null;
        if(System.getProperty("Language").toLowerCase().equals("en")) {
            csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv"; }
        else if (System.getProperty("Language").toLowerCase().equals("fr"))
        {
            csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataFR.csv"; }
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }


    @Test(dataProvider = "FilterData", groups = {"Search","Pagination"}) @Parameters({"strLanguage"})
    public void contextPageValidation(String[] csvRow)
    {
        String url;
        int pageNumber;
        String message=null;
        String strParentFilterName=null;
        List<WebElement> lstParentFilters;
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRow[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRow[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().waitTime();
        reporter.reportLogPass(getRogersSearchPage().getSearchResults() + " are displayed");
        getRogersSearchPage().clkGrandParentFilter(csvRow[1]);
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot(csvRow[1] + " grandparent filter is clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(csvRow[1]);
        getRogersSearchPage().clkParentFilter(lstParentFilters.get(0));
        getRogersSearchPage().isPageLoaded();
        strParentFilterName = lstParentFilters.get(0).getText();
        reporter.reportLogWithScreenshot(strParentFilterName + " parent filter is selected");
        String randomPageSize= getRogersSearchPage().selectRandomValueFromResultPerPageDropdown();
        reporter.reportLogPassWithScreenshot("Selected a random Page size from result per page dropdown : " + randomPageSize);
        message =getRogersSearchPage().selectPageTwo();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogPassWithScreenshot(message);
        message =getRogersSearchPage().isSecondPageNumberHighlighted();
        reporter.reportLogPassWithScreenshot(message);
        url = getDriver().getCurrentUrl();
        message =getRogersSearchPage().validatePageNumberInURL(url);
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().validatePageSizeInURL(url)," Page size at the bottom pagination and the url matches", "Page size at the bottom pagination and the url does not match");
        getRogersSearchPage().toggleLanguage();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Toggle Language is clicked");
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(),"First page is highlighted under pagination", "First page is not highlighted under pagination");
        reporter.softAssert(getRogersSearchPage().isGrandParentFilterUnexpanded(),"Filter is reset", "Filter is not reset");
        reporter.softAssert(getRogersSearchPage().searchTermRetained(csvRow[0]),"Search term is retained", "Search term is not retained");

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