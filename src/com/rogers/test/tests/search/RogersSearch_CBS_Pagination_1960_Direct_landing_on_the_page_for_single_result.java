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
 * This class contains the test method to validate that user is directed to the details
 * page for a single result so that user can reach destination without multiple clicks.
 *
 * @author naina.agarwal
 *
 * Test steps:
 * Go to the testing env and search for a term having single result, The tester should land on the record details page directly.
 * They should not see any filter & pagination component
 **/
public class RogersSearch_CBS_Pagination_1960_Direct_landing_on_the_page_for_single_result extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/OneSearchTerm.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }


    @Test(dataProvider = "FilterData", groups = {"Search","Pagination"}) @Parameters({"strLanguage"})
    public void contextPageValidation(String[] csvRowStrArray) {
        String url;
        int pageNumber;
        String message = null;
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box.");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        getRogersSearchPage().waitForDetailsPage();
        reporter.softAssert(getRogersSearchPage().isDetailsPageDisplayed(csvRowStrArray[0]), "Product details page is displayed for single result", "Product details page is not displayed for single result");
        reporter.reportLogWithScreenshot("Product Details Page for: " + csvRowStrArray[0]);
        reporter.softAssert(getRogersSearchPage().isFilterDisplayedForSingleResult(),"Filter Component is not displayed for single result", "Filter Component is displayed");
        reporter.softAssert(getRogersSearchPage().isPaginationDisplayedForSingleResult(),"Pagination Component is not displayed for single result", "Pagination Component is displayed");
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