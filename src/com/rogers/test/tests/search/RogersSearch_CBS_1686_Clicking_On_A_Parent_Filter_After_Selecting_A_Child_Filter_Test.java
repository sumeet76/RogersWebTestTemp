package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import utils.CSVReader;

public class RogersSearch_CBS_1686_Clicking_On_A_Parent_Filter_After_Selecting_A_Child_Filter_Test extends BaseTestClass {

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
    public void validateChildAndParentFilterSelection(String[] csvRow) {
        boolean isMobile;
        List<WebElement> lstParentFilters;
        List<String> strColorFilters;
        String strParentFilterName;
        int intCounter = 0;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        String gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        String pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(gpfilter);
        strColorFilters = getRogersSearchPage().getColorFilters();
        for (int i = 0; i < strColorFilters.size(); i++) {
            getRogersSearchPage().clkColorType(strColorFilters.get(i));
            reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");
            if (isMobile) {
                getRogersSearchPage().clkShowResultBtnMobile();
                reporter.reportLogWithScreenshot("Clicked on Show Results button");
            }
            reporter.softAssert(getRogersSearchPage().validateResultsTag(gpfilter, pfilter),
                    "Results belong to tag " + gpfilter + "-" + pfilter,
                    "Results do not belong to tag " + gpfilter + "-" + pfilter);
            reporter.softAssert(getRogersSearchPage().validateResultsColor(strColorFilters.get(i)),
                    "All Results belong to color: " + strColorFilters.get(i),
                    "All Results do Not belong to color: " + strColorFilters.get(i));
            if (lstParentFilters.size() == 1)
                break;
            else {
                strParentFilterName = lstParentFilters.get(0).getText();
                if (isMobile) {
                    getRogersSearchPage().clkFilterIconMobile();
                    reporter.reportLogWithScreenshot("Clicked on Filter Icon");
                }
                getRogersSearchPage().clkParentFilter(lstParentFilters.get(0));
                reporter.reportLogWithScreenshot("Parent filter " + lstParentFilters.get(intCounter).getText() + " is clicked");
                if (isMobile) {
                    getRogersSearchPage().clkShowResultBtnMobile();
                    reporter.reportLogWithScreenshot("Clicked on Show Results button");
                }
                reporter.softAssert(getRogersSearchPage().validateResultsTag(gpfilter, strParentFilterName),
                        "Results belong to tag " + gpfilter + "-" + strParentFilterName + "'. Navigation Passed",
                        "Results do not belong to tag " + gpfilter + "-" + strParentFilterName + "'. Navigation Failed");
                if (isMobile) {
                    getRogersSearchPage().clkFilterIconMobile();
                    reporter.reportLogWithScreenshot("Clicked on Filter Icon");
                }
                getRogersSearchPage().clkParentFilter(gpfilter, pfilter);
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