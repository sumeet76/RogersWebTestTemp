package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
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
 *1. Search for a term and scroll down to pagination component
 *2. Select page number 2
 *3. Select any page no. visible .
 *
 **/
public class RogersSearch_CBS_Pagination_1759_Current_Page_Context_Validation extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
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
    public void contextPageValidation(String[] csvRowStrArray)
    {
        String url;
        int pageNumber;
        String message=null;
        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().waitTime();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().waitTime();
        reporter.reportLogPass(getRogersSearchPage().getSearchResults() + " are displayed");
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(),"First page is highlighted under pagination", "First page is not highlighted under pagination");
        message =getRogersSearchPage().selectPageTwo();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogPassWithScreenshot(message);
        message =getRogersSearchPage().isSecondPageNumberHighlighted();
        reporter.reportLogPassWithScreenshot(message);
        url = getDriver().getCurrentUrl();
        message =getRogersSearchPage().validatePageNumberInURL(url);
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().validateSearchResultNumberAreInSyncWithPagination(), "The search result number at the top are displayed based on page number selected", "The search result number at the top are not displayed based on page number selected");
        pageNumber = getRogersSearchPage().clickOnRandomPageNumber();
        reporter.reportLogPassWithScreenshot("A random page number " + pageNumber+ " in the pagination component is clicked");
        url = getDriver().getCurrentUrl();
        message =getRogersSearchPage().validatePageNumberInURL(url);
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().validateSearchResultNumberAreInSyncWithPagination(), "The search result number at the top are displayed based on page number selected", "The search result number at the top are not displayed based on page number selected");

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