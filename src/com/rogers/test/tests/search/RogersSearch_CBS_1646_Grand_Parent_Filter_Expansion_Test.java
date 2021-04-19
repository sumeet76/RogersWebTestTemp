package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import utils.CSVReader;

/**
 * This class will validate results have tags consistent to the grandparent filter selected
 *
 * @author pankaj.patil
 **/
public class RogersSearch_CBS_1646_Grand_Parent_Filter_Expansion_Test extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = null;
        String language = System.getProperty("Language").toLowerCase();
        switch (language) {
            case "en":
                csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
                break;
            case "fr":
                csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataFR.csv";
                break;
        }
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Multilingual", "Mobile"})
    public void validateResultsGrandParentFilter(String[] csvRowStrArray) {
        boolean isMobile;
        getDriver().get(System.getProperty("SearchUrl") + csvRowStrArray[0]);
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        for (int i = 1; i < csvRowStrArray.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(csvRowStrArray[i]);
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(csvRowStrArray[i] + " filter selected");
            if (isMobile) {
                getRogersSearchPage().clkShowResultBtnMobile();
                reporter.reportLogWithScreenshot("Show results button clicked");
            }
            reporter.softAssert(getRogersSearchPage().validateResultsTag(csvRowStrArray[i]),
                    "Results have expected tag " + csvRowStrArray[i], "Results do not have expected tag " + csvRowStrArray[i]);
            isMobile = getRogersSearchPage().isMobileSelected();
            if (isMobile) {
                getRogersSearchPage().clkFilterIconMobile();
                reporter.reportLogWithScreenshot("Clicked on Filter Icon");
            }
        }
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