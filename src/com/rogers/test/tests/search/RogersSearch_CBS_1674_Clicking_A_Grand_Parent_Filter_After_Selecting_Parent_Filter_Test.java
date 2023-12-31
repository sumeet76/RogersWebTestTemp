package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1674_Clicking_A_Grand_Parent_Filter_After_Selecting_Parent_Filter_Test extends BaseTestClass {
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
    public void validateNavigationFromParentToGrandParent(String[] csvRow) {
        boolean isMobile;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        String strResultWindowText;
        List<WebElement> lstParentFilters;
        String strParentFilterName;
        strResultWindowText = getRogersSearchPage().getResultWindowText();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        String[] strFilters = Arrays.copyOfRange(csvRow, 1, csvRow.length);
        for (int i = 0; i < strFilters.length; i++) {
            getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(strFilters[i] + " is clicked");
            lstParentFilters = getRogersSearchPage().getParentFilters(strFilters[i]);
            for (int j = 0; j < lstParentFilters.size(); j++) {
                getRogersSearchPage().clkParentFilter(lstParentFilters.get(j));
                getRogersSearchPage().isPageLoaded();
                strParentFilterName = lstParentFilters.get(j).getText();
                reporter.reportLogWithScreenshot(strParentFilterName + " is selected");
                if (isMobile)
                    getRogersSearchPage().clkShowResultBtnMobile();
                reporter.hardAssert(getRogersSearchPage().validateResultsTag(strFilters[i], strParentFilterName),
                        "Results tags verified", "Results tags mismatch");
                if (isMobile)
                    getRogersSearchPage().clkFilterIconMobile();
                getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
                getRogersSearchPage().isPageLoaded();
                reporter.reportLogWithScreenshot(strFilters[i] + " is clicked");
                if (isMobile)
                    getRogersSearchPage().clkShowResultBtnMobile();
                reporter.hardAssert(strResultWindowText.equals(getRogersSearchPage().getResultWindowText()),
                        "Successfully navigated to GrandParent from Parent filter", "Navigation from Parent to GrandParent filter failed");
                if (isMobile)
                    getRogersSearchPage().clkFilterIconMobile();
                getRogersSearchPage().clkGrandParentFilter(strFilters[i]);
            }
        }
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