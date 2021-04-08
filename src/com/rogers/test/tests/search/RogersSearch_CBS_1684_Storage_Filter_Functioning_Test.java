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

    @Test(groups = {"Search", "Filter", "Multilingual"})
    public void validateStorageFilterSelection() {
        getDriver().get(System.getProperty("SearchUrl") + "iphone");
        getRogersSearchPage().isPageLoaded();
        List<WebElement> resultLinks;
        String strDeviceName;
        String strSelectedStorage;
        List<String> strStorageFilters;
        getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot("Shop Filter clicked");
        getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot("Wireless Filter clicked");
        strStorageFilters = getRogersSearchPage().getStorageSelections();
        for (int i = 0; i < strStorageFilters.size(); i++) {
            getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
            reporter.reportLogWithScreenshot(strStorageFilters.get(i) + " - Selected");
            resultLinks = getRogersSearchPage().getAllResultLinks();
            for (int k = 0; k < resultLinks.size(); k++) {
                getRogersSearchPage().clkResultLink(resultLinks.get(k));
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
                    getDriver().get(System.getProperty("SearchUrl") + "iphone");
                    getRogersSearchPage().clkShopFilter();
                    getRogersSearchPage().clkWirelessFilter();
                    getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
                }
                resultLinks = getRogersSearchPage().getAllResultLinks();
            }
            getRogersSearchPage().isPageLoaded();
            getRogersSearchPage().waitForResultPage();
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