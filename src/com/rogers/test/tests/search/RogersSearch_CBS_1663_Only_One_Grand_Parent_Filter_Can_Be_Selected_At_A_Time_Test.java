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
 * This class will validate that only one grandparent filter is selected at a time
 *
 * @author pankaj.patil
 **/
public class RogersSearch_CBS_1663_Only_One_Grand_Parent_Filter_Can_Be_Selected_At_A_Time_Test extends BaseTestClass {

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

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Multilingual"})
    public void validateGrandParentFilterSelection(String[] csvRow) {
        boolean isMobile;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        for (int i = 1; i < csvRow.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(csvRow[i]);
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(csvRow[i] + " is selected");
            reporter.softAssert(getRogersSearchPage().isGrandParentFilterExpanded(csvRow[i]),
                    csvRow[i] + " is Expanded", csvRow[i] + " is not Expanded");
            for (int j = 1; j < csvRow.length; j++) {
                if (i != j) {
                    reporter.softAssert(!(getRogersSearchPage().isGrandParentFilterExpanded(csvRow[j])),
                            csvRow[j] + " is not Expanded", csvRow[j] + " is Expanded");
                }
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


