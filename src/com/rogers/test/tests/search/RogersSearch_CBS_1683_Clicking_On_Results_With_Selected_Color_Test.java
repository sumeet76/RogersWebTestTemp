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

public class RogersSearch_CBS_1683_Clicking_On_Results_With_Selected_Color_Test extends BaseTestClass {

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
    public void validateResultsWithSelectedColors(String[] csvRow) {
        boolean isMobile;
        List<WebElement> resultLinks;
        String strDeviceName, gpfilter, pfilter;
        String strSelectedColor;
        List<String> strColorFilters;
        List<String> resultColorOptions;
        getDriver().get(System.getProperty("SearchUrl") + "iphone11");
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strColorFilters = getRogersSearchPage().getColorFilters();
        for (int i = 0; i < strColorFilters.size(); i++) {
            getRogersSearchPage().clkColorType(strColorFilters.get(i));
            reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");
        }
        if (isMobile) {
            getRogersSearchPage().clkShowResultBtnMobile();
            reporter.reportLogWithScreenshot("Clicked on Show Results button");
        }
        resultLinks = getRogersSearchPage().getAllResultLinks();
        for (int k = 0; k < resultLinks.size(); k++) {
            String linkDetails = resultLinks.get(k).getText();
            resultColorOptions = getRogersSearchPage().getResultColorOptions(resultLinks.get(k));
            for (int j = 0; j < resultColorOptions.size(); j++) {
                getRogersSearchPage().clkResultColor(resultLinks.get(k), resultColorOptions.get(j));
                reporter.reportLogWithScreenshot(resultColorOptions.get(j) + " color selected for Result link-" + (k + 1));
                getRogersSearchPage().clkResultLink(resultLinks.get(k));
                reporter.reportLogWithScreenshot((j+1) + " color of " + (k + 1) + ": Result link is clicked");
                strDeviceName = getRogersDeviceConfigPage().getDeviceName();
                if (strDeviceName != null && !strDeviceName.equals("Phones")) {
                    reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
                    strSelectedColor = getRogersSearchPage().getSelectedColor();
                    reporter.softAssert(strSelectedColor.equals(resultColorOptions.get(j)),
                            "Color: Expected=" + resultColorOptions.get(j) + "; Actual=" + strSelectedColor,
                            "Color: Expected=" + resultColorOptions.get(j) + "; Actual=" + strSelectedColor);
                    getRogersDeviceConfigPage().navigateBack();
                    getRogersSearchPage().isPageLoaded();
                    getRogersSearchPage().waitForResultPage();
                } else {
                    reporter.reportLogFailWithScreenshot("Failed to land on Device Config page for following device: " + linkDetails + " & following color: " + resultColorOptions.get(j));
                    getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
                    if (isMobile) {
                        getRogersSearchPage().clkFilterIconMobile();
                        reporter.reportLogWithScreenshot("Clicked on Filter Icon");
                    }
                    getRogersSearchPage().clkShopFilter();
                    reporter.reportLogWithScreenshot("Shop Filter clicked");
                    getRogersSearchPage().clkWirelessFilter();
                    reporter.reportLogWithScreenshot("Wireless Filter clicked");
                    strColorFilters = getRogersSearchPage().getColorFilters();
                    for (int i = 0; i < strColorFilters.size(); i++) {
                        getRogersSearchPage().clkColorType(strColorFilters.get(i));
                    }
                    if (isMobile) {
                        getRogersSearchPage().clkShowResultBtnMobile();
                        reporter.reportLogWithScreenshot("Clicked on Show Results button");
                    }
                }
                getRogersSearchPage().isPageLoaded();
                getRogersSearchPage().waitForResultPage();
                resultLinks = getRogersSearchPage().getAllResultLinks();
                resultColorOptions = getRogersSearchPage().getResultColorOptions(resultLinks.get(k));
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