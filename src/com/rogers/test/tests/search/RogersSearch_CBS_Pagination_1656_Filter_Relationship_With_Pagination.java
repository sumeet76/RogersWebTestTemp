package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * This class contains the test method to validate that if any filter state is selected then it should not be affected (stay put)
 * on performing any pagination functionality
 *
 * @author naina.agarwal
 * <p>
 * Test steps:
 * <p>
 * Select any combination of parent- child(s) filter,The pagination component should be displayed with 1st page highlighted and 10 results on the screen
 * Navigate to different page numbers and select first and last page button,The selected filter state should be persistent when the results refresh
 * Change the page size,The selected filter state should be persistent when the results refresh
 **/
public class RogersSearch_CBS_Pagination_1656_Filter_Relationship_With_Pagination extends BaseTestClass {

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

    @Test(dataProvider = "FilterData", groups = {"Search", "Pagination"})
    @Parameters({"strLanguage"})
    public void contextPageValidation(String[] csvRow) throws UnsupportedEncodingException {
        boolean isMobile;
        String message, results, grandParentFilter, strParentFilterName;
        List<WebElement> lstParentFilters;
        reporter.reportLogWithScreenshot("Launching URL");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is launched");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRow[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRow[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        results = getRogersSearchPage().getSearchResults();
        reporter.reportLogPass("Displayed results are : " + results);
        grandParentFilter = csvRow[1];
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        getRogersSearchPage().clkGrandParentFilter(grandParentFilter);
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot(grandParentFilter + " grandparent filter is clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(csvRow[1]);
        int size = lstParentFilters.size();
        getRogersSearchPage().clkParentFilter(lstParentFilters.get(size - 1));
        getRogersSearchPage().isPageLoaded();
        strParentFilterName = lstParentFilters.get(size - 1).getText();
        reporter.reportLogWithScreenshot(strParentFilterName + " parent filter is selected");
        if (isMobile) {
            getRogersSearchPage().clkShowResultBtnMobile();
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot("Clicked on Show Results button");
        }
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(), "First page is highlighted under pagination", "First page is not highlighted under pagination");
        reporter.softAssert(getRogersSearchPage().validateDefaultResultDropdownValue(), "Default page size is displayed as expected", "Default page size is not displayed as expected");
        message = getRogersSearchPage().clickLastForwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().lastPageIsHighlighted(), "Last page is highlighted", "Last page is not highlighted");
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validateFiltersInUrl(grandParentFilter, strParentFilterName), "Filters are retained", "Filters are not retained");
        message = getRogersSearchPage().clickLastBackwardArrow();
        reporter.reportLogPassWithScreenshot(message);
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(), "First page is highlighted under pagination", "First page is not highlighted under pagination");
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validateFiltersInUrl(grandParentFilter, strParentFilterName), "Filters are retained", "Filters are not retained");
        String randomPageSize = getRogersSearchPage().selectRandomValueFromResultPerPageDropdown();
        reporter.reportLogPassWithScreenshot("Selected a random Page size from result per page dropdown : " + randomPageSize);
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validateFiltersInUrl(grandParentFilter, strParentFilterName), "Filters are retained", "Filters are not retained");
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
