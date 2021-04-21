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

public class RogersSearch_CBS_1684_Storage_Filter_Functioning_Test extends BaseTestClass {
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
    public void validateStorageFilterSelection(String[] csvRow) {
        boolean isMobile;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        List<WebElement> resultLinks;
        String strDeviceName, gpfilter, pfilter;
        String strSelectedStorage;
        List<String> strStorageFilters;
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strStorageFilters = getRogersSearchPage().getStorageSelections();
        for (int i = 0; i < strStorageFilters.size(); i++) {
            getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
            reporter.reportLogWithScreenshot(strStorageFilters.get(i) + " - Selected");
            if (isMobile) {
                getRogersSearchPage().clkShowResultBtnMobile();
                reporter.reportLogWithScreenshot("Clicked on Show Results button");
            }
            resultLinks = getRogersSearchPage().getAllResultLinks();
            for (int k = 0; k < resultLinks.size(); k++) {
                getRogersSearchPage().clkResultLink(resultLinks.get(k));
                reporter.reportLogWithScreenshot((k + 1) + ": Result link is clicked");
                strDeviceName = getRogersDeviceConfigPage().getDeviceName();
                if (strDeviceName != null && !strDeviceName.equals("Phones")) {
                    reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
                    strSelectedStorage = getRogersSearchPage().getSelectedStorage();
                    reporter.softAssert(strSelectedStorage.equalsIgnoreCase(strStorageFilters.get(i)),
                            "Storage: Expected=" + strStorageFilters.get(i) + "; Actual=" + strSelectedStorage,
                            "Storage: Expected=" + strStorageFilters.get(i) + "; Actual=" + strSelectedStorage);
                    getRogersDeviceConfigPage().navigateBack();
                    getRogersSearchPage().isPageLoaded();
                    getRogersSearchPage().waitForResultPage();
                } else {
                    reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");
                    getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
                    if (isMobile) {
                        getRogersSearchPage().clkFilterIconMobile();
                        reporter.reportLogWithScreenshot("Clicked on Filter Icon");
                    }
                    getRogersSearchPage().clkShopFilter();
                    getRogersSearchPage().clkWirelessFilter();
                    getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
                    if (isMobile) {
                        getRogersSearchPage().clkShowResultBtnMobile();
                        reporter.reportLogWithScreenshot("Clicked on Show Results button");
                    }
                }
                resultLinks = getRogersSearchPage().getAllResultLinks();
            }
            getRogersSearchPage().isPageLoaded();
            getRogersSearchPage().waitForResultPage();
            if (isMobile) {
                getRogersSearchPage().clkFilterIconMobile();
                reporter.reportLogWithScreenshot("Clicked on Filter Icon");
            }
            getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("fr") String strLanguage, ITestContext testContext, Method method) throws IOException {
        xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("SearchUrl"), strBrowser, strLanguage, RogersEnums.GroupName.search, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}