package com.rogers.test.tests.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import utils.CSVReader;

/**
 * This test case will select all colors one by one and validate whether the results
 * have same color highlighted as selected from the filter
 *
 * @author pankaj.patil
 */
public class RogersSearch_CBS_1681_Color_Facet_Testing_Test extends BaseTestClass {

    @Test(groups = {"Search", "Filter"})
    public void validateColorFilterSelection() {
        List<String> strColorFilters;
        getDriver().get(System.getProperty("SearchUrl") + "wireless");
        getRogersSearchPage().isPageLoaded();
        getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot("Shop Filter clicked");
        getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot("Wireless Filter clicked");
        strColorFilters = getRogersSearchPage().getColorFilters();
        for (int i = 0; i < strColorFilters.size(); i++) {
            getRogersSearchPage().clkColorType(strColorFilters.get(i));
            getRogersSearchPage().isPageLoaded();
            reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");
            reporter.softAssert(getRogersSearchPage().validateResultsColor(strColorFilters.get(i)),
                    "All Results belong to color: " + strColorFilters.get(i),
                    "All Results do Not belong to color: " + strColorFilters.get(i));
            reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Result Screenshot");
            getRogersSearchPage().clkColorType(strColorFilters.get(i));
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