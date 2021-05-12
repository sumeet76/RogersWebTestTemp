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
 * This class contains the test method to validate that we see relevant results on toggling province
 *
 * @author naina.agarwal
 * <p>
 * Test steps:
 * <p>
 * Go to the testing env and search for a term, Tester should see the relevant results page
 * Toggle province from the header , The results page should refresh as per the province selected
 * Hit refresh , The tester should still see the selected province
 * Select a grandparent filter and toggle province, The results page should refresh as per the selected province and the grandparent filter should be unselected (from the URL as well)
 **/
public class RogersSearch_CBS_Pagination_1962_Province_Toggling_Functioning extends BaseTestClass {

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

    @Test(dataProvider = "FilterData", groups = {"Search", "Pagination"})
    @Parameters({"strLanguage"})
    public void contextPageValidation(String[] csvRow) {
        String searchResult = null;
        String strParentFilterName = null;
        List<WebElement> lstParentFilters;
        String selectedProvince = null;
        boolean isMobile;
        reporter.reportLogWithScreenshot("Launching URL");
        getRogersSearchPage().isPageLoaded();
        getRogersSearchPage().isEnvQA();
        reporter.reportLogWithScreenshot("Page is launched");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRow[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRow[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        selectedProvince = getRogersSearchPage().selectRandomProvince();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Selected province is: " + selectedProvince);
        searchResult = getRogersSearchPage().getSearchResults();
        reporter.reportLogPass(searchResult + " are displayed");
        getDriver().navigate().refresh();
        reporter.reportLogWithScreenshot("Page is refreshed");
        getRogersSearchPage().waitForPage();
        reporter.softAssert(getRogersSearchPage().searchResultMatch(searchResult), "Search results match after page refresh", "Search result does not match after page refresh");
        reporter.softAssert(getRogersSearchPage().validateProvinceAfterToggle(selectedProvince), "Same province is displayed in Language toggle after page refresh", "Same province is displayed in Language toggle after page refresh");
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkOnCrossMarkMbl();
            reporter.reportLogWithScreenshot("Clicked on Cross Mark");
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        getRogersSearchPage().clkGrandParentFilter(csvRow[1]);
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot(csvRow[1] + " grandparent filter is clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(csvRow[1]);
        getRogersSearchPage().clkParentFilter(lstParentFilters.get(0));
        getRogersSearchPage().isPageLoaded();
        strParentFilterName = lstParentFilters.get(0).getText();
        reporter.reportLogWithScreenshot(strParentFilterName + " parent filter is selected");
        getRogersSearchPage().isPageLoaded();
        if (isMobile) {
            getRogersSearchPage().clkShowResultBtnMobile();
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot("Clicked on Show Results button");
        }
        selectedProvince = getRogersSearchPage().selectRandomProvince();
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Selected province is: " + selectedProvince);
        searchResult = getRogersSearchPage().getSearchResults();
        reporter.reportLogPass(searchResult + " are displayed");
        getDriver().navigate().refresh();
        reporter.reportLogWithScreenshot("Page is refreshed");
        getRogersSearchPage().waitForPage();
        reporter.softAssert(getRogersSearchPage().searchResultMatch(searchResult), "Search results match after page refresh", "Search result does not match after page refresh");
        reporter.softAssert(getRogersSearchPage().validateProvinceAfterToggle(selectedProvince), "Same province is displayed in Language toggle after page refresh", "Same province is displayed in Language toggle after page refresh");
        if (isMobile) {
            getRogersSearchPage().clkOnCrossMarkMbl();
            reporter.reportLogWithScreenshot("Clicked on Cross Mark");
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        reporter.softAssert(getRogersSearchPage().isGrandParentFilterUnexpanded(), "Filter is reset", "Filter is not reset");
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
