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
 * This class contains the test method to validate the changing page size validation for search
 *
 * @author naina.agarwal
 *
 * Test steps:
 *
 *1. Search for a term and scroll down to pagination component
 *2. Click on the forward arrow key at the right end of the page numbers, Tester should be directed to page number 2 (if page 1 was selected)
 *3. Click on the back arrow key at the left end of the page numbers, Tester should be directed back to page number 1
 *4. Select the forward arrow key (at the extreme right end) of the pagination component ,Tester should land on the last page directly
 *   Select the backward arrow key (at the extreme left end) of the pagination component,Tester should land on the first page directly
 **/
public class RogersSearch_CBS_Pagination_1770_Jumping_to_previous_next_page extends BaseTestClass {

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
        List<WebElement> resultLinks;
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
        message =getRogersSearchPage().clickFirstForwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        message =getRogersSearchPage().isSecondPageNumberHighlighted();
        reporter.reportLogPassWithScreenshot(message);
        message =getRogersSearchPage().clickFirstBackwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(),"First page is highlighted under pagination", "First page is not highlighted under pagination");
        message =getRogersSearchPage().clickLastForwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().lastPageIsHighlighted(),"Last page is highlighted", "Last page is not highlighted");
        getRogersSearchPage().isPageLoaded();
        message =getRogersSearchPage().clickLastBackwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(),"First page is highlighted under pagination", "First page is not highlighted under pagination");
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