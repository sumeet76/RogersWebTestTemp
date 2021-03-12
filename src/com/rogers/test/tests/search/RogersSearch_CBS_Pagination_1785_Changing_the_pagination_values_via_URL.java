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
 *1. Go to the testing env and change the page size and page number to a valid value in the URL, The page should reflect inserted page size and page number
 *2. Go to the testing env and change the page size and page number to a invalid value in the URL, The app will reset the pagination to default value
 **/
public class RogersSearch_CBS_Pagination_1785_Changing_the_pagination_values_via_URL extends BaseTestClass {

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
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().waitTime();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().waitTime();
        reporter.reportLogPass(getRogersSearchPage().getSearchResults() + " are displayed");
        String newURL=getRogersSearchPage().updateURLWithValidData();
        reporter.reportLogPassWithScreenshot("URL is updated with valid page number and page size, new URL is: " +newURL);
        getRogersSearchPage().isPageLoaded();
        message =getRogersSearchPage().validatePageNumberInURL(newURL);
        reporter.reportLogPassWithScreenshot(message);
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().validatePageSizeInURL(newURL),"The paze size matches with the URL", "The page size does not match with the URL");
        String newInvalidURL=getRogersSearchPage().updateURLWithInvalidData();
        reporter.reportLogPassWithScreenshot("URL is updated with invalid page number and page size");
        getRogersSearchPage().isPageLoaded();
        reporter.softAssert(getRogersSearchPage().isFirstPageNumberHighlighted(),"First page is highlighted under pagination", "First page is not highlighted under pagination");
        reporter.softAssert(getRogersSearchPage().validateDefaultResultDropdownValue(),"Default page is displayed as expected","Default page size is not displayed as expected");

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("SearchUrl") , strBrowser, strLanguage, RogersEnums.GroupName.search, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}