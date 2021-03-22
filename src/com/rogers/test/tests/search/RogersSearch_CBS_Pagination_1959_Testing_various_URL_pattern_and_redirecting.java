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
 *
 * Test steps:
 *
 * Any special characters inputted should redirect to the home page
 * Invalid urls - redirect to home page
 **/
public class RogersSearch_CBS_Pagination_1959_Testing_various_URL_pattern_and_redirecting extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/InvalidSearchTerm.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }


    @Test(dataProvider = "FilterData", groups = {"Pagination"}) @Parameters({"strLanguage"} )
    public void contextPageValidation(String[] csvRow) {
        String url="https://qa4.rogers.com/search?q=@@@";
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRow[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRow[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validateHomeURL(),"Directed to home page", "Not directed to home page");
        getDriver().get(url);
        reporter.reportLogWithScreenshot("Url is updayed with invalid search term, url is: " +url);
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validateHomeURL(),"Directed to home page", "Not directed to home page");
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