package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * This class contains the test method to validate the current page context validation for search
 *
 * @author naina.agarwal
 *
 * Test steps:
 *
 *Search for a term and go to page number 2,Tester should see the pagination details updated in the query string
 * Change the page size, Tester should see the pagination details updated in the query string
 * Copy+paste  the Url in another browser, The page should render back in the exact same way
 * Now refresh the page a couple of times, The page should render back in the exact same way every time
 **/
public class RogersSearch_CBS_Pagination_1599_Persisting_Page_State_in_URL extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }


    @Test(dataProvider = "FilterData", groups = {"Search","Pagination"}) @Parameters({"strLanguage"} )
    public void contextPageValidation(String[] csvRowStrArray)
    {
        String url,message,randomPageSize;
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogPass(getRogersSearchPage().getSearchResults() + " displayed for search term :" + csvRowStrArray[0]);
        message =getRogersSearchPage().selectPageTwo();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogPassWithScreenshot(message);
        message =getRogersSearchPage().isSecondPageNumberHighlighted();
        reporter.reportLogPassWithScreenshot(message);
        randomPageSize= getRogersSearchPage().selectRandomValueFromResultPerPageDropdown();
        reporter.reportLogPassWithScreenshot("Selected a random Page size from result per page dropdown : " + randomPageSize);
        url = getDriver().getCurrentUrl();
        reporter.softAssert(getRogersSearchPage().validatePageSizeInURL(url)," Page size at the bottom pagination and the url matches", "Page size at the bottom pagination and the url does not match");
        getRogersSearchPage().openURLInNewTab(url);
        reporter.reportLogPassWithScreenshot("New tab is launched with the same URL: " +url);
        getRogersSearchPage().refreshPage();
        getRogersSearchPage().waitForPage();
        reporter.reportLogPassWithScreenshot("The page is refreshed a couple of times");
        message =getRogersSearchPage().validatePageNumberInURL(url);
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().validatePageSizeInURL(url),"The page size matches with the URL", "The page size does not match with the URL");
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