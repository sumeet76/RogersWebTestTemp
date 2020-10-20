package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;

import utils.CSVReader;

public class RogersSearch_CBS_1740_Click_On_Magnifying_Lens_Or_Press_Enter_Test extends BaseTestClass {
    @DataProvider(name = "FilterData")
    public Object[] testData() throws IOException
    {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/SearchBoxText.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRow = new Object[csvData.size()];

        for(int i =0; i < csvData.size();i++){
            csvRow[i] = csvData.get(i);
        }

        return csvRow;
    }

    @Test(dataProvider = "FilterData")
    public void validateResultLandingPage(String[] csvRow) {

        //getDriver().get(System.getProperty("SearchUrl"));
        getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);
        reporter.reportLogWithScreenshot("CBS Search Page");
        rogers_search_page.enterTextSearch(csvRow[1]);
        reporter.reportLogWithScreenshot("Search field entered");
        reporter.hardAssert(rogers_search_page.validateLabelVisible("Suggestions"), "label Suggestion Visible", "label Suggestion Not Visible");
        reporter.hardAssert(rogers_search_page.validateLabelVisible("Support"), "label Support Visible", "label Support Not Visible");
        reporter.reportLogWithScreenshot("Search Label Validation");
        reporter.hardAssert(rogers_search_page.validateLinksVisible("Suggestions"), "Suggestion Links Visible", "Suggestion Links  Not Visible");
        reporter.hardAssert(rogers_search_page.validateLinksVisible("Support"), "Support Links  Visible", " Support Links Not Visible");
        reporter.reportLogWithScreenshot("Link Validation");
        rogers_search_page.clkOnMagnifyingLens();
        reporter.hardAssert(rogers_search_page.validateResultLandingPageURL(csvRow[1]), "Result Landing Page displayed", "Result Landing Page not displayed");

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