package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import utils.CSVReader;

/**
 * This class will validate results have tags out of the filters displayed on the landing page
 *
 * @author pankaj.patil
 **/
public class RogersSearch_CBS_1643_Relevant_Results_Rendering_Test extends BaseTestClass {

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

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Multilingual", "Sanity", "Mobile"})
    public void validateResults(String[] csvRowStrArray) {
        getDriver().get(System.getProperty("SearchUrl") + csvRowStrArray[0]);
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Launching URL");
        String[] strFilters = Arrays.copyOfRange(csvRowStrArray, 1, csvRowStrArray.length);
        reporter.softAssert(getRogersSearchPage().verifyResultsCategoryTagRelevancy(strFilters),
                "Relevant Results tags Displayed are displayed on the landing page for the search filters", "Relevant Results tags are not displayed on the landing page for the search filters");
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
