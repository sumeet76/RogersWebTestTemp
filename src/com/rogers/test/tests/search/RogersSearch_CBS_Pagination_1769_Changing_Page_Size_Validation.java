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
 * <p>
 * Test steps:
 * <p>
 * 1. Search for a term and scroll down to pagination component
 * 2. Tester should see 10 results in items per page component and in the URL. The page info at the top should be updated
 * 3. In the items per page, select a different page size
 * 4. The items per page and the URL should reflect the selected page size.
 * The page info at the top should be updated
 **/
public class RogersSearch_CBS_Pagination_1769_Changing_Page_Size_Validation extends BaseTestClass {

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

    @Test(dataProvider = "FilterData", groups = {"Search", "Pagination"})
    public void contextPageValidation(String[] csvRowStrArray) {
        String results;
        List<WebElement> resultLinks;
        reporter.reportLogWithScreenshot("Launching URL");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is launched");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        results = getRogersSearchPage().getSearchResults();
        reporter.reportLogPass("Displayed results are : " + results);
        resultLinks = getRogersSearchPage().getAllResultLinks();
        reporter.softAssert(getRogersSearchPage().validateNumberOfSearchResultsOnPage(resultLinks), "Results displayed on the page are within expected range", "Results displayed on the page not within expected range");
        String randomPageSize = getRogersSearchPage().selectRandomValueFromResultPerPageDropdown();
        reporter.reportLogPassWithScreenshot("Selected a random Page size from result per page dropdown : " + randomPageSize);
        int totalResults = getRogersSearchPage().totalResult();
        reporter.softAssert(getRogersSearchPage().validateResultsAfterPageSizeSelection(randomPageSize, totalResults), "The result list is displayed correctly based on the random page selected from the dropdown", "The result list is not displayed correctly based on the random page selected from the dropdown");
        reporter.softAssert(getRogersSearchPage().verifyResultsOnTop(randomPageSize, totalResults), "Results on the top are displayed according to page size selected", "Results on the top are not based on page size selected");
        reporter.softAssert(getRogersSearchPage().validatePageSizeInURL(getDriver().getCurrentUrl()),"URL reflect correct page size as selected in result per page dropdown", "URL does not reflect correct page size as selected in result per page dropdown");
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